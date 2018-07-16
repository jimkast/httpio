package org.jimkast.text;

import java.util.regex.Pattern;

public final class CleanedInvalidHtml extends TextEnvelope {
    private static final Pattern regex = Pattern.compile("[\u007F-\u009F]");

    public CleanedInvalidHtml(CharSequence str) {
        super(() -> regex.matcher(str.toString()).replaceAll(""));
    }
}
