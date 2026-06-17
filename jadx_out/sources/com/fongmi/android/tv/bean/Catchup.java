package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.format.DateTimeFormatter;
import java.net.URI;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Catchup {

    @SerializedName("days")
    private String days;

    @SerializedName("regex")
    private String regex;

    @SerializedName("replace")
    private String replace;

    @SerializedName("source")
    private String source;

    @SerializedName("type")
    private String type;
    private static final Pattern TOKEN_PATTERN = Pattern.compile("(\\$?\\{[^}]*\\})");
    private static final Pattern TAG_PATTERN = Pattern.compile("\\{([^}]+)\\}");

    public static Catchup PLTV() {
        Catchup catchup = new Catchup();
        catchup.setDays("7");
        catchup.setType("append");
        catchup.setRegex("/PLTV/");
        catchup.setReplace("/PLTV/,/TVOD/");
        catchup.setSource("?playseek=${(b)yyyyMMddHHmmss}-${(e)yyyyMMddHHmmss}");
        return catchup;
    }

    private String append(String str, String str2) {
        String[] strArrSplit = getReplace().split(",", 2);
        if (strArrSplit.length == 2) {
            str = str.replaceAll(strArrSplit[0], strArrSplit[1]);
        }
        if (!TextUtils.isEmpty(URI.create(str).getQuery())) {
            str2 = str2.replace("?", "&");
        }
        return str + str2;
    }

    public static Catchup create() {
        return new Catchup();
    }

    public static Catchup decide(Catchup catchup, Catchup catchup2) {
        if (!catchup.isEmpty()) {
            return catchup;
        }
        if (catchup2.isEmpty()) {
            return null;
        }
        return catchup2;
    }

    private String format(String str, long j, long j2) {
        Matcher matcher = TAG_PATTERN.matcher(str);
        if (!matcher.find()) {
            return "";
        }
        String strGroup = matcher.group(1);
        int iIndexOf = strGroup.indexOf(41);
        return (!strGroup.startsWith("(b") || iIndexOf < 0) ? (!strGroup.startsWith("(e") || iIndexOf < 0) ? strGroup.startsWith("utcend:") ? String.valueOf(j2 / 1000) : strGroup.startsWith("utc:") ? String.valueOf(j / 1000) : "" : formatTime(j2, strGroup.substring(iIndexOf + 1)) : formatTime(j, strGroup.substring(iIndexOf + 1));
    }

    private String formatTime(long j, String str) {
        return str.equals("timestamp") ? String.valueOf(j / 1000) : DateTimeFormatter.ofPattern(str, Locale.getDefault()).format(Instant.ofEpochMilli(j).atZone(ZoneId.systemDefault()));
    }

    private boolean isDefault() {
        return getType().equals("default");
    }

    public String getDays() {
        return TextUtils.isEmpty(this.days) ? "" : this.days;
    }

    public String getRegex() {
        return TextUtils.isEmpty(this.regex) ? "" : this.regex;
    }

    public String getReplace() {
        return TextUtils.isEmpty(this.replace) ? "" : this.replace;
    }

    public String getSource() {
        return TextUtils.isEmpty(this.source) ? "" : this.source;
    }

    public String getType() {
        return TextUtils.isEmpty(this.type) ? "" : this.type;
    }

    public boolean isEmpty() {
        return getSource().isEmpty();
    }

    public boolean match(String str) {
        return str.contains(getRegex()) || Pattern.compile(getRegex()).matcher(str).find();
    }

    public void setDays(String str) {
        this.days = str;
    }

    public void setRegex(String str) {
        this.regex = str;
    }

    public void setReplace(String str) {
        this.replace = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String format(String str, EpgData epgData) {
        String source = getSource();
        Matcher matcher = TOKEN_PATTERN.matcher(source);
        while (matcher.find()) {
            Catchup catchup = this;
            source = source.replace(matcher.group(1), catchup.format(matcher.group(1), epgData.getStartTime(), epgData.getEndTime()));
            this = catchup;
        }
        Catchup catchup2 = this;
        return catchup2.isDefault() ? source : catchup2.append(str, source);
    }
}
