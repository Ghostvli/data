package org.mozilla.javascript.optimizer;

import defpackage.d04;
import java.util.HashMap;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.IRFactory;
import org.mozilla.javascript.JavaAdapter;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.ScriptNode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ClassCompiler {
    private CompilerEnvirons compilerEnv;
    private String mainMethodClassName;
    private Class<?> targetExtends;
    private Class<?>[] targetImplements;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ClassCompiler(CompilerEnvirons compilerEnvirons) {
        if (compilerEnvirons == null) {
            d04.a();
            throw null;
        }
        this.compilerEnv = compilerEnvirons;
        this.mainMethodClassName = "org.mozilla.javascript.optimizer.OptRuntime";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object[] compileToClassFiles(String str, String str2, int i, String str3) {
        ScriptNode scriptNodeTransformTree = new IRFactory(this.compilerEnv, str).transformTree(new Parser(this.compilerEnv).parse(str, str2, i));
        if (this.compilerEnv.isGeneratingSource()) {
            scriptNodeTransformTree.setRawSource(str);
            scriptNodeTransformTree.setRawSourceBounds(0, str.length());
        }
        Class<?> targetExtends = getTargetExtends();
        Class<?>[] targetImplements = getTargetImplements();
        boolean z = targetImplements == null && targetExtends == null;
        String strMakeAuxiliaryClassName = z ? str3 : makeAuxiliaryClassName(str3, "1");
        Codegen codegen = new Codegen();
        codegen.setMainMethodClass(this.mainMethodClassName);
        byte[] bArrCompileToClassFile = codegen.compileToClassFile(this.compilerEnv, strMakeAuxiliaryClassName, scriptNodeTransformTree, str, false);
        if (z) {
            return new Object[]{strMakeAuxiliaryClassName, bArrCompileToClassFile};
        }
        int functionCount = scriptNodeTransformTree.getFunctionCount();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 != functionCount; i2++) {
            FunctionNode functionNode = scriptNodeTransformTree.getFunctionNode(i2);
            String name = functionNode.getName();
            if (name != null && name.length() != 0) {
                map.put(name, Integer.valueOf(functionNode.getParamCount()));
            }
        }
        if (targetExtends == null) {
            targetExtends = ScriptRuntime.ObjectClass;
        }
        return new Object[]{str3, JavaAdapter.createAdapterCode(map, str3, targetExtends, targetImplements, strMakeAuxiliaryClassName), strMakeAuxiliaryClassName, bArrCompileToClassFile};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CompilerEnvirons getCompilerEnv() {
        return this.compilerEnv;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getMainMethodClass() {
        return this.mainMethodClassName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Class<?> getTargetExtends() {
        return this.targetExtends;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Class<?>[] getTargetImplements() {
        Class<?>[] clsArr = this.targetImplements;
        if (clsArr == null) {
            return null;
        }
        return (Class[]) clsArr.clone();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String makeAuxiliaryClassName(String str, String str2) {
        return str + str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMainMethodClass(String str) {
        this.mainMethodClassName = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTargetExtends(Class<?> cls) {
        this.targetExtends = cls;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTargetImplements(Class<?>[] clsArr) {
        this.targetImplements = clsArr == null ? null : (Class[]) clsArr.clone();
    }
}
