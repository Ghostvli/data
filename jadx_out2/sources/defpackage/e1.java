package defpackage;

import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e1 implements nh4 {
    public final Class a;
    public final Class b;
    public final boolean c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public e1(Class cls, Class cls2, boolean z) {
        this.a = cls;
        this.b = cls2;
        this.c = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh4
    public nh4 b() {
        Class cls = this.b;
        if (cls == null) {
            return null;
        }
        try {
            return (nh4) cls.newInstance();
        } catch (IllegalAccessException e) {
            wg1.a(e);
            return null;
        } catch (InstantiationException e2) {
            wg1.a(e2);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh4
    public Class c() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ph4 d(String str, Class cls, ThreadMode threadMode, int i, boolean z) {
        try {
            return new ph4(this.a.getDeclaredMethod(str, cls), cls, threadMode, i, z);
        } catch (NoSuchMethodException e) {
            throw new wu0("Could not find subscriber method in " + this.a + ". Maybe a missing ProGuard rule?", e);
        }
    }
}
