package defpackage;

import com.fongmi.android.tv.bean.DanmakuData;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class q83 extends jh {
    public static final Pattern k = Pattern.compile("p=\"([^\"]+)\"[^>]*>([^<]+)<");
    public static final Pattern l = Pattern.compile("\\[(.*?)\\](.*)");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ih l(Matcher matcher, int i) {
        try {
            DanmakuData danmakuData = new DanmakuData(matcher, this.e);
            int type = danmakuData.getType();
            if (type == 2 || type == 3) {
                type = 1;
            }
            t80 t80Var = this.i;
            ih ihVarD = t80Var.E.d(type, t80Var);
            if (ihVarD != null && ihVarD.m() != 7) {
                d90.e(ihVarD, danmakuData.getText());
                ihVarD.i = danmakuData.getShadow();
                ihVarD.f = danmakuData.getColor();
                ihVarD.H = this.i.C;
                ihVarD.k = danmakuData.getSize();
                ihVarD.B(danmakuData.getTime());
                ihVarD.D(this.b);
                ihVarD.r = i;
                return ihVarD;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: e()Ldh1; */
    @Override // defpackage.jh
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public e90 e() {
        BufferedReader bufferedReader;
        Pattern pattern;
        if (this.a == null) {
            return null;
        }
        int i = 0;
        e90 e90Var = new e90(0);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(((c6) this.a).a()));
            pattern = null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null || Thread.interrupted()) {
                    break;
                }
                if (pattern == null) {
                    pattern = line.startsWith("<") ? k : l;
                }
                Matcher matcher = pattern.matcher(line);
                while (matcher.find() && matcher.groupCount() == 2) {
                    int i2 = i + 1;
                    ih ihVarL = l(matcher, i);
                    if (ihVarL != null) {
                        synchronized (e90Var.i()) {
                            e90Var.c(ihVarL);
                        }
                    }
                    i = i2;
                }
            } finally {
            }
            e.printStackTrace();
            return null;
        }
        bufferedReader.close();
        return e90Var;
    }
}
