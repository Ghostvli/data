package org.mozilla.javascript.ast;

import defpackage.b;
import defpackage.jl;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jupnp.model.ServiceReference;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AstNode extends Node implements Comparable<AstNode> {
    private static final String[] INDENTATIONS;
    private static final int MAX_INDENT = 42;
    private static final Map<Integer, String> operatorNames;
    protected AstNode inlineComment;
    protected int length;
    protected AstNode parent;
    protected int position;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class DebugPrintVisitor implements NodeVisitor {
        private static final int DEBUG_INDENT = 2;
        private StringBuilder buffer;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public DebugPrintVisitor(StringBuilder sb) {
            this.buffer = sb;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private static String makeIndent(int i) {
            int i2 = i * 2;
            StringBuilder sb = new StringBuilder(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(" ");
            }
            return sb.toString();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return this.buffer.toString();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.mozilla.javascript.ast.NodeVisitor
        public boolean visit(AstNode astNode) {
            int type = astNode.getType();
            String strTypeToName = Token.typeToName(type);
            StringBuilder sb = this.buffer;
            sb.append(astNode.getAbsolutePosition());
            sb.append("\t");
            this.buffer.append(makeIndent(astNode.depth()));
            StringBuilder sb2 = this.buffer;
            sb2.append(strTypeToName);
            sb2.append(" ");
            StringBuilder sb3 = this.buffer;
            sb3.append(astNode.getPosition());
            sb3.append(" ");
            this.buffer.append(astNode.getLength());
            if (type == 44) {
                StringBuilder sb4 = this.buffer;
                sb4.append(" ");
                sb4.append(((Name) astNode).getIdentifier());
            } else if (type == 46) {
                StringBuilder sb5 = this.buffer;
                sb5.append(" ");
                sb5.append(((StringLiteral) astNode).getValue(true));
            }
            this.buffer.append("\n");
            return true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        HashMap map = new HashMap();
        operatorNames = map;
        String[] strArr = new String[43];
        INDENTATIONS = strArr;
        map.put(57, "in");
        map.put(32, "typeof");
        map.put(58, "instanceof");
        map.put(31, "delete");
        map.put(98, ",");
        map.put(Integer.valueOf(Token.COLON), ":");
        map.put(Integer.valueOf(Token.OR), "||");
        map.put(Integer.valueOf(Token.NULLISH_COALESCING), "??");
        map.put(Integer.valueOf(Token.QUESTION_DOT), "?.");
        map.put(Integer.valueOf(Token.AND), "&&");
        map.put(Integer.valueOf(Token.INC), "++");
        map.put(120, "--");
        map.put(9, "|");
        map.put(10, "^");
        map.put(11, "&");
        map.put(12, "==");
        map.put(13, "!=");
        map.put(14, "<");
        map.put(16, ">");
        map.put(15, "<=");
        map.put(17, ">=");
        map.put(18, "<<");
        map.put(19, ">>");
        map.put(20, ">>>");
        map.put(21, "+");
        map.put(22, "-");
        map.put(23, "*");
        map.put(24, ServiceReference.DELIMITER);
        map.put(25, "%");
        map.put(81, "**");
        map.put(26, "!");
        map.put(27, "~");
        map.put(28, "+");
        map.put(29, "-");
        map.put(51, "===");
        map.put(52, "!==");
        map.put(99, "=");
        map.put(100, "|=");
        map.put(101, "||=");
        map.put(103, "&=");
        map.put(Integer.valueOf(Token.ASSIGN_LOGICAL_AND), "&&=");
        map.put(Integer.valueOf(Token.ASSIGN_LSH), "<<=");
        map.put(Integer.valueOf(Token.ASSIGN_RSH), ">>=");
        map.put(Integer.valueOf(Token.ASSIGN_URSH), ">>>=");
        map.put(Integer.valueOf(Token.ASSIGN_ADD), "+=");
        map.put(Integer.valueOf(Token.ASSIGN_SUB), "-=");
        map.put(110, "*=");
        map.put(Integer.valueOf(Token.ASSIGN_DIV), "/=");
        map.put(Integer.valueOf(Token.ASSIGN_MOD), "%=");
        map.put(102, "^=");
        map.put(Integer.valueOf(Token.ASSIGN_EXP), "**=");
        map.put(114, "??=");
        map.put(Integer.valueOf(Token.VOID), "void");
        StringBuilder sb = new StringBuilder();
        strArr[0] = "";
        for (int i = 1; i <= 42; i++) {
            sb.append("  ");
            INDENTATIONS[i] = sb.toString();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AstNode() {
        super(-1);
        this.position = -1;
        this.length = 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static RuntimeException codeBug() {
        throw Kit.codeBug();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String operatorToString(int i) {
        String str = operatorNames.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        b.a("Invalid operator: ", i);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void addChild(AstNode astNode) {
        assertNotNull(astNode);
        setLength((astNode.getPosition() + astNode.getLength()) - getPosition());
        addChildToBack(astNode);
        astNode.setParent(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void assertNotNull(Object obj) {
        if (obj != null) {
            return;
        }
        jl.a("arg cannot be null");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: compareTo(Ljava/lang/Object;)I */
    @Override // java.lang.Comparable
    public int compareTo(AstNode astNode) {
        if (equals(astNode)) {
            return 0;
        }
        int absolutePosition = getAbsolutePosition();
        int absolutePosition2 = astNode.getAbsolutePosition();
        if (absolutePosition < absolutePosition2) {
            return -1;
        }
        if (absolutePosition2 < absolutePosition) {
            return 1;
        }
        int length = getLength();
        int length2 = astNode.getLength();
        if (length < length2) {
            return -1;
        }
        if (length2 < length) {
            return 1;
        }
        return hashCode() - astNode.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String debugPrint() {
        DebugPrintVisitor debugPrintVisitor = new DebugPrintVisitor(new StringBuilder(1000));
        visit(debugPrintVisitor);
        return debugPrintVisitor.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int depth() {
        AstNode astNode = this.parent;
        if (astNode == null) {
            return 0;
        }
        return astNode.depth() + 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getAbsolutePosition() {
        int position = this.position;
        for (AstNode parent = this.parent; parent != null; parent = parent.getParent()) {
            position += parent.getPosition();
        }
        return position;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AstRoot getAstRoot() {
        while (this != null && !(this instanceof AstRoot)) {
            this = this.getParent();
        }
        return (AstRoot) this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FunctionNode getEnclosingFunction() {
        AstNode parent = getParent();
        while (parent != null && !(parent instanceof FunctionNode)) {
            parent = parent.getParent();
        }
        return (FunctionNode) parent;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Scope getEnclosingScope() {
        AstNode parent = getParent();
        while (parent != null && !(parent instanceof Scope)) {
            parent = parent.getParent();
        }
        return (Scope) parent;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AstNode getInlineComment() {
        return this.inlineComment;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getLength() {
        return this.length;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Node
    public int getLineno() {
        int i = this.lineno;
        if (i != -1) {
            return i;
        }
        AstNode astNode = this.parent;
        if (astNode != null) {
            return astNode.getLineno();
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AstNode getParent() {
        return this.parent;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getPosition() {
        return this.position;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Node
    public boolean hasSideEffects() {
        int type = getType();
        if (type == 30 || type == 31 || type == 55 || type == 56 || type == 61 || type == 62 || type == 90 || type == 91 || type == 119 || type == 120) {
            return true;
        }
        switch (type) {
            case -1:
            case Token.SETPROP /* 37 */:
            case Token.SETELEM /* 41 */:
            case Token.CALL /* 43 */:
            case 70:
            case Token.YIELD /* 78 */:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case Token.ASSIGN_LOGICAL_AND /* 104 */:
            case Token.ASSIGN_LSH /* 105 */:
            case Token.ASSIGN_RSH /* 106 */:
            case Token.ASSIGN_URSH /* 107 */:
            case Token.ASSIGN_ADD /* 108 */:
            case Token.ASSIGN_SUB /* 109 */:
            case 110:
            case Token.ASSIGN_DIV /* 111 */:
            case Token.ASSIGN_MOD /* 112 */:
            case Token.ASSIGN_EXP /* 113 */:
            case 114:
            case Token.BLOCK /* 143 */:
            case Token.LABEL /* 144 */:
            case Token.TARGET /* 145 */:
            case Token.LOOP /* 146 */:
            case Token.EXPR_RESULT /* 148 */:
            case Token.JSR /* 149 */:
            case Token.SETPROP_OP /* 153 */:
            case Token.SETELEM_OP /* 154 */:
            case Token.LOCAL_BLOCK /* 155 */:
            case Token.SET_REF_OP /* 156 */:
            case Token.LET /* 167 */:
            case Token.CONST /* 168 */:
            case Token.LETEXPR /* 172 */:
            case Token.WITHEXPR /* 173 */:
            case Token.YIELD_STAR /* 179 */:
                return true;
            default:
                switch (type) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        return true;
                    default:
                        switch (type) {
                            case Token.SET_REF /* 74 */:
                            case Token.DEL_REF /* 75 */:
                            case Token.REF_CALL /* 76 */:
                                return true;
                            default:
                                switch (type) {
                                    case Token.FUNCTION /* 122 */:
                                    case Token.EXPORT /* 123 */:
                                    case Token.IMPORT /* 124 */:
                                    case Token.IF /* 125 */:
                                    case 126:
                                    case 127:
                                        return true;
                                    default:
                                        switch (type) {
                                            case 130:
                                            case Token.DO /* 131 */:
                                            case Token.FOR /* 132 */:
                                            case Token.BREAK /* 133 */:
                                            case Token.CONTINUE /* 134 */:
                                            case Token.VAR /* 135 */:
                                            case Token.WITH /* 136 */:
                                            case Token.CATCH /* 137 */:
                                            case Token.FINALLY /* 138 */:
                                                return true;
                                            default:
                                                return false;
                                        }
                                }
                        }
                }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String makeIndent(int i) {
        return INDENTATIONS[Math.min(42, Math.max(0, i))];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <T extends AstNode> void printList(List<T> list, StringBuilder sb) {
        int size = list.size();
        int i = 0;
        for (T t : list) {
            sb.append(t.toSource(0));
            int i2 = i + 1;
            if (i < size - 1) {
                sb.append(", ");
            } else if (t instanceof EmptyExpression) {
                sb.append(",");
            }
            i = i2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setBounds(int i, int i2) {
        setPosition(i);
        setLength(i2 - i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setInlineComment(AstNode astNode) {
        this.inlineComment = astNode;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setLength(int i) {
        this.length = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setParent(AstNode astNode) {
        AstNode astNode2 = this.parent;
        if (astNode == astNode2) {
            return;
        }
        if (astNode2 != null) {
            setRelative(-astNode2.getAbsolutePosition());
        }
        this.parent = astNode;
        if (astNode != null) {
            setRelative(astNode.getAbsolutePosition());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPosition(int i) {
        this.position = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setRelative(int i) {
        this.position -= i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String shortName() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf(".") + 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toSource() {
        return toSource(0);
    }

    public abstract String toSource(int i);

    public abstract void visit(NodeVisitor nodeVisitor);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class PositionComparator implements Comparator<AstNode>, Serializable {
        private static final long serialVersionUID = 1;

        /* JADX DEBUG: Method merged with bridge method: compare(Ljava/lang/Object;Ljava/lang/Object;)I */
        @Override // java.util.Comparator
        public int compare(AstNode astNode, AstNode astNode2) {
            return astNode.position - astNode2.position;
        }
    }

    public AstNode(int i) {
        this();
        this.position = i;
    }

    public AstNode(int i, int i2) {
        this();
        this.position = i;
        this.length = i2;
    }
}
