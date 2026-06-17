package is.xyz.mpv;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public abstract class MPVNode {

    public static final class ArrayNode extends MPVNode {
        private final MPVNode[] value;

        public ArrayNode(MPVNode[] value) {
            this.value = value;
        }

        public MPVNode[] getValue() {
            return value;
        }
    }

    public static final class BooleanNode extends MPVNode {
        private final boolean value;

        public BooleanNode(boolean value) {
            this.value = value;
        }

        public boolean getValue() {
            return value;
        }
    }

    public static final class ByteArrayNode extends MPVNode {
        private final byte[] value;

        public ByteArrayNode(byte[] value) {
            this.value = value;
        }

        public byte[] getValue() {
            return value;
        }
    }

    public static final class DoubleNode extends MPVNode {
        private final double value;

        public DoubleNode(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }

    public static final class IntNode extends MPVNode {
        private final long value;

        public IntNode(long value) {
            this.value = value;
        }

        public long getValue() {
            return value;
        }
    }

    public static final class MapNode extends MPVNode {
        private final Map<String, MPVNode> value;

        public MapNode(Map<String, MPVNode> value) {
            this.value = value;
        }

        public Map<String, MPVNode> getValue() {
            return value;
        }
    }

    public static final class None extends MPVNode {
        public static final None INSTANCE = new None();
        private None() {}
    }

    public static final class StringNode extends MPVNode {
        private final String value;

        public StringNode(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    protected MPVNode() {}

    public final MPVNode[] asArray() {
        return this instanceof ArrayNode ? ((ArrayNode) this).getValue() : null;
    }

    public final Boolean asBoolean() {
        return this instanceof BooleanNode ? ((BooleanNode) this).getValue() : null;
    }

    public final byte[] asByteArray() {
        return this instanceof ByteArrayNode ? ((ByteArrayNode) this).getValue() : null;
    }

    public final Double asDouble() {
        return this instanceof DoubleNode ? ((DoubleNode) this).getValue() : null;
    }

    public final Long asInt() {
        return this instanceof IntNode ? ((IntNode) this).getValue() : null;
    }

    public final Map<String, MPVNode> asMap() {
        return this instanceof MapNode ? ((MapNode) this).getValue() : null;
    }

    public final String asString() {
        return this instanceof StringNode ? ((StringNode) this).getValue() : null;
    }

    public final MPVNode get(String key) {
        Map<String, MPVNode> map = asMap();
        return map != null ? map.get(key) : null;
    }

    public final MPVNode get(int index) {
        MPVNode[] array = asArray();
        if (array != null && index >= 0 && index < array.length) {
            return array[index];
        }
        return null;
    }

    public final boolean isEmpty() {
        if (this instanceof None) return true;
        if (this instanceof StringNode) return ((StringNode) this).getValue().isEmpty();
        if (this instanceof ArrayNode) return ((ArrayNode) this).getValue().length == 0;
        if (this instanceof MapNode) return ((MapNode) this).getValue().isEmpty();
        return false;
    }

    public final Set<String> keys() {
        Map<String, MPVNode> map = asMap();
        return map != null ? map.keySet() : Collections.emptySet();
    }

    public final int size() {
        if (this instanceof ArrayNode) return ((ArrayNode) this).getValue().length;
        if (this instanceof MapNode) return ((MapNode) this).getValue().size();
        return 0;
    }

    public final String toJson() {
        if (this instanceof None) {
            return "null";
        }
        if (this instanceof StringNode) {
            return "\"" + ((StringNode) this).getValue().replace("\"", "\\\"") + "\"";
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
            return "\"" + android.util.Base64.encodeToString(((ByteArrayNode) this).getValue(), android.util.Base64.NO_WRAP) + "\"";
        }
        if (this instanceof ArrayNode) {
            StringBuilder sb = new StringBuilder("[");
            MPVNode[] array = ((ArrayNode) this).getValue();
            for (int i = 0; i < array.length; i++) {
                if (i > 0) sb.append(",");
                sb.append(array[i].toJson());
            }
            sb.append("]");
            return sb.toString();
        }
        if (this instanceof MapNode) {
            StringBuilder sb = new StringBuilder("{");
            Map<String, MPVNode> map = ((MapNode) this).getValue();
            boolean first = true;
            for (Map.Entry<String, MPVNode> entry : map.entrySet()) {
                if (!first) sb.append(",");
                first = false;
                sb.append("\"").append(entry.getKey()).append("\":").append(entry.getValue().toJson());
            }
            sb.append("}");
            return sb.toString();
        }
        return "null";
    }
}
