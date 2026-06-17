package org.jupnp.binding.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UpnpStateVariable {
    long allowedValueMaximum() default 0;

    long allowedValueMinimum() default 0;

    Class allowedValueProvider() default void.class;

    Class allowedValueRangeProvider() default void.class;

    long allowedValueStep() default 1;

    String[] allowedValues() default {};

    Class allowedValuesEnum() default void.class;

    String datatype() default "";

    String defaultValue() default "";

    int eventMaximumRateMilliseconds() default 0;

    int eventMinimumDelta() default 0;

    String name() default "";

    boolean sendEvents() default true;
}
