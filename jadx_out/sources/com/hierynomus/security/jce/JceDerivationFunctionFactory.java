package com.hierynomus.security.jce;

import com.hierynomus.protocol.commons.Factory;
import com.hierynomus.security.DerivationFunction;
import com.hierynomus.security.jce.derivationfunction.KDFCounterHMacSHA256;
import defpackage.c;
import defpackage.f02;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JceDerivationFunctionFactory {
    private static final Map<String, Factory<DerivationFunction>> lookup;

    static {
        HashMap map = new HashMap();
        lookup = map;
        map.put("KDF/Counter/HMACSHA256", new Factory<DerivationFunction>() { // from class: com.hierynomus.security.jce.JceDerivationFunctionFactory.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.hierynomus.protocol.commons.Factory
            public DerivationFunction create() {
                try {
                    return new KDFCounterHMacSHA256();
                } catch (NoSuchAlgorithmException unused) {
                    return null;
                }
            }
        });
    }

    public static DerivationFunction create(String str) {
        Factory<DerivationFunction> factory = lookup.get(str);
        if (factory == null) {
            c.a("Unknown DerivationFunction ", str);
            return null;
        }
        DerivationFunction derivationFunctionCreate = factory.create();
        if (derivationFunctionCreate != null) {
            return derivationFunctionCreate;
        }
        f02.a("DerivationFunction ", str, " not supported!");
        return null;
    }
}
