package defpackage;

import android.R;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.fongmi.android.tv.bean.Filter;
import com.fongmi.android.tv.bean.Value;
import com.google.android.material.bottomsheet.b;
import com.google.android.material.textview.MaterialTextView;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class i11 extends nh {
    public g11 A0;
    public List B0;
    public yk0 z0;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static i11 W2() {
        return new i11();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public i35 M2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        yk0 yk0VarC = yk0.c(layoutInflater, viewGroup, false);
        this.z0 = yk0VarC;
        return yk0VarC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public void O2() {
        Iterator it = this.B0.iterator();
        while (it.hasNext()) {
            V2((Filter) it.next());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public boolean T2() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void V2(final Filter filter) {
        String name = filter.getName();
        if (name != null && !name.isEmpty()) {
            MaterialTextView materialTextView = new MaterialTextView(Y1());
            materialTextView.setText(name);
            materialTextView.setTextSize(14.0f);
            materialTextView.setTypeface(null, 1);
            materialTextView.setTextColor(vr3.c(rk3.b));
            materialTextView.setPadding(0, 4, 0, 2);
            this.z0.b.addView(materialTextView);
        }
        ot otVar = new ot(Y1());
        otVar.setSingleSelection(true);
        otVar.setChipSpacingHorizontal(4);
        otVar.setChipSpacingVertical(0);
        otVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        for (final Value value : filter.getValue()) {
            mt mtVar = new mt(Y1());
            mtVar.setText(value.getN());
            mtVar.setClickable(true);
            mtVar.setCheckable(true);
            mtVar.setChecked(value.isActivated());
            int[][] iArr = {new int[]{R.attr.state_checked}, new int[0]};
            mtVar.setChipBackgroundColor(new ColorStateList(iArr, new int[]{-14776091, 872415231}));
            mtVar.setTextColor(new ColorStateList(iArr, new int[]{-1, -583847117}));
            mtVar.setTextSize(12.0f);
            mtVar.setGravity(17);
            mtVar.setTag(value);
            mtVar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: h11
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.a.Y2(value, filter, compoundButton, z);
                }
            });
            otVar.addView(mtVar);
        }
        this.z0.b.addView(otVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public i11 X2(List list) {
        this.B0 = list;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void Y2(Value value, Filter filter, CompoundButton compoundButton, boolean z) {
        if (z) {
            value.setActivated(true);
            this.A0.j(filter.getKey(), value);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: p51 */
    /* JADX WARN: Multi-variable type inference failed */
    public void Z2(p51 p51Var) {
        Iterator it = p51Var.T().w0().iterator();
        while (it.hasNext()) {
            if (((p51) it.next()) instanceof b) {
                return;
            }
        }
        G2(p51Var.T(), null);
        this.A0 = (g11) p51Var;
    }
}
