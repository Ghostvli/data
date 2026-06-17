package org.mozilla.javascript.ast;

import defpackage.b;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ObjectProperty extends InfixExpression {
    private boolean shorthand;

    public ObjectProperty() {
        this.type = Token.COLON;
    }

    public boolean isGetterMethod() {
        return this.type == 165;
    }

    public boolean isMethod() {
        return isGetterMethod() || isSetterMethod() || isNormalMethod();
    }

    public boolean isNormalMethod() {
        return this.type == 177;
    }

    public boolean isSetterMethod() {
        return this.type == 166;
    }

    public boolean isShorthand() {
        return this.shorthand;
    }

    public void setIsGetterMethod() {
        this.type = Token.GET;
    }

    public void setIsNormalMethod() {
        this.type = Token.METHOD;
    }

    public void setIsSetterMethod() {
        this.type = Token.SET;
    }

    public void setIsShorthand(boolean z) {
        this.shorthand = z;
    }

    public void setNodeType(int i) {
        if (i == 116 || i == 165 || i == 166 || i == 177) {
            setType(i);
        } else {
            b.a("invalid node type: ", i);
        }
    }

    @Override // org.mozilla.javascript.ast.InfixExpression, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = i + 1;
        sb.append(makeIndent(i2));
        if (isGetterMethod()) {
            sb.append("get ");
        } else if (isSetterMethod()) {
            sb.append("set ");
        }
        AstNode astNode = this.left;
        if (getType() == 116) {
            i = 0;
        }
        sb.append(astNode.toSource(i));
        if (!this.shorthand) {
            if (this.type == 116) {
                sb.append(": ");
            }
            AstNode astNode2 = this.right;
            if (getType() == 116) {
                i2 = 0;
            }
            sb.append(astNode2.toSource(i2));
        }
        return sb.toString();
    }

    public ObjectProperty(int i) {
        super(i);
        this.type = Token.COLON;
    }

    public ObjectProperty(int i, int i2) {
        super(i, i2);
        this.type = Token.COLON;
    }
}
