package org.jupnp.model.types;

import okhttp3.internal.ws.WebSocketProtocol;
import org.jupnp.util.SpecificationViolationReporter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class UnsignedVariableInteger {
    protected long value;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum Bits {
        EIGHT(255),
        SIXTEEN(WebSocketProtocol.PAYLOAD_SHORT_MAX),
        TWENTYFOUR(16777215),
        THIRTYTWO(4294967295L);

        private final long maxValue;

        Bits(long j) {
            this.maxValue = j;
        }

        public long getMaxValue() {
            return this.maxValue;
        }
    }

    public UnsignedVariableInteger(String str) {
        if (str.startsWith("-")) {
            SpecificationViolationReporter.report("Invalid negative integer value '" + str + "', assuming value 0!", new Object[0]);
            str = "0";
        }
        setValue(Long.parseLong(str.trim()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.value == ((UnsignedVariableInteger) obj).value;
    }

    public abstract Bits getBits();

    public int getMinValue() {
        return 0;
    }

    public Long getValue() {
        return Long.valueOf(this.value);
    }

    public int hashCode() {
        long j = this.value;
        return (int) (j ^ (j >>> 32));
    }

    public UnsignedVariableInteger increment(boolean z) {
        if (this.value + 1 > getBits().getMaxValue()) {
            this.value = z ? 1L : 0L;
            return this;
        }
        this.value++;
        return this;
    }

    public void isInRange(long j) {
        if (j < getMinValue() || j > getBits().getMaxValue()) {
            throw new NumberFormatException("Value must be between " + getMinValue() + " and " + getBits().getMaxValue() + ": " + j);
        }
    }

    public UnsignedVariableInteger setValue(long j) {
        isInRange(j);
        this.value = j;
        return this;
    }

    public String toString() {
        return Long.toString(this.value);
    }

    public UnsignedVariableInteger(long j) {
        setValue(j);
    }

    public UnsignedVariableInteger() {
    }
}
