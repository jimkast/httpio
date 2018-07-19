package org.jimkast.http.parse.params;

import java.net.URI;
import org.junit.Test;

public class FormDecodedParamsTest {

    @Test
    public void aaa() throws Exception {
        URI uri = new URI("https://john.doe@www.example.com:123/forum/quest%20ions/?tag=networking&order=newest#top");
        System.out.println("\nScheme: ");
        System.out.println(uri.getScheme());
        System.out.println("\nAuthority: ");
        System.out.println(uri.getAuthority());
        System.out.println("\nUserInfo: ");
        System.out.println(uri.getUserInfo());
        System.out.println("\nHost: ");
        System.out.println(uri.getHost());
        System.out.println("\nPort: ");
        System.out.println(uri.getPort());
        System.out.println("\nPath: ");
        System.out.println(uri.getPath());
        System.out.println("\nQuery: ");
        System.out.println(uri.getQuery());
        System.out.println("\nFragment: ");
        System.out.println(uri.getFragment());
    }

}