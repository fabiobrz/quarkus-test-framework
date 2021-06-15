package org.wildfly.test.services;

import io.quarkus.test.bootstrap.ServiceContext;

public interface WildFlyApplicationManagedResourceBinding<R extends WildFlyManagedResource, B extends WildFlyApplicationManagedResourceBuilder> {

    boolean appliesFor(ServiceContext context);

    R init(B builder);
}
