package org.mozilla.javascript;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
final class NativeMath extends ScriptableObject {
    private static final Double Double32 = Double.valueOf(32.0d);
    private static final double LOG2E = 1.4426950408889634d;
    private static final String MATH_TAG = "Math";
    private static final long serialVersionUID = -8838847185801131569L;

    private NativeMath() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object abs(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number = ScriptRuntime.toNumber(objArr, 0);
        if (number == 0.0d) {
            number = 0.0d;
        } else if (number < 0.0d) {
            number = -number;
        }
        return ScriptRuntime.wrapNumber(number);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object acos(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number = ScriptRuntime.toNumber(objArr, 0);
        return ScriptRuntime.wrapNumber((Double.isNaN(number) || -1.0d > number || number > 1.0d) ? Double.NaN : Math.acos(number));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object acosh(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number = ScriptRuntime.toNumber(objArr, 0);
        return !Double.isNaN(number) ? Double.valueOf(Math.log(number + Math.sqrt((number * number) - 1.0d))) : ScriptRuntime.NaNobj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object asin(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number = ScriptRuntime.toNumber(objArr, 0);
        return ScriptRuntime.wrapNumber((Double.isNaN(number) || -1.0d > number || number > 1.0d) ? Double.NaN : Math.asin(number));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object asinh(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number = ScriptRuntime.toNumber(objArr, 0);
        return Double.isInfinite(number) ? Double.valueOf(number) : !Double.isNaN(number) ? number == 0.0d ? 1.0d / number > 0.0d ? ScriptRuntime.zeroObj : ScriptRuntime.negativeZeroObj : Double.valueOf(Math.log(number + Math.sqrt((number * number) + 1.0d))) : ScriptRuntime.NaNobj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object atan(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.wrapNumber(Math.atan(ScriptRuntime.toNumber(objArr, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object atan2(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.wrapNumber(Math.atan2(ScriptRuntime.toNumber(objArr, 0), ScriptRuntime.toNumber(objArr, 1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object atanh(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number = ScriptRuntime.toNumber(objArr, 0);
        return (Double.isNaN(number) || -1.0d > number || number > 1.0d) ? ScriptRuntime.NaNobj : number == 0.0d ? 1.0d / number > 0.0d ? ScriptRuntime.zeroObj : ScriptRuntime.negativeZeroObj : Double.valueOf(Math.log((number + 1.0d) / (1.0d - number)) * 0.5d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object cbrt(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.wrapNumber(Math.cbrt(ScriptRuntime.toNumber(objArr, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object ceil(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.wrapNumber(Math.ceil(ScriptRuntime.toNumber(objArr, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object clz32(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        int i = 0;
        double number = ScriptRuntime.toNumber(objArr, 0);
        if (number == 0.0d || Double.isNaN(number) || Double.isInfinite(number)) {
            return Double32;
        }
        long uint32 = ScriptRuntime.toUint32(number);
        if (uint32 == 0) {
            return Double32;
        }
        if (((-65536) & uint32) != 0) {
            i = 16;
            uint32 >>>= 16;
        }
        if ((65280 & uint32) != 0) {
            i += 8;
            uint32 >>>= 8;
        }
        if ((240 & uint32) != 0) {
            i += 4;
            uint32 >>>= 4;
        }
        if ((12 & uint32) != 0) {
            i += 2;
            uint32 >>>= 2;
        }
        if ((2 & uint32) != 0) {
            i++;
            uint32 >>>= 1;
        }
        if ((uint32 & 1) != 0) {
            i++;
        }
        return Double.valueOf(32 - i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object cos(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number = ScriptRuntime.toNumber(objArr, 0);
        return ScriptRuntime.wrapNumber(Double.isInfinite(number) ? Double.NaN : Math.cos(number));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object cosh(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.wrapNumber(Math.cosh(ScriptRuntime.toNumber(objArr, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object exp(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number = ScriptRuntime.toNumber(objArr, 0);
        if (number != Double.POSITIVE_INFINITY) {
            number = number == Double.NEGATIVE_INFINITY ? 0.0d : Math.exp(number);
        }
        return ScriptRuntime.wrapNumber(number);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object expm1(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.wrapNumber(Math.expm1(ScriptRuntime.toNumber(objArr, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object floor(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.wrapNumber(Math.floor(ScriptRuntime.toNumber(objArr, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object fround(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.wrapNumber((float) ScriptRuntime.toNumber(objArr, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object hypot(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double d = 0.0d;
        if (objArr == null) {
            return Double.valueOf(0.0d);
        }
        boolean z = false;
        boolean z2 = false;
        for (Object obj : objArr) {
            double number = ScriptRuntime.toNumber(obj);
            if (Double.isNaN(number)) {
                z2 = true;
            } else if (Double.isInfinite(number)) {
                z = true;
            } else {
                d += number * number;
            }
        }
        return z ? Double.valueOf(Double.POSITIVE_INFINITY) : z2 ? Double.valueOf(Double.NaN) : Double.valueOf(Math.sqrt(d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object imul(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        return ScriptRuntime.wrapNumber(ScriptRuntime.toInt32(objArr, 0) * ScriptRuntime.toInt32(objArr, 1));
    }

    public static void init(Scriptable scriptable, boolean z) {
        NativeMath nativeMath = new NativeMath();
        nativeMath.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeMath.setParentScope(scriptable);
        nativeMath.defineProperty("toSource", MATH_TAG, 7);
        nativeMath.defineProperty(scriptable, "abs", 1, new Callable() { // from class: org.mozilla.javascript.m
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.abs(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "acos", 1, new Callable() { // from class: org.mozilla.javascript.o
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.acos(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "acosh", 1, new Callable() { // from class: org.mozilla.javascript.a0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.acosh(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "asin", 1, new Callable() { // from class: org.mozilla.javascript.g0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.asin(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "asinh", 1, new Callable() { // from class: org.mozilla.javascript.h0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.asinh(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "atan", 1, new Callable() { // from class: org.mozilla.javascript.j0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.atan(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "atanh", 1, new Callable() { // from class: org.mozilla.javascript.k0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.atanh(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "atan2", 2, new Callable() { // from class: org.mozilla.javascript.l0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.atan2(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "cbrt", 1, new Callable() { // from class: org.mozilla.javascript.m0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.cbrt(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "ceil", 1, new Callable() { // from class: org.mozilla.javascript.n0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.ceil(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "clz32", 1, new Callable() { // from class: org.mozilla.javascript.x
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.clz32(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "cos", 1, new Callable() { // from class: org.mozilla.javascript.i0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.cos(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "cosh", 1, new Callable() { // from class: org.mozilla.javascript.o0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.cosh(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "exp", 1, new Callable() { // from class: org.mozilla.javascript.p0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.exp(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "expm1", 1, new Callable() { // from class: org.mozilla.javascript.q0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.expm1(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "floor", 1, new Callable() { // from class: org.mozilla.javascript.r0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.floor(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "fround", 1, new Callable() { // from class: org.mozilla.javascript.s0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.fround(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "hypot", 2, new Callable() { // from class: org.mozilla.javascript.t0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.hypot(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "imul", 2, new Callable() { // from class: org.mozilla.javascript.u0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.imul(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "log", 1, new Callable() { // from class: org.mozilla.javascript.n
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.log(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "log1p", 1, new Callable() { // from class: org.mozilla.javascript.p
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.log1p(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "log10", 1, new Callable() { // from class: org.mozilla.javascript.q
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.log10(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "log2", 1, new Callable() { // from class: org.mozilla.javascript.r
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.log2(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "max", 2, new Callable() { // from class: org.mozilla.javascript.s
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.max(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "min", 2, new Callable() { // from class: org.mozilla.javascript.t
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.min(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "pow", 2, new Callable() { // from class: org.mozilla.javascript.u
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.pow(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "random", 0, new Callable() { // from class: org.mozilla.javascript.v
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.random(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "round", 1, new Callable() { // from class: org.mozilla.javascript.w
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.round(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "sign", 1, new Callable() { // from class: org.mozilla.javascript.y
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.sign(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "sin", 1, new Callable() { // from class: org.mozilla.javascript.z
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.sin(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "sinh", 1, new Callable() { // from class: org.mozilla.javascript.b0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.sinh(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "sqrt", 1, new Callable() { // from class: org.mozilla.javascript.c0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.sqrt(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "tan", 1, new Callable() { // from class: org.mozilla.javascript.d0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.tan(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "tanh", 1, new Callable() { // from class: org.mozilla.javascript.e0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.tanh(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty(scriptable, "trunc", 1, new Callable() { // from class: org.mozilla.javascript.f0
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeMath.trunc(context, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        nativeMath.defineProperty("E", Double.valueOf(2.718281828459045d), 7);
        nativeMath.defineProperty("PI", Double.valueOf(3.141592653589793d), 7);
        nativeMath.defineProperty("LN10", Double.valueOf(2.302585092994046d), 7);
        nativeMath.defineProperty("LN2", Double.valueOf(0.6931471805599453d), 7);
        nativeMath.defineProperty("LOG2E", Double.valueOf(LOG2E), 7);
        nativeMath.defineProperty("LOG10E", Double.valueOf(0.4342944819032518d), 7);
        nativeMath.defineProperty("SQRT1_2", Double.valueOf(0.7071067811865476d), 7);
        nativeMath.defineProperty("SQRT2", Double.valueOf(1.4142135623730951d), 7);
        nativeMath.defineProperty(SymbolKey.TO_STRING_TAG, MATH_TAG, 3);
        ScriptableObject.defineProperty(scriptable, MATH_TAG, nativeMath, 2);
        if (z) {
            nativeMath.sealObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object log(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number = ScriptRuntime.toNumber(objArr, 0);
        return ScriptRuntime.wrapNumber(number < 0.0d ? Double.NaN : Math.log(number));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object log10(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.wrapNumber(Math.log10(ScriptRuntime.toNumber(objArr, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object log1p(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.wrapNumber(Math.log1p(ScriptRuntime.toNumber(objArr, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object log2(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number = ScriptRuntime.toNumber(objArr, 0);
        return ScriptRuntime.wrapNumber(number < 0.0d ? Double.NaN : Math.log(number) * LOG2E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object max(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double dMax = Double.NEGATIVE_INFINITY;
        for (int i = 0; i != objArr.length; i++) {
            dMax = Math.max(dMax, ScriptRuntime.toNumber(objArr[i]));
        }
        return ScriptRuntime.wrapNumber(dMax);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object min(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double dMin = Double.POSITIVE_INFINITY;
        for (int i = 0; i != objArr.length; i++) {
            dMin = Math.min(dMin, ScriptRuntime.toNumber(objArr[i]));
        }
        return ScriptRuntime.wrapNumber(dMin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f A[PHI: r5
      0x006f: PHI (r5v1 double) = (r5v0 double), (r5v0 double), (r5v0 double), (r5v0 double), (r5v0 double), (r5v0 double), (r5v2 double), (r5v0 double) binds: [B:64:0x00a5, B:54:0x008e, B:43:0x007a, B:45:0x007e, B:37:0x006d, B:22:0x0048, B:24:0x004b, B:12:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object pow(org.mozilla.javascript.Context r24, org.mozilla.javascript.Scriptable r25, org.mozilla.javascript.Scriptable r26, java.lang.Object[] r27) {
        /*
            r0 = r27
            r1 = 0
            double r1 = org.mozilla.javascript.ScriptRuntime.toNumber(r0, r1)
            r3 = 1
            double r3 = org.mozilla.javascript.ScriptRuntime.toNumber(r0, r3)
            boolean r0 = java.lang.Double.isNaN(r3)
            if (r0 == 0) goto L14
            goto Laa
        L14:
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r0 != 0) goto L1f
            r3 = r7
            goto Laa
        L1f:
            int r9 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            r10 = -9223372036854775808
            r12 = 0
            r14 = 1
            r16 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            r18 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            if (r9 != 0) goto L4e
            double r7 = r7 / r1
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 <= 0) goto L35
            if (r0 <= 0) goto L71
            goto L6f
        L35:
            long r1 = (long) r3
            double r7 = (double) r1
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 != 0) goto L48
            long r1 = r1 & r14
            int r1 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r1 == 0) goto L48
            if (r0 <= 0) goto L43
            goto L45
        L43:
            r10 = r16
        L45:
            r3 = r10
            goto Laa
        L48:
            if (r0 <= 0) goto L4b
            goto L6f
        L4b:
            r5 = r18
            goto L6f
        L4e:
            double r20 = java.lang.Math.pow(r1, r3)
            boolean r9 = java.lang.Double.isNaN(r20)
            if (r9 == 0) goto La8
            int r9 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            r22 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            if (r9 != 0) goto L74
            int r0 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
            if (r0 < 0) goto L71
            int r0 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r0 >= 0) goto L67
            goto L71
        L67:
            int r0 = (r22 > r1 ? 1 : (r22 == r1 ? 0 : -1))
            if (r0 >= 0) goto La8
            int r0 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r0 >= 0) goto La8
        L6f:
            r3 = r5
            goto Laa
        L71:
            r3 = r18
            goto Laa
        L74:
            int r9 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r9 != 0) goto L8a
            int r0 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
            if (r0 < 0) goto L6f
            int r0 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r0 >= 0) goto L81
            goto L6f
        L81:
            int r0 = (r22 > r1 ? 1 : (r22 == r1 ? 0 : -1))
            if (r0 >= 0) goto La8
            int r0 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r0 >= 0) goto La8
            goto L71
        L8a:
            int r7 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r7 != 0) goto L91
            if (r0 <= 0) goto L6f
            goto L71
        L91:
            int r1 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r1 != 0) goto La8
            long r1 = (long) r3
            double r7 = (double) r1
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 != 0) goto La5
            long r1 = r1 & r14
            int r1 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r1 == 0) goto La5
            if (r0 <= 0) goto L45
            r3 = r16
            goto Laa
        La5:
            if (r0 <= 0) goto L6f
            goto L71
        La8:
            r3 = r20
        Laa:
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeMath.pow(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object random(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.wrapNumber(Math.random());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object round(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number = ScriptRuntime.toNumber(objArr, 0);
        if (!Double.isNaN(number) && !Double.isInfinite(number)) {
            long jRound = Math.round(number);
            if (jRound != 0) {
                number = jRound;
            } else if (number < 0.0d) {
                number = ScriptRuntime.negativeZero;
            } else if (number != 0.0d) {
                number = 0.0d;
            }
        }
        return ScriptRuntime.wrapNumber(number);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object sign(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number = ScriptRuntime.toNumber(objArr, 0);
        return !Double.isNaN(number) ? number == 0.0d ? 1.0d / number > 0.0d ? ScriptRuntime.zeroObj : ScriptRuntime.negativeZeroObj : Double.valueOf(Math.signum(number)) : ScriptRuntime.NaNobj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object sin(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number = ScriptRuntime.toNumber(objArr, 0);
        return ScriptRuntime.wrapNumber(Double.isInfinite(number) ? Double.NaN : Math.sin(number));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object sinh(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.wrapNumber(Math.sinh(ScriptRuntime.toNumber(objArr, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object sqrt(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.wrapNumber(Math.sqrt(ScriptRuntime.toNumber(objArr, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object tan(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.wrapNumber(Math.tan(ScriptRuntime.toNumber(objArr, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object tanh(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ScriptRuntime.wrapNumber(Math.tanh(ScriptRuntime.toNumber(objArr, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object trunc(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number = ScriptRuntime.toNumber(objArr, 0);
        return ScriptRuntime.wrapNumber(number < 0.0d ? Math.ceil(number) : Math.floor(number));
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return MATH_TAG;
    }
}
