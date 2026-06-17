package org.mozilla.javascript;

import org.mozilla.javascript.Parser;
import org.mozilla.javascript.ast.AstNode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Parser.Transformer {
    public final /* synthetic */ IRFactory a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [org.mozilla.javascript.IRFactory.createAssignment(int, org.mozilla.javascript.Node, org.mozilla.javascript.Node):org.mozilla.javascript.Node, org.mozilla.javascript.IRFactory.createForIn(int, org.mozilla.javascript.Node, org.mozilla.javascript.Node, org.mozilla.javascript.Node, org.mozilla.javascript.Node, org.mozilla.javascript.ast.AstNode, boolean, boolean):org.mozilla.javascript.Node, org.mozilla.javascript.IRFactory.transformVariableInitializers(org.mozilla.javascript.ast.VariableDeclaration):org.mozilla.javascript.Node] */
    public /* synthetic */ c(IRFactory iRFactory) {
        this.a = iRFactory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Parser.Transformer
    public final Node transform(AstNode astNode) {
        return this.a.transform(astNode);
    }
}
