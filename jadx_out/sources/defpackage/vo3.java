package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.App;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class vo3 extends RecyclerView.h {
    public final b d;
    public final List e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends TypeToken<List<String>> {
        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void b(String str);

        void l(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends RecyclerView.g0 implements View.OnLongClickListener {
        public final r4 z;

        public c(r4 r4Var) {
            super(r4Var.getRoot());
            this.z = r4Var;
            this.f.setOnLongClickListener(this);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            vo3.this.e.remove(n());
            vo3.this.t(n());
            vo3.this.d.l(vo3.this.g());
            q24.f0(App.c().toJson(vo3.this.e));
            return true;
        }
    }

    public vo3(b bVar) {
        this.d = bVar;
        List listL = L();
        this.e = listL;
        bVar.l(listL.size());
    }

    private List L() {
        return q24.f().isEmpty() ? new ArrayList() : (List) App.c().fromJson(q24.f(), new a().getType());
    }

    public void J(String str) {
        K(str);
        l();
        this.d.l(g());
        q24.f0(App.c().toJson(this.e));
    }

    public final void K(String str) {
        this.e.remove(str);
        this.e.add(0, str);
        if (this.e.size() > 10) {
            this.e.remove(10);
        }
    }

    public final /* synthetic */ void M(String str, View view) {
        this.d.b(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public void v(c cVar, int i) {
        final String str = (String) this.e.get(i);
        cVar.z.b.setText(str);
        cVar.z.b.setOnClickListener(new View.OnClickListener() { // from class: uo3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.M(str, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public c x(ViewGroup viewGroup, int i) {
        return new c(r4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.size();
    }
}
