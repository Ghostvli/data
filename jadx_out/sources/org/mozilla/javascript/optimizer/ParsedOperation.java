package org.mozilla.javascript.optimizer;

import defpackage.fn;
import jdk.dynalink.NamedOperation;
import jdk.dynalink.Namespace;
import jdk.dynalink.NamespaceOperation;
import jdk.dynalink.Operation;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class ParsedOperation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final String name;
    private final Namespace namespace;
    private final Operation operation;
    private final Operation root;

    public ParsedOperation(Operation operation) {
        this.root = operation;
        Object name = NamedOperation.getName(operation);
        if (name instanceof String) {
            this.name = (String) name;
        } else {
            if (name != null) {
                fn.a(operation.toString());
                throw null;
            }
            this.name = "";
        }
        NamespaceOperation baseOperation = NamedOperation.getBaseOperation(operation);
        this.namespace = baseOperation.getNamespace(0);
        this.operation = baseOperation.getBaseOperation();
    }

    public String getName() {
        return this.name;
    }

    public boolean isNamespace(Namespace namespace) {
        return namespace.equals(this.namespace);
    }

    public boolean isOperation(Operation operation, Operation operation2) {
        return operation.equals(this.operation) || operation2.equals(this.operation);
    }

    public String toString() {
        return this.root.toString();
    }

    public boolean isOperation(Operation operation) {
        return operation.equals(this.operation);
    }
}
