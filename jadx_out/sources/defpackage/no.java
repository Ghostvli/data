package defpackage;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class no implements Comparable {
    public final String f;
    public final long g;
    public final long h;
    public final boolean i;
    public final File j;
    public final long k;

    public no(String str, long j, long j2, long j3, File file) {
        this.f = str;
        this.g = j;
        this.h = j2;
        this.i = file != null;
        this.j = file;
        this.k = j3;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(no noVar) {
        if (!this.f.equals(noVar.f)) {
            return this.f.compareTo(noVar.f);
        }
        long j = this.g - noVar.g;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }

    public boolean b() {
        return !this.i;
    }

    public boolean e() {
        return this.h == -1;
    }

    public String toString() {
        return "[" + this.g + ", " + this.h + "]";
    }
}
