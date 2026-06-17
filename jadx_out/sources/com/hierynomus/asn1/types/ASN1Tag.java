package com.hierynomus.asn1.types;

import com.hierynomus.asn1.ASN1ParseException;
import com.hierynomus.asn1.ASN1Parser;
import com.hierynomus.asn1.ASN1Serializer;
import com.hierynomus.asn1.encodingrules.ASN1Decoder;
import com.hierynomus.asn1.encodingrules.ASN1Encoder;
import com.hierynomus.asn1.types.ASN1Object;
import com.hierynomus.asn1.types.constructed.ASN1Sequence;
import com.hierynomus.asn1.types.constructed.ASN1Set;
import com.hierynomus.asn1.types.constructed.ASN1TaggedObject;
import com.hierynomus.asn1.types.primitive.ASN1Boolean;
import com.hierynomus.asn1.types.primitive.ASN1Enumerated;
import com.hierynomus.asn1.types.primitive.ASN1Integer;
import com.hierynomus.asn1.types.primitive.ASN1Null;
import com.hierynomus.asn1.types.primitive.ASN1ObjectIdentifier;
import com.hierynomus.asn1.types.string.ASN1BitString;
import com.hierynomus.asn1.types.string.ASN1OctetString;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ASN1Tag<T extends ASN1Object> {
    public static final ASN1Tag<ASN1BitString> BIT_STRING;
    public static final ASN1Tag<ASN1Boolean> BOOLEAN;
    public static final ASN1Tag<ASN1Enumerated> ENUMERATED;
    public static final ASN1Tag<ASN1Integer> INTEGER;
    public static final ASN1Tag<ASN1Null> NULL;
    public static final ASN1Tag<ASN1ObjectIdentifier> OBJECT_IDENTIFIER;
    public static final ASN1Tag<?> OCTET_STRING;
    public static final ASN1Tag<ASN1Sequence> SEQUENCE;
    public static final ASN1Tag<ASN1Set> SET;
    private static Map<Integer, ASN1Tag<?>> tags = new HashMap();
    private final ASN1Encoding asn1Encoding;
    private final ASN1TagClass asn1TagClass;
    private final Set<ASN1Encoding> supportedEncodings;
    private final int tag;

    /* JADX INFO: renamed from: com.hierynomus.asn1.types.ASN1Tag$12, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] $SwitchMap$com$hierynomus$asn1$types$ASN1TagClass;

        static {
            int[] iArr = new int[ASN1TagClass.values().length];
            $SwitchMap$com$hierynomus$asn1$types$ASN1TagClass = iArr;
            try {
                iArr[ASN1TagClass.UNIVERSAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hierynomus$asn1$types$ASN1TagClass[ASN1TagClass.APPLICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hierynomus$asn1$types$ASN1TagClass[ASN1TagClass.CONTEXT_SPECIFIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$hierynomus$asn1$types$ASN1TagClass[ASN1TagClass.PRIVATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        ASN1TagClass aSN1TagClass = ASN1TagClass.UNIVERSAL;
        ASN1Encoding aSN1Encoding = ASN1Encoding.PRIMITIVE;
        ASN1Tag<ASN1Boolean> aSN1Tag = new ASN1Tag<ASN1Boolean>(aSN1TagClass, 1, aSN1Encoding) { // from class: com.hierynomus.asn1.types.ASN1Tag.1
            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Parser<ASN1Boolean> newParser(ASN1Decoder aSN1Decoder) {
                return new ASN1Boolean.Parser(aSN1Decoder);
            }

            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Serializer<ASN1Boolean> newSerializer(ASN1Encoder aSN1Encoder) {
                return new ASN1Boolean.Serializer(aSN1Encoder);
            }
        };
        BOOLEAN = aSN1Tag;
        ASN1Tag<ASN1Integer> aSN1Tag2 = new ASN1Tag<ASN1Integer>(aSN1TagClass, 2, aSN1Encoding) { // from class: com.hierynomus.asn1.types.ASN1Tag.2
            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Parser<ASN1Integer> newParser(ASN1Decoder aSN1Decoder) {
                return new ASN1Integer.Parser(aSN1Decoder);
            }

            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Serializer<ASN1Integer> newSerializer(ASN1Encoder aSN1Encoder) {
                return new ASN1Integer.Serializer(aSN1Encoder);
            }
        };
        INTEGER = aSN1Tag2;
        ASN1Encoding aSN1Encoding2 = ASN1Encoding.CONSTRUCTED;
        ASN1Tag<ASN1BitString> aSN1Tag3 = new ASN1Tag<ASN1BitString>(aSN1TagClass, 3, aSN1Encoding, EnumSet.of(aSN1Encoding, aSN1Encoding2)) { // from class: com.hierynomus.asn1.types.ASN1Tag.3
            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Parser<ASN1BitString> newParser(ASN1Decoder aSN1Decoder) {
                return new ASN1BitString.Parser(aSN1Decoder);
            }

            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Serializer<ASN1BitString> newSerializer(ASN1Encoder aSN1Encoder) {
                return new ASN1BitString.Serializer(aSN1Encoder);
            }
        };
        BIT_STRING = aSN1Tag3;
        ASN1Tag<?> aSN1Tag4 = new ASN1Tag(aSN1TagClass, 4, EnumSet.of(aSN1Encoding, aSN1Encoding2)) { // from class: com.hierynomus.asn1.types.ASN1Tag.4
            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Parser<?> newParser(ASN1Decoder aSN1Decoder) {
                return new ASN1OctetString.Parser(aSN1Decoder);
            }

            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Serializer newSerializer(ASN1Encoder aSN1Encoder) {
                return new ASN1OctetString.Serializer(aSN1Encoder);
            }
        };
        OCTET_STRING = aSN1Tag4;
        ASN1Tag<ASN1Null> aSN1Tag5 = new ASN1Tag<ASN1Null>(aSN1TagClass, 5, aSN1Encoding) { // from class: com.hierynomus.asn1.types.ASN1Tag.5
            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Parser<ASN1Null> newParser(ASN1Decoder aSN1Decoder) {
                return new ASN1Null.Parser(aSN1Decoder);
            }

            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Serializer<ASN1Null> newSerializer(ASN1Encoder aSN1Encoder) {
                return new ASN1Null.Serializer(aSN1Encoder);
            }
        };
        NULL = aSN1Tag5;
        ASN1Tag<ASN1ObjectIdentifier> aSN1Tag6 = new ASN1Tag<ASN1ObjectIdentifier>(aSN1TagClass, 6, aSN1Encoding) { // from class: com.hierynomus.asn1.types.ASN1Tag.6
            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Parser<ASN1ObjectIdentifier> newParser(ASN1Decoder aSN1Decoder) {
                return new ASN1ObjectIdentifier.Parser(aSN1Decoder);
            }

            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Serializer<ASN1ObjectIdentifier> newSerializer(ASN1Encoder aSN1Encoder) {
                return new ASN1ObjectIdentifier.Serializer(aSN1Encoder);
            }
        };
        OBJECT_IDENTIFIER = aSN1Tag6;
        ASN1Tag<ASN1Enumerated> aSN1Tag7 = new ASN1Tag<ASN1Enumerated>(aSN1TagClass, 10, aSN1Encoding) { // from class: com.hierynomus.asn1.types.ASN1Tag.7
            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Parser<ASN1Enumerated> newParser(ASN1Decoder aSN1Decoder) {
                return new ASN1Enumerated.Parser(aSN1Decoder);
            }

            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Serializer<ASN1Enumerated> newSerializer(ASN1Encoder aSN1Encoder) {
                return new ASN1Enumerated.Serializer(aSN1Encoder);
            }
        };
        ENUMERATED = aSN1Tag7;
        ASN1Tag<ASN1Set> aSN1Tag8 = new ASN1Tag<ASN1Set>(aSN1TagClass, 17, aSN1Encoding2) { // from class: com.hierynomus.asn1.types.ASN1Tag.8
            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Parser<ASN1Set> newParser(ASN1Decoder aSN1Decoder) {
                return new ASN1Set.Parser(aSN1Decoder);
            }

            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Serializer<ASN1Set> newSerializer(ASN1Encoder aSN1Encoder) {
                return new ASN1Set.Serializer(aSN1Encoder);
            }
        };
        SET = aSN1Tag8;
        ASN1Tag<ASN1Sequence> aSN1Tag9 = new ASN1Tag<ASN1Sequence>(aSN1TagClass, 16, aSN1Encoding2) { // from class: com.hierynomus.asn1.types.ASN1Tag.9
            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Parser<ASN1Sequence> newParser(ASN1Decoder aSN1Decoder) {
                return new ASN1Sequence.Parser(aSN1Decoder);
            }

            @Override // com.hierynomus.asn1.types.ASN1Tag
            public ASN1Serializer<ASN1Sequence> newSerializer(ASN1Encoder aSN1Encoder) {
                return new ASN1Sequence.Serializer(aSN1Encoder);
            }
        };
        SEQUENCE = aSN1Tag9;
        tags.put(Integer.valueOf(aSN1Tag.getTag()), aSN1Tag);
        tags.put(Integer.valueOf(aSN1Tag2.getTag()), aSN1Tag2);
        tags.put(Integer.valueOf(aSN1Tag3.getTag()), aSN1Tag3);
        tags.put(Integer.valueOf(aSN1Tag4.getTag()), aSN1Tag4);
        tags.put(Integer.valueOf(aSN1Tag5.getTag()), aSN1Tag5);
        tags.put(Integer.valueOf(aSN1Tag6.getTag()), aSN1Tag6);
        tags.put(Integer.valueOf(aSN1Tag7.getTag()), aSN1Tag7);
        tags.put(Integer.valueOf(aSN1Tag8.getTag()), aSN1Tag8);
        tags.put(Integer.valueOf(aSN1Tag9.getTag()), aSN1Tag9);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ASN1Tag(ASN1TagClass aSN1TagClass, int i, Set<ASN1Encoding> set) {
        ASN1Encoding aSN1Encoding = ASN1Encoding.PRIMITIVE;
        this(aSN1TagClass, i, set.contains(aSN1Encoding) ? aSN1Encoding : ASN1Encoding.CONSTRUCTED, set);
    }

    public static ASN1Tag application(int i) {
        return forTag(ASN1TagClass.APPLICATION, i);
    }

    public static ASN1Tag contextSpecific(int i) {
        return forTag(ASN1TagClass.CONTEXT_SPECIFIC, i);
    }

    public static ASN1Tag forTag(ASN1TagClass aSN1TagClass, int i) {
        int i2 = AnonymousClass12.$SwitchMap$com$hierynomus$asn1$types$ASN1TagClass[aSN1TagClass.ordinal()];
        if (i2 == 1) {
            for (ASN1Tag<?> aSN1Tag : tags.values()) {
                if (((ASN1Tag) aSN1Tag).tag == i && aSN1TagClass == ((ASN1Tag) aSN1Tag).asn1TagClass) {
                    return aSN1Tag;
                }
            }
        } else if (i2 == 2 || i2 == 3 || i2 == 4) {
            return new ASN1Tag(aSN1TagClass, i, EnumSet.of(ASN1Encoding.PRIMITIVE, ASN1Encoding.CONSTRUCTED)) { // from class: com.hierynomus.asn1.types.ASN1Tag.11
                @Override // com.hierynomus.asn1.types.ASN1Tag
                public ASN1Parser<?> newParser(ASN1Decoder aSN1Decoder) {
                    return new ASN1TaggedObject.Parser(aSN1Decoder);
                }

                @Override // com.hierynomus.asn1.types.ASN1Tag
                public ASN1Serializer newSerializer(ASN1Encoder aSN1Encoder) {
                    return new ASN1TaggedObject.Serializer(aSN1Encoder);
                }
            };
        }
        throw new ASN1ParseException(String.format("Unknown ASN.1 tag '%s:%s' found (%s)", aSN1TagClass, Integer.valueOf(i), tags));
    }

    public ASN1Tag<T> asEncoded(ASN1Encoding aSN1Encoding) {
        if (this.asn1Encoding == aSN1Encoding) {
            return this;
        }
        if (this.supportedEncodings.contains(aSN1Encoding)) {
            return (ASN1Tag<T>) new ASN1Tag<T>(this.asn1TagClass, this.tag, aSN1Encoding, this.supportedEncodings) { // from class: com.hierynomus.asn1.types.ASN1Tag.10
                @Override // com.hierynomus.asn1.types.ASN1Tag
                public ASN1Parser<T> newParser(ASN1Decoder aSN1Decoder) {
                    return ASN1Tag.this.newParser(aSN1Decoder);
                }

                @Override // com.hierynomus.asn1.types.ASN1Tag
                public ASN1Serializer<T> newSerializer(ASN1Encoder aSN1Encoder) {
                    return ASN1Tag.this.newSerializer(aSN1Encoder);
                }
            };
        }
        throw new IllegalArgumentException(String.format("The ASN.1 tag %s does not support encoding as %s", this, aSN1Encoding));
    }

    public ASN1Tag<T> constructed() {
        return asEncoded(ASN1Encoding.CONSTRUCTED);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ASN1Tag aSN1Tag = (ASN1Tag) obj;
            if (getTag() == aSN1Tag.getTag() && this.asn1TagClass == aSN1Tag.asn1TagClass && this.asn1Encoding == aSN1Tag.asn1Encoding) {
                return true;
            }
        }
        return false;
    }

    public ASN1Encoding getAsn1Encoding() {
        return this.asn1Encoding;
    }

    public ASN1TagClass getAsn1TagClass() {
        return this.asn1TagClass;
    }

    public EnumSet<ASN1Encoding> getSupportedEncodings() {
        return EnumSet.copyOf((Collection) this.supportedEncodings);
    }

    public int getTag() {
        return this.tag;
    }

    public int hashCode() {
        return Objects.hash(this.asn1TagClass, Integer.valueOf(getTag()), this.asn1Encoding);
    }

    public boolean isConstructed() {
        return this.asn1Encoding == ASN1Encoding.CONSTRUCTED;
    }

    public abstract ASN1Parser<T> newParser(ASN1Decoder aSN1Decoder);

    public abstract ASN1Serializer<T> newSerializer(ASN1Encoder aSN1Encoder);

    public ASN1Tag<T> primitive() {
        return asEncoded(ASN1Encoding.PRIMITIVE);
    }

    public String toString() {
        return "ASN1Tag[" + this.asn1TagClass + "," + this.asn1Encoding + "," + this.tag + ']';
    }

    public ASN1Tag(ASN1TagClass aSN1TagClass, int i, ASN1Encoding aSN1Encoding) {
        this(aSN1TagClass, i, aSN1Encoding, EnumSet.of(aSN1Encoding));
    }

    private ASN1Tag(ASN1TagClass aSN1TagClass, int i, ASN1Encoding aSN1Encoding, Set<ASN1Encoding> set) {
        this.asn1TagClass = aSN1TagClass;
        this.tag = i;
        this.supportedEncodings = set;
        this.asn1Encoding = aSN1Encoding;
    }
}
