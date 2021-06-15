package org.wildfly.test;

/**
 * WildFly execution model type
 */
public enum WildFlyExecutionModelType {
    /**
     * Traditional execution model is about running the application server as the main executable
     */
    Traditional,
    /**
     * Bootable JAR execution model is about haveing a runnable JAR that will start an inner WildFly instance
     */
    Bootable
}
