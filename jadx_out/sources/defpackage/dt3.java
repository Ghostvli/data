package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.github.catvod.utils.Path;
import j$.time.Instant;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class dt3 extends RecyclerView.h {
    public final a d;
    public final List e = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void e(File file);

        void s(File file);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final p4 z;

        public b(p4 p4Var) {
            super(p4Var.getRoot());
            this.z = p4Var;
        }
    }

    public dt3(a aVar) {
        this.d = aVar;
        J();
    }

    public final void J() {
        File[] fileArrListFiles = Path.tv().listFiles();
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        for (File file : fileArrListFiles) {
            if (file.getName().startsWith("tv") && file.getName().endsWith(".bk.gz")) {
                this.e.add(file);
            }
        }
        if (!this.e.isEmpty()) {
            this.e.sort(new Comparator() { // from class: ct3
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
                }
            });
        }
        l();
    }

    public final /* synthetic */ void K(File file, View view) {
        this.d.e(file);
    }

    public final /* synthetic */ void L(File file, View view) {
        this.d.s(file);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        final File file = (File) this.e.get(i);
        bVar.z.c.setText(file.getName());
        bVar.z.d.setText(w41.c.format(Instant.ofEpochMilli(file.lastModified())));
        bVar.z.b.setOnClickListener(new View.OnClickListener() { // from class: at3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.K(file, view);
            }
        });
        bVar.z.getRoot().setOnClickListener(new View.OnClickListener() { // from class: bt3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.L(file, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(p4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    public int O(File file) {
        int iIndexOf = this.e.indexOf(file);
        if (iIndexOf == -1) {
            return -1;
        }
        Path.clear(file);
        this.e.remove(iIndexOf);
        t(iIndexOf);
        return g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.size();
    }
}
