package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class f01 extends RecyclerView.h {
    public final a d;
    public final List e = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void s(File file);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final h4 z;

        public b(h4 h4Var) {
            super(h4Var.getRoot());
            this.z = h4Var;
        }
    }

    public f01(a aVar) {
        this.d = aVar;
    }

    public void H(List list) {
        this.e.clear();
        this.e.addAll(list);
        l();
    }

    public final /* synthetic */ void I(File file, View view) {
        this.d.s(file);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        final File file = (File) this.e.get(i);
        bVar.z.c.setText(file.getName());
        bVar.z.getRoot().setOnClickListener(new View.OnClickListener() { // from class: e01
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.I(file, view);
            }
        });
        bVar.z.b.setImageResource(file.isDirectory() ? fl3.l : fl3.k);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(h4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.size();
    }
}
