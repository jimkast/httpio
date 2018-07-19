package org.jimkast.classpath;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.HashMap;
import java.util.Map;
import org.jimkast.map.FluentMap;

public final class UrlHandlerFactory implements URLStreamHandlerFactory {
    private final Map<String, URLStreamHandler> protocolHandlers;

    public UrlHandlerFactory() {
        this(new HashMap<>());
    }

    public UrlHandlerFactory(String protocol, URLStreamHandler handler) {
        this(new FluentMap<>(protocol, handler));
    }

    public UrlHandlerFactory(Map<String, URLStreamHandler> protocolHandlers) {
        this.protocolHandlers = protocolHandlers;
    }

    public UrlHandlerFactory addHandler(String protocol, URLStreamHandler urlHandler) {
        protocolHandlers.put(protocol, urlHandler);
        return this;
    }

    public URLStreamHandler createURLStreamHandler(String protocol) {
        return protocolHandlers.get(protocol);
    }
}
