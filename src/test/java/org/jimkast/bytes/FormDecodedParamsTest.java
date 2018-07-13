package org.jimkast.bytes;

import java.util.Map;
import org.jimkast.text.TextInputOf;
import org.jimkast.text.stream.FormDecodedParams;
import org.junit.Test;

public class FormDecodedParamsTest {

    @Test
    public void iterator() {
        for (Map.Entry<String, String> entry : new FormDecodedParams(new TextInputOf("d%405+xfgdxfg=3456tdfxhfc&dfgd&23edrgdfg=346rd"))) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}