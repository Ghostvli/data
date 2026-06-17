package org.schabi.newpipe.extractor.services.youtube.protos.playlist;

import defpackage.hn;
import defpackage.hv;
import defpackage.i91;
import defpackage.n83;
import defpackage.p0;
import defpackage.rs2;
import defpackage.ss2;
import defpackage.xy0;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class PlaylistProtobufContinuation {

    /* JADX INFO: renamed from: org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[i91.e.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[i91.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[i91.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[i91.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[i91.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[i91.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[i91.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[i91.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface ContinuationParamsOrBuilder extends ss2 {
        String getBrowseId();

        hn getBrowseIdBytes();

        String getContinuationProperties();

        hn getContinuationPropertiesBytes();

        @Override // defpackage.ss2
        /* synthetic */ rs2 getDefaultInstanceForType();

        String getPlaylistId();

        hn getPlaylistIdBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface PlaylistContinuationOrBuilder extends ss2 {
        @Override // defpackage.ss2
        /* synthetic */ rs2 getDefaultInstanceForType();

        ContinuationParams getParameters();

        boolean hasParameters();

        /* synthetic */ boolean isInitialized();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private PlaylistProtobufContinuation() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void registerAllExtensions(xy0 xy0Var) {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class ContinuationParams extends i91 implements ContinuationParamsOrBuilder {
        public static final int BROWSEID_FIELD_NUMBER = 2;
        public static final int CONTINUATIONPROPERTIES_FIELD_NUMBER = 3;
        private static final ContinuationParams DEFAULT_INSTANCE;
        private static volatile n83 PARSER = null;
        public static final int PLAYLISTID_FIELD_NUMBER = 35;
        private String browseId_ = "";
        private String continuationProperties_ = "";
        private String playlistId_ = "";

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class Builder extends i91.a implements ContinuationParamsOrBuilder {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            private Builder() {
                super(ContinuationParams.DEFAULT_INSTANCE);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public Builder clearBrowseId() {
                copyOnWrite();
                ((ContinuationParams) this.instance).clearBrowseId();
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public Builder clearContinuationProperties() {
                copyOnWrite();
                ((ContinuationParams) this.instance).clearContinuationProperties();
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public Builder clearPlaylistId() {
                copyOnWrite();
                ((ContinuationParams) this.instance).clearPlaylistId();
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
            public String getBrowseId() {
                return ((ContinuationParams) this.instance).getBrowseId();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
            public hn getBrowseIdBytes() {
                return ((ContinuationParams) this.instance).getBrowseIdBytes();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
            public String getContinuationProperties() {
                return ((ContinuationParams) this.instance).getContinuationProperties();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
            public hn getContinuationPropertiesBytes() {
                return ((ContinuationParams) this.instance).getContinuationPropertiesBytes();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
            public String getPlaylistId() {
                return ((ContinuationParams) this.instance).getPlaylistId();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
            public hn getPlaylistIdBytes() {
                return ((ContinuationParams) this.instance).getPlaylistIdBytes();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public Builder setBrowseId(String str) {
                copyOnWrite();
                ((ContinuationParams) this.instance).setBrowseId(str);
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public Builder setBrowseIdBytes(hn hnVar) {
                copyOnWrite();
                ((ContinuationParams) this.instance).setBrowseIdBytes(hnVar);
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public Builder setContinuationProperties(String str) {
                copyOnWrite();
                ((ContinuationParams) this.instance).setContinuationProperties(str);
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public Builder setContinuationPropertiesBytes(hn hnVar) {
                copyOnWrite();
                ((ContinuationParams) this.instance).setContinuationPropertiesBytes(hnVar);
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public Builder setPlaylistId(String str) {
                copyOnWrite();
                ((ContinuationParams) this.instance).setPlaylistId(str);
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public Builder setPlaylistIdBytes(hn hnVar) {
                copyOnWrite();
                ((ContinuationParams) this.instance).setPlaylistIdBytes(hnVar);
                return this;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            ContinuationParams continuationParams = new ContinuationParams();
            DEFAULT_INSTANCE = continuationParams;
            i91.registerDefaultInstance(ContinuationParams.class, continuationParams);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private ContinuationParams() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public void clearBrowseId() {
            this.browseId_ = getDefaultInstance().getBrowseId();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public void clearContinuationProperties() {
            this.continuationProperties_ = getDefaultInstance().getContinuationProperties();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public void clearPlaylistId() {
            this.playlistId_ = getDefaultInstance().getPlaylistId();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static ContinuationParams getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static ContinuationParams parseDelimitedFrom(InputStream inputStream) {
            return (ContinuationParams) i91.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static ContinuationParams parseFrom(ByteBuffer byteBuffer) {
            return (ContinuationParams) i91.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static n83 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public void setBrowseId(String str) {
            str.getClass();
            this.browseId_ = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public void setBrowseIdBytes(hn hnVar) {
            p0.checkByteStringIsUtf8(hnVar);
            this.browseId_ = hnVar.A();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public void setContinuationProperties(String str) {
            str.getClass();
            this.continuationProperties_ = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public void setContinuationPropertiesBytes(hn hnVar) {
            p0.checkByteStringIsUtf8(hnVar);
            this.continuationProperties_ = hnVar.A();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public void setPlaylistId(String str) {
            str.getClass();
            this.playlistId_ = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public void setPlaylistIdBytes(hn hnVar) {
            p0.checkByteStringIsUtf8(hnVar);
            this.playlistId_ = hnVar.A();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i91
        public final Object dynamicMethod(i91.e eVar, Object obj, Object obj2) {
            n83 bVar;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[eVar.ordinal()];
            switch (i) {
                case 1:
                    return new ContinuationParams();
                case 2:
                    return new Builder();
                case 3:
                    return i91.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0002#\u0003\u0000\u0000\u0000\u0002Ȉ\u0003Ȉ#Ȉ", new Object[]{"browseId_", "continuationProperties_", "playlistId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    n83 n83Var = PARSER;
                    if (n83Var != null) {
                        return n83Var;
                    }
                    synchronized (ContinuationParams.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new i91.b(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return bVar;
                case 6:
                    return (byte) 1;
                default:
                    throw null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
        public String getBrowseId() {
            return this.browseId_;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
        public hn getBrowseIdBytes() {
            return hn.g(this.browseId_);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
        public String getContinuationProperties() {
            return this.continuationProperties_;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
        public hn getContinuationPropertiesBytes() {
            return hn.g(this.continuationProperties_);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
        public String getPlaylistId() {
            return this.playlistId_;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
        public hn getPlaylistIdBytes() {
            return hn.g(this.playlistId_);
        }

        public static Builder newBuilder(ContinuationParams continuationParams) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(continuationParams);
        }

        public static ContinuationParams parseDelimitedFrom(InputStream inputStream, xy0 xy0Var) {
            return (ContinuationParams) i91.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, xy0Var);
        }

        public static ContinuationParams parseFrom(ByteBuffer byteBuffer, xy0 xy0Var) {
            return (ContinuationParams) i91.parseFrom(DEFAULT_INSTANCE, byteBuffer, xy0Var);
        }

        public static ContinuationParams parseFrom(hn hnVar) {
            return (ContinuationParams) i91.parseFrom(DEFAULT_INSTANCE, hnVar);
        }

        public static ContinuationParams parseFrom(hn hnVar, xy0 xy0Var) {
            return (ContinuationParams) i91.parseFrom(DEFAULT_INSTANCE, hnVar, xy0Var);
        }

        public static ContinuationParams parseFrom(byte[] bArr) {
            return (ContinuationParams) i91.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ContinuationParams parseFrom(byte[] bArr, xy0 xy0Var) {
            return (ContinuationParams) i91.parseFrom(DEFAULT_INSTANCE, bArr, xy0Var);
        }

        public static ContinuationParams parseFrom(InputStream inputStream) {
            return (ContinuationParams) i91.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ContinuationParams parseFrom(InputStream inputStream, xy0 xy0Var) {
            return (ContinuationParams) i91.parseFrom(DEFAULT_INSTANCE, inputStream, xy0Var);
        }

        public static ContinuationParams parseFrom(hv hvVar) {
            return (ContinuationParams) i91.parseFrom(DEFAULT_INSTANCE, hvVar);
        }

        public static ContinuationParams parseFrom(hv hvVar, xy0 xy0Var) {
            return (ContinuationParams) i91.parseFrom(DEFAULT_INSTANCE, hvVar, xy0Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class PlaylistContinuation extends i91 implements PlaylistContinuationOrBuilder {
        private static final PlaylistContinuation DEFAULT_INSTANCE;
        public static final int PARAMETERS_FIELD_NUMBER = 80226972;
        private static volatile n83 PARSER;
        private int bitField0_;
        private ContinuationParams parameters_;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            PlaylistContinuation playlistContinuation = new PlaylistContinuation();
            DEFAULT_INSTANCE = playlistContinuation;
            i91.registerDefaultInstance(PlaylistContinuation.class, playlistContinuation);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private PlaylistContinuation() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public void clearParameters() {
            this.parameters_ = null;
            this.bitField0_ &= -2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static PlaylistContinuation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public void mergeParameters(ContinuationParams continuationParams) {
            continuationParams.getClass();
            ContinuationParams continuationParams2 = this.parameters_;
            if (continuationParams2 == null || continuationParams2 == ContinuationParams.getDefaultInstance()) {
                this.parameters_ = continuationParams;
            } else {
                this.parameters_ = (ContinuationParams) ((ContinuationParams.Builder) ContinuationParams.newBuilder(this.parameters_).mergeFrom((i91) continuationParams)).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static PlaylistContinuation parseDelimitedFrom(InputStream inputStream) {
            return (PlaylistContinuation) i91.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static PlaylistContinuation parseFrom(ByteBuffer byteBuffer) {
            return (PlaylistContinuation) i91.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static n83 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX INFO: Access modifiers changed from: private */
        public void setParameters(ContinuationParams continuationParams) {
            continuationParams.getClass();
            this.parameters_ = continuationParams;
            this.bitField0_ |= 1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i91
        public final Object dynamicMethod(i91.e eVar, Object obj, Object obj2) {
            n83 bVar;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[eVar.ordinal()];
            switch (i) {
                case 1:
                    return new PlaylistContinuation();
                case 2:
                    return new Builder();
                case 3:
                    return i91.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\uea9c♁\uea9c♁\u0001\u0000\u0000\u0000\uea9c♁ဉ\u0000", new Object[]{"bitField0_", "parameters_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    n83 n83Var = PARSER;
                    if (n83Var != null) {
                        return n83Var;
                    }
                    synchronized (PlaylistContinuation.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new i91.b(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return bVar;
                case 6:
                    return (byte) 1;
                default:
                    throw null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.PlaylistContinuationOrBuilder
        public ContinuationParams getParameters() {
            ContinuationParams continuationParams = this.parameters_;
            return continuationParams == null ? ContinuationParams.getDefaultInstance() : continuationParams;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.PlaylistContinuationOrBuilder
        public boolean hasParameters() {
            return (this.bitField0_ & 1) != 0;
        }

        public static Builder newBuilder(PlaylistContinuation playlistContinuation) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(playlistContinuation);
        }

        public static PlaylistContinuation parseDelimitedFrom(InputStream inputStream, xy0 xy0Var) {
            return (PlaylistContinuation) i91.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, xy0Var);
        }

        public static PlaylistContinuation parseFrom(ByteBuffer byteBuffer, xy0 xy0Var) {
            return (PlaylistContinuation) i91.parseFrom(DEFAULT_INSTANCE, byteBuffer, xy0Var);
        }

        public static PlaylistContinuation parseFrom(hn hnVar) {
            return (PlaylistContinuation) i91.parseFrom(DEFAULT_INSTANCE, hnVar);
        }

        public static PlaylistContinuation parseFrom(hn hnVar, xy0 xy0Var) {
            return (PlaylistContinuation) i91.parseFrom(DEFAULT_INSTANCE, hnVar, xy0Var);
        }

        public static PlaylistContinuation parseFrom(byte[] bArr) {
            return (PlaylistContinuation) i91.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PlaylistContinuation parseFrom(byte[] bArr, xy0 xy0Var) {
            return (PlaylistContinuation) i91.parseFrom(DEFAULT_INSTANCE, bArr, xy0Var);
        }

        public static PlaylistContinuation parseFrom(InputStream inputStream) {
            return (PlaylistContinuation) i91.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PlaylistContinuation parseFrom(InputStream inputStream, xy0 xy0Var) {
            return (PlaylistContinuation) i91.parseFrom(DEFAULT_INSTANCE, inputStream, xy0Var);
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class Builder extends i91.a implements PlaylistContinuationOrBuilder {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            private Builder() {
                super(PlaylistContinuation.DEFAULT_INSTANCE);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public Builder clearParameters() {
                copyOnWrite();
                ((PlaylistContinuation) this.instance).clearParameters();
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.PlaylistContinuationOrBuilder
            public ContinuationParams getParameters() {
                return ((PlaylistContinuation) this.instance).getParameters();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.PlaylistContinuationOrBuilder
            public boolean hasParameters() {
                return ((PlaylistContinuation) this.instance).hasParameters();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public Builder mergeParameters(ContinuationParams continuationParams) {
                copyOnWrite();
                ((PlaylistContinuation) this.instance).mergeParameters(continuationParams);
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public Builder setParameters(ContinuationParams.Builder builder) {
                copyOnWrite();
                ((PlaylistContinuation) this.instance).setParameters((ContinuationParams) builder.m3build());
                return this;
            }

            public Builder setParameters(ContinuationParams continuationParams) {
                copyOnWrite();
                ((PlaylistContinuation) this.instance).setParameters(continuationParams);
                return this;
            }
        }

        public static PlaylistContinuation parseFrom(hv hvVar) {
            return (PlaylistContinuation) i91.parseFrom(DEFAULT_INSTANCE, hvVar);
        }

        public static PlaylistContinuation parseFrom(hv hvVar, xy0 xy0Var) {
            return (PlaylistContinuation) i91.parseFrom(DEFAULT_INSTANCE, hvVar, xy0Var);
        }
    }
}
