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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Channel(String str) {
        this.name = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Channel create(int i) {
        return new Channel().setNumber(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Channel objectFrom(JsonElement jsonElement) {
        return (Channel) App.c().fromJson(jsonElement, Channel.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Catchup getCatchup() {
        Catchup catchup = this.catchup;
        return catchup == null ? new Catchup() : catchup;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getClick() {
        return TextUtils.isEmpty(this.click) ? "" : this.click;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getCurrent() {
        if (getUrls().isEmpty()) {
            return "";
        }
        String str = getUrls().get(getIndex());
        return getDrm() != null ? str : str.split("\\$")[0];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Epg getData(ZoneId zoneId) {
        final String str = LocalDate.now(zoneId).format(w41.a);
        List<Epg> list = this.dataList;
        return list == null ? new Epg() : list.stream().filter(new Predicate() { // from class: mr
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Epg) obj).equal(str);
            }
        }).findFirst().orElse(new Epg());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Epg> getDataList() {
        List<Epg> list = this.dataList;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Drm getDrm() {
        return this.drm;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getEpg() {
        return TextUtils.isEmpty(this.epg) ? "" : this.epg;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getFormat() {
        return this.format;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Group getGroup() {
        return this.group;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map<String, String> getHeader() {
        Map<String, String> map = this.header;
        return map == null ? new HashMap() : map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getIndex() {
        return this.index;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getLine() {
        if (getUrls().size() <= 1) {
            return "";
        }
        String[] strArrSplit = getUrls().get(getIndex()).split("\\$");
        return (strArrSplit.length <= 1 || strArrSplit[1].isEmpty()) ? vr3.m(sm3.M, Integer.valueOf(getIndex() + 1)) : strArrSplit[1];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getLineVisible() {
        return isOnly() ? 8 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getLogo() {
        return TextUtils.isEmpty(this.logo) ? "" : this.logo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getName() {
        return TextUtils.isEmpty(this.name) ? "" : this.name;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getNumber() {
        return TextUtils.isEmpty(this.number) ? "" : this.number;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getOrigin() {
        return TextUtils.isEmpty(this.origin) ? "" : this.origin;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getParse() {
        Integer num = this.parse;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getReferer() {
        return TextUtils.isEmpty(this.referer) ? "" : this.referer;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getShow() {
        return TextUtils.isEmpty(this.show) ? getName() : this.show;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getTvgId() {
        return TextUtils.isEmpty(this.tvgId) ? getTvgName() : this.tvgId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getTvgName() {
        return TextUtils.isEmpty(this.tvgName) ? getName() : this.tvgName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getUa() {
        return TextUtils.isEmpty(this.ua) ? "" : this.ua;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<String> getUrls() {
        List<String> arrayList = this.urls;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.urls = arrayList;
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Channel group(Group group) {
        setGroup(group);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean hasCatchup() {
        if (getCatchup().isEmpty() && getCurrent().contains("/PLTV/")) {
            setCatchup(Catchup.PLTV());
        }
        return !getCatchup().getRegex().isEmpty() ? getCatchup().match(getCurrent()) : !getCatchup().isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isLast() {
        return getUrls().isEmpty() || getIndex() == getUrls().size() - 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isOnly() {
        return getUrls().size() == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isRtsp() {
        return getCurrent().startsWith("rtsp");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isSelected() {
        return this.selected;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void loadLogo(ImageView imageView) {
        si1.i(getName(), getLogo(), imageView, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCatchup(Catchup catchup) {
        this.catchup = catchup;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setClick(String str) {
        this.click = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setData(final Epg epg) {
        if (this.dataList == null) {
            this.dataList = new ArrayList();
        }
        this.dataList.removeIf(new Predicate() { // from class: nr
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Epg) obj).equal(epg.getDate());
            }
        });
        this.dataList.add(epg);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setDataList(List<Epg> list) {
        this.dataList = new ArrayList(list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setDrm(Drm drm) {
        this.drm = drm;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setEpg(String str) {
        this.epg = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setFormat(String str) {
        this.format = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setGroup(Group group) {
        this.group = group;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setHeader(Map<String, String> map) {
        this.header = map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIndex(String str) {
        for (int i = 0; i < getUrls().size(); i++) {
            String str2 = getUrls().get(i);
            if (str2.equals(str) || (str2.contains("$") && str.equals(str2.split("\\$")[0]))) {
                setIndex(i);
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setLogo(String str) {
        this.logo = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setName(String str) {
        this.name = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Channel setNumber(int i) {
        setNumber(String.format(Locale.getDefault(), "%03d", Integer.valueOf(i)));
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOrigin(String str) {
        this.origin = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setParse(Integer num) {
        this.parse = num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setReferer(String str) {
        this.referer = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSelected(Channel channel) {
        this.selected = channel.equals(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setShow(String str) {
        this.show = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTvgId(String str) {
        this.tvgId = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTvgName(String str) {
        this.tvgName = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setUa(String str) {
        this.ua = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setUrls(List<String> list) {
        this.urls = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void switchLine(boolean z) {
        List<String> urls = getUrls();
        if (urls.isEmpty()) {
            return;
        }
        int size = urls.size();
        setIndex(((getIndex() + (z ? 1 : -1)) + size) % size);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
