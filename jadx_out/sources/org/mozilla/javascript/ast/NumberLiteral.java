package org.mozilla.javascript.ast;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NumberLiteral extends AstNode {
    private double number;
    private String value;

    public NumberLiteral(int i, String str) {
        super(i);
        this.type = 45;
        setValue(str);
        setLength(str.length());
    }

    public double getNumber() {
        return this.number;
    }

    public String getValue() {
        return this.value;
    }

    public void setNumber(double d) {
        this.number = d;
    }

    public void setValue(String str) {
        assertNotNull(str);
        this.value = str;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        String strMakeIndent = makeIndent(i);
        String str = this.value;
        if (str == null) {
            str = "<null>";
        }
        return strMakeIndent + str;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    public NumberLiteral(int i) {
        super(i);
        this.type = 45;
    }

    public NumberLiteral(int i, int i2) {
        super(i, i2);
        this.type = 45;
    }

    public NumberLiteral() {
        this.type = 45;
    }

    public NumberLiteral(int i, String str, double d) {
        this(i, str);
        setDouble(d);
    }

    public NumberLiteral(double d) {
        this.type = 45;
        setDouble(d);
        setValue(Double.toString(d));
    }
}
