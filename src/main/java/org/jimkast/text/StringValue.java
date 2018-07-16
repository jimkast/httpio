package org.jimkast.text;

public final class StringValue extends TextEnvelope {
    public StringValue(Object  o) {
        super(o::toString);
    }
}
