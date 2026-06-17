package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.db.AppDatabase;
import com.github.catvod.crawler.Spider;
import com.github.catvod.utils.Trans;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import defpackage.di;
import defpackage.f10;
import defpackage.fl3;
import defpackage.qx4;
import defpackage.sy0;
import defpackage.yc1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.xml.XMLConstants;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Live {
    private boolean activated;

    @SerializedName("api")
    private String api;

    @SerializedName("boot")
    private boolean boot;

    @SerializedName("catchup")
    private Catchup catchup;

    @SerializedName("click")
    private String click;

    @SerializedName("core")
    private Core core;

    @SerializedName("epg")
    private String epg;

    @SerializedName("ext")
    @JsonAdapter(sy0.class)
    private String ext;

    @SerializedName("groups")
    private List<Group> groups;

    @SerializedName("header")
    @JsonAdapter(yc1.class)
    private Map<String, String> header;

    @SerializedName("jar")
    private String jar;

    @SerializedName("keep")
    private String keep;

    @SerializedName("logo")
    private String logo;

    @SerializedName("name")
    private String name;

    @SerializedName("origin")
    private String origin;

    @SerializedName("pass")
    private boolean pass;

    @SerializedName("referer")
    private String referer;

    @SerializedName("timeZone")
    private String timeZone;

    @SerializedName("timeout")
    private Integer timeout;

    @SerializedName("ua")
    private String ua;

    @SerializedName("url")
    private String url;
    private int width;

    public Live(String str, String str2) {
        this.name = str;
        this.url = str2;
    }

    public static List<Live> findAll() {
        return AppDatabase.Q().V().h();
    }

    public static Live objectFrom(JsonElement jsonElement, String str) {
        try {
            Live live = (Live) App.c().fromJson(jsonElement, Live.class);
            if (live.getJar().isEmpty()) {
                live.setJar(str);
            }
            live.setApi(qx4.a(live.getApi()));
            live.setExt(qx4.a(live.getExt()));
            return live.trans();
        } catch (Exception unused) {
            return new Live();
        }
    }

    public Live boot(boolean z) {
        setBoot(z);
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Live) {
            return getName().equals(((Live) obj).getName());
        }
        return false;
    }

    public Group find(Group group) {
        for (Group group2 : getGroups()) {
            if (group2.getName().equals(group.getName())) {
                return group2;
            }
        }
        getGroups().add(group);
        return group;
    }

    public String getApi() {
        return TextUtils.isEmpty(this.api) ? "" : this.api;
    }

    public int getBootIcon() {
        return isBoot() ? fl3.n : fl3.m;
    }

    public Catchup getCatchup() {
        Catchup catchup = this.catchup;
        return catchup == null ? new Catchup() : catchup;
    }

    public String getClick() {
        return TextUtils.isEmpty(this.click) ? "" : this.click;
    }

    public Core getCore() {
        Core core = this.core;
        return core == null ? new Core() : core;
    }

    public String getEpg() {
        return TextUtils.isEmpty(this.epg) ? "" : this.epg;
    }

    public String getEpgApi() {
        for (String str : getEpg().split(",")) {
            if (str.contains("{")) {
                return str;
            }
        }
        return getEpg();
    }

    public List<String> getEpgXml() {
        ArrayList arrayList = new ArrayList();
        for (String str : getEpg().split(",")) {
            if (!str.contains("{") && (str.contains(XMLConstants.XML_NS_PREFIX) || str.contains("gz"))) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public String getExt() {
        return TextUtils.isEmpty(this.ext) ? "" : this.ext;
    }

    public List<Group> getGroups() {
        List<Group> arrayList = this.groups;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.groups = arrayList;
        return arrayList;
    }

    public Map<String, String> getHeader() {
        Map<String, String> map = this.header;
        return map == null ? new HashMap() : map;
    }

    public Map<String, String> getHeaders() {
        HashMap map = new HashMap(getHeader());
        if (!getUa().isEmpty()) {
            map.put("User-Agent", getUa());
        }
        if (!getOrigin().isEmpty()) {
            map.put("Origin", getOrigin());
        }
        if (!getReferer().isEmpty()) {
            map.put("Referer", getReferer());
        }
        return map;
    }

    public String getJar() {
        return TextUtils.isEmpty(this.jar) ? "" : this.jar;
    }

    public String getKeep() {
        return TextUtils.isEmpty(this.keep) ? "" : this.keep;
    }

    public String getLogo() {
        return TextUtils.isEmpty(this.logo) ? "" : this.logo;
    }

    public String getName() {
        return TextUtils.isEmpty(this.name) ? "" : this.name;
    }

    public String getOrigin() {
        return TextUtils.isEmpty(this.origin) ? "" : this.origin;
    }

    public int getPassIcon() {
        return isPass() ? fl3.m : fl3.o;
    }

    public String getReferer() {
        return TextUtils.isEmpty(this.referer) ? "" : this.referer;
    }

    public String getTimeZone() {
        return TextUtils.isEmpty(this.timeZone) ? "" : this.timeZone;
    }

    public long getTimeout() {
        if (this.timeout == null) {
            return f10.g;
        }
        return TimeUnit.SECONDS.toMillis(Math.max(r2.intValue(), 1));
    }

    public String getUa() {
        return TextUtils.isEmpty(this.ua) ? "" : this.ua;
    }

    public String getUrl() {
        return TextUtils.isEmpty(this.url) ? "" : this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isActivated() {
        return this.activated;
    }

    public boolean isBoot() {
        return this.boot;
    }

    public boolean isEmpty() {
        return getName().isEmpty();
    }

    public boolean isPass() {
        return this.pass;
    }

    public Live keep(Channel channel) {
        setKeep(channel.getGroup().getName() + "@@@" + channel.getName() + "@@@" + channel.getCurrent());
        return this;
    }

    public Live pass(boolean z) {
        getGroups().clear();
        setPass(z);
        return this;
    }

    public Live recent() {
        di.d().o(getName(), getApi(), getJar());
        return this;
    }

    public void save() {
        AppDatabase.Q().V().c(this);
    }

    public void setActivated(Live live) {
        this.activated = live.equals(this);
    }

    public void setApi(String str) {
        this.api = str;
    }

    public void setBoot(boolean z) {
        this.boot = z;
    }

    public void setEpg(String str) {
        this.epg = str;
    }

    public void setExt(String str) {
        this.ext = str.trim();
    }

    public void setJar(String str) {
        this.jar = str;
    }

    public void setKeep(String str) {
        this.keep = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPass(boolean z) {
        this.pass = z;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public Spider spider() {
        return di.d().f(getName(), getApi(), getExt(), getJar());
    }

    public Live sync(Live live) {
        if (live == null) {
            return this;
        }
        setBoot(live.isBoot());
        setPass(live.isPass());
        setKeep(live.getKeep());
        return this;
    }

    public Live trans() {
        if (Trans.pass()) {
            return this;
        }
        this.name = Trans.s2t(this.name);
        return this;
    }

    public void setActivated(boolean z) {
        this.activated = z;
    }

    public Live() {
    }

    public Live sync() {
        sync(find(getName()));
        return this;
    }

    public static Live find(String str) {
        return AppDatabase.Q().V().g(str);
    }
}
