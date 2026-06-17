package is.xyz.mpv;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import defpackage.a31;
import defpackage.a64;
import defpackage.c31;
import defpackage.ce4;
import defpackage.dm;
import defpackage.e04;
import defpackage.f30;
import defpackage.fu4;
import defpackage.fw4;
import defpackage.g30;
import defpackage.hl;
import defpackage.hp1;
import defpackage.i73;
import defpackage.il1;
import defpackage.kl1;
import defpackage.lt3;
import defpackage.mm0;
import defpackage.nl;
import defpackage.np3;
import defpackage.oj4;
import defpackage.pt4;
import defpackage.pw2;
import defpackage.ra0;
import defpackage.sp1;
import defpackage.t81;
import defpackage.u40;
import defpackage.v40;
import defpackage.w54;
import defpackage.we0;
import defpackage.wi4;
import defpackage.z21;
import is.xyz.mpv.MPV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class MPV {
    public static final Companion Companion = new Companion(null);
    private long nativeHandle;
    private u40 sessionScope = v40.a(wi4.b(null, 1, null).N(mm0.c().h0()));
    private final pw2 intFlow = w54.b(0, 0, null, 7, null);
    private final pw2 booleanFlow = w54.b(0, 0, null, 7, null);
    private final pw2 stringFlow = w54.b(0, 0, null, 7, null);
    private final pw2 doubleFlow = w54.b(0, 0, null, 7, null);
    private final pw2 nodeFlow = w54.b(0, 0, null, 7, null);
    private final pw2 longFlow = w54.b(0, 0, null, 7, null);
    private final pw2 floatFlow = w54.b(0, 0, null, 7, null);
    private final pw2 eventPropertyFlow = w54.b(0, 0, null, 7, null);
    private final pw2 eventFlow = w54.b(0, 0, null, 7, null);
    private final Map<String, ce4> stateCache = new LinkedHashMap();
    private final Map<String, Integer> observedProperties = new LinkedHashMap();
    private final PropertyAccessor prop = new PropertyAccessor();
    private final PropertyFlowAccessor propFlow = new PropertyFlowAccessor();
    private final List<EventObserver> observers = new ArrayList();
    private final List<LogObserver> log_observers = new ArrayList();
    private final pw2 logFlow = w54.b(0, 0, null, 7, null);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface EventObserver {
        void event(int i, MPVNode mPVNode);

        void eventProperty(String str);

        void eventProperty(String str, double d);

        void eventProperty(String str, long j);

        void eventProperty(String str, MPVNode mPVNode);

        void eventProperty(String str, String str2);

        void eventProperty(String str, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface LogObserver {
        void logMessage(String str, int i, String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class PropertyAccessor {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public PropertyAccessor() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final /* synthetic */ <T> T get(String str) {
            T t;
            str.getClass();
            if (!MPV.this.isInitialized()) {
                return null;
            }
            il1.d(4, "T");
            hp1 hp1VarB = np3.b(Object.class);
            if (il1.a(hp1VarB, np3.b(Integer.TYPE))) {
                t = (T) MPV.this.getPropertyInt(str);
            } else if (il1.a(hp1VarB, np3.b(Long.TYPE))) {
                t = (T) MPV.this.getPropertyLong(str);
            } else if (il1.a(hp1VarB, np3.b(Float.TYPE))) {
                t = (T) MPV.this.getPropertyFloat(str);
            } else if (il1.a(hp1VarB, np3.b(Double.TYPE))) {
                t = (T) MPV.this.getPropertyDouble(str);
            } else if (il1.a(hp1VarB, np3.b(Boolean.TYPE))) {
                t = (T) MPV.this.getPropertyBoolean(str);
            } else if (il1.a(hp1VarB, np3.b(String.class))) {
                t = (T) MPV.this.getPropertyString(str);
            } else {
                if (!il1.a(hp1VarB, np3.b(MPVNode.class))) {
                    il1.d(4, "T");
                    nl.a("Unsupported property type: ", np3.b(Object.class));
                    return null;
                }
                t = (T) MPV.this.getPropertyNode(str);
            }
            il1.d(1, "T?");
            return t;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: T */
        /* JADX WARN: Multi-variable type inference failed */
        public final /* synthetic */ <T> void set(String str, T t) {
            str.getClass();
            if (MPV.this.isInitialized()) {
                il1.d(4, "T");
                hp1 hp1VarB = np3.b(Object.class);
                if (il1.a(hp1VarB, np3.b(Integer.TYPE))) {
                    MPV mpv = MPV.this;
                    t.getClass();
                    mpv.setPropertyInt(str, ((Integer) t).intValue());
                    return;
                }
                if (il1.a(hp1VarB, np3.b(Long.TYPE))) {
                    MPV mpv2 = MPV.this;
                    t.getClass();
                    mpv2.setPropertyLong(str, ((Long) t).longValue());
                    return;
                }
                if (il1.a(hp1VarB, np3.b(Float.TYPE))) {
                    MPV mpv3 = MPV.this;
                    t.getClass();
                    mpv3.setPropertyFloat(str, ((Float) t).floatValue());
                    return;
                }
                if (il1.a(hp1VarB, np3.b(Double.TYPE))) {
                    MPV mpv4 = MPV.this;
                    t.getClass();
                    mpv4.setPropertyDouble(str, ((Double) t).doubleValue());
                    return;
                }
                if (il1.a(hp1VarB, np3.b(Boolean.TYPE))) {
                    MPV mpv5 = MPV.this;
                    t.getClass();
                    mpv5.setPropertyBoolean(str, ((Boolean) t).booleanValue());
                } else if (il1.a(hp1VarB, np3.b(String.class))) {
                    MPV mpv6 = MPV.this;
                    t.getClass();
                    mpv6.setPropertyString(str, (String) t);
                } else if (!il1.a(hp1VarB, np3.b(MPVNode.class))) {
                    il1.d(4, "T");
                    nl.a("Unsupported property type: ", np3.b(Object.class));
                } else {
                    MPV mpv7 = MPV.this;
                    t.getClass();
                    mpv7.setPropertyNode(str, (MPVNode) t);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class PropertyDelegate<T> {
        private final Function1<String, T> getter;
        private final String name;
        private final Function2<String, T, fw4> setter;
        final /* synthetic */ MPV this$0;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, ? extends T> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super T, fw4> */
        /* JADX WARN: Multi-variable type inference failed */
        public PropertyDelegate(MPV mpv, String str, Function1<? super String, ? extends T> function1, Function2<? super String, ? super T, fw4> function2) {
            str.getClass();
            function1.getClass();
            function2.getClass();
            this.this$0 = mpv;
            this.name = str;
            this.getter = function1;
            this.setter = function2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final T getValue(Object obj, sp1 sp1Var) {
            sp1Var.getClass();
            if (this.this$0.isInitialized()) {
                return this.getter.invoke(this.name);
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void setValue(Object obj, sp1 sp1Var, T t) {
            sp1Var.getClass();
            if (!this.this$0.isInitialized() || t == null) {
                return;
            }
            this.setter.invoke(this.name, t);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class PropertyFlowAccessor {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public PropertyFlowAccessor() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static ce4 a(MPV mpv, final String str) {
            final pw2 pw2Var = mpv.stringFlow;
            final z21 z21Var = new z21() { // from class: is.xyz.mpv.MPV$PropertyFlowAccessor$getStringFlow$lambda$17$$inlined$filter$1

                /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getStringFlow$lambda$17$$inlined$filter$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                public static final class AnonymousClass2<T> implements a31 {
                    final /* synthetic */ String $name$inlined;
                    final /* synthetic */ a31 $this_unsafeFlow;

                    /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getStringFlow$lambda$17$$inlined$filter$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                    @ra0(c = "is.xyz.mpv.MPV$PropertyFlowAccessor$getStringFlow$lambda$17$$inlined$filter$1$2", f = "MPV.kt", l = {223}, m = "emit")
                    public static final class AnonymousClass1 extends g30 {
                        Object L$0;
                        Object L$1;
                        int label;
                        /* synthetic */ Object result;

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        public AnonymousClass1(f30 f30Var) {
                            super(f30Var);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.hh
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    public AnonymousClass2(a31 a31Var, String str) {
                        this.$this_unsafeFlow = a31Var;
                        this.$name$inlined = str;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // defpackage.a31
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, f30 f30Var) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        if (f30Var instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) f30Var;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(f30Var);
                            }
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objE = kl1.e();
                        int i2 = anonymousClass1.label;
                        if (i2 == 0) {
                            lt3.b(obj2);
                            a31 a31Var = this.$this_unsafeFlow;
                            if (il1.a(((i73) obj).c(), this.$name$inlined)) {
                                anonymousClass1.label = 1;
                                if (a31Var.emit(obj, anonymousClass1) == objE) {
                                    return objE;
                                }
                            }
                        } else {
                            if (i2 != 1) {
                                e04.a("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            lt3.b(obj2);
                        }
                        return fw4.a;
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.z21
                public Object collect(a31 a31Var, f30 f30Var) {
                    Object objCollect = pw2Var.collect(new AnonymousClass2(a31Var, str), f30Var);
                    return objCollect == kl1.e() ? objCollect : fw4.a;
                }
            };
            return c31.l(new z21() { // from class: is.xyz.mpv.MPV$PropertyFlowAccessor$getStringFlow$lambda$17$$inlined$map$1

                /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getStringFlow$lambda$17$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                public static final class AnonymousClass2<T> implements a31 {
                    final /* synthetic */ a31 $this_unsafeFlow;

                    /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getStringFlow$lambda$17$$inlined$map$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                    @ra0(c = "is.xyz.mpv.MPV$PropertyFlowAccessor$getStringFlow$lambda$17$$inlined$map$1$2", f = "MPV.kt", l = {223}, m = "emit")
                    public static final class AnonymousClass1 extends g30 {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        public AnonymousClass1(f30 f30Var) {
                            super(f30Var);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.hh
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    public AnonymousClass2(a31 a31Var) {
                        this.$this_unsafeFlow = a31Var;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // defpackage.a31
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, f30 f30Var) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        if (f30Var instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) f30Var;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(f30Var);
                            }
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objE = kl1.e();
                        int i2 = anonymousClass1.label;
                        if (i2 == 0) {
                            lt3.b(obj2);
                            a31 a31Var = this.$this_unsafeFlow;
                            Object objD = ((i73) obj).d();
                            anonymousClass1.label = 1;
                            if (a31Var.emit(objD, anonymousClass1) == objE) {
                                return objE;
                            }
                        } else {
                            if (i2 != 1) {
                                e04.a("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            lt3.b(obj2);
                        }
                        return fw4.a;
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.z21
                public Object collect(a31 a31Var, f30 f30Var) {
                    Object objCollect = z21Var.collect(new AnonymousClass2(a31Var), f30Var);
                    return objCollect == kl1.e() ? objCollect : fw4.a;
                }
            }, mpv.sessionScope, a64.a.b(), mpv.isInitialized() ? mpv.getPropertyString(str) : null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static ce4 b(MPV mpv, final String str) {
            final pw2 pw2Var = mpv.floatFlow;
            final z21 z21Var = new z21() { // from class: is.xyz.mpv.MPV$PropertyFlowAccessor$getFloatFlow$lambda$8$$inlined$filter$1

                /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getFloatFlow$lambda$8$$inlined$filter$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                public static final class AnonymousClass2<T> implements a31 {
                    final /* synthetic */ String $name$inlined;
                    final /* synthetic */ a31 $this_unsafeFlow;

                    /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getFloatFlow$lambda$8$$inlined$filter$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                    @ra0(c = "is.xyz.mpv.MPV$PropertyFlowAccessor$getFloatFlow$lambda$8$$inlined$filter$1$2", f = "MPV.kt", l = {223}, m = "emit")
                    public static final class AnonymousClass1 extends g30 {
                        Object L$0;
                        Object L$1;
                        int label;
                        /* synthetic */ Object result;

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        public AnonymousClass1(f30 f30Var) {
                            super(f30Var);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.hh
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    public AnonymousClass2(a31 a31Var, String str) {
                        this.$this_unsafeFlow = a31Var;
                        this.$name$inlined = str;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // defpackage.a31
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, f30 f30Var) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        if (f30Var instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) f30Var;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(f30Var);
                            }
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objE = kl1.e();
                        int i2 = anonymousClass1.label;
                        if (i2 == 0) {
                            lt3.b(obj2);
                            a31 a31Var = this.$this_unsafeFlow;
                            if (il1.a(((i73) obj).c(), this.$name$inlined)) {
                                anonymousClass1.label = 1;
                                if (a31Var.emit(obj, anonymousClass1) == objE) {
                                    return objE;
                                }
                            }
                        } else {
                            if (i2 != 1) {
                                e04.a("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            lt3.b(obj2);
                        }
                        return fw4.a;
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.z21
                public Object collect(a31 a31Var, f30 f30Var) {
                    Object objCollect = pw2Var.collect(new AnonymousClass2(a31Var, str), f30Var);
                    return objCollect == kl1.e() ? objCollect : fw4.a;
                }
            };
            return c31.l(new z21() { // from class: is.xyz.mpv.MPV$PropertyFlowAccessor$getFloatFlow$lambda$8$$inlined$map$1

                /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getFloatFlow$lambda$8$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                public static final class AnonymousClass2<T> implements a31 {
                    final /* synthetic */ a31 $this_unsafeFlow;

                    /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getFloatFlow$lambda$8$$inlined$map$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                    @ra0(c = "is.xyz.mpv.MPV$PropertyFlowAccessor$getFloatFlow$lambda$8$$inlined$map$1$2", f = "MPV.kt", l = {223}, m = "emit")
                    public static final class AnonymousClass1 extends g30 {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        public AnonymousClass1(f30 f30Var) {
                            super(f30Var);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.hh
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    public AnonymousClass2(a31 a31Var) {
                        this.$this_unsafeFlow = a31Var;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // defpackage.a31
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, f30 f30Var) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        if (f30Var instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) f30Var;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(f30Var);
                            }
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objE = kl1.e();
                        int i2 = anonymousClass1.label;
                        if (i2 == 0) {
                            lt3.b(obj2);
                            a31 a31Var = this.$this_unsafeFlow;
                            Object objD = ((i73) obj).d();
                            anonymousClass1.label = 1;
                            if (a31Var.emit(objD, anonymousClass1) == objE) {
                                return objE;
                            }
                        } else {
                            if (i2 != 1) {
                                e04.a("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            lt3.b(obj2);
                        }
                        return fw4.a;
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.z21
                public Object collect(a31 a31Var, f30 f30Var) {
                    Object objCollect = z21Var.collect(new AnonymousClass2(a31Var), f30Var);
                    return objCollect == kl1.e() ? objCollect : fw4.a;
                }
            }, mpv.sessionScope, a64.a.b(), mpv.isInitialized() ? mpv.getPropertyFloat(str) : null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static ce4 c(MPV mpv, final String str) {
            final pw2 pw2Var = mpv.intFlow;
            final z21 z21Var = new z21() { // from class: is.xyz.mpv.MPV$PropertyFlowAccessor$getIntFlow$lambda$2$$inlined$filter$1

                /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getIntFlow$lambda$2$$inlined$filter$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                public static final class AnonymousClass2<T> implements a31 {
                    final /* synthetic */ String $name$inlined;
                    final /* synthetic */ a31 $this_unsafeFlow;

                    /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getIntFlow$lambda$2$$inlined$filter$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                    @ra0(c = "is.xyz.mpv.MPV$PropertyFlowAccessor$getIntFlow$lambda$2$$inlined$filter$1$2", f = "MPV.kt", l = {223}, m = "emit")
                    public static final class AnonymousClass1 extends g30 {
                        Object L$0;
                        Object L$1;
                        int label;
                        /* synthetic */ Object result;

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        public AnonymousClass1(f30 f30Var) {
                            super(f30Var);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.hh
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    public AnonymousClass2(a31 a31Var, String str) {
                        this.$this_unsafeFlow = a31Var;
                        this.$name$inlined = str;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // defpackage.a31
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, f30 f30Var) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        if (f30Var instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) f30Var;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(f30Var);
                            }
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objE = kl1.e();
                        int i2 = anonymousClass1.label;
                        if (i2 == 0) {
                            lt3.b(obj2);
                            a31 a31Var = this.$this_unsafeFlow;
                            if (il1.a(((i73) obj).c(), this.$name$inlined)) {
                                anonymousClass1.label = 1;
                                if (a31Var.emit(obj, anonymousClass1) == objE) {
                                    return objE;
                                }
                            }
                        } else {
                            if (i2 != 1) {
                                e04.a("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            lt3.b(obj2);
                        }
                        return fw4.a;
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.z21
                public Object collect(a31 a31Var, f30 f30Var) {
                    Object objCollect = pw2Var.collect(new AnonymousClass2(a31Var, str), f30Var);
                    return objCollect == kl1.e() ? objCollect : fw4.a;
                }
            };
            return c31.l(new z21() { // from class: is.xyz.mpv.MPV$PropertyFlowAccessor$getIntFlow$lambda$2$$inlined$map$1

                /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getIntFlow$lambda$2$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                public static final class AnonymousClass2<T> implements a31 {
                    final /* synthetic */ a31 $this_unsafeFlow;

                    /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getIntFlow$lambda$2$$inlined$map$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                    @ra0(c = "is.xyz.mpv.MPV$PropertyFlowAccessor$getIntFlow$lambda$2$$inlined$map$1$2", f = "MPV.kt", l = {223}, m = "emit")
                    public static final class AnonymousClass1 extends g30 {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        public AnonymousClass1(f30 f30Var) {
                            super(f30Var);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.hh
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    public AnonymousClass2(a31 a31Var) {
                        this.$this_unsafeFlow = a31Var;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // defpackage.a31
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, f30 f30Var) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        if (f30Var instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) f30Var;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(f30Var);
                            }
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objE = kl1.e();
                        int i2 = anonymousClass1.label;
                        if (i2 == 0) {
                            lt3.b(obj2);
                            a31 a31Var = this.$this_unsafeFlow;
                            Object objD = ((i73) obj).d();
                            anonymousClass1.label = 1;
                            if (a31Var.emit(objD, anonymousClass1) == objE) {
                                return objE;
                            }
                        } else {
                            if (i2 != 1) {
                                e04.a("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            lt3.b(obj2);
                        }
                        return fw4.a;
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.z21
                public Object collect(a31 a31Var, f30 f30Var) {
                    Object objCollect = z21Var.collect(new AnonymousClass2(a31Var), f30Var);
                    return objCollect == kl1.e() ? objCollect : fw4.a;
                }
            }, mpv.sessionScope, a64.a.b(), mpv.isInitialized() ? mpv.getPropertyInt(str) : null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static ce4 d(MPV mpv, final String str) {
            final pw2 pw2Var = mpv.longFlow;
            final z21 z21Var = new z21() { // from class: is.xyz.mpv.MPV$PropertyFlowAccessor$getLongFlow$lambda$5$$inlined$filter$1

                /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getLongFlow$lambda$5$$inlined$filter$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                public static final class AnonymousClass2<T> implements a31 {
                    final /* synthetic */ String $name$inlined;
                    final /* synthetic */ a31 $this_unsafeFlow;

                    /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getLongFlow$lambda$5$$inlined$filter$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                    @ra0(c = "is.xyz.mpv.MPV$PropertyFlowAccessor$getLongFlow$lambda$5$$inlined$filter$1$2", f = "MPV.kt", l = {223}, m = "emit")
                    public static final class AnonymousClass1 extends g30 {
                        Object L$0;
                        Object L$1;
                        int label;
                        /* synthetic */ Object result;

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        public AnonymousClass1(f30 f30Var) {
                            super(f30Var);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.hh
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    public AnonymousClass2(a31 a31Var, String str) {
                        this.$this_unsafeFlow = a31Var;
                        this.$name$inlined = str;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // defpackage.a31
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, f30 f30Var) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        if (f30Var instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) f30Var;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(f30Var);
                            }
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objE = kl1.e();
                        int i2 = anonymousClass1.label;
                        if (i2 == 0) {
                            lt3.b(obj2);
                            a31 a31Var = this.$this_unsafeFlow;
                            if (il1.a(((i73) obj).c(), this.$name$inlined)) {
                                anonymousClass1.label = 1;
                                if (a31Var.emit(obj, anonymousClass1) == objE) {
                                    return objE;
                                }
                            }
                        } else {
                            if (i2 != 1) {
                                e04.a("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            lt3.b(obj2);
                        }
                        return fw4.a;
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.z21
                public Object collect(a31 a31Var, f30 f30Var) {
                    Object objCollect = pw2Var.collect(new AnonymousClass2(a31Var, str), f30Var);
                    return objCollect == kl1.e() ? objCollect : fw4.a;
                }
            };
            return c31.l(new z21() { // from class: is.xyz.mpv.MPV$PropertyFlowAccessor$getLongFlow$lambda$5$$inlined$map$1

                /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getLongFlow$lambda$5$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                public static final class AnonymousClass2<T> implements a31 {
                    final /* synthetic */ a31 $this_unsafeFlow;

                    /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getLongFlow$lambda$5$$inlined$map$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                    @ra0(c = "is.xyz.mpv.MPV$PropertyFlowAccessor$getLongFlow$lambda$5$$inlined$map$1$2", f = "MPV.kt", l = {223}, m = "emit")
                    public static final class AnonymousClass1 extends g30 {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        public AnonymousClass1(f30 f30Var) {
                            super(f30Var);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.hh
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    public AnonymousClass2(a31 a31Var) {
                        this.$this_unsafeFlow = a31Var;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // defpackage.a31
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, f30 f30Var) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        if (f30Var instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) f30Var;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(f30Var);
                            }
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objE = kl1.e();
                        int i2 = anonymousClass1.label;
                        if (i2 == 0) {
                            lt3.b(obj2);
                            a31 a31Var = this.$this_unsafeFlow;
                            Object objD = ((i73) obj).d();
                            anonymousClass1.label = 1;
                            if (a31Var.emit(objD, anonymousClass1) == objE) {
                                return objE;
                            }
                        } else {
                            if (i2 != 1) {
                                e04.a("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            lt3.b(obj2);
                        }
                        return fw4.a;
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.z21
                public Object collect(a31 a31Var, f30 f30Var) {
                    Object objCollect = z21Var.collect(new AnonymousClass2(a31Var), f30Var);
                    return objCollect == kl1.e() ? objCollect : fw4.a;
                }
            }, mpv.sessionScope, a64.a.a(), mpv.isInitialized() ? mpv.getPropertyLong(str) : null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static ce4 e(MPV mpv, final String str) {
            final pw2 pw2Var = mpv.doubleFlow;
            final z21 z21Var = new z21() { // from class: is.xyz.mpv.MPV$PropertyFlowAccessor$getDoubleFlow$lambda$11$$inlined$filter$1

                /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getDoubleFlow$lambda$11$$inlined$filter$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                public static final class AnonymousClass2<T> implements a31 {
                    final /* synthetic */ String $name$inlined;
                    final /* synthetic */ a31 $this_unsafeFlow;

                    /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getDoubleFlow$lambda$11$$inlined$filter$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                    @ra0(c = "is.xyz.mpv.MPV$PropertyFlowAccessor$getDoubleFlow$lambda$11$$inlined$filter$1$2", f = "MPV.kt", l = {223}, m = "emit")
                    public static final class AnonymousClass1 extends g30 {
                        Object L$0;
                        Object L$1;
                        int label;
                        /* synthetic */ Object result;

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        public AnonymousClass1(f30 f30Var) {
                            super(f30Var);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.hh
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    public AnonymousClass2(a31 a31Var, String str) {
                        this.$this_unsafeFlow = a31Var;
                        this.$name$inlined = str;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // defpackage.a31
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, f30 f30Var) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        if (f30Var instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) f30Var;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(f30Var);
                            }
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objE = kl1.e();
                        int i2 = anonymousClass1.label;
                        if (i2 == 0) {
                            lt3.b(obj2);
                            a31 a31Var = this.$this_unsafeFlow;
                            if (il1.a(((i73) obj).c(), this.$name$inlined)) {
                                anonymousClass1.label = 1;
                                if (a31Var.emit(obj, anonymousClass1) == objE) {
                                    return objE;
                                }
                            }
                        } else {
                            if (i2 != 1) {
                                e04.a("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            lt3.b(obj2);
                        }
                        return fw4.a;
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.z21
                public Object collect(a31 a31Var, f30 f30Var) {
                    Object objCollect = pw2Var.collect(new AnonymousClass2(a31Var, str), f30Var);
                    return objCollect == kl1.e() ? objCollect : fw4.a;
                }
            };
            return c31.l(new z21() { // from class: is.xyz.mpv.MPV$PropertyFlowAccessor$getDoubleFlow$lambda$11$$inlined$map$1

                /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getDoubleFlow$lambda$11$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                public static final class AnonymousClass2<T> implements a31 {
                    final /* synthetic */ a31 $this_unsafeFlow;

                    /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getDoubleFlow$lambda$11$$inlined$map$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                    @ra0(c = "is.xyz.mpv.MPV$PropertyFlowAccessor$getDoubleFlow$lambda$11$$inlined$map$1$2", f = "MPV.kt", l = {223}, m = "emit")
                    public static final class AnonymousClass1 extends g30 {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        public AnonymousClass1(f30 f30Var) {
                            super(f30Var);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.hh
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    public AnonymousClass2(a31 a31Var) {
                        this.$this_unsafeFlow = a31Var;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // defpackage.a31
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, f30 f30Var) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        if (f30Var instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) f30Var;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(f30Var);
                            }
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objE = kl1.e();
                        int i2 = anonymousClass1.label;
                        if (i2 == 0) {
                            lt3.b(obj2);
                            a31 a31Var = this.$this_unsafeFlow;
                            Object objD = ((i73) obj).d();
                            anonymousClass1.label = 1;
                            if (a31Var.emit(objD, anonymousClass1) == objE) {
                                return objE;
                            }
                        } else {
                            if (i2 != 1) {
                                e04.a("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            lt3.b(obj2);
                        }
                        return fw4.a;
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.z21
                public Object collect(a31 a31Var, f30 f30Var) {
                    Object objCollect = z21Var.collect(new AnonymousClass2(a31Var), f30Var);
                    return objCollect == kl1.e() ? objCollect : fw4.a;
                }
            }, mpv.sessionScope, a64.a.b(), mpv.isInitialized() ? mpv.getPropertyDouble(str) : null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static ce4 f(MPV mpv, final String str) {
            final pw2 pw2Var = mpv.nodeFlow;
            final z21 z21Var = new z21() { // from class: is.xyz.mpv.MPV$PropertyFlowAccessor$getNodeFlow$lambda$20$$inlined$filter$1

                /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getNodeFlow$lambda$20$$inlined$filter$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                public static final class AnonymousClass2<T> implements a31 {
                    final /* synthetic */ String $name$inlined;
                    final /* synthetic */ a31 $this_unsafeFlow;

                    /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getNodeFlow$lambda$20$$inlined$filter$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                    @ra0(c = "is.xyz.mpv.MPV$PropertyFlowAccessor$getNodeFlow$lambda$20$$inlined$filter$1$2", f = "MPV.kt", l = {223}, m = "emit")
                    public static final class AnonymousClass1 extends g30 {
                        Object L$0;
                        Object L$1;
                        int label;
                        /* synthetic */ Object result;

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        public AnonymousClass1(f30 f30Var) {
                            super(f30Var);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.hh
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    public AnonymousClass2(a31 a31Var, String str) {
                        this.$this_unsafeFlow = a31Var;
                        this.$name$inlined = str;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // defpackage.a31
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, f30 f30Var) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        if (f30Var instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) f30Var;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(f30Var);
                            }
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objE = kl1.e();
                        int i2 = anonymousClass1.label;
                        if (i2 == 0) {
                            lt3.b(obj2);
                            a31 a31Var = this.$this_unsafeFlow;
                            if (il1.a(((i73) obj).c(), this.$name$inlined)) {
                                anonymousClass1.label = 1;
                                if (a31Var.emit(obj, anonymousClass1) == objE) {
                                    return objE;
                                }
                            }
                        } else {
                            if (i2 != 1) {
                                e04.a("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            lt3.b(obj2);
                        }
                        return fw4.a;
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.z21
                public Object collect(a31 a31Var, f30 f30Var) {
                    Object objCollect = pw2Var.collect(new AnonymousClass2(a31Var, str), f30Var);
                    return objCollect == kl1.e() ? objCollect : fw4.a;
                }
            };
            return c31.l(new z21() { // from class: is.xyz.mpv.MPV$PropertyFlowAccessor$getNodeFlow$lambda$20$$inlined$map$1

                /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getNodeFlow$lambda$20$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                public static final class AnonymousClass2<T> implements a31 {
                    final /* synthetic */ a31 $this_unsafeFlow;

                    /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getNodeFlow$lambda$20$$inlined$map$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                    @ra0(c = "is.xyz.mpv.MPV$PropertyFlowAccessor$getNodeFlow$lambda$20$$inlined$map$1$2", f = "MPV.kt", l = {223}, m = "emit")
                    public static final class AnonymousClass1 extends g30 {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        public AnonymousClass1(f30 f30Var) {
                            super(f30Var);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.hh
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    public AnonymousClass2(a31 a31Var) {
                        this.$this_unsafeFlow = a31Var;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // defpackage.a31
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, f30 f30Var) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        if (f30Var instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) f30Var;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(f30Var);
                            }
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objE = kl1.e();
                        int i2 = anonymousClass1.label;
                        if (i2 == 0) {
                            lt3.b(obj2);
                            a31 a31Var = this.$this_unsafeFlow;
                            Object objD = ((i73) obj).d();
                            anonymousClass1.label = 1;
                            if (a31Var.emit(objD, anonymousClass1) == objE) {
                                return objE;
                            }
                        } else {
                            if (i2 != 1) {
                                e04.a("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            lt3.b(obj2);
                        }
                        return fw4.a;
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.z21
                public Object collect(a31 a31Var, f30 f30Var) {
                    Object objCollect = z21Var.collect(new AnonymousClass2(a31Var), f30Var);
                    return objCollect == kl1.e() ? objCollect : fw4.a;
                }
            }, mpv.sessionScope, a64.a.b(), mpv.isInitialized() ? mpv.getPropertyNode(str) : null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static ce4 g(MPV mpv, final String str) {
            final pw2 pw2Var = mpv.booleanFlow;
            final z21 z21Var = new z21() { // from class: is.xyz.mpv.MPV$PropertyFlowAccessor$getBooleanFlow$lambda$14$$inlined$filter$1

                /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getBooleanFlow$lambda$14$$inlined$filter$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                public static final class AnonymousClass2<T> implements a31 {
                    final /* synthetic */ String $name$inlined;
                    final /* synthetic */ a31 $this_unsafeFlow;

                    /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getBooleanFlow$lambda$14$$inlined$filter$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                    @ra0(c = "is.xyz.mpv.MPV$PropertyFlowAccessor$getBooleanFlow$lambda$14$$inlined$filter$1$2", f = "MPV.kt", l = {223}, m = "emit")
                    public static final class AnonymousClass1 extends g30 {
                        Object L$0;
                        Object L$1;
                        int label;
                        /* synthetic */ Object result;

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        public AnonymousClass1(f30 f30Var) {
                            super(f30Var);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.hh
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    public AnonymousClass2(a31 a31Var, String str) {
                        this.$this_unsafeFlow = a31Var;
                        this.$name$inlined = str;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // defpackage.a31
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, f30 f30Var) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        if (f30Var instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) f30Var;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(f30Var);
                            }
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objE = kl1.e();
                        int i2 = anonymousClass1.label;
                        if (i2 == 0) {
                            lt3.b(obj2);
                            a31 a31Var = this.$this_unsafeFlow;
                            if (il1.a(((i73) obj).c(), this.$name$inlined)) {
                                anonymousClass1.label = 1;
                                if (a31Var.emit(obj, anonymousClass1) == objE) {
                                    return objE;
                                }
                            }
                        } else {
                            if (i2 != 1) {
                                e04.a("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            lt3.b(obj2);
                        }
                        return fw4.a;
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.z21
                public Object collect(a31 a31Var, f30 f30Var) {
                    Object objCollect = pw2Var.collect(new AnonymousClass2(a31Var, str), f30Var);
                    return objCollect == kl1.e() ? objCollect : fw4.a;
                }
            };
            return c31.l(new z21() { // from class: is.xyz.mpv.MPV$PropertyFlowAccessor$getBooleanFlow$lambda$14$$inlined$map$1

                /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getBooleanFlow$lambda$14$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                public static final class AnonymousClass2<T> implements a31 {
                    final /* synthetic */ a31 $this_unsafeFlow;

                    /* JADX INFO: renamed from: is.xyz.mpv.MPV$PropertyFlowAccessor$getBooleanFlow$lambda$14$$inlined$map$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                    @ra0(c = "is.xyz.mpv.MPV$PropertyFlowAccessor$getBooleanFlow$lambda$14$$inlined$map$1$2", f = "MPV.kt", l = {223}, m = "emit")
                    public static final class AnonymousClass1 extends g30 {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        public AnonymousClass1(f30 f30Var) {
                            super(f30Var);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.hh
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    public AnonymousClass2(a31 a31Var) {
                        this.$this_unsafeFlow = a31Var;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // defpackage.a31
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, f30 f30Var) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        if (f30Var instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) f30Var;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(f30Var);
                            }
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objE = kl1.e();
                        int i2 = anonymousClass1.label;
                        if (i2 == 0) {
                            lt3.b(obj2);
                            a31 a31Var = this.$this_unsafeFlow;
                            Object objD = ((i73) obj).d();
                            anonymousClass1.label = 1;
                            if (a31Var.emit(objD, anonymousClass1) == objE) {
                                return objE;
                            }
                        } else {
                            if (i2 != 1) {
                                e04.a("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            lt3.b(obj2);
                        }
                        return fw4.a;
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.z21
                public Object collect(a31 a31Var, f30 f30Var) {
                    Object objCollect = z21Var.collect(new AnonymousClass2(a31Var), f30Var);
                    return objCollect == kl1.e() ? objCollect : fw4.a;
                }
            }, mpv.sessionScope, a64.a.b(), mpv.isInitialized() ? mpv.getPropertyBoolean(str) : null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final /* synthetic */ <T> ce4 get(String str) {
            ce4 nodeFlow;
            str.getClass();
            il1.d(4, "T");
            hp1 hp1VarB = np3.b(Object.class);
            if (il1.a(hp1VarB, np3.b(Integer.TYPE))) {
                nodeFlow = getIntFlow(str);
            } else if (il1.a(hp1VarB, np3.b(Long.TYPE))) {
                nodeFlow = getLongFlow(str);
            } else if (il1.a(hp1VarB, np3.b(Float.TYPE))) {
                nodeFlow = getFloatFlow(str);
            } else if (il1.a(hp1VarB, np3.b(Double.TYPE))) {
                nodeFlow = getDoubleFlow(str);
            } else if (il1.a(hp1VarB, np3.b(Boolean.TYPE))) {
                nodeFlow = getBooleanFlow(str);
            } else if (il1.a(hp1VarB, np3.b(String.class))) {
                nodeFlow = getStringFlow(str);
            } else {
                if (!il1.a(hp1VarB, np3.b(MPVNode.class))) {
                    il1.d(4, "T");
                    nl.a("Unsupported property type: ", np3.b(Object.class));
                    return null;
                }
                nodeFlow = getNodeFlow(str);
            }
            nodeFlow.getClass();
            return nodeFlow;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ce4 getBooleanFlow(final String str) {
            str.getClass();
            final MPV mpv = MPV.this;
            return mpv.getOrCreateState(str, 3, new Function0() { // from class: t32
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MPV.PropertyFlowAccessor.g(mpv, str);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ce4 getDoubleFlow(final String str) {
            str.getClass();
            final MPV mpv = MPV.this;
            return mpv.getOrCreateState(str, 5, new Function0() { // from class: q32
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MPV.PropertyFlowAccessor.e(mpv, str);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ce4 getFloatFlow(final String str) {
            str.getClass();
            final MPV mpv = MPV.this;
            return mpv.getOrCreateState(str, 5, new Function0() { // from class: o32
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MPV.PropertyFlowAccessor.b(mpv, str);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ce4 getIntFlow(final String str) {
            str.getClass();
            final MPV mpv = MPV.this;
            return mpv.getOrCreateState(str, 4, new Function0() { // from class: n32
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MPV.PropertyFlowAccessor.c(mpv, str);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ce4 getLongFlow(final String str) {
            str.getClass();
            final MPV mpv = MPV.this;
            return mpv.getOrCreateState(str, 4, new Function0() { // from class: s32
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MPV.PropertyFlowAccessor.d(mpv, str);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ce4 getNodeFlow(final String str) {
            str.getClass();
            final MPV mpv = MPV.this;
            return mpv.getOrCreateState(str, 6, new Function0() { // from class: r32
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MPV.PropertyFlowAccessor.f(mpv, str);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ce4 getStringFlow(final String str) {
            str.getClass();
            final MPV mpv = MPV.this;
            return mpv.getOrCreateState(str, 1, new Function0() { // from class: p32
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MPV.PropertyFlowAccessor.a(mpv, str);
                }
            });
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$event$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @ra0(c = "is.xyz.mpv.MPV$event$2", f = "MPV.kt", l = {369}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends oj4 implements Function2<u40, f30, Object> {
        final /* synthetic */ int $eventId;
        int label;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i, f30 f30Var) {
            super(2, f30Var);
            this.$eventId = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return MPV.this.new AnonymousClass2(this.$eventId, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((AnonymousClass2) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.label;
            if (i == 0) {
                lt3.b(obj);
                pw2 pw2Var = MPV.this.eventFlow;
                Integer numD = hl.d(this.$eventId);
                this.label = 1;
                if (pw2Var.emit(numD, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
            }
            return fw4.a;
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$eventProperty$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @ra0(c = "is.xyz.mpv.MPV$eventProperty$10", f = "MPV.kt", l = {353}, m = "invokeSuspend")
    public static final class AnonymousClass10 extends oj4 implements Function2<u40, f30, Object> {
        final /* synthetic */ String $property;
        final /* synthetic */ MPVNode $value;
        int label;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass10(String str, MPVNode mPVNode, f30 f30Var) {
            super(2, f30Var);
            this.$property = str;
            this.$value = mPVNode;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return MPV.this.new AnonymousClass10(this.$property, this.$value, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((AnonymousClass10) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.label;
            if (i == 0) {
                lt3.b(obj);
                pw2 pw2Var = MPV.this.nodeFlow;
                i73 i73VarA = fu4.a(this.$property, this.$value);
                this.label = 1;
                if (pw2Var.emit(i73VarA, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
            }
            return fw4.a;
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$eventProperty$12, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @ra0(c = "is.xyz.mpv.MPV$eventProperty$12", f = "MPV.kt", l = {361}, m = "invokeSuspend")
    public static final class AnonymousClass12 extends oj4 implements Function2<u40, f30, Object> {
        final /* synthetic */ String $property;
        int label;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass12(String str, f30 f30Var) {
            super(2, f30Var);
            this.$property = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return MPV.this.new AnonymousClass12(this.$property, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((AnonymousClass12) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.label;
            if (i == 0) {
                lt3.b(obj);
                pw2 pw2Var = MPV.this.eventPropertyFlow;
                String str = this.$property;
                this.label = 1;
                if (pw2Var.emit(str, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
            }
            return fw4.a;
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$eventProperty$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @ra0(c = "is.xyz.mpv.MPV$eventProperty$2", f = "MPV.kt", l = {316, 317}, m = "invokeSuspend")
    public static final class C01472 extends oj4 implements Function2<u40, f30, Object> {
        final /* synthetic */ String $property;
        final /* synthetic */ long $value;
        int label;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01472(String str, long j, f30 f30Var) {
            super(2, f30Var);
            this.$property = str;
            this.$value = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return MPV.this.new C01472(this.$property, this.$value, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((C01472) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
        
            if (r7.emit(r1, r6) == r0) goto L15;
         */
        @Override // defpackage.hh
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.label;
            if (i == 0) {
                lt3.b(obj);
                pw2 pw2Var = MPV.this.longFlow;
                i73 i73VarA = fu4.a(this.$property, hl.e(this.$value));
                this.label = 1;
                if (pw2Var.emit(i73VarA, this) != objE) {
                }
                return objE;
            }
            if (i != 1) {
                if (i == 2) {
                    lt3.b(obj);
                    return fw4.a;
                }
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            lt3.b(obj);
            pw2 pw2Var2 = MPV.this.intFlow;
            i73 i73VarA2 = fu4.a(this.$property, hl.d((int) this.$value));
            this.label = 2;
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$eventProperty$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @ra0(c = "is.xyz.mpv.MPV$eventProperty$4", f = "MPV.kt", l = {326}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends oj4 implements Function2<u40, f30, Object> {
        final /* synthetic */ String $property;
        final /* synthetic */ boolean $value;
        int label;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(String str, boolean z, f30 f30Var) {
            super(2, f30Var);
            this.$property = str;
            this.$value = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return MPV.this.new AnonymousClass4(this.$property, this.$value, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((AnonymousClass4) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.label;
            if (i == 0) {
                lt3.b(obj);
                pw2 pw2Var = MPV.this.booleanFlow;
                i73 i73VarA = fu4.a(this.$property, hl.a(this.$value));
                this.label = 1;
                if (pw2Var.emit(i73VarA, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
            }
            return fw4.a;
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$eventProperty$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @ra0(c = "is.xyz.mpv.MPV$eventProperty$6", f = "MPV.kt", l = {335, 336}, m = "invokeSuspend")
    public static final class AnonymousClass6 extends oj4 implements Function2<u40, f30, Object> {
        final /* synthetic */ String $property;
        final /* synthetic */ double $value;
        int label;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(String str, double d, f30 f30Var) {
            super(2, f30Var);
            this.$property = str;
            this.$value = d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return MPV.this.new AnonymousClass6(this.$property, this.$value, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((AnonymousClass6) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
        
            if (r7.emit(r1, r6) == r0) goto L15;
         */
        @Override // defpackage.hh
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.label;
            if (i == 0) {
                lt3.b(obj);
                pw2 pw2Var = MPV.this.doubleFlow;
                i73 i73VarA = fu4.a(this.$property, hl.b(this.$value));
                this.label = 1;
                if (pw2Var.emit(i73VarA, this) != objE) {
                }
                return objE;
            }
            if (i != 1) {
                if (i == 2) {
                    lt3.b(obj);
                    return fw4.a;
                }
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            lt3.b(obj);
            pw2 pw2Var2 = MPV.this.floatFlow;
            i73 i73VarA2 = fu4.a(this.$property, hl.c((float) this.$value));
            this.label = 2;
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$eventProperty$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @ra0(c = "is.xyz.mpv.MPV$eventProperty$8", f = "MPV.kt", l = {345}, m = "invokeSuspend")
    public static final class AnonymousClass8 extends oj4 implements Function2<u40, f30, Object> {
        final /* synthetic */ String $property;
        final /* synthetic */ String $value;
        int label;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(String str, String str2, f30 f30Var) {
            super(2, f30Var);
            this.$property = str;
            this.$value = str2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return MPV.this.new AnonymousClass8(this.$property, this.$value, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((AnonymousClass8) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.label;
            if (i == 0) {
                lt3.b(obj);
                pw2 pw2Var = MPV.this.stringFlow;
                i73 i73VarA = fu4.a(this.$property, this.$value);
                this.label = 1;
                if (pw2Var.emit(i73VarA, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
            }
            return fw4.a;
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$logMessage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @ra0(c = "is.xyz.mpv.MPV$logMessage$2", f = "MPV.kt", l = {377}, m = "invokeSuspend")
    public static final class C01482 extends oj4 implements Function2<u40, f30, Object> {
        final /* synthetic */ int $level;
        final /* synthetic */ String $prefix;
        final /* synthetic */ String $text;
        int label;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01482(String str, int i, String str2, f30 f30Var) {
            super(2, f30Var);
            this.$prefix = str;
            this.$level = i;
            this.$text = str2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return MPV.this.new C01482(this.$prefix, this.$level, this.$text, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((C01482) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.label;
            if (i == 0) {
                lt3.b(obj);
                pw2 logFlow = MPV.this.getLogFlow();
                pt4 pt4Var = new pt4(this.$prefix, hl.d(this.$level), this.$text);
                this.label = 1;
                if (logFlow.emit(pt4Var, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
            }
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class mpvEvent {
        public static final mpvEvent INSTANCE = new mpvEvent();
        public static final int MPV_EVENT_AUDIO_RECONFIG = 18;
        public static final int MPV_EVENT_CLIENT_MESSAGE = 16;
        public static final int MPV_EVENT_COMMAND_REPLY = 5;
        public static final int MPV_EVENT_END_FILE = 7;
        public static final int MPV_EVENT_FILE_LOADED = 8;
        public static final int MPV_EVENT_GET_PROPERTY_REPLY = 3;
        public static final int MPV_EVENT_HOOK = 25;
        public static final int MPV_EVENT_IDLE = 11;
        public static final int MPV_EVENT_LOG_MESSAGE = 2;
        public static final int MPV_EVENT_NONE = 0;
        public static final int MPV_EVENT_PLAYBACK_RESTART = 21;
        public static final int MPV_EVENT_PROPERTY_CHANGE = 22;
        public static final int MPV_EVENT_QUEUE_OVERFLOW = 24;
        public static final int MPV_EVENT_SEEK = 20;
        public static final int MPV_EVENT_SET_PROPERTY_REPLY = 4;
        public static final int MPV_EVENT_SHUTDOWN = 1;
        public static final int MPV_EVENT_START_FILE = 6;
        public static final int MPV_EVENT_TICK = 14;
        public static final int MPV_EVENT_VIDEO_RECONFIG = 17;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private mpvEvent() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void getMPV_EVENT_IDLE$annotations() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void getMPV_EVENT_TICK$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class mpvFormat {
        public static final mpvFormat INSTANCE = new mpvFormat();
        public static final int MPV_FORMAT_BYTE_ARRAY = 9;
        public static final int MPV_FORMAT_DOUBLE = 5;
        public static final int MPV_FORMAT_FLAG = 3;
        public static final int MPV_FORMAT_INT64 = 4;
        public static final int MPV_FORMAT_NODE = 6;
        public static final int MPV_FORMAT_NODE_ARRAY = 7;
        public static final int MPV_FORMAT_NODE_MAP = 8;
        public static final int MPV_FORMAT_NONE = 0;
        public static final int MPV_FORMAT_OSD_STRING = 2;
        public static final int MPV_FORMAT_STRING = 1;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private mpvFormat() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class mpvLogLevel {
        public static final mpvLogLevel INSTANCE = new mpvLogLevel();
        public static final int MPV_LOG_LEVEL_DEBUG = 60;
        public static final int MPV_LOG_LEVEL_ERROR = 20;
        public static final int MPV_LOG_LEVEL_FATAL = 10;
        public static final int MPV_LOG_LEVEL_INFO = 40;
        public static final int MPV_LOG_LEVEL_NONE = 0;
        public static final int MPV_LOG_LEVEL_TRACE = 70;
        public static final int MPV_LOG_LEVEL_V = 50;
        public static final int MPV_LOG_LEVEL_WARN = 30;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private mpvLogLevel() {
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$prop$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class AnonymousClass1 extends t81 implements Function1<String, Integer> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AnonymousClass1(Object obj) {
            super(1, obj, MPV.class, "getPropertyInt", "getPropertyInt(Ljava/lang/String;)Ljava/lang/Integer;", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(String str) {
            str.getClass();
            return ((MPV) this.receiver).getPropertyInt(str);
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$prop$11, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class AnonymousClass11 extends t81 implements Function1<String, String> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AnonymousClass11(Object obj) {
            super(1, obj, MPV.class, "getPropertyString", "getPropertyString(Ljava/lang/String;)Ljava/lang/String;", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(String str) {
            str.getClass();
            return ((MPV) this.receiver).getPropertyString(str);
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$prop$13, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class AnonymousClass13 extends t81 implements Function1<String, MPVNode> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AnonymousClass13(Object obj) {
            super(1, obj, MPV.class, "getPropertyNode", "getPropertyNode(Ljava/lang/String;)Lis/xyz/mpv/MPVNode;", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function1
        public final MPVNode invoke(String str) {
            str.getClass();
            return ((MPV) this.receiver).getPropertyNode(str);
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$prop$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class AnonymousClass3 extends t81 implements Function1<String, Long> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AnonymousClass3(Object obj) {
            super(1, obj, MPV.class, "getPropertyLong", "getPropertyLong(Ljava/lang/String;)Ljava/lang/Long;", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function1
        public final Long invoke(String str) {
            str.getClass();
            return ((MPV) this.receiver).getPropertyLong(str);
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$prop$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class AnonymousClass5 extends t81 implements Function1<String, Float> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AnonymousClass5(Object obj) {
            super(1, obj, MPV.class, "getPropertyFloat", "getPropertyFloat(Ljava/lang/String;)Ljava/lang/Float;", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function1
        public final Float invoke(String str) {
            str.getClass();
            return ((MPV) this.receiver).getPropertyFloat(str);
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$prop$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class AnonymousClass7 extends t81 implements Function1<String, Double> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AnonymousClass7(Object obj) {
            super(1, obj, MPV.class, "getPropertyDouble", "getPropertyDouble(Ljava/lang/String;)Ljava/lang/Double;", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function1
        public final Double invoke(String str) {
            str.getClass();
            return ((MPV) this.receiver).getPropertyDouble(str);
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$prop$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class AnonymousClass9 extends t81 implements Function1<String, Boolean> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AnonymousClass9(Object obj) {
            super(1, obj, MPV.class, "getPropertyBoolean", "getPropertyBoolean(Ljava/lang/String;)Ljava/lang/Boolean;", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(String str) {
            str.getClass();
            return ((MPV) this.receiver).getPropertyBoolean(str);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        String[] strArr = {"mpv", "player"};
        for (int i = 0; i < 2; i++) {
            System.loadLibrary(strArr[i]);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void event(int i, MPVNode mPVNode) {
        synchronized (this.observers) {
            try {
                Iterator<EventObserver> it = this.observers.iterator();
                while (it.hasNext()) {
                    it.next().event(i, mPVNode);
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        dm.b(this.sessionScope, null, null, new AnonymousClass2(i, null), 3, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void eventProperty(String str, long j) {
        synchronized (this.observers) {
            try {
                Iterator<EventObserver> it = this.observers.iterator();
                while (it.hasNext()) {
                    it.next().eventProperty(str, j);
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        dm.b(this.sessionScope, null, null, new C01472(str, j, null), 3, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static /* synthetic */ void getNativeHandle$annotations() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public final <T> ce4 getOrCreateState(String str, int i, Function0<? extends ce4> function0) {
        Map<String, ce4> map = this.stateCache;
        ce4 ce4VarInvoke = map.get(str);
        if (ce4VarInvoke == null) {
            this.observedProperties.put(str, Integer.valueOf(i));
            if (isInitialized()) {
                observeProperty(str, i);
            }
            ce4VarInvoke = function0.invoke();
            map.put(str, ce4VarInvoke);
        }
        ce4VarInvoke.getClass();
        return ce4VarInvoke;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void logMessage(String str, int i, String str2) {
        synchronized (this.log_observers) {
            try {
                Iterator<LogObserver> it = this.log_observers.iterator();
                while (it.hasNext()) {
                    it.next().logMessage(str, i, str2);
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        dm.b(this.sessionScope, null, null, new C01482(str, i, str2, null), 3, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void addLogObserver(LogObserver logObserver) {
        logObserver.getClass();
        synchronized (this.log_observers) {
            this.log_observers.add(logObserver);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void addObserver(EventObserver eventObserver) {
        eventObserver.getClass();
        synchronized (this.observers) {
            this.observers.add(eventObserver);
        }
    }

    public final native void attachSurface(Surface surface);

    public final native void command(String... strArr);

    public final native MPVNode commandNode(String... strArr);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void create(Context context) {
        context.getClass();
        nativeCreate(context);
        initSession();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void destroy() {
        destroySession();
        nativeDestroy();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void destroySession() {
        v40.c(this.sessionScope, null, 1, null);
        this.stateCache.clear();
        this.observedProperties.clear();
    }

    public final native void detachSurface();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final pw2 getLogFlow() {
        return this.logFlow;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final PropertyAccessor getProp() {
        return this.prop;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final PropertyFlowAccessor getPropFlow() {
        return this.propFlow;
    }

    public final native Boolean getPropertyBoolean(String str);

    public final native Double getPropertyDouble(String str);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Float getPropertyFloat(String str) {
        str.getClass();
        Double propertyDouble = getPropertyDouble(str);
        if (propertyDouble != null) {
            return Float.valueOf((float) propertyDouble.doubleValue());
        }
        return null;
    }

    public final native Integer getPropertyInt(String str);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Long getPropertyLong(String str) {
        str.getClass();
        if (getPropertyInt(str) != null) {
            return Long.valueOf(r0.intValue());
        }
        return null;
    }

    public final native MPVNode getPropertyNode(String str);

    public final native String getPropertyString(String str);

    public final native Bitmap grabThumbnail(int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void init() {
        nativeInit();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void initSession() {
        for (Map.Entry<String, Integer> entry : this.observedProperties.entrySet()) {
            observeProperty(entry.getKey(), entry.getValue().intValue());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean isInitialized() {
        return this.nativeHandle != 0;
    }

    public final native void nativeCreate(Context context);

    public final native void nativeDestroy();

    public final native void nativeInit();

    public final native void observeProperty(String str, int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ <T> PropertyDelegate<T> prop(String str) {
        str.getClass();
        il1.d(4, "T");
        hp1 hp1VarB = np3.b(Object.class);
        if (il1.a(hp1VarB, np3.b(Integer.TYPE))) {
            return new PropertyDelegate<>(this, str, new AnonymousClass1(this), new C01512(this));
        }
        if (il1.a(hp1VarB, np3.b(Long.TYPE))) {
            return new PropertyDelegate<>(this, str, new AnonymousClass3(this), new C01524(this));
        }
        if (il1.a(hp1VarB, np3.b(Float.TYPE))) {
            return new PropertyDelegate<>(this, str, new AnonymousClass5(this), new C01536(this));
        }
        if (il1.a(hp1VarB, np3.b(Double.TYPE))) {
            return new PropertyDelegate<>(this, str, new AnonymousClass7(this), new C01548(this));
        }
        if (il1.a(hp1VarB, np3.b(Boolean.TYPE))) {
            return new PropertyDelegate<>(this, str, new AnonymousClass9(this), new C014910(this));
        }
        if (il1.a(hp1VarB, np3.b(String.class))) {
            return new PropertyDelegate<>(this, str, new AnonymousClass11(this), new C015012(this));
        }
        if (il1.a(hp1VarB, np3.b(MPVNode.class))) {
            return new PropertyDelegate<>(this, str, new AnonymousClass13(this), new AnonymousClass14(this));
        }
        il1.d(4, "T");
        nl.a("Unsupported property type: ", np3.b(Object.class));
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ <T> ce4 propFlow(String str) {
        ce4 nodeFlow;
        str.getClass();
        PropertyFlowAccessor propFlow = getPropFlow();
        il1.d(4, "T?");
        hp1 hp1VarB = np3.b(Object.class);
        if (il1.a(hp1VarB, np3.b(Integer.TYPE))) {
            nodeFlow = propFlow.getIntFlow(str);
        } else if (il1.a(hp1VarB, np3.b(Long.TYPE))) {
            nodeFlow = propFlow.getLongFlow(str);
        } else if (il1.a(hp1VarB, np3.b(Float.TYPE))) {
            nodeFlow = propFlow.getFloatFlow(str);
        } else if (il1.a(hp1VarB, np3.b(Double.TYPE))) {
            nodeFlow = propFlow.getDoubleFlow(str);
        } else if (il1.a(hp1VarB, np3.b(Boolean.TYPE))) {
            nodeFlow = propFlow.getBooleanFlow(str);
        } else if (il1.a(hp1VarB, np3.b(String.class))) {
            nodeFlow = propFlow.getStringFlow(str);
        } else {
            if (!il1.a(hp1VarB, np3.b(MPVNode.class))) {
                il1.d(4, "T?");
                nl.a("Unsupported property type: ", np3.b(Object.class));
                return null;
            }
            nodeFlow = propFlow.getNodeFlow(str);
        }
        nodeFlow.getClass();
        return nodeFlow;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void removeLogObserver(LogObserver logObserver) {
        logObserver.getClass();
        synchronized (this.log_observers) {
            this.log_observers.remove(logObserver);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void removeObserver(EventObserver eventObserver) {
        eventObserver.getClass();
        synchronized (this.observers) {
            this.observers.remove(eventObserver);
        }
    }

    public final native int setOptionString(String str, String str2);

    public final native void setPropertyBoolean(String str, boolean z);

    public final native void setPropertyDouble(String str, double d);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void setPropertyFloat(String str, float f) {
        str.getClass();
        setPropertyDouble(str, f);
    }

    public final native void setPropertyInt(String str, int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void setPropertyLong(String str, long j) {
        str.getClass();
        setPropertyInt(str, (int) j);
    }

    public final native void setPropertyNode(String str, MPVNode mPVNode);

    public final native void setPropertyString(String str, String str2);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: is.xyz.mpv.MPV.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$prop$10, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class C014910 extends t81 implements Function2<String, Boolean, fw4> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C014910(Object obj) {
            super(2, obj, MPV.class, "setPropertyBoolean", "setPropertyBoolean(Ljava/lang/String;Z)V", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ fw4 invoke(String str, Boolean bool) {
            invoke(str, bool.booleanValue());
            return fw4.a;
        }

        public final void invoke(String str, boolean z) {
            str.getClass();
            ((MPV) this.receiver).setPropertyBoolean(str, z);
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$prop$12, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class C015012 extends t81 implements Function2<String, String, fw4> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C015012(Object obj) {
            super(2, obj, MPV.class, "setPropertyString", "setPropertyString(Ljava/lang/String;Ljava/lang/String;)V", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str, String str2) {
            str.getClass();
            str2.getClass();
            ((MPV) this.receiver).setPropertyString(str, str2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ fw4 invoke(String str, String str2) {
            invoke2(str, str2);
            return fw4.a;
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$prop$14, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class AnonymousClass14 extends t81 implements Function2<String, MPVNode, fw4> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AnonymousClass14(Object obj) {
            super(2, obj, MPV.class, "setPropertyNode", "setPropertyNode(Ljava/lang/String;Lis/xyz/mpv/MPVNode;)V", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str, MPVNode mPVNode) {
            str.getClass();
            mPVNode.getClass();
            ((MPV) this.receiver).setPropertyNode(str, mPVNode);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ fw4 invoke(String str, MPVNode mPVNode) {
            invoke2(str, mPVNode);
            return fw4.a;
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$prop$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class C01512 extends t81 implements Function2<String, Integer, fw4> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C01512(Object obj) {
            super(2, obj, MPV.class, "setPropertyInt", "setPropertyInt(Ljava/lang/String;I)V", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ fw4 invoke(String str, Integer num) {
            invoke(str, num.intValue());
            return fw4.a;
        }

        public final void invoke(String str, int i) {
            str.getClass();
            ((MPV) this.receiver).setPropertyInt(str, i);
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$prop$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class C01524 extends t81 implements Function2<String, Long, fw4> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C01524(Object obj) {
            super(2, obj, MPV.class, "setPropertyLong", "setPropertyLong(Ljava/lang/String;J)V", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ fw4 invoke(String str, Long l) {
            invoke(str, l.longValue());
            return fw4.a;
        }

        public final void invoke(String str, long j) {
            str.getClass();
            ((MPV) this.receiver).setPropertyLong(str, j);
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$prop$6, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class C01536 extends t81 implements Function2<String, Float, fw4> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C01536(Object obj) {
            super(2, obj, MPV.class, "setPropertyFloat", "setPropertyFloat(Ljava/lang/String;F)V", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ fw4 invoke(String str, Float f) {
            invoke(str, f.floatValue());
            return fw4.a;
        }

        public final void invoke(String str, float f) {
            str.getClass();
            ((MPV) this.receiver).setPropertyFloat(str, f);
        }
    }

    /* JADX INFO: renamed from: is.xyz.mpv.MPV$prop$8, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class C01548 extends t81 implements Function2<String, Double, fw4> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C01548(Object obj) {
            super(2, obj, MPV.class, "setPropertyDouble", "setPropertyDouble(Ljava/lang/String;D)V", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ fw4 invoke(String str, Double d) {
            invoke(str, d.doubleValue());
            return fw4.a;
        }

        public final void invoke(String str, double d) {
            str.getClass();
            ((MPV) this.receiver).setPropertyDouble(str, d);
        }
    }

    private final void eventProperty(String str, boolean z) {
        synchronized (this.observers) {
            try {
                Iterator<EventObserver> it = this.observers.iterator();
                while (it.hasNext()) {
                    it.next().eventProperty(str, z);
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        dm.b(this.sessionScope, null, null, new AnonymousClass4(str, z, null), 3, null);
    }

    private final void eventProperty(String str, double d) {
        synchronized (this.observers) {
            try {
                Iterator<EventObserver> it = this.observers.iterator();
                while (it.hasNext()) {
                    it.next().eventProperty(str, d);
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        dm.b(this.sessionScope, null, null, new AnonymousClass6(str, d, null), 3, null);
    }

    private final void eventProperty(String str, String str2) {
        synchronized (this.observers) {
            try {
                Iterator<EventObserver> it = this.observers.iterator();
                while (it.hasNext()) {
                    it.next().eventProperty(str, str2);
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        dm.b(this.sessionScope, null, null, new AnonymousClass8(str, str2, null), 3, null);
    }

    private final void eventProperty(String str, MPVNode mPVNode) {
        synchronized (this.observers) {
            try {
                Iterator<EventObserver> it = this.observers.iterator();
                while (it.hasNext()) {
                    it.next().eventProperty(str, mPVNode);
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        dm.b(this.sessionScope, null, null, new AnonymousClass10(str, mPVNode, null), 3, null);
    }

    private final void eventProperty(String str) {
        synchronized (this.observers) {
            try {
                Iterator<EventObserver> it = this.observers.iterator();
                while (it.hasNext()) {
                    it.next().eventProperty(str);
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        dm.b(this.sessionScope, null, null, new AnonymousClass12(str, null), 3, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> void prop(String str, T t) {
        str.getClass();
        il1.d(4, "T");
        hp1 hp1VarB = np3.b(Object.class);
        if (il1.a(hp1VarB, np3.b(Integer.TYPE))) {
            t.getClass();
            setPropertyInt(str, ((Integer) t).intValue());
            return;
        }
        if (il1.a(hp1VarB, np3.b(Long.TYPE))) {
            t.getClass();
            setPropertyLong(str, ((Long) t).longValue());
            return;
        }
        if (il1.a(hp1VarB, np3.b(Float.TYPE))) {
            t.getClass();
            setPropertyFloat(str, ((Float) t).floatValue());
            return;
        }
        if (il1.a(hp1VarB, np3.b(Double.TYPE))) {
            t.getClass();
            setPropertyDouble(str, ((Double) t).doubleValue());
            return;
        }
        if (il1.a(hp1VarB, np3.b(Boolean.TYPE))) {
            t.getClass();
            setPropertyBoolean(str, ((Boolean) t).booleanValue());
        } else if (il1.a(hp1VarB, np3.b(String.class))) {
            t.getClass();
            setPropertyString(str, (String) t);
        } else if (il1.a(hp1VarB, np3.b(MPVNode.class))) {
            t.getClass();
            setPropertyNode(str, (MPVNode) t);
        } else {
            il1.d(4, "T");
            nl.a("Unsupported property type: ", np3.b(Object.class));
        }
    }
}
