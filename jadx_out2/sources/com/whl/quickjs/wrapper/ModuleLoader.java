package com.whl.quickjs.wrapper;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ModuleLoader {
    public abstract byte[] getModuleBytecode(String str);

    public abstract String getModuleStringCode(String str);

    public abstract boolean isBytecodeMode();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String moduleNormalizeName(String str, String str2) {
        return str2;
    }
}
