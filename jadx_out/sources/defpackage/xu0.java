package defpackage;

import com.fongmi.android.tv.service.PlaybackService;
import com.fongmi.android.tv.ui.activity.HistoryActivity;
import com.fongmi.android.tv.ui.activity.HomeActivity;
import com.fongmi.android.tv.ui.activity.KeepActivity;
import com.fongmi.android.tv.ui.activity.LiveActivity;
import com.fongmi.android.tv.ui.activity.VideoActivity;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class xu0 implements oh4 {
    public static final Map a = new HashMap();

    static {
        ThreadMode threadMode = ThreadMode.MAIN;
        b(new e74(z60.class, true, new rh4[]{new rh4("onConfigEvent", c00.class, threadMode)}));
        b(new e74(VideoActivity.class, true, new rh4[]{new rh4("onCastEvent", wq.class, threadMode), new rh4("onRefreshEvent", qp3.class, threadMode)}));
        b(new e74(xg.class, true, new rh4[]{new rh4("onSubscribe", Object.class, threadMode)}));
        b(new e74(KeepActivity.class, true, new rh4[]{new rh4("onRefreshEvent", qp3.class, threadMode)}));
        b(new e74(HistoryActivity.class, true, new rh4[]{new rh4("onRefreshEvent", qp3.class, threadMode)}));
        b(new e74(LiveActivity.class, true, new rh4[]{new rh4("onRefreshEvent", qp3.class, threadMode)}));
        b(new e74(z34.class, true, new rh4[]{new rh4("onConfigEvent", c00.class, threadMode)}));
        b(new e74(PlaybackService.class, true, new rh4[]{new rh4("onConfigEvent", c00.class, threadMode)}));
        b(new e74(o75.class, true, new rh4[]{new rh4("onConfigEvent", c00.class, threadMode), new rh4("onRefreshEvent", qp3.class, threadMode), new rh4("onStateEvent", be4.class, threadMode), new rh4("onCastEvent", wq.class, threadMode)}));
        b(new e74(HomeActivity.class, true, new rh4[]{new rh4("onConfigEvent", c00.class, threadMode), new rh4("onServerEvent", u14.class, threadMode)}));
    }

    public static void b(nh4 nh4Var) {
        a.put(nh4Var.c(), nh4Var);
    }

    @Override // defpackage.oh4
    public nh4 a(Class cls) {
        nh4 nh4Var = (nh4) a.get(cls);
        if (nh4Var != null) {
            return nh4Var;
        }
        return null;
    }
}
