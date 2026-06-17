package org.mozilla.javascript;

import com.thegrizzlylabs.sardineandroid.DavPrincipal;
import java.util.ArrayList;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.IteratorLikeIterable;
import org.mozilla.javascript.LambdaConstructor;
import org.mozilla.javascript.NativePromise;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.TopLevel;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NativePromise extends ScriptableObject {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private State state = State.PENDING;
    private Object result = null;
    private boolean handled = false;
    private ArrayList<Reaction> fulfillReactions = new ArrayList<>();
    private ArrayList<Reaction> rejectReactions = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Capability {
        Object promise;
        private Object rawReject;
        private Object rawResolve;
        Callable reject;
        Callable resolve;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Capability(Context context, Scriptable scriptable, Object obj) {
            Object obj2 = Undefined.instance;
            this.rawResolve = obj2;
            this.rawReject = obj2;
            if (!(obj instanceof Constructable)) {
                throw ScriptRuntime.typeErrorById("msg.constructor.expected", new Object[0]);
            }
            this.promise = ((Constructable) obj).construct(context, scriptable, new Object[]{new LambdaFunction(scriptable, 2, new Callable() { // from class: org.mozilla.javascript.z0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.mozilla.javascript.Callable
                public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                    return this.f.executor(objArr);
                }
            })});
            Object obj3 = this.rawResolve;
            if (!(obj3 instanceof Callable)) {
                throw ScriptRuntime.typeErrorById("msg.function.expected", new Object[0]);
            }
            this.resolve = (Callable) obj3;
            Object obj4 = this.rawReject;
            if (!(obj4 instanceof Callable)) {
                throw ScriptRuntime.typeErrorById("msg.function.expected", new Object[0]);
            }
            this.reject = (Callable) obj4;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public Object executor(Object[] objArr) {
            if (!Undefined.isUndefined(this.rawResolve) || !Undefined.isUndefined(this.rawReject)) {
                throw ScriptRuntime.typeErrorById("msg.promise.capability.state", new Object[0]);
            }
            if (objArr.length > 0) {
                this.rawResolve = objArr[0];
            }
            if (objArr.length > 1) {
                this.rawReject = objArr[1];
            }
            return Undefined.instance;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class PromiseAllResolver {
        private static final int MAX_PROMISES = 2097152;
        Capability capability;
        boolean failFast;
        IteratorLikeIterable.Itr iterator;
        Scriptable thisObj;
        final ArrayList<Object> values = new ArrayList<>();
        int remainingElements = 1;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public PromiseAllResolver(IteratorLikeIterable.Itr itr, Scriptable scriptable, Capability capability, boolean z) {
            this.iterator = itr;
            this.thisObj = scriptable;
            this.capability = capability;
            this.failFast = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ Object a(PromiseAllResolver promiseAllResolver, PromiseElementResolver promiseElementResolver, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            promiseAllResolver.getClass();
            Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
            if (!promiseAllResolver.failFast) {
                Scriptable scriptableNewObject = context.newObject(scriptable);
                scriptableNewObject.put("status", scriptableNewObject, "fulfilled");
                scriptableNewObject.put(ES6Iterator.VALUE_PROPERTY, scriptableNewObject, obj);
                obj = scriptableNewObject;
            }
            return promiseElementResolver.resolve(context, scriptable, obj, promiseAllResolver);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ Object b(PromiseAllResolver promiseAllResolver, PromiseElementResolver promiseElementResolver, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            promiseAllResolver.getClass();
            Scriptable scriptableNewObject = context.newObject(scriptable);
            scriptableNewObject.put("status", scriptableNewObject, " rejected");
            scriptableNewObject.put("reason", scriptableNewObject, objArr.length > 0 ? objArr[0] : Undefined.instance);
            return promiseElementResolver.resolve(context, scriptable, scriptableNewObject, promiseAllResolver);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void finalResolution(Context context, Scriptable scriptable) {
            this.capability.resolve.call(context, scriptable, Undefined.SCRIPTABLE_UNDEFINED, new Object[]{context.newArray(scriptable, this.values.toArray())});
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x006a */
        /* JADX DEBUG: Multi-variable search result rejected for r8v3, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v2, types: [org.mozilla.javascript.Callable] */
        /* JADX WARN: Type inference failed for: r8v4, types: [org.mozilla.javascript.BaseFunction, org.mozilla.javascript.LambdaFunction] */
        public Object resolve(Context context, Scriptable scriptable) {
            Callable propFunctionAndThis = ScriptRuntime.getPropFunctionAndThis(this.thisObj, "resolve", context, scriptable);
            Scriptable scriptableLastStoredScriptable = ScriptRuntime.lastStoredScriptable(context);
            for (int i = 0; i != MAX_PROMISES; i++) {
                Object obj = Undefined.instance;
                try {
                    boolean zHasNext = this.iterator.hasNext();
                    Object next = zHasNext ? this.iterator.next() : obj;
                    if (!zHasNext) {
                        int i2 = this.remainingElements - 1;
                        this.remainingElements = i2;
                        if (i2 == 0) {
                            finalResolution(context, scriptable);
                        }
                        return this.capability.promise;
                    }
                    this.values.add(obj);
                    Object objCall = propFunctionAndThis.call(context, scriptable, scriptableLastStoredScriptable, new Object[]{next});
                    final PromiseElementResolver promiseElementResolver = new PromiseElementResolver(i);
                    LambdaFunction lambdaFunction = new LambdaFunction(scriptable, 1, new Callable() { // from class: org.mozilla.javascript.a1
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // org.mozilla.javascript.Callable
                        public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                            return NativePromise.PromiseAllResolver.a(this.f, promiseElementResolver, context2, scriptable2, scriptable3, objArr);
                        }
                    });
                    Object lambdaFunction2 = this.capability.reject;
                    if (!this.failFast) {
                        lambdaFunction2 = new LambdaFunction(scriptable, 1, new Callable() { // from class: org.mozilla.javascript.b1
                            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                            @Override // org.mozilla.javascript.Callable
                            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                                return NativePromise.PromiseAllResolver.b(this.f, promiseElementResolver, context2, scriptable2, scriptable3, objArr);
                            }
                        });
                        lambdaFunction2.setStandardPropertyAttributes(3);
                    }
                    this.remainingElements++;
                    ScriptRuntime.getPropFunctionAndThis(objCall, "then", context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), new Object[]{lambdaFunction, lambdaFunction2});
                } catch (Throwable th) {
                    this.iterator.setDone(true);
                    throw th;
                }
            }
            throw ScriptRuntime.rangeErrorById("msg.promise.all.toobig", new Object[0]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class PromiseAnyRejector {
        private static final int MAX_PROMISES = 2097152;
        Capability capability;
        IteratorLikeIterable.Itr iterator;
        Scriptable thisObj;
        final ArrayList<Object> errors = new ArrayList<>();
        int remainingElements = 1;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public PromiseAnyRejector(IteratorLikeIterable.Itr itr, Scriptable scriptable, Capability capability) {
            this.iterator = itr;
            this.thisObj = scriptable;
            this.capability = capability;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ Object a(PromiseAnyRejector promiseAnyRejector, PromiseElementResolver promiseElementResolver, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            promiseAnyRejector.getClass();
            return promiseElementResolver.reject(context, scriptable, objArr.length > 0 ? objArr[0] : Undefined.instance, promiseAnyRejector);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void finalRejection(Context context, Scriptable scriptable) {
            this.capability.reject.call(context, scriptable, Undefined.SCRIPTABLE_UNDEFINED, new Object[]{(NativeError) context.newObject(scriptable, "AggregateError", new Object[]{context.newArray(scriptable, this.errors.toArray())})});
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Object reject(Context context, Scriptable scriptable) {
            Callable propFunctionAndThis = ScriptRuntime.getPropFunctionAndThis(this.thisObj, "resolve", context, scriptable);
            Scriptable scriptableLastStoredScriptable = ScriptRuntime.lastStoredScriptable(context);
            for (int i = 0; i != MAX_PROMISES; i++) {
                Object obj = Undefined.instance;
                try {
                    boolean zHasNext = this.iterator.hasNext();
                    Object next = zHasNext ? this.iterator.next() : obj;
                    if (!zHasNext) {
                        int i2 = this.remainingElements - 1;
                        this.remainingElements = i2;
                        if (i2 != 0) {
                            return this.capability.promise;
                        }
                        throw new JavaScriptException((NativeError) context.newObject(scriptable, "AggregateError", new Object[]{context.newArray(scriptable, this.errors.toArray())}), null, 0);
                    }
                    this.errors.add(obj);
                    Object objCall = propFunctionAndThis.call(context, scriptable, scriptableLastStoredScriptable, new Object[]{next});
                    final PromiseElementResolver promiseElementResolver = new PromiseElementResolver(i);
                    LambdaFunction lambdaFunction = new LambdaFunction(scriptable, 1, new Callable() { // from class: org.mozilla.javascript.c1
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // org.mozilla.javascript.Callable
                        public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                            return NativePromise.PromiseAnyRejector.a(this.f, promiseElementResolver, context2, scriptable2, scriptable3, objArr);
                        }
                    });
                    this.remainingElements++;
                    ScriptRuntime.getPropFunctionAndThis(objCall, "then", context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), new Object[]{this.capability.resolve, lambdaFunction});
                } catch (Throwable th) {
                    this.iterator.setDone(true);
                    throw th;
                }
            }
            throw ScriptRuntime.rangeErrorById("msg.promise.any.toobig", new Object[0]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class PromiseElementResolver {
        private boolean alreadyCalled = false;
        private final int index;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public PromiseElementResolver(int i) {
            this.index = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Object reject(Context context, Scriptable scriptable, Object obj, PromiseAnyRejector promiseAnyRejector) {
            if (this.alreadyCalled) {
                return Undefined.instance;
            }
            this.alreadyCalled = true;
            promiseAnyRejector.errors.set(this.index, obj);
            int i = promiseAnyRejector.remainingElements - 1;
            promiseAnyRejector.remainingElements = i;
            if (i == 0) {
                promiseAnyRejector.finalRejection(context, scriptable);
            }
            return Undefined.instance;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Object resolve(Context context, Scriptable scriptable, Object obj, PromiseAllResolver promiseAllResolver) {
            if (this.alreadyCalled) {
                return Undefined.instance;
            }
            this.alreadyCalled = true;
            promiseAllResolver.values.set(this.index, obj);
            int i = promiseAllResolver.remainingElements - 1;
            promiseAllResolver.remainingElements = i;
            if (i == 0) {
                promiseAllResolver.finalResolution(context, scriptable);
            }
            return Undefined.instance;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Reaction {
        Capability capability;
        Callable handler;
        ReactionType reaction;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Reaction(Capability capability, ReactionType reactionType, Callable callable) {
            ReactionType reactionType2 = ReactionType.FULFILL;
            this.capability = capability;
            this.reaction = reactionType;
            this.handler = callable;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void invoke(Context context, Scriptable scriptable, Object obj) {
            try {
                Callable callable = this.handler;
                if (callable == null) {
                    int iOrdinal = this.reaction.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal == 1) {
                            this.capability.reject.call(context, scriptable, Undefined.SCRIPTABLE_UNDEFINED, new Object[]{obj});
                            return;
                        }
                        obj = null;
                    }
                } else {
                    obj = callable.call(context, scriptable, Undefined.SCRIPTABLE_UNDEFINED, new Object[]{obj});
                }
                this.capability.resolve.call(context, scriptable, Undefined.SCRIPTABLE_UNDEFINED, new Object[]{obj});
            } catch (RhinoException e) {
                this.capability.reject.call(context, scriptable, Undefined.SCRIPTABLE_UNDEFINED, new Object[]{NativePromise.getErrorObject(context, scriptable, e)});
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum ReactionType {
        FULFILL,
        REJECT
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class ResolvingFunctions {
        private boolean alreadyResolved = false;
        LambdaFunction reject;
        LambdaFunction resolve;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ResolvingFunctions(Scriptable scriptable, final NativePromise nativePromise) {
            this.resolve = new LambdaFunction(scriptable, 1, new Callable() { // from class: org.mozilla.javascript.d1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.mozilla.javascript.Callable
                public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                    return NativePromise.ResolvingFunctions.b(this.f, nativePromise, context, scriptable2, scriptable3, objArr);
                }
            });
            this.reject = new LambdaFunction(scriptable, 1, new Callable() { // from class: org.mozilla.javascript.e1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.mozilla.javascript.Callable
                public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                    return NativePromise.ResolvingFunctions.a(this.f, nativePromise, context, scriptable2, scriptable3, objArr);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ Object a(ResolvingFunctions resolvingFunctions, NativePromise nativePromise, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            resolvingFunctions.getClass();
            return resolvingFunctions.reject(context, scriptable, nativePromise, objArr.length > 0 ? objArr[0] : Undefined.instance);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ Object b(ResolvingFunctions resolvingFunctions, NativePromise nativePromise, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            resolvingFunctions.getClass();
            return resolvingFunctions.resolve(context, scriptable, nativePromise, objArr.length > 0 ? objArr[0] : Undefined.instance);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private Object reject(Context context, Scriptable scriptable, NativePromise nativePromise, Object obj) {
            if (this.alreadyResolved) {
                return Undefined.instance;
            }
            this.alreadyResolved = true;
            return nativePromise.rejectPromise(context, scriptable, obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private Object resolve(final Context context, final Scriptable scriptable, final NativePromise nativePromise, final Object obj) {
            if (this.alreadyResolved) {
                return Undefined.instance;
            }
            this.alreadyResolved = true;
            if (obj == nativePromise) {
                return nativePromise.rejectPromise(context, scriptable, ScriptRuntime.newNativeError(context, scriptable, TopLevel.NativeErrors.TypeError, new Object[]{"No promise self-resolution"}));
            }
            if (!ScriptRuntime.isObject(obj)) {
                return nativePromise.fulfillPromise(context, scriptable, obj);
            }
            final Object property = ScriptableObject.getProperty(ScriptableObject.ensureScriptable(obj), "then");
            if (!(property instanceof Callable)) {
                return nativePromise.fulfillPromise(context, scriptable, obj);
            }
            context.enqueueMicrotask(new Runnable() { // from class: org.mozilla.javascript.f1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    nativePromise.callThenable(context, scriptable, obj, (Callable) property);
                }
            });
            return Undefined.instance;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum State {
        PENDING,
        FULFILLED,
        REJECTED
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object D(Scriptable scriptable, Callable callable, Object obj, Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
        final Object obj2 = objArr.length > 0 ? objArr[0] : Undefined.instance;
        return ScriptRuntime.getPropFunctionAndThis(resolveInternal(context, scriptable, obj, callable.call(context, scriptable2, Undefined.SCRIPTABLE_UNDEFINED, ScriptRuntime.emptyArgs)), "then", context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), new Object[]{new LambdaFunction(scriptable, 0, new Callable() { // from class: jz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable4, Scriptable scriptable5, Object[] objArr2) {
                return NativePromise.w(obj2, context2, scriptable4, scriptable5, objArr2);
            }
        })});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Object all(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return doAll(context, scriptable, scriptable2, objArr, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Object allSettled(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return doAll(context, scriptable, scriptable2, objArr, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r6v5, types: [org.mozilla.javascript.IteratorLikeIterable$Itr] */
    public static Object any(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Capability capability = new Capability(context, scriptable, scriptable2);
        try {
            IteratorLikeIterable iteratorLikeIterable = new IteratorLikeIterable(context, scriptable, ScriptRuntime.callIterator(objArr.length > 0 ? objArr[0] : Undefined.instance, context, scriptable));
            ?? it = iteratorLikeIterable.iterator();
            try {
                try {
                    Object objReject = new PromiseAnyRejector(it, scriptable2, capability).reject(context, scriptable);
                } finally {
                    if (!it.isDone()) {
                        iteratorLikeIterable.close();
                    }
                }
            } catch (RhinoException e) {
                capability.reject.call(context, scriptable, Undefined.SCRIPTABLE_UNDEFINED, new Object[]{getErrorObject(context, scriptable, e)});
                return capability.promise;
            }
        } catch (RhinoException e2) {
            capability.reject.call(context, scriptable, Undefined.SCRIPTABLE_UNDEFINED, new Object[]{getErrorObject(context, scriptable, e2)});
            return capability.promise;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public void callThenable(Context context, Scriptable scriptable, Object obj, Callable callable) {
        ResolvingFunctions resolvingFunctions = new ResolvingFunctions(scriptable, this);
        try {
            callable.call(context, scriptable, obj instanceof Scriptable ? (Scriptable) obj : Undefined.SCRIPTABLE_UNDEFINED, new Object[]{resolvingFunctions.resolve, resolvingFunctions.reject});
        } catch (RhinoException e) {
            resolvingFunctions.reject.call(context, scriptable, Undefined.SCRIPTABLE_UNDEFINED, new Object[]{getErrorObject(context, scriptable, e)});
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Scriptable constructor(Context context, Scriptable scriptable, Object[] objArr) {
        Scriptable scriptable2;
        if (objArr.length >= 1) {
            Object obj = objArr[0];
            if (obj instanceof Callable) {
                Callable callable = (Callable) obj;
                NativePromise nativePromise = new NativePromise();
                ResolvingFunctions resolvingFunctions = new ResolvingFunctions(scriptable, nativePromise);
                Scriptable scriptable3 = Undefined.SCRIPTABLE_UNDEFINED;
                if (!context.isStrictMode() && (scriptable2 = context.topCallScope) != null) {
                    scriptable3 = scriptable2;
                }
                try {
                    callable.call(context, scriptable, scriptable3, new Object[]{resolvingFunctions.resolve, resolvingFunctions.reject});
                    return nativePromise;
                } catch (RhinoException e) {
                    resolvingFunctions.reject.call(context, scriptable, scriptable3, new Object[]{getErrorObject(context, scriptable, e)});
                    return nativePromise;
                }
            }
        }
        throw ScriptRuntime.typeErrorById("msg.function.expected", new Object[0]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Type inference failed for: r6v5, types: [org.mozilla.javascript.IteratorLikeIterable$Itr] */
    private static Object doAll(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, boolean z) {
        Capability capability = new Capability(context, scriptable, scriptable2);
        try {
            IteratorLikeIterable iteratorLikeIterable = new IteratorLikeIterable(context, scriptable, ScriptRuntime.callIterator(objArr.length > 0 ? objArr[0] : Undefined.instance, context, scriptable));
            ?? it = iteratorLikeIterable.iterator();
            try {
                try {
                    Object objResolve = new PromiseAllResolver(it, scriptable2, capability, z).resolve(context, scriptable);
                } finally {
                    if (!it.isDone()) {
                        iteratorLikeIterable.close();
                    }
                }
            } catch (RhinoException e) {
                capability.reject.call(context, scriptable, Undefined.SCRIPTABLE_UNDEFINED, new Object[]{getErrorObject(context, scriptable, e)});
                return capability.promise;
            }
        } catch (RhinoException e2) {
            capability.reject.call(context, scriptable, Undefined.SCRIPTABLE_UNDEFINED, new Object[]{getErrorObject(context, scriptable, e2)});
            return capability.promise;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Object doCatch(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.getPropFunctionAndThis(ScriptRuntime.toObject(context, scriptable, scriptable2), "then", context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), new Object[]{Undefined.instance, objArr.length > 0 ? objArr[0] : Undefined.instance});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Object doFinally(Context context, Scriptable scriptable, Scriptable scriptable2, LambdaConstructor lambdaConstructor, Object[] objArr) {
        Object objMakeCatchFinally;
        if (!ScriptRuntime.isObject(scriptable2)) {
            throw ScriptRuntime.typeErrorById("msg.arg.not.object", ScriptRuntime.typeof(scriptable2));
        }
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.SCRIPTABLE_UNDEFINED;
        Constructable constructableSpeciesConstructor = AbstractEcmaObjectOperations.speciesConstructor(context, scriptable2, lambdaConstructor);
        if (obj instanceof Callable) {
            Callable callable = (Callable) obj;
            Callable callableMakeThenFinally = makeThenFinally(scriptable, constructableSpeciesConstructor, callable);
            objMakeCatchFinally = makeCatchFinally(scriptable, constructableSpeciesConstructor, callable);
            obj = callableMakeThenFinally;
        } else {
            objMakeCatchFinally = obj;
        }
        return ScriptRuntime.getPropFunctionAndThis(scriptable2, "then", context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), new Object[]{obj, objMakeCatchFinally});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public Object fulfillPromise(final Context context, final Scriptable scriptable, final Object obj) {
        this.result = obj;
        ArrayList<Reaction> arrayList = this.fulfillReactions;
        this.fulfillReactions = new ArrayList<>();
        if (!this.rejectReactions.isEmpty()) {
            this.rejectReactions = new ArrayList<>();
        }
        this.state = State.FULFILLED;
        for (final Reaction reaction : arrayList) {
            context.enqueueMicrotask(new Runnable() { // from class: org.mozilla.javascript.w0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    reaction.invoke(context, scriptable, obj);
                }
            });
        }
        return Undefined.instance;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Object getErrorObject(Context context, Scriptable scriptable, RhinoException rhinoException) {
        if (rhinoException instanceof JavaScriptException) {
            return ((JavaScriptException) rhinoException).getValue();
        }
        TopLevel.NativeErrors nativeErrors = TopLevel.NativeErrors.Error;
        if (rhinoException instanceof EcmaError) {
            String name = ((EcmaError) rhinoException).getName();
            name.getClass();
            switch (name) {
                case "TypeError":
                    nativeErrors = TopLevel.NativeErrors.TypeError;
                    break;
                case "InternalError":
                    nativeErrors = TopLevel.NativeErrors.InternalError;
                    break;
                case "EvalError":
                    nativeErrors = TopLevel.NativeErrors.EvalError;
                    break;
                case "JavaException":
                    nativeErrors = TopLevel.NativeErrors.JavaException;
                    break;
                case "URIError":
                    nativeErrors = TopLevel.NativeErrors.URIError;
                    break;
                case "RangeError":
                    nativeErrors = TopLevel.NativeErrors.RangeError;
                    break;
                case "ReferenceError":
                    nativeErrors = TopLevel.NativeErrors.ReferenceError;
                    break;
                case "SyntaxError":
                    nativeErrors = TopLevel.NativeErrors.SyntaxError;
                    break;
            }
        }
        return ScriptRuntime.newNativeError(context, scriptable, nativeErrors, new Object[]{rhinoException.getMessage()});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void init(Context context, Scriptable scriptable, boolean z) {
        final LambdaConstructor lambdaConstructor = new LambdaConstructor(scriptable, "Promise", 1, 2, new Constructable() { // from class: lz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Constructable
            public final Scriptable construct(Context context2, Scriptable scriptable2, Object[] objArr) {
                return NativePromise.constructor(context2, scriptable2, objArr);
            }
        });
        lambdaConstructor.setPrototypePropertyAttributes(7);
        lambdaConstructor.defineConstructorMethod(scriptable, "resolve", 1, new Callable() { // from class: mz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativePromise.resolve(context2, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        lambdaConstructor.defineConstructorMethod(scriptable, "reject", 1, new Callable() { // from class: nz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativePromise.reject(context2, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        lambdaConstructor.defineConstructorMethod(scriptable, DavPrincipal.KEY_ALL, 1, new Callable() { // from class: oz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativePromise.all(context2, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        lambdaConstructor.defineConstructorMethod(scriptable, "allSettled", 1, new Callable() { // from class: pz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativePromise.allSettled(context2, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        lambdaConstructor.defineConstructorMethod(scriptable, "race", 1, new Callable() { // from class: qz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativePromise.race(context2, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        lambdaConstructor.defineConstructorMethod(scriptable, "any", 1, new Callable() { // from class: rz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativePromise.any(context2, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        ScriptRuntimeES6.addSymbolSpecies(context, scriptable, lambdaConstructor);
        lambdaConstructor.definePrototypeMethod(scriptable, "then", 2, new Callable() { // from class: ez2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return ((NativePromise) LambdaConstructor.convertThisObject(scriptable3, NativePromise.class)).then(context2, scriptable2, lambdaConstructor, objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "catch", 1, new Callable() { // from class: fz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativePromise.doCatch(context2, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "finally", 1, new Callable() { // from class: gz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativePromise.doFinally(context2, scriptable2, scriptable3, lambdaConstructor, objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeProperty(SymbolKey.TO_STRING_TAG, "Promise", 3);
        ScriptableObject.defineProperty(scriptable, "Promise", lambdaConstructor, 2);
        if (z) {
            lambdaConstructor.sealObject();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object j(Scriptable scriptable, Callable callable, Object obj, Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
        final Object obj2 = objArr.length > 0 ? objArr[0] : Undefined.instance;
        return ScriptRuntime.getPropFunctionAndThis(resolveInternal(context, scriptable, obj, callable.call(context, scriptable2, Undefined.SCRIPTABLE_UNDEFINED, ScriptRuntime.emptyArgs)), "then", context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), new Object[]{new LambdaFunction(scriptable, 0, new Callable() { // from class: hz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable4, Scriptable scriptable5, Object[] objArr2) {
                return NativePromise.n(obj2, context2, scriptable4, scriptable5, objArr2);
            }
        })});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Callable makeCatchFinally(final Scriptable scriptable, final Object obj, final Callable callable) {
        return new LambdaFunction(scriptable, 1, new Callable() { // from class: kz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativePromise.D(scriptable, callable, obj, context, scriptable2, scriptable3, objArr);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Callable makeThenFinally(final Scriptable scriptable, final Object obj, final Callable callable) {
        return new LambdaFunction(scriptable, 1, new Callable() { // from class: iz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativePromise.j(scriptable, callable, obj, context, scriptable2, scriptable3, objArr);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void markHandled(Context context) {
        if (this.handled) {
            return;
        }
        context.getUnhandledPromiseTracker().promiseHandled(this);
        this.handled = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object n(Object obj, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object performRace(Context context, Scriptable scriptable, IteratorLikeIterable.Itr itr, Scriptable scriptable2, Capability capability) {
        Callable propFunctionAndThis = ScriptRuntime.getPropFunctionAndThis(scriptable2, "resolve", context, scriptable);
        Scriptable scriptableLastStoredScriptable = ScriptRuntime.lastStoredScriptable(context);
        while (true) {
            Object next = Undefined.instance;
            try {
                boolean zHasNext = itr.hasNext();
                if (zHasNext) {
                    next = itr.next();
                }
                if (!zHasNext) {
                    return capability.promise;
                }
                ScriptRuntime.getPropFunctionAndThis(propFunctionAndThis.call(context, scriptable, scriptableLastStoredScriptable, new Object[]{next}), "then", context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), new Object[]{capability.resolve, capability.reject});
            } catch (Throwable th) {
                itr.setDone(true);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v5, types: [org.mozilla.javascript.IteratorLikeIterable$Itr] */
    public static Object race(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Capability capability = new Capability(context, scriptable, scriptable2);
        try {
            IteratorLikeIterable iteratorLikeIterable = new IteratorLikeIterable(context, scriptable, ScriptRuntime.callIterator(objArr.length > 0 ? objArr[0] : Undefined.instance, context, scriptable));
            ?? it = iteratorLikeIterable.iterator();
            try {
                try {
                    Object objPerformRace = performRace(context, scriptable, it, scriptable2, capability);
                } catch (RhinoException e) {
                    capability.reject.call(context, scriptable, Undefined.SCRIPTABLE_UNDEFINED, new Object[]{getErrorObject(context, scriptable, e)});
                    return capability.promise;
                }
            } finally {
                if (!it.isDone()) {
                    iteratorLikeIterable.close();
                }
            }
        } catch (RhinoException e2) {
            capability.reject.call(context, scriptable, Undefined.SCRIPTABLE_UNDEFINED, new Object[]{getErrorObject(context, scriptable, e2)});
            return capability.promise;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Object reject(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!ScriptRuntime.isObject(scriptable2)) {
            throw ScriptRuntime.typeErrorById("msg.arg.not.object", ScriptRuntime.typeof(scriptable2));
        }
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        Capability capability = new Capability(context, scriptable, scriptable2);
        capability.reject.call(context, scriptable, Undefined.SCRIPTABLE_UNDEFINED, new Object[]{obj});
        return capability.promise;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public Object rejectPromise(final Context context, final Scriptable scriptable, final Object obj) {
        this.result = obj;
        ArrayList<Reaction> arrayList = this.rejectReactions;
        this.rejectReactions = new ArrayList<>();
        if (!this.fulfillReactions.isEmpty()) {
            this.fulfillReactions = new ArrayList<>();
        }
        this.state = State.REJECTED;
        context.getUnhandledPromiseTracker().promiseRejected(this);
        for (final Reaction reaction : arrayList) {
            context.enqueueMicrotask(new Runnable() { // from class: org.mozilla.javascript.v0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    reaction.invoke(context, scriptable, obj);
                }
            });
        }
        if (!arrayList.isEmpty()) {
            markHandled(context);
        }
        return Undefined.instance;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Object resolve(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (ScriptRuntime.isObject(scriptable2)) {
            return resolveInternal(context, scriptable, scriptable2, objArr.length > 0 ? objArr[0] : Undefined.instance);
        }
        throw ScriptRuntime.typeErrorById("msg.arg.not.object", ScriptRuntime.typeof(scriptable2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object resolveInternal(Context context, Scriptable scriptable, Object obj, Object obj2) {
        if ((obj2 instanceof NativePromise) && ScriptRuntime.getObjectProp(obj2, "constructor", context, scriptable) == obj) {
            return obj2;
        }
        Capability capability = new Capability(context, scriptable, obj);
        capability.resolve.call(context, scriptable, Undefined.SCRIPTABLE_UNDEFINED, new Object[]{obj2});
        return capability.promise;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object then(final Context context, final Scriptable scriptable, LambdaConstructor lambdaConstructor, Object[] objArr) {
        Callable callable;
        Capability capability = new Capability(context, scriptable, AbstractEcmaObjectOperations.speciesConstructor(context, this, lambdaConstructor));
        Callable callable2 = null;
        if (objArr.length >= 1) {
            Object obj = objArr[0];
            callable = obj instanceof Callable ? (Callable) obj : null;
        }
        if (objArr.length >= 2) {
            Object obj2 = objArr[1];
            if (obj2 instanceof Callable) {
                callable2 = (Callable) obj2;
            }
        }
        final Reaction reaction = new Reaction(capability, ReactionType.FULFILL, callable);
        final Reaction reaction2 = new Reaction(capability, ReactionType.REJECT, callable2);
        State state = this.state;
        if (state == State.PENDING) {
            this.fulfillReactions.add(reaction);
            this.rejectReactions.add(reaction2);
        } else if (state == State.FULFILLED) {
            context.enqueueMicrotask(new Runnable() { // from class: org.mozilla.javascript.x0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    reaction.invoke(context, scriptable, this.f.result);
                }
            });
        } else {
            markHandled(context);
            context.enqueueMicrotask(new Runnable() { // from class: org.mozilla.javascript.y0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    reaction2.invoke(context, scriptable, this.f.result);
                }
            });
        }
        return capability.promise;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0007: THROW 
      (wrap:org.mozilla.javascript.JavaScriptException:0x0004: CONSTRUCTOR (r0v0 java.lang.Object), (null java.lang.String), (0 int) A[MD:(java.lang.Object, java.lang.String, int):void (m), WRAPPED] (LINE:5) call: org.mozilla.javascript.JavaScriptException.<init>(java.lang.Object, java.lang.String, int):void type: CONSTRUCTOR)
     (LINE:8) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object w(Object obj, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        throw new JavaScriptException(obj, null, 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Promise";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object getResult() {
        return this.result;
    }
}
