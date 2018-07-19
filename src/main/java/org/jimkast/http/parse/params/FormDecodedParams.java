package org.jimkast.http.parse.params;

import java.nio.charset.Charset;
import org.cactoos.Input;
import org.cactoos.iterable.Mapped;
import org.jimkast.iterable.IterableEnvelope;
import org.jimkast.map.Prop;
import org.jimkast.text.TextInput;
import org.jimkast.text.stream.SplitText;
import org.jimkast.text.stream.TextInputOf;

public final class FormDecodedParams extends IterableEnvelope<Prop> {
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
        super(
            new Mapped<>(
                p -> new FormParam(p, charset),
                new SplitText("&", in)
            )
        );
    }
}
