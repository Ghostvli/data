package org.simpleframework.xml;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface ElementList {
    boolean data() default false;

    boolean empty() default true;

    String entry() default "";

    boolean inline() default false;

    String name() default "";

    boolean required() default true;

    Class type() default void.class;
}
