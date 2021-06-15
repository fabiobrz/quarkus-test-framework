package org.wildfly.test.services;

import static org.junit.jupiter.api.Assertions.fail;

import java.lang.annotation.Annotation;
import java.util.ServiceLoader;

import org.wildfly.test.WildFlyApplication;

import io.quarkus.test.bootstrap.ManagedResource;
import io.quarkus.test.bootstrap.ManagedResourceBuilder;
import io.quarkus.test.bootstrap.ServiceContext;

/**
 * Class that encapsulates the logic needed to build WildFly managed resource.
 */
public abstract class WildFlyApplicationManagedResourceBuilder implements ManagedResourceBuilder {
    private ServiceContext context;
    private WildFlyManagedResource managedResource;

    private final ServiceLoader<WildFlyApplicationManagedResourceBinding> managedResourceBindingsRegistry = ServiceLoader
            .load(WildFlyApplicationManagedResourceBinding.class);

    @Override
    public void init(Annotation annotation) {
        WildFlyApplication metadata = (WildFlyApplication) annotation;
        //        setSslEnabled(metadata.ssl());
    }

    @Override
    public ManagedResource build(ServiceContext context) {
        setContext(context);
        //configureLogging();
        managedResource = findManagedResource();
        build();

        managedResource.validate();

        return managedResource;
    }

    public abstract void build();

    private WildFlyManagedResource findManagedResource() {
        for (WildFlyApplicationManagedResourceBinding binding : managedResourceBindingsRegistry) {
            if (binding.appliesFor(getContext())) {
                return binding.init(this);
            }
        }

        fail("No resources found for " + getClass().getSimpleName());
        return null;
    }

    protected ServiceContext getContext() {
        return context;
    }

    protected void setContext(ServiceContext context) {
        this.context = context;
    }

}
