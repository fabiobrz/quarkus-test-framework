package org.wildfly.test.services;

import java.lang.reflect.Field;

import io.quarkus.test.bootstrap.AnnotationBinding;
import io.quarkus.test.bootstrap.ManagedResourceBuilder;
import io.quarkus.test.services.WildFlyApplication;

public class WildFlyApplicationAnnotationBinding implements AnnotationBinding {

    @Override
    public boolean isFor(Field field) {
        return field.isAnnotationPresent(WildFlyApplication.class);
    }

    @Override
    public ManagedResourceBuilder createBuilder(Field field) throws Exception {
        WildFlyApplication metadata = field.getAnnotation(WildFlyApplication.class);

        ManagedResourceBuilder builder = metadata.builder().getDeclaredConstructor().newInstance();
        builder.init(metadata);
        return builder;
    }

}
