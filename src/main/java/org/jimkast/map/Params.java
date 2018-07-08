package org.jimkast.map;

public interface Params {
    Iterable<String> names();

    Iterable<String> param(CharSequence name);
}
