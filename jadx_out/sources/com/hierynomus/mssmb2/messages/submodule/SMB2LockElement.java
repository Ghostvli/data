package com.hierynomus.mssmb2.messages.submodule;

import com.hierynomus.mssmb2.SMB2LockFlag;
import defpackage.jl;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2LockElement {
    private static final List<EnumSet<SMB2LockFlag>> VALID_FLAG_COMBINATIONS;
    private final long length;
    private final Set<SMB2LockFlag> lockFlags;
    private final long offset;

    static {
        SMB2LockFlag sMB2LockFlag = SMB2LockFlag.SMB2_LOCKFLAG_SHARED_LOCK;
        EnumSet enumSetOf = EnumSet.of(sMB2LockFlag);
        SMB2LockFlag sMB2LockFlag2 = SMB2LockFlag.SMB2_LOCKFLAG_EXCLUSIVE_LOCK;
        EnumSet enumSetOf2 = EnumSet.of(sMB2LockFlag2);
        SMB2LockFlag sMB2LockFlag3 = SMB2LockFlag.SMB2_LOCKFLAG_FAIL_IMMEDIATELY;
        VALID_FLAG_COMBINATIONS = Arrays.asList(enumSetOf, enumSetOf2, EnumSet.of(sMB2LockFlag, sMB2LockFlag3), EnumSet.of(sMB2LockFlag2, sMB2LockFlag3), EnumSet.of(SMB2LockFlag.SMB2_LOCKFLAG_UNLOCK));
    }

    public SMB2LockElement(long j, long j2, Set<SMB2LockFlag> set) {
        this.offset = j;
        this.length = j2;
        if (VALID_FLAG_COMBINATIONS.contains(set != null ? EnumSet.copyOf((Collection) set) : EnumSet.noneOf(SMB2LockFlag.class))) {
            this.lockFlags = set;
        } else {
            jl.a("Invalid lock flags combination. Check SMB2 document 2.2.26.1 SMB2_LOCK_ELEMENT Structure.");
            throw null;
        }
    }

    public long getLength() {
        return this.length;
    }

    public Set<SMB2LockFlag> getLockFlags() {
        return this.lockFlags;
    }

    public long getOffset() {
        return this.offset;
    }

    public String toString() {
        return "SMB2LockElement{offset=" + this.offset + ", length=" + this.length + ", lockFlags=" + this.lockFlags + '}';
    }
}
