package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Parse;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class u73 extends RecyclerView.h {
    public final a d;
    public final List e = b75.I().S();
    public final int f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void o0(Parse parse);
    }

    public u73(a aVar, int i) {
        this.d = aVar;
        this.f = i;
    }

    public Parse H() {
        return (Parse) this.e.get(0);
    }

    public Parse I(int i) {
        return (Parse) this.e.get(i);
    }

    public int J() {
        for (int i = 0; i < this.e.size(); i++) {
            if (((Parse) this.e.get(i)).isActivated()) {
                return i;
            }
        }
        return 0;
    }

    public boolean K() {
        return g() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        Parse parse = (Parse) this.e.get(i);
        if (bVar.z != null) {
            bVar.Q(bVar.z.b, parse);
        }
        if (bVar.A != null) {
            bVar.Q(bVar.A.b, parse);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return i == 0 ? new b(l4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false)) : new b(m4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int i(int i) {
        return this.f;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public m4 A;
        public l4 z;

        public b(l4 l4Var) {
            super(l4Var.getRoot());
            this.z = l4Var;
        }

        public void Q(TextView textView, final Parse parse) {
            textView.setText(parse.getName());
            textView.setActivated(parse.isActivated());
            textView.setOnClickListener(new View.OnClickListener() { // from class: v73
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f.R(parse, view);
                }
            });
        }

        public final /* synthetic */ void R(Parse parse, View view) {
            u73.this.d.o0(parse);
        }

        public b(m4 m4Var) {
            super(m4Var.getRoot());
            this.A = m4Var;
        }
    }
}
