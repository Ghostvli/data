package com.hierynomus.asn1;

import com.hierynomus.asn1.encodingrules.ASN1Decoder;
import com.hierynomus.asn1.types.ASN1Object;
import com.hierynomus.asn1.types.ASN1Tag;
import defpackage.j02;
import defpackage.n02;
import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ASN1InputStream extends FilterInputStream implements Iterable<ASN1Object>, InputStreamRetargetInterface {
    private static final j02 logger = n02.k(ASN1InputStream.class);
    private final ASN1Decoder decoder;

    public ASN1InputStream(ASN1Decoder aSN1Decoder, byte[] bArr) {
        super(new ByteArrayInputStream(bArr));
        this.decoder = aSN1Decoder;
    }

    @Override // java.lang.Iterable
    public Iterator<ASN1Object> iterator() {
        return new Iterator<ASN1Object>() { // from class: com.hierynomus.asn1.ASN1InputStream.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return ASN1InputStream.this.available() > 0;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public ASN1Object next() {
                try {
                    return ASN1InputStream.this.readObject();
                } catch (Exception e) {
                    throw new NoSuchElementException(e.getMessage());
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Remove not supported on ASN.1 InputStream iterator");
            }
        };
    }

    public int readLength() {
        return this.decoder.readLength(this);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <T extends ASN1Object> T readObject() {
        try {
            ASN1Tag<? extends ASN1Object> tag = this.decoder.readTag(this);
            j02 j02Var = logger;
            j02Var.h("Read ASN.1 tag {}", tag);
            int length = this.decoder.readLength(this);
            j02Var.h("Read ASN.1 object length: {}", Integer.valueOf(length));
            T t = (T) tag.newParser(this.decoder).parse(tag, this.decoder.readValue(length, this));
            j02Var.q("Read ASN.1 object: {}", t);
            return t;
        } catch (ASN1ParseException e) {
            throw e;
        } catch (Exception e2) {
            throw new ASN1ParseException(e2, "Cannot parse ASN.1 object from stream", new Object[0]);
        }
    }

    public ASN1Tag readTag() {
        return this.decoder.readTag(this);
    }

    public byte[] readValue(int i) {
        return this.decoder.readValue(i, this);
    }

    @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
    public /* synthetic */ long transferTo(OutputStream outputStream) {
        return DesugarInputStream.transferTo(this, outputStream);
    }

    public ASN1InputStream(ASN1Decoder aSN1Decoder, InputStream inputStream) {
        super(inputStream);
        this.decoder = aSN1Decoder;
    }
}
