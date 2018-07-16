package org.jimkast.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.cactoos.Scalar;
import org.jimkast.text.TextEnvelope;

public final class LocalDateFormatted extends TextEnvelope {
    public LocalDateFormatted(LocalDate date) {
        this(() -> date);
    }

    public LocalDateFormatted(LocalDate date, CharSequence pattern) {
        this(date, () -> DateTimeFormatter.ofPattern(pattern.toString()));
    }

    public LocalDateFormatted(LocalDate date, DateTimeFormatter format) {
        this(date, () -> format);
    }

    public LocalDateFormatted(LocalDate date, Scalar<DateTimeFormatter> format) {
        this(() -> date, format);
    }

    public LocalDateFormatted(Scalar<LocalDate> date) {
        this(date, DateTimeFormatter.ISO_DATE);
    }

    public LocalDateFormatted(Scalar<LocalDate> date, CharSequence pattern) {
        this(date, () -> DateTimeFormatter.ofPattern(pattern.toString()));
    }

    public LocalDateFormatted(Scalar<LocalDate> date, DateTimeFormatter format) {
        this(date, () -> format);
    }

    public LocalDateFormatted(Scalar<LocalDate> date, Scalar<DateTimeFormatter> format) {
        super(() -> date.value().format(format.value()));
    }
}
