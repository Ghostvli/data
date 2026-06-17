package com.hierynomus.protocol.commons;

import defpackage.jl;
import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface EnumWithValue<E extends Enum<E>> {
    long getValue();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class EnumUtils {
        public static <E extends Enum<E>> Set<E> ensureNotNull(Set<E> set, Class<E> cls) {
            return set == null ? EnumSet.noneOf(cls) : set;
        }

        /* JADX WARN: Incorrect types in method signature: <E::Lcom/hierynomus/protocol/commons/EnumWithValue<*>;>(JTE;)Z */
        public static boolean isSet(long j, EnumWithValue enumWithValue) {
            return (j & enumWithValue.getValue()) > 0;
        }

        public static <E extends Enum<E>> EnumSet<E> toEnumSet(long j, Class<E> cls) {
            if (!EnumWithValue.class.isAssignableFrom(cls)) {
                jl.a("Can only be used with EnumWithValue enums.");
                return null;
            }
            EnumSet<E> enumSetNoneOf = EnumSet.noneOf(cls);
            for (E e : cls.getEnumConstants()) {
                if (isSet(j, (EnumWithValue) e)) {
                    enumSetNoneOf.add(e);
                }
            }
            return enumSetNoneOf;
        }

        public static <E extends Enum<E>> long toLong(Collection<E> collection) {
            long value = 0;
            for (E e : collection) {
                if (!(e instanceof EnumWithValue)) {
                    jl.a("Can only be used with EnumWithValue enums.");
                    return 0L;
                }
                value |= ((EnumWithValue) e).getValue();
            }
            return value;
        }

        /* JADX WARN: Incorrect return type in method signature: <E::Lcom/hierynomus/protocol/commons/EnumWithValue<*>;>(JLjava/lang/Class<TE;>;TE;)TE; */
        public static EnumWithValue valueOf(long j, Class cls, EnumWithValue enumWithValue) {
            for (EnumWithValue enumWithValue2 : (EnumWithValue[]) cls.getEnumConstants()) {
                if (enumWithValue2.getValue() == j) {
                    return enumWithValue2;
                }
            }
            return enumWithValue;
        }

        public static <E extends Enum<E>> E ensureNotNull(E e, E e2) {
            return e != null ? e : e2;
        }
    }
}
