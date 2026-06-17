package j$.nio.file.attribute;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class v {
    public static final v GROUP_EXECUTE;
    public static final v GROUP_READ;
    public static final v GROUP_WRITE;
    public static final v OTHERS_EXECUTE;
    public static final v OTHERS_READ;
    public static final v OTHERS_WRITE;
    public static final v OWNER_EXECUTE;
    public static final v OWNER_READ;
    public static final v OWNER_WRITE;
    public static final /* synthetic */ v[] a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        v vVar = new v("OWNER_READ", 0);
        OWNER_READ = vVar;
        v vVar2 = new v("OWNER_WRITE", 1);
        OWNER_WRITE = vVar2;
        v vVar3 = new v("OWNER_EXECUTE", 2);
        OWNER_EXECUTE = vVar3;
        v vVar4 = new v("GROUP_READ", 3);
        GROUP_READ = vVar4;
        v vVar5 = new v("GROUP_WRITE", 4);
        GROUP_WRITE = vVar5;
        v vVar6 = new v("GROUP_EXECUTE", 5);
        GROUP_EXECUTE = vVar6;
        v vVar7 = new v("OTHERS_READ", 6);
        OTHERS_READ = vVar7;
        v vVar8 = new v("OTHERS_WRITE", 7);
        OTHERS_WRITE = vVar8;
        v vVar9 = new v("OTHERS_EXECUTE", 8);
        OTHERS_EXECUTE = vVar9;
        a = new v[]{vVar, vVar2, vVar3, vVar4, vVar5, vVar6, vVar7, vVar8, vVar9};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static v[] values() {
        return (v[]) a.clone();
    }
}
