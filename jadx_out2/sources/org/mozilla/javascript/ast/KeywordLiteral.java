package org.mozilla.javascript.ast;

import defpackage.b;
import defpackage.jr1;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class KeywordLiteral extends AstNode {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public KeywordLiteral(int i, int i2, int i3) {
        super(i, i2);
        setType(i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isBooleanLiteral() {
        int i = this.type;
        return i == 50 || i == 49;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: setType(I)Lorg/mozilla/javascript/Node; */
    @Override // org.mozilla.javascript.Node
    public KeywordLiteral setType(int i) {
        if (i == 48 || i == 79 || i == 47 || i == 50 || i == 49 || i == 174) {
            this.type = i;
            return this;
        }
        b.a("Invalid node type: ", i);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        int type = getType();
        if (type == 79) {
            sb.append("super");
        } else if (type != 174) {
            switch (type) {
                case Token.NULL /* 47 */:
                    sb.append("null");
                    break;
                case 48:
                    sb.append("this");
                    break;
                case Token.FALSE /* 49 */:
                    sb.append("false");
                    break;
                case 50:
                    sb.append("true");
                    break;
                default:
                    jr1.a("Invalid keyword literal type: ", getType());
                    return null;
            }
        } else {
            sb.append("debugger;\n");
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    public KeywordLiteral(int i) {
        super(i);
    }

    public KeywordLiteral(int i, int i2) {
        super(i, i2);
    }

    public KeywordLiteral() {
    }
}
