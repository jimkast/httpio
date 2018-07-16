package org.jimkast.xml;

import java.io.StringReader;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import org.cactoos.iterable.Mapped;
import org.jimkast.date.IsoDateString;
import org.jimkast.map.MappedMap;
import org.jimkast.xml.saxon.XdmEnvelope;
import org.jimkast.xml.saxon.XdmSaxon;
import org.jimkast.xml.saxon.XqSaxon;

public final class XdmOfMap extends XdmEnvelope {
    private static final XQuery XQ = new XqSaxon(new StringReader(
        "declare namespace map = 'http://www.w3.org/2005/xpath-functions/map';\n" +
            "\n" +
            "declare variable $docs external;\n" +
            "declare function local:json-value($val) {\n" +
            "    if ($val instance of map(*)) then for $k in map:keys($val) return local:json-value($k, $val($k))\n" +
            "    else for $v in $val return local:json-value(\"item\", $v)\n" +
            "};\n" +
            "\n" +
            "declare function local:json-value($key, $val) {\n" +
            "    if (count($val) = 0) then ()\n" +
            "    else if (count($val) > 1) then for $v in $val return local:json-value($key, $v)\n" +
            "    else if ($val instance of map(*)) then\n" +
            "            element {$key} {\n" +
            "                let $id := $val('_id')\n" +
            "                return if($id != '') then attribute {'id'} {$id} else (),\n" +
            "                for $k in map:keys($val)[. != '_id' and . != '_class'] return local:json-value($k, $val($k))\n" +
            "            }\n" +
            "        else element {$key} {$val}\n" +
            "};\n" +
            "\n" +
            "local:json-value($docs)")
    );

    @SafeVarargs
    public XdmOfMap(Map<String, ?>... docs) {
        this(Arrays.asList(docs));
    }

    public XdmOfMap(Iterable<? extends Map<String, ?>> docs) {
        this(XQ, docs);
    }

    public XdmOfMap(XQuery xq, Iterable<? extends Map<String, ?>> docs) {
        super(() -> xq.with("docs", new XdmSaxon(new Fn().apply(docs))).evaluate(Xdm.EMPTY.source()));
    }


    public static class Fn implements Function<Object, Object> {
        @Override
        public Object apply(Object o) {
            if (o == null) return "";
            if (o instanceof Iterable) return apply((Iterable) o);
            if (o instanceof Map) return apply((Map) o);
            if (o instanceof Date) return apply((Date) o);
            return o;
        }

        public Map apply(Map o) {
            return new MappedMap(o, this::apply);
        }

        public Iterable<Object> apply(Iterable<?> o) {
            return new Mapped<>(this::apply, o);
        }

        public String apply(Date o) {
            return new IsoDateString(o).toString();
        }
    }
}
