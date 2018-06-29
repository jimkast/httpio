package org.jimkast.http;

public final class HeaderParts implements Header {
    private final String name;
    private final String value;

    public HeaderParts(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return name + ": " + value;
    }
}
