package org.screative.gardpower;

/**
 * Created by sureya on 24/1/15.
 */
import org.jboss.netty.handler.codec.http.HttpMethod;
import org.restexpress.RestExpress;

public class Route {




    public static void define(RestExpress server){
        //server.uri("/test", new BaseController()).action("testing", HttpMethod.GET).noSerialization();
        server.uri("/insert/values/{credentials}", new BaseController()).action("testing", HttpMethod.GET).noSerialization();
        server.uri("/insert/values/post", new BaseController()).action("postReq", HttpMethod.POST).noSerialization();

    }
}
