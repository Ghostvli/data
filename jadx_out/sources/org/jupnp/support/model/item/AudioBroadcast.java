package org.jupnp.support.model.item;

import org.jupnp.support.model.DIDLObject;
import org.jupnp.support.model.Res;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AudioBroadcast extends AudioItem {
    public static final DIDLObject.Class CLASS = new DIDLObject.Class("object.item.audioItem.audioBroadcast");

    public AudioBroadcast() {
        setClazz(CLASS);
    }

    public Integer getChannelNr() {
        return (Integer) getFirstPropertyValue(DIDLObject.Property.UPNP.CHANNEL_NR.class);
    }

    public String getRadioBand() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.RADIO_BAND.class);
    }

    public String getRadioCallSign() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.RADIO_CALL_SIGN.class);
    }

    public String getRadioStationID() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.RADIO_STATION_ID.class);
    }

    public String getRegion() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.REGION.class);
    }

    public AudioBroadcast setChannelNr(Integer num) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.CHANNEL_NR(num));
        return this;
    }

    public AudioBroadcast setRadioBand(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.RADIO_BAND(str));
        return this;
    }

    public AudioBroadcast setRadioCallSign(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.RADIO_CALL_SIGN(str));
        return this;
    }

    public AudioBroadcast setRadioStationID(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.RADIO_STATION_ID(str));
        return this;
    }

    public AudioBroadcast setRegion(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.REGION(str));
        return this;
    }

    public AudioBroadcast(Item item) {
        super(item);
    }

    public AudioBroadcast(String str, String str2, String str3, String str4, Res... resArr) {
        super(str, str2, str3, str4, resArr);
        setClazz(CLASS);
    }
}
