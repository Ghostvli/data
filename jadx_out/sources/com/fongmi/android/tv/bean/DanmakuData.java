package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.github.catvod.utils.Trans;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class DanmakuData {
    private int color;
    private int shadow;
    private float size;
    private String text;
    private long time;
    private int type;

    public DanmakuData(Matcher matcher, float f) throws Exception {
        param(matcher.group(1), f);
        this.text = matcher.group(2);
        trans();
    }

    private void param(String str, float f) throws Exception {
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length < 4) {
            throw new Exception();
        }
        this.type = Integer.parseInt(strArrSplit[1]);
        this.time = (long) (Float.parseFloat(strArrSplit[0]) * 1000.0f);
        this.size = Float.parseFloat(strArrSplit[2]) * (f - 0.6f);
        int i = (int) ((Long.parseLong(strArrSplit[3]) | 4278190080L) & 4294967295L);
        this.color = i;
        this.shadow = i <= -16777216 ? -1 : -16777216;
    }

    public int getColor() {
        return this.color;
    }

    public int getShadow() {
        return this.shadow;
    }

    public float getSize() {
        return this.size;
    }

    public String getText() {
        return TextUtils.isEmpty(this.text) ? "" : this.text.replace("&amp;", "&").replace("&quot;", "\"").replace("&gt;", ">").replace("&lt;", "<");
    }

    public long getTime() {
        return this.time;
    }

    public int getType() {
        return this.type;
    }

    public void trans() {
        if (Trans.pass()) {
            return;
        }
        this.text = Trans.s2t(this.text);
    }
}
