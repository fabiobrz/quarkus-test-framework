package org.wildfly.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.wildfly.test.services.bootable.WildFlyBootableJarApplicationManagedResourceBuilder;

import io.quarkus.test.bootstrap.ManagedResourceBuilder;

/**
 * Annotation that identifies a WildFly Application.
 *
 * Currently only Bootable JAR WildFly application is supported when this annotation is used.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WildFlyApplication {

    WildFlyExecutionModelType executionModelType() default WildFlyExecutionModelType.Bootable;

    Class<? extends ManagedResourceBuilder> builder() default WildFlyBootableJarApplicationManagedResourceBuilder.class;
}
