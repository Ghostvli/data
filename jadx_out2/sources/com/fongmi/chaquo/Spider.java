package com.fongmi.chaquo;

import android.content.Context;
import com.chaquo.python.PyObject;
import com.github.catvod.utils.Path;
import com.github.catvod.utils.UriUtil;
import com.github.catvod.utils.Util;
import com.google.gson.Gson;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Spider extends com.github.catvod.crawler.Spider {
    public final PyObject a;
    public final PyObject b;
    public final String c;
    public final Gson d = new Gson();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Spider(PyObject pyObject, PyObject pyObject2, String str) {
        this.a = pyObject;
        this.b = pyObject2;
        this.c = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a(String str) {
        this.a.callAttr("download", Path.py(str).getAbsolutePath(), UriUtil.resolve(this.c, str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public String action(String str) {
        return this.a.callAttr("action", this.b, str).toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Map b(PyObject pyObject) {
        try {
            HashMap map = new HashMap();
            for (Map.Entry<PyObject, PyObject> entry : pyObject.asMap().entrySet()) {
                map.put(entry.getKey().toString(), entry.getValue().toString());
            }
            return map;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ByteArrayInputStream c(PyObject pyObject, boolean z) {
        if (pyObject == null) {
            return null;
        }
        if (pyObject.type().toString().contains("bytes")) {
            return new ByteArrayInputStream((byte[]) pyObject.toJava(byte[].class));
        }
        String string = pyObject.toString();
        if (z && string.contains("base64,")) {
            string = string.split("base64,")[1];
        }
        return new ByteArrayInputStream(z ? Util.decode(string) : string.getBytes());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public String categoryContent(String str, String str2, boolean z, HashMap<String, String> map) {
        return this.a.callAttr("categoryContent", this.b, str, str2, Boolean.valueOf(z), this.d.toJson(map)).toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public void destroy() {
        try {
            this.a.callAttr("destroy", this.b);
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public String detailContent(List<String> list) {
        return this.a.callAttr("detailContent", this.b, this.d.toJson(list)).toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public String homeContent(boolean z) {
        return this.a.callAttr("homeContent", this.b, Boolean.valueOf(z)).toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public String homeVideoContent() {
        return this.a.callAttr("homeVideoContent", this.b).toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public void init(Context context, String str) {
        PyObject pyObjectCallAttr = this.a.callAttr("getDependence", this.b);
        if (pyObjectCallAttr != null) {
            Iterator<PyObject> it = pyObjectCallAttr.asList().iterator();
            while (it.hasNext()) {
                a(it.next() + ".py");
            }
        }
        this.b.put("siteKey", (Object) this.siteKey);
        this.a.callAttr("init", this.b, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public boolean isVideoFormat(String str) {
        return this.a.callAttr("isVideoFormat", this.b, str).toBoolean();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public String liveContent(String str) {
        return this.a.callAttr("liveContent", this.b, str).toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public boolean manualVideoCheck() {
        return this.a.callAttr("manualVideoCheck", this.b).toBoolean();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public String playerContent(String str, String str2, List<String> list) {
        return this.a.callAttr("playerContent", this.b, str, str2, this.d.toJson(list)).toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public Object[] proxy(Map<String, String> map) {
        List<PyObject> listAsList = this.a.callAttr("localProxy", this.b, this.d.toJson(map)).asList();
        return new Object[]{Integer.valueOf(listAsList.get(0).toInt()), listAsList.get(1).toString(), c(listAsList.get(2), listAsList.size() > 4 && listAsList.get(4).toInt() == 1), listAsList.size() > 3 && listAsList.get(3) != null ? b(listAsList.get(3)) : null};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.github.catvod.crawler.Spider
    public String searchContent(String str, boolean z) {
        return this.a.callAttr("searchContent", this.b, str, Boolean.valueOf(z)).toString();
    }

    @Override // com.github.catvod.crawler.Spider
    public String searchContent(String str, boolean z, String str2) {
        return this.a.callAttr("searchContent", this.b, str, Boolean.valueOf(z), str2).toString();
    }
}
