package com.hierynomus.security.bc;

import com.hierynomus.protocol.commons.Factory;
import com.hierynomus.security.AEADBlockCipher;
import com.hierynomus.security.Cipher;
import com.hierynomus.security.SecurityException;
import defpackage.c;
import defpackage.e;
import defpackage.g;
import defpackage.h;
import defpackage.nl1;
import defpackage.on;
import defpackage.y81;
import defpackage.yq1;
import defpackage.yt;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class BCAEADCipherFactory {
    private static final Map<String, Factory<AEADBlockCipher>> lookup;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class BCAEADBlockCipher implements AEADBlockCipher {
        private e wrappedCipher;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public BCAEADBlockCipher(e eVar) {
            this.wrappedCipher = eVar;
        }

        public abstract yt createParams(byte[] bArr, GCMParameterSpec gCMParameterSpec);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.security.AEADBlockCipher
        public byte[] doFinal(byte[] bArr, int i, int i2) throws SecurityException {
            byte[] bArr2 = new byte[this.wrappedCipher.e(i2)];
            try {
                this.wrappedCipher.doFinal(bArr2, this.wrappedCipher.c(bArr, i, i2, bArr2, 0));
                return bArr2;
            } catch (nl1 e) {
                throw new SecurityException(e);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.security.AEADBlockCipher
        public void init(Cipher.CryptMode cryptMode, byte[] bArr, GCMParameterSpec gCMParameterSpec) {
            this.wrappedCipher.a(cryptMode == Cipher.CryptMode.ENCRYPT, createParams(bArr, gCMParameterSpec));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.security.AEADBlockCipher
        public void reset() {
            this.wrappedCipher.reset();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.security.AEADBlockCipher
        public byte[] update(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[this.wrappedCipher.d(i2)];
            this.wrappedCipher.c(bArr, i, i2, bArr2, 0);
            return bArr2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.security.AEADBlockCipher
        public void updateAAD(byte[] bArr, int i, int i2) {
            this.wrappedCipher.f(bArr, i, i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        HashMap map = new HashMap();
        lookup = map;
        map.put("AES/CCM/NoPadding", new Factory<AEADBlockCipher>() { // from class: com.hierynomus.security.bc.BCAEADCipherFactory.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: create()Ljava/lang/Object; */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.hierynomus.protocol.commons.Factory
            public AEADBlockCipher create() {
                return new BCAEADBlockCipher(new on(new h())) { // from class: com.hierynomus.security.bc.BCAEADCipherFactory.1.1
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // com.hierynomus.security.bc.BCAEADCipherFactory.BCAEADBlockCipher
                    public yt createParams(byte[] bArr, GCMParameterSpec gCMParameterSpec) {
                        return new g(new yq1(bArr), gCMParameterSpec.getTLen(), gCMParameterSpec.getIV());
                    }
                };
            }
        });
        map.put("AES/GCM/NoPadding", new Factory<AEADBlockCipher>() { // from class: com.hierynomus.security.bc.BCAEADCipherFactory.2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: create()Ljava/lang/Object; */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.hierynomus.protocol.commons.Factory
            public AEADBlockCipher create() {
                return new BCAEADBlockCipher(new y81(new h())) { // from class: com.hierynomus.security.bc.BCAEADCipherFactory.2.1
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // com.hierynomus.security.bc.BCAEADCipherFactory.BCAEADBlockCipher
                    public yt createParams(byte[] bArr, GCMParameterSpec gCMParameterSpec) {
                        return new g(new yq1(bArr), gCMParameterSpec.getTLen(), gCMParameterSpec.getIV());
                    }
                };
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static AEADBlockCipher create(String str) {
        Factory<AEADBlockCipher> factory = lookup.get(str);
        if (factory != null) {
            return factory.create();
        }
        c.a("Unknown AEADCipher ", str);
        return null;
    }
}
