package com.hierynomus.asn1.annotations;

import com.hierynomus.asn1.types.primitive.ASN1Integer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface ASN1 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @Target({ElementType.FIELD, ElementType.METHOD})
    @ParsedBy(parser = ASN1Integer.Parser.class)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ASN1Integer {
        String defaultValue() default "0";
    }
}
