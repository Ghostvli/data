package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import defpackage.jk3;
import defpackage.wu4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    public boolean Q;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, wu4.a(context, jk3.f, R.attr.preferenceScreenStyle));
        this.Q = true;
    }

    @Override // androidx.preference.Preference
    public void x() {
        if (h() == null && g() == null && K() != 0) {
            m();
            throw null;
        }
    }
}
