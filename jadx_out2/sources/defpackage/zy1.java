package defpackage;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.internal.Common;
import com.fongmi.chaquo.Spider;
import com.github.catvod.utils.Path;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class zy1 {
    public final PyObject a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zy1() {
        if (!Python.isStarted()) {
            Python.start(pb3.d());
        }
        this.a = Python.getInstance().getModule(Common.ASSET_APP);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Spider a(String str) {
        return new Spider(this.a, this.a.callAttr("spider", Path.py().getAbsolutePath(), str), str);
    }
}
