package com.hierynomus.security.bc;

import com.hierynomus.protocol.commons.Factory;
import com.hierynomus.security.DerivationFunction;
import com.hierynomus.security.jce.derivationfunction.CounterDerivationParameters;
import com.hierynomus.security.jce.derivationfunction.DerivationParameters;
import defpackage.c;
import defpackage.gw3;
import defpackage.jl;
import defpackage.kp1;
import defpackage.lp1;
import defpackage.nj0;
import defpackage.oj0;
import defpackage.xb1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class BCDerivationFunctionFactory {
    private static final Map<String, Factory<DerivationFunction>> lookup;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class BCDerivationFunction implements DerivationFunction {
        private final nj0 function;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public BCDerivationFunction(nj0 nj0Var) {
            this.function = nj0Var;
        }

        public abstract oj0 createParams(DerivationParameters derivationParameters);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.security.DerivationFunction
        public int generateBytes(byte[] bArr, int i, int i2) {
            return this.function.generateBytes(bArr, i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.security.DerivationFunction
        public void init(DerivationParameters derivationParameters) {
            this.function.a(createParams(derivationParameters));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        HashMap map = new HashMap();
        lookup = map;
        map.put("KDF/Counter/HMACSHA256", new Factory<DerivationFunction>() { // from class: com.hierynomus.security.bc.BCDerivationFunctionFactory.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: create()Ljava/lang/Object; */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.hierynomus.protocol.commons.Factory
            public DerivationFunction create() {
                return new BCDerivationFunction(new kp1(new xb1(new gw3()))) { // from class: com.hierynomus.security.bc.BCDerivationFunctionFactory.1.1
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // com.hierynomus.security.bc.BCDerivationFunctionFactory.BCDerivationFunction
                    public oj0 createParams(DerivationParameters derivationParameters) {
                        if (derivationParameters instanceof CounterDerivationParameters) {
                            CounterDerivationParameters counterDerivationParameters = (CounterDerivationParameters) derivationParameters;
                            return new lp1(counterDerivationParameters.getSeed(), counterDerivationParameters.getFixedCounterSuffix(), counterDerivationParameters.getCounterLength());
                        }
                        jl.a("Parameters should be a CounterDerivationParameters");
                        return null;
                    }
                };
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static DerivationFunction create(String str) {
        Factory<DerivationFunction> factory = lookup.get(str);
        if (factory != null) {
            return factory.create();
        }
        c.a("Unknown DerivationFunction ", str);
        return null;
    }
}
