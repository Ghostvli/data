package org.mozilla.javascript;

import defpackage.e04;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.XMLConstants;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.ArrayComprehension;
import org.mozilla.javascript.ast.ArrayLiteral;
import org.mozilla.javascript.ast.Assignment;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.BigIntLiteral;
import org.mozilla.javascript.ast.Block;
import org.mozilla.javascript.ast.BreakStatement;
import org.mozilla.javascript.ast.Comment;
import org.mozilla.javascript.ast.ComputedPropertyKey;
import org.mozilla.javascript.ast.ConditionalExpression;
import org.mozilla.javascript.ast.ContinueStatement;
import org.mozilla.javascript.ast.DestructuringForm;
import org.mozilla.javascript.ast.DoLoop;
import org.mozilla.javascript.ast.ElementGet;
import org.mozilla.javascript.ast.EmptyExpression;
import org.mozilla.javascript.ast.EmptyStatement;
import org.mozilla.javascript.ast.ErrorNode;
import org.mozilla.javascript.ast.ExpressionStatement;
import org.mozilla.javascript.ast.ForInLoop;
import org.mozilla.javascript.ast.ForLoop;
import org.mozilla.javascript.ast.FunctionCall;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.GeneratorExpression;
import org.mozilla.javascript.ast.GeneratorExpressionLoop;
import org.mozilla.javascript.ast.GeneratorMethodDefinition;
import org.mozilla.javascript.ast.IdeErrorReporter;
import org.mozilla.javascript.ast.IfStatement;
import org.mozilla.javascript.ast.InfixExpression;
import org.mozilla.javascript.ast.Jump;
import org.mozilla.javascript.ast.Label;
import org.mozilla.javascript.ast.LabeledStatement;
import org.mozilla.javascript.ast.LetNode;
import org.mozilla.javascript.ast.Loop;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.NewExpression;
import org.mozilla.javascript.ast.NumberLiteral;
import org.mozilla.javascript.ast.ObjectLiteral;
import org.mozilla.javascript.ast.ObjectProperty;
import org.mozilla.javascript.ast.ParenthesizedExpression;
import org.mozilla.javascript.ast.PropertyGet;
import org.mozilla.javascript.ast.ReturnStatement;
import org.mozilla.javascript.ast.Scope;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.ast.StringLiteral;
import org.mozilla.javascript.ast.SwitchCase;
import org.mozilla.javascript.ast.SwitchStatement;
import org.mozilla.javascript.ast.TaggedTemplateLiteral;
import org.mozilla.javascript.ast.TemplateCharacters;
import org.mozilla.javascript.ast.TemplateLiteral;
import org.mozilla.javascript.ast.ThrowStatement;
import org.mozilla.javascript.ast.UnaryExpression;
import org.mozilla.javascript.ast.UpdateExpression;
import org.mozilla.javascript.ast.VariableDeclaration;
import org.mozilla.javascript.ast.VariableInitializer;
import org.mozilla.javascript.ast.WhileLoop;
import org.mozilla.javascript.ast.WithStatement;
import org.mozilla.javascript.ast.XmlDotQuery;
import org.mozilla.javascript.ast.XmlElemRef;
import org.mozilla.javascript.ast.XmlExpression;
import org.mozilla.javascript.ast.XmlLiteral;
import org.mozilla.javascript.ast.XmlMemberGet;
import org.mozilla.javascript.ast.XmlPropRef;
import org.mozilla.javascript.ast.XmlRef;
import org.mozilla.javascript.ast.XmlString;
import org.mozilla.javascript.ast.Yield;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Parser {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ARGC_LIMIT = 65536;
    static final int CLEAR_TI_MASK = 65535;
    private static final int GET_ENTRY = 2;
    private static final int METHOD_ENTRY = 8;
    private static final int PROP_ENTRY = 1;
    private static final int SET_ENTRY = 4;
    static final int TI_AFTER_EOL = 65536;
    static final int TI_CHECK_LABEL = 131072;
    boolean calledByCompileFunction;
    CompilerEnvirons compilerEnv;
    private int currentFlaggedToken;
    private Comment currentJsDocComment;
    private LabeledStatement currentLabel;
    CurrentPositionReporter currentPos;
    Scope currentScope;
    ScriptNode currentScriptOrFn;
    private int currentToken;
    private boolean defaultUseStrictDirective;
    private int endFlags;
    private IdeErrorReporter errorCollector;
    private ErrorReporter errorReporter;
    private boolean inDestructuringAssignment;
    private boolean inForInit;
    protected boolean inUseStrictDirective;
    private boolean insideMethod;
    private Map<String, LabeledStatement> labelSet;
    private int lastTokenColumn;
    private int lastTokenLineno;
    private List<Jump> loopAndSwitchSet;
    private List<Loop> loopSet;
    protected int nestingOfFunction;
    protected int nestingOfFunctionParams;
    private boolean parseFinished;
    private int prevNameTokenColumn;
    private int prevNameTokenLineno;
    private int prevNameTokenStart;
    private String prevNameTokenString;
    private List<Comment> scannedComments;
    private char[] sourceChars;
    private String sourceURI;
    private int syntaxErrorCount;
    private TokenStream ts;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class ConditionData {
        AstNode condition;
        int lp;
        int rp;

        private ConditionData() {
            this.lp = -1;
            this.rp = -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface CurrentPositionReporter {
        int getLength();

        String getLine();

        int getLineno();

        int getOffset();

        int getPosition();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class ParserException extends RuntimeException {
        private static final long serialVersionUID = 5882582646773765630L;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class PerFunctionVariables {
        private Scope savedCurrentScope;
        private ScriptNode savedCurrentScriptOrFn;
        private int savedEndFlags;
        private boolean savedInForInit;
        private Map<String, LabeledStatement> savedLabelSet;
        private List<Jump> savedLoopAndSwitchSet;
        private List<Loop> savedLoopSet;

        public PerFunctionVariables(FunctionNode functionNode) {
            this.savedCurrentScriptOrFn = Parser.this.currentScriptOrFn;
            Parser.this.currentScriptOrFn = functionNode;
            this.savedCurrentScope = Parser.this.currentScope;
            Parser.this.currentScope = functionNode;
            this.savedLabelSet = Parser.this.labelSet;
            Parser.this.labelSet = null;
            this.savedLoopSet = Parser.this.loopSet;
            Parser.this.loopSet = null;
            this.savedLoopAndSwitchSet = Parser.this.loopAndSwitchSet;
            Parser.this.loopAndSwitchSet = null;
            this.savedEndFlags = Parser.this.endFlags;
            Parser.this.endFlags = 0;
            this.savedInForInit = Parser.this.inForInit;
            Parser.this.inForInit = false;
        }

        public void restore() {
            Parser parser = Parser.this;
            parser.currentScriptOrFn = this.savedCurrentScriptOrFn;
            parser.currentScope = this.savedCurrentScope;
            parser.labelSet = this.savedLabelSet;
            Parser.this.loopSet = this.savedLoopSet;
            Parser.this.loopAndSwitchSet = this.savedLoopAndSwitchSet;
            Parser.this.endFlags = this.savedEndFlags;
            Parser.this.inForInit = this.savedInForInit;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface Transformer {
        Node transform(AstNode astNode);
    }

    public Parser(CompilerEnvirons compilerEnvirons, ErrorReporter errorReporter) {
        this.currentFlaggedToken = 0;
        this.prevNameTokenString = "";
        this.lastTokenLineno = -1;
        this.lastTokenColumn = -1;
        this.compilerEnv = compilerEnvirons;
        this.errorReporter = errorReporter;
        if (errorReporter instanceof IdeErrorReporter) {
            this.errorCollector = (IdeErrorReporter) errorReporter;
        }
    }

    private AstNode addExpr() {
        AstNode astNodeMulExpr = mulExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            if (iPeekToken != 21 && iPeekToken != 22) {
                return astNodeMulExpr;
            }
            consumeToken();
            astNodeMulExpr = new InfixExpression(iPeekToken, astNodeMulExpr, mulExpr(), i);
        }
    }

    private AstNode andExpr() {
        AstNode astNodeBitOrExpr = bitOrExpr();
        if (!matchToken(Token.AND, true)) {
            return astNodeBitOrExpr;
        }
        return new InfixExpression(Token.AND, astNodeBitOrExpr, andExpr(), this.ts.tokenBeg);
    }

    /* JADX WARN: Finally extract failed */
    private List<AstNode> argumentList() {
        if (matchToken(97, true)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = this.inForInit;
        this.inForInit = false;
        do {
            try {
                if (peekToken() == 97) {
                    break;
                }
                if (peekToken() == 78) {
                    reportError("msg.yield.parenthesized");
                }
                AstNode astNodeAssignExpr = assignExpr();
                if (peekToken() == 132) {
                    try {
                        arrayList.add(generatorExpression(astNodeAssignExpr, 0, true));
                    } catch (IOException unused) {
                    }
                } else {
                    arrayList.add(astNodeAssignExpr);
                }
            } catch (Throwable th) {
                this.inForInit = z;
                throw th;
            }
        } while (matchToken(98, true));
        this.inForInit = z;
        mustMatchToken(97, "msg.no.paren.arg", true);
        return arrayList;
    }

    private AstNode arrayComprehension(AstNode astNode, int i) {
        int i2;
        ConditionData conditionDataCondition;
        ArrayList arrayList = new ArrayList();
        while (peekToken() == 132) {
            arrayList.add(arrayComprehensionLoop());
        }
        if (peekToken() == 125) {
            consumeToken();
            i2 = this.ts.tokenBeg - i;
            conditionDataCondition = condition();
        } else {
            i2 = -1;
            conditionDataCondition = null;
        }
        mustMatchToken(93, "msg.no.bracket.arg", true);
        ArrayComprehension arrayComprehension = new ArrayComprehension(i, this.ts.tokenEnd - i);
        arrayComprehension.setResult(astNode);
        arrayComprehension.setLoops(arrayList);
        if (conditionDataCondition != null) {
            arrayComprehension.setIfPosition(i2);
            arrayComprehension.setFilter(conditionDataCondition.condition);
            arrayComprehension.setFilterLp(conditionDataCondition.lp - i);
            arrayComprehension.setFilterRp(conditionDataCondition.rp - i);
        }
        return arrayComprehension;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00c6 A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:6:0x001a, B:9:0x0023, B:11:0x0031, B:16:0x003e, B:18:0x0046, B:20:0x004d, B:26:0x005b, B:29:0x0071, B:31:0x0077, B:32:0x0082, B:44:0x00b1, B:45:0x00b8, B:47:0x00c6, B:49:0x00cd, B:53:0x00e5, B:37:0x008e, B:39:0x0095, B:42:0x00a5, B:43:0x00aa, B:27:0x0062, B:28:0x006a, B:14:0x003a), top: B:58:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.ast.ArrayComprehensionLoop arrayComprehensionLoop() {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.arrayComprehensionLoop():org.mozilla.javascript.ast.ArrayComprehensionLoop");
    }

    private AstNode arrayLiteral() {
        if (this.currentToken != 92) {
            codeBug();
        }
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        int i2 = tokenStream.tokenEnd;
        int iLineNumber = lineNumber();
        int iColumnNumber = columnNumber();
        ArrayList arrayList = new ArrayList();
        ArrayLiteral arrayLiteral = new ArrayLiteral(i);
        int i3 = 0;
        int i4 = -1;
        loop0: while (true) {
            int i5 = 1;
            while (true) {
                int iPeekToken = peekToken();
                if (iPeekToken == 98) {
                    consumeToken();
                    i4 = this.ts.tokenEnd;
                    if (i5 == 0) {
                        break;
                    }
                    arrayList.add(new EmptyExpression(this.ts.tokenBeg, 1));
                    i3++;
                } else if (iPeekToken == 175) {
                    consumeToken();
                } else if (iPeekToken == 93) {
                    consumeToken();
                    i2 = this.ts.tokenEnd;
                    arrayLiteral.setDestructuringLength(arrayList.size() + i5);
                    arrayLiteral.setSkipCount(i3);
                    if (i4 != -1) {
                        warnTrailingComma(i, arrayList, i4);
                    }
                } else {
                    if (iPeekToken == 132 && i5 == 0 && arrayList.size() == 1) {
                        return arrayComprehension((AstNode) arrayList.get(0), i);
                    }
                    if (iPeekToken == 0) {
                        reportError("msg.no.bracket.arg");
                        break loop0;
                    }
                    if (i5 == 0) {
                        reportError("msg.no.bracket.arg");
                    }
                    arrayList.add(assignExpr());
                    i5 = 0;
                    i4 = -1;
                }
            }
        }
        Iterator<?> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayLiteral.addElement((AstNode) it.next());
        }
        arrayLiteral.setLength(i2 - i);
        arrayLiteral.setLineColumnNumber(iLineNumber, iColumnNumber);
        return arrayLiteral;
    }

    private AstNode arrowFunction(AstNode astNode, int i, int i2) {
        Parser parser;
        int iLineNumber = lineNumber();
        int position = astNode != null ? astNode.getPosition() : -1;
        FunctionNode functionNode = new FunctionNode(position);
        functionNode.setFunctionType(4);
        functionNode.setJsDocNode(getAndResetJsDoc());
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashSet hashSet = new HashSet();
        PerFunctionVariables perFunctionVariables = new PerFunctionVariables(functionNode);
        try {
            if (astNode instanceof ParenthesizedExpression) {
                functionNode.setParens(0, astNode.getLength());
                if (astNode.getIntProp(28, 0) == 1) {
                    functionNode.putIntProp(28, 1);
                }
                AstNode expression = ((ParenthesizedExpression) astNode).getExpression();
                if (expression instanceof EmptyExpression) {
                    parser = this;
                } else {
                    parser = this;
                    parser.arrowFunctionParams(functionNode, expression, map, map2, hashSet);
                }
            } else {
                parser = this;
                parser.arrowFunctionParams(functionNode, astNode, map, map2, hashSet);
            }
            if (!map.isEmpty()) {
                Node node = new Node(98);
                for (Map.Entry entry : map.entrySet()) {
                    node.addChildToBack(parser.createDestructuringAssignment(Token.VAR, (Node) entry.getValue(), parser.createName((String) entry.getKey()), (AstNode) map2.get(entry.getKey())));
                }
                functionNode.putProp(23, node);
            }
            AstNode functionBody = parser.parseFunctionBody(4, functionNode);
            functionNode.setBody(functionBody);
            int position2 = functionBody.getPosition() + position + functionBody.getLength();
            functionNode.setRawSourceBounds(position, position2);
            functionNode.setLength(position2 - position);
            perFunctionVariables.restore();
            if (functionNode.isGenerator()) {
                parser.reportError("msg.arrowfunction.generator");
                return parser.makeErrorNode();
            }
            functionNode.setSourceName(parser.sourceURI);
            functionNode.setBaseLineno(iLineNumber);
            functionNode.setEndLineno(parser.lineNumber());
            functionNode.setLineColumnNumber(i, i2);
            return functionNode;
        } catch (Throwable th) {
            perFunctionVariables.restore();
            throw th;
        }
    }

    private void arrowFunctionParams(FunctionNode functionNode, AstNode astNode, Map<String, Node> map, Map<String, AstNode> map2, Set<String> set) {
        if ((astNode instanceof ArrayLiteral) || (astNode instanceof ObjectLiteral)) {
            markDestructuring(astNode);
            functionNode.addParam(astNode);
            String nextTempName = this.currentScriptOrFn.getNextTempName();
            defineSymbol(96, nextTempName, false);
            map.put(nextTempName, astNode);
            return;
        }
        if ((astNode instanceof InfixExpression) && astNode.getType() == 98) {
            InfixExpression infixExpression = (InfixExpression) astNode;
            arrowFunctionParams(functionNode, infixExpression.getLeft(), map, map2, set);
            arrowFunctionParams(functionNode, infixExpression.getRight(), map, map2, set);
            return;
        }
        if (astNode instanceof Name) {
            functionNode.addParam(astNode);
            String identifier = ((Name) astNode).getIdentifier();
            defineSymbol(96, identifier);
            if (this.inUseStrictDirective) {
                if ("eval".equals(identifier) || "arguments".equals(identifier)) {
                    reportError("msg.bad.id.strict", identifier);
                }
                if (set.contains(identifier)) {
                    addError("msg.dup.param.strict", identifier);
                }
                set.add(identifier);
                return;
            }
            return;
        }
        if (!(astNode instanceof Assignment)) {
            reportError("msg.no.parm", astNode.getPosition(), astNode.getLength());
            functionNode.addParam(makeErrorNode());
            return;
        }
        if (this.compilerEnv.getLanguageVersion() < 200) {
            reportError("msg.default.args");
            return;
        }
        Assignment assignment = (Assignment) astNode;
        AstNode right = assignment.getRight();
        AstNode left = assignment.getLeft();
        if (left instanceof Name) {
            functionNode.putDefaultParams(((Name) left).getIdentifier(), right);
            arrowFunctionParams(functionNode, left, map, map2, set);
            return;
        }
        if (!(left instanceof ArrayLiteral) && !(left instanceof ObjectLiteral)) {
            reportError("msg.no.parm", astNode.getPosition(), astNode.getLength());
            functionNode.addParam(makeErrorNode());
            return;
        }
        markDestructuring(left);
        functionNode.addParam(left);
        String nextTempName2 = this.currentScriptOrFn.getNextTempName();
        defineSymbol(96, nextTempName2, false);
        map.put(nextTempName2, left);
        map2.put(nextTempName2, right);
    }

    private AstNode assignExpr() {
        boolean z;
        int iPeekToken = peekToken();
        if (iPeekToken == 78) {
            return returnOrYield(iPeekToken, true);
        }
        TokenStream tokenStream = this.ts;
        int i = tokenStream.lineno;
        int tokenColumn = tokenStream.getTokenColumn();
        AstNode astNodeCondExpr = condExpr();
        int iPeekTokenOrEOL = peekTokenOrEOL();
        if (iPeekTokenOrEOL == 1) {
            iPeekTokenOrEOL = peekToken();
            z = true;
        } else {
            z = false;
        }
        if (99 <= iPeekTokenOrEOL && iPeekTokenOrEOL <= 114) {
            consumeToken();
            Comment andResetJsDoc = getAndResetJsDoc();
            markDestructuring(astNodeCondExpr);
            int i2 = this.ts.tokenBeg;
            if (isNotValidSimpleAssignmentTarget(astNodeCondExpr)) {
                reportError("msg.syntax.invalid.assignment.lhs");
            }
            Assignment assignment = new Assignment(iPeekTokenOrEOL, astNodeCondExpr, assignExpr(), i2);
            if (andResetJsDoc != null) {
                assignment.setJsDocNode(andResetJsDoc);
            }
            return assignment;
        }
        if (iPeekTokenOrEOL == 91) {
            if (this.currentJsDocComment != null) {
                astNodeCondExpr.setJsDocNode(getAndResetJsDoc());
                return astNodeCondExpr;
            }
        } else {
            if (!z && iPeekTokenOrEOL == 178) {
                consumeToken();
                return arrowFunction(astNodeCondExpr, i, tokenColumn);
            }
            if (astNodeCondExpr.getIntProp(29, 0) == 1 && !this.inDestructuringAssignment) {
                reportError("msg.syntax");
            }
        }
        return astNodeCondExpr;
    }

    private AstNode attributeAccess() {
        int iNextToken = nextToken();
        int i = this.ts.tokenBeg;
        if (iNextToken == 23) {
            saveNameTokenData(i, "*", lineNumber(), columnNumber());
            return propertyName(i, 0);
        }
        if (iNextToken == 44) {
            return propertyName(i, 0);
        }
        if (iNextToken == 92) {
            return xmlElemRef(i, null, -1);
        }
        reportError("msg.no.name.after.xmlAttr");
        return makeErrorNode();
    }

    private void autoInsertSemicolon(AstNode astNode) {
        int iPeekFlaggedToken = peekFlaggedToken();
        int position = astNode.getPosition();
        int i = 65535 & iPeekFlaggedToken;
        if (i != -1 && i != 0) {
            if (i == 91) {
                consumeToken();
                astNode.setLength(this.ts.tokenEnd - position);
                return;
            } else if (i != 95) {
                if ((iPeekFlaggedToken & 65536) == 0) {
                    reportError("msg.no.semi.stmt");
                    return;
                } else {
                    warnMissingSemi(position, nodeEnd(astNode));
                    return;
                }
            }
        }
        warnMissingSemi(position, Math.max(position + 1, nodeEnd(astNode)));
    }

    private AstNode bitAndExpr() {
        AstNode astNodeEqExpr = eqExpr();
        while (matchToken(11, true)) {
            astNodeEqExpr = new InfixExpression(11, astNodeEqExpr, eqExpr(), this.ts.tokenBeg);
        }
        return astNodeEqExpr;
    }

    private AstNode bitOrExpr() {
        AstNode astNodeBitXorExpr = bitXorExpr();
        while (matchToken(9, true)) {
            astNodeBitXorExpr = new InfixExpression(9, astNodeBitXorExpr, bitXorExpr(), this.ts.tokenBeg);
        }
        return astNodeBitXorExpr;
    }

    private AstNode bitXorExpr() {
        AstNode astNodeBitAndExpr = bitAndExpr();
        while (matchToken(10, true)) {
            astNodeBitAndExpr = new InfixExpression(10, astNodeBitAndExpr, bitAndExpr(), this.ts.tokenBeg);
        }
        return astNodeBitAndExpr;
    }

    private AstNode block() {
        if (this.currentToken != 94) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        Scope scope = new Scope(i);
        scope.setLineColumnNumber(lineNumber(), columnNumber());
        pushScope(scope);
        try {
            statements(scope);
            mustMatchToken(95, "msg.no.brace.block", true);
            scope.setLength(this.ts.tokenEnd - i);
            return scope;
        } finally {
            popScope();
        }
    }

    private BreakStatement breakStatement() {
        int nodeEnd;
        Name nameCreateNameNode;
        if (this.currentToken != 133) {
            codeBug();
        }
        consumeToken();
        int iLineNumber = lineNumber();
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        int i2 = tokenStream.tokenEnd;
        int iColumnNumber = columnNumber();
        if (peekTokenOrEOL() == 44) {
            nameCreateNameNode = createNameNode();
            nodeEnd = getNodeEnd(nameCreateNameNode);
        } else {
            nodeEnd = i2;
            nameCreateNameNode = null;
        }
        LabeledStatement labeledStatementMatchJumpLabelName = matchJumpLabelName();
        Jump firstLabel = labeledStatementMatchJumpLabelName != null ? labeledStatementMatchJumpLabelName.getFirstLabel() : null;
        if (firstLabel == null && nameCreateNameNode == null) {
            List<Jump> list = this.loopAndSwitchSet;
            if (list == null || list.size() == 0) {
                reportError("msg.bad.break", i, nodeEnd - i);
            } else {
                firstLabel = this.loopAndSwitchSet.get(r5.size() - 1);
            }
        }
        if (nameCreateNameNode != null) {
            nameCreateNameNode.setLineColumnNumber(lineNumber(), columnNumber());
        }
        BreakStatement breakStatement = new BreakStatement(i, nodeEnd - i);
        breakStatement.setBreakLabel(nameCreateNameNode);
        if (firstLabel != null) {
            breakStatement.setBreakTarget(firstLabel);
        }
        breakStatement.setLineColumnNumber(iLineNumber, iColumnNumber);
        return breakStatement;
    }

    private void checkBadIncDec(UpdateExpression updateExpression) {
        int type = removeParens(updateExpression.getOperand()).getType();
        if (type == 44 || type == 33 || type == 39 || type == 73 || type == 43) {
            return;
        }
        reportError(updateExpression.getType() == 119 ? "msg.bad.incr" : "msg.bad.decr");
    }

    private void checkCallRequiresActivation(AstNode astNode) {
        if ((astNode.getType() == 44 && "eval".equals(((Name) astNode).getIdentifier())) || (astNode.getType() == 33 && "eval".equals(((PropertyGet) astNode).getProperty().getIdentifier()))) {
            setRequiresActivation();
        }
    }

    private RuntimeException codeBug() {
        TokenStream tokenStream = this.ts;
        throw Kit.codeBug("ts.cursor=" + tokenStream.cursor + ", ts.tokenBeg=" + tokenStream.tokenBeg + ", currentToken=" + this.currentToken);
    }

    private int columnNumber() {
        return this.lastTokenColumn;
    }

    private AstNode condExpr() {
        AstNode astNodeNullishCoalescingExpr = nullishCoalescingExpr();
        if (!matchToken(Token.HOOK, true)) {
            return astNodeNullishCoalescingExpr;
        }
        int i = this.ts.tokenBeg;
        boolean z = this.inForInit;
        this.inForInit = false;
        try {
            AstNode astNodeAssignExpr = assignExpr();
            this.inForInit = z;
            int i2 = mustMatchToken(Token.COLON, "msg.no.colon.cond", true) ? this.ts.tokenBeg : -1;
            AstNode astNodeAssignExpr2 = assignExpr();
            int position = astNodeNullishCoalescingExpr.getPosition();
            ConditionalExpression conditionalExpression = new ConditionalExpression(position, getNodeEnd(astNodeAssignExpr2) - position);
            conditionalExpression.setLineColumnNumber(astNodeNullishCoalescingExpr.getLineno(), astNodeNullishCoalescingExpr.getColumn());
            conditionalExpression.setTestExpression(astNodeNullishCoalescingExpr);
            conditionalExpression.setTrueExpression(astNodeAssignExpr);
            conditionalExpression.setFalseExpression(astNodeAssignExpr2);
            conditionalExpression.setQuestionMarkPosition(i - position);
            conditionalExpression.setColonPosition(i2 - position);
            return conditionalExpression;
        } catch (Throwable th) {
            this.inForInit = z;
            throw th;
        }
    }

    private ConditionData condition() {
        ConditionData conditionData = new ConditionData();
        if (mustMatchToken(96, "msg.no.paren.cond", true)) {
            conditionData.lp = this.ts.tokenBeg;
        }
        conditionData.condition = expr(false);
        if (mustMatchToken(97, "msg.no.paren.after.cond", true)) {
            conditionData.rp = this.ts.tokenBeg;
        }
        AstNode astNode = conditionData.condition;
        if (astNode instanceof Assignment) {
            addStrictWarning("msg.equal.as.assign", "", astNode.getPosition(), conditionData.condition.getLength());
        }
        return conditionData;
    }

    private void consumeToken() {
        this.currentFlaggedToken = 0;
        this.lastTokenLineno = this.ts.getTokenStartLineno();
        this.lastTokenColumn = this.ts.getTokenColumn();
    }

    private ContinueStatement continueStatement() {
        int nodeEnd;
        Name nameCreateNameNode;
        if (this.currentToken != 134) {
            codeBug();
        }
        consumeToken();
        int iLineNumber = lineNumber();
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        int i2 = tokenStream.tokenEnd;
        int iColumnNumber = columnNumber();
        Loop loop = null;
        if (peekTokenOrEOL() == 44) {
            nameCreateNameNode = createNameNode();
            nodeEnd = getNodeEnd(nameCreateNameNode);
        } else {
            nodeEnd = i2;
            nameCreateNameNode = null;
        }
        LabeledStatement labeledStatementMatchJumpLabelName = matchJumpLabelName();
        if (labeledStatementMatchJumpLabelName == null && nameCreateNameNode == null) {
            List<Loop> list = this.loopSet;
            if (list == null || list.size() == 0) {
                reportError("msg.continue.outside");
            } else {
                loop = this.loopSet.get(r5.size() - 1);
            }
        } else {
            if (labeledStatementMatchJumpLabelName == null || !(labeledStatementMatchJumpLabelName.getStatement() instanceof Loop)) {
                reportError("msg.continue.nonloop", i, nodeEnd - i);
            }
            if (labeledStatementMatchJumpLabelName != null) {
                loop = (Loop) labeledStatementMatchJumpLabelName.getStatement();
            }
        }
        if (nameCreateNameNode != null) {
            nameCreateNameNode.setLineColumnNumber(lineNumber(), columnNumber());
        }
        ContinueStatement continueStatement = new ContinueStatement(i, nodeEnd - i);
        if (loop != null) {
            continueStatement.setTarget(loop);
        }
        continueStatement.setLabel(nameCreateNameNode);
        continueStatement.setLineColumnNumber(iLineNumber, iColumnNumber);
        return continueStatement;
    }

    private Name createNameNode(boolean z, int i) {
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        String string = tokenStream.getString();
        int iLineNumber = lineNumber();
        int iColumnNumber = columnNumber();
        String str = "";
        if (!"".equals(this.prevNameTokenString)) {
            i2 = this.prevNameTokenStart;
            string = this.prevNameTokenString;
            iLineNumber = this.prevNameTokenLineno;
            iColumnNumber = this.prevNameTokenColumn;
            this.prevNameTokenStart = 0;
            this.prevNameTokenString = "";
            this.prevNameTokenLineno = 0;
            this.prevNameTokenColumn = 0;
        }
        if (string != null) {
            str = string;
        } else if (!this.compilerEnv.isIdeMode()) {
            codeBug();
            str = string;
        }
        Name name = new Name(i2, str);
        name.setLineColumnNumber(iLineNumber, iColumnNumber);
        if (z) {
            checkActivationName(str, i);
        }
        return name;
    }

    private AstNode createNumericLiteral(int i, boolean z) {
        AstNode numberLiteral;
        String string = this.ts.getString();
        if (this.inUseStrictDirective && this.ts.isNumericOldOctal() && (this.compilerEnv.getLanguageVersion() >= 200 || !z)) {
            if (i == 89) {
                reportError("msg.no.old.octal.bigint");
            } else {
                reportError("msg.no.old.octal.strict");
            }
        }
        if (this.compilerEnv.getLanguageVersion() >= 200 || !z) {
            if (this.ts.isNumericBinary()) {
                string = "0b" + string;
            } else if (this.ts.isNumericOldOctal()) {
                string = "0" + string;
            } else if (this.ts.isNumericOctal()) {
                string = "0o" + string;
            } else if (this.ts.isNumericHex()) {
                string = "0x" + string;
            }
        }
        if (i == 89) {
            numberLiteral = new BigIntLiteral(this.ts.tokenBeg, string + "n", this.ts.getBigInt());
        } else {
            TokenStream tokenStream = this.ts;
            numberLiteral = new NumberLiteral(tokenStream.tokenBeg, string, tokenStream.getNumber());
        }
        numberLiteral.setLineColumnNumber(lineNumber(), columnNumber());
        return numberLiteral;
    }

    private StringLiteral createStringLiteral() {
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        StringLiteral stringLiteral = new StringLiteral(i, tokenStream.tokenEnd - i);
        stringLiteral.setLineColumnNumber(lineNumber(), columnNumber());
        stringLiteral.setValue(this.ts.getString());
        stringLiteral.setQuoteCharacter(this.ts.getQuoteChar());
        return stringLiteral;
    }

    private TemplateCharacters createTemplateLiteralCharacters(int i) {
        TemplateCharacters templateCharacters = new TemplateCharacters(i, (this.ts.tokenEnd - i) - 1);
        templateCharacters.setValue(this.ts.getString());
        templateCharacters.setRawValue(this.ts.getRawString());
        return templateCharacters;
    }

    private AstNode defaultXmlNamespace() {
        if (this.currentToken != 129) {
            codeBug();
        }
        consumeToken();
        mustHaveXML();
        setRequiresActivation();
        int iLineNumber = lineNumber();
        int iColumnNumber = columnNumber();
        int i = this.ts.tokenBeg;
        if (!matchToken(44, true) || !XMLConstants.XML_NS_PREFIX.equals(this.ts.getString())) {
            reportError("msg.bad.namespace");
        }
        if (!matchToken(44, true) || !"namespace".equals(this.ts.getString())) {
            reportError("msg.bad.namespace");
        }
        if (!matchToken(99, true)) {
            reportError("msg.bad.namespace");
        }
        AstNode astNodeExpr = expr(false);
        UnaryExpression unaryExpression = new UnaryExpression(i, getNodeEnd(astNodeExpr) - i);
        unaryExpression.setOperator(82);
        unaryExpression.setOperand(astNodeExpr);
        unaryExpression.setLineColumnNumber(iLineNumber, iColumnNumber);
        return new ExpressionStatement((AstNode) unaryExpression, true);
    }

    private AstNode destructuringAssignExpr() {
        try {
            this.inDestructuringAssignment = true;
            return assignExpr();
        } finally {
            this.inDestructuringAssignment = false;
        }
    }

    private AstNode destructuringPrimaryExpr() {
        try {
            this.inDestructuringAssignment = true;
            return primaryExpr();
        } finally {
            this.inDestructuringAssignment = false;
        }
    }

    private DoLoop doLoop() {
        if (this.currentToken != 131) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        DoLoop doLoop = new DoLoop(i);
        doLoop.setLineColumnNumber(lineNumber(), columnNumber());
        enterLoop(doLoop);
        try {
            AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(doLoop);
            mustMatchToken(130, "msg.no.while.do", true);
            doLoop.setWhilePosition(this.ts.tokenBeg - i);
            ConditionData conditionDataCondition = condition();
            doLoop.setCondition(conditionDataCondition.condition);
            doLoop.setParens(conditionDataCondition.lp - i, conditionDataCondition.rp - i);
            int nodeEnd = getNodeEnd(nextStatementAfterInlineComments);
            restoreRelativeLoopPosition(doLoop);
            doLoop.setBody(nextStatementAfterInlineComments);
            exitLoop();
            if (matchToken(91, true)) {
                nodeEnd = this.ts.tokenEnd;
            }
            doLoop.setLength(nodeEnd - i);
            return doLoop;
        } catch (Throwable th) {
            exitLoop();
            throw th;
        }
    }

    private void enterLoop(Loop loop) {
        if (this.loopSet == null) {
            this.loopSet = new ArrayList();
        }
        this.loopSet.add(loop);
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList();
        }
        this.loopAndSwitchSet.add(loop);
        pushScope(loop);
        LabeledStatement labeledStatement = this.currentLabel;
        if (labeledStatement != null) {
            labeledStatement.setStatement(loop);
            this.currentLabel.getFirstLabel().setLoop(loop);
            loop.setRelative(-this.currentLabel.getPosition());
        }
    }

    private void enterSwitch(SwitchStatement switchStatement) {
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList();
        }
        this.loopAndSwitchSet.add(switchStatement);
    }

    private AstNode eqExpr() {
        AstNode astNodeRelExpr = relExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            if (iPeekToken != 12 && iPeekToken != 13 && iPeekToken != 51 && iPeekToken != 52) {
                return astNodeRelExpr;
            }
            consumeToken();
            if (this.compilerEnv.getLanguageVersion() == 120) {
                if (iPeekToken == 12) {
                    iPeekToken = 51;
                } else if (iPeekToken == 13) {
                    iPeekToken = 52;
                }
            }
            astNodeRelExpr = new InfixExpression(iPeekToken, astNodeRelExpr, relExpr(), i);
        }
    }

    private void exitLoop() {
        this.loopSet.remove(r0.size() - 1);
        this.loopAndSwitchSet.remove(r0.size() - 1);
        popScope();
    }

    private void exitSwitch() {
        this.loopAndSwitchSet.remove(r1.size() - 1);
    }

    private AstNode expExpr() {
        AstNode astNodeUnaryExpr = unaryExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            if (iPeekToken != 81) {
                return astNodeUnaryExpr;
            }
            if (astNodeUnaryExpr instanceof UnaryExpression) {
                reportError("msg.no.unary.expr.on.left.exp", AstNode.operatorToString(astNodeUnaryExpr.getType()));
                return makeErrorNode();
            }
            consumeToken();
            astNodeUnaryExpr = new InfixExpression(iPeekToken, astNodeUnaryExpr, expExpr(), i);
        }
    }

    private AstNode expr(boolean z) {
        AstNode astNodeAssignExpr = assignExpr();
        int position = astNodeAssignExpr.getPosition();
        while (matchToken(98, true)) {
            int i = this.ts.tokenBeg;
            if (this.compilerEnv.isStrictMode() && !astNodeAssignExpr.hasSideEffects()) {
                addStrictWarning("msg.no.side.effects", "", position, nodeEnd(astNodeAssignExpr) - position);
            }
            if (peekToken() == 78) {
                reportError("msg.yield.parenthesized");
            }
            if (z && peekToken() == 97) {
                astNodeAssignExpr.putIntProp(28, 1);
                return astNodeAssignExpr;
            }
            astNodeAssignExpr = new InfixExpression(98, astNodeAssignExpr, assignExpr(), i);
        }
        return astNodeAssignExpr;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private Loop forLoop() {
        boolean z;
        int i;
        AstNode astNodeExpr;
        AstNode astNodeExpr2;
        boolean z2;
        boolean z3;
        int i2;
        Loop loop;
        if (this.currentToken != 132) {
            codeBug();
        }
        consumeToken();
        int i3 = this.ts.tokenBeg;
        int iLineNumber = lineNumber();
        int iColumnNumber = columnNumber();
        Scope scope = new Scope();
        pushScope(scope);
        try {
            if (!matchToken(44, true)) {
                z = false;
                i = -1;
            } else if ("each".equals(this.ts.getString())) {
                i = this.ts.tokenBeg - i3;
                z = true;
            } else {
                reportError("msg.no.paren.for");
                z = false;
                i = -1;
            }
            int i4 = mustMatchToken(96, "msg.no.paren.for", true) ? this.ts.tokenBeg - i3 : -1;
            AstNode astNodeForLoopInit = forLoopInit(peekToken());
            AstNode astNodeExpr3 = null;
            if (matchToken(57, true)) {
                i2 = this.ts.tokenBeg - i3;
                markDestructuring(astNodeForLoopInit);
                astNodeExpr2 = expr(false);
                z3 = true;
                z2 = false;
            } else if (this.compilerEnv.getLanguageVersion() >= 200 && matchToken(44, true) && "of".equals(this.ts.getString())) {
                i2 = this.ts.tokenBeg - i3;
                markDestructuring(astNodeForLoopInit);
                astNodeExpr2 = expr(false);
                z2 = true;
                z3 = false;
            } else {
                mustMatchToken(91, "msg.no.semi.for", true);
                if (peekToken() == 91) {
                    astNodeExpr = new EmptyExpression(this.ts.tokenBeg, 1);
                    astNodeExpr.setLineColumnNumber(this.ts.getLineno(), this.ts.getTokenColumn());
                } else {
                    astNodeExpr = expr(false);
                }
                astNodeExpr2 = astNodeExpr;
                mustMatchToken(91, "msg.no.semi.for.cond", true);
                int i5 = this.ts.tokenEnd;
                if (peekToken() == 97) {
                    astNodeExpr3 = new EmptyExpression(i5, 1);
                    astNodeExpr3.setLineColumnNumber(this.ts.getLineno(), this.ts.getTokenColumn());
                } else {
                    astNodeExpr3 = expr(false);
                }
                z2 = false;
                z3 = false;
                i2 = -1;
            }
            int i6 = mustMatchToken(97, "msg.no.paren.for.ctrl", true) ? this.ts.tokenBeg - i3 : -1;
            if (z3 || z2) {
                ForInLoop forInLoop = new ForInLoop(i3);
                if ((astNodeForLoopInit instanceof VariableDeclaration) && ((VariableDeclaration) astNodeForLoopInit).getVariables().size() > 1) {
                    reportError("msg.mult.index");
                }
                if (z2 && z) {
                    reportError("msg.invalid.for.each");
                }
                forInLoop.setIterator(astNodeForLoopInit);
                forInLoop.setIteratedObject(astNodeExpr2);
                forInLoop.setInPosition(i2);
                forInLoop.setIsForEach(z);
                forInLoop.setEachPosition(i);
                forInLoop.setIsForOf(z2);
                loop = forInLoop;
            } else {
                ForLoop forLoop = new ForLoop(i3);
                forLoop.setInitializer(astNodeForLoopInit);
                forLoop.setCondition(astNodeExpr2);
                forLoop.setIncrement(astNodeExpr3);
                loop = forLoop;
            }
            this.currentScope.replaceWith(loop);
            popScope();
            enterLoop(loop);
            try {
                AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(loop);
                loop.setLength(getNodeEnd(nextStatementAfterInlineComments) - i3);
                restoreRelativeLoopPosition(loop);
                loop.setBody(nextStatementAfterInlineComments);
                if (this.currentScope == scope) {
                    popScope();
                }
                loop.setParens(i4, i6);
                loop.setLineColumnNumber(iLineNumber, iColumnNumber);
                return loop;
            } finally {
                exitLoop();
            }
        } catch (Throwable th) {
            if (this.currentScope == scope) {
                popScope();
            }
            throw th;
        }
    }

    private AstNode forLoopInit(int i) {
        AstNode astNodeVariables;
        try {
            this.inForInit = true;
            if (i == 91) {
                astNodeVariables = new EmptyExpression(this.ts.tokenBeg, 1);
                astNodeVariables.setLineColumnNumber(this.ts.getLineno(), this.ts.getTokenColumn());
            } else if (i == 135 || i == 167) {
                consumeToken();
                astNodeVariables = variables(i, this.ts.tokenBeg, false);
            } else {
                astNodeVariables = expr(false);
            }
            this.inForInit = false;
            return astNodeVariables;
        } catch (Throwable th) {
            this.inForInit = false;
            throw th;
        }
    }

    private FunctionNode function(int i, boolean z) {
        AstNode astNode;
        Name nameCreateNameNode;
        int iLineNumber = lineNumber();
        int i2 = this.ts.tokenBeg;
        int iColumnNumber = columnNumber();
        boolean z2 = false;
        while (true) {
            astNode = null;
            if (matchToken(44, true)) {
                nameCreateNameNode = createNameNode(true, 44);
                if (this.inUseStrictDirective) {
                    String identifier = nameCreateNameNode.getIdentifier();
                    if ("eval".equals(identifier) || "arguments".equals(identifier)) {
                        reportError("msg.bad.id.strict", identifier);
                    }
                }
                if (!matchToken(96, true)) {
                    if (this.compilerEnv.isAllowMemberExprAsFunctionName()) {
                        AstNode astNodeMemberExprTail = memberExprTail(false, nameCreateNameNode);
                        nameCreateNameNode = null;
                        astNode = astNodeMemberExprTail;
                    }
                    mustMatchToken(96, "msg.no.paren.parms", true);
                }
            } else {
                if (matchToken(96, true)) {
                    nameCreateNameNode = null;
                    break;
                }
                if (!matchToken(23, true) || this.compilerEnv.getLanguageVersion() < 200) {
                    break;
                }
                z2 = true;
            }
        }
        AstNode astNodeMemberExpr = this.compilerEnv.isAllowMemberExprAsFunctionName() ? memberExpr(false) : null;
        mustMatchToken(96, "msg.no.paren.parms", true);
        nameCreateNameNode = null;
        astNode = astNodeMemberExpr;
        int i3 = this.currentToken == 96 ? this.ts.tokenBeg : -1;
        if ((astNode != null ? 2 : i) != 2 && nameCreateNameNode != null && nameCreateNameNode.length() > 0) {
            defineSymbol(Token.FUNCTION, nameCreateNameNode.getIdentifier());
        }
        FunctionNode functionNode = new FunctionNode(i2, nameCreateNameNode);
        functionNode.setMethodDefinition(z);
        functionNode.setFunctionType(i);
        if (z2) {
            functionNode.setIsES6Generator();
        }
        if (i3 != -1) {
            functionNode.setLp(i3 - i2);
        }
        functionNode.setJsDocNode(getAndResetJsDoc());
        PerFunctionVariables perFunctionVariables = new PerFunctionVariables(functionNode);
        boolean z3 = this.insideMethod;
        this.insideMethod = z;
        try {
            parseFunctionParams(functionNode);
            AstNode functionBody = parseFunctionBody(i, functionNode);
            functionNode.setBody(functionBody);
            int position = functionBody.getPosition() + i2 + functionBody.getLength();
            functionNode.setRawSourceBounds(i2, position);
            functionNode.setLength(position - i2);
            if (this.compilerEnv.isStrictMode() && !functionNode.getBody().hasConsistentReturnUsage()) {
                addStrictWarning((nameCreateNameNode == null || nameCreateNameNode.length() <= 0) ? "msg.anon.no.return.value" : "msg.no.return.value", nameCreateNameNode == null ? "" : nameCreateNameNode.getIdentifier());
            }
            perFunctionVariables.restore();
            this.insideMethod = z3;
            if (astNode != null) {
                Kit.codeBug();
                functionNode.setMemberExprNode(astNode);
            }
            functionNode.setSourceName(this.sourceURI);
            functionNode.setLineColumnNumber(iLineNumber, iColumnNumber);
            functionNode.setEndLineno(lineNumber());
            if (this.compilerEnv.isIdeMode()) {
                functionNode.setParentScope(this.currentScope);
            }
            return functionNode;
        } catch (Throwable th) {
            perFunctionVariables.restore();
            this.insideMethod = z3;
            throw th;
        }
    }

    private AstNode generatorExpression(AstNode astNode, int i, boolean z) {
        int i2;
        ConditionData conditionDataCondition;
        ArrayList arrayList = new ArrayList();
        while (peekToken() == 132) {
            arrayList.add(generatorExpressionLoop());
        }
        if (peekToken() == 125) {
            consumeToken();
            i2 = this.ts.tokenBeg - i;
            conditionDataCondition = condition();
        } else {
            i2 = -1;
            conditionDataCondition = null;
        }
        if (!z) {
            mustMatchToken(97, "msg.no.paren.let", true);
        }
        GeneratorExpression generatorExpression = new GeneratorExpression(i, this.ts.tokenEnd - i);
        generatorExpression.setResult(astNode);
        generatorExpression.setLoops(arrayList);
        if (conditionDataCondition != null) {
            generatorExpression.setIfPosition(i2);
            generatorExpression.setFilter(conditionDataCondition.condition);
            generatorExpression.setFilterLp(conditionDataCondition.lp - i);
            generatorExpression.setFilterRp(conditionDataCondition.rp - i);
        }
        return generatorExpression;
    }

    private GeneratorExpressionLoop generatorExpressionLoop() {
        AstNode astNodeCreateNameNode;
        if (nextToken() != 132) {
            codeBug();
        }
        int i = this.ts.tokenBeg;
        GeneratorExpressionLoop generatorExpressionLoop = new GeneratorExpressionLoop(i);
        pushScope(generatorExpressionLoop);
        try {
            int i2 = mustMatchToken(96, "msg.no.paren.for", true) ? this.ts.tokenBeg - i : -1;
            int iPeekToken = peekToken();
            if (iPeekToken == 44) {
                consumeToken();
                astNodeCreateNameNode = createNameNode();
            } else if (iPeekToken == 92 || iPeekToken == 94) {
                astNodeCreateNameNode = destructuringPrimaryExpr();
                markDestructuring(astNodeCreateNameNode);
            } else {
                reportError("msg.bad.var");
                astNodeCreateNameNode = null;
            }
            if (astNodeCreateNameNode.getType() == 44) {
                defineSymbol(Token.LET, this.ts.getString(), true);
            }
            int i3 = mustMatchToken(57, "msg.in.after.for.name", true) ? this.ts.tokenBeg - i : -1;
            AstNode astNodeExpr = expr(false);
            int i4 = mustMatchToken(97, "msg.no.paren.for.ctrl", true) ? this.ts.tokenBeg - i : -1;
            generatorExpressionLoop.setLength(this.ts.tokenEnd - i);
            generatorExpressionLoop.setIterator(astNodeCreateNameNode);
            generatorExpressionLoop.setIteratedObject(astNodeExpr);
            generatorExpressionLoop.setInPosition(i3);
            generatorExpressionLoop.setParens(i2, i4);
            popScope();
            return generatorExpressionLoop;
        } catch (Throwable th) {
            popScope();
            throw th;
        }
    }

    private Comment getAndResetJsDoc() {
        Comment comment = this.currentJsDocComment;
        this.currentJsDocComment = null;
        return comment;
    }

    private static String getDirective(AstNode astNode) {
        if (!(astNode instanceof ExpressionStatement)) {
            return null;
        }
        AstNode expression = ((ExpressionStatement) astNode).getExpression();
        if (expression instanceof StringLiteral) {
            return ((StringLiteral) expression).getValue();
        }
        return null;
    }

    private AstNode getNextStatementAfterInlineComments(AstNode astNode) {
        AstNode astNodeStatement = statement();
        if (175 != astNodeStatement.getType()) {
            return astNodeStatement;
        }
        AstNode astNodeStatement2 = statement();
        if (astNode != null) {
            astNode.setInlineComment(astNodeStatement);
            return astNodeStatement2;
        }
        astNodeStatement2.setInlineComment(astNodeStatement);
        return astNodeStatement2;
    }

    private static int getNodeEnd(AstNode astNode) {
        return astNode.getPosition() + astNode.getLength();
    }

    public static Object getPropKey(Node node) {
        if (node instanceof Name) {
            return ScriptRuntime.getIndexObject(((Name) node).getIdentifier());
        }
        if (node instanceof StringLiteral) {
            return ScriptRuntime.getIndexObject(((StringLiteral) node).getValue());
        }
        if (node instanceof NumberLiteral) {
            return ScriptRuntime.getIndexObject(((NumberLiteral) node).getNumber());
        }
        if (node instanceof GeneratorMethodDefinition) {
            return getPropKey(((GeneratorMethodDefinition) node).getMethodName());
        }
        return null;
    }

    private IfStatement ifStatement() {
        int i;
        AstNode astNodeStatement;
        if (this.currentToken != 125) {
            codeBug();
        }
        consumeToken();
        int i2 = this.ts.tokenBeg;
        int iLineNumber = lineNumber();
        int iColumnNumber = columnNumber();
        IfStatement ifStatement = new IfStatement(i2);
        ConditionData conditionDataCondition = condition();
        AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(ifStatement);
        if (matchToken(126, true)) {
            if (peekToken() == 175) {
                List<Comment> list = this.scannedComments;
                ifStatement.setElseKeyWordInlineComment(list.get(list.size() - 1));
                consumeToken();
            }
            i = this.ts.tokenBeg - i2;
            astNodeStatement = statement();
        } else {
            i = -1;
            astNodeStatement = null;
        }
        ifStatement.setLength(getNodeEnd(astNodeStatement != null ? astNodeStatement : nextStatementAfterInlineComments) - i2);
        ifStatement.setCondition(conditionDataCondition.condition);
        ifStatement.setParens(conditionDataCondition.lp - i2, conditionDataCondition.rp - i2);
        ifStatement.setThenPart(nextStatementAfterInlineComments);
        ifStatement.setElsePart(astNodeStatement);
        ifStatement.setElsePosition(i);
        ifStatement.setLineColumnNumber(iLineNumber, iColumnNumber);
        return ifStatement;
    }

    private static boolean isNotValidSimpleAssignmentTarget(AstNode astNode) {
        return astNode.getType() == 33 ? isNotValidSimpleAssignmentTarget(((PropertyGet) astNode).getLeft()) : astNode.getType() == 186;
    }

    private AstNode let(boolean z, int i) {
        LetNode letNode = new LetNode(i);
        letNode.setLineColumnNumber(lineNumber(), columnNumber());
        if (mustMatchToken(96, "msg.no.paren.after.let", true)) {
            letNode.setLp(this.ts.tokenBeg - i);
        }
        pushScope(letNode);
        try {
            letNode.setVariables(variables(Token.LET, this.ts.tokenBeg, z));
            if (mustMatchToken(97, "msg.no.paren.let", true)) {
                letNode.setRp(this.ts.tokenBeg - i);
            }
            if (z && peekToken() == 94) {
                consumeToken();
                int i2 = this.ts.tokenBeg;
                AstNode astNodeStatements = statements();
                mustMatchToken(95, "msg.no.curly.let", true);
                astNodeStatements.setLength(this.ts.tokenEnd - i2);
                letNode.setLength(this.ts.tokenEnd - i);
                letNode.setBody(astNodeStatements);
                letNode.setType(Token.LET);
            } else {
                AstNode astNodeExpr = expr(false);
                letNode.setLength(getNodeEnd(astNodeExpr) - i);
                letNode.setBody(astNodeExpr);
                if (z) {
                    ExpressionStatement expressionStatement = new ExpressionStatement(letNode, !insideFunctionBody());
                    expressionStatement.setLineColumnNumber(letNode.getLineno(), letNode.getColumn());
                    popScope();
                    return expressionStatement;
                }
            }
            popScope();
            return letNode;
        } catch (Throwable th) {
            popScope();
            throw th;
        }
    }

    private AstNode letStatement() {
        if (this.currentToken != 167) {
            codeBug();
        }
        consumeToken();
        int iLineNumber = lineNumber();
        int i = this.ts.tokenBeg;
        int iColumnNumber = columnNumber();
        AstNode astNodeLet = peekToken() == 96 ? let(true, i) : variables(Token.LET, i, true);
        astNodeLet.setLineColumnNumber(iLineNumber, iColumnNumber);
        return astNodeLet;
    }

    private int lineBeginningFor(int i) {
        char[] cArr = this.sourceChars;
        if (cArr == null) {
            return -1;
        }
        if (i <= 0) {
            return 0;
        }
        if (i >= cArr.length) {
            i = cArr.length - 1;
        }
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                return 0;
            }
            if (ScriptRuntime.isJSLineTerminator(cArr[i2])) {
                return i;
            }
            i = i2;
        }
    }

    private int lineNumber() {
        return this.lastTokenLineno;
    }

    private ElementGet makeElemGet(AstNode astNode, int i) {
        int i2;
        int position = astNode.getPosition();
        AstNode astNodeExpr = expr(false);
        int nodeEnd = getNodeEnd(astNodeExpr);
        if (mustMatchToken(93, "msg.no.bracket.index", true)) {
            TokenStream tokenStream = this.ts;
            int i3 = tokenStream.tokenBeg;
            nodeEnd = tokenStream.tokenEnd;
            i2 = i3;
        } else {
            i2 = -1;
        }
        ElementGet elementGet = new ElementGet(position, nodeEnd - position);
        elementGet.setTarget(astNode);
        elementGet.setElement(astNodeExpr);
        elementGet.setParens(i, i2);
        return elementGet;
    }

    private ErrorNode makeErrorNode() {
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        ErrorNode errorNode = new ErrorNode(i, tokenStream.tokenEnd - i);
        errorNode.setLineColumnNumber(lineNumber(), columnNumber());
        return errorNode;
    }

    private FunctionCall makeFunctionCall(AstNode astNode, int i, boolean z) {
        consumeToken();
        checkCallRequiresActivation(astNode);
        FunctionCall functionCall = new FunctionCall(i);
        functionCall.setTarget(astNode);
        functionCall.setLp(this.ts.tokenBeg - i);
        List<AstNode> listArgumentList = argumentList();
        if (listArgumentList != null && listArgumentList.size() > 65536) {
            reportError("msg.too.many.function.args");
        }
        functionCall.setArguments(listArgumentList);
        functionCall.setRp(this.ts.tokenBeg - i);
        functionCall.setLength(this.ts.tokenEnd - i);
        if (z) {
            functionCall.markIsOptionalCall();
        }
        return functionCall;
    }

    private LabeledStatement matchJumpLabelName() {
        if (peekTokenOrEOL() == 44) {
            consumeToken();
            Map<String, LabeledStatement> map = this.labelSet;
            labeledStatement = map != null ? map.get(this.ts.getString()) : null;
            if (labeledStatement == null) {
                reportError("msg.undef.label");
            }
        }
        return labeledStatement;
    }

    private boolean matchToken(int i, boolean z) {
        int iPeekToken = peekToken();
        while (iPeekToken == 175 && z) {
            consumeToken();
            iPeekToken = peekToken();
        }
        if (iPeekToken != i) {
            return false;
        }
        consumeToken();
        return true;
    }

    private AstNode memberExpr(boolean z) {
        AstNode astNodePrimaryExpr;
        if (peekToken() != 30) {
            astNodePrimaryExpr = primaryExpr();
        } else {
            consumeToken();
            int i = this.ts.tokenBeg;
            int iLineNumber = lineNumber();
            int iColumnNumber = columnNumber();
            NewExpression newExpression = new NewExpression(i);
            AstNode astNodeMemberExpr = memberExpr(false);
            int nodeEnd = getNodeEnd(astNodeMemberExpr);
            newExpression.setTarget(astNodeMemberExpr);
            newExpression.setLineColumnNumber(iLineNumber, iColumnNumber);
            if (matchToken(96, true)) {
                int i2 = this.ts.tokenBeg;
                List<AstNode> listArgumentList = argumentList();
                if (listArgumentList != null && listArgumentList.size() > 65536) {
                    reportError("msg.too.many.constructor.args");
                }
                TokenStream tokenStream = this.ts;
                int i3 = tokenStream.tokenBeg;
                nodeEnd = tokenStream.tokenEnd;
                if (listArgumentList != null) {
                    newExpression.setArguments(listArgumentList);
                }
                newExpression.setParens(i2 - i, i3 - i);
            }
            if (matchToken(94, true)) {
                ObjectLiteral objectLiteral = objectLiteral();
                nodeEnd = getNodeEnd(objectLiteral);
                newExpression.setInitializer(objectLiteral);
            }
            newExpression.setLength(nodeEnd - i);
            astNodePrimaryExpr = newExpression;
        }
        return memberExprTail(z, astNodePrimaryExpr);
    }

    private AstNode memberExprTail(boolean z, AstNode astNode) {
        int i;
        if (astNode == null) {
            codeBug();
        }
        int position = astNode.getPosition();
        boolean z2 = false;
        while (true) {
            int iLineNumber = lineNumber();
            int iColumnNumber = columnNumber();
            int iPeekToken = peekToken();
            if (iPeekToken == 92) {
                consumeToken();
                astNode = makeElemGet(astNode, this.ts.tokenBeg);
            } else if (iPeekToken != 96) {
                if (iPeekToken != 121 && iPeekToken != 157) {
                    if (iPeekToken == 160) {
                        consumeToken();
                        int i2 = this.ts.tokenBeg;
                        mustHaveXML();
                        setRequiresActivation();
                        AstNode astNodeExpr = expr(false);
                        int nodeEnd = getNodeEnd(astNodeExpr);
                        if (mustMatchToken(97, "msg.no.paren", true)) {
                            TokenStream tokenStream = this.ts;
                            int i3 = tokenStream.tokenBeg;
                            nodeEnd = tokenStream.tokenEnd;
                            i = i3;
                        } else {
                            i = -1;
                        }
                        XmlDotQuery xmlDotQuery = new XmlDotQuery(position, nodeEnd - position);
                        xmlDotQuery.setLeft(astNode);
                        xmlDotQuery.setRight(astNodeExpr);
                        xmlDotQuery.setOperatorPosition(i2);
                        xmlDotQuery.setRp(i - position);
                        xmlDotQuery.setLineColumnNumber(iLineNumber, iColumnNumber);
                        astNode = xmlDotQuery;
                    } else if (iPeekToken == 175) {
                        int i4 = this.currentFlaggedToken;
                        peekUntilNonComment(iPeekToken);
                        int i5 = this.currentFlaggedToken;
                        if ((65536 & i5) != 0) {
                            i4 = i5;
                        }
                        this.currentFlaggedToken = i4;
                    } else if (iPeekToken == 180) {
                        consumeToken();
                        astNode = taggedTemplateLiteral(astNode);
                    } else if (iPeekToken != 186) {
                        break;
                    }
                }
                z2 |= iPeekToken == 186;
                astNode = propertyAccess(iPeekToken, astNode, z2);
            } else {
                if (!z) {
                    break;
                }
                astNode = makeFunctionCall(astNode, position, z2);
            }
        }
        return astNode;
    }

    private ObjectProperty methodDefinition(int i, AstNode astNode, int i2, boolean z) {
        FunctionNode functionNodeFunction = function(2, true);
        Name functionName = functionNodeFunction.getFunctionName();
        if (functionName != null && functionName.length() != 0) {
            reportError("msg.bad.prop");
        }
        ObjectProperty objectProperty = new ObjectProperty(i);
        if (i2 == 2) {
            objectProperty.setIsGetterMethod();
            functionNodeFunction.setFunctionIsGetterMethod();
        } else if (i2 == 4) {
            objectProperty.setIsSetterMethod();
            functionNodeFunction.setFunctionIsSetterMethod();
        } else if (i2 == 8) {
            objectProperty.setIsNormalMethod();
            functionNodeFunction.setFunctionIsNormalMethod();
            if (z) {
                functionNodeFunction.setIsES6Generator();
            }
        }
        int nodeEnd = getNodeEnd(functionNodeFunction);
        objectProperty.setLeft(astNode);
        objectProperty.setRight(functionNodeFunction);
        objectProperty.setLength(nodeEnd - i);
        return objectProperty;
    }

    private AstNode mulExpr() {
        AstNode astNodeExpExpr = expExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            switch (iPeekToken) {
                case 23:
                case 24:
                case 25:
                    consumeToken();
                    astNodeExpExpr = new InfixExpression(iPeekToken, astNodeExpExpr, expExpr(), i);
                    break;
                default:
                    return astNodeExpExpr;
            }
        }
    }

    private void mustHaveXML() {
        if (this.compilerEnv.isXmlAvailable()) {
            return;
        }
        reportError("msg.XML.not.available");
    }

    private boolean mustMatchToken(int i, String str, boolean z) {
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        return mustMatchToken(i, str, i2, tokenStream.tokenEnd - i2, z);
    }

    private AstNode name(int i, int i2) {
        String string = this.ts.getString();
        int i3 = this.ts.tokenBeg;
        int iLineNumber = lineNumber();
        int iColumnNumber = columnNumber();
        if ((i & TI_CHECK_LABEL) == 0 || peekToken() != 116) {
            saveNameTokenData(i3, string, iLineNumber, iColumnNumber);
            return this.compilerEnv.isXmlAvailable() ? propertyName(-1, 0) : createNameNode(true, 44);
        }
        Label label = new Label(i3, this.ts.tokenEnd - i3);
        label.setName(string);
        label.setLineColumnNumber(lineNumber(), columnNumber());
        return label;
    }

    private AstNode nameOrLabel() {
        AstNode astNodeStatementHelper;
        if (this.currentToken != 44) {
            throw codeBug();
        }
        int i = this.ts.tokenBeg;
        this.currentFlaggedToken |= TI_CHECK_LABEL;
        AstNode astNodeExpr = expr(false);
        if (astNodeExpr.getType() != 144) {
            ExpressionStatement expressionStatement = new ExpressionStatement(astNodeExpr, !insideFunctionBody());
            expressionStatement.setLineColumnNumber(astNodeExpr.getLineno(), astNodeExpr.getColumn());
            return expressionStatement;
        }
        LabeledStatement labeledStatement = new LabeledStatement(i);
        recordLabel((Label) astNodeExpr, labeledStatement);
        labeledStatement.setLineColumnNumber(astNodeExpr.getLineno(), astNodeExpr.getColumn());
        while (true) {
            if (peekToken() != 44) {
                astNodeStatementHelper = null;
                break;
            }
            this.currentFlaggedToken |= TI_CHECK_LABEL;
            AstNode astNodeExpr2 = expr(false);
            if (astNodeExpr2.getType() != 144) {
                astNodeStatementHelper = new ExpressionStatement(astNodeExpr2, !insideFunctionBody());
                autoInsertSemicolon(astNodeStatementHelper);
                break;
            }
            recordLabel((Label) astNodeExpr2, labeledStatement);
        }
        try {
            this.currentLabel = labeledStatement;
            if (astNodeStatementHelper == null) {
                astNodeStatementHelper = statementHelper();
                if (peekToken() == 175) {
                    if (astNodeStatementHelper.getLineno() == this.scannedComments.get(r3.size() - 1).getLineno()) {
                        astNodeStatementHelper.setInlineComment(this.scannedComments.get(r2.size() - 1));
                        consumeToken();
                    }
                }
            }
            labeledStatement.setLength(astNodeStatementHelper.getParent() == null ? getNodeEnd(astNodeStatementHelper) - i : getNodeEnd(astNodeStatementHelper));
            labeledStatement.setStatement(astNodeStatementHelper);
            return labeledStatement;
        } finally {
            this.currentLabel = null;
            Iterator<Label> it = labeledStatement.getLabels().iterator();
            while (it.hasNext()) {
                this.labelSet.remove(it.next().getName());
            }
        }
    }

    private int nextToken() {
        int iPeekToken = peekToken();
        consumeToken();
        return iPeekToken;
    }

    private static int nodeEnd(AstNode astNode) {
        return astNode.getPosition() + astNode.getLength();
    }

    private static final boolean nowAllSet(int i, int i2, int i3) {
        return (i & i3) != i3 && (i2 & i3) == i3;
    }

    private AstNode nullishCoalescingExpr() {
        AstNode astNodeOrExpr = orExpr();
        if (!matchToken(Token.NULLISH_COALESCING, true)) {
            return astNodeOrExpr;
        }
        int i = this.ts.tokenBeg;
        AstNode astNodeNullishCoalescingExpr = nullishCoalescingExpr();
        if (astNodeOrExpr.getType() == 117 || astNodeOrExpr.getType() == 118 || astNodeNullishCoalescingExpr.getType() == 117 || astNodeNullishCoalescingExpr.getType() == 118) {
            reportError("msg.nullish.bad.token");
        }
        return new InfixExpression(Token.NULLISH_COALESCING, astNodeOrExpr, astNodeNullishCoalescingExpr, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v5 */
    private ObjectLiteral objectLiteral() {
        HashSet hashSet;
        HashSet hashSet2;
        int i;
        ?? r9;
        int i2;
        String string;
        int i3;
        int i4 = this.ts.tokenBeg;
        int iLineNumber = lineNumber();
        int iColumnNumber = columnNumber();
        ArrayList arrayList = new ArrayList();
        if (this.inUseStrictDirective) {
            hashSet = new HashSet();
            hashSet2 = new HashSet();
        } else {
            hashSet = null;
            hashSet2 = null;
        }
        Comment andResetJsDoc = getAndResetJsDoc();
        int i5 = -1;
        boolean z = false;
        int i6 = -1;
        while (true) {
            int iPeekToken = peekToken();
            Comment andResetJsDoc2 = getAndResetJsDoc();
            if (iPeekToken == 175) {
                consumeToken();
                iPeekToken = peekUntilNonComment(iPeekToken);
            }
            if (iPeekToken != 95) {
                AstNode astNodeObjliteralProperty = objliteralProperty();
                if (astNodeObjliteralProperty == null) {
                    reportError("msg.bad.prop");
                    i = iLineNumber;
                    i2 = 1;
                    string = null;
                } else {
                    string = this.ts.getString();
                    int i7 = this.ts.tokenBeg;
                    consumeToken();
                    boolean z2 = z;
                    if ((astNodeObjliteralProperty instanceof Name) || (astNodeObjliteralProperty instanceof StringLiteral)) {
                        i = iLineNumber;
                        i3 = i6;
                        astNodeObjliteralProperty.setLineColumnNumber(lineNumber(), columnNumber());
                    } else if (astNodeObjliteralProperty instanceof GeneratorMethodDefinition) {
                        i3 = i6;
                        i = iLineNumber;
                        ((GeneratorMethodDefinition) astNodeObjliteralProperty).getMethodName().setLineColumnNumber(lineNumber(), columnNumber());
                    } else {
                        i = iLineNumber;
                        i3 = i6;
                    }
                    int iPeekToken2 = peekToken();
                    if (iPeekToken2 == 98 || iPeekToken2 == 116 || iPeekToken2 == 95) {
                        astNodeObjliteralProperty.setJsDocNode(andResetJsDoc2);
                        arrayList.add(plainProperty(astNodeObjliteralProperty, iPeekToken));
                        z = z2;
                        i2 = 1;
                        if ((astNodeObjliteralProperty instanceof GeneratorMethodDefinition) && i2 != 8) {
                            reportError("msg.bad.prop");
                        }
                    } else {
                        if (iPeekToken2 == 99) {
                            if (this.compilerEnv.getLanguageVersion() >= 200) {
                                arrayList.add(plainProperty(astNodeObjliteralProperty, iPeekToken));
                                if (!matchToken(98, true)) {
                                    r9 = 1;
                                    z = true;
                                    break;
                                }
                                i6 = i3;
                                iLineNumber = i;
                                i5 = -1;
                                z = true;
                            } else {
                                reportError("msg.default.args");
                                i2 = 1;
                                z = true;
                            }
                        } else if (iPeekToken2 == 96) {
                            z = z2;
                            i2 = 8;
                        } else {
                            if (astNodeObjliteralProperty.getType() == 44) {
                                if ("get".equals(string)) {
                                    z = z2;
                                    i2 = 2;
                                } else if ("set".equals(string)) {
                                    z = z2;
                                    i2 = 4;
                                }
                            }
                            z = z2;
                            i2 = 1;
                        }
                        if (i2 == 2 || i2 == 4) {
                            astNodeObjliteralProperty = objliteralProperty();
                            if (astNodeObjliteralProperty == null) {
                                reportError("msg.bad.prop");
                            }
                            consumeToken();
                        }
                        if (astNodeObjliteralProperty == null) {
                            string = null;
                        } else {
                            string = this.ts.getString();
                            ObjectProperty objectPropertyMethodDefinition = methodDefinition(i7, astNodeObjliteralProperty, i2, astNodeObjliteralProperty instanceof GeneratorMethodDefinition);
                            astNodeObjliteralProperty.setJsDocNode(andResetJsDoc2);
                            arrayList.add(objectPropertyMethodDefinition);
                        }
                        if (astNodeObjliteralProperty instanceof GeneratorMethodDefinition) {
                            reportError("msg.bad.prop");
                        }
                    }
                }
                if (this.inUseStrictDirective && string != null && !(astNodeObjliteralProperty instanceof ComputedPropertyKey)) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            if (hashSet.contains(string)) {
                                addError("msg.dup.obj.lit.prop.strict", string);
                            }
                            hashSet.add(string);
                        } else if (i2 == 4) {
                            if (hashSet2.contains(string)) {
                                addError("msg.dup.obj.lit.prop.strict", string);
                            }
                            hashSet2.add(string);
                        } else if (i2 == 8) {
                        }
                    }
                    if (hashSet.contains(string) || hashSet2.contains(string)) {
                        addError("msg.dup.obj.lit.prop.strict", string);
                    }
                    hashSet.add(string);
                    hashSet2.add(string);
                }
                getAndResetJsDoc();
                r9 = 1;
                if (!matchToken(98, true)) {
                    break;
                }
                i6 = this.ts.tokenEnd;
                iLineNumber = i;
                i5 = -1;
            } else {
                if (i6 != i5) {
                    warnTrailingComma(i4, arrayList, i6);
                }
                i = iLineNumber;
                r9 = 1;
            }
        }
        mustMatchToken(95, "msg.no.brace.prop", r9);
        ObjectLiteral objectLiteral = new ObjectLiteral(i4, this.ts.tokenEnd - i4);
        if (z) {
            objectLiteral.putIntProp(29, r9);
        }
        if (andResetJsDoc != null) {
            objectLiteral.setJsDocNode(andResetJsDoc);
        }
        objectLiteral.setElements(arrayList);
        objectLiteral.setLineColumnNumber(i, iColumnNumber);
        return objectLiteral;
    }

    private AstNode objliteralProperty() {
        int iPeekToken = peekToken();
        if (iPeekToken == 23) {
            if (this.compilerEnv.getLanguageVersion() < 200) {
                reportError("msg.bad.prop");
                return null;
            }
            int i = this.ts.tokenBeg;
            nextToken();
            int iLineNumber = lineNumber();
            int iColumnNumber = columnNumber();
            GeneratorMethodDefinition generatorMethodDefinition = new GeneratorMethodDefinition(i, this.ts.tokenEnd - i, objliteralProperty());
            generatorMethodDefinition.setLineColumnNumber(iLineNumber, iColumnNumber);
            return generatorMethodDefinition;
        }
        if (iPeekToken != 89) {
            if (iPeekToken == 92) {
                if (this.compilerEnv.getLanguageVersion() < 200) {
                    reportError("msg.bad.prop");
                    return null;
                }
                int i2 = this.ts.tokenBeg;
                nextToken();
                int iLineNumber2 = lineNumber();
                int iColumnNumber2 = columnNumber();
                AstNode astNodeAssignExpr = assignExpr();
                if (peekToken() != 93) {
                    reportError("msg.bad.prop");
                }
                nextToken();
                ComputedPropertyKey computedPropertyKey = new ComputedPropertyKey(i2, this.ts.tokenEnd - i2);
                computedPropertyKey.setLineColumnNumber(iLineNumber2, iColumnNumber2);
                computedPropertyKey.setExpression(astNodeAssignExpr);
                return computedPropertyKey;
            }
            switch (iPeekToken) {
                case Token.NAME /* 44 */:
                    return createNameNode();
                case Token.NUMBER /* 45 */:
                    break;
                case Token.STRING /* 46 */:
                    return createStringLiteral();
                default:
                    if (this.compilerEnv.isReservedKeywordAsIdentifier() && TokenStream.isKeyword(this.ts.getString(), this.compilerEnv.getLanguageVersion(), this.inUseStrictDirective)) {
                        return createNameNode();
                    }
                    return null;
            }
        }
        return createNumericLiteral(iPeekToken, true);
    }

    private AstNode orExpr() {
        AstNode astNodeAndExpr = andExpr();
        if (!matchToken(Token.OR, true)) {
            return astNodeAndExpr;
        }
        return new InfixExpression(Token.OR, astNodeAndExpr, orExpr(), this.ts.tokenBeg);
    }

    private AstNode parenExpr() {
        boolean z = this.inForInit;
        this.inForInit = false;
        try {
            Comment andResetJsDoc = getAndResetJsDoc();
            int iLineNumber = lineNumber();
            int iColumnNumber = columnNumber();
            int i = this.ts.tokenBeg;
            AstNode emptyExpression = peekToken() == 97 ? new EmptyExpression(i) : expr(true);
            if (peekToken() == 132) {
                AstNode astNodeGeneratorExpression = generatorExpression(emptyExpression, i);
                this.inForInit = z;
                return astNodeGeneratorExpression;
            }
            mustMatchToken(97, "msg.no.paren", true);
            int i2 = this.ts.tokenEnd - i;
            boolean z2 = emptyExpression.getIntProp(29, 0) == 1;
            boolean z3 = emptyExpression.getIntProp(28, 0) == 1;
            if ((z3 || z2 || emptyExpression.getType() == 141) && peekToken() != 178) {
                reportError("msg.syntax");
                ErrorNode errorNodeMakeErrorNode = makeErrorNode();
                this.inForInit = z;
                return errorNodeMakeErrorNode;
            }
            ParenthesizedExpression parenthesizedExpression = new ParenthesizedExpression(i, i2, emptyExpression);
            parenthesizedExpression.setLineColumnNumber(iLineNumber, iColumnNumber);
            if (andResetJsDoc == null) {
                andResetJsDoc = getAndResetJsDoc();
            }
            if (andResetJsDoc != null) {
                parenthesizedExpression.setJsDocNode(andResetJsDoc);
            }
            if (z3) {
                parenthesizedExpression.putIntProp(28, 1);
            }
            this.inForInit = z;
            return parenthesizedExpression;
        } catch (Throwable th) {
            this.inForInit = z;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.ast.AstRoot parse() {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.parse():org.mozilla.javascript.ast.AstRoot");
    }

    private AstNode parseFunctionBody(int i, FunctionNode functionNode) {
        boolean z;
        Comment commentFunction;
        if (matchToken(94, true)) {
            z = false;
        } else if (this.compilerEnv.getLanguageVersion() >= 180 || i == 4) {
            z = true;
        } else {
            reportError("msg.no.brace.body");
            z = false;
        }
        boolean z2 = i == 4;
        this.nestingOfFunction++;
        int i2 = this.ts.tokenBeg;
        Block block = new Block(i2);
        boolean z3 = this.inUseStrictDirective;
        this.inUseStrictDirective = false;
        block.setLineColumnNumber(lineNumber(), columnNumber());
        try {
            if (z) {
                AstNode astNodeAssignExpr = assignExpr();
                ReturnStatement returnStatement = new ReturnStatement(astNodeAssignExpr.getPosition(), astNodeAssignExpr.getLength(), astNodeAssignExpr);
                Boolean bool = Boolean.TRUE;
                returnStatement.putProp(25, bool);
                returnStatement.setLineColumnNumber(astNodeAssignExpr.getLineno(), astNodeAssignExpr.getColumn());
                block.putProp(25, bool);
                if (z2) {
                    returnStatement.putProp(26, bool);
                }
                block.addStatement(returnStatement);
                block.setLength(returnStatement.getLength());
            } else {
                boolean z4 = true;
                while (true) {
                    int iPeekToken = peekToken();
                    if (iPeekToken == -1 || iPeekToken == 0 || iPeekToken == 95) {
                        break;
                    }
                    if (iPeekToken == 122) {
                        consumeToken();
                        commentFunction = function(1);
                    } else if (iPeekToken != 175) {
                        commentFunction = statement();
                        if (z4) {
                            String directive = getDirective(commentFunction);
                            if (directive == null) {
                                z4 = false;
                            } else if (directive.equals("use strict")) {
                                if (functionNode.getDefaultParams() != null) {
                                    reportError("msg.default.args.use.strict");
                                }
                                this.inUseStrictDirective = true;
                                functionNode.setInStrictMode(true);
                                if (!z3) {
                                    setRequiresActivation();
                                }
                            }
                        }
                    } else {
                        consumeToken();
                        List<Comment> list = this.scannedComments;
                        commentFunction = list.get(list.size() - 1);
                    }
                    block.addStatement(commentFunction);
                }
                int i3 = this.ts.tokenEnd;
                if (mustMatchToken(95, "msg.no.brace.after.body", true)) {
                    i3 = this.ts.tokenEnd;
                }
                block.setLength(i3 - i2);
            }
        } catch (ParserException unused) {
        } catch (Throwable th) {
            this.nestingOfFunction--;
            this.inUseStrictDirective = z3;
            throw th;
        }
        this.nestingOfFunction--;
        this.inUseStrictDirective = z3;
        getAndResetJsDoc();
        return block;
    }

    private void parseFunctionParams(FunctionNode functionNode) {
        int iLineNumber;
        int iColumnNumber;
        this.nestingOfFunctionParams++;
        try {
            if (matchToken(97, true)) {
                functionNode.setRp(this.ts.tokenBeg - functionNode.getPosition());
            } else {
                HashSet hashSet = new HashSet();
                HashMap map = null;
                HashMap map2 = null;
                while (true) {
                    int iPeekToken = peekToken();
                    if (iPeekToken != 97) {
                        boolean z = false;
                        if (iPeekToken == 92 || iPeekToken == 94) {
                            if (functionNode.hasRestParameter()) {
                                TokenStream tokenStream = this.ts;
                                int i = tokenStream.tokenBeg;
                                reportError("msg.parm.after.rest", i, tokenStream.tokenEnd - i);
                            }
                            AstNode astNodeDestructuringAssignExpr = destructuringAssignExpr();
                            if (map == null) {
                                map = new HashMap();
                            }
                            if (astNodeDestructuringAssignExpr instanceof Assignment) {
                                AstNode left = ((Assignment) astNodeDestructuringAssignExpr).getLeft();
                                AstNode right = ((Assignment) astNodeDestructuringAssignExpr).getRight();
                                markDestructuring(left);
                                functionNode.addParam(left);
                                String nextTempName = this.currentScriptOrFn.getNextTempName();
                                defineSymbol(96, nextTempName, false);
                                if (map2 == null) {
                                    map2 = new HashMap();
                                }
                                map.put(nextTempName, left);
                                map2.put(nextTempName, right);
                            } else {
                                markDestructuring(astNodeDestructuringAssignExpr);
                                functionNode.addParam(astNodeDestructuringAssignExpr);
                                String nextTempName2 = this.currentScriptOrFn.getNextTempName();
                                defineSymbol(96, nextTempName2, false);
                                map.put(nextTempName2, astNodeDestructuringAssignExpr);
                            }
                        } else {
                            if (iPeekToken == 184) {
                                if (functionNode.hasRestParameter()) {
                                    TokenStream tokenStream2 = this.ts;
                                    int i2 = tokenStream2.tokenBeg;
                                    reportError("msg.parm.after.rest", i2, tokenStream2.tokenEnd - i2);
                                }
                                functionNode.setHasRestParameter(true);
                                consumeToken();
                                iLineNumber = lineNumber();
                                iColumnNumber = columnNumber();
                                z = true;
                            } else {
                                iLineNumber = -1;
                                iColumnNumber = -1;
                            }
                            if (mustMatchToken(44, "msg.no.parm", true)) {
                                if (!z && functionNode.hasRestParameter()) {
                                    TokenStream tokenStream3 = this.ts;
                                    int i3 = tokenStream3.tokenBeg;
                                    reportError("msg.parm.after.rest", i3, tokenStream3.tokenEnd - i3);
                                }
                                AstNode astNodeCreateNameNode = createNameNode();
                                if (z) {
                                    astNodeCreateNameNode.setLineColumnNumber(iLineNumber, iColumnNumber);
                                }
                                Comment andResetJsDoc = getAndResetJsDoc();
                                if (andResetJsDoc != null) {
                                    astNodeCreateNameNode.setJsDocNode(andResetJsDoc);
                                }
                                functionNode.addParam(astNodeCreateNameNode);
                                String string = this.ts.getString();
                                defineSymbol(96, string);
                                if (this.inUseStrictDirective) {
                                    if ("eval".equals(string) || "arguments".equals(string)) {
                                        reportError("msg.bad.id.strict", string);
                                    }
                                    if (hashSet.contains(string)) {
                                        addError("msg.dup.param.strict", string);
                                    }
                                    hashSet.add(string);
                                }
                                if (matchToken(99, true)) {
                                    if (this.compilerEnv.getLanguageVersion() >= 200) {
                                        functionNode.putDefaultParams(string, assignExpr());
                                    } else {
                                        reportError("msg.default.args");
                                    }
                                }
                            } else {
                                functionNode.addParam(makeErrorNode());
                            }
                        }
                        if (!matchToken(98, true)) {
                            break;
                        }
                    } else {
                        if (functionNode.hasRestParameter()) {
                            TokenStream tokenStream4 = this.ts;
                            int i4 = tokenStream4.tokenBeg;
                            reportError("msg.parm.after.rest", i4, tokenStream4.tokenEnd - i4);
                        }
                        functionNode.putIntProp(28, 1);
                    }
                }
                if (map != null) {
                    Node node = new Node(98);
                    for (Map.Entry entry : map.entrySet()) {
                        node.addChildToBack(createDestructuringAssignment(Token.VAR, (Node) entry.getValue(), createName((String) entry.getKey()), map2 != null ? (AstNode) map2.get(entry.getKey()) : null));
                    }
                    functionNode.putProp(23, node);
                }
                if (mustMatchToken(97, "msg.no.paren.after.parms", true)) {
                    functionNode.setRp(this.ts.tokenBeg - functionNode.getPosition());
                }
            }
        } finally {
            this.nestingOfFunctionParams--;
        }
    }

    private int peekFlaggedToken() {
        peekToken();
        return this.currentFlaggedToken;
    }

    private int peekToken() {
        if (this.currentFlaggedToken != 0) {
            return this.currentToken;
        }
        int token = this.ts.getToken();
        boolean z = false;
        while (true) {
            if (token != 1 && token != 175) {
                break;
            }
            if (token == 1) {
                token = this.ts.getToken();
                z = true;
            } else {
                boolean zIsRecordingComments = this.compilerEnv.isRecordingComments();
                TokenStream tokenStream = this.ts;
                if (zIsRecordingComments) {
                    recordComment(this.ts.getTokenStartLineno(), this.ts.getTokenColumn(), tokenStream.getAndResetCurrentComment());
                    break;
                }
                token = tokenStream.getToken();
            }
        }
        this.currentToken = token;
        this.currentFlaggedToken = (z ? 65536 : 0) | token;
        return token;
    }

    private int peekTokenOrEOL() {
        int iPeekToken = peekToken();
        if ((this.currentFlaggedToken & 65536) != 0) {
            return 1;
        }
        return iPeekToken;
    }

    private int peekUntilNonComment(int i) {
        while (i == 175) {
            consumeToken();
            i = peekToken();
        }
        return i;
    }

    private ObjectProperty plainProperty(AstNode astNode, int i) {
        int iPeekToken = peekToken();
        if ((iPeekToken == 98 || iPeekToken == 95) && i == 44 && this.compilerEnv.getLanguageVersion() >= 180) {
            if (!this.inDestructuringAssignment && this.compilerEnv.getLanguageVersion() < 200) {
                reportError("msg.bad.object.init");
            }
            Name name = new Name(astNode.getPosition(), astNode.getString());
            ObjectProperty objectProperty = new ObjectProperty();
            objectProperty.setIsShorthand(true);
            objectProperty.setLeftAndRight(astNode, name);
            return objectProperty;
        }
        if (iPeekToken != 99) {
            mustMatchToken(Token.COLON, "msg.no.colon.prop", true);
            ObjectProperty objectProperty2 = new ObjectProperty();
            objectProperty2.setOperatorPosition(this.ts.tokenBeg);
            objectProperty2.setLeftAndRight(astNode, assignExpr());
            return objectProperty2;
        }
        ObjectProperty objectProperty3 = new ObjectProperty();
        consumeToken();
        Assignment assignment = new Assignment(astNode, assignExpr());
        assignment.setType(99);
        objectProperty3.setLeftAndRight(astNode, assignment);
        return objectProperty3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.ast.AstNode primaryExpr() {
        /*
            Method dump skipped, instruction units count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.primaryExpr():org.mozilla.javascript.ast.AstNode");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void processDestructuringDefaults(int i, Node node, List<String> list, Assignment assignment, Node node2, int i2, Transformer transformer) {
        AstNode left = assignment.getLeft();
        if (left.getType() == 44) {
            String string = left.getString();
            AstNode right = assignment.getRight();
            Node nodeTransform = right;
            if (transformer != null) {
                nodeTransform = transformer.transform(right);
            }
            Node node3 = new Node(Token.HOOK, new Node(51, createName("undefined"), node2), nodeTransform, node2);
            Node node4 = new Node(Token.HOOK, new Node(51, createName("undefined"), createName(string)), node3, left);
            if (transformer == null) {
                this.currentScriptOrFn.putDestructuringRvalues(node3, nodeTransform);
            }
            node.addChildToBack(new Node(i2, createName(54, string, null), node4));
            if (i != -1) {
                defineSymbol(i, string, true);
                list.add(string);
            }
        }
    }

    private AstNode propertyAccess(int i, AstNode astNode, boolean z) {
        int i2;
        AstNode astNodePropertyName;
        String strKeywordToName;
        if (astNode == null) {
            codeBug();
        }
        if (astNode.getType() == 79 && z) {
            reportError("msg.optional.super");
            return makeErrorNode();
        }
        int iLineNumber = lineNumber();
        int i3 = this.ts.tokenBeg;
        int iColumnNumber = columnNumber();
        consumeToken();
        if (i == 157) {
            mustHaveXML();
            i2 = 4;
        } else {
            i2 = 0;
        }
        if (!this.compilerEnv.isXmlAvailable()) {
            if (nextToken() != 44 && (!this.compilerEnv.isReservedKeywordAsIdentifier() || !TokenStream.isKeyword(this.ts.getString(), this.compilerEnv.getLanguageVersion(), this.inUseStrictDirective))) {
                reportError("msg.no.name.after.dot");
            }
            PropertyGet propertyGet = new PropertyGet(astNode, createNameNode(true, 33), i3);
            propertyGet.setLineColumnNumber(iLineNumber, iColumnNumber);
            return propertyGet;
        }
        int iNextToken = nextToken();
        if (iNextToken == 23) {
            saveNameTokenData(this.ts.tokenBeg, "*", lineNumber(), columnNumber());
            astNodePropertyName = propertyName(-1, i2);
        } else if (iNextToken == 44) {
            astNodePropertyName = propertyName(-1, i2);
        } else if (iNextToken == 55) {
            saveNameTokenData(this.ts.tokenBeg, "throw", lineNumber(), columnNumber());
            astNodePropertyName = propertyName(-1, i2);
        } else {
            if (iNextToken == 92) {
                if (i != 186) {
                    reportError("msg.no.name.after.dot");
                    return makeErrorNode();
                }
                consumeToken();
                ElementGet elementGetMakeElemGet = makeElemGet(astNode, this.ts.tokenBeg);
                elementGetMakeElemGet.setType(Token.QUESTION_DOT);
                return elementGetMakeElemGet;
            }
            if (iNextToken == 96) {
                if (i == 186) {
                    return makeFunctionCall(astNode, astNode.getPosition(), z);
                }
                reportError("msg.no.name.after.dot");
                return makeErrorNode();
            }
            if (iNextToken == 140) {
                saveNameTokenData(this.ts.tokenBeg, this.ts.getString(), lineNumber(), columnNumber());
                astNodePropertyName = propertyName(-1, i2);
            } else if (iNextToken == 161) {
                astNodePropertyName = attributeAccess();
            } else {
                if (!this.compilerEnv.isReservedKeywordAsIdentifier() || (strKeywordToName = Token.keywordToName(iNextToken)) == null) {
                    reportError("msg.no.name.after.dot");
                    return makeErrorNode();
                }
                saveNameTokenData(this.ts.tokenBeg, strKeywordToName, lineNumber(), columnNumber());
                astNodePropertyName = propertyName(-1, i2);
            }
        }
        boolean z2 = astNodePropertyName instanceof XmlRef;
        InfixExpression xmlMemberGet = z2 ? new XmlMemberGet() : new PropertyGet();
        if (z2 && i == 121) {
            xmlMemberGet.setType(Token.DOT);
        }
        if (z) {
            xmlMemberGet.setType(Token.QUESTION_DOT);
        }
        int position = astNode.getPosition();
        xmlMemberGet.setPosition(position);
        xmlMemberGet.setLength(getNodeEnd(astNodePropertyName) - position);
        xmlMemberGet.setOperatorPosition(i3 - position);
        xmlMemberGet.setLineColumnNumber(iLineNumber, iColumnNumber);
        xmlMemberGet.setLeft(astNode);
        xmlMemberGet.setRight(astNodePropertyName);
        return xmlMemberGet;
    }

    private AstNode propertyName(int i, int i2) {
        Name nameCreateNameNode;
        int i3;
        int i4 = i != -1 ? i : this.ts.tokenBeg;
        int iLineNumber = lineNumber();
        int iColumnNumber = columnNumber();
        Name nameCreateNameNode2 = createNameNode(true, this.currentToken);
        if (matchToken(Token.COLONCOLON, true)) {
            i3 = this.ts.tokenBeg;
            int iNextToken = nextToken();
            if (iNextToken == 23) {
                saveNameTokenData(this.ts.tokenBeg, "*", lineNumber(), columnNumber());
                nameCreateNameNode = createNameNode(false, -1);
            } else {
                if (iNextToken != 44) {
                    if (iNextToken == 92) {
                        return xmlElemRef(i, nameCreateNameNode2, i3);
                    }
                    reportError("msg.no.name.after.coloncolon");
                    return makeErrorNode();
                }
                nameCreateNameNode = createNameNode();
            }
        } else {
            nameCreateNameNode2 = null;
            nameCreateNameNode = nameCreateNameNode2;
            i3 = -1;
        }
        if (nameCreateNameNode2 == null && i2 == 0 && i == -1) {
            return nameCreateNameNode;
        }
        XmlPropRef xmlPropRef = new XmlPropRef(i4, getNodeEnd(nameCreateNameNode) - i4);
        xmlPropRef.setAtPos(i);
        xmlPropRef.setNamespace(nameCreateNameNode2);
        xmlPropRef.setColonPos(i3);
        xmlPropRef.setPropName(nameCreateNameNode);
        xmlPropRef.setLineColumnNumber(iLineNumber, iColumnNumber);
        return xmlPropRef;
    }

    private void recordComment(int i, int i2, String str) {
        if (this.scannedComments == null) {
            this.scannedComments = new ArrayList();
        }
        TokenStream tokenStream = this.ts;
        Comment comment = new Comment(tokenStream.tokenBeg, tokenStream.getTokenLength(), this.ts.commentType, str);
        if (this.ts.commentType == Token.CommentType.JSDOC && this.compilerEnv.isRecordingLocalJsDocComments()) {
            TokenStream tokenStream2 = this.ts;
            Comment comment2 = new Comment(tokenStream2.tokenBeg, tokenStream2.getTokenLength(), this.ts.commentType, str);
            this.currentJsDocComment = comment2;
            comment2.setLineColumnNumber(i, i2);
        }
        comment.setLineColumnNumber(i, i2);
        this.scannedComments.add(comment);
    }

    private void recordLabel(Label label, LabeledStatement labeledStatement) {
        if (peekToken() != 116) {
            codeBug();
        }
        consumeToken();
        String name = label.getName();
        Map<String, LabeledStatement> map = this.labelSet;
        if (map == null) {
            this.labelSet = new HashMap();
        } else {
            LabeledStatement labeledStatement2 = map.get(name);
            if (labeledStatement2 != null) {
                if (this.compilerEnv.isIdeMode()) {
                    Label labelByName = labeledStatement2.getLabelByName(name);
                    reportError("msg.dup.label", labelByName.getAbsolutePosition(), labelByName.getLength());
                }
                reportError("msg.dup.label", label.getPosition(), label.getLength());
            }
        }
        labeledStatement.addLabel(label);
        this.labelSet.put(name, labeledStatement);
    }

    private AstNode relExpr() {
        AstNode astNodeShiftExpr = shiftExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            if (iPeekToken != 57) {
                if (iPeekToken != 58) {
                    switch (iPeekToken) {
                    }
                } else {
                    continue;
                }
                consumeToken();
                astNodeShiftExpr = new InfixExpression(iPeekToken, astNodeShiftExpr, shiftExpr(), i);
            } else if (!this.inForInit) {
                consumeToken();
                astNodeShiftExpr = new InfixExpression(iPeekToken, astNodeShiftExpr, shiftExpr(), i);
            }
        }
        return astNodeShiftExpr;
    }

    private void restoreRelativeLoopPosition(Loop loop) {
        if (loop.getParent() != null) {
            loop.setRelative(loop.getParent().getPosition());
        }
    }

    private AstNode returnOrYield(int i, boolean z) {
        boolean z2;
        int nodeEnd;
        AstNode astNodeExpr;
        AstNode yield;
        if (!insideFunctionBody()) {
            reportError(i == 4 ? "msg.bad.return" : "msg.bad.yield");
        }
        consumeToken();
        int iLineNumber = lineNumber();
        int iColumnNumber = columnNumber();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        int i3 = tokenStream.tokenEnd;
        if (i == 78 && this.compilerEnv.getLanguageVersion() >= 200 && peekToken() == 23) {
            consumeToken();
            z2 = true;
        } else {
            z2 = false;
        }
        int iPeekTokenOrEOL = peekTokenOrEOL();
        if (iPeekTokenOrEOL == -1 || iPeekTokenOrEOL == 0 || iPeekTokenOrEOL == 1 || (iPeekTokenOrEOL == 78 ? this.compilerEnv.getLanguageVersion() < 200 : iPeekTokenOrEOL == 91 || iPeekTokenOrEOL == 93 || iPeekTokenOrEOL == 95 || iPeekTokenOrEOL == 97)) {
            nodeEnd = i3;
            astNodeExpr = null;
        } else {
            astNodeExpr = expr(false);
            nodeEnd = getNodeEnd(astNodeExpr);
        }
        int i4 = this.endFlags;
        if (i == 4) {
            this.endFlags = i4 | (astNodeExpr == null ? 2 : 4);
            int i5 = nodeEnd - i2;
            yield = new ReturnStatement(i2, i5, astNodeExpr);
            if (nowAllSet(i4, this.endFlags, 6)) {
                addStrictWarning("msg.return.inconsistent", "", i2, i5);
            }
        } else {
            if (!insideFunctionBody()) {
                reportError("msg.bad.yield");
            }
            this.endFlags |= 8;
            yield = new Yield(i2, nodeEnd - i2, astNodeExpr, z2);
            setRequiresActivation();
            setIsGenerator();
            if (!z) {
                yield.setLineColumnNumber(iLineNumber, iColumnNumber);
                yield = new ExpressionStatement(yield);
            }
        }
        if (insideFunctionBody() && nowAllSet(i4, this.endFlags, 12) && !((FunctionNode) this.currentScriptOrFn).isES6Generator()) {
            Name functionName = ((FunctionNode) this.currentScriptOrFn).getFunctionName();
            if (functionName == null || functionName.length() == 0) {
                addError("msg.anon.generator.returns", "");
            } else {
                addError("msg.generator.returns", functionName.getIdentifier());
            }
        }
        yield.setLineColumnNumber(iLineNumber, iColumnNumber);
        return yield;
    }

    private void saveNameTokenData(int i, String str, int i2, int i3) {
        this.prevNameTokenStart = i;
        this.prevNameTokenString = str;
        this.prevNameTokenLineno = i2;
        this.prevNameTokenColumn = i3;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void setupDefaultValues(String str, Node node, AstNode astNode, int i, Transformer transformer) {
        Node nodeTransform = astNode;
        if (astNode != null) {
            if (transformer != null) {
                nodeTransform = transformer.transform(astNode);
            }
            Node node2 = new Node(Token.HOOK, new Node(51, createName(str), createName("undefined")), nodeTransform, createName(str));
            if (transformer == null) {
                this.currentScriptOrFn.putDestructuringRvalues(node2, nodeTransform);
            }
            node.addChildToBack(new Node(i, createName(54, str, null), node2));
        }
    }

    private AstNode shiftExpr() {
        AstNode astNodeAddExpr = addExpr();
        while (true) {
            int iPeekToken = peekToken();
            int i = this.ts.tokenBeg;
            switch (iPeekToken) {
                case 18:
                case 19:
                case 20:
                    consumeToken();
                    astNodeAddExpr = new InfixExpression(iPeekToken, astNodeAddExpr, addExpr(), i);
                    break;
                default:
                    return astNodeAddExpr;
            }
        }
    }

    private AstNode statement() {
        int iPeekTokenOrEOL;
        int i = this.ts.tokenBeg;
        try {
            AstNode astNodeStatementHelper = statementHelper();
            if (astNodeStatementHelper != null) {
                if (this.compilerEnv.isStrictMode() && !astNodeStatementHelper.hasSideEffects()) {
                    int position = astNodeStatementHelper.getPosition();
                    int iMax = Math.max(position, lineBeginningFor(position));
                    addStrictWarning(astNodeStatementHelper instanceof EmptyStatement ? "msg.extra.trailing.semi" : "msg.no.side.effects", "", iMax, nodeEnd(astNodeStatementHelper) - iMax);
                }
                if (peekToken() == 175) {
                    int lineno = astNodeStatementHelper.getLineno();
                    List<Comment> list = this.scannedComments;
                    if (lineno == list.get(list.size() - 1).getLineno()) {
                        List<Comment> list2 = this.scannedComments;
                        astNodeStatementHelper.setInlineComment(list2.get(list2.size() - 1));
                        consumeToken();
                    }
                }
                return astNodeStatementHelper;
            }
        } catch (ParserException unused) {
        }
        do {
            iPeekTokenOrEOL = peekTokenOrEOL();
            consumeToken();
            if (iPeekTokenOrEOL == -1 || iPeekTokenOrEOL == 0 || iPeekTokenOrEOL == 1) {
                break;
            }
        } while (iPeekTokenOrEOL != 91);
        return new EmptyStatement(i, this.ts.tokenBeg - i);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.ast.AstNode statementHelper() {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.statementHelper():org.mozilla.javascript.ast.AstNode");
    }

    private AstNode statements(AstNode astNode) {
        if (this.currentToken != 94 && !this.compilerEnv.isIdeMode()) {
            codeBug();
        }
        int i = this.ts.tokenBeg;
        if (astNode == null) {
            astNode = new Block(i);
        }
        astNode.setLineColumnNumber(lineNumber(), columnNumber());
        while (true) {
            int iPeekToken = peekToken();
            if (iPeekToken <= 0 || iPeekToken == 95) {
                break;
            }
            astNode.addChild(statement());
        }
        astNode.setLength(this.ts.tokenBeg - i);
        return astNode;
    }

    private SwitchStatement switchStatement() {
        boolean z;
        AstNode astNode;
        if (this.currentToken != 127) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        SwitchStatement switchStatement = new SwitchStatement(i);
        switchStatement.setLineColumnNumber(lineNumber(), columnNumber());
        if (mustMatchToken(96, "msg.no.paren.switch", true)) {
            switchStatement.setLp(this.ts.tokenBeg - i);
        }
        switchStatement.setExpression(expr(false));
        enterSwitch(switchStatement);
        try {
            if (mustMatchToken(97, "msg.no.paren.after.switch", true)) {
                switchStatement.setRp(this.ts.tokenBeg - i);
            }
            mustMatchToken(94, "msg.no.brace.switch", true);
            boolean z2 = false;
            while (true) {
                int iNextToken = nextToken();
                int i2 = this.ts.tokenBeg;
                int iLineNumber = lineNumber();
                int iColumnNumber = columnNumber();
                if (iNextToken == 95) {
                    switchStatement.setLength(this.ts.tokenEnd - i);
                    break;
                }
                if (iNextToken != 175) {
                    if (iNextToken == 128) {
                        AstNode astNodeExpr = expr(false);
                        mustMatchToken(Token.COLON, "msg.no.colon.case", true);
                        z = z2;
                        astNode = astNodeExpr;
                    } else {
                        if (iNextToken != 129) {
                            reportError("msg.bad.switch");
                            break;
                        }
                        if (z2) {
                            reportError("msg.double.switch.default");
                        }
                        mustMatchToken(Token.COLON, "msg.no.colon.case", true);
                        astNode = null;
                        z = true;
                    }
                    SwitchCase switchCase = new SwitchCase(i2);
                    switchCase.setExpression(astNode);
                    switchCase.setLength(this.ts.tokenEnd - i);
                    switchCase.setLineColumnNumber(iLineNumber, iColumnNumber);
                    while (true) {
                        int iPeekToken = peekToken();
                        if (iPeekToken == 95 || iPeekToken == 128 || iPeekToken == 129 || iPeekToken == 0) {
                            break;
                        }
                        if (iPeekToken == 175) {
                            List<Comment> list = this.scannedComments;
                            Comment comment = list.get(list.size() - 1);
                            if (switchCase.getInlineComment() == null && comment.getLineno() == switchCase.getLineno()) {
                                switchCase.setInlineComment(comment);
                            } else {
                                switchCase.addStatement(comment);
                            }
                            consumeToken();
                        } else {
                            switchCase.addStatement(statement());
                        }
                    }
                    switchStatement.addCase(switchCase);
                    z2 = z;
                } else {
                    List<Comment> list2 = this.scannedComments;
                    switchStatement.addChild(list2.get(list2.size() - 1));
                }
            }
            exitSwitch();
            return switchStatement;
        } catch (Throwable th) {
            exitSwitch();
            throw th;
        }
    }

    private AstNode taggedTemplateLiteral(AstNode astNode) {
        AstNode astNodeTemplateLiteral = templateLiteral(true);
        TaggedTemplateLiteral taggedTemplateLiteral = new TaggedTemplateLiteral();
        taggedTemplateLiteral.setTarget(astNode);
        taggedTemplateLiteral.setTemplateLiteral(astNodeTemplateLiteral);
        taggedTemplateLiteral.setLineColumnNumber(astNode.getLineno(), astNode.getColumn());
        return taggedTemplateLiteral;
    }

    private AstNode templateLiteral(boolean z) {
        if (this.currentToken != 180) {
            codeBug();
        }
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        int i2 = tokenStream.tokenEnd;
        int iLineNumber = lineNumber();
        int iColumnNumber = columnNumber();
        ArrayList arrayList = new ArrayList();
        TemplateLiteral templateLiteral = new TemplateLiteral(i);
        TokenStream tokenStream2 = this.ts;
        int i3 = tokenStream2.tokenBeg + 1;
        int templateLiteral2 = tokenStream2.readTemplateLiteral(z);
        while (templateLiteral2 == 182) {
            arrayList.add(createTemplateLiteralCharacters(i3));
            arrayList.add(expr(false));
            mustMatchToken(95, "msg.syntax", true);
            TokenStream tokenStream3 = this.ts;
            i3 = tokenStream3.tokenBeg + 1;
            templateLiteral2 = tokenStream3.readTemplateLiteral(z);
        }
        if (templateLiteral2 == -1) {
            return makeErrorNode();
        }
        arrayList.add(createTemplateLiteralCharacters(i3));
        int i4 = this.ts.tokenEnd;
        templateLiteral.setElements(arrayList);
        templateLiteral.setLength(i4 - i);
        templateLiteral.setLineColumnNumber(iLineNumber, iColumnNumber);
        return templateLiteral;
    }

    private ThrowStatement throwStatement() {
        if (this.currentToken != 55) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        int iLineNumber = lineNumber();
        int iColumnNumber = columnNumber();
        if (peekTokenOrEOL() == 1) {
            reportError("msg.bad.throw.eol");
        }
        ThrowStatement throwStatement = new ThrowStatement(i, expr(false));
        throwStatement.setLineColumnNumber(iLineNumber, iColumnNumber);
        return throwStatement;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x017f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.mozilla.javascript.ast.TryStatement tryStatement() {
        /*
            Method dump skipped, instruction units count: 482
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.tryStatement():org.mozilla.javascript.ast.TryStatement");
    }

    private AstNode unaryExpr() {
        int iPeekToken = peekToken();
        if (iPeekToken == 175) {
            consumeToken();
            iPeekToken = peekUntilNonComment(iPeekToken);
        }
        if (iPeekToken == -1) {
            consumeToken();
            return makeErrorNode();
        }
        if (iPeekToken != 14) {
            if (iPeekToken != 139) {
                if (iPeekToken == 21) {
                    consumeToken();
                    int iLineNumber = lineNumber();
                    int iColumnNumber = columnNumber();
                    UnaryExpression unaryExpression = new UnaryExpression(28, this.ts.tokenBeg, unaryExpr());
                    unaryExpression.setLineColumnNumber(iLineNumber, iColumnNumber);
                    return unaryExpression;
                }
                if (iPeekToken == 22) {
                    consumeToken();
                    int iLineNumber2 = lineNumber();
                    int iColumnNumber2 = columnNumber();
                    UnaryExpression unaryExpression2 = new UnaryExpression(29, this.ts.tokenBeg, unaryExpr());
                    unaryExpression2.setLineColumnNumber(iLineNumber2, iColumnNumber2);
                    return unaryExpression2;
                }
                if (iPeekToken != 26 && iPeekToken != 27) {
                    if (iPeekToken == 31) {
                        consumeToken();
                        int iLineNumber3 = lineNumber();
                        int iColumnNumber3 = columnNumber();
                        UnaryExpression unaryExpression3 = new UnaryExpression(iPeekToken, this.ts.tokenBeg, unaryExpr());
                        unaryExpression3.setLineColumnNumber(iLineNumber3, iColumnNumber3);
                        return unaryExpression3;
                    }
                    if (iPeekToken != 32) {
                        if (iPeekToken == 119 || iPeekToken == 120) {
                            consumeToken();
                            int iLineNumber4 = lineNumber();
                            int iColumnNumber4 = columnNumber();
                            UpdateExpression updateExpression = new UpdateExpression(iPeekToken, this.ts.tokenBeg, memberExpr(true));
                            updateExpression.setLineColumnNumber(iLineNumber4, iColumnNumber4);
                            checkBadIncDec(updateExpression);
                            return updateExpression;
                        }
                    }
                }
            }
            consumeToken();
            int iLineNumber5 = lineNumber();
            int iColumnNumber5 = columnNumber();
            UnaryExpression unaryExpression4 = new UnaryExpression(iPeekToken, this.ts.tokenBeg, unaryExpr());
            unaryExpression4.setLineColumnNumber(iLineNumber5, iColumnNumber5);
            return unaryExpression4;
        }
        if (this.compilerEnv.isXmlAvailable()) {
            consumeToken();
            return memberExprTail(true, xmlInitializer());
        }
        AstNode astNodeMemberExpr = memberExpr(true);
        int iPeekTokenOrEOL = peekTokenOrEOL();
        if (iPeekTokenOrEOL != 119 && iPeekTokenOrEOL != 120) {
            return astNodeMemberExpr;
        }
        consumeToken();
        UpdateExpression updateExpression2 = new UpdateExpression(iPeekTokenOrEOL, this.ts.tokenBeg, astNodeMemberExpr, true);
        updateExpression2.setLineColumnNumber(astNodeMemberExpr.getLineno(), astNodeMemberExpr.getColumn());
        checkBadIncDec(updateExpression2);
        return updateExpression2;
    }

    private VariableDeclaration variables(int i, int i2, boolean z) {
        AstNode astNodeDestructuringPrimaryExpr;
        int nodeEnd;
        Name name;
        VariableDeclaration variableDeclaration = new VariableDeclaration(i2);
        variableDeclaration.setType(i);
        variableDeclaration.setLineColumnNumber(lineNumber(), columnNumber());
        Comment andResetJsDoc = getAndResetJsDoc();
        if (andResetJsDoc != null) {
            variableDeclaration.setJsDocNode(andResetJsDoc);
        }
        do {
            int iPeekToken = peekToken();
            TokenStream tokenStream = this.ts;
            int i3 = tokenStream.tokenBeg;
            int i4 = tokenStream.tokenEnd;
            AstNode astNodeAssignExpr = null;
            if (iPeekToken == 92 || iPeekToken == 94) {
                astNodeDestructuringPrimaryExpr = destructuringPrimaryExpr();
                int nodeEnd2 = getNodeEnd(astNodeDestructuringPrimaryExpr);
                if (!(astNodeDestructuringPrimaryExpr instanceof DestructuringForm)) {
                    reportError("msg.bad.assign.left", i3, nodeEnd2 - i3);
                }
                markDestructuring(astNodeDestructuringPrimaryExpr);
                nodeEnd = nodeEnd2;
                name = null;
            } else {
                mustMatchToken(44, "msg.bad.var", true);
                Name nameCreateNameNode = createNameNode();
                nameCreateNameNode.setLineColumnNumber(lineNumber(), columnNumber());
                if (this.inUseStrictDirective) {
                    String string = this.ts.getString();
                    if ("eval".equals(string) || "arguments".equals(this.ts.getString())) {
                        reportError("msg.bad.id.strict", string);
                    }
                }
                defineSymbol(i, this.ts.getString(), this.inForInit);
                nodeEnd = i4;
                name = nameCreateNameNode;
                astNodeDestructuringPrimaryExpr = null;
            }
            int iLineNumber = lineNumber();
            int iColumnNumber = columnNumber();
            Comment andResetJsDoc2 = getAndResetJsDoc();
            if (matchToken(99, true)) {
                astNodeAssignExpr = assignExpr();
                nodeEnd = getNodeEnd(astNodeAssignExpr);
            }
            VariableInitializer variableInitializer = new VariableInitializer(i3, nodeEnd - i3);
            if (astNodeDestructuringPrimaryExpr != null) {
                if (astNodeAssignExpr == null && !this.inForInit) {
                    reportError("msg.destruct.assign.no.init");
                }
                variableInitializer.setTarget(astNodeDestructuringPrimaryExpr);
            } else {
                variableInitializer.setTarget(name);
            }
            variableInitializer.setInitializer(astNodeAssignExpr);
            variableInitializer.setType(i);
            variableInitializer.setJsDocNode(andResetJsDoc2);
            variableInitializer.setLineColumnNumber(iLineNumber, iColumnNumber);
            variableDeclaration.addVariable(variableInitializer);
        } while (matchToken(98, true));
        variableDeclaration.setLength(nodeEnd - i2);
        variableDeclaration.setIsStatement(z);
        return variableDeclaration;
    }

    private void warnMissingSemi(int i, int i2) {
        if (this.compilerEnv.isStrictMode()) {
            int[] iArr = new int[2];
            String line = this.ts.getLine(i2, iArr);
            if (this.compilerEnv.isIdeMode()) {
                i = Math.max(i, i2 - iArr[1]);
            }
            int i3 = i;
            if (line != null) {
                addStrictWarning("msg.missing.semi", "", i3, i2 - i3, iArr[0], line, iArr[1]);
            } else {
                addStrictWarning("msg.missing.semi", "", i3, i2 - i3);
            }
        }
    }

    private void warnTrailingComma(int i, List<?> list, int i2) {
        if (this.compilerEnv.getWarnTrailingComma()) {
            if (!list.isEmpty()) {
                i = ((AstNode) list.get(0)).getPosition();
            }
            int iMax = Math.max(i, lineBeginningFor(i2));
            addWarning("msg.extra.trailing.comma", iMax, i2 - iMax);
        }
    }

    private WhileLoop whileLoop() {
        if (this.currentToken != 130) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        WhileLoop whileLoop = new WhileLoop(i);
        whileLoop.setLineColumnNumber(lineNumber(), columnNumber());
        enterLoop(whileLoop);
        try {
            ConditionData conditionDataCondition = condition();
            whileLoop.setCondition(conditionDataCondition.condition);
            whileLoop.setParens(conditionDataCondition.lp - i, conditionDataCondition.rp - i);
            AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(whileLoop);
            whileLoop.setLength(getNodeEnd(nextStatementAfterInlineComments) - i);
            restoreRelativeLoopPosition(whileLoop);
            whileLoop.setBody(nextStatementAfterInlineComments);
            return whileLoop;
        } finally {
            exitLoop();
        }
    }

    private WithStatement withStatement() {
        if (this.currentToken != 136) {
            codeBug();
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        int iLineNumber = lineNumber();
        int iColumnNumber = columnNumber();
        int i = this.ts.tokenBeg;
        int i2 = mustMatchToken(96, "msg.no.paren.with", true) ? this.ts.tokenBeg : -1;
        AstNode astNodeExpr = expr(false);
        int i3 = mustMatchToken(97, "msg.no.paren.after.with", true) ? this.ts.tokenBeg : -1;
        WithStatement withStatement = new WithStatement(i);
        AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(withStatement);
        withStatement.setLength(getNodeEnd(nextStatementAfterInlineComments) - i);
        withStatement.setJsDocNode(andResetJsDoc);
        withStatement.setExpression(astNodeExpr);
        withStatement.setStatement(nextStatementAfterInlineComments);
        withStatement.setParens(i2, i3);
        withStatement.setLineColumnNumber(iLineNumber, iColumnNumber);
        return withStatement;
    }

    private XmlElemRef xmlElemRef(int i, Name name, int i2) {
        int i3 = this.ts.tokenBeg;
        int i4 = -1;
        int i5 = i != -1 ? i : i3;
        AstNode astNodeExpr = expr(false);
        int nodeEnd = getNodeEnd(astNodeExpr);
        if (mustMatchToken(93, "msg.no.bracket.index", true)) {
            TokenStream tokenStream = this.ts;
            i4 = tokenStream.tokenBeg;
            nodeEnd = tokenStream.tokenEnd;
        }
        XmlElemRef xmlElemRef = new XmlElemRef(i5, nodeEnd - i5);
        xmlElemRef.setNamespace(name);
        xmlElemRef.setColonPos(i2);
        xmlElemRef.setAtPos(i);
        xmlElemRef.setExpression(astNodeExpr);
        xmlElemRef.setBrackets(i3, i4);
        return xmlElemRef;
    }

    private AstNode xmlInitializer() {
        if (this.currentToken != 14) {
            codeBug();
        }
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        int firstXMLToken = tokenStream.getFirstXMLToken();
        if (firstXMLToken != 159 && firstXMLToken != 162) {
            reportError("msg.syntax");
            return makeErrorNode();
        }
        XmlLiteral xmlLiteral = new XmlLiteral(i);
        xmlLiteral.setLineColumnNumber(lineNumber(), columnNumber());
        while (firstXMLToken == 159) {
            TokenStream tokenStream2 = this.ts;
            xmlLiteral.addFragment(new XmlString(tokenStream2.tokenBeg, tokenStream2.getString()));
            mustMatchToken(94, "msg.syntax", true);
            int i2 = this.ts.tokenBeg;
            AstNode emptyExpression = peekToken() == 95 ? new EmptyExpression(i2, this.ts.tokenEnd - i2) : expr(false);
            mustMatchToken(95, "msg.syntax", true);
            XmlExpression xmlExpression = new XmlExpression(i2, emptyExpression);
            xmlExpression.setIsXmlAttribute(this.ts.isXMLAttribute());
            xmlExpression.setLength(this.ts.tokenEnd - i2);
            xmlLiteral.addFragment(xmlExpression);
            firstXMLToken = this.ts.getNextXMLToken();
        }
        if (firstXMLToken != 162) {
            reportError("msg.syntax");
            return makeErrorNode();
        }
        TokenStream tokenStream3 = this.ts;
        xmlLiteral.addFragment(new XmlString(tokenStream3.tokenBeg, tokenStream3.getString()));
        return xmlLiteral;
    }

    public void addError(String str, String str2, int i, int i2) {
        this.syntaxErrorCount++;
        String strLookupMessage = lookupMessage(str, str2);
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.error(strLookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.error(strLookupMessage, this.sourceURI, this.currentPos.getLineno(), this.currentPos.getLine(), this.currentPos.getOffset());
        }
    }

    public void addStrictWarning(String str, String str2) {
        addStrictWarning(str, str2, this.currentPos.getPosition(), this.currentPos.getLength());
    }

    public void addWarning(String str, String str2, int i, int i2) {
        String strLookupMessage = lookupMessage(str, str2);
        if (this.compilerEnv.reportWarningAsError()) {
            addError(str, str2, i, i2);
            return;
        }
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.warning(strLookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.warning(strLookupMessage, this.sourceURI, this.currentPos.getLineno(), this.currentPos.getLine(), this.currentPos.getOffset());
        }
    }

    public void checkActivationName(String str, int i) {
        if (insideFunctionBody()) {
            if ((!"arguments".equals(str) || ((FunctionNode) this.currentScriptOrFn).getFunctionType() == 4) && ((this.compilerEnv.getActivationNames() == null || !this.compilerEnv.getActivationNames().contains(str)) && !(org.simpleframework.xml.strategy.Name.LENGTH.equals(str) && i == 33 && this.compilerEnv.getLanguageVersion() == 120))) {
                return;
            }
            setRequiresActivation();
        }
    }

    public void checkMutableReference(Node node) {
        if ((node.getIntProp(16, 0) & 4) != 0) {
            reportError("msg.bad.assign.left");
        }
    }

    public Node createDestructuringAssignment(int i, Node node, Node node2, AstNode astNode, Transformer transformer) {
        String nextTempName = this.currentScriptOrFn.getNextTempName();
        Node nodeDestructuringAssignmentHelper = destructuringAssignmentHelper(i, node, node2, nextTempName, astNode, transformer);
        nodeDestructuringAssignmentHelper.getLastChild().addChildToBack(createName(nextTempName));
        return nodeDestructuringAssignmentHelper;
    }

    public Node createName(int i, String str, Node node) {
        Node nodeCreateName = createName(str);
        nodeCreateName.setType(i);
        if (node != null) {
            nodeCreateName.addChildToBack(node);
        }
        return nodeCreateName;
    }

    public Node createNumber(double d) {
        return Node.newNumber(d);
    }

    public PerFunctionVariables createPerFunctionVariables(FunctionNode functionNode) {
        return new PerFunctionVariables(functionNode);
    }

    public Scope createScopeNode(int i, int i2, int i3) {
        Scope scope = new Scope();
        scope.setType(i);
        scope.setLineColumnNumber(i2, i3);
        return scope;
    }

    public void defineSymbol(int i, String str, boolean z) {
        if (str == null) {
            if (this.compilerEnv.isIdeMode()) {
                return;
            } else {
                codeBug();
            }
        }
        Scope definingScope = this.currentScope.getDefiningScope(str);
        org.mozilla.javascript.ast.Symbol symbol = definingScope != null ? definingScope.getSymbol(str) : null;
        int declType = symbol != null ? symbol.getDeclType() : -1;
        String str2 = "msg.var.redecl";
        if (symbol != null && (declType == 168 || i == 168 || (definingScope == this.currentScope && declType == 167))) {
            if (declType == 168) {
                str2 = "msg.const.redecl";
            } else if (declType == 167) {
                str2 = "msg.let.redecl";
            } else if (declType != 135) {
                str2 = declType == 122 ? "msg.fn.redecl" : "msg.parm.redecl";
            }
            addError(str2, str);
            return;
        }
        if (i == 96) {
            if (symbol != null) {
                addWarning("msg.dup.parms", str);
            }
            this.currentScriptOrFn.putSymbol(new org.mozilla.javascript.ast.Symbol(i, str));
            return;
        }
        if (i != 122 && i != 135) {
            if (i == 167) {
                if (z || !(this.currentScope.getType() == 125 || (this.currentScope instanceof Loop))) {
                    this.currentScope.putSymbol(new org.mozilla.javascript.ast.Symbol(i, str));
                    return;
                } else {
                    addError("msg.let.decl.not.in.block");
                    return;
                }
            }
            if (i != 168) {
                throw codeBug();
            }
        }
        if (symbol == null) {
            this.currentScriptOrFn.putSymbol(new org.mozilla.javascript.ast.Symbol(i, str));
        } else if (declType == 135) {
            addStrictWarning("msg.var.redecl", str);
        } else if (declType == 96) {
            addStrictWarning("msg.var.hides.arg", str);
        }
    }

    public boolean destructuringArray(ArrayLiteral arrayLiteral, int i, String str, Node node, List<String> list, AstNode astNode, Transformer transformer) {
        Node node2;
        boolean z;
        int i2;
        Parser parser = this;
        int i3 = i;
        int i4 = i3 == 168 ? Token.SETCONST : 8;
        boolean z2 = false;
        int i5 = 0;
        boolean z3 = true;
        for (AstNode astNode2 : arrayLiteral.getElements()) {
            if (astNode2.getType() == 141) {
                i5++;
            } else {
                Node node3 = new Node(39, parser.createName(str), parser.createNumber(i5));
                if (astNode == null || z2) {
                    node2 = node;
                    z = z2;
                } else {
                    node2 = node;
                    parser.setupDefaultValues(str, node2, astNode, i4, transformer);
                    z = true;
                }
                if (astNode2.getType() == 44) {
                    String string = astNode2.getString();
                    node2.addChildToBack(new Node(i4, parser.createName(54, string, null), node3));
                    if (i3 != -1) {
                        parser.defineSymbol(i3, string, true);
                        list.add(string);
                    }
                    i2 = i4;
                } else if (astNode2.getType() == 99) {
                    int i6 = i3;
                    int i7 = i4;
                    parser.processDestructuringDefaults(i6, node2, list, (Assignment) astNode2, node3, i7, transformer);
                    i2 = i7;
                } else {
                    i2 = i4;
                    node2.addChildToBack(parser.destructuringAssignmentHelper(i, astNode2, node3, parser.currentScriptOrFn.getNextTempName(), null, transformer));
                }
                i5++;
                parser = this;
                i3 = i;
                z3 = false;
                i4 = i2;
                z2 = z;
            }
        }
        return z3;
    }

    public Node destructuringAssignmentHelper(int i, Node node, Node node2, String str, AstNode astNode, Transformer transformer) {
        Scope scopeCreateScopeNode = createScopeNode(Token.LETEXPR, node.getLineno(), node.getColumn());
        scopeCreateScopeNode.addChildToFront(new Node(Token.LET, createName(44, str, node2)));
        try {
            pushScope(scopeCreateScopeNode);
            boolean zDestructuringObject = true;
            defineSymbol(Token.LET, str, true);
            popScope();
            Node node3 = new Node(98);
            scopeCreateScopeNode.addChildToBack(node3);
            List<String> arrayList = new ArrayList<>();
            if (node instanceof ArrayLiteral) {
                zDestructuringObject = destructuringArray((ArrayLiteral) node, i, str, node3, arrayList, astNode, transformer);
            } else if (node instanceof ObjectLiteral) {
                zDestructuringObject = destructuringObject((ObjectLiteral) node, i, str, node3, arrayList, astNode, transformer);
            } else if (node.getType() == 33 || node.getType() == 39) {
                if (i == 135 || i == 167 || i == 168) {
                    reportError("msg.bad.assign.left");
                }
                node3.addChildToBack(simpleAssignment(node, createName(str), transformer));
            } else {
                reportError("msg.bad.assign.left");
            }
            if (zDestructuringObject) {
                node3.addChildToBack(createNumber(0.0d));
            }
            scopeCreateScopeNode.putProp(22, arrayList);
            return scopeCreateScopeNode;
        } catch (Throwable th) {
            popScope();
            throw th;
        }
    }

    public boolean destructuringObject(ObjectLiteral objectLiteral, int i, String str, Node node, List<String> list, AstNode astNode, Transformer transformer) {
        int iLineNumber;
        int iColumnNumber;
        Node node2;
        Node node3;
        int i2;
        int i3 = i;
        String str2 = str;
        int i4 = i3 == 168 ? Token.SETCONST : 8;
        boolean z = false;
        boolean z2 = true;
        for (ObjectProperty objectProperty : objectLiteral.getElements()) {
            if (this.ts != null) {
                iLineNumber = lineNumber();
                iColumnNumber = columnNumber();
            } else {
                iLineNumber = 0;
                iColumnNumber = 0;
            }
            AstNode left = objectProperty.getLeft();
            if (left instanceof Name) {
                node2 = new Node(33, createName(str2), Node.newString(((Name) left).getIdentifier()));
            } else if (left instanceof StringLiteral) {
                node2 = new Node(33, createName(str2), Node.newString(((StringLiteral) left).getValue()));
            } else {
                if (!(left instanceof NumberLiteral)) {
                    if (!(left instanceof ComputedPropertyKey)) {
                        throw codeBug();
                    }
                    reportError("msg.bad.computed.property.in.destruct");
                    return false;
                }
                node2 = new Node(39, createName(str2), createNumber((int) ((NumberLiteral) left).getNumber()));
            }
            Node node4 = node2;
            node4.setLineColumnNumber(iLineNumber, iColumnNumber);
            if (astNode == null || z) {
                node3 = node;
            } else {
                node3 = node;
                setupDefaultValues(str2, node3, astNode, i4, transformer);
                z = true;
            }
            AstNode right = objectProperty.getRight();
            if (right.getType() == 44) {
                String identifier = ((Name) right).getIdentifier();
                node3.addChildToBack(new Node(i4, createName(54, identifier, null), node4));
                if (i3 != -1) {
                    defineSymbol(i3, identifier, true);
                    list.add(identifier);
                }
            } else if (right.getType() == 99) {
                processDestructuringDefaults(i3, node3, list, (Assignment) right, node4, i4, transformer);
            } else {
                i2 = i4;
                node3.addChildToBack(destructuringAssignmentHelper(i, right, node4, this.currentScriptOrFn.getNextTempName(), null, transformer));
                i3 = i;
                str2 = str;
                z2 = false;
                i4 = i2;
            }
            i2 = i4;
            i3 = i;
            str2 = str;
            z2 = false;
            i4 = i2;
        }
        return z2;
    }

    public boolean eof() {
        return this.ts.eof();
    }

    public boolean inUseStrictDirective() {
        return this.inUseStrictDirective;
    }

    public boolean insideFunctionBody() {
        return this.nestingOfFunction != 0;
    }

    public boolean insideFunctionParams() {
        return this.nestingOfFunctionParams != 0;
    }

    public String lookupMessage(String str, String str2) {
        return str2 == null ? ScriptRuntime.getMessageById(str, new Object[0]) : ScriptRuntime.getMessageById(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void markDestructuring(AstNode astNode) {
        if (astNode instanceof DestructuringForm) {
            ((DestructuringForm) astNode).setIsDestructuring(true);
        } else if (astNode instanceof ParenthesizedExpression) {
            markDestructuring(((ParenthesizedExpression) astNode).getExpression());
        }
    }

    public void popScope() {
        this.currentScope = this.currentScope.getParentScope();
    }

    public void pushScope(Scope scope) {
        Scope parentScope = scope.getParentScope();
        Scope scope2 = this.currentScope;
        if (parentScope == null) {
            scope2.addChildScope(scope);
        } else if (parentScope != scope2) {
            codeBug();
        }
        this.currentScope = scope;
    }

    public AstNode removeParens(AstNode astNode) {
        while (astNode instanceof ParenthesizedExpression) {
            astNode = ((ParenthesizedExpression) astNode).getExpression();
        }
        return astNode;
    }

    public void reportError(String str, String str2, int i, int i2) {
        addError(str, str2, i, i2);
        if (!this.compilerEnv.recoverFromErrors()) {
            throw new ParserException();
        }
    }

    public void reportErrorsIfExists(int i) {
        int i2 = this.syntaxErrorCount;
        if (i2 != 0) {
            String strLookupMessage = lookupMessage("msg.got.syntax.errors", String.valueOf(i2));
            if (!this.compilerEnv.isIdeMode()) {
                throw this.errorReporter.runtimeError(strLookupMessage, this.sourceURI, i, null, 0);
            }
        }
    }

    public void setDefaultUseStrictDirective(boolean z) {
        this.defaultUseStrictDirective = z;
    }

    public void setIsGenerator() {
        if (insideFunctionBody()) {
            ((FunctionNode) this.currentScriptOrFn).setIsGenerator();
        }
    }

    public void setRequiresActivation() {
        if (insideFunctionBody()) {
            ((FunctionNode) this.currentScriptOrFn).setRequiresActivation();
        }
    }

    public void setSourceURI(String str) {
        this.sourceURI = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [org.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r4v3, types: [org.mozilla.javascript.ast.AstNode] */
    /* JADX WARN: Type inference failed for: r4v4, types: [org.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [org.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r4v7, types: [org.mozilla.javascript.ast.Name] */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.mozilla.javascript.Parser$Transformer] */
    public Node simpleAssignment(Node node, Node node2, Transformer transformer) {
        Node firstChild;
        ?? lastChild;
        int i;
        int type = node.getType();
        if (type != 33 && type != 39) {
            if (type != 44) {
                if (type != 73) {
                    throw codeBug();
                }
                Node firstChild2 = node.getFirstChild();
                checkMutableReference(firstChild2);
                return new Node(74, firstChild2, node2);
            }
            String identifier = ((Name) node).getIdentifier();
            if (this.inUseStrictDirective && ("eval".equals(identifier) || "arguments".equals(identifier))) {
                reportError("msg.bad.id.strict", identifier);
            }
            node.setType(54);
            return new Node(8, node, node2);
        }
        if (node instanceof PropertyGet) {
            PropertyGet propertyGet = (PropertyGet) node;
            AstNode target = propertyGet.getTarget();
            firstChild = target;
            if (transformer != 0) {
                firstChild = transformer.transform(target);
            }
            lastChild = propertyGet.getProperty();
        } else if (node instanceof ElementGet) {
            ElementGet elementGet = (ElementGet) node;
            AstNode target2 = elementGet.getTarget();
            lastChild = elementGet.getElement();
            firstChild = target2;
            if (transformer != 0) {
                firstChild = transformer.transform(target2);
            }
            if (transformer != 0) {
                lastChild = transformer.transform(lastChild);
            }
        } else {
            firstChild = node.getFirstChild();
            lastChild = node.getLastChild();
        }
        if (type == 33) {
            lastChild.setType(46);
            i = 37;
        } else {
            i = 41;
        }
        return new Node(i, firstChild, (Node) lastChild, node2);
    }

    public Node createName(String str) {
        checkActivationName(str, 44);
        return Node.newString(44, str);
    }

    public void addStrictWarning(String str, String str2, int i, int i2) {
        if (this.compilerEnv.isStrictMode()) {
            addWarning(str, str2, i, i2);
        }
    }

    private void addStrictWarning(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        if (this.compilerEnv.isStrictMode()) {
            addWarning(str, str2, i, i2, i3, str3, i4);
        }
    }

    private boolean mustMatchToken(int i, String str, int i2, int i3, boolean z) {
        if (matchToken(i, z)) {
            return true;
        }
        reportError(str, i2, i3);
        return false;
    }

    public void reportError(String str, String str2) {
        reportError(str, str2, this.currentPos.getPosition(), this.currentPos.getLength());
    }

    public String lookupMessage(String str) {
        return lookupMessage(str, null);
    }

    public void reportError(String str, int i, int i2) {
        reportError(str, null, i, i2);
    }

    public void reportError(String str) {
        reportError(str, null);
    }

    public Parser(CompilerEnvirons compilerEnvirons) {
        this(compilerEnvirons, compilerEnvirons.getErrorReporter());
    }

    public Node createDestructuringAssignment(int i, Node node, Node node2, Transformer transformer) {
        return createDestructuringAssignment(i, node, node2, null, transformer);
    }

    public Parser() {
        this(new CompilerEnvirons());
    }

    public Node createDestructuringAssignment(int i, Node node, Node node2, AstNode astNode) {
        return createDestructuringAssignment(i, node, node2, astNode, null);
    }

    public void addError(String str, int i, int i2) {
        addError(str, null, i, i2);
    }

    public void addError(String str, String str2) {
        addError(str, str2, this.currentPos.getPosition(), this.currentPos.getLength());
    }

    public void addError(String str, int i) {
        addError(str, Character.toString((char) i));
    }

    public void addError(String str) {
        addError(str, this.currentPos.getPosition(), this.currentPos.getLength());
    }

    private void addError(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        this.syntaxErrorCount++;
        String strLookupMessage = lookupMessage(str, str2);
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.error(strLookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.error(strLookupMessage, this.sourceURI, i3, str3, i4);
        }
    }

    public void addWarning(String str, int i, int i2) {
        addWarning(str, null, i, i2);
    }

    public void addWarning(String str, String str2) {
        addWarning(str, str2, this.currentPos.getPosition(), this.currentPos.getLength());
    }

    private void addWarning(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        String strLookupMessage = lookupMessage(str, str2);
        if (this.compilerEnv.reportWarningAsError()) {
            addError(str, str2, i, i2, i3, str3, i4);
            return;
        }
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.warning(strLookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.warning(strLookupMessage, this.sourceURI, i3, str3, i4);
        }
    }

    private AstNode statements() {
        return statements(null);
    }

    private Name createNameNode() {
        return createNameNode(false, 44);
    }

    private AstNode generatorExpression(AstNode astNode, int i) {
        return generatorExpression(astNode, i, false);
    }

    public Node simpleAssignment(Node node, Node node2) {
        return simpleAssignment(node, node2, null);
    }

    public void defineSymbol(int i, String str) {
        defineSymbol(i, str, false);
    }

    @Deprecated
    public AstRoot parse(Reader reader, String str, int i) {
        if (!this.parseFinished) {
            if (this.compilerEnv.isIdeMode()) {
                return parse(Kit.readReader(reader), str, i);
            }
            try {
                this.sourceURI = str;
                TokenStream tokenStream = new TokenStream(this, reader, null, i);
                this.ts = tokenStream;
                this.currentPos = tokenStream;
                return parse();
            } finally {
                this.parseFinished = true;
            }
        }
        e04.a("parser reused");
        return null;
    }

    public AstRoot parse(String str, String str2, int i) {
        if (!this.parseFinished) {
            this.sourceURI = str2;
            if (this.compilerEnv.isIdeMode()) {
                this.sourceChars = str.toCharArray();
            }
            TokenStream tokenStream = new TokenStream(this, null, str, i);
            this.ts = tokenStream;
            this.currentPos = tokenStream;
            try {
                try {
                    return parse();
                } catch (IOException unused) {
                    throw new IllegalStateException();
                }
            } finally {
                this.parseFinished = true;
            }
        }
        e04.a("parser reused");
        return null;
    }

    private FunctionNode function(int i) {
        return function(i, false);
    }
}
