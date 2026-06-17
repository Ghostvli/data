package com.hierynomus.security.jce;

import com.hierynomus.security.AEADBlockCipher;
import com.hierynomus.security.Cipher;
import com.hierynomus.security.DerivationFunction;
import com.hierynomus.security.Mac;
import com.hierynomus.security.MessageDigest;
import com.hierynomus.security.SecurityProvider;
import com.hierynomus.security.mac.HmacT64;
import java.security.Provider;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JceSecurityProvider implements SecurityProvider {
    private final Provider jceProvider;
    private final String providerName;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public JceSecurityProvider() {
        this.jceProvider = null;
        this.providerName = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.security.SecurityProvider
    public AEADBlockCipher getAEADBlockCipher(String str) {
        return new JceAEADCipher(str, this.jceProvider, this.providerName);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.security.SecurityProvider
    public Cipher getCipher(String str) {
        return new JceCipher(str, this.jceProvider, this.providerName);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.security.SecurityProvider
    public DerivationFunction getDerivationFunction(String str) {
        return JceDerivationFunctionFactory.create(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.security.SecurityProvider
    public MessageDigest getDigest(String str) {
        return new JceMessageDigest(str, this.jceProvider, this.providerName);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.security.SecurityProvider
    public Mac getMac(String str) {
        return Objects.equals(str, "HMACT64") ? new HmacT64(getDigest("MD5")) : new JceMac(str, this.jceProvider, this.providerName);
    }

    public JceSecurityProvider(String str) {
        this.providerName = str;
        this.jceProvider = null;
    }

    public JceSecurityProvider(Provider provider) {
        this.providerName = null;
        this.jceProvider = provider;
    }
}
