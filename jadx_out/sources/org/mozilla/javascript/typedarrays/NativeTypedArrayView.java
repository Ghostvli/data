package org.mozilla.javascript.typedarrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.RandomAccess;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import net.engio.mbassy.listener.MessageHandler;
import org.mozilla.javascript.AbstractEcmaObjectOperations;
import org.mozilla.javascript.ArrayLikeAbstractOperations;
import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ExternalArrayData;
import org.mozilla.javascript.LambdaConstructor;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.NativeArrayIterator;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.SymbolKey;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.Wrapper;
import org.mozilla.javascript.typedarrays.NativeTypedArrayView;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeTypedArrayView<T> extends NativeArrayBufferView implements List<T>, RandomAccess, ExternalArrayData {
    private static final long serialVersionUID = -4963053773152251274L;
    protected final int length;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface RealThis {
        NativeTypedArrayView<?> realThis(Scriptable scriptable);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface TypedArrayConstructable {
        NativeTypedArrayView<?> construct(NativeArrayBuffer nativeArrayBuffer, int i, int i2);
    }

    public NativeTypedArrayView() {
        this.length = 0;
    }

    public static /* synthetic */ Object J(RealThis realThis, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return new NativeArrayIterator(scriptable, realThis.realThis(scriptable2), NativeArrayIterator.ARRAY_ITERATOR_TYPE.VALUES);
    }

    public static /* synthetic */ Object P(RealThis realThis, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        NativeTypedArrayView<?> nativeTypedArrayViewRealThis = realThis.realThis(scriptable2);
        return nativeTypedArrayViewRealThis.typedArraySpeciesCreate(context, scriptable, new Object[]{ArrayLikeAbstractOperations.iterativeMethod(context, ArrayLikeAbstractOperations.IterativeOperation.FILTER, scriptable, nativeTypedArrayViewRealThis, objArr)}, MessageHandler.Properties.Filter);
    }

    public static /* synthetic */ Object S(RealThis realThis, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return new NativeArrayIterator(scriptable, realThis.realThis(scriptable2), NativeArrayIterator.ARRAY_ITERATOR_TYPE.VALUES);
    }

    public static /* synthetic */ Object V(RealThis realThis, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return new NativeArrayIterator(scriptable, realThis.realThis(scriptable2), NativeArrayIterator.ARRAY_ITERATOR_TYPE.KEYS);
    }

    private Object getElemForToString(Context context, Scriptable scriptable, int i, boolean z) {
        Object objJs_get = js_get(i);
        return z ? ScriptRuntime.getPropFunctionAndThis(objJs_get, "toLocaleString", context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), ScriptRuntime.emptyArgs) : objJs_get;
    }

    public static void init(Context context, Scriptable scriptable, LambdaConstructor lambdaConstructor, final RealThis realThis) {
        lambdaConstructor.definePrototypeProperty(context, "buffer", new Function() { // from class: k03
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return NativeTypedArrayView.js_buffer((Scriptable) obj, realThis);
            }
        }, 3);
        lambdaConstructor.definePrototypeProperty(context, "byteLength", new Function() { // from class: c03
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return NativeTypedArrayView.js_byteLength((Scriptable) obj, realThis);
            }
        }, 3);
        lambdaConstructor.definePrototypeProperty(context, "byteOffset", new Function() { // from class: o03
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return NativeTypedArrayView.js_byteOffset((Scriptable) obj, realThis);
            }
        }, 3);
        lambdaConstructor.definePrototypeProperty(context, Name.LENGTH, new Function() { // from class: w03
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return NativeTypedArrayView.js_length((Scriptable) obj, realThis);
            }
        }, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "at", 1, new Callable() { // from class: x03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_at(context2, scriptable2, scriptable3, objArr, realThis);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "copyWithin", 1, new Callable() { // from class: y03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_copyWithin(context2, scriptable2, scriptable3, objArr, realThis);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "entries", 0, new Callable() { // from class: z03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.u(realThis, context2, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "every", 1, new Callable() { // from class: a13
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return ArrayLikeAbstractOperations.iterativeMethod(context2, ArrayLikeAbstractOperations.IterativeOperation.EVERY, scriptable2, realThis.realThis(scriptable3), objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "fill", 1, new Callable() { // from class: b13
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_fill(context2, scriptable2, scriptable3, objArr, realThis);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, MessageHandler.Properties.Filter, 1, new Callable() { // from class: c13
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.P(realThis, context2, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "find", 1, new Callable() { // from class: v03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return ArrayLikeAbstractOperations.iterativeMethod(context2, ArrayLikeAbstractOperations.IterativeOperation.FIND, scriptable2, realThis.realThis(scriptable3), objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "findIndex", 1, new Callable() { // from class: d13
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return ArrayLikeAbstractOperations.iterativeMethod(context2, ArrayLikeAbstractOperations.IterativeOperation.FIND_INDEX, scriptable2, realThis.realThis(scriptable3), objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "findLast", 1, new Callable() { // from class: e13
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return ArrayLikeAbstractOperations.iterativeMethod(context2, ArrayLikeAbstractOperations.IterativeOperation.FIND_LAST, scriptable2, realThis.realThis(scriptable3), objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "findLastIndex", 1, new Callable() { // from class: f13
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return ArrayLikeAbstractOperations.iterativeMethod(context2, ArrayLikeAbstractOperations.IterativeOperation.FIND_LAST_INDEX, scriptable2, realThis.realThis(scriptable3), objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "forEach", 1, new Callable() { // from class: g13
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return ArrayLikeAbstractOperations.iterativeMethod(context2, ArrayLikeAbstractOperations.IterativeOperation.FOR_EACH, scriptable2, realThis.realThis(scriptable3), objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "includes", 1, new Callable() { // from class: h13
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_includes(context2, scriptable2, scriptable3, objArr, realThis);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "indexOf", 1, new Callable() { // from class: i13
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_indexOf(context2, scriptable2, scriptable3, objArr, realThis);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "join", 1, new Callable() { // from class: j13
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_join(context2, scriptable2, scriptable3, objArr, realThis);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "keys", 0, new Callable() { // from class: a03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.V(realThis, context2, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "lastIndexOf", 1, new Callable() { // from class: b03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_lastIndexOf(context2, scriptable2, scriptable3, objArr, realThis);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "map", 1, new Callable() { // from class: d03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return realThis.realThis(scriptable3).typedArraySpeciesCreate(context2, scriptable2, new Object[]{ArrayLikeAbstractOperations.iterativeMethod(context2, ArrayLikeAbstractOperations.IterativeOperation.MAP, scriptable2, scriptable3, objArr)}, "map");
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "reduce", 1, new Callable() { // from class: e03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return ArrayLikeAbstractOperations.reduceMethod(context2, ArrayLikeAbstractOperations.ReduceOperation.REDUCE, scriptable2, realThis.realThis(scriptable3), objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "reduceRight", 1, new Callable() { // from class: f03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return ArrayLikeAbstractOperations.reduceMethod(context2, ArrayLikeAbstractOperations.ReduceOperation.REDUCE_RIGHT, scriptable2, realThis.realThis(scriptable3), objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "reverse", 0, new Callable() { // from class: g03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_reverse(context2, scriptable2, scriptable3, objArr, realThis);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "set", 0, new Callable() { // from class: h03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_set(context2, scriptable2, scriptable3, objArr, realThis);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "slice", 2, new Callable() { // from class: i03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_slice(context2, scriptable2, scriptable3, objArr, realThis);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "some", 1, new Callable() { // from class: j03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return ArrayLikeAbstractOperations.iterativeMethod(context2, ArrayLikeAbstractOperations.IterativeOperation.SOME, scriptable2, realThis.realThis(scriptable3), objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "sort", 1, new Callable() { // from class: l03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_sort(context2, scriptable2, scriptable3, objArr, realThis);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "subarray", 2, new Callable() { // from class: m03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_subarray(context2, scriptable2, scriptable3, objArr, realThis);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "toLocaleString", 0, new Callable() { // from class: n03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_toString(context2, scriptable2, scriptable3, objArr, realThis, true);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "toReversed", 0, new Callable() { // from class: p03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_toReversed(context2, scriptable2, scriptable3, objArr, realThis);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "toSorted", 1, new Callable() { // from class: q03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_toSorted(context2, scriptable2, scriptable3, objArr, realThis);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "toString", 0, new Callable() { // from class: r03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_toString(context2, scriptable2, scriptable3, objArr, realThis, false);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "values", 0, new Callable() { // from class: s03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.S(realThis, context2, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "with", 2, new Callable() { // from class: t03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.js_with(context2, scriptable2, scriptable3, objArr, realThis);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, SymbolKey.ITERATOR, 0, new Callable() { // from class: u03
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeTypedArrayView.J(realThis, context2, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_at(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RealThis realThis) {
        NativeTypedArrayView<?> nativeTypedArrayViewRealThis = realThis.realThis(scriptable2);
        long integer = objArr.length >= 1 ? (long) ScriptRuntime.toInteger(objArr[0]) : 0L;
        if (integer < 0) {
            integer += (long) nativeTypedArrayViewRealThis.length;
        }
        return (integer < 0 || integer >= ((long) nativeTypedArrayViewRealThis.length)) ? Undefined.instance : ScriptableObject.getProperty(scriptable2, (int) integer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_buffer(Scriptable scriptable, RealThis realThis) {
        return realThis.realThis(scriptable).arrayBuffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_byteLength(Scriptable scriptable, RealThis realThis) {
        return Integer.valueOf(realThis.realThis(scriptable).byteLength);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_byteOffset(Scriptable scriptable, RealThis realThis) {
        return Integer.valueOf(realThis.realThis(scriptable).offset);
    }

    public static NativeTypedArrayView<?> js_constructor(Context context, Scriptable scriptable, Object[] objArr, TypedArrayConstructable typedArrayConstructable, int i) {
        if (!NativeArrayBufferView.isArg(objArr, 0)) {
            return typedArrayConstructable.construct(new NativeArrayBuffer(), 0, 0);
        }
        Object obj = objArr[0];
        if (obj == null) {
            return typedArrayConstructable.construct(new NativeArrayBuffer(), 0, 0);
        }
        if ((obj instanceof Number) || (obj instanceof String)) {
            int int32 = ScriptRuntime.toInt32(obj);
            return typedArrayConstructable.construct(makeArrayBuffer(context, scriptable, int32, i), 0, int32);
        }
        if (obj instanceof NativeTypedArrayView) {
            NativeTypedArrayView nativeTypedArrayView = (NativeTypedArrayView) obj;
            NativeTypedArrayView<?> nativeTypedArrayViewConstruct = typedArrayConstructable.construct(makeArrayBuffer(context, scriptable, nativeTypedArrayView.length, i), 0, nativeTypedArrayView.length);
            while (int32 < nativeTypedArrayView.length) {
                nativeTypedArrayViewConstruct.js_set(int32, nativeTypedArrayView.js_get(int32));
                int32++;
            }
            return nativeTypedArrayViewConstruct;
        }
        if (obj instanceof NativeArrayBuffer) {
            NativeArrayBuffer nativeArrayBuffer = (NativeArrayBuffer) obj;
            int32 = NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0;
            int int322 = NativeArrayBufferView.isArg(objArr, 2) ? ScriptRuntime.toInt32(objArr[2]) * i : nativeArrayBuffer.getLength() - int32;
            if (int32 < 0 || int32 > nativeArrayBuffer.getLength()) {
                throw ScriptRuntime.rangeError(ScriptRuntime.getMessageById("msg.typed.array.bad.offset", Integer.valueOf(int32)));
            }
            if (int322 < 0 || int32 + int322 > nativeArrayBuffer.getLength()) {
                throw ScriptRuntime.rangeError(ScriptRuntime.getMessageById("msg.typed.array.bad.length", Integer.valueOf(int322)));
            }
            if (int32 % i != 0) {
                throw ScriptRuntime.rangeError(ScriptRuntime.getMessageById("msg.typed.array.bad.offset.byte.size", Integer.valueOf(int32), Integer.valueOf(i)));
            }
            if (int322 % i == 0) {
                return typedArrayConstructable.construct(nativeArrayBuffer, int32, int322 / i);
            }
            throw ScriptRuntime.rangeError(ScriptRuntime.getMessageById("msg.typed.array.bad.buffer.length.byte.size", Integer.valueOf(int322), Integer.valueOf(i)));
        }
        if (!(obj instanceof NativeArray)) {
            if (!ScriptRuntime.isArrayObject(obj)) {
                throw ScriptRuntime.constructError("Error", "invalid argument");
            }
            Object[] arrayElements = ScriptRuntime.getArrayElements((Scriptable) obj);
            NativeTypedArrayView<?> nativeTypedArrayViewConstruct2 = typedArrayConstructable.construct(makeArrayBuffer(context, scriptable, arrayElements.length, i), 0, arrayElements.length);
            while (int32 < arrayElements.length) {
                nativeTypedArrayViewConstruct2.js_set(int32, arrayElements[int32]);
                int32++;
            }
            return nativeTypedArrayViewConstruct2;
        }
        NativeArray nativeArray = (NativeArray) obj;
        NativeTypedArrayView<?> nativeTypedArrayViewConstruct3 = typedArrayConstructable.construct(makeArrayBuffer(context, scriptable, nativeArray.size(), i), 0, nativeArray.size());
        while (int32 < nativeArray.size()) {
            Object obj2 = nativeArray.get(int32, nativeArray);
            if (obj2 == Scriptable.NOT_FOUND || obj2 == Undefined.instance) {
                nativeTypedArrayViewConstruct3.js_set(int32, ScriptRuntime.NaNobj);
            } else if (obj2 instanceof Wrapper) {
                nativeTypedArrayViewConstruct3.js_set(int32, ((Wrapper) obj2).unwrap());
            } else {
                nativeTypedArrayViewConstruct3.js_set(int32, obj2);
            }
            int32++;
        }
        return nativeTypedArrayViewConstruct3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_copyWithin(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RealThis realThis) {
        NativeTypedArrayView<?> nativeTypedArrayViewRealThis = realThis.realThis(scriptable2);
        int i = 1;
        long integer = (long) ScriptRuntime.toInteger(objArr.length >= 1 ? objArr[0] : Undefined.instance);
        long jMax = integer < 0 ? Math.max(((long) nativeTypedArrayViewRealThis.length) + integer, 0L) : Math.min(integer, nativeTypedArrayViewRealThis.length);
        long integer2 = (long) ScriptRuntime.toInteger(objArr.length >= 2 ? objArr[1] : Undefined.instance);
        long jMax2 = integer2 < 0 ? Math.max(((long) nativeTypedArrayViewRealThis.length) + integer2, 0L) : Math.min(integer2, nativeTypedArrayViewRealThis.length);
        long integer3 = nativeTypedArrayViewRealThis.length;
        if (objArr.length >= 3 && !Undefined.isUndefined(objArr[2])) {
            integer3 = (long) ScriptRuntime.toInteger(objArr[2]);
        }
        int i2 = nativeTypedArrayViewRealThis.length;
        long jMin = Math.min((integer3 < 0 ? Math.max(((long) i2) + integer3, 0L) : Math.min(integer3, i2)) - jMax2, ((long) nativeTypedArrayViewRealThis.length) - jMax);
        if (jMax2 < jMax) {
            long j = jMax2 + jMin;
            if (jMax < j) {
                jMax2 = j - 1;
                jMax = (jMax + jMin) - 1;
                i = -1;
            }
        }
        while (jMin > 0) {
            nativeTypedArrayViewRealThis.js_set((int) jMax, nativeTypedArrayViewRealThis.js_get((int) jMax2));
            long j2 = i;
            jMax2 += j2;
            jMax += j2;
            jMin--;
        }
        return nativeTypedArrayViewRealThis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NativeTypedArrayView<?> js_fill(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RealThis realThis) {
        NativeTypedArrayView<?> nativeTypedArrayViewRealThis = realThis.realThis(scriptable2);
        long integer = objArr.length >= 2 ? (long) ScriptRuntime.toInteger(objArr[1]) : 0L;
        long jMax = integer < 0 ? Math.max(((long) nativeTypedArrayViewRealThis.length) + integer, 0L) : Math.min(integer, nativeTypedArrayViewRealThis.length);
        long integer2 = nativeTypedArrayViewRealThis.length;
        if (objArr.length >= 3 && !Undefined.isUndefined(objArr[2])) {
            integer2 = (long) ScriptRuntime.toInteger(objArr[2]);
        }
        int i = nativeTypedArrayViewRealThis.length;
        long jMax2 = integer2 < 0 ? Math.max(((long) i) + integer2, 0L) : Math.min(integer2, i);
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        for (int i2 = (int) jMax; i2 < jMax2; i2++) {
            nativeTypedArrayViewRealThis.js_set(i2, obj);
        }
        return nativeTypedArrayViewRealThis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0030 A[PHI: r7
      0x0030: PHI (r7v7 long) = (r7v6 long), (r7v10 long) binds: [B:14:0x0025, B:16:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Boolean js_includes(org.mozilla.javascript.Context r4, org.mozilla.javascript.Scriptable r5, org.mozilla.javascript.Scriptable r6, java.lang.Object[] r7, org.mozilla.javascript.typedarrays.NativeTypedArrayView.RealThis r8) {
        /*
            org.mozilla.javascript.typedarrays.NativeTypedArrayView r4 = r8.realThis(r6)
            int r5 = r7.length
            if (r5 <= 0) goto Lb
            r5 = 0
            r5 = r7[r5]
            goto Ld
        Lb:
            java.lang.Object r5 = org.mozilla.javascript.Undefined.instance
        Ld:
            int r6 = r4.length
            if (r6 != 0) goto L14
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L14:
            int r6 = r7.length
            r8 = 2
            r0 = 0
            if (r6 >= r8) goto L1b
            goto L3c
        L1b:
            r6 = 1
            r7 = r7[r6]
            double r7 = org.mozilla.javascript.ScriptRuntime.toInteger(r7)
            long r7 = (long) r7
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 >= 0) goto L30
            int r2 = r4.length
            long r2 = (long) r2
            long r7 = r7 + r2
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 >= 0) goto L30
            goto L31
        L30:
            r0 = r7
        L31:
            int r7 = r4.length
            int r7 = r7 - r6
            long r6 = (long) r7
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 <= 0) goto L3c
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L3c:
            int r6 = (int) r0
        L3d:
            int r7 = r4.length
            if (r6 >= r7) goto L51
            java.lang.Object r7 = r4.js_get(r6)
            boolean r7 = org.mozilla.javascript.ScriptRuntime.sameZero(r7, r5)
            if (r7 == 0) goto L4e
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            return r4
        L4e:
            int r6 = r6 + 1
            goto L3d
        L51:
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.typedarrays.NativeTypedArrayView.js_includes(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[], org.mozilla.javascript.typedarrays.NativeTypedArrayView$RealThis):java.lang.Boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033 A[PHI: r3
      0x0033: PHI (r3v2 long) = (r3v1 long), (r3v3 long) binds: [B:13:0x0028, B:15:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object js_indexOf(org.mozilla.javascript.Context r7, org.mozilla.javascript.Scriptable r8, org.mozilla.javascript.Scriptable r9, java.lang.Object[] r10, org.mozilla.javascript.typedarrays.NativeTypedArrayView.RealThis r11) {
        /*
            r7 = -1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            org.mozilla.javascript.typedarrays.NativeTypedArrayView r8 = r11.realThis(r9)
            int r9 = r10.length
            if (r9 <= 0) goto L10
            r9 = 0
            r9 = r10[r9]
            goto L12
        L10:
            java.lang.Object r9 = org.mozilla.javascript.Undefined.instance
        L12:
            int r11 = r8.length
            if (r11 != 0) goto L17
            return r7
        L17:
            int r11 = r10.length
            r0 = 2
            r1 = 0
            if (r11 >= r0) goto L1e
            goto L3d
        L1e:
            r11 = 1
            r10 = r10[r11]
            double r3 = org.mozilla.javascript.ScriptRuntime.toInteger(r10)
            long r3 = (long) r3
            int r10 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r10 >= 0) goto L33
            int r10 = r8.length
            long r5 = (long) r10
            long r3 = r3 + r5
            int r10 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r10 >= 0) goto L33
            goto L34
        L33:
            r1 = r3
        L34:
            int r10 = r8.length
            int r10 = r10 - r11
            long r10 = (long) r10
            int r10 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r10 <= 0) goto L3d
            return r7
        L3d:
            int r10 = (int) r1
        L3e:
            int r11 = r8.length
            if (r10 >= r11) goto L59
            java.lang.Object r11 = r8.js_get(r10)
            java.lang.Object r0 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r11 == r0) goto L56
            boolean r11 = org.mozilla.javascript.ScriptRuntime.shallowEq(r11, r9)
            if (r11 == 0) goto L56
            long r7 = (long) r10
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            return r7
        L56:
            int r10 = r10 + 1
            goto L3e
        L59:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.typedarrays.NativeTypedArrayView.js_indexOf(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[], org.mozilla.javascript.typedarrays.NativeTypedArrayView$RealThis):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String js_join(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RealThis realThis) {
        int i;
        Object obj;
        NativeTypedArrayView<?> nativeTypedArrayViewRealThis = realThis.realThis(scriptable2);
        String string = (objArr.length < 1 || (obj = objArr[0]) == Undefined.instance) ? "," : ScriptRuntime.toString(obj);
        int i2 = nativeTypedArrayViewRealThis.length;
        if (i2 == 0) {
            return "";
        }
        String[] strArr = new String[i2];
        int i3 = 0;
        int length = 0;
        while (true) {
            i = nativeTypedArrayViewRealThis.length;
            if (i3 == i) {
                break;
            }
            Object objJs_get = nativeTypedArrayViewRealThis.js_get(i3);
            if (objJs_get != null && objJs_get != Undefined.instance) {
                String string2 = ScriptRuntime.toString(objJs_get);
                length += string2.length();
                strArr[i3] = string2;
            }
            i3++;
        }
        StringBuilder sb = new StringBuilder(length + ((i - 1) * string.length()));
        for (int i4 = 0; i4 != nativeTypedArrayViewRealThis.length; i4++) {
            if (i4 != 0) {
                sb.append(string);
            }
            String str = strArr[i4];
            if (str != null) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_lastIndexOf(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RealThis realThis) {
        long integer;
        NativeTypedArrayView<?> nativeTypedArrayViewRealThis = realThis.realThis(scriptable2);
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        int i = nativeTypedArrayViewRealThis.length;
        if (i == 0) {
            return -1;
        }
        if (objArr.length < 2) {
            integer = ((long) i) - 1;
        } else {
            integer = (long) ScriptRuntime.toInteger(objArr[1]);
            int i2 = nativeTypedArrayViewRealThis.length;
            if (integer >= i2) {
                integer = ((long) i2) - 1;
            } else if (integer < 0) {
                integer += (long) i2;
            }
            if (integer < 0) {
                return -1;
            }
        }
        for (int i3 = (int) integer; i3 >= 0; i3--) {
            Object objJs_get = nativeTypedArrayViewRealThis.js_get(i3);
            if (objJs_get != Scriptable.NOT_FOUND && ScriptRuntime.shallowEq(objJs_get, obj)) {
                return Long.valueOf(i3);
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_length(Scriptable scriptable, RealThis realThis) {
        return Integer.valueOf(realThis.realThis(scriptable).length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NativeTypedArrayView<?> js_reverse(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RealThis realThis) {
        NativeTypedArrayView<?> nativeTypedArrayViewRealThis = realThis.realThis(scriptable2);
        int i = 0;
        for (int i2 = nativeTypedArrayViewRealThis.length - 1; i < i2; i2--) {
            Object objJs_get = nativeTypedArrayViewRealThis.js_get(i);
            nativeTypedArrayViewRealThis.js_set(i, nativeTypedArrayViewRealThis.js_get(i2));
            nativeTypedArrayViewRealThis.js_set(i2, objJs_get);
            i++;
        }
        return nativeTypedArrayViewRealThis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_set(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RealThis realThis) {
        NativeTypedArrayView<?> nativeTypedArrayViewRealThis = realThis.realThis(scriptable2);
        if (objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof NativeTypedArrayView) {
                nativeTypedArrayViewRealThis.setRange((NativeTypedArrayView<?>) objArr[0], NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0);
                return Undefined.instance;
            }
            if (obj instanceof NativeArray) {
                nativeTypedArrayViewRealThis.setRange((NativeArray) objArr[0], NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0);
                return Undefined.instance;
            }
            if (obj instanceof Scriptable) {
                return Undefined.instance;
            }
            if (NativeArrayBufferView.isArg(objArr, 2)) {
                return nativeTypedArrayViewRealThis.js_set(ScriptRuntime.toInt32(objArr[0]), objArr[1]);
            }
        }
        throw ScriptRuntime.constructError("Error", "invalid arguments");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Scriptable js_slice(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RealThis realThis) {
        long sliceIndex;
        long sliceIndex2;
        Object obj;
        NativeTypedArrayView<?> nativeTypedArrayViewRealThis = realThis.realThis(scriptable2);
        if (objArr.length == 0) {
            sliceIndex2 = nativeTypedArrayViewRealThis.length;
            sliceIndex = 0;
        } else {
            sliceIndex = ArrayLikeAbstractOperations.toSliceIndex(ScriptRuntime.toInteger(objArr[0]), nativeTypedArrayViewRealThis.length);
            sliceIndex2 = (objArr.length == 1 || (obj = objArr[1]) == Undefined.instance) ? nativeTypedArrayViewRealThis.length : ArrayLikeAbstractOperations.toSliceIndex(ScriptRuntime.toInteger(obj), nativeTypedArrayViewRealThis.length);
        }
        long j = sliceIndex2 - sliceIndex;
        if (j > 2147483647L) {
            throw ScriptRuntime.rangeError(ScriptRuntime.getMessageById("msg.arraylength.bad", new Object[0]));
        }
        Math.max(j, 0L);
        return nativeTypedArrayViewRealThis.typedArraySpeciesCreate(context, scriptable, new Object[]{nativeTypedArrayViewRealThis.arrayBuffer, Long.valueOf(sliceIndex * ((long) nativeTypedArrayViewRealThis.getBytesPerElement())), Long.valueOf(Math.max(0L, j))}, "slice");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Scriptable js_sort(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RealThis realThis) {
        if (NativeArrayBufferView.isArg(objArr, 0) && !(objArr[0] instanceof Callable)) {
            throw ScriptRuntime.typeErrorById("msg.function.expected", new Object[0]);
        }
        NativeTypedArrayView<?> nativeTypedArrayViewRealThis = realThis.realThis(scriptable2);
        Object[] objArrSortTemporaryArray = nativeTypedArrayViewRealThis.sortTemporaryArray(context, scriptable, objArr);
        for (int i = 0; i < nativeTypedArrayViewRealThis.length; i++) {
            nativeTypedArrayViewRealThis.js_set(i, objArrSortTemporaryArray[i]);
        }
        return nativeTypedArrayViewRealThis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_subarray(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RealThis realThis) {
        NativeTypedArrayView<?> nativeTypedArrayViewRealThis = realThis.realThis(scriptable2);
        int int32 = NativeArrayBufferView.isArg(objArr, 0) ? ScriptRuntime.toInt32(objArr[0]) : 0;
        int int322 = NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : nativeTypedArrayViewRealThis.length;
        if (context.getLanguageVersion() < 200 && objArr.length <= 0) {
            throw ScriptRuntime.constructError("Error", "invalid arguments");
        }
        if (int32 < 0) {
            int32 += nativeTypedArrayViewRealThis.length;
        }
        if (int322 < 0) {
            int322 += nativeTypedArrayViewRealThis.length;
        }
        int iMax = Math.max(0, int32);
        return context.newObject(scriptable, nativeTypedArrayViewRealThis.getClassName(), new Object[]{nativeTypedArrayViewRealThis.arrayBuffer, Integer.valueOf(Math.min(nativeTypedArrayViewRealThis.getByteOffset() + (iMax * nativeTypedArrayViewRealThis.getBytesPerElement()), nativeTypedArrayViewRealThis.arrayBuffer.getLength())), Integer.valueOf(Math.max(0, Math.min(nativeTypedArrayViewRealThis.length, int322) - iMax))});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_toReversed(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RealThis realThis) {
        NativeTypedArrayView<?> nativeTypedArrayViewRealThis = realThis.realThis(scriptable2);
        int i = 0;
        Scriptable scriptableNewObject = context.newObject(scriptable, nativeTypedArrayViewRealThis.getClassName(), new Object[]{new NativeArrayBuffer(nativeTypedArrayViewRealThis.length * nativeTypedArrayViewRealThis.getBytesPerElement()), 0, Integer.valueOf(nativeTypedArrayViewRealThis.length), Integer.valueOf(nativeTypedArrayViewRealThis.getBytesPerElement())});
        while (true) {
            if (i >= nativeTypedArrayViewRealThis.length) {
                return scriptableNewObject;
            }
            scriptableNewObject.put(i, scriptableNewObject, nativeTypedArrayViewRealThis.js_get((r5 - i) - 1));
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_toSorted(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RealThis realThis) {
        NativeTypedArrayView<?> nativeTypedArrayViewRealThis = realThis.realThis(scriptable2);
        Object[] objArrSortTemporaryArray = nativeTypedArrayViewRealThis.sortTemporaryArray(context, scriptable, objArr);
        Scriptable scriptableNewObject = context.newObject(scriptable, nativeTypedArrayViewRealThis.getClassName(), new Object[]{new NativeArrayBuffer(nativeTypedArrayViewRealThis.length * nativeTypedArrayViewRealThis.getBytesPerElement()), 0, Integer.valueOf(nativeTypedArrayViewRealThis.length), Integer.valueOf(nativeTypedArrayViewRealThis.getBytesPerElement())});
        for (int i = 0; i < nativeTypedArrayViewRealThis.length; i++) {
            scriptableNewObject.put(i, scriptableNewObject, objArrSortTemporaryArray[i]);
        }
        return scriptableNewObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String js_toString(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RealThis realThis, boolean z) {
        NativeTypedArrayView<?> nativeTypedArrayViewRealThis = realThis.realThis(scriptable2);
        StringBuilder sb = new StringBuilder();
        if (nativeTypedArrayViewRealThis.length > 0) {
            sb.append(ScriptRuntime.toString(nativeTypedArrayViewRealThis.getElemForToString(context, scriptable, 0, z)));
        }
        for (int i = 1; i < nativeTypedArrayViewRealThis.length; i++) {
            sb.append(',');
            sb.append(ScriptRuntime.toString(nativeTypedArrayViewRealThis.getElemForToString(context, scriptable, i, z)));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_with(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RealThis realThis) {
        NativeTypedArrayView<?> nativeTypedArrayViewRealThis = realThis.realThis(scriptable2);
        long integer = objArr.length > 0 ? (int) ScriptRuntime.toInteger(objArr[0]) : 0L;
        long j = integer >= 0 ? integer : ((long) nativeTypedArrayViewRealThis.length) + integer;
        Double dValueOf = Double.valueOf(objArr.length > 1 ? ScriptRuntime.toNumber(objArr[1]) : 0.0d);
        if (j < 0 || j >= nativeTypedArrayViewRealThis.length) {
            throw ScriptRuntime.rangeError(ScriptRuntime.getMessageById("msg.typed.array.index.out.of.bounds", Long.valueOf(integer), Integer.valueOf(nativeTypedArrayViewRealThis.length * (-1)), Integer.valueOf(nativeTypedArrayViewRealThis.length - 1)));
        }
        Scriptable scriptableNewObject = context.newObject(scriptable, nativeTypedArrayViewRealThis.getClassName(), new Object[]{new NativeArrayBuffer(nativeTypedArrayViewRealThis.length * nativeTypedArrayViewRealThis.getBytesPerElement()), 0, Integer.valueOf(nativeTypedArrayViewRealThis.length), Integer.valueOf(nativeTypedArrayViewRealThis.getBytesPerElement())});
        for (int i = 0; i < nativeTypedArrayViewRealThis.length; i++) {
            scriptableNewObject.put(i, scriptableNewObject, ((long) i) == j ? dValueOf : nativeTypedArrayViewRealThis.js_get(i));
        }
        return scriptableNewObject;
    }

    private static NativeArrayBuffer makeArrayBuffer(Context context, Scriptable scriptable, int i, int i2) {
        return (NativeArrayBuffer) context.newObject(scriptable, NativeArrayBuffer.CLASS_NAME, new Object[]{Double.valueOf(((double) i) * ((double) i2))});
    }

    private void setRange(NativeTypedArrayView<?> nativeTypedArrayView, int i) {
        int i2;
        if (i < 0 || i > (i2 = this.length)) {
            throw ScriptRuntime.rangeError(ScriptRuntime.getMessageById("msg.typed.array.bad.offset", Integer.valueOf(i)));
        }
        int i3 = nativeTypedArrayView.length;
        int i4 = 0;
        if (i3 > i2 - i) {
            throw ScriptRuntime.rangeError(ScriptRuntime.getMessageById("msg.typed.array.bad.source.array", new Object[0]));
        }
        if (nativeTypedArrayView.arrayBuffer != this.arrayBuffer) {
            while (i4 < nativeTypedArrayView.length) {
                js_set(i4 + i, nativeTypedArrayView.js_get(i4));
                i4++;
            }
            return;
        }
        Object[] objArr = new Object[i3];
        for (int i5 = 0; i5 < nativeTypedArrayView.length; i5++) {
            objArr[i5] = nativeTypedArrayView.js_get(i5);
        }
        while (i4 < nativeTypedArrayView.length) {
            js_set(i4 + i, objArr[i4]);
            i4++;
        }
    }

    private Object[] sortTemporaryArray(Context context, Scriptable scriptable, Object[] objArr) {
        Comparator<Object> comparatorComparingDouble = (objArr.length <= 0 || Undefined.instance == objArr[0]) ? Comparator.comparingDouble(new ToDoubleFunction() { // from class: zz2
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                return ((Number) obj).doubleValue();
            }
        }) : ArrayLikeAbstractOperations.getSortComparator(context, scriptable, objArr);
        Object[] array = toArray();
        Arrays.sort(array, comparatorComparingDouble);
        return array;
    }

    private static int toIndex(double d) {
        int i = (int) d;
        if (i != d || i < 0) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Scriptable typedArraySpeciesCreate(Context context, Scriptable scriptable, Object[] objArr, String str) {
        Scriptable scriptableConstruct = AbstractEcmaObjectOperations.speciesConstructor(context, this, ScriptRuntime.getExistingCtor(context, ScriptableObject.getTopLevelScope(scriptable), getClassName())).construct(context, scriptable, objArr);
        if (scriptableConstruct instanceof NativeTypedArrayView) {
            return scriptableConstruct;
        }
        throw ScriptRuntime.typeErrorById("msg.typed.array.ctor.incompatible", str);
    }

    public static /* synthetic */ Object u(RealThis realThis, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return new NativeArrayIterator(scriptable, realThis.realThis(scriptable2), NativeArrayIterator.ARRAY_ITERATOR_TYPE.ENTRIES);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean checkIndex(int i) {
        return i < 0 || i >= this.length;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(String str) {
        if (ScriptRuntime.canonicalNumericIndexString(str).isPresent()) {
            return;
        }
        super.delete(str);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NativeTypedArrayView)) {
            return false;
        }
        NativeTypedArrayView nativeTypedArrayView = (NativeTypedArrayView) obj;
        if (this.length != nativeTypedArrayView.length) {
            return false;
        }
        for (int i = 0; i < this.length; i++) {
            if (!js_get(i).equals(nativeTypedArrayView.js_get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        int index;
        Optional<Double> optionalCanonicalNumericIndexString = ScriptRuntime.canonicalNumericIndexString(str);
        return (!optionalCanonicalNumericIndexString.isPresent() || (index = toIndex(optionalCanonicalNumericIndexString.get().doubleValue())) < 0) ? super.get(str, scriptable) : js_get(index);
    }

    @Override // org.mozilla.javascript.ExternalArrayData
    public Object getArrayElement(int i) {
        return js_get(i);
    }

    @Override // org.mozilla.javascript.ExternalArrayData
    public int getArrayLength() {
        return this.length;
    }

    public abstract int getBytesPerElement();

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        Object[] objArr = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            objArr[i] = Integer.valueOf(i);
        }
        return objArr;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        int index;
        Optional<Double> optionalCanonicalNumericIndexString = ScriptRuntime.canonicalNumericIndexString(str);
        return (!optionalCanonicalNumericIndexString.isPresent() || (index = toIndex(optionalCanonicalNumericIndexString.get().doubleValue())) < 0) ? super.has(str, scriptable) : !checkIndex(index);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        int iHashCode = 0;
        for (int i = 0; i < this.length; i++) {
            iHashCode += js_get(i).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        for (int i = 0; i < this.length; i++) {
            if (obj.equals(js_get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // org.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new NativeTypedArrayIterator(this, 0);
    }

    public abstract Object js_get(int i);

    public abstract Object js_set(int i, Object obj);

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        for (int i = this.length - 1; i >= 0; i--) {
            if (obj.equals(js_get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return new NativeTypedArrayIterator(this, i);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        Optional<Double> optionalCanonicalNumericIndexString = ScriptRuntime.canonicalNumericIndexString(str);
        if (!optionalCanonicalNumericIndexString.isPresent()) {
            super.put(str, scriptable, obj);
            return;
        }
        int index = toIndex(optionalCanonicalNumericIndexString.get().doubleValue());
        if (index >= 0) {
            js_set(index, obj);
        }
    }

    @Override // java.util.List
    public T remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.ExternalArrayData
    public void setArrayElement(int i, Object obj) {
        js_set(i, obj);
    }

    @Override // org.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public int size() {
        return this.length;
    }

    @Override // java.util.List
    public List<T> subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public <U> U[] toArray(U[] uArr) {
        if (uArr.length < this.length) {
            uArr = (U[]) ((Object[]) Array.newInstance(uArr.getClass().getComponentType(), this.length));
        }
        for (int i = 0; i < this.length; i++) {
            try {
                uArr[i] = js_get(i);
            } catch (ClassCastException unused) {
                throw new ArrayStoreException();
            }
        }
        return uArr;
    }

    @Override // java.util.List
    public void add(int i, T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public NativeTypedArrayView(NativeArrayBuffer nativeArrayBuffer, int i, int i2, int i3) {
        super(nativeArrayBuffer, i, i3);
        this.length = i2;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i) {
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new NativeTypedArrayIterator(this, 0);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        js_set(i, obj);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        return js_get(i);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return !checkIndex(i);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            objArr[i] = js_get(i);
        }
        return objArr;
    }

    private void setRange(NativeArray nativeArray, int i) {
        if (i >= 0 && i <= this.length) {
            if (nativeArray.size() + i <= this.length) {
                Iterator it = nativeArray.iterator();
                while (it.hasNext()) {
                    js_set(i, it.next());
                    i++;
                }
                return;
            }
            throw ScriptRuntime.rangeError(ScriptRuntime.getMessageById("msg.typed.array.bad.source.array", new Object[0]));
        }
        throw ScriptRuntime.rangeError(ScriptRuntime.getMessageById("msg.typed.array.bad.offset", Integer.valueOf(i)));
    }
}
