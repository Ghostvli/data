package is.xyz.mpv;

import defpackage.il1;
import defpackage.j33;
import defpackage.o24;
import defpackage.sg4;
import defpackage.ua;
import defpackage.vg;
import defpackage.we0;
import defpackage.ww;
import is.xyz.mpv.MPVNode;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MPVNode {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class ArrayNode extends MPVNode {
        private final MPVNode[] value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArrayNode(MPVNode[] mPVNodeArr) {
            super(null);
            mPVNodeArr.getClass();
            this.value = mPVNodeArr;
        }

        public static /* synthetic */ ArrayNode copy$default(ArrayNode arrayNode, MPVNode[] mPVNodeArr, int i, Object obj) {
            if ((i & 1) != 0) {
                mPVNodeArr = arrayNode.value;
            }
            return arrayNode.copy(mPVNodeArr);
        }

        public final MPVNode[] component1() {
            return this.value;
        }

        public final ArrayNode copy(MPVNode[] mPVNodeArr) {
            mPVNodeArr.getClass();
            return new ArrayNode(mPVNodeArr);
        }

        @Override // is.xyz.mpv.MPVNode
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ArrayNode) && il1.a(this.value, ((ArrayNode) obj).value);
        }

        public final MPVNode[] getValue() {
            return this.value;
        }

        @Override // is.xyz.mpv.MPVNode
        public int hashCode() {
            return Arrays.hashCode(this.value);
        }

        public String toString() {
            return "ArrayNode(value=" + Arrays.toString(this.value) + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class BooleanNode extends MPVNode {
        private final boolean value;

        public BooleanNode(boolean z) {
            super(null);
            this.value = z;
        }

        public static /* synthetic */ BooleanNode copy$default(BooleanNode booleanNode, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = booleanNode.value;
            }
            return booleanNode.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final BooleanNode copy(boolean z) {
            return new BooleanNode(z);
        }

        @Override // is.xyz.mpv.MPVNode
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BooleanNode) && this.value == ((BooleanNode) obj).value;
        }

        public final boolean getValue() {
            return this.value;
        }

        @Override // is.xyz.mpv.MPVNode
        public int hashCode() {
            return Boolean.hashCode(this.value);
        }

        public String toString() {
            return "BooleanNode(value=" + this.value + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class ByteArrayNode extends MPVNode {
        private final byte[] value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ByteArrayNode(byte[] bArr) {
            super(null);
            bArr.getClass();
            this.value = bArr;
        }

        public static /* synthetic */ ByteArrayNode copy$default(ByteArrayNode byteArrayNode, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = byteArrayNode.value;
            }
            return byteArrayNode.copy(bArr);
        }

        public final byte[] component1() {
            return this.value;
        }

        public final ByteArrayNode copy(byte[] bArr) {
            bArr.getClass();
            return new ByteArrayNode(bArr);
        }

        @Override // is.xyz.mpv.MPVNode
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ByteArrayNode) && il1.a(this.value, ((ByteArrayNode) obj).value);
        }

        public final byte[] getValue() {
            return this.value;
        }

        @Override // is.xyz.mpv.MPVNode
        public int hashCode() {
            return Arrays.hashCode(this.value);
        }

        public String toString() {
            return "ByteArrayNode(value=" + Arrays.toString(this.value) + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class DoubleNode extends MPVNode {
        private final double value;

        public DoubleNode(double d) {
            super(null);
            this.value = d;
        }

        public static /* synthetic */ DoubleNode copy$default(DoubleNode doubleNode, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                d = doubleNode.value;
            }
            return doubleNode.copy(d);
        }

        public final double component1() {
            return this.value;
        }

        public final DoubleNode copy(double d) {
            return new DoubleNode(d);
        }

        @Override // is.xyz.mpv.MPVNode
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DoubleNode) && Double.compare(this.value, ((DoubleNode) obj).value) == 0;
        }

        public final double getValue() {
            return this.value;
        }

        @Override // is.xyz.mpv.MPVNode
        public int hashCode() {
            return Double.hashCode(this.value);
        }

        public String toString() {
            return "DoubleNode(value=" + this.value + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class IntNode extends MPVNode {
        private final long value;

        public IntNode(long j) {
            super(null);
            this.value = j;
        }

        public static /* synthetic */ IntNode copy$default(IntNode intNode, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = intNode.value;
            }
            return intNode.copy(j);
        }

        public final long component1() {
            return this.value;
        }

        public final IntNode copy(long j) {
            return new IntNode(j);
        }

        @Override // is.xyz.mpv.MPVNode
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IntNode) && this.value == ((IntNode) obj).value;
        }

        public final long getValue() {
            return this.value;
        }

        @Override // is.xyz.mpv.MPVNode
        public int hashCode() {
            return Long.hashCode(this.value);
        }

        public String toString() {
            return "IntNode(value=" + this.value + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class MapNode extends MPVNode {
        private final Map<String, MPVNode> value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public MapNode(Map<String, ? extends MPVNode> map) {
            super(null);
            map.getClass();
            this.value = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MapNode copy$default(MapNode mapNode, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = mapNode.value;
            }
            return mapNode.copy(map);
        }

        public final Map<String, MPVNode> component1() {
            return this.value;
        }

        public final MapNode copy(Map<String, ? extends MPVNode> map) {
            map.getClass();
            return new MapNode(map);
        }

        @Override // is.xyz.mpv.MPVNode
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MapNode) && il1.a(this.value, ((MapNode) obj).value);
        }

        public final Map<String, MPVNode> getValue() {
            return this.value;
        }

        @Override // is.xyz.mpv.MPVNode
        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "MapNode(value=" + this.value + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class None extends MPVNode {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class StringNode extends MPVNode {
        private final String value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringNode(String str) {
            super(null);
            str.getClass();
            this.value = str;
        }

        public static /* synthetic */ StringNode copy$default(StringNode stringNode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stringNode.value;
            }
            return stringNode.copy(str);
        }

        public final String component1() {
            return this.value;
        }

        public final StringNode copy(String str) {
            str.getClass();
            return new StringNode(str);
        }

        @Override // is.xyz.mpv.MPVNode
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StringNode) && il1.a(this.value, ((StringNode) obj).value);
        }

        public final String getValue() {
            return this.value;
        }

        @Override // is.xyz.mpv.MPVNode
        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "StringNode(value=" + this.value + ")";
        }
    }

    public /* synthetic */ MPVNode(we0 we0Var) {
        this();
    }

    public static CharSequence a(Map.Entry entry) {
        entry.getClass();
        return "\"" + entry.getKey() + "\":" + ((MPVNode) entry.getValue()).toJson();
    }

    public static CharSequence b(MPVNode mPVNode) {
        mPVNode.getClass();
        return mPVNode.toJson();
    }

    public final MPVNode[] asArray() {
        ArrayNode arrayNode = this instanceof ArrayNode ? (ArrayNode) this : null;
        if (arrayNode != null) {
            return arrayNode.getValue();
        }
        return null;
    }

    public final Boolean asBoolean() {
        BooleanNode booleanNode = this instanceof BooleanNode ? (BooleanNode) this : null;
        if (booleanNode != null) {
            return Boolean.valueOf(booleanNode.getValue());
        }
        return null;
    }

    public final byte[] asByteArray() {
        ByteArrayNode byteArrayNode = this instanceof ByteArrayNode ? (ByteArrayNode) this : null;
        if (byteArrayNode != null) {
            return byteArrayNode.getValue();
        }
        return null;
    }

    public final Double asDouble() {
        DoubleNode doubleNode = this instanceof DoubleNode ? (DoubleNode) this : null;
        if (doubleNode != null) {
            return Double.valueOf(doubleNode.getValue());
        }
        return null;
    }

    public final Long asInt() {
        IntNode intNode = this instanceof IntNode ? (IntNode) this : null;
        if (intNode != null) {
            return Long.valueOf(intNode.getValue());
        }
        return null;
    }

    public final Map<String, MPVNode> asMap() {
        MapNode mapNode = this instanceof MapNode ? (MapNode) this : null;
        if (mapNode != null) {
            return mapNode.getValue();
        }
        return null;
    }

    public final String asString() {
        StringNode stringNode = this instanceof StringNode ? (StringNode) this : null;
        if (stringNode != null) {
            return stringNode.getValue();
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MPVNode) {
            return ((this instanceof ArrayNode) && (obj instanceof ArrayNode)) ? Arrays.equals(((ArrayNode) this).getValue(), ((ArrayNode) obj).getValue()) : ((this instanceof ByteArrayNode) && (obj instanceof ByteArrayNode)) ? Arrays.equals(((ByteArrayNode) this).getValue(), ((ByteArrayNode) obj).getValue()) : this instanceof None ? obj instanceof None : this instanceof StringNode ? (obj instanceof StringNode) && il1.a(((StringNode) this).getValue(), ((StringNode) obj).getValue()) : this instanceof BooleanNode ? (obj instanceof BooleanNode) && ((BooleanNode) this).getValue() == ((BooleanNode) obj).getValue() : this instanceof IntNode ? (obj instanceof IntNode) && ((IntNode) this).getValue() == ((IntNode) obj).getValue() : this instanceof DoubleNode ? (obj instanceof DoubleNode) && ((DoubleNode) this).getValue() == ((DoubleNode) obj).getValue() : (this instanceof MapNode) && (obj instanceof MapNode) && il1.a(((MapNode) this).getValue(), ((MapNode) obj).getValue());
        }
        return false;
    }

    public final MPVNode get(String str) {
        str.getClass();
        Map<String, MPVNode> mapAsMap = asMap();
        if (mapAsMap != null) {
            return mapAsMap.get(str);
        }
        return null;
    }

    public int hashCode() {
        if (this instanceof None) {
            return 0;
        }
        if (this instanceof StringNode) {
            return ((StringNode) this).getValue().hashCode();
        }
        if (this instanceof BooleanNode) {
            return Boolean.hashCode(((BooleanNode) this).getValue());
        }
        if (this instanceof IntNode) {
            return Long.hashCode(((IntNode) this).getValue());
        }
        if (this instanceof DoubleNode) {
            return Double.hashCode(((DoubleNode) this).getValue());
        }
        if (this instanceof ByteArrayNode) {
            return Arrays.hashCode(((ByteArrayNode) this).getValue());
        }
        if (this instanceof ArrayNode) {
            return Arrays.hashCode(((ArrayNode) this).getValue());
        }
        if (this instanceof MapNode) {
            return ((MapNode) this).getValue().hashCode();
        }
        throw new j33();
    }

    public final boolean isEmpty() {
        return this instanceof ArrayNode ? ((ArrayNode) this).getValue().length == 0 : this instanceof MapNode ? ((MapNode) this).getValue().isEmpty() : this instanceof StringNode ? ((StringNode) this).getValue().length() == 0 : this instanceof None;
    }

    public final Set<String> keys() {
        Set<String> setKeySet;
        Map<String, MPVNode> mapAsMap = asMap();
        return (mapAsMap == null || (setKeySet = mapAsMap.keySet()) == null) ? o24.d() : setKeySet;
    }

    public final int size() {
        if (this instanceof ArrayNode) {
            return ((ArrayNode) this).getValue().length;
        }
        if (this instanceof MapNode) {
            return ((MapNode) this).getValue().size();
        }
        return 0;
    }

    public final String toJson() {
        if (this instanceof None) {
            return "null";
        }
        if (this instanceof StringNode) {
            return "\"" + sg4.G(((StringNode) this).getValue(), "\"", "\\\"", false, 4, null) + "\"";
        }
        if (this instanceof BooleanNode) {
            return ((BooleanNode) this).getValue() ? "true" : "false";
        }
        if (this instanceof IntNode) {
            return String.valueOf(((IntNode) this).getValue());
        }
        if (this instanceof DoubleNode) {
            return String.valueOf(((DoubleNode) this).getValue());
        }
        if (this instanceof ByteArrayNode) {
            return "\"" + vg.d(vg.f, ((ByteArrayNode) this).getValue(), 0, 0, 6, null) + "\"";
        }
        if (this instanceof ArrayNode) {
            return "[" + ua.G(((ArrayNode) this).getValue(), ",", null, null, 0, null, new Function1() { // from class: u32
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MPVNode.b((MPVNode) obj);
                }
            }, 30, null) + "]";
        }
        if (!(this instanceof MapNode)) {
            throw new j33();
        }
        return "{" + ww.P(((MapNode) this).getValue().entrySet(), ",", null, null, 0, null, new Function1() { // from class: v32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MPVNode.a((Map.Entry) obj);
            }
        }, 30, null) + "}";
    }

    private MPVNode() {
    }

    public final MPVNode get(int i) {
        MPVNode[] mPVNodeArrAsArray = asArray();
        if (mPVNodeArrAsArray != null) {
            return (MPVNode) ua.B(mPVNodeArrAsArray, i);
        }
        return null;
    }
}
