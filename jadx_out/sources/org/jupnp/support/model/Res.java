package org.jupnp.support.model;

import java.net.URI;
import org.jupnp.util.MimeType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Res {
    protected Long bitrate;
    protected Long bitsPerSample;
    protected Long colorDepth;
    protected String duration;
    protected URI importUri;
    protected Long nrAudioChannels;
    protected String protection;
    protected ProtocolInfo protocolInfo;
    protected String resolution;
    protected Long sampleFrequency;
    protected Long size;
    protected String value;

    public Res(URI uri, ProtocolInfo protocolInfo, Long l, String str, Long l2, Long l3, Long l4, Long l5, Long l6, String str2, String str3, String str4) {
        this.importUri = uri;
        this.protocolInfo = protocolInfo;
        this.size = l;
        this.duration = str;
        this.bitrate = l2;
        this.sampleFrequency = l3;
        this.bitsPerSample = l4;
        this.nrAudioChannels = l5;
        this.colorDepth = l6;
        this.protection = str2;
        this.resolution = str3;
        this.value = str4;
    }

    public Long getBitrate() {
        return this.bitrate;
    }

    public Long getBitsPerSample() {
        return this.bitsPerSample;
    }

    public Long getColorDepth() {
        return this.colorDepth;
    }

    public String getDuration() {
        return this.duration;
    }

    public URI getImportUri() {
        return this.importUri;
    }

    public Long getNrAudioChannels() {
        return this.nrAudioChannels;
    }

    public String getProtection() {
        return this.protection;
    }

    public ProtocolInfo getProtocolInfo() {
        return this.protocolInfo;
    }

    public String getResolution() {
        return this.resolution;
    }

    public int getResolutionX() {
        if (getResolution() == null || getResolution().split("x").length != 2) {
            return 0;
        }
        return Integer.parseInt(getResolution().split("x")[0]);
    }

    public int getResolutionY() {
        if (getResolution() == null || getResolution().split("x").length != 2) {
            return 0;
        }
        return Integer.parseInt(getResolution().split("x")[1]);
    }

    public Long getSampleFrequency() {
        return this.sampleFrequency;
    }

    public Long getSize() {
        return this.size;
    }

    public String getValue() {
        return this.value;
    }

    public void setBitrate(Long l) {
        this.bitrate = l;
    }

    public void setBitsPerSample(Long l) {
        this.bitsPerSample = l;
    }

    public void setColorDepth(Long l) {
        this.colorDepth = l;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public void setImportUri(URI uri) {
        this.importUri = uri;
    }

    public void setNrAudioChannels(Long l) {
        this.nrAudioChannels = l;
    }

    public void setProtection(String str) {
        this.protection = str;
    }

    public void setProtocolInfo(ProtocolInfo protocolInfo) {
        this.protocolInfo = protocolInfo;
    }

    public void setResolution(int i, int i2) {
        this.resolution = i + "x" + i2;
    }

    public void setSampleFrequency(Long l) {
        this.sampleFrequency = l;
    }

    public void setSize(Long l) {
        this.size = l;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public Res(String str, Long l, String str2, Long l2, String str3) {
        this(new ProtocolInfo(Protocol.HTTP_GET, "*", str, "*"), l, str2, l2, str3);
    }

    public Res(MimeType mimeType, Long l, String str, Long l2, String str2) {
        this(new ProtocolInfo(mimeType), l, str, l2, str2);
    }

    public Res(MimeType mimeType, Long l, String str) {
        this(new ProtocolInfo(mimeType), l, str);
    }

    public Res(ProtocolInfo protocolInfo, Long l, String str) {
        this.protocolInfo = protocolInfo;
        this.size = l;
        this.value = str;
    }

    public Res(ProtocolInfo protocolInfo, Long l, String str, Long l2, String str2) {
        this.protocolInfo = protocolInfo;
        this.size = l;
        this.duration = str;
        this.bitrate = l2;
        this.value = str2;
    }

    public Res() {
    }
}
