package com.hierynomus.security.bc;

import com.hierynomus.protocol.commons.Factory;
import com.hierynomus.security.Mac;
import defpackage.gw3;
import defpackage.h;
import defpackage.jl;
import defpackage.l32;
import defpackage.rn;
import defpackage.xb1;
import defpackage.y32;
import defpackage.yq1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class BCMac implements Mac {
    private static Map<String, Factory<y32>> lookup;
    private final y32 mac;

    static {
        HashMap map = new HashMap();
        lookup = map;
        map.put("HMACSHA256", new Factory<y32>() { // from class: com.hierynomus.security.bc.BCMac.1
            @Override // com.hierynomus.protocol.commons.Factory
            public y32 create() {
                return new xb1(new gw3());
            }
        });
        lookup.put("HMACMD5", new Factory<y32>() { // from class: com.hierynomus.security.bc.BCMac.2
            @Override // com.hierynomus.protocol.commons.Factory
            public y32 create() {
                return new xb1(new l32());
            }
        });
        lookup.put("AESCMAC", new Factory<y32>() { // from class: com.hierynomus.security.bc.BCMac.3
            @Override // com.hierynomus.protocol.commons.Factory
            public y32 create() {
                return new rn(new h());
            }
        });
    }

    public BCMac(String str) {
        this.mac = getMacFactory(str).create();
    }

    private Factory<y32> getMacFactory(String str) {
        Factory<y32> factory = lookup.get(str.toUpperCase());
        if (factory != null) {
            return factory;
        }
        jl.a("No Mac defined for ".concat(str));
        return null;
    }

    @Override // com.hierynomus.security.Mac
    public byte[] doFinal() {
        byte[] bArr = new byte[this.mac.a()];
        this.mac.doFinal(bArr, 0);
        return bArr;
    }

    @Override // com.hierynomus.security.Mac
    public void init(byte[] bArr) {
        this.mac.b(new yq1(bArr));
    }

    @Override // com.hierynomus.security.Mac
    public void reset() {
        this.mac.reset();
    }

    @Override // com.hierynomus.security.Mac
    public void update(byte[] bArr) {
        this.mac.update(bArr, 0, bArr.length);
    }

    @Override // com.hierynomus.security.Mac
    public void update(byte b) {
        this.mac.update(b);
    }

    @Override // com.hierynomus.security.Mac
    public void update(byte[] bArr, int i, int i2) {
        this.mac.update(bArr, i, i2);
    }
}
