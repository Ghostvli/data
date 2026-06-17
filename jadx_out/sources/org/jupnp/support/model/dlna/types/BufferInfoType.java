package org.jupnp.support.model.dlna.types;

import defpackage.f80;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jupnp.support.model.dlna.types.CodedDataBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class BufferInfoType {
    private static final Pattern pattern = Pattern.compile("^dejitter=(\\d{1,10})(;CDB=(\\d{1,10});BTM=(0|1|2))?(;TD=(\\d{1,10}))?(;BFR=(0|1))?$", 2);
    private CodedDataBuffer cdb;
    private Long dejitterSize;
    private Boolean fullnessReports;
    private Long targetDuration;

    public BufferInfoType(Long l, CodedDataBuffer codedDataBuffer, Long l2, Boolean bool) {
        this.dejitterSize = l;
        this.cdb = codedDataBuffer;
        this.targetDuration = l2;
        this.fullnessReports = bool;
    }

    public static BufferInfoType valueOf(String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            try {
                return new BufferInfoType(Long.valueOf(Long.parseLong(matcher.group(1))), matcher.group(2) != null ? new CodedDataBuffer(Long.valueOf(Long.parseLong(matcher.group(3))), CodedDataBuffer.TransferMechanism.values()[Integer.parseInt(matcher.group(4))]) : null, matcher.group(5) != null ? Long.valueOf(Long.parseLong(matcher.group(6))) : null, matcher.group(7) != null ? Boolean.valueOf(matcher.group(8).equals("1")) : null);
            } catch (NumberFormatException unused) {
            }
        }
        f80.a("Can't parse BufferInfoType: ", str);
        return null;
    }

    public CodedDataBuffer getCdb() {
        return this.cdb;
    }

    public Long getDejitterSize() {
        return this.dejitterSize;
    }

    public String getString() {
        String str = "dejitter=" + this.dejitterSize.toString();
        CodedDataBuffer codedDataBuffer = this.cdb;
        if (codedDataBuffer != null) {
            str = str + ";CDB=" + codedDataBuffer.getSize().toString() + ";BTM=" + this.cdb.getTranfer().ordinal();
        }
        Long l = this.targetDuration;
        if (l != null) {
            str = str + ";TD=" + l;
        }
        Boolean bool = this.fullnessReports;
        if (bool == null) {
            return str;
        }
        return str + ";BFR=" + (bool.booleanValue() ? "1" : "0");
    }

    public Long getTargetDuration() {
        return this.targetDuration;
    }

    public Boolean isFullnessReports() {
        return this.fullnessReports;
    }

    public BufferInfoType(Long l) {
        this.dejitterSize = l;
    }
}
