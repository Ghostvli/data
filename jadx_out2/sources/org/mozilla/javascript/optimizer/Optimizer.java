package org.mozilla.javascript.optimizer;

import java.util.ArrayList;
import java.util.List;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.ScriptNode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class Optimizer {
    static final int AnyType = 3;
    static final int NoType = 0;
    static final int NumberType = 1;
    private boolean inDirectCallFunction;
    private boolean parameterUsedInNumberContext;
    OptFunctionNode theFunction;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void buildStatementList_r(Node node, List<Node> list) {
        int type = node.getType();
        if (type != 143 && type != 155 && type != 146 && type != 122) {
            list.add(node);
            return;
        }
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            buildStatementList_r(firstChild, list);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean convertParameter(Node node) {
        if (!this.inDirectCallFunction || node.getType() != 60) {
            return false;
        }
        if (!this.theFunction.isParameter(this.theFunction.getVarIndex(node))) {
            return false;
        }
        node.removeProp(8);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void markDCPNumberContext(Node node) {
        if (this.inDirectCallFunction && node.getType() == 60) {
            if (this.theFunction.isParameter(this.theFunction.getVarIndex(node))) {
                this.parameterUsedInNumberContext = true;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void optimizeFunction(OptFunctionNode optFunctionNode) {
        if (optFunctionNode.fnode.requiresActivation()) {
            return;
        }
        this.inDirectCallFunction = optFunctionNode.isTargetOfDirectCall();
        this.theFunction = optFunctionNode;
        ArrayList arrayList = new ArrayList();
        buildStatementList_r(optFunctionNode.fnode, arrayList);
        int size = arrayList.size();
        Node[] nodeArr = new Node[size];
        arrayList.toArray(nodeArr);
        Block.runFlowAnalyzes(optFunctionNode, nodeArr);
        if (optFunctionNode.fnode.requiresActivation()) {
            return;
        }
        this.parameterUsedInNumberContext = false;
        for (int i = 0; i < size; i++) {
            rewriteForNumberVariables(nodeArr[i], 1);
        }
        optFunctionNode.setParameterNumberContext(this.parameterUsedInNumberContext);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void rewriteAsObjectChildren(Node node, Node node2) {
        while (node2 != null) {
            Node next = node2.getNext();
            if (rewriteForNumberVariables(node2, 0) == 1 && !convertParameter(node2)) {
                node.removeChild(node2);
                Node node3 = new Node(Token.TO_OBJECT, node2);
                if (next == null) {
                    node.addChildToBack(node3);
                } else {
                    node.addChildBefore(node3, next);
                }
            }
            node2 = next;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int rewriteForNumberVariables(Node node, int i) {
        int type = node.getType();
        if (type == 39) {
            Node firstChild = node.getFirstChild();
            Node next = firstChild.getNext();
            if (rewriteForNumberVariables(firstChild, 1) == 1 && !convertParameter(firstChild)) {
                node.removeChild(firstChild);
                node.addChildToFront(new Node(Token.TO_OBJECT, firstChild));
            }
            if (rewriteForNumberVariables(next, 1) == 1 && !convertParameter(next)) {
                node.putIntProp(8, 2);
            }
            return 0;
        }
        if (type != 41) {
            if (type == 43) {
                Node firstChild2 = node.getFirstChild();
                rewriteAsObjectChildren(firstChild2, firstChild2.getFirstChild());
                Node next2 = firstChild2.getNext();
                if (((OptFunctionNode) node.getProp(9)) != null) {
                    while (next2 != null) {
                        if (rewriteForNumberVariables(next2, 1) == 1) {
                            markDCPNumberContext(next2);
                        }
                        next2 = next2.getNext();
                    }
                } else {
                    rewriteAsObjectChildren(node, next2);
                }
                return 0;
            }
            if (type == 45) {
                node.putIntProp(8, 0);
                return 1;
            }
            if (type != 81) {
                if (type == 147) {
                    if (rewriteForNumberVariables(node.getFirstChild(), 1) == 1) {
                        node.putIntProp(8, 0);
                    }
                    return 0;
                }
                if (type != 154) {
                    if (type != 170) {
                        if (type == 60) {
                            int varIndex = this.theFunction.getVarIndex(node);
                            if (this.inDirectCallFunction && this.theFunction.isParameter(varIndex) && i == 1) {
                                node.putIntProp(8, 0);
                                return 1;
                            }
                            if (!this.theFunction.isNumberVar(varIndex)) {
                                return 0;
                            }
                            node.putIntProp(8, 0);
                            return 1;
                        }
                        if (type != 61) {
                            if (type != 119 && type != 120) {
                                switch (type) {
                                    case 9:
                                    case 10:
                                    case 11:
                                        break;
                                    default:
                                        switch (type) {
                                            case 14:
                                            case 15:
                                            case 16:
                                            case 17:
                                                Node firstChild3 = node.getFirstChild();
                                                Node next3 = firstChild3.getNext();
                                                int iRewriteForNumberVariables = rewriteForNumberVariables(firstChild3, 1);
                                                int iRewriteForNumberVariables2 = rewriteForNumberVariables(next3, 1);
                                                markDCPNumberContext(firstChild3);
                                                markDCPNumberContext(next3);
                                                if (convertParameter(firstChild3)) {
                                                    if (!convertParameter(next3) && iRewriteForNumberVariables2 == 1) {
                                                        node.putIntProp(8, 2);
                                                    }
                                                } else if (convertParameter(next3)) {
                                                    if (iRewriteForNumberVariables == 1) {
                                                        node.putIntProp(8, 1);
                                                    }
                                                } else if (iRewriteForNumberVariables == 1) {
                                                    if (iRewriteForNumberVariables2 == 1) {
                                                        node.putIntProp(8, 0);
                                                    } else {
                                                        node.putIntProp(8, 1);
                                                    }
                                                } else if (iRewriteForNumberVariables2 == 1) {
                                                    node.putIntProp(8, 2);
                                                }
                                                return 0;
                                            case 18:
                                            case 19:
                                                break;
                                            default:
                                                switch (type) {
                                                    case 21:
                                                        Node firstChild4 = node.getFirstChild();
                                                        Node next4 = firstChild4.getNext();
                                                        int iRewriteForNumberVariables3 = rewriteForNumberVariables(firstChild4, 1);
                                                        int iRewriteForNumberVariables4 = rewriteForNumberVariables(next4, 1);
                                                        if (convertParameter(firstChild4)) {
                                                            if (!convertParameter(next4) && iRewriteForNumberVariables4 == 1) {
                                                                node.putIntProp(8, 2);
                                                            }
                                                        } else if (convertParameter(next4)) {
                                                            if (iRewriteForNumberVariables3 == 1) {
                                                                node.putIntProp(8, 1);
                                                            }
                                                        } else if (iRewriteForNumberVariables3 == 1) {
                                                            if (iRewriteForNumberVariables4 == 1) {
                                                                node.putIntProp(8, 0);
                                                                return 1;
                                                            }
                                                            node.putIntProp(8, 1);
                                                        } else if (iRewriteForNumberVariables4 == 1) {
                                                            node.putIntProp(8, 2);
                                                        }
                                                        return 0;
                                                    case 22:
                                                    case 23:
                                                    case 24:
                                                    case 25:
                                                        break;
                                                    default:
                                                        switch (type) {
                                                            case 27:
                                                            case 28:
                                                            case 29:
                                                                Node firstChild5 = node.getFirstChild();
                                                                if (rewriteForNumberVariables(firstChild5, 1) != 1 || convertParameter(firstChild5)) {
                                                                    return 0;
                                                                }
                                                                node.putIntProp(8, 0);
                                                                markDCPNumberContext(firstChild5);
                                                                return 1;
                                                            default:
                                                                rewriteAsObjectChildren(node, node.getFirstChild());
                                                                return 0;
                                                        }
                                                }
                                                break;
                                        }
                                        break;
                                }
                            } else {
                                Node firstChild6 = node.getFirstChild();
                                if (firstChild6.getIntProp(31, 0) == 1) {
                                    return 0;
                                }
                                int iRewriteForNumberVariables5 = rewriteForNumberVariables(firstChild6, 1);
                                if (firstChild6.getType() != 60) {
                                    if (firstChild6.getType() == 39 || firstChild6.getType() == 33) {
                                        return iRewriteForNumberVariables5;
                                    }
                                    return 0;
                                }
                                if (iRewriteForNumberVariables5 != 1 || convertParameter(firstChild6)) {
                                    return 0;
                                }
                                node.putIntProp(8, 0);
                                markDCPNumberContext(firstChild6);
                                return 1;
                            }
                        }
                    }
                    Node next5 = node.getFirstChild().getNext();
                    int iRewriteForNumberVariables6 = rewriteForNumberVariables(next5, 1);
                    int varIndex2 = this.theFunction.getVarIndex(node);
                    if (this.inDirectCallFunction && this.theFunction.isParameter(varIndex2)) {
                        if (iRewriteForNumberVariables6 != 1) {
                            return iRewriteForNumberVariables6;
                        }
                        if (convertParameter(next5)) {
                            markDCPNumberContext(next5);
                            return 0;
                        }
                        node.putIntProp(8, 0);
                        return 1;
                    }
                    if (!this.theFunction.isNumberVar(varIndex2)) {
                        if (iRewriteForNumberVariables6 == 1 && !convertParameter(next5)) {
                            node.removeChild(next5);
                            node.addChildToBack(new Node(Token.TO_OBJECT, next5));
                        }
                        return 0;
                    }
                    if (iRewriteForNumberVariables6 != 1) {
                        node.removeChild(next5);
                        node.addChildToBack(new Node(Token.TO_DOUBLE, next5));
                    }
                    node.putIntProp(8, 0);
                    markDCPNumberContext(next5);
                    return 1;
                }
            }
            Node firstChild7 = node.getFirstChild();
            Node next6 = firstChild7.getNext();
            int iRewriteForNumberVariables7 = rewriteForNumberVariables(firstChild7, 1);
            int iRewriteForNumberVariables8 = rewriteForNumberVariables(next6, 1);
            markDCPNumberContext(firstChild7);
            markDCPNumberContext(next6);
            if (iRewriteForNumberVariables7 != 1) {
                if (iRewriteForNumberVariables8 != 1) {
                    return 3;
                }
                if (!convertParameter(firstChild7)) {
                    node.removeChild(firstChild7);
                    node.addChildToFront(new Node(Token.TO_DOUBLE, firstChild7));
                    node.putIntProp(8, 0);
                }
                return 1;
            }
            if (iRewriteForNumberVariables8 == 1) {
                node.putIntProp(8, 0);
                return 1;
            }
            if (!convertParameter(next6)) {
                node.removeChild(next6);
                node.addChildToBack(new Node(Token.TO_DOUBLE, next6));
                node.putIntProp(8, 0);
            }
            return 1;
        }
        Node firstChild8 = node.getFirstChild();
        Node next7 = firstChild8.getNext();
        Node next8 = next7.getNext();
        if (rewriteForNumberVariables(firstChild8, 1) == 1 && !convertParameter(firstChild8)) {
            node.removeChild(firstChild8);
            node.addChildToFront(new Node(Token.TO_OBJECT, firstChild8));
        }
        if (rewriteForNumberVariables(next7, 1) == 1 && !convertParameter(next7)) {
            node.putIntProp(8, 1);
        }
        if (rewriteForNumberVariables(next8, 1) == 1 && !convertParameter(next8)) {
            node.removeChild(next8);
            node.addChildToBack(new Node(Token.TO_OBJECT, next8));
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void optimize(ScriptNode scriptNode) {
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            optimizeFunction(OptFunctionNode.get(scriptNode, i));
        }
    }
}
