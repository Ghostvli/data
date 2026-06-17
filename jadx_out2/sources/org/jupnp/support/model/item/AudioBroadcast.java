package org.jupnp.support.model.item;

import org.jupnp.support.model.DIDLObject;
import org.jupnp.support.model.Res;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AudioBroadcast extends AudioItem {
    public static final DIDLObject.Class CLASS = new DIDLObject.Class("object.item.audioItem.audioBroadcast");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AudioBroadcast() {
        setClazz(CLASS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getChannelNr() {
        return (Integer) getFirstPropertyValue(DIDLObject.Property.UPNP.CHANNEL_NR.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getRadioBand() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.RADIO_BAND.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getRadioCallSign() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.RADIO_CALL_SIGN.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getRadioStationID() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.RADIO_STATION_ID.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getRegion() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.REGION.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AudioBroadcast setChannelNr(Integer num) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.CHANNEL_NR(num));
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AudioBroadcast setRadioBand(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.RADIO_BAND(str));
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AudioBroadcast setRadioCallSign(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.RADIO_CALL_SIGN(str));
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AudioBroadcast setRadioStationID(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.RADIO_STATION_ID(str));
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
