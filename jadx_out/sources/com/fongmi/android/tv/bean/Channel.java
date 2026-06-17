package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import android.widget.ImageView;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Epg;
import com.github.catvod.utils.Trans;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import defpackage.si1;
import defpackage.sm3;
import defpackage.vr3;
import defpackage.w41;
import defpackage.yc1;
import j$.time.LocalDate;
import j$.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Channel {

    @SerializedName("catchup")
    private Catchup catchup;

    @SerializedName("click")
    private String click;
    private List<Epg> dataList;

    @SerializedName("drm")
    private Drm drm;

    @SerializedName("epg")
    private String epg;

    @SerializedName("format")
    private String format;
    private Group group;

    @SerializedName("header")
    @JsonAdapter(yc1.class)
    private Map<String, String> header;
    private int index;

    @SerializedName("logo")
    private String logo;

    @SerializedName("name")
    private String name;

    @SerializedName("number")
    private String number;

    @SerializedName("origin")
    private String origin;

    @SerializedName("parse")
    private Integer parse;

    @SerializedName("referer")
    private String referer;
    private boolean selected;
    private String show;

    @SerializedName("tvgId")
    private String tvgId;

    @SerializedName("tvgName")
    private String tvgName;

    @SerializedName("ua")
    private String ua;

    @SerializedName("urls")
    private List<String> urls;

    public Channel(String str) {
        this.name = str;
    }

    public static Channel create(int i) {
        return new Channel().setNumber(i);
    }

    public static Channel objectFrom(JsonElement jsonElement) {
        return (Channel) App.c().fromJson(jsonElement, Channel.class);
    }

    public Channel copy(Channel channel) {
        setCatchup(channel.getCatchup());
        setReferer(channel.getReferer());
        setTvgName(channel.getTvgName());
        setHeader(channel.getHeader());
        setNumber(channel.getNumber());
        setOrigin(channel.getOrigin());
        setFormat(channel.getFormat());
        setParse(channel.getParse());
        setClick(channel.getClick());
        setTvgId(channel.getTvgId());
        setLogo(channel.getLogo());
        setName(channel.getName());
        setShow(channel.getShow());
        setUrls(channel.getUrls());
        setDataList(channel.getDataList());
        setDrm(channel.getDrm());
        setEpg(channel.getEpg());
        setUa(channel.getUa());
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Channel) {
            Channel channel = (Channel) obj;
            String name = getName();
            String name2 = channel.getName();
            String number = getNumber();
            String number2 = channel.getNumber();
            if (!name.isEmpty() && !name2.isEmpty()) {
                return name.equals(name2);
            }
            if (!number.isEmpty() && !number2.isEmpty()) {
                return number.equals(number2);
            }
        }
        return false;
    }

    public Catchup getCatchup() {
        Catchup catchup = this.catchup;
        return catchup == null ? new Catchup() : catchup;
    }

    public String getClick() {
        return TextUtils.isEmpty(this.click) ? "" : this.click;
    }

    public String getCurrent() {
        if (getUrls().isEmpty()) {
            return "";
        }
        String str = getUrls().get(getIndex());
        return getDrm() != null ? str : str.split("\\$")[0];
    }

    public Epg getData(ZoneId zoneId) {
        final String str = LocalDate.now(zoneId).format(w41.a);
        List<Epg> list = this.dataList;
        return list == null ? new Epg() : list.stream().filter(new Predicate() { // from class: mr
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Epg) obj).equal(str);
            }
        }).findFirst().orElse(new Epg());
    }

    public List<Epg> getDataList() {
        List<Epg> list = this.dataList;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public Drm getDrm() {
        return this.drm;
    }

    public String getEpg() {
        return TextUtils.isEmpty(this.epg) ? "" : this.epg;
    }

    public String getFormat() {
        return this.format;
    }

    public Group getGroup() {
        return this.group;
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

    public int getIndex() {
        return this.index;
    }

    public String getLine() {
        if (getUrls().size() <= 1) {
            return "";
        }
        String[] strArrSplit = getUrls().get(getIndex()).split("\\$");
        return (strArrSplit.length <= 1 || strArrSplit[1].isEmpty()) ? vr3.m(sm3.M, Integer.valueOf(getIndex() + 1)) : strArrSplit[1];
    }

    public int getLineVisible() {
        return isOnly() ? 8 : 0;
    }

    public String getLogo() {
        return TextUtils.isEmpty(this.logo) ? "" : this.logo;
    }

    public String getName() {
        return TextUtils.isEmpty(this.name) ? "" : this.name;
    }

    public String getNumber() {
        return TextUtils.isEmpty(this.number) ? "" : this.number;
    }

    public String getOrigin() {
        return TextUtils.isEmpty(this.origin) ? "" : this.origin;
    }

    public Integer getParse() {
        Integer num = this.parse;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public String getReferer() {
        return TextUtils.isEmpty(this.referer) ? "" : this.referer;
    }

    public String getShow() {
        return TextUtils.isEmpty(this.show) ? getName() : this.show;
    }

    public String getTvgId() {
        return TextUtils.isEmpty(this.tvgId) ? getTvgName() : this.tvgId;
    }

    public String getTvgName() {
        return TextUtils.isEmpty(this.tvgName) ? getName() : this.tvgName;
    }

    public String getUa() {
        return TextUtils.isEmpty(this.ua) ? "" : this.ua;
    }

    public List<String> getUrls() {
        List<String> arrayList = this.urls;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.urls = arrayList;
        return arrayList;
    }

    public Channel group(Group group) {
        setGroup(group);
        return this;
    }

    public boolean hasCatchup() {
        if (getCatchup().isEmpty() && getCurrent().contains("/PLTV/")) {
            setCatchup(Catchup.PLTV());
        }
        return !getCatchup().getRegex().isEmpty() ? getCatchup().match(getCurrent()) : !getCatchup().isEmpty();
    }

    public int hashCode() {
        String name = getName();
        String number = getNumber();
        if (!name.isEmpty()) {
            return Objects.hash(name);
        }
        if (number.isEmpty()) {
            return 0;
        }
        return Objects.hash(number);
    }

    public boolean isLast() {
        return getUrls().isEmpty() || getIndex() == getUrls().size() - 1;
    }

    public boolean isOnly() {
        return getUrls().size() == 1;
    }

    public boolean isRtsp() {
        return getCurrent().startsWith("rtsp");
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void live(Live live) {
        if (!live.getUa().isEmpty() && getUa().isEmpty()) {
            setUa(live.getUa());
        }
        if (!live.getClick().isEmpty() && getClick().isEmpty()) {
            setClick(live.getClick());
        }
        if (!live.getHeader().isEmpty() && getHeader().isEmpty()) {
            setHeader(live.getHeader());
        }
        if (!live.getOrigin().isEmpty() && getOrigin().isEmpty()) {
            setOrigin(live.getOrigin());
        }
        if (!live.getCatchup().isEmpty() && getCatchup().isEmpty()) {
            setCatchup(live.getCatchup());
        }
        if (!live.getReferer().isEmpty() && getReferer().isEmpty()) {
            setReferer(live.getReferer());
        }
        if (live.getEpg().contains("{") && !getEpg().startsWith("http")) {
            setEpg(live.getEpgApi().replace("{id}", getTvgId()).replace("{name}", getTvgName()).replace("{epg}", getEpg()));
        }
        if (!live.getLogo().contains("{") || getLogo().startsWith("http")) {
            return;
        }
        setLogo(live.getLogo().replace("{id}", getTvgId()).replace("{name}", getTvgName()).replace("{logo}", getLogo()));
    }

    public void loadLogo(ImageView imageView) {
        si1.i(getName(), getLogo(), imageView, false);
    }

    public Result result() {
        Result result = new Result();
        result.setDrm(getDrm());
        result.setUrl(getCurrent());
        result.setClick(getClick());
        result.setParse(getParse());
        result.setFormat(getFormat());
        result.setHeader(getHeaders());
        return result;
    }

    public void setCatchup(Catchup catchup) {
        this.catchup = catchup;
    }

    public void setClick(String str) {
        this.click = str;
    }

    public void setData(final Epg epg) {
        if (this.dataList == null) {
            this.dataList = new ArrayList();
        }
        this.dataList.removeIf(new Predicate() { // from class: nr
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Epg) obj).equal(epg.getDate());
            }
        });
        this.dataList.add(epg);
    }

    public void setDataList(List<Epg> list) {
        this.dataList = new ArrayList(list);
    }

    public void setDrm(Drm drm) {
        this.drm = drm;
    }

    public void setEpg(String str) {
        this.epg = str;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setHeader(Map<String, String> map) {
        this.header = map;
    }

    public void setIndex(String str) {
        for (int i = 0; i < getUrls().size(); i++) {
            String str2 = getUrls().get(i);
            if (str2.equals(str) || (str2.contains("$") && str.equals(str2.split("\\$")[0]))) {
                setIndex(i);
                return;
            }
        }
    }

    public void setLogo(String str) {
        this.logo = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Channel setNumber(int i) {
        setNumber(String.format(Locale.getDefault(), "%03d", Integer.valueOf(i)));
        return this;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public void setParse(Integer num) {
        this.parse = num;
    }

    public void setReferer(String str) {
        this.referer = str;
    }

    public void setSelected(Channel channel) {
        this.selected = channel.equals(this);
    }

    public void setShow(String str) {
        this.show = str;
    }

    public void setTvgId(String str) {
        this.tvgId = str;
    }

    public void setTvgName(String str) {
        this.tvgName = str;
    }

    public void setUa(String str) {
        this.ua = str;
    }

    public void setUrls(List<String> list) {
        this.urls = list;
    }

    public void switchLine(boolean z) {
        List<String> urls = getUrls();
        if (urls.isEmpty()) {
            return;
        }
        int size = urls.size();
        setIndex(((getIndex() + (z ? 1 : -1)) + size) % size);
    }

    public Channel trans() {
        if (Trans.pass()) {
            return this;
        }
        this.show = Trans.s2t(this.name);
        return this;
    }

    public Channel() {
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }

    public static Channel create(String str) {
        return new Channel(str);
    }

    public static Channel create(Channel channel) {
        return new Channel().copy(channel);
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public Epg getData() {
        return getData(ZoneId.systemDefault());
    }

    public void setIndex(int i) {
        this.index = Math.max(i, 0);
    }
}
