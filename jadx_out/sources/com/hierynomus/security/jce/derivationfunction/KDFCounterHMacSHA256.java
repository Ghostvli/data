package com.hierynomus.security.jce.derivationfunction;

import com.hierynomus.security.SecurityException;
import com.hierynomus.security.jce.JceDerivationFunction;
import defpackage.jl;
import java.security.InvalidKeyException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class KDFCounterHMacSHA256 extends JceDerivationFunction {
    private byte[] fixedSuffix;
    private Mac mac = Mac.getInstance("HmacSHA256");
    private int maxLength;

    @Override // com.hierynomus.security.jce.JceDerivationFunction, com.hierynomus.security.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) {
        int i3 = i2 / 32;
        if (i2 % 32 != 0) {
            i3++;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            i4++;
            this.mac.update(new byte[]{(byte) (i4 >>> 24), (byte) (i4 >>> 16), (byte) (i4 >>> 8), (byte) i4});
            this.mac.update(this.fixedSuffix);
            byte[] bArrDoFinal = this.mac.doFinal();
            int length = bArrDoFinal.length;
            if (bArrDoFinal.length + i5 > i2) {
                length = i2 - i5;
            }
            System.arraycopy(bArrDoFinal, 0, bArr, i, length);
            i5 += length;
            i += length;
        }
        return i2;
    }

    @Override // com.hierynomus.security.jce.JceDerivationFunction, com.hierynomus.security.DerivationFunction
    public void init(DerivationParameters derivationParameters) throws SecurityException {
        if (!(derivationParameters instanceof CounterDerivationParameters)) {
            jl.a("Parameters should be a CounterDerivationParameters");
            return;
        }
        CounterDerivationParameters counterDerivationParameters = (CounterDerivationParameters) derivationParameters;
        try {
            this.mac.init(new SecretKeySpec(counterDerivationParameters.getSeed(), "HmacSHA256"));
            this.fixedSuffix = counterDerivationParameters.getFixedCounterSuffix();
            this.maxLength = counterDerivationParameters.getCounterLength();
        } catch (InvalidKeyException e) {
            throw new SecurityException(e);
        }
    }
}
