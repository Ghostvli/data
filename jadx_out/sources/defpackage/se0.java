package defpackage;

import android.content.Context;
import android.os.Handler;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import defpackage.qg;
import defpackage.u23;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class se0 implements qg, hs4 {
    public static final xi1 r = xi1.z(4300000L, 3200000L, 2400000L, 1700000L, 860000L);
    public static final xi1 s = xi1.z(1500000L, 980000L, 750000L, 520000L, 290000L);
    public static final xi1 t = xi1.z(2000000L, 1300000L, 1000000L, 860000L, 610000L);
    public static final xi1 u = xi1.z(2500000L, 1700000L, 1200000L, 970000L, 680000L);
    public static final xi1 v = xi1.z(4700000L, 2800000L, 2100000L, 1700000L, 980000L);
    public static final xi1 w = xi1.z(2700000L, 2000000L, 1600000L, 1300000L, 1000000L);
    public static se0 x;
    public final Context a;
    public final zi1 b;
    public final qg.a.C0114a c;
    public final zu d;
    public final boolean e;
    public final m94 f;
    public int g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public int n;
    public boolean o;
    public int p;
    public String q;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final Context a;
        public final Map b;
        public int c;
        public zu d;
        public boolean e;

        public b(Context context) {
            this.a = context == null ? null : context.getApplicationContext();
            this.c = 2000;
            this.d = zu.a;
            this.e = true;
            HashMap map = new HashMap(8);
            this.b = map;
            map.put(0, 1000000L);
            map.put(2, -9223372036854775807L);
            map.put(3, -9223372036854775807L);
            map.put(4, -9223372036854775807L);
            map.put(5, -9223372036854775807L);
            map.put(10, -9223372036854775807L);
            map.put(9, -9223372036854775807L);
            map.put(7, -9223372036854775807L);
        }

        public se0 a() {
            return new se0(this.a, this.b, this.c, this.d, this.e);
        }
    }

    public se0(Context context, Map map, int i, zu zuVar, boolean z) {
        this.a = context == null ? null : context.getApplicationContext();
        this.b = zi1.c(map);
        this.c = new qg.a.C0114a();
        this.f = new m94(i);
        this.d = zuVar;
        this.e = z;
        if (context == null) {
            this.n = 0;
            this.l = 1000000L;
            return;
        }
        u23 u23VarE = u23.e(context);
        int iG = u23VarE.g();
        this.n = iG;
        this.l = l(iG);
        u23VarE.k(new u23.c() { // from class: re0
            @Override // u23.c
            public final void a(int i2) throws Throwable {
                this.a.q(i2);
            }
        }, sf.a());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int[] k(String str) {
        str.getClass();
        byte b2 = -1;
        switch (str.hashCode()) {
            case 2083:
                if (str.equals("AD")) {
                    b2 = 0;
                }
                break;
            case 2084:
                if (str.equals("AE")) {
                    b2 = 1;
                }
                break;
            case 2085:
                if (str.equals("AF")) {
                    b2 = 2;
                }
                break;
            case 2086:
                if (str.equals("AG")) {
                    b2 = 3;
                }
                break;
            case 2088:
                if (str.equals("AI")) {
                    b2 = 4;
                }
                break;
            case 2091:
                if (str.equals("AL")) {
                    b2 = 5;
                }
                break;
            case 2092:
                if (str.equals("AM")) {
                    b2 = 6;
                }
                break;
            case 2094:
                if (str.equals("AO")) {
                    b2 = 7;
                }
                break;
            case 2096:
                if (str.equals("AQ")) {
                    b2 = 8;
                }
                break;
            case 2097:
                if (str.equals("AR")) {
                    b2 = 9;
                }
                break;
            case 2098:
                if (str.equals("AS")) {
                    b2 = 10;
                }
                break;
            case 2099:
                if (str.equals("AT")) {
                    b2 = 11;
                }
                break;
            case 2100:
                if (str.equals("AU")) {
                    b2 = 12;
                }
                break;
            case 2102:
                if (str.equals("AW")) {
                    b2 = 13;
                }
                break;
            case 2103:
                if (str.equals("AX")) {
                    b2 = 14;
                }
                break;
            case 2105:
                if (str.equals("AZ")) {
                    b2 = 15;
                }
                break;
            case 2111:
                if (str.equals("BA")) {
                    b2 = 16;
                }
                break;
            case 2112:
                if (str.equals("BB")) {
                    b2 = 17;
                }
                break;
            case 2114:
                if (str.equals("BD")) {
                    b2 = 18;
                }
                break;
            case 2115:
                if (str.equals("BE")) {
                    b2 = 19;
                }
                break;
            case 2116:
                if (str.equals("BF")) {
                    b2 = 20;
                }
                break;
            case 2117:
                if (str.equals("BG")) {
                    b2 = 21;
                }
                break;
            case 2118:
                if (str.equals("BH")) {
                    b2 = 22;
                }
                break;
            case 2119:
                if (str.equals("BI")) {
                    b2 = 23;
                }
                break;
            case 2120:
                if (str.equals("BJ")) {
                    b2 = 24;
                }
                break;
            case 2122:
                if (str.equals("BL")) {
                    b2 = 25;
                }
                break;
            case 2123:
                if (str.equals("BM")) {
                    b2 = 26;
                }
                break;
            case 2124:
                if (str.equals("BN")) {
                    b2 = 27;
                }
                break;
            case 2125:
                if (str.equals("BO")) {
                    b2 = 28;
                }
                break;
            case 2127:
                if (str.equals("BQ")) {
                    b2 = 29;
                }
                break;
            case 2128:
                if (str.equals("BR")) {
                    b2 = 30;
                }
                break;
            case 2129:
                if (str.equals("BS")) {
                    b2 = 31;
                }
                break;
            case 2130:
                if (str.equals("BT")) {
                    b2 = 32;
                }
                break;
            case 2133:
                if (str.equals("BW")) {
                    b2 = 33;
                }
                break;
            case 2135:
                if (str.equals("BY")) {
                    b2 = 34;
                }
                break;
            case 2136:
                if (str.equals("BZ")) {
                    b2 = 35;
                }
                break;
            case 2142:
                if (str.equals("CA")) {
                    b2 = 36;
                }
                break;
            case 2145:
                if (str.equals("CD")) {
                    b2 = 37;
                }
                break;
            case 2147:
                if (str.equals("CF")) {
                    b2 = 38;
                }
                break;
            case 2148:
                if (str.equals("CG")) {
                    b2 = 39;
                }
                break;
            case 2149:
                if (str.equals("CH")) {
                    b2 = 40;
                }
                break;
            case 2150:
                if (str.equals("CI")) {
                    b2 = 41;
                }
                break;
            case 2152:
                if (str.equals("CK")) {
                    b2 = 42;
                }
                break;
            case 2153:
                if (str.equals("CL")) {
                    b2 = 43;
                }
                break;
            case 2154:
                if (str.equals("CM")) {
                    b2 = 44;
                }
                break;
            case 2155:
                if (str.equals("CN")) {
                    b2 = 45;
                }
                break;
            case 2156:
                if (str.equals("CO")) {
                    b2 = 46;
                }
                break;
            case 2159:
                if (str.equals("CR")) {
                    b2 = 47;
                }
                break;
            case 2162:
                if (str.equals("CU")) {
                    b2 = 48;
                }
                break;
            case 2163:
                if (str.equals("CV")) {
                    b2 = 49;
                }
                break;
            case 2164:
                if (str.equals("CW")) {
                    b2 = 50;
                }
                break;
            case 2165:
                if (str.equals("CX")) {
                    b2 = 51;
                }
                break;
            case 2166:
                if (str.equals("CY")) {
                    b2 = 52;
                }
                break;
            case 2167:
                if (str.equals("CZ")) {
                    b2 = 53;
                }
                break;
            case 2177:
                if (str.equals("DE")) {
                    b2 = 54;
                }
                break;
            case 2182:
                if (str.equals("DJ")) {
                    b2 = 55;
                }
                break;
            case 2183:
                if (str.equals("DK")) {
                    b2 = 56;
                }
                break;
            case 2185:
                if (str.equals("DM")) {
                    b2 = 57;
                }
                break;
            case 2187:
                if (str.equals("DO")) {
                    b2 = 58;
                }
                break;
            case 2198:
                if (str.equals("DZ")) {
                    b2 = 59;
                }
                break;
            case 2206:
                if (str.equals("EC")) {
                    b2 = 60;
                }
                break;
            case 2208:
                if (str.equals("EE")) {
                    b2 = 61;
                }
                break;
            case 2210:
                if (str.equals("EG")) {
                    b2 = 62;
                }
                break;
            case 2221:
                if (str.equals("ER")) {
                    b2 = Utf8.REPLACEMENT_BYTE;
                }
                break;
            case 2222:
                if (str.equals("ES")) {
                    b2 = 64;
                }
                break;
            case 2223:
                if (str.equals("ET")) {
                    b2 = 65;
                }
                break;
            case 2243:
                if (str.equals("FI")) {
                    b2 = 66;
                }
                break;
            case 2244:
                if (str.equals("FJ")) {
                    b2 = 67;
                }
                break;
            case 2245:
                if (str.equals("FK")) {
                    b2 = 68;
                }
                break;
            case 2247:
                if (str.equals("FM")) {
                    b2 = 69;
                }
                break;
            case 2249:
                if (str.equals("FO")) {
                    b2 = 70;
                }
                break;
            case 2252:
                if (str.equals("FR")) {
                    b2 = 71;
                }
                break;
            case 2266:
                if (str.equals("GA")) {
                    b2 = 72;
                }
                break;
            case 2267:
                if (str.equals("GB")) {
                    b2 = 73;
                }
                break;
            case 2269:
                if (str.equals("GD")) {
                    b2 = 74;
                }
                break;
            case 2270:
                if (str.equals("GE")) {
                    b2 = 75;
                }
                break;
            case 2271:
                if (str.equals("GF")) {
                    b2 = 76;
                }
                break;
            case 2272:
                if (str.equals("GG")) {
                    b2 = 77;
                }
                break;
            case 2273:
                if (str.equals("GH")) {
                    b2 = 78;
                }
                break;
            case 2274:
                if (str.equals("GI")) {
                    b2 = 79;
                }
                break;
            case 2277:
                if (str.equals("GL")) {
                    b2 = 80;
                }
                break;
            case 2278:
                if (str.equals("GM")) {
                    b2 = 81;
                }
                break;
            case 2279:
                if (str.equals("GN")) {
                    b2 = 82;
                }
                break;
            case 2281:
                if (str.equals("GP")) {
                    b2 = 83;
                }
                break;
            case 2282:
                if (str.equals("GQ")) {
                    b2 = 84;
                }
                break;
            case 2283:
                if (str.equals("GR")) {
                    b2 = 85;
                }
                break;
            case 2285:
                if (str.equals("GT")) {
                    b2 = 86;
                }
                break;
            case 2286:
                if (str.equals("GU")) {
                    b2 = 87;
                }
                break;
            case 2288:
                if (str.equals("GW")) {
                    b2 = 88;
                }
                break;
            case 2290:
                if (str.equals("GY")) {
                    b2 = 89;
                }
                break;
            case 2307:
                if (str.equals("HK")) {
                    b2 = 90;
                }
                break;
            case 2314:
                if (str.equals("HR")) {
                    b2 = 91;
                }
                break;
            case 2316:
                if (str.equals("HT")) {
                    b2 = 92;
                }
                break;
            case 2317:
                if (str.equals("HU")) {
                    b2 = 93;
                }
                break;
            case 2331:
                if (str.equals("ID")) {
                    b2 = 94;
                }
                break;
            case 2332:
                if (str.equals("IE")) {
                    b2 = 95;
                }
                break;
            case 2339:
                if (str.equals("IL")) {
                    b2 = 96;
                }
                break;
            case 2340:
                if (str.equals("IM")) {
                    b2 = 97;
                }
                break;
            case 2341:
                if (str.equals("IN")) {
                    b2 = 98;
                }
                break;
            case 2342:
                if (str.equals("IO")) {
                    b2 = 99;
                }
                break;
            case 2344:
                if (str.equals("IQ")) {
                    b2 = 100;
                }
                break;
            case 2345:
                if (str.equals("IR")) {
                    b2 = 101;
                }
                break;
            case 2346:
                if (str.equals("IS")) {
                    b2 = 102;
                }
                break;
            case 2347:
                if (str.equals("IT")) {
                    b2 = 103;
                }
                break;
            case 2363:
                if (str.equals("JE")) {
                    b2 = 104;
                }
                break;
            case 2371:
                if (str.equals("JM")) {
                    b2 = 105;
                }
                break;
            case 2373:
                if (str.equals("JO")) {
                    b2 = 106;
                }
                break;
            case 2374:
                if (str.equals("JP")) {
                    b2 = 107;
                }
                break;
            case 2394:
                if (str.equals("KE")) {
                    b2 = 108;
                }
                break;
            case 2396:
                if (str.equals(ExpandedProductParsedResult.KILOGRAM)) {
                    b2 = 109;
                }
                break;
            case 2397:
                if (str.equals("KH")) {
                    b2 = 110;
                }
                break;
            case 2398:
                if (str.equals("KI")) {
                    b2 = 111;
                }
                break;
            case 2402:
                if (str.equals("KM")) {
                    b2 = 112;
                }
                break;
            case 2403:
                if (str.equals("KN")) {
                    b2 = 113;
                }
                break;
            case 2407:
                if (str.equals("KR")) {
                    b2 = 114;
                }
                break;
            case 2412:
                if (str.equals("KW")) {
                    b2 = 115;
                }
                break;
            case 2414:
                if (str.equals("KY")) {
                    b2 = 116;
                }
                break;
            case 2415:
                if (str.equals("KZ")) {
                    b2 = 117;
                }
                break;
            case 2421:
                if (str.equals("LA")) {
                    b2 = 118;
                }
                break;
            case 2422:
                if (str.equals(ExpandedProductParsedResult.POUND)) {
                    b2 = 119;
                }
                break;
            case 2423:
                if (str.equals("LC")) {
                    b2 = 120;
                }
                break;
            case 2429:
                if (str.equals("LI")) {
                    b2 = 121;
                }
                break;
            case 2431:
                if (str.equals("LK")) {
                    b2 = 122;
                }
                break;
            case 2438:
                if (str.equals("LR")) {
                    b2 = 123;
                }
                break;
            case 2439:
                if (str.equals("LS")) {
                    b2 = 124;
                }
                break;
            case 2440:
                if (str.equals("LT")) {
                    b2 = 125;
                }
                break;
            case 2441:
                if (str.equals("LU")) {
                    b2 = 126;
                }
                break;
            case 2442:
                if (str.equals("LV")) {
                    b2 = 127;
                }
                break;
            case 2445:
                if (str.equals("LY")) {
                    b2 = 128;
                }
                break;
            case 2452:
                if (str.equals("MA")) {
                    b2 = 129;
                }
                break;
            case 2454:
                if (str.equals("MC")) {
                    b2 = 130;
                }
                break;
            case 2455:
                if (str.equals("MD")) {
                    b2 = 131;
                }
                break;
            case 2456:
                if (str.equals("ME")) {
                    b2 = 132;
                }
                break;
            case 2457:
                if (str.equals("MF")) {
                    b2 = 133;
                }
                break;
            case 2458:
                if (str.equals("MG")) {
                    b2 = 134;
                }
                break;
            case 2459:
                if (str.equals("MH")) {
                    b2 = 135;
                }
                break;
            case 2462:
                if (str.equals("MK")) {
                    b2 = 136;
                }
                break;
            case 2463:
                if (str.equals("ML")) {
                    b2 = 137;
                }
                break;
            case 2464:
                if (str.equals("MM")) {
                    b2 = 138;
                }
                break;
            case 2465:
                if (str.equals("MN")) {
                    b2 = 139;
                }
                break;
            case 2466:
                if (str.equals("MO")) {
                    b2 = 140;
                }
                break;
            case 2467:
                if (str.equals("MP")) {
                    b2 = 141;
                }
                break;
            case 2468:
                if (str.equals("MQ")) {
                    b2 = 142;
                }
                break;
            case 2469:
                if (str.equals("MR")) {
                    b2 = 143;
                }
                break;
            case 2470:
                if (str.equals("MS")) {
                    b2 = 144;
                }
                break;
            case 2471:
                if (str.equals("MT")) {
                    b2 = 145;
                }
                break;
            case 2472:
                if (str.equals("MU")) {
                    b2 = 146;
                }
                break;
            case 2473:
                if (str.equals("MV")) {
                    b2 = 147;
                }
                break;
            case 2474:
                if (str.equals("MW")) {
                    b2 = 148;
                }
                break;
            case 2475:
                if (str.equals("MX")) {
                    b2 = 149;
                }
                break;
            case 2476:
                if (str.equals("MY")) {
                    b2 = 150;
                }
                break;
            case 2477:
                if (str.equals("MZ")) {
                    b2 = 151;
                }
                break;
            case 2483:
                if (str.equals("NA")) {
                    b2 = 152;
                }
                break;
            case 2485:
                if (str.equals("NC")) {
                    b2 = 153;
                }
                break;
            case 2487:
                if (str.equals("NE")) {
                    b2 = 154;
                }
                break;
            case 2488:
                if (str.equals("NF")) {
                    b2 = 155;
                }
                break;
            case 2489:
                if (str.equals("NG")) {
                    b2 = 156;
                }
                break;
            case 2491:
                if (str.equals("NI")) {
                    b2 = 157;
                }
                break;
            case 2494:
                if (str.equals("NL")) {
                    b2 = 158;
                }
                break;
            case 2497:
                if (str.equals("NO")) {
                    b2 = 159;
                }
                break;
            case 2498:
                if (str.equals("NP")) {
                    b2 = 160;
                }
                break;
            case 2500:
                if (str.equals("NR")) {
                    b2 = 161;
                }
                break;
            case 2503:
                if (str.equals("NU")) {
                    b2 = 162;
                }
                break;
            case 2508:
                if (str.equals("NZ")) {
                    b2 = 163;
                }
                break;
            case 2526:
                if (str.equals("OM")) {
                    b2 = 164;
                }
                break;
            case 2545:
                if (str.equals("PA")) {
                    b2 = 165;
                }
                break;
            case 2549:
                if (str.equals("PE")) {
                    b2 = 166;
                }
                break;
            case 2550:
                if (str.equals("PF")) {
                    b2 = 167;
                }
                break;
            case 2551:
                if (str.equals("PG")) {
                    b2 = 168;
                }
                break;
            case 2552:
                if (str.equals("PH")) {
                    b2 = 169;
                }
                break;
            case 2555:
                if (str.equals("PK")) {
                    b2 = 170;
                }
                break;
            case 2556:
                if (str.equals("PL")) {
                    b2 = 171;
                }
                break;
            case 2557:
                if (str.equals("PM")) {
                    b2 = 172;
                }
                break;
            case 2562:
                if (str.equals("PR")) {
                    b2 = 173;
                }
                break;
            case 2563:
                if (str.equals("PS")) {
                    b2 = 174;
                }
                break;
            case 2564:
                if (str.equals("PT")) {
                    b2 = 175;
                }
                break;
            case 2567:
                if (str.equals("PW")) {
                    b2 = 176;
                }
                break;
            case 2569:
                if (str.equals("PY")) {
                    b2 = 177;
                }
                break;
            case 2576:
                if (str.equals("QA")) {
                    b2 = 178;
                }
                break;
            case 2611:
                if (str.equals("RE")) {
                    b2 = 179;
                }
                break;
            case 2621:
                if (str.equals("RO")) {
                    b2 = 180;
                }
                break;
            case 2625:
                if (str.equals("RS")) {
                    b2 = 181;
                }
                break;
            case 2627:
                if (str.equals("RU")) {
                    b2 = 182;
                }
                break;
            case 2629:
                if (str.equals("RW")) {
                    b2 = 183;
                }
                break;
            case 2638:
                if (str.equals("SA")) {
                    b2 = 184;
                }
                break;
            case 2639:
                if (str.equals("SB")) {
                    b2 = 185;
                }
                break;
            case 2640:
                if (str.equals("SC")) {
                    b2 = 186;
                }
                break;
            case 2641:
                if (str.equals("SD")) {
                    b2 = 187;
                }
                break;
            case 2642:
                if (str.equals("SE")) {
                    b2 = 188;
                }
                break;
            case 2644:
                if (str.equals("SG")) {
                    b2 = 189;
                }
                break;
            case 2645:
                if (str.equals("SH")) {
                    b2 = 190;
                }
                break;
            case 2646:
                if (str.equals("SI")) {
                    b2 = 191;
                }
                break;
            case 2647:
                if (str.equals("SJ")) {
                    b2 = 192;
                }
                break;
            case 2648:
                if (str.equals("SK")) {
                    b2 = 193;
                }
                break;
            case 2649:
                if (str.equals("SL")) {
                    b2 = 194;
                }
                break;
            case 2650:
                if (str.equals("SM")) {
                    b2 = 195;
                }
                break;
            case 2651:
                if (str.equals("SN")) {
                    b2 = 196;
                }
                break;
            case 2652:
                if (str.equals("SO")) {
                    b2 = 197;
                }
                break;
            case 2655:
                if (str.equals("SR")) {
                    b2 = 198;
                }
                break;
            case 2656:
                if (str.equals("SS")) {
                    b2 = 199;
                }
                break;
            case 2657:
                if (str.equals("ST")) {
                    b2 = 200;
                }
                break;
            case 2659:
                if (str.equals("SV")) {
                    b2 = 201;
                }
                break;
            case 2661:
                if (str.equals("SX")) {
                    b2 = 202;
                }
                break;
            case 2662:
                if (str.equals("SY")) {
                    b2 = 203;
                }
                break;
            case 2663:
                if (str.equals("SZ")) {
                    b2 = 204;
                }
                break;
            case 2671:
                if (str.equals("TC")) {
                    b2 = 205;
                }
                break;
            case 2672:
                if (str.equals("TD")) {
                    b2 = 206;
                }
                break;
            case 2675:
                if (str.equals("TG")) {
                    b2 = 207;
                }
                break;
            case 2676:
                if (str.equals("TH")) {
                    b2 = 208;
                }
                break;
            case 2678:
                if (str.equals("TJ")) {
                    b2 = 209;
                }
                break;
            case 2680:
                if (str.equals("TL")) {
                    b2 = 210;
                }
                break;
            case 2681:
                if (str.equals("TM")) {
                    b2 = 211;
                }
                break;
            case 2682:
                if (str.equals("TN")) {
                    b2 = 212;
                }
                break;
            case 2683:
                if (str.equals("TO")) {
                    b2 = 213;
                }
                break;
            case 2686:
                if (str.equals("TR")) {
                    b2 = 214;
                }
                break;
            case 2688:
                if (str.equals("TT")) {
                    b2 = 215;
                }
                break;
            case 2690:
                if (str.equals("TV")) {
                    b2 = 216;
                }
                break;
            case 2691:
                if (str.equals("TW")) {
                    b2 = 217;
                }
                break;
            case 2694:
                if (str.equals("TZ")) {
                    b2 = 218;
                }
                break;
            case 2700:
                if (str.equals("UA")) {
                    b2 = 219;
                }
                break;
            case 2706:
                if (str.equals("UG")) {
                    b2 = 220;
                }
                break;
            case 2718:
                if (str.equals("US")) {
                    b2 = 221;
                }
                break;
            case 2724:
                if (str.equals("UY")) {
                    b2 = 222;
                }
                break;
            case 2725:
                if (str.equals("UZ")) {
                    b2 = 223;
                }
                break;
            case 2731:
                if (str.equals("VA")) {
                    b2 = 224;
                }
                break;
            case 2733:
                if (str.equals("VC")) {
                    b2 = 225;
                }
                break;
            case 2735:
                if (str.equals("VE")) {
                    b2 = 226;
                }
                break;
            case 2737:
                if (str.equals("VG")) {
                    b2 = 227;
                }
                break;
            case 2739:
                if (str.equals("VI")) {
                    b2 = 228;
                }
                break;
            case 2744:
                if (str.equals("VN")) {
                    b2 = 229;
                }
                break;
            case 2751:
                if (str.equals("VU")) {
                    b2 = 230;
                }
                break;
            case 2767:
                if (str.equals("WF")) {
                    b2 = 231;
                }
                break;
            case 2780:
                if (str.equals("WS")) {
                    b2 = 232;
                }
                break;
            case 2803:
                if (str.equals("XK")) {
                    b2 = 233;
                }
                break;
            case 2828:
                if (str.equals("YE")) {
                    b2 = 234;
                }
                break;
            case 2843:
                if (str.equals("YT")) {
                    b2 = 235;
                }
                break;
            case 2855:
                if (str.equals("ZA")) {
                    b2 = 236;
                }
                break;
            case 2867:
                if (str.equals("ZM")) {
                    b2 = 237;
                }
                break;
            case 2877:
                if (str.equals("ZW")) {
                    b2 = 238;
                }
                break;
        }
        switch (b2) {
            case 0:
            case 4:
            case 17:
            case 29:
            case 50:
            case Token.IN /* 57 */:
            case Token.ASSIGN_EXP /* 113 */:
            case Token.COLON /* 116 */:
            case 202:
            case 225:
                return new int[]{1, 2, 0, 0, 2, 2};
            case 1:
                return new int[]{1, 4, 2, 3, 4, 1};
            case 2:
            case 204:
                return new int[]{4, 4, 3, 4, 2, 2};
            case 3:
            case Token.SETELEM /* 41 */:
                return new int[]{2, 4, 3, 4, 2, 2};
            case 5:
                return new int[]{1, 1, 1, 2, 2, 2};
            case 6:
            case Token.GET /* 165 */:
                return new int[]{2, 3, 2, 3, 2, 2};
            case 7:
                return new int[]{3, 4, 4, 3, 2, 2};
            case 8:
            case Token.ENUM_INIT_KEYS /* 63 */:
            case Token.XMLEND /* 162 */:
            case Token.QUESTION_DOT /* 186 */:
            case 190:
                return new int[]{4, 2, 2, 2, 2, 2};
            case 9:
                return new int[]{2, 2, 2, 2, 1, 2};
            case 10:
                return new int[]{2, 2, 3, 3, 2, 2};
            case 11:
            case Token.SETVAR /* 61 */:
            case Token.RB /* 93 */:
            case 102:
            case 127:
            case Token.TARGET /* 145 */:
            case 188:
                return new int[]{0, 0, 0, 0, 0, 2};
            case 12:
                return new int[]{0, 3, 1, 1, 3, 0};
            case 13:
                return new int[]{2, 2, 3, 4, 2, 2};
            case 14:
            case Token.SHEQ /* 51 */:
            case Token.DOT /* 121 */:
            case Token.LABEL /* 144 */:
            case Token.LETEXPR /* 172 */:
            case 195:
            case 224:
                return new int[]{0, 2, 2, 2, 2, 2};
            case 15:
            case Token.THROW /* 55 */:
            case 128:
            case 194:
                return new int[]{4, 2, 3, 3, 2, 2};
            case 16:
            case Token.ASSIGN_RSH /* 106 */:
            case 214:
                return new int[]{1, 1, 1, 1, 2, 2};
            case 18:
                return new int[]{2, 1, 3, 2, 4, 2};
            case 19:
                return new int[]{0, 0, 1, 0, 1, 2};
            case 20:
            case Token.LAST_TOKEN /* 187 */:
            case 203:
            case 206:
                return new int[]{4, 3, 4, 4, 2, 2};
            case 21:
            case Token.COMMENT /* 175 */:
            case 191:
                return new int[]{0, 0, 0, 0, 1, 2};
            case 22:
                return new int[]{1, 3, 1, 3, 4, 2};
            case 23:
            case Token.ESCXMLTEXT /* 84 */:
            case Token.LB /* 92 */:
            case Token.SETELEM_OP /* 154 */:
            case 226:
            case 234:
                return new int[]{4, 4, 4, 4, 2, 2};
            case 24:
                return new int[]{4, 4, 2, 3, 2, 2};
            case 25:
            case Token.EMPTY /* 141 */:
            case Token.METHOD /* 177 */:
                return new int[]{1, 2, 2, 2, 2, 2};
            case 26:
                return new int[]{0, 2, 0, 0, 2, 2};
            case 27:
                return new int[]{3, 2, 0, 0, 2, 2};
            case 28:
                return new int[]{1, 2, 4, 4, 2, 2};
            case 30:
                return new int[]{1, 1, 1, 1, 2, 4};
            case 31:
                return new int[]{3, 2, 1, 1, 2, 2};
            case 32:
                return new int[]{3, 1, 2, 2, 3, 2};
            case 33:
                return new int[]{3, 2, 1, 0, 2, 2};
            case Token.GETPROPNOWARN /* 34 */:
                return new int[]{1, 2, 3, 3, 2, 2};
            case 35:
            case Token.SETELEM_SUPER /* 42 */:
                return new int[]{2, 2, 2, 1, 2, 2};
            case 36:
            case 219:
                return new int[]{0, 2, 1, 2, 3, 3};
            case Token.SETPROP /* 37 */:
            case Token.CATCH /* 137 */:
                return new int[]{3, 3, 2, 2, 2, 2};
            case Token.SETPROP_SUPER /* 38 */:
                return new int[]{4, 2, 4, 2, 2, 2};
            case Token.GETELEM /* 39 */:
            case Token.CATCH_SCOPE /* 62 */:
            case Token.CONTINUE /* 134 */:
                return new int[]{3, 4, 3, 3, 2, 2};
            case 40:
                return new int[]{0, 1, 0, 0, 0, 2};
            case Token.CALL /* 43 */:
            case 208:
                return new int[]{0, 1, 2, 2, 2, 2};
            case Token.NAME /* 44 */:
            case Token.BLOCK /* 143 */:
                return new int[]{4, 3, 3, 4, 2, 2};
            case Token.NUMBER /* 45 */:
                return new int[]{2, 0, 1, 1, 3, 1};
            case Token.STRING /* 46 */:
                return new int[]{2, 3, 3, 2, 2, 2};
            case Token.NULL /* 47 */:
            case Token.DOTDOT /* 157 */:
                return new int[]{2, 4, 4, 4, 2, 2};
            case 48:
            case Token.ASSIGN_DIV /* 111 */:
            case Token.XMLATTR /* 161 */:
            case 210:
                return new int[]{4, 2, 4, 4, 2, 2};
            case Token.FALSE /* 49 */:
                return new int[]{2, 3, 0, 1, 2, 2};
            case Token.SHNE /* 52 */:
                return new int[]{1, 0, 1, 0, 0, 2};
            case Token.REGEXP /* 53 */:
                return new int[]{0, 0, 2, 0, 1, 2};
            case Token.BINDNAME /* 54 */:
                return new int[]{0, 1, 4, 2, 2, 1};
            case Token.RETHROW /* 56 */:
                return new int[]{0, 0, 2, 0, 0, 2};
            case Token.INSTANCEOF /* 58 */:
            case Token.EXPORT /* 123 */:
                return new int[]{3, 4, 4, 4, 2, 2};
            case Token.LOCAL_LOAD /* 59 */:
            case 209:
                return new int[]{3, 3, 4, 4, 2, 2};
            case 60:
                return new int[]{1, 3, 2, 1, 2, 2};
            case 64:
                return new int[]{0, 0, 0, 0, 1, 0};
            case Token.ENUM_INIT_ARRAY /* 65 */:
                return new int[]{4, 3, 4, 4, 4, 2};
            case Token.ENUM_INIT_VALUES_IN_ORDER /* 66 */:
                return new int[]{0, 0, 0, 1, 0, 2};
            case Token.ENUM_NEXT /* 67 */:
                return new int[]{3, 2, 2, 3, 2, 2};
            case Token.ENUM_ID /* 68 */:
            case Token.LOCAL_BLOCK /* 155 */:
            case 192:
                return new int[]{3, 2, 2, 2, 2, 2};
            case Token.THISFN /* 69 */:
                return new int[]{4, 2, 4, 0, 2, 2};
            case 70:
                return new int[]{0, 2, 2, 0, 2, 2};
            case Token.ARRAYLIT /* 71 */:
                return new int[]{1, 1, 1, 1, 0, 2};
            case Token.OBJECTLIT /* 72 */:
                return new int[]{3, 4, 0, 0, 2, 2};
            case Token.GET_REF /* 73 */:
                return new int[]{1, 1, 3, 2, 2, 2};
            case Token.SET_REF /* 74 */:
                return new int[]{2, 2, 0, 0, 2, 2};
            case Token.DEL_REF /* 75 */:
                return new int[]{1, 1, 0, 2, 2, 2};
            case Token.REF_CALL /* 76 */:
                return new int[]{3, 2, 3, 3, 2, 2};
            case Token.REF_SPECIAL /* 77 */:
                return new int[]{0, 2, 1, 1, 2, 2};
            case Token.YIELD /* 78 */:
                return new int[]{3, 3, 3, 2, 2, 2};
            case Token.SUPER /* 79 */:
            case Token.RP /* 97 */:
            case Token.ASSIGN_LOGICAL_AND /* 104 */:
                return new int[]{0, 2, 0, 1, 2, 2};
            case Token.STRICT_SETNAME /* 80 */:
            case 130:
                return new int[]{1, 2, 2, 0, 2, 2};
            case Token.EXP /* 81 */:
            case 199:
                return new int[]{4, 3, 2, 4, 2, 2};
            case Token.DEFAULTNAMESPACE /* 82 */:
                return new int[]{3, 4, 4, 2, 2, 2};
            case Token.ESCXMLATTR /* 83 */:
                return new int[]{2, 1, 1, 3, 2, 2};
            case Token.REF_MEMBER /* 85 */:
                return new int[]{1, 0, 0, 0, 1, 2};
            case Token.REF_NS_MEMBER /* 86 */:
                return new int[]{2, 1, 2, 1, 2, 2};
            case Token.REF_NAME /* 87 */:
                return new int[]{2, 2, 4, 3, 3, 2};
            case Token.REF_NS_NAME /* 88 */:
                return new int[]{4, 4, 1, 2, 2, 2};
            case 89:
                return new int[]{3, 1, 1, 3, 2, 2};
            case 90:
                return new int[]{0, 1, 0, 1, 1, 0};
            case Token.SEMI /* 91 */:
            case Token.HOOK /* 115 */:
                return new int[]{1, 0, 0, 0, 0, 2};
            case Token.LC /* 94 */:
                return new int[]{3, 1, 3, 3, 2, 4};
            case Token.RC /* 95 */:
                return new int[]{1, 1, 1, 1, 1, 2};
            case Token.LP /* 96 */:
                return new int[]{1, 2, 2, 3, 4, 2};
            case Token.COMMA /* 98 */:
                return new int[]{1, 1, 3, 2, 2, 3};
            case 99:
                return new int[]{3, 2, 2, 0, 2, 2};
            case 100:
                return new int[]{3, 2, 3, 2, 2, 2};
            case 101:
                return new int[]{4, 2, 3, 3, 4, 3};
            case 103:
                return new int[]{0, 1, 1, 2, 1, 2};
            case Token.ASSIGN_LSH /* 105 */:
                return new int[]{2, 4, 3, 1, 2, 2};
            case Token.ASSIGN_URSH /* 107 */:
                return new int[]{0, 3, 2, 3, 4, 2};
            case Token.ASSIGN_ADD /* 108 */:
                return new int[]{3, 2, 1, 1, 1, 2};
            case Token.ASSIGN_SUB /* 109 */:
                return new int[]{2, 1, 1, 2, 2, 2};
            case 110:
                return new int[]{1, 0, 4, 2, 2, 2};
            case Token.ASSIGN_MOD /* 112 */:
            case 230:
                return new int[]{4, 3, 3, 2, 2, 2};
            case 114:
                return new int[]{0, 2, 2, 4, 4, 4};
            case Token.OR /* 117 */:
                return new int[]{2, 1, 2, 2, 3, 2};
            case Token.AND /* 118 */:
                return new int[]{1, 2, 1, 3, 2, 2};
            case Token.INC /* 119 */:
                return new int[]{3, 1, 1, 2, 2, 2};
            case 120:
                return new int[]{2, 2, 1, 1, 2, 2};
            case Token.FUNCTION /* 122 */:
            case Token.FINALLY /* 138 */:
                return new int[]{3, 2, 3, 3, 4, 2};
            case Token.IMPORT /* 124 */:
            case Token.CONST /* 168 */:
                return new int[]{4, 3, 3, 3, 2, 2};
            case Token.IF /* 125 */:
                return new int[]{0, 1, 0, 1, 0, 2};
            case 126:
                return new int[]{4, 0, 3, 2, 1, 3};
            case Token.DEFAULT /* 129 */:
                return new int[]{3, 3, 1, 1, 2, 2};
            case Token.DO /* 131 */:
                return new int[]{1, 0, 0, 0, 2, 2};
            case Token.FOR /* 132 */:
                return new int[]{2, 0, 0, 1, 3, 2};
            case Token.BREAK /* 133 */:
                return new int[]{1, 2, 2, 3, 2, 2};
            case Token.VAR /* 135 */:
            case 211:
            case 216:
            case 231:
                return new int[]{4, 2, 2, 4, 2, 2};
            case Token.WITH /* 136 */:
                return new int[]{1, 0, 0, 1, 3, 2};
            case Token.VOID /* 139 */:
                return new int[]{2, 0, 2, 2, 2, 2};
            case 140:
                return new int[]{0, 2, 4, 4, 3, 1};
            case Token.COMPUTED_PROPERTY /* 142 */:
                return new int[]{2, 1, 2, 3, 2, 2};
            case Token.LOOP /* 146 */:
                return new int[]{3, 1, 0, 2, 2, 2};
            case Token.EXPR_VOID /* 147 */:
                return new int[]{3, 2, 1, 3, 4, 2};
            case Token.EXPR_RESULT /* 148 */:
                return new int[]{3, 2, 2, 1, 2, 2};
            case Token.JSR /* 149 */:
                return new int[]{2, 4, 4, 4, 3, 2};
            case 150:
                return new int[]{1, 0, 4, 1, 1, 0};
            case Token.TYPEOFNAME /* 151 */:
            case 232:
                return new int[]{3, 1, 2, 2, 2, 2};
            case Token.USE_STACK /* 152 */:
                return new int[]{3, 4, 3, 2, 2, 2};
            case Token.SETPROP_OP /* 153 */:
            case 235:
                return new int[]{2, 3, 3, 4, 2, 2};
            case Token.SET_REF_OP /* 156 */:
                return new int[]{3, 4, 2, 1, 2, 2};
            case Token.COLONCOLON /* 158 */:
                return new int[]{2, 1, 4, 3, 0, 4};
            case Token.XML /* 159 */:
                return new int[]{0, 0, 3, 0, 0, 2};
            case 160:
                return new int[]{2, 2, 4, 3, 2, 2};
            case Token.TO_OBJECT /* 163 */:
                return new int[]{0, 0, 1, 2, 4, 2};
            case Token.TO_DOUBLE /* 164 */:
                return new int[]{2, 3, 1, 2, 4, 2};
            case Token.SET /* 166 */:
                return new int[]{1, 2, 4, 4, 3, 2};
            case Token.LET /* 167 */:
                return new int[]{2, 2, 3, 1, 2, 2};
            case Token.SETCONST /* 169 */:
                return new int[]{2, 1, 2, 3, 2, 1};
            case 170:
                return new int[]{3, 3, 3, 3, 2, 2};
            case Token.ARRAYCOMP /* 171 */:
                return new int[]{1, 0, 2, 2, 4, 4};
            case Token.WITHEXPR /* 173 */:
                return new int[]{2, 0, 2, 1, 2, 0};
            case Token.DEBUGGER /* 174 */:
                return new int[]{3, 4, 1, 3, 2, 2};
            case Token.GENEXPR /* 176 */:
                return new int[]{2, 2, 4, 1, 2, 2};
            case Token.ARROW /* 178 */:
                return new int[]{1, 4, 4, 4, 4, 2};
            case Token.YIELD_STAR /* 179 */:
                return new int[]{0, 3, 2, 3, 1, 2};
            case 180:
                return new int[]{0, 0, 1, 1, 3, 2};
            case Token.TEMPLATE_CHARS /* 181 */:
                return new int[]{1, 0, 0, 1, 2, 2};
            case Token.TEMPLATE_LITERAL_SUBST /* 182 */:
                return new int[]{1, 0, 0, 1, 3, 3};
            case Token.TAGGED_TEMPLATE_LITERAL /* 183 */:
                return new int[]{3, 3, 2, 0, 2, 2};
            case Token.DOTDOTDOT /* 184 */:
                return new int[]{3, 1, 1, 2, 2, 0};
            case Token.NULLISH_COALESCING /* 185 */:
            case 238:
                return new int[]{4, 2, 4, 3, 2, 2};
            case 189:
                return new int[]{2, 3, 3, 3, 1, 1};
            case 193:
                return new int[]{0, 1, 1, 1, 2, 2};
            case 196:
                return new int[]{4, 4, 3, 2, 2, 2};
            case 197:
                return new int[]{2, 2, 3, 4, 4, 2};
            case 198:
                return new int[]{2, 4, 4, 1, 2, 2};
            case 200:
                return new int[]{2, 2, 1, 2, 2, 2};
            case 201:
                return new int[]{2, 3, 2, 1, 2, 2};
            case 205:
                return new int[]{3, 2, 1, 2, 2, 2};
            case 207:
                return new int[]{3, 4, 1, 0, 2, 2};
            case 212:
                return new int[]{3, 1, 1, 1, 2, 2};
            case 213:
                return new int[]{3, 2, 4, 3, 2, 2};
            case 215:
                return new int[]{2, 4, 1, 0, 2, 2};
            case 217:
                return new int[]{0, 0, 0, 0, 0, 0};
            case 218:
                return new int[]{3, 4, 2, 1, 3, 2};
            case 220:
                return new int[]{3, 3, 2, 3, 4, 2};
            case 221:
                return new int[]{2, 2, 4, 1, 3, 1};
            case 222:
                return new int[]{2, 1, 1, 2, 1, 2};
            case 223:
                return new int[]{1, 2, 3, 4, 3, 2};
            case 227:
                return new int[]{2, 2, 1, 1, 2, 4};
            case 228:
                return new int[]{0, 2, 1, 2, 2, 2};
            case 229:
                return new int[]{0, 0, 1, 2, 2, 2};
            case 233:
                return new int[]{1, 2, 1, 1, 2, 2};
            case 236:
                return new int[]{2, 4, 2, 1, 1, 2};
            case 237:
                return new int[]{4, 4, 4, 3, 2, 2};
            default:
                return new int[]{2, 2, 2, 2, 2, 2};
        }
    }

    public static long m(String str, int i) {
        int[] iArrK = k(gg4.d(str));
        if (i != 2) {
            if (i == 3) {
                return ((Long) s.get(iArrK[1])).longValue();
            }
            if (i == 4) {
                return ((Long) t.get(iArrK[2])).longValue();
            }
            if (i == 5) {
                return ((Long) u.get(iArrK[3])).longValue();
            }
            if (i != 7) {
                if (i == 9) {
                    return ((Long) w.get(iArrK[5])).longValue();
                }
                if (i != 10) {
                    return 1000000L;
                }
                return ((Long) v.get(iArrK[4])).longValue();
            }
        }
        return ((Long) r.get(iArrK[0])).longValue();
    }

    public static synchronized se0 n(Context context) {
        try {
            if (x == null) {
                x = new b(context).a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return x;
    }

    public static boolean o(ja0 ja0Var, boolean z) {
        return z && !ja0Var.d(8);
    }

    @Override // defpackage.hs4
    public void b(aa0 aa0Var, ja0 ja0Var, boolean z) {
    }

    @Override // defpackage.qg
    public void c(Handler handler, qg.a aVar) {
        gg3.q(handler);
        gg3.q(aVar);
        this.c.b(handler, aVar);
    }

    @Override // defpackage.hs4
    public synchronized void d(aa0 aa0Var, ja0 ja0Var, boolean z, int i) {
        if (o(ja0Var, z)) {
            this.i += (long) i;
        }
    }

    @Override // defpackage.qg
    public hs4 e() {
        return this;
    }

    @Override // defpackage.qg
    public void f(qg.a aVar) {
        this.c.d(aVar);
    }

    @Override // defpackage.qg
    public synchronized long g() {
        return this.l;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0055 A[Catch: all -> 0x0072, TRY_ENTER, TryCatch #1 {all -> 0x0072, blocks: (B:3:0x0001, B:7:0x0009, B:11:0x0011, B:13:0x002e, B:23:0x0060, B:22:0x0055), top: B:38:0x0001 }] */
    @Override // defpackage.hs4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void h(defpackage.aa0 r11, defpackage.ja0 r12, boolean r13) throws java.lang.Throwable {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r11 = o(r12, r13)     // Catch: java.lang.Throwable -> L72
            if (r11 != 0) goto L9
            monitor-exit(r10)
            return
        L9:
            int r11 = r10.g     // Catch: java.lang.Throwable -> L72
            r12 = 1
            if (r11 <= 0) goto L10
            r11 = r12
            goto L11
        L10:
            r11 = 0
        L11:
            defpackage.gg3.v(r11)     // Catch: java.lang.Throwable -> L72
            zu r11 = r10.d     // Catch: java.lang.Throwable -> L72
            long r0 = r11.e()     // Catch: java.lang.Throwable -> L72
            long r2 = r10.h     // Catch: java.lang.Throwable -> L72
            long r2 = r0 - r2
            int r5 = (int) r2     // Catch: java.lang.Throwable -> L72
            long r2 = r10.j     // Catch: java.lang.Throwable -> L72
            long r6 = (long) r5     // Catch: java.lang.Throwable -> L72
            long r2 = r2 + r6
            r10.j = r2     // Catch: java.lang.Throwable -> L72
            long r2 = r10.k     // Catch: java.lang.Throwable -> L72
            long r6 = r10.i     // Catch: java.lang.Throwable -> L72
            long r2 = r2 + r6
            r10.k = r2     // Catch: java.lang.Throwable -> L72
            if (r5 <= 0) goto L75
            float r11 = (float) r6     // Catch: java.lang.Throwable -> L72
            r13 = 1174011904(0x45fa0000, float:8000.0)
            float r11 = r11 * r13
            float r13 = (float) r5     // Catch: java.lang.Throwable -> L72
            float r11 = r11 / r13
            m94 r13 = r10.f     // Catch: java.lang.Throwable -> L72
            double r2 = (double) r6     // Catch: java.lang.Throwable -> L72
            double r2 = java.lang.Math.sqrt(r2)     // Catch: java.lang.Throwable -> L72
            int r2 = (int) r2     // Catch: java.lang.Throwable -> L72
            r13.c(r2, r11)     // Catch: java.lang.Throwable -> L72
            long r2 = r10.j     // Catch: java.lang.Throwable -> L72
            r6 = 2000(0x7d0, double:9.88E-321)
            int r11 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r11 >= 0) goto L55
            long r2 = r10.k     // Catch: java.lang.Throwable -> L51
            r6 = 524288(0x80000, double:2.590327E-318)
            int r11 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r11 < 0) goto L60
            goto L55
        L51:
            r0 = move-exception
            r11 = r0
            r4 = r10
            goto L7d
        L55:
            m94 r11 = r10.f     // Catch: java.lang.Throwable -> L72
            r13 = 1056964608(0x3f000000, float:0.5)
            float r11 = r11.f(r13)     // Catch: java.lang.Throwable -> L72
            long r2 = (long) r11     // Catch: java.lang.Throwable -> L72
            r10.l = r2     // Catch: java.lang.Throwable -> L72
        L60:
            long r6 = r10.i     // Catch: java.lang.Throwable -> L72
            long r8 = r10.l     // Catch: java.lang.Throwable -> L72
            r4 = r10
            r4.p(r5, r6, r8)     // Catch: java.lang.Throwable -> L6f
            r4.h = r0     // Catch: java.lang.Throwable -> L6f
            r10 = 0
            r4.i = r10     // Catch: java.lang.Throwable -> L6f
            goto L76
        L6f:
            r0 = move-exception
        L70:
            r11 = r0
            goto L7d
        L72:
            r0 = move-exception
            r4 = r10
            goto L70
        L75:
            r4 = r10
        L76:
            int r10 = r4.g     // Catch: java.lang.Throwable -> L6f
            int r10 = r10 - r12
            r4.g = r10     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r4)
            return
        L7d:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L6f
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.se0.h(aa0, ja0, boolean):void");
    }

    @Override // defpackage.hs4
    public synchronized void i(aa0 aa0Var, ja0 ja0Var, boolean z) {
        try {
            if (o(ja0Var, z)) {
                if (this.g == 0) {
                    this.h = this.d.e();
                }
                this.g++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final long l(int i) {
        Long lValueOf = (Long) this.b.get(Integer.valueOf(i));
        if (lValueOf == null) {
            lValueOf = (Long) this.b.get(0);
        } else if (lValueOf.longValue() == -9223372036854775807L) {
            lValueOf = Long.valueOf(m(this.q, i));
        }
        if (lValueOf == null) {
            lValueOf = 1000000L;
        }
        return lValueOf.longValue();
    }

    public final void p(int i, long j, long j2) {
        if (i == 0 && j == 0 && j2 == this.m) {
            return;
        }
        this.m = j2;
        this.c.c(i, j, j2);
    }

    public final synchronized void q(int i) throws Throwable {
        se0 se0Var;
        Throwable th;
        try {
            try {
                int i2 = this.n;
                if (i2 != 0) {
                    try {
                        if (!this.e) {
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        se0Var = this;
                    }
                }
                if (this.o) {
                    i = this.p;
                }
                if (i2 != i || this.q == null) {
                    this.n = i;
                    if (i == 1 || i == 0 || i == 8) {
                        return;
                    }
                    if (this.q == null) {
                        this.q = fy4.c0(this.a);
                    }
                    this.l = l(i);
                    long jE = this.d.e();
                    p(this.g > 0 ? (int) (jE - this.h) : 0, this.i, this.l);
                    this.h = jE;
                    this.i = 0L;
                    this.k = 0L;
                    this.j = 0L;
                    this.f.g();
                    return;
                }
                return;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            se0Var = this;
        }
        th = th;
        throw th;
    }
}
