package org.mozilla.javascript;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class NativeArrayIterator extends ES6Iterator {
    private static final String ITERATOR_TAG = "ArrayIterator";
    private static final long serialVersionUID = 1;
    private Scriptable arrayLike;
    private int index;
    private ARRAY_ITERATOR_TYPE type;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum ARRAY_ITERATOR_TYPE {
        ENTRIES,
        KEYS,
        VALUES
    }

    public NativeArrayIterator(Scriptable scriptable, Scriptable scriptable2, ARRAY_ITERATOR_TYPE array_iterator_type) {
        super(scriptable, ITERATOR_TAG);
        this.index = 0;
        this.arrayLike = scriptable2;
        this.type = array_iterator_type;
    }

    public static void init(ScriptableObject scriptableObject, boolean z) {
        ES6Iterator.init(scriptableObject, z, new NativeArrayIterator(), ITERATOR_TAG);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Array Iterator";
    }

    @Override // org.mozilla.javascript.ES6Iterator
    public String getTag() {
        return ITERATOR_TAG;
    }

    @Override // org.mozilla.javascript.ES6Iterator
    public boolean isDone(Context context, Scriptable scriptable) {
        return ((long) this.index) >= NativeArray.getLengthProperty(context, this.arrayLike);
    }

    @Override // org.mozilla.javascript.ES6Iterator
    public Object nextValue(Context context, Scriptable scriptable) {
        if (this.type == ARRAY_ITERATOR_TYPE.KEYS) {
            int i = this.index;
            this.index = i + 1;
            return Integer.valueOf(i);
        }
        Scriptable scriptable2 = this.arrayLike;
        Object objNewArray = scriptable2.get(this.index, scriptable2);
        if (objNewArray == Scriptable.NOT_FOUND) {
            objNewArray = Undefined.instance;
        }
        if (this.type == ARRAY_ITERATOR_TYPE.ENTRIES) {
            objNewArray = context.newArray(scriptable, new Object[]{Integer.valueOf(this.index), objNewArray});
        }
        this.index++;
        return objNewArray;
    }

    private NativeArrayIterator() {
    }
}
