package org.mozilla.javascript.ast;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class XmlElemRef extends XmlRef {
    private AstNode indexExpr;
    private int lb;
    private int rb;

    public XmlElemRef() {
        this.lb = -1;
        this.rb = -1;
        this.type = 85;
    }

    public AstNode getExpression() {
        return this.indexExpr;
    }

    public int getLb() {
        return this.lb;
    }

    public int getRb() {
        return this.rb;
    }

    public void setBrackets(int i, int i2) {
        this.lb = i;
        this.rb = i2;
    }

    public void setExpression(AstNode astNode) {
        assertNotNull(astNode);
        this.indexExpr = astNode;
        astNode.setParent(this);
    }

    public void setLb(int i) {
        this.lb = i;
    }

    public void setRb(int i) {
        this.rb = i;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        if (isAttributeAccess()) {
            sb.append("@");
        }
        Name name = this.namespace;
        if (name != null) {
            sb.append(name.toSource(0));
            sb.append("::");
        }
        sb.append("[");
        sb.append(this.indexExpr.toSource(0));
        sb.append("]");
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            Name name = this.namespace;
            if (name != null) {
                name.visit(nodeVisitor);
            }
            this.indexExpr.visit(nodeVisitor);
        }
    }

    public XmlElemRef(int i) {
        super(i);
        this.lb = -1;
        this.rb = -1;
        this.type = 85;
    }

    public XmlElemRef(int i, int i2) {
        super(i, i2);
        this.lb = -1;
        this.rb = -1;
        this.type = 85;
    }
}
