package defpackage;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class vj1 implements Serializable {
    public final a f;
    public final int g;
    public final String h;
    public final String i;
    public List j = Collections.EMPTY_LIST;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        STREAM,
        PLAYLIST,
        CHANNEL,
        COMMENT
    }

    public vj1(a aVar, int i, String str, String str2) {
        this.f = aVar;
        this.g = i;
        this.h = str;
        this.i = str2;
    }

    public a a() {
        return this.f;
    }

    public String b() {
        return this.i;
    }

    public int c() {
        return this.g;
    }

    public List d() {
        return this.j;
    }

    public String e() {
        return this.h;
    }

    public void f(List list) {
        this.j = list;
    }

    public String toString() {
        return getClass().getSimpleName() + "[url=\"" + this.h + "\", name=\"" + this.i + "\"]";
    }
}
