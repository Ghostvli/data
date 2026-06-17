package com.hierynomus.security.bc;

import com.hierynomus.protocol.commons.Factory;
import com.hierynomus.security.Cipher;
import com.hierynomus.security.SecurityException;
import defpackage.c;
import defpackage.n70;
import defpackage.nl1;
import defpackage.on3;
import defpackage.p70;
import defpackage.se4;
import defpackage.ul;
import defpackage.yq1;
import defpackage.yt;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class BCCipherFactory {
    private static final Map<String, Factory<Cipher>> lookup;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class BCBlockCipher implements Cipher {
        private ul wrappedCipher;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public BCBlockCipher(ul ulVar) {
            this.wrappedCipher = ulVar;
        }

        public abstract yt createParams(byte[] bArr);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.security.Cipher
        public int doFinal(byte[] bArr, int i) throws SecurityException {
            try {
                return this.wrappedCipher.a(bArr, i);
            } catch (nl1 e) {
                throw new SecurityException(e);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.security.Cipher
        public void init(Cipher.CryptMode cryptMode, byte[] bArr) {
            this.wrappedCipher.d(cryptMode == Cipher.CryptMode.ENCRYPT, createParams(bArr));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.security.Cipher
        public void reset() {
            this.wrappedCipher.f();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.security.Cipher
        public int update(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
            return this.wrappedCipher.e(bArr, i, i2, bArr2, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class BCStreamCipher implements Cipher {
        private se4 streamCipher;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public BCStreamCipher(se4 se4Var) {
            this.streamCipher = se4Var;
        }

        public abstract yt createParams(byte[] bArr);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.security.Cipher
        public int doFinal(byte[] bArr, int i) {
            this.streamCipher.reset();
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.security.Cipher
        public void init(Cipher.CryptMode cryptMode, byte[] bArr) {
            this.streamCipher.a(cryptMode == Cipher.CryptMode.ENCRYPT, createParams(bArr));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.security.Cipher
        public void reset() {
            this.streamCipher.reset();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.security.Cipher
        public int update(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
            return this.streamCipher.c(bArr, i, i2, bArr2, i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        HashMap map = new HashMap();
        lookup = map;
        map.put("DES/ECB/NoPadding", new Factory<Cipher>() { // from class: com.hierynomus.security.bc.BCCipherFactory.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: create()Ljava/lang/Object; */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.hierynomus.protocol.commons.Factory
            public Cipher create() {
                return new BCBlockCipher(new ul(new n70())) { // from class: com.hierynomus.security.bc.BCCipherFactory.1.1
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // com.hierynomus.security.bc.BCCipherFactory.BCBlockCipher
                    public yt createParams(byte[] bArr) {
                        return new p70(bArr);
                    }
                };
            }
        });
        map.put("RC4", new Factory<Cipher>() { // from class: com.hierynomus.security.bc.BCCipherFactory.2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: create()Ljava/lang/Object; */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.hierynomus.protocol.commons.Factory
            public Cipher create() {
                return new BCStreamCipher(new on3()) { // from class: com.hierynomus.security.bc.BCCipherFactory.2.1
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // com.hierynomus.security.bc.BCCipherFactory.BCStreamCipher
                    public yt createParams(byte[] bArr) {
                        return new yq1(bArr);
                    }
                };
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Cipher create(String str) {
        Factory<Cipher> factory = lookup.get(str);
        if (factory != null) {
            return factory.create();
        }
        c.a("Unknown Cipher ", str);
        return null;
    }
}
