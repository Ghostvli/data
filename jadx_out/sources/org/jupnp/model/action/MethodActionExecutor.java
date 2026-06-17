package org.jupnp.model.action;

import defpackage.j02;
import defpackage.n02;
import java.lang.reflect.Method;
import java.util.Map;
import org.jupnp.model.meta.ActionArgument;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.state.StateVariableAccessor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MethodActionExecutor extends AbstractActionExecutor {
    private final j02 logger;
    protected Method method;

    public MethodActionExecutor(Method method) {
        this.logger = n02.k(MethodActionExecutor.class);
        this.method = method;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object[] createInputArgumentValues(org.jupnp.model.action.ActionInvocation<org.jupnp.model.meta.LocalService> r13, java.lang.reflect.Method r14) throws org.jupnp.model.action.ActionException {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jupnp.model.action.MethodActionExecutor.createInputArgumentValues(org.jupnp.model.action.ActionInvocation, java.lang.reflect.Method):java.lang.Object[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9  */
    @Override // org.jupnp.model.action.AbstractActionExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void execute(org.jupnp.model.action.ActionInvocation<org.jupnp.model.meta.LocalService> r6, java.lang.Object r7) throws java.lang.Exception {
        /*
            r5 = this;
            java.lang.reflect.Method r0 = r5.method
            java.lang.Object[] r0 = r5.createInputArgumentValues(r6, r0)
            org.jupnp.model.meta.Action r1 = r6.getAction()
            boolean r1 = r1.hasOutputArguments()
            if (r1 != 0) goto L1f
            j02 r6 = r5.logger
            java.lang.String r1 = "Calling local service method with no output arguments: {}"
            java.lang.reflect.Method r2 = r5.method
            r6.h(r1, r2)
            java.lang.reflect.Method r5 = r5.method
            org.jupnp.util.Reflections.invoke(r5, r7, r0)
            return
        L1f:
            java.lang.reflect.Method r1 = r5.method
            java.lang.Class r1 = r1.getReturnType()
            java.lang.Class r2 = java.lang.Void.TYPE
            boolean r1 = r1.equals(r2)
            j02 r2 = r5.logger
            java.lang.String r3 = "Calling local service method with output arguments: {}"
            java.lang.reflect.Method r4 = r5.method
            r2.h(r3, r4)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L4e
            j02 r1 = r5.logger
            java.lang.String r4 = "Action method is void, calling declared accessors(s) on service instance to retrieve output argument(s)"
            r1.y(r4)
            java.lang.reflect.Method r1 = r5.method
            org.jupnp.util.Reflections.invoke(r1, r7, r0)
            org.jupnp.model.meta.Action r0 = r6.getAction()
            java.lang.Object r7 = r5.readOutputArgumentValues(r0, r7)
        L4c:
            r0 = r3
            goto L76
        L4e:
            boolean r1 = r5.isUseOutputArgumentAccessors(r6)
            j02 r4 = r5.logger
            if (r1 == 0) goto L6a
            java.lang.String r1 = "Action method is not void, calling declared accessor(s) on returned instance to retrieve output argument(s)"
            r4.y(r1)
            java.lang.reflect.Method r1 = r5.method
            java.lang.Object r7 = org.jupnp.util.Reflections.invoke(r1, r7, r0)
            org.jupnp.model.meta.Action r0 = r6.getAction()
            java.lang.Object r7 = r5.readOutputArgumentValues(r0, r7)
            goto L4c
        L6a:
            java.lang.String r1 = "Action method is not void, using returned value as (single) output argument"
            r4.y(r1)
            java.lang.reflect.Method r1 = r5.method
            java.lang.Object r7 = org.jupnp.util.Reflections.invoke(r1, r7, r0)
            r0 = r2
        L76:
            org.jupnp.model.meta.Action r1 = r6.getAction()
            org.jupnp.model.meta.ActionArgument[] r1 = r1.getOutputArguments()
            if (r0 == 0) goto La0
            boolean r0 = r7 instanceof java.lang.Object[]
            if (r0 == 0) goto La0
            java.lang.Object[] r7 = (java.lang.Object[]) r7
            j02 r0 = r5.logger
            int r3 = r7.length
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "Accessors returned Object[], setting output argument values: {}"
            r0.h(r4, r3)
        L92:
            int r0 = r1.length
            if (r2 >= r0) goto L9f
            r0 = r1[r2]
            r3 = r7[r2]
            r5.setOutputArgumentValue(r6, r0, r3)
            int r2 = r2 + 1
            goto L92
        L9f:
            return
        La0:
            int r0 = r1.length
            if (r0 != r3) goto La9
            r0 = r1[r2]
            r5.setOutputArgumentValue(r6, r0, r7)
            return
        La9:
            org.jupnp.model.action.ActionException r5 = new org.jupnp.model.action.ActionException
            org.jupnp.model.types.ErrorCode r6 = org.jupnp.model.types.ErrorCode.ACTION_FAILED
            int r7 = r1.length
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Method return does not match required number of output arguments: "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r5.<init>(r6, r7)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jupnp.model.action.MethodActionExecutor.execute(org.jupnp.model.action.ActionInvocation, java.lang.Object):void");
    }

    public Method getMethod() {
        return this.method;
    }

    public boolean isUseOutputArgumentAccessors(ActionInvocation<LocalService> actionInvocation) {
        for (ActionArgument actionArgument : actionInvocation.getAction().getOutputArguments()) {
            if (getOutputArgumentAccessors().get(actionArgument) != null) {
                return true;
            }
        }
        return false;
    }

    public MethodActionExecutor(Map<ActionArgument<LocalService>, StateVariableAccessor> map, Method method) {
        super(map);
        this.logger = n02.k(MethodActionExecutor.class);
        this.method = method;
    }
}
