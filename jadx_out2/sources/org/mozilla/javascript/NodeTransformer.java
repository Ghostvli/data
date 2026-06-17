package org.mozilla.javascript;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Scope;
import org.mozilla.javascript.ast.ScriptNode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NodeTransformer {
    private boolean hasFinally;
    private Deque<Node> loopEnds;
    private Deque<Node> loops;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Node addBeforeCurrent(Node node, Node node2, Node node3, Node node4) {
        if (node2 == null) {
            if (node3 != node.getFirstChild()) {
                Kit.codeBug();
            }
            node.addChildToFront(node4);
            return node4;
        }
        if (node3 != node2.getNext()) {
            Kit.codeBug();
        }
        node.addChildAfter(node4, node2);
        return node4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Node replaceCurrent(Node node, Node node2, Node node3, Node node4) {
        if (node2 == null) {
            if (node3 != node.getFirstChild()) {
                Kit.codeBug();
            }
            node.replaceChild(node3, node4);
            return node4;
        }
        if (node2.next == node3) {
            node.replaceChildAfter(node2, node4);
            return node4;
        }
        node.replaceChild(node3, node4);
        return node4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void transformCompilationUnit(ScriptNode scriptNode, boolean z) {
        this.loops = new ArrayDeque();
        this.loopEnds = new ArrayDeque();
        this.hasFinally = false;
        boolean z2 = scriptNode.getType() != 122 || ((FunctionNode) scriptNode).requiresActivation();
        scriptNode.flattenSymbolTable(!z2);
        transformCompilationUnit_r(scriptNode, scriptNode, scriptNode, z2, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:251:0x03e9 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:258:0x0100 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:261:0x0100 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:273:0x036c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:274:0x036c */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0177  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [org.mozilla.javascript.NodeTransformer] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [org.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r3v27, types: [org.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r3v28, types: [org.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30, types: [org.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r3v33 */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void transformCompilationUnit_r(org.mozilla.javascript.ast.ScriptNode r19, org.mozilla.javascript.Node r20, org.mozilla.javascript.ast.Scope r21, boolean r22, boolean r23) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r6 = r20
            r7 = r21
            r8 = 0
            r2 = r8
        La:
            if (r2 != 0) goto L12
            org.mozilla.javascript.Node r2 = r6.getFirstChild()
            r3 = r8
            goto L1b
        L12:
            org.mozilla.javascript.Node r3 = r2.getNext()
            r17 = r3
            r3 = r2
            r2 = r17
        L1b:
            if (r2 != 0) goto L1e
            return
        L1e:
            int r4 = r2.getType()
            r5 = 167(0xa7, float:2.34E-43)
            r9 = 172(0xac, float:2.41E-43)
            r10 = 143(0x8f, float:2.0E-43)
            r11 = 44
            if (r22 == 0) goto L89
            r12 = 171(0xab, float:2.4E-43)
            if (r4 == r10) goto L36
            r13 = 146(0x92, float:2.05E-43)
            if (r4 == r13) goto L36
            if (r4 != r12) goto L89
        L36:
            boolean r13 = r2 instanceof org.mozilla.javascript.ast.Scope
            if (r13 == 0) goto L89
            r13 = r2
            org.mozilla.javascript.ast.Scope r13 = (org.mozilla.javascript.ast.Scope) r13
            java.util.Map r14 = r13.getSymbolTable()
            if (r14 == 0) goto L89
            org.mozilla.javascript.Node r14 = new org.mozilla.javascript.Node
            if (r4 != r12) goto L49
            r4 = r9
            goto L4a
        L49:
            r4 = r5
        L4a:
            r14.<init>(r4)
            org.mozilla.javascript.Node r4 = new org.mozilla.javascript.Node
            r4.<init>(r5)
            r14.addChildToBack(r4)
            java.util.Map r12 = r13.getSymbolTable()
            java.util.Set r12 = r12.keySet()
            java.util.Iterator r12 = r12.iterator()
        L61:
            boolean r15 = r12.hasNext()
            if (r15 == 0) goto L75
            java.lang.Object r15 = r12.next()
            java.lang.String r15 = (java.lang.String) r15
            org.mozilla.javascript.Node r15 = org.mozilla.javascript.Node.newString(r11, r15)
            r4.addChildToBack(r15)
            goto L61
        L75:
            r13.setSymbolTable(r8)
            org.mozilla.javascript.Node r4 = replaceCurrent(r6, r3, r2, r14)
            int r12 = r4.getType()
            r14.addChildToBack(r2)
            r17 = r12
            r12 = r4
            r4 = r17
            goto L8a
        L89:
            r12 = r2
        L8a:
            r2 = 3
            if (r4 == r2) goto L3ec
            r13 = 4
            r14 = 149(0x95, float:2.09E-43)
            r15 = 136(0x88, float:1.9E-43)
            r16 = 0
            r10 = 90
            if (r4 == r13) goto L344
            r13 = 7
            if (r4 == r13) goto L2e4
            r13 = 54
            r8 = 8
            if (r4 == r8) goto L246
            r8 = 43
            if (r4 == r8) goto L241
            if (r4 == r11) goto L272
            r8 = 72
            if (r4 == r8) goto L214
            r8 = 78
            if (r4 == r8) goto L20c
            if (r4 == r10) goto L1f4
            r8 = 127(0x7f, float:1.78E-43)
            if (r4 == r8) goto L1e4
            r8 = 151(0x97, float:2.12E-43)
            if (r4 == r8) goto L1d6
            if (r4 == r9) goto L150
            r8 = 179(0xb3, float:2.51E-43)
            if (r4 == r8) goto L20c
            switch(r4) {
                case 30: goto L14c;
                case 31: goto L272;
                case 32: goto L2e4;
                default: goto Lc2;
            }
        Lc2:
            switch(r4) {
                case 133: goto Le6;
                case 134: goto Le6;
                case 135: goto L177;
                case 136: goto Lcd;
                default: goto Lc5;
            }
        Lc5:
            switch(r4) {
                case 144: goto L1e4;
                case 145: goto L3ec;
                case 146: goto L1e4;
                default: goto Lc8;
            }
        Lc8:
            switch(r4) {
                case 167: goto L150;
                case 168: goto L177;
                case 169: goto L272;
                default: goto Lcb;
            }
        Lcb:
            goto L174
        Lcd:
            java.util.Deque<org.mozilla.javascript.Node> r3 = r0.loops
            r3.push(r12)
            org.mozilla.javascript.Node r3 = r12.getNext()
            int r4 = r3.getType()
            if (r4 == r2) goto Ldf
            org.mozilla.javascript.Kit.codeBug()
        Ldf:
            java.util.Deque<org.mozilla.javascript.Node> r2 = r0.loopEnds
            r2.push(r3)
            goto L174
        Le6:
            r5 = r12
            org.mozilla.javascript.ast.Jump r5 = (org.mozilla.javascript.ast.Jump) r5
            org.mozilla.javascript.ast.Jump r8 = r5.getJumpStatement()
            if (r8 != 0) goto Lf2
            org.mozilla.javascript.Kit.codeBug()
        Lf2:
            java.util.Deque<org.mozilla.javascript.Node> r9 = r0.loops
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L147
            java.util.Deque<org.mozilla.javascript.Node> r9 = r0.loops
            java.util.Iterator r9 = r9.iterator()
        L100:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L133
            java.lang.Object r11 = r9.next()
            org.mozilla.javascript.Node r11 = (org.mozilla.javascript.Node) r11
            if (r11 != r8) goto L10f
            goto L133
        L10f:
            int r13 = r11.getType()
            if (r13 != r15) goto L11f
            org.mozilla.javascript.Node r11 = new org.mozilla.javascript.Node
            r11.<init>(r2)
            org.mozilla.javascript.Node r3 = addBeforeCurrent(r6, r3, r12, r11)
            goto L100
        L11f:
            if (r13 != r10) goto L100
            org.mozilla.javascript.ast.Jump r11 = (org.mozilla.javascript.ast.Jump) r11
            org.mozilla.javascript.ast.Jump r13 = new org.mozilla.javascript.ast.Jump
            r13.<init>(r14)
            org.mozilla.javascript.Node r11 = r11.getFinally()
            r13.target = r11
            org.mozilla.javascript.Node r3 = addBeforeCurrent(r6, r3, r12, r13)
            goto L100
        L133:
            r2 = 133(0x85, float:1.86E-43)
            if (r4 != r2) goto L13c
            org.mozilla.javascript.Node r2 = r8.target
            r5.target = r2
            goto L142
        L13c:
            org.mozilla.javascript.Node r2 = r8.getContinue()
            r5.target = r2
        L142:
            r2 = 5
            r5.setType(r2)
            goto L174
        L147:
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.codeBug()
            throw r0
        L14c:
            r0.visitNew(r12, r1)
            goto L174
        L150:
            org.mozilla.javascript.Node r2 = r12.getFirstChild()
            int r2 = r2.getType()
            if (r2 != r5) goto L177
            int r2 = r1.getType()
            r4 = 122(0x7a, float:1.71E-43)
            if (r2 != r4) goto L16f
            r2 = r1
            org.mozilla.javascript.ast.FunctionNode r2 = (org.mozilla.javascript.ast.FunctionNode) r2
            boolean r2 = r2.requiresActivation()
            if (r2 == 0) goto L16c
            goto L16f
        L16c:
            r2 = r16
            goto L170
        L16f:
            r2 = 1
        L170:
            org.mozilla.javascript.Node r12 = r0.visitLet(r2, r6, r3, r12)
        L174:
            r2 = r12
            goto L408
        L177:
            org.mozilla.javascript.Node r2 = new org.mozilla.javascript.Node
            r5 = 143(0x8f, float:2.0E-43)
            r2.<init>(r5)
            org.mozilla.javascript.Node r5 = r12.getFirstChild()
        L182:
            if (r5 == 0) goto L1d1
            org.mozilla.javascript.Node r8 = r5.getNext()
            int r10 = r5.getType()
            if (r10 != r11) goto L1af
            boolean r10 = r5.hasChildren()
            if (r10 != 0) goto L195
            goto L1ca
        L195:
            org.mozilla.javascript.Node r10 = r5.getFirstChild()
            r5.removeChild(r10)
            r5.setType(r13)
            org.mozilla.javascript.Node r14 = new org.mozilla.javascript.Node
            r15 = 168(0xa8, float:2.35E-43)
            if (r4 != r15) goto L1a8
            r15 = 169(0xa9, float:2.37E-43)
            goto L1aa
        L1a8:
            r15 = 8
        L1aa:
            r14.<init>(r15, r5, r10)
            r5 = r14
            goto L1b5
        L1af:
            int r10 = r5.getType()
            if (r10 != r9) goto L1cc
        L1b5:
            org.mozilla.javascript.Node r10 = new org.mozilla.javascript.Node
            r14 = 147(0x93, float:2.06E-43)
            r10.<init>(r14, r5)
            int r5 = r12.getLineno()
            int r14 = r12.getColumn()
            r10.setLineColumnNumber(r5, r14)
            r2.addChildToBack(r10)
        L1ca:
            r5 = r8
            goto L182
        L1cc:
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.codeBug()
            throw r0
        L1d1:
            org.mozilla.javascript.Node r12 = replaceCurrent(r6, r3, r12, r2)
            goto L174
        L1d6:
            java.lang.String r2 = r12.getString()
            org.mozilla.javascript.ast.Scope r2 = r7.getDefiningScope(r2)
            if (r2 == 0) goto L174
            r12.setScope(r2)
            goto L174
        L1e4:
            java.util.Deque<org.mozilla.javascript.Node> r2 = r0.loops
            r2.push(r12)
            java.util.Deque<org.mozilla.javascript.Node> r2 = r0.loopEnds
            r3 = r12
            org.mozilla.javascript.ast.Jump r3 = (org.mozilla.javascript.ast.Jump) r3
            org.mozilla.javascript.Node r3 = r3.target
            r2.push(r3)
            goto L174
        L1f4:
            r2 = r12
            org.mozilla.javascript.ast.Jump r2 = (org.mozilla.javascript.ast.Jump) r2
            org.mozilla.javascript.Node r2 = r2.getFinally()
            if (r2 == 0) goto L174
            r3 = 1
            r0.hasFinally = r3
            java.util.Deque<org.mozilla.javascript.Node> r3 = r0.loops
            r3.push(r12)
            java.util.Deque<org.mozilla.javascript.Node> r3 = r0.loopEnds
            r3.push(r2)
            goto L174
        L20c:
            r2 = r1
            org.mozilla.javascript.ast.FunctionNode r2 = (org.mozilla.javascript.ast.FunctionNode) r2
            r2.addResumptionPoint(r12)
            goto L174
        L214:
            r2 = 12
            java.lang.Object r2 = r12.getProp(r2)
            r8 = r2
            java.lang.Object[] r8 = (java.lang.Object[]) r8
            if (r8 == 0) goto L174
            int r9 = r8.length
            r10 = r16
        L222:
            if (r10 >= r9) goto L174
            r2 = r8[r10]
            boolean r3 = r2 instanceof org.mozilla.javascript.Node
            if (r3 != 0) goto L22b
            goto L23e
        L22b:
            org.mozilla.javascript.Node r2 = (org.mozilla.javascript.Node) r2
            boolean r3 = r12 instanceof org.mozilla.javascript.ast.Scope
            if (r3 == 0) goto L239
            r3 = r12
            org.mozilla.javascript.ast.Scope r3 = (org.mozilla.javascript.ast.Scope) r3
        L234:
            r4 = r22
            r5 = r23
            goto L23b
        L239:
            r3 = r7
            goto L234
        L23b:
            r0.transformCompilationUnit_r(r1, r2, r3, r4, r5)
        L23e:
            int r10 = r10 + 1
            goto L222
        L241:
            r0.visitCall(r12, r1)
            goto L174
        L246:
            if (r23 == 0) goto L272
            r2 = 80
            r12.setType(r2)
            org.mozilla.javascript.Node r2 = r12.getFirstChild()
            int r2 = r2.getType()
            if (r2 != r13) goto L272
            org.mozilla.javascript.Node r2 = r12.getFirstChild()
            boolean r5 = r2 instanceof org.mozilla.javascript.ast.Name
            if (r5 == 0) goto L272
            org.mozilla.javascript.ast.Name r2 = (org.mozilla.javascript.ast.Name) r2
            java.lang.String r2 = r2.getIdentifier()
            java.lang.String r5 = "eval"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L272
            java.lang.String r2 = "syntax error"
            org.mozilla.javascript.Context.reportError(r2)
        L272:
            if (r22 == 0) goto L276
            goto L174
        L276:
            r2 = 31
            if (r4 != r11) goto L27c
            r5 = r12
            goto L28f
        L27c:
            org.mozilla.javascript.Node r5 = r12.getFirstChild()
            int r8 = r5.getType()
            if (r8 == r13) goto L28f
            if (r4 != r2) goto L28a
            goto L174
        L28a:
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.codeBug()
            throw r0
        L28f:
            org.mozilla.javascript.ast.Scope r8 = r5.getScope()
            if (r8 == 0) goto L297
            goto L174
        L297:
            java.lang.String r8 = r5.getString()
            org.mozilla.javascript.ast.Scope r8 = r7.getDefiningScope(r8)
            if (r8 == 0) goto L174
            r5.setScope(r8)
            if (r4 != r11) goto L2ad
            r2 = 60
            r12.setType(r2)
            goto L174
        L2ad:
            r8 = 46
            r9 = 8
            if (r4 == r9) goto L2da
            r9 = 80
            if (r4 != r9) goto L2b8
            goto L2da
        L2b8:
            r9 = 169(0xa9, float:2.37E-43)
            if (r4 != r9) goto L2c6
            r2 = 170(0xaa, float:2.38E-43)
            r12.setType(r2)
            r5.setType(r8)
            goto L174
        L2c6:
            if (r4 != r2) goto L2d5
            org.mozilla.javascript.Node r2 = new org.mozilla.javascript.Node
            r4 = 49
            r2.<init>(r4)
            org.mozilla.javascript.Node r12 = replaceCurrent(r6, r3, r12, r2)
            goto L174
        L2d5:
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.codeBug()
            throw r0
        L2da:
            r2 = 61
            r12.setType(r2)
            r5.setType(r8)
            goto L174
        L2e4:
            org.mozilla.javascript.Node r2 = r12.getFirstChild()
            r3 = 7
            if (r4 != r3) goto L335
        L2eb:
            int r3 = r2.getType()
            r4 = 26
            if (r3 != r4) goto L2f8
            org.mozilla.javascript.Node r2 = r2.getFirstChild()
            goto L2eb
        L2f8:
            int r3 = r2.getType()
            r4 = 12
            if (r3 == r4) goto L308
            int r3 = r2.getType()
            r4 = 13
            if (r3 != r4) goto L335
        L308:
            org.mozilla.javascript.Node r3 = r2.getFirstChild()
            org.mozilla.javascript.Node r4 = r2.getLastChild()
            int r5 = r3.getType()
            java.lang.String r8 = "undefined"
            if (r5 != r11) goto L324
            java.lang.String r5 = r3.getString()
            boolean r5 = r5.equals(r8)
            if (r5 == 0) goto L324
            r2 = r4
            goto L335
        L324:
            int r5 = r4.getType()
            if (r5 != r11) goto L335
            java.lang.String r4 = r4.getString()
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L335
            r2 = r3
        L335:
            int r3 = r2.getType()
            r4 = 33
            if (r3 != r4) goto L174
            r3 = 34
            r2.setType(r3)
            goto L174
        L344:
            int r4 = r1.getType()
            r5 = 122(0x7a, float:1.71E-43)
            if (r4 != r5) goto L357
            r4 = r1
            org.mozilla.javascript.ast.FunctionNode r4 = (org.mozilla.javascript.ast.FunctionNode) r4
            boolean r4 = r4.isGenerator()
            if (r4 == 0) goto L357
            r16 = 1
        L357:
            if (r16 == 0) goto L35f
            r4 = 20
            r5 = 1
            r12.putIntProp(r4, r5)
        L35f:
            boolean r4 = r0.hasFinally
            if (r4 != 0) goto L365
            goto L174
        L365:
            java.util.Deque<org.mozilla.javascript.Node> r4 = r0.loops
            java.util.Iterator r4 = r4.iterator()
            r5 = 0
        L36c:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L3b4
            java.lang.Object r8 = r4.next()
            org.mozilla.javascript.Node r8 = (org.mozilla.javascript.Node) r8
            int r9 = r8.getType()
            if (r9 == r10) goto L384
            if (r9 != r15) goto L381
            goto L384
        L381:
            r8 = 143(0x8f, float:2.0E-43)
            goto L36c
        L384:
            if (r9 != r10) goto L394
            org.mozilla.javascript.ast.Jump r9 = new org.mozilla.javascript.ast.Jump
            r9.<init>(r14)
            org.mozilla.javascript.ast.Jump r8 = (org.mozilla.javascript.ast.Jump) r8
            org.mozilla.javascript.Node r8 = r8.getFinally()
            r9.target = r8
            goto L399
        L394:
            org.mozilla.javascript.Node r9 = new org.mozilla.javascript.Node
            r9.<init>(r2)
        L399:
            if (r5 != 0) goto L3ae
            org.mozilla.javascript.Node r5 = new org.mozilla.javascript.Node
            r8 = 143(0x8f, float:2.0E-43)
            r5.<init>(r8)
            int r11 = r12.getLineno()
            int r13 = r12.getColumn()
            r9.setLineColumnNumber(r11, r13)
            goto L3b0
        L3ae:
            r8 = 143(0x8f, float:2.0E-43)
        L3b0:
            r5.addChildToBack(r9)
            goto L36c
        L3b4:
            if (r5 == 0) goto L174
            org.mozilla.javascript.Node r2 = r12.getFirstChild()
            org.mozilla.javascript.Node r8 = replaceCurrent(r6, r3, r12, r5)
            if (r2 == 0) goto L3e1
            if (r16 == 0) goto L3c3
            goto L3e1
        L3c3:
            org.mozilla.javascript.Node r3 = new org.mozilla.javascript.Node
            r4 = 148(0x94, float:2.07E-43)
            r3.<init>(r4, r2)
            r5.addChildToFront(r3)
            org.mozilla.javascript.Node r2 = new org.mozilla.javascript.Node
            r4 = 70
            r2.<init>(r4)
            r5.addChildToBack(r2)
            r4 = r22
            r5 = r23
            r2 = r3
            r3 = r7
            r0.transformCompilationUnit_r(r1, r2, r3, r4, r5)
            goto L3e4
        L3e1:
            r5.addChildToBack(r12)
        L3e4:
            r1 = r19
            r7 = r21
            r2 = r8
        L3e9:
            r8 = 0
            goto La
        L3ec:
            java.util.Deque<org.mozilla.javascript.Node> r1 = r0.loopEnds
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L174
            java.util.Deque<org.mozilla.javascript.Node> r1 = r0.loopEnds
            java.lang.Object r1 = r1.peek()
            if (r1 != r12) goto L174
            java.util.Deque<org.mozilla.javascript.Node> r1 = r0.loopEnds
            r1.pop()
            java.util.Deque<org.mozilla.javascript.Node> r1 = r0.loops
            r1.pop()
            goto L174
        L408:
            boolean r1 = r2 instanceof org.mozilla.javascript.ast.Scope
            if (r1 == 0) goto L417
            r7 = r2
            org.mozilla.javascript.ast.Scope r7 = (org.mozilla.javascript.ast.Scope) r7
            r3 = r7
        L410:
            r1 = r19
            r4 = r22
            r5 = r23
            goto L41a
        L417:
            r3 = r21
            goto L410
        L41a:
            r0.transformCompilationUnit_r(r1, r2, r3, r4, r5)
            r0 = r18
            r1 = r19
            r7 = r21
            goto L3e9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NodeTransformer.transformCompilationUnit_r(org.mozilla.javascript.ast.ScriptNode, org.mozilla.javascript.Node, org.mozilla.javascript.ast.Scope, boolean, boolean):void");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void transform(ScriptNode scriptNode, boolean z, CompilerEnvirons compilerEnvirons) {
        if (compilerEnvirons.getLanguageVersion() >= 200 && scriptNode.isInStrictMode()) {
            z = true;
        }
        transformCompilationUnit(scriptNode, z);
        for (int i = 0; i != scriptNode.getFunctionCount(); i++) {
            transform(scriptNode.getFunctionNode(i), z, compilerEnvirons);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void visitCall(Node node, ScriptNode scriptNode) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Node visitLet(boolean z, Node node, Node node2, Node node3) {
        Node node4;
        Node firstChild;
        Node node5;
        Node firstChild2;
        Node firstChild3 = node3.getFirstChild();
        Node next = firstChild3.getNext();
        node3.removeChild(firstChild3);
        node3.removeChild(next);
        int type = node3.getType();
        int i = Token.LETEXPR;
        boolean z2 = type == 172;
        int i2 = Token.LET;
        if (z) {
            Node nodeReplaceCurrent = replaceCurrent(node, node2, node3, new Node(z2 ? 173 : 143));
            ArrayList arrayList = new ArrayList();
            Node node6 = new Node(72);
            Node firstChild4 = firstChild3.getFirstChild();
            while (firstChild4 != null) {
                if (firstChild4.getType() == i) {
                    List list = (List) firstChild4.getProp(22);
                    Node firstChild5 = firstChild4.getFirstChild();
                    if (firstChild5.getType() != i2) {
                        throw Kit.codeBug();
                    }
                    node5 = z2 ? new Node(98, firstChild5.getNext(), next) : new Node(Token.BLOCK, new Node(Token.EXPR_VOID, firstChild5.getNext()), next);
                    if (list != null) {
                        arrayList.addAll(list);
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            node6.addChildToBack(new Node(Token.VOID, Node.newNumber(0.0d)));
                        }
                    }
                    firstChild2 = firstChild5.getFirstChild();
                } else {
                    node5 = next;
                    firstChild2 = firstChild4;
                }
                if (firstChild2.getType() != 44) {
                    throw Kit.codeBug();
                }
                arrayList.add(ScriptRuntime.getIndexObject(firstChild2.getString()));
                Node firstChild6 = firstChild2.getFirstChild();
                if (firstChild6 == null) {
                    firstChild6 = new Node(Token.VOID, Node.newNumber(0.0d));
                }
                node6.addChildToBack(firstChild6);
                firstChild4 = firstChild4.getNext();
                next = node5;
                i = Token.LETEXPR;
                i2 = Token.LET;
            }
            node6.putProp(12, arrayList.toArray());
            nodeReplaceCurrent.addChildToBack(new Node(2, node6));
            nodeReplaceCurrent.addChildToBack(new Node(Token.WITH, next));
            nodeReplaceCurrent.addChildToBack(new Node(3));
            return nodeReplaceCurrent;
        }
        Node nodeReplaceCurrent2 = replaceCurrent(node, node2, node3, new Node(z2 ? 98 : 143));
        Node node7 = new Node(98);
        Node firstChild7 = firstChild3.getFirstChild();
        while (firstChild7 != null) {
            if (firstChild7.getType() == 172) {
                Node firstChild8 = firstChild7.getFirstChild();
                if (firstChild8.getType() != 167) {
                    throw Kit.codeBug();
                }
                node4 = z2 ? new Node(98, firstChild8.getNext(), next) : new Node(Token.BLOCK, new Node(Token.EXPR_VOID, firstChild8.getNext()), next);
                Scope.joinScopes((Scope) firstChild7, (Scope) node3);
                firstChild = firstChild8.getFirstChild();
            } else {
                node4 = next;
                firstChild = firstChild7;
            }
            if (firstChild.getType() != 44) {
                throw Kit.codeBug();
            }
            Node nodeNewString = Node.newString(firstChild.getString());
            nodeNewString.setScope((Scope) node3);
            Node firstChild9 = firstChild.getFirstChild();
            if (firstChild9 == null) {
                firstChild9 = new Node(Token.VOID, Node.newNumber(0.0d));
            }
            node7.addChildToBack(new Node(61, nodeNewString, firstChild9));
            firstChild7 = firstChild7.getNext();
            next = node4;
        }
        if (z2) {
            nodeReplaceCurrent2.addChildToBack(node7);
            node3.setType(98);
            nodeReplaceCurrent2.addChildToBack(node3);
            node3.addChildToBack(next);
            if (next instanceof Scope) {
                Scope scope = (Scope) next;
                Scope parentScope = scope.getParentScope();
                Scope scope2 = (Scope) node3;
                scope.setParentScope(scope2);
                scope2.setParentScope(parentScope);
                return nodeReplaceCurrent2;
            }
        } else {
            nodeReplaceCurrent2.addChildToBack(new Node(Token.EXPR_VOID, node7));
            node3.setType(Token.BLOCK);
            nodeReplaceCurrent2.addChildToBack(node3);
            node3.addChildrenToBack(next);
            if (next instanceof Scope) {
                Scope scope3 = (Scope) next;
                Scope parentScope2 = scope3.getParentScope();
                Scope scope4 = (Scope) node3;
                scope3.setParentScope(scope4);
                scope4.setParentScope(parentScope2);
            }
        }
        return nodeReplaceCurrent2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void visitNew(Node node, ScriptNode scriptNode) {
    }

    public final void transform(ScriptNode scriptNode, CompilerEnvirons compilerEnvirons) {
        transform(scriptNode, false, compilerEnvirons);
    }
}
