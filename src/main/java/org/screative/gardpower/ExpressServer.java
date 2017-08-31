package org.screative.gardpower;

/**
 * Created by sureya on 24/1/15.
 */

import org.restexpress.RestExpress;
import org.restexpress.pipeline.SimpleConsoleLogMessageObserver;

import java.io.IOException;

/**
 * Created by sureya on 31/10/14.
 */
public class ExpressServer {

    public static RestExpress initializeServer(String SERVICE_NAME,int SERVER_PORT,int DEFAULT_EXECUTOR_THREAD_POOL_SIZE) throws IOException {
        RestExpress server = new RestExpress()
                .setName(SERVICE_NAME)
                .setBaseUrl("http://localhost:" + SERVER_PORT)
                .setExecutorThreadCount(DEFAULT_EXECUTOR_THREAD_POOL_SIZE)
                .addMessageObserver(new SimpleConsoleLogMessageObserver());
//        BaseRoute.define(server);
//        RetargetingRoutes.define(server);
//        CampaignRoutes.define(server);
        Route.define(server);
        server.bind(SERVER_PORT);
        return server;
    }
}