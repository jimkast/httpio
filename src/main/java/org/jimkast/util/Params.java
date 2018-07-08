package org.jimkast.util;

public interface Params {
    Iterable<String> names();

    Iterable<String> param(CharSequence name);
}
