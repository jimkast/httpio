package org.jimkast.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.cactoos.Scalar;

public final class LocalDateParsed implements Scalar<LocalDate> {
    private final CharSequence text;
    private final Scalar<DateTimeFormatter> format;

    public LocalDateParsed(CharSequence text) {
        this(text, DateTimeFormatter.ISO_DATE);
    }

    public LocalDateParsed(CharSequence text, CharSequence pattern) {
        this(text, () -> DateTimeFormatter.ofPattern(pattern.toString()));
    }


    public LocalDateParsed(CharSequence text, DateTimeFormatter format) {
        this(text, () -> format);
    }

    public LocalDateParsed(CharSequence text, Scalar<DateTimeFormatter> format) {
        this.text = text;
        this.format = format;
    }

    @Override
    public LocalDate value() throws Exception {
        return LocalDate.parse(text.toString(), format.value());
    }
}
