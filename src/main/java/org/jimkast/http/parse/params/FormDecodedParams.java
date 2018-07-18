package org.jimkast.http.parse.params;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Map;
import org.cactoos.Input;
import org.cactoos.iterable.Mapped;
import org.cactoos.scalar.StickyScalar;
import org.cactoos.scalar.UncheckedScalar;
import org.jimkast.iterable.IterableEnvelope;
import org.jimkast.text.TextInput;
import org.jimkast.text.stream.SplitText;
import org.jimkast.text.stream.TextInputOf;

public final class FormDecodedParams extends IterableEnvelope<Map.Entry<String, String>> {
    public FormDecodedParams(CharSequence text) {
        this(new TextInputOf(text));
    }

    public FormDecodedParams(String charset, CharSequence text) {
        this(charset, new TextInputOf(text));
    }

    public FormDecodedParams(Input in) {
        this(new TextInputOf(in));
    }

    public FormDecodedParams(Charset charset, Input in) {
        this(new TextInputOf(charset, in));
    }

    public FormDecodedParams(TextInput in) {
        this("UTF-8", in);
    }

    public FormDecodedParams(String charset, TextInput in) {
        super(new Mapped<>(
            input -> {
                UncheckedScalar<String[]> pair = new UncheckedScalar<>(new StickyScalar<>(() -> input.split("=", 2)));
                return new Map.Entry<String, String>() {
                    @Override
                    public String getKey() {
                        try {
                            return URLDecoder.decode(pair.value()[0], charset);
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public String getValue() {
                        String[] pairs = pair.value();
                        try {
                            return (pairs.length == 1) ? "" : URLDecoder.decode(pairs[1], charset);
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public String setValue(String value) {
                        throw new UnsupportedOperationException("#setValue");
                    }
                };
            },
            new SplitText("&", in)
        ));
    }
}
