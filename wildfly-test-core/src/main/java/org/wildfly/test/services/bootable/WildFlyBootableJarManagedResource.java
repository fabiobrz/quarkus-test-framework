package org.wildfly.test.services.bootable;

import java.util.Collections;
import java.util.List;

import org.wildfly.test.services.WildFlyManagedResource;

import io.quarkus.test.bootstrap.Protocol;
import io.quarkus.test.logging.LoggingHandler;

/**
 * Class that implements the logic to which the deployment of a WildFly application is delegated.
 */
public class WildFlyBootableJarManagedResource extends WildFlyManagedResource {

    protected LoggingHandler getLoggingHandler() {
        return null; //  @@@ todo - TBD
    }

    @Override
    public List<String> logs() {

        // todo - TBD
        return Collections.emptyList();
    }

    @Override
    public int getPort(Protocol protocol) {
        // todo - TBD
        return -1;
    }

    @Override
    public String getHost(Protocol protocol) {
        return "http://localhost";
    }

    @Override
    public void start() {
        // todo - TBD
    }

    @Override
    public void stop() {
        // todo - TBD
    }

    @Override
    public void restart() {
        stop();
        start();
    }
}
