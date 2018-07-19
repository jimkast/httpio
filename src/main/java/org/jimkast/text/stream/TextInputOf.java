package org.jimkast.text.stream;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.cactoos.Input;
import org.jimkast.io.InputIoChecked;
import org.jimkast.text.TextInput;

public final class TextInputOf extends TextInput.Envelope {
    public TextInputOf(Input input) {
        this(StandardCharsets.UTF_8, input);
    }

    public TextInputOf(CharSequence charset, Input input) {
        super(() -> new InputStreamReader(new InputIoChecked(input).stream(), charset.toString()));
    }

    public TextInputOf(Charset charset, Input input) {
        super(() -> new InputStreamReader(new InputIoChecked(input).stream(), charset));
    }

    public TextInputOf(Reader reader) {
        super(() -> reader);
    }

    public TextInputOf(CharSequence str) {
        super(() -> new StringReader(str.toString()));
    }


}
