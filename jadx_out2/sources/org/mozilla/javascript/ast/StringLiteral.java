package org.mozilla.javascript.ast;

import org.mozilla.javascript.ScriptRuntime;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class StringLiteral extends AstNode {
    private char quoteChar;
    private String value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public StringLiteral() {
        this.type = 46;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public char getQuoteCharacter() {
        return this.quoteChar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getValue(boolean z) {
        if (!z) {
            return this.value;
        }
        char c = this.quoteChar;
        return c + this.value + c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setQuoteCharacter(char c) {
        this.quoteChar = c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setValue(String str) {
        assertNotNull(str);
        this.value = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        String strMakeIndent = makeIndent(i);
        char c = this.quoteChar;
        return strMakeIndent + c + ScriptRuntime.escapeString(this.value, c) + this.quoteChar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    public StringLiteral(int i) {
        super(i);
        this.type = 46;
    }

    public StringLiteral(int i, int i2) {
        super(i, i2);
        this.type = 46;
    }

    public String getValue() {
        return this.value;
    }
}
