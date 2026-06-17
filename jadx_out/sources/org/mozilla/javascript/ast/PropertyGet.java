package org.mozilla.javascript.ast;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PropertyGet extends InfixExpression {
    public PropertyGet(AstNode astNode, Name name) {
        super(astNode, name);
        this.type = 33;
        super.setLineColumnNumber(name.getLineno(), name.getColumn());
    }

    public Name getProperty() {
        return (Name) getRight();
    }

    public AstNode getTarget() {
        return getLeft();
    }

    public void setProperty(Name name) {
        setRight(name);
    }

    public void setTarget(AstNode astNode) {
        setLeft(astNode);
    }

    @Override // org.mozilla.javascript.ast.InfixExpression, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + getLeft().toSource(0) + "." + getRight().toSource(0);
    }

    @Override // org.mozilla.javascript.ast.InfixExpression, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            getTarget().visit(nodeVisitor);
            getProperty().visit(nodeVisitor);
        }
    }

    public PropertyGet(int i) {
        super(i);
        this.type = 33;
    }

    public PropertyGet(int i, int i2) {
        super(i, i2);
        this.type = 33;
    }

    public PropertyGet(int i, int i2, AstNode astNode, Name name) {
        super(i, i2, astNode, name);
        this.type = 33;
    }

    public PropertyGet() {
        this.type = 33;
    }

    public PropertyGet(AstNode astNode, Name name, int i) {
        super(33, astNode, name, i);
        this.type = 33;
        super.setLineColumnNumber(name.getLineno(), name.getColumn());
    }
}
