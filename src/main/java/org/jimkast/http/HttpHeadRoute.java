package org.jimkast.http;

import java.util.function.Predicate;

public interface HttpHeadRoute extends Predicate<HttpHead> {
    @Override
    boolean test(HttpHead httpHead);
}
