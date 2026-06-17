package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Device;
import com.fongmi.android.tv.db.AppDatabase;
import com.google.gson.annotations.SerializedName;
import defpackage.fh3;
import defpackage.jy4;
import defpackage.nl0;
import defpackage.qx4;
import defpackage.t14;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import org.jupnp.model.meta.RemoteDevice;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Device implements nl0, Comparable<Device> {

    @SerializedName("eth")
    private String eth;

    @SerializedName(Name.MARK)
    private Integer id;

    @SerializedName("ip")
    private String ip;

    @SerializedName("name")
    private String name;

    @SerializedName("serial")
    private String serial;

    @SerializedName("time")
    private long time;

    @SerializedName("type")
    private int type;

    @SerializedName("uuid")
    private String uuid;

    @SerializedName("wlan")
    private String wlan;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void delete() {
        AppDatabase.Q().S().g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Device get() {
        Device device = new Device();
        device.setTime(App.i());
        device.setSerial(jy4.k());
        device.setEth(jy4.i("eth0"));
        device.setWlan(jy4.i("wlan0"));
        device.setUuid(jy4.e());
        device.setName(jy4.h());
        device.setIp(t14.b().c());
        device.setType(fh3.d());
        return device;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<Device> getAll() {
        return AppDatabase.Q().S().h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Device objectFrom(String str) {
        return (Device) App.c().fromJson(str, Device.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: compareTo(Ljava/lang/Object;)I */
    @Override // java.lang.Comparable
    public int compareTo(Device device) {
        return Comparator.comparingInt(new ToIntFunction() { // from class: vj0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((Device) obj).getType();
            }
        }).thenComparing(new Function() { // from class: wj0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Device) obj).getName();
            }
        }, String.CASE_INSENSITIVE_ORDER).thenComparing(new Function() { // from class: xj0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Device) obj).getUuid();
            }
        }).compare(this, device);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Device) {
            return Objects.equals(getUuid(), ((Device) obj).getUuid());
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getHost() {
        return isDLNA() ? getUuid() : qx4.e(getIp());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getId() {
        return this.id;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getIp() {
        return TextUtils.isEmpty(this.ip) ? "" : this.ip;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getName() {
        return TextUtils.isEmpty(this.name) ? "" : this.name;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getType() {
        return this.type;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getUuid() {
        return TextUtils.isEmpty(this.uuid) ? "" : this.uuid;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hash(getUuid());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isApp() {
        return isLeanback() || isMobile();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isDLNA() {
        return getType() == 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isLeanback() {
        return getType() == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isMobile() {
        return getType() == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: isSameContent(Ljava/lang/Object;)Z */
    @Override // defpackage.nl0
    public boolean isSameContent(Device device) {
        return getName().equals(device.getName()) && getType() == device.getType();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Device save() {
        AppDatabase.Q().S().c(this);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setEth(String str) {
        this.eth = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setId(Integer num) {
        this.id = num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIp(String str) {
        this.ip = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setName(String str) {
        this.name = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSerial(String str) {
        this.serial = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTime(long j) {
        this.time = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setType(int i) {
        this.type = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setUuid(String str) {
        this.uuid = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setWlan(String str) {
        this.wlan = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return App.c().toJson(this);
    }

    /* JADX DEBUG: Method merged with bridge method: isSameItem(Ljava/lang/Object;)Z */
    @Override // defpackage.nl0
    public boolean isSameItem(Device device) {
        return equals(device);
    }

    public static Device get(RemoteDevice remoteDevice) {
        Device device = new Device();
        device.setUuid(remoteDevice.getIdentity().getUdn().getIdentifierString());
        device.setName(remoteDevice.getDetails().getFriendlyName());
        device.setType(2);
        return device;
    }
}
