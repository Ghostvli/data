package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Result;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class s60 extends RecyclerView.v {
    public final a a;
    public boolean b;
    public boolean c = true;
    public int d = 1;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void u(String str);
    }

    public s60(a aVar) {
        this.a = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v
    public void b(RecyclerView recyclerView, int i, int i2) {
        if (f() || g() || recyclerView.getScrollState() == 0 || this.a == null || recyclerView.canScrollVertically(1) || i2 <= 0) {
            return;
        }
        a aVar = this.a;
        int i3 = this.d + 1;
        this.d = i3;
        aVar.u(String.valueOf(i3));
    }

    public int c() {
        int i = this.d + 1;
        this.d = i;
        return i;
    }

    public void d(Result result) {
        if (result.getList().isEmpty()) {
            this.d--;
        }
        i(result.getPageCount().intValue());
        j(false);
    }

    public boolean e() {
        return this.d == 1;
    }

    public boolean f() {
        return !this.c;
    }

    public boolean g() {
        return this.b;
    }

    public void h() {
        this.c = true;
        this.d = 1;
    }

    public void i(int i) {
        this.c = this.d < i || i == 0;
    }

    public void j(boolean z) {
        this.b = z;
    }

    public void k(int i) {
        this.d = i;
    }
}
