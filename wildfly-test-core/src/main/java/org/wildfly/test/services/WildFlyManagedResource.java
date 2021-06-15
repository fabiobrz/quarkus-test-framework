package org.wildfly.test.services;

import static org.junit.jupiter.api.Assertions.fail;

import io.quarkus.test.bootstrap.ManagedResource;
import io.quarkus.test.logging.LoggingHandler;

/**
 * Class that implements the logic to which the deployment of a WildFly application is delegated.
 */
public abstract class WildFlyManagedResource implements ManagedResource {

    private static final String EXPECTED_OUTPUT_FROM_SUCCESSFULLY_STARTED = "WFLYSRV0025";
    private static final String UNRECOVERABLE_ERROR = "WFLYSRV0056";

    @Override
    public boolean isRunning() {
        if (getLoggingHandler() == null) {
            return false;
        }

        if (getLoggingHandler().logsContains(UNRECOVERABLE_ERROR)) {
            fail("WildFly managed resource failed to start");
        }

        return getLoggingHandler().logsContains(EXPECTED_OUTPUT_FROM_SUCCESSFULLY_STARTED);
    }

    protected abstract LoggingHandler getLoggingHandler();

    protected boolean needsBuildArtifact() {
        return true;
    }

    protected void validate() {
    }
}
