package org.mozilla.javascript;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ArrayLikeAbstractOperations {
    private static final Comparator<Object> STRING_COMPARATOR = new StringLikeComparator();
    private static final Comparator<Object> DEFAULT_COMPARATOR = new ElementComparator();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum IterativeOperation {
        EVERY,
        FILTER,
        FOR_EACH,
        MAP,
        SOME,
        FIND,
        FIND_INDEX,
        FIND_LAST,
        FIND_LAST_INDEX
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum ReduceOperation {
        REDUCE,
        REDUCE_RIGHT
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class StringLikeComparator implements Comparator<Object>, Serializable {
        private static final long serialVersionUID = 5299017659728190979L;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ScriptRuntime.toString(obj).compareTo(ScriptRuntime.toString(obj2));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void defineElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (j > 2147483647L) {
            scriptable.put(Long.toString(j), scriptable, obj);
        } else {
            scriptable.put((int) j, scriptable, obj);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Function getCallbackArg(Context context, Object obj) {
        RegExpProxy regExpProxy;
        if (!(obj instanceof Function)) {
            throw ScriptRuntime.notFunctionError(obj);
        }
        Function function = (Function) obj;
        if (context.getLanguageVersion() < 200 || (regExpProxy = ScriptRuntime.getRegExpProxy(context)) == null || !regExpProxy.isRegExp(function)) {
            return function;
        }
        throw ScriptRuntime.notFunctionError(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object getRawElem(Scriptable scriptable, long j) {
        return j > 2147483647L ? ScriptableObject.getProperty(scriptable, Long.toString(j)) : ScriptableObject.getProperty(scriptable, (int) j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Comparator<Object> getSortComparator(Context context, Scriptable scriptable, Object[] objArr) {
        return (objArr.length <= 0 || Undefined.instance == objArr[0]) ? DEFAULT_COMPARATOR : getSortComparatorFromArguments(context, scriptable, objArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ElementComparator getSortComparatorFromArguments(final Context context, final Scriptable scriptable, Object[] objArr) {
        final Callable valueFunctionAndThis = ScriptRuntime.getValueFunctionAndThis(objArr[0], context);
        final Scriptable scriptableLastStoredScriptable = ScriptRuntime.lastStoredScriptable(context);
        final Object[] objArr2 = new Object[2];
        return new ElementComparator(new Comparator<Object>() { // from class: org.mozilla.javascript.ArrayLikeAbstractOperations.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                Object[] objArr3 = objArr2;
                objArr3[0] = obj;
                objArr3[1] = obj2;
                int iCompare = Double.compare(ScriptRuntime.toNumber(valueFunctionAndThis.call(context, scriptable, scriptableLastStoredScriptable, objArr3)), 0.0d);
                if (iCompare < 0) {
                    return -1;
                }
                return iCompare > 0 ? 1 : 0;
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x010e, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:130:0x010e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Object iterativeMethod(Context context, IdFunctionObject idFunctionObject, IterativeOperation iterativeOperation, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, boolean z) {
        Object obj;
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        if (!z && (IterativeOperation.FIND == iterativeOperation || IterativeOperation.FIND_INDEX == iterativeOperation || IterativeOperation.FIND_LAST == iterativeOperation || IterativeOperation.FIND_LAST_INDEX == iterativeOperation)) {
            ScriptRuntimeES6.requireObjectCoercible(context, object, idFunctionObject);
        }
        long lengthProperty = NativeArray.getLengthProperty(context, object);
        IterativeOperation iterativeOperation2 = IterativeOperation.MAP;
        if (iterativeOperation == iterativeOperation2 && lengthProperty > 2147483647L) {
            throw ScriptRuntime.rangeError(ScriptRuntime.getMessageById("msg.arraylength.bad", new Object[0]));
        }
        Function callbackArg = getCallbackArg(context, objArr.length > 0 ? objArr[0] : Undefined.instance);
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(callbackArg);
        Scriptable object2 = (objArr.length < 2 || (obj = objArr[1]) == null || obj == Undefined.instance) ? topLevelScope : ScriptRuntime.toObject(context, scriptable, obj);
        Scriptable scriptableNewArray = (iterativeOperation == IterativeOperation.FILTER || iterativeOperation == iterativeOperation2) ? context.newArray(scriptable, iterativeOperation == iterativeOperation2 ? (int) lengthProperty : 0) : null;
        IterativeOperation iterativeOperation3 = IterativeOperation.FIND_LAST;
        long j = 0;
        long j2 = 1;
        long j3 = (iterativeOperation == iterativeOperation3 || iterativeOperation == IterativeOperation.FIND_LAST_INDEX) ? lengthProperty - 1 : 0L;
        long j4 = -1;
        if (iterativeOperation == iterativeOperation3 || iterativeOperation == IterativeOperation.FIND_LAST_INDEX) {
            lengthProperty = -1;
        }
        if (iterativeOperation != iterativeOperation3 && iterativeOperation != IterativeOperation.FIND_LAST_INDEX) {
            j4 = 1;
        }
        long j5 = j3;
        while (j5 != lengthProperty) {
            long j6 = j2;
            Object rawElem = getRawElem(object, j5);
            if (rawElem != Scriptable.NOT_FOUND) {
                Object[] objArr2 = {rawElem, Long.valueOf(j5), object};
                Object objCall = callbackArg.call(context, topLevelScope, object2, objArr2);
                switch (iterativeOperation) {
                    case null:
                        if (!ScriptRuntime.toBoolean(objCall)) {
                            return Boolean.FALSE;
                        }
                        break;
                        break;
                    case 1:
                        if (ScriptRuntime.toBoolean(objCall)) {
                            defineElem(context, scriptableNewArray, j, objArr2[0]);
                            j += j6;
                        }
                        break;
                    case 3:
                        defineElem(context, scriptableNewArray, j5, objCall);
                        break;
                    case 4:
                        if (ScriptRuntime.toBoolean(objCall)) {
                            return Boolean.TRUE;
                        }
                        break;
                    case 5:
                    case 7:
                        if (ScriptRuntime.toBoolean(objCall)) {
                            return rawElem;
                        }
                        break;
                    case 6:
                    case 8:
                        if (ScriptRuntime.toBoolean(objCall)) {
                            return ScriptRuntime.wrapNumber(j5);
                        }
                        break;
                }
            } else if (iterativeOperation == IterativeOperation.FIND || iterativeOperation == IterativeOperation.FIND_INDEX || iterativeOperation == IterativeOperation.FIND_LAST || iterativeOperation == IterativeOperation.FIND_LAST_INDEX) {
                rawElem = Undefined.instance;
                Object[] objArr22 = {rawElem, Long.valueOf(j5), object};
                Object objCall2 = callbackArg.call(context, topLevelScope, object2, objArr22);
                switch (iterativeOperation) {
                }
            }
            j5 += j4;
            j2 = j6;
        }
        int iOrdinal = iterativeOperation.ordinal();
        return iOrdinal != 0 ? (iOrdinal == 1 || iOrdinal == 3) ? scriptableNewArray : iOrdinal != 4 ? (iOrdinal == 6 || iOrdinal == 8) ? ScriptRuntime.wrapNumber(-1.0d) : Undefined.instance : Boolean.FALSE : Boolean.TRUE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object reduceMethod(Context context, ReduceOperation reduceOperation, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
        long lengthProperty = NativeArray.getLengthProperty(context, object);
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (obj == null || !(obj instanceof Function)) {
            throw ScriptRuntime.notFunctionError(obj);
        }
        Function function = (Function) obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(function);
        boolean z = reduceOperation == ReduceOperation.REDUCE;
        Object objCall = objArr.length > 1 ? objArr[1] : Scriptable.NOT_FOUND;
        for (long j = 0; j < lengthProperty; j++) {
            long j2 = z ? j : (lengthProperty - 1) - j;
            Object rawElem = getRawElem(object, j2);
            Object obj2 = Scriptable.NOT_FOUND;
            if (rawElem != obj2) {
                objCall = objCall == obj2 ? rawElem : function.call(context, topLevelScope, topLevelScope, new Object[]{objCall, rawElem, Long.valueOf(j2), object});
            }
        }
        if (objCall != Scriptable.NOT_FOUND) {
            return objCall;
        }
        throw ScriptRuntime.typeErrorById("msg.empty.array.reduce", new Object[0]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long toSliceIndex(double d, long j) {
        if (d >= 0.0d) {
            return d > ((double) j) ? j : (long) d;
        }
        double d2 = d + j;
        if (d2 < 0.0d) {
            return 0L;
        }
        return (long) d2;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class ElementComparator implements Comparator<Object>, Serializable {
        private static final long serialVersionUID = -1189948017688708858L;
        private final Comparator<Object> child;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ElementComparator() {
            this.child = ArrayLikeAbstractOperations.STRING_COMPARATOR;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            Object obj3 = Undefined.instance;
            if (obj == obj3) {
                if (obj2 == obj3) {
                    return 0;
                }
                return obj2 == Scriptable.NOT_FOUND ? -1 : 1;
            }
            Object obj4 = Scriptable.NOT_FOUND;
            if (obj == obj4) {
                return obj2 == obj4 ? 0 : 1;
            }
            if (obj2 == obj4 || obj2 == obj3) {
                return -1;
            }
            return this.child.compare(obj, obj2);
        }

        public ElementComparator(Comparator<Object> comparator) {
            this.child = comparator;
        }
    }

    public static Object iterativeMethod(Context context, IdFunctionObject idFunctionObject, IterativeOperation iterativeOperation, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return iterativeMethod(context, idFunctionObject, iterativeOperation, scriptable, scriptable2, objArr, false);
    }

    public static Object iterativeMethod(Context context, IterativeOperation iterativeOperation, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return iterativeMethod(context, null, iterativeOperation, scriptable, scriptable2, objArr, true);
    }
}
