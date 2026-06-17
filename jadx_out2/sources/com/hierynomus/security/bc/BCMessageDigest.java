package com.hierynomus.security.bc;

import com.hierynomus.protocol.commons.Factory;
import com.hierynomus.security.MessageDigest;
import defpackage.f02;
import defpackage.gw3;
import defpackage.hw3;
import defpackage.k32;
import defpackage.l32;
import defpackage.sl0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class BCMessageDigest implements MessageDigest {
    private static Map<String, Factory<sl0>> lookup;
    private final sl0 digest;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        HashMap map = new HashMap();
        lookup = map;
        map.put("SHA-512", new Factory<sl0>() { // from class: com.hierynomus.security.bc.BCMessageDigest.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: create()Ljava/lang/Object; */
            @Override // com.hierynomus.protocol.commons.Factory
            public sl0 create() {
                return new hw3();
            }
        });
        lookup.put("SHA256", new Factory<sl0>() { // from class: com.hierynomus.security.bc.BCMessageDigest.2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: create()Ljava/lang/Object; */
            @Override // com.hierynomus.protocol.commons.Factory
            public sl0 create() {
                return new gw3();
            }
        });
        lookup.put("MD4", new Factory<sl0>() { // from class: com.hierynomus.security.bc.BCMessageDigest.3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: create()Ljava/lang/Object; */
            @Override // com.hierynomus.protocol.commons.Factory
            public sl0 create() {
                return new k32();
            }
        });
        lookup.put("MD5", new Factory<sl0>() { // from class: com.hierynomus.security.bc.BCMessageDigest.4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: create()Ljava/lang/Object; */
            @Override // com.hierynomus.protocol.commons.Factory
            public sl0 create() {
                return new l32();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public BCMessageDigest(String str) {
        this.digest = getDigest(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private sl0 getDigest(String str) {
        Factory<sl0> factory = lookup.get(str);
        if (factory != null) {
            return factory.create();
        }
        f02.a("No MessageDigest ", str, " defined in BouncyCastle");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.security.MessageDigest
    public byte[] digest() {
        byte[] bArr = new byte[this.digest.e()];
        this.digest.doFinal(bArr, 0);
        return bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.security.MessageDigest
    public int getDigestLength() {
        return this.digest.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.security.MessageDigest
    public void reset() {
        this.digest.reset();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.security.MessageDigest
    public void update(byte[] bArr) {
        this.digest.update(bArr, 0, bArr.length);
    }

    @Override // com.hierynomus.security.MessageDigest
    public void update(byte b) {
        this.digest.update(b);
    }

    @Override // com.hierynomus.security.MessageDigest
    public void update(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }
}
