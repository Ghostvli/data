package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.j;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class d extends BaseAdapter {
    public e a;
    public int b = -1;
    public boolean c;
    public final boolean d;
    public final LayoutInflater e;
    public final int f;

    public d(e eVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.d = z;
        this.e = layoutInflater;
        this.a = eVar;
        this.f = i;
        a();
    }

    public void a() {
        g gVarX = this.a.x();
        if (gVarX != null) {
            ArrayList arrayListB = this.a.B();
            int size = arrayListB.size();
            for (int i = 0; i < size; i++) {
                if (((g) arrayListB.get(i)) == gVarX) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    public e b() {
        return this.a;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public g getItem(int i) {
        boolean z = this.d;
        e eVar = this.a;
        ArrayList arrayListB = z ? eVar.B() : eVar.G();
        int i2 = this.b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (g) arrayListB.get(i);
    }

    public void d(boolean z) {
        this.c = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        boolean z = this.d;
        e eVar = this.a;
        return this.b < 0 ? (z ? eVar.B() : eVar.G()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.e.inflate(this.f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.a.I() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        j.a aVar = (j.a) view;
        if (this.c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.d(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
