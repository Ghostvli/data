package org.mozilla.javascript;

import defpackage.ku0;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.mozilla.javascript.debug.DebuggableObject;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
final class EqualObjectGraphs {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ThreadLocal<EqualObjectGraphs> instance = new ThreadLocal<>();
    private static final Set<Class<?>> valueClasses = Collections.unmodifiableSet(new HashSet(Arrays.asList(Boolean.class, Byte.class, Character.class, Double.class, Float.class, Integer.class, Long.class, Short.class)));
    private final IdentityHashMap<Object, Object> knownEquals = new IdentityHashMap<>();
    private final IdentityHashMap<Object, Object> currentlyCompared = new IdentityHashMap<>();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ int a(Object obj, Object obj2) {
        if (obj instanceof Integer) {
            if (obj2 instanceof Integer) {
                return ((Integer) obj).compareTo((Integer) obj2);
            }
            if ((obj2 instanceof String) || (obj2 instanceof Symbol)) {
                return -1;
            }
        } else if (obj instanceof String) {
            if (obj2 instanceof String) {
                return ((String) obj).compareTo((String) obj2);
            }
            if (obj2 instanceof Integer) {
                return 1;
            }
            if (obj2 instanceof Symbol) {
                return -1;
            }
        } else if (obj instanceof Symbol) {
            if (obj2 instanceof Symbol) {
                return getSymbolName((Symbol) obj).compareTo(getSymbolName((Symbol) obj2));
            }
            if ((obj2 instanceof Integer) || (obj2 instanceof String)) {
                return 1;
            }
        }
        ku0.a();
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean equalGraphsNoMemo(Object obj, Object obj2) {
        return obj instanceof Wrapper ? (obj2 instanceof Wrapper) && equalGraphs(((Wrapper) obj).unwrap(), ((Wrapper) obj2).unwrap()) : obj instanceof NativeJavaTopPackage ? obj2 instanceof NativeJavaTopPackage : obj instanceof Scriptable ? (obj2 instanceof Scriptable) && equalScriptables((Scriptable) obj, (Scriptable) obj2) : obj instanceof SymbolKey ? (obj2 instanceof SymbolKey) && equalGraphs(((SymbolKey) obj).getName(), ((SymbolKey) obj2).getName()) : obj instanceof Object[] ? (obj2 instanceof Object[]) && equalObjectArrays((Object[]) obj, (Object[]) obj2) : obj.getClass().isArray() ? Objects.deepEquals(obj, obj2) : obj instanceof List ? (obj2 instanceof List) && equalLists((List) obj, (List) obj2) : obj instanceof Map ? (obj2 instanceof Map) && equalMaps((Map) obj, (Map) obj2) : obj instanceof Set ? (obj2 instanceof Set) && equalSets((Set) obj, (Set) obj2) : obj instanceof NativeGlobal ? obj2 instanceof NativeGlobal : obj instanceof JavaAdapter ? obj2 instanceof JavaAdapter : obj.equals(obj2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean equalInterpretedFunctions(InterpretedFunction interpretedFunction, InterpretedFunction interpretedFunction2) {
        return Objects.equals(interpretedFunction.getRawSource(), interpretedFunction2.getRawSource());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean equalLists(List<?> list, List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        Iterator<?> it = list.iterator();
        Iterator<?> it2 = list2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!equalGraphs(it.next(), it2.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean equalMaps(Map<?, ?> map, Map<?, ?> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        Iterator<Map.Entry> itSortedEntries = sortedEntries(map);
        Iterator<Map.Entry> itSortedEntries2 = sortedEntries(map2);
        while (itSortedEntries.hasNext() && itSortedEntries2.hasNext()) {
            Map.Entry next = itSortedEntries.next();
            Map.Entry next2 = itSortedEntries2.next();
            if (!equalGraphs(next.getKey(), next2.getKey()) || !equalGraphs(next.getValue(), next2.getValue())) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean equalObjectArrays(Object[] objArr, Object[] objArr2) {
        if (objArr.length != objArr2.length) {
            return false;
        }
        for (int i = 0; i < objArr.length; i++) {
            if (!equalGraphs(objArr[i], objArr2[i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean equalScriptables(Scriptable scriptable, Scriptable scriptable2) {
        Object[] sortedIds = getSortedIds(scriptable);
        Object[] sortedIds2 = getSortedIds(scriptable2);
        if (!equalObjectArrays(sortedIds, sortedIds2)) {
            return false;
        }
        int length = sortedIds.length;
        for (int i = 0; i < length; i++) {
            if (!equalGraphs(getValue(scriptable, sortedIds[i]), getValue(scriptable2, sortedIds2[i]))) {
                return false;
            }
        }
        if (!equalGraphs(scriptable.getPrototype(), scriptable2.getPrototype()) || !equalGraphs(scriptable.getParentScope(), scriptable2.getParentScope())) {
            return false;
        }
        if (scriptable instanceof NativeContinuation) {
            return (scriptable2 instanceof NativeContinuation) && NativeContinuation.equalImplementations((NativeContinuation) scriptable, (NativeContinuation) scriptable2);
        }
        if (scriptable instanceof NativeJavaPackage) {
            return scriptable.equals(scriptable2);
        }
        if (scriptable instanceof IdFunctionObject) {
            return (scriptable2 instanceof IdFunctionObject) && IdFunctionObject.equalObjectGraphs((IdFunctionObject) scriptable, (IdFunctionObject) scriptable2, this);
        }
        if (scriptable instanceof InterpretedFunction) {
            return (scriptable2 instanceof InterpretedFunction) && equalInterpretedFunctions((InterpretedFunction) scriptable, (InterpretedFunction) scriptable2);
        }
        if (scriptable instanceof ArrowFunction) {
            return (scriptable2 instanceof ArrowFunction) && ArrowFunction.equalObjectGraphs((ArrowFunction) scriptable, (ArrowFunction) scriptable2, this);
        }
        if (scriptable instanceof BoundFunction) {
            return (scriptable2 instanceof BoundFunction) && BoundFunction.equalObjectGraphs((BoundFunction) scriptable, (BoundFunction) scriptable2, this);
        }
        if (scriptable instanceof NativeSymbol) {
            return (scriptable2 instanceof NativeSymbol) && equalGraphs(((NativeSymbol) scriptable).getKey(), ((NativeSymbol) scriptable2).getKey());
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean equalSets(Set<?> set, Set<?> set2) {
        return equalObjectArrays(sortedSet(set), sortedSet(set2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object[] getIds(Scriptable scriptable) {
        return scriptable instanceof ScriptableObject ? ((ScriptableObject) scriptable).getIds(true, true) : scriptable instanceof DebuggableObject ? ((DebuggableObject) scriptable).getAllIds() : scriptable.getIds();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object[] getSortedIds(Scriptable scriptable) {
        Object[] ids = getIds(scriptable);
        Arrays.sort(ids, new Comparator() { // from class: org.mozilla.javascript.b
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return EqualObjectGraphs.a(obj, obj2);
            }
        });
        return ids;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String getSymbolName(Symbol symbol) {
        if (symbol instanceof SymbolKey) {
            return ((SymbolKey) symbol).getName();
        }
        if (symbol instanceof NativeSymbol) {
            return ((NativeSymbol) symbol).getKey().getName();
        }
        ku0.a();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object getValue(Scriptable scriptable, Object obj) {
        if (obj instanceof Symbol) {
            return ScriptableObject.getProperty(scriptable, (Symbol) obj);
        }
        if (obj instanceof Integer) {
            return ScriptableObject.getProperty(scriptable, ((Integer) obj).intValue());
        }
        if (obj instanceof String) {
            return ScriptableObject.getProperty(scriptable, (String) obj);
        }
        ku0.a();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Iterator<Map.Entry> sortedEntries(Map map) {
        if (!(map instanceof SortedMap)) {
            map = new TreeMap(map);
        }
        return map.entrySet().iterator();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object[] sortedSet(Set<?> set) {
        Object[] array = set.toArray();
        Arrays.sort(array);
        return array;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static <T> T withThreadLocal(java.util.function.Function<EqualObjectGraphs, T> function) {
        ThreadLocal<EqualObjectGraphs> threadLocal = instance;
        EqualObjectGraphs equalObjectGraphs = threadLocal.get();
        if (equalObjectGraphs != null) {
            return function.apply(equalObjectGraphs);
        }
        EqualObjectGraphs equalObjectGraphs2 = new EqualObjectGraphs();
        threadLocal.set(equalObjectGraphs2);
        try {
            T tApply = function.apply(equalObjectGraphs2);
            threadLocal.set(null);
            return tApply;
        } catch (Throwable th) {
            instance.set(null);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equalGraphs(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (obj instanceof String) {
            return obj2 instanceof ConsString ? obj.equals(obj2.toString()) : obj.equals(obj2);
        }
        if (obj instanceof ConsString) {
            if ((obj2 instanceof String) || (obj2 instanceof ConsString)) {
                return obj.toString().equals(obj2.toString());
            }
            return false;
        }
        if (valueClasses.contains(obj.getClass())) {
            return obj.equals(obj2);
        }
        Object obj3 = this.currentlyCompared.get(obj);
        if (obj3 == obj2) {
            return true;
        }
        if (obj3 != null) {
            return false;
        }
        Object obj4 = this.knownEquals.get(obj);
        if (obj4 == obj2) {
            return true;
        }
        if (obj4 != null || this.knownEquals.get(obj2) != null) {
            return false;
        }
        this.currentlyCompared.put(obj, obj2);
        boolean zEqualGraphsNoMemo = equalGraphsNoMemo(obj, obj2);
        if (zEqualGraphsNoMemo) {
            this.knownEquals.put(obj, obj2);
            this.knownEquals.put(obj2, obj);
        }
        this.currentlyCompared.remove(obj);
        return zEqualGraphsNoMemo;
    }
}
