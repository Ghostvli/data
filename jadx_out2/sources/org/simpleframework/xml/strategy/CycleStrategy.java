package org.simpleframework.xml.strategy;

import java.util.Map;
import org.simpleframework.xml.stream.NodeMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class CycleStrategy implements Strategy {
    private final Contract contract;
    private final ReadState read;
    private final WriteState write;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CycleStrategy(String str, String str2, String str3, String str4) {
        Contract contract = new Contract(str, str2, str3, str4);
        this.contract = contract;
        this.write = new WriteState(contract);
        this.read = new ReadState(contract);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.strategy.Strategy
    public Value read(Type type, NodeMap nodeMap, Map map) {
        ReadGraph readGraphFind = this.read.find(map);
        if (readGraphFind != null) {
            return readGraphFind.read(type, nodeMap);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.strategy.Strategy
    public boolean write(Type type, Object obj, NodeMap nodeMap, Map map) {
        WriteGraph writeGraphFind = this.write.find(map);
        if (writeGraphFind != null) {
            return writeGraphFind.write(type, obj, nodeMap);
        }
        return false;
    }

    public CycleStrategy(String str, String str2) {
        this(str, str2, Name.LABEL);
    }

    public CycleStrategy(String str, String str2, String str3) {
        this(str, str2, str3, Name.LENGTH);
    }

    public CycleStrategy() {
        this(Name.MARK, Name.REFER);
    }
}
