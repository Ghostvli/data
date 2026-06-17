package org.simpleframework.xml.convert;

import java.util.Map;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RegistryStrategy implements Strategy {
    private final Registry registry;
    private final Strategy strategy;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RegistryStrategy(Registry registry) {
        this(registry, new TreeStrategy());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isReference(Value value) {
        return value != null && value.isReference();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Converter lookup(Type type, Value value) {
        Class type2 = type.getType();
        if (value != null) {
            type2 = value.getType();
        }
        return this.registry.lookup(type2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Value read(Type type, NodeMap<InputNode> nodeMap, Value value) {
        Converter converterLookup = lookup(type, value);
        InputNode inputNode = (InputNode) nodeMap.getNode();
        if (converterLookup == null) {
            return value;
        }
        Object obj = converterLookup.read(inputNode);
        Class type2 = type.getType();
        if (value != null) {
            value.setValue(obj);
        }
        return new Reference(value, obj, type2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean write(Type type, Object obj, NodeMap<OutputNode> nodeMap) {
        Converter converterLookup = lookup(type, obj);
        OutputNode outputNode = (OutputNode) nodeMap.getNode();
        if (converterLookup == null) {
            return false;
        }
        converterLookup.write(outputNode, obj);
        return true;
    }

    public RegistryStrategy(Registry registry, Strategy strategy) {
        this.registry = registry;
        this.strategy = strategy;
    }

    private Converter lookup(Type type, Object obj) {
        Class<?> type2 = type.getType();
        if (obj != null) {
            type2 = obj.getClass();
        }
        return this.registry.lookup(type2);
    }

    @Override // org.simpleframework.xml.strategy.Strategy
    public boolean write(Type type, Object obj, NodeMap<OutputNode> nodeMap, Map map) {
        boolean zWrite = this.strategy.write(type, obj, nodeMap, map);
        return !zWrite ? write(type, obj, nodeMap) : zWrite;
    }

    @Override // org.simpleframework.xml.strategy.Strategy
    public Value read(Type type, NodeMap<InputNode> nodeMap, Map map) {
        Value value = this.strategy.read(type, nodeMap, map);
        return isReference(value) ? value : read(type, nodeMap, value);
    }
}
