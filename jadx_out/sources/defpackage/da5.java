package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Word;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class da5 extends rh {
    public final a e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void b(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final s4 z;

        public b(s4 s4Var) {
            super(s4Var.getRoot());
            this.z = s4Var;
        }
    }

    public da5(a aVar) {
        this.e = aVar;
    }

    public final /* synthetic */ void Z(Word.Data data, View view) {
        this.e.b(data.getTitle());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        final Word.Data data = (Word.Data) M(i);
        bVar.z.b.setText(data.getTitle());
        bVar.z.b.setOnClickListener(new View.OnClickListener() { // from class: ca5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.Z(data, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(s4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }
}
