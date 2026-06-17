package net.engio.mbassy.listener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.engio.mbassy.dispatch.HandlerInvocation;
import net.engio.mbassy.dispatch.ReflectiveHandlerInvocation;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@Inherited
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Handler {
    String condition() default "";

    Invoke delivery() default Invoke.Synchronously;

    boolean enabled() default true;

    Filter[] filters() default {};

    Class<? extends HandlerInvocation> invocation() default ReflectiveHandlerInvocation.class;

    int priority() default 0;

    boolean rejectSubtypes() default false;
}
