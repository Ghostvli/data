package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.github.catvod.utils.Trans;
import com.google.gson.annotations.SerializedName;
import defpackage.w41;
import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.format.DateTimeFormatter;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class EpgData {

    @SerializedName("end")
    private String end;
    private long endTime;
    private boolean selected;

    @SerializedName("start")
    private String start;
    private long startTime;

    @SerializedName("title")
    private String title;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void checkDay(ZoneId zoneId) {
        setEndTime(Instant.ofEpochMilli(getEndTime()).atZone(zoneId).plusDays(1L).toInstant().toEpochMilli());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EpgData) {
            EpgData epgData = (EpgData) obj;
            if (Objects.equals(getTitle(), epgData.getTitle()) && Objects.equals(getEnd(), epgData.getEnd()) && Objects.equals(getStart(), epgData.getStart())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String format() {
        if (getTitle().isEmpty()) {
            return "";
        }
        if (getStart().isEmpty() && getEnd().isEmpty()) {
            return getTitle();
        }
        return getStart() + " ~ " + getEnd() + "  " + getTitle();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getEnd() {
        return TextUtils.isEmpty(this.end) ? "" : this.end;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getEndTime() {
        return this.endTime;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getRange() {
        StringBuilder sb = new StringBuilder("clock=");
        DateTimeFormatter dateTimeFormatter = w41.g;
        sb.append(dateTimeFormatter.format(Instant.ofEpochMilli(getStartTime())));
        sb.append("-");
        sb.append(dateTimeFormatter.format(Instant.ofEpochMilli(getEndTime())));
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getStart() {
        return TextUtils.isEmpty(this.start) ? "" : this.start;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getStartTime() {
        return this.startTime;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getTime() {
        if (getStart().isEmpty() && getEnd().isEmpty()) {
            return "";
        }
        return getStart() + " ~ " + getEnd();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getTitle() {
        return TextUtils.isEmpty(this.title) ? "" : this.title;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hash(getTitle(), getEnd(), getStart());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isFuture() {
        return getStartTime() > System.currentTimeMillis();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isInRange() {
        return getStartTime() <= System.currentTimeMillis() && System.currentTimeMillis() <= getEndTime();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isSelected() {
        return this.selected;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setEnd(String str) {
        this.end = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setEndTime(long j) {
        this.endTime = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSelected(EpgData epgData) {
        this.selected = epgData.equals(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setStart(String str) {
        this.start = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setStartTime(long j) {
        this.startTime = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTitle(String str) {
        this.title = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void trans() {
        if (Trans.pass()) {
            return;
        }
        this.title = Trans.s2t(this.title);
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }
}
