package okio.internal;

import defpackage.fu4;
import defpackage.fw4;
import defpackage.kp3;
import defpackage.lp3;
import defpackage.mp3;
import defpackage.sb1;
import defpackage.sg4;
import defpackage.sx;
import defpackage.wg4;
import defpackage.ww;
import defpackage.y42;
import defpackage.ye5;
import defpackage.ze5;
import defpackage.zs;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;
import okio.ZipFileSystem;
import okio.internal.ZipEntry;
import okio.internal.ZipFilesKt;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_NTFS_EXTRA = 10;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    public static fw4 a(BufferedSource bufferedSource, mp3 mp3Var, mp3 mp3Var2, mp3 mp3Var3, int i, long j) throws IOException {
        if (i == HEADER_ID_EXTENDED_TIMESTAMP) {
            if (j < 1) {
                sb1.a("bad zip: extended timestamp extra too short");
                return null;
            }
            byte b = bufferedSource.readByte();
            boolean z = (b & 1) == 1;
            boolean z2 = (b & 2) == 2;
            boolean z3 = (b & 4) == 4;
            long j2 = z ? 5L : 1L;
            if (z2) {
                j2 += 4;
            }
            if (z3) {
                j2 += 4;
            }
            if (j < j2) {
                sb1.a("bad zip: extended timestamp extra too short");
                return null;
            }
            if (z) {
                mp3Var.f = Integer.valueOf(bufferedSource.readIntLe());
            }
            if (z2) {
                mp3Var2.f = Integer.valueOf(bufferedSource.readIntLe());
            }
            if (z3) {
                mp3Var3.f = Integer.valueOf(bufferedSource.readIntLe());
            }
        }
        return fw4.a;
    }

    public static boolean b(ZipEntry zipEntry) {
        zipEntry.getClass();
        return true;
    }

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Path path = Path.Companion.get$default(Path.Companion, ServiceReference.DELIMITER, false, 1, (Object) null);
        Map<Path, ZipEntry> mapK = y42.k(fu4.a(path, new ZipEntry(path, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 65532, null)));
        for (ZipEntry zipEntry : ww.X(list, new Comparator() { // from class: okio.internal.ZipFilesKt$buildIndex$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return sx.a(((ZipEntry) t).getCanonicalPath(), ((ZipEntry) t2).getCanonicalPath());
            }
        })) {
            if (mapK.put(zipEntry.getCanonicalPath(), zipEntry) == null) {
                while (true) {
                    Path pathParent = zipEntry.getCanonicalPath().parent();
                    if (pathParent != null) {
                        ZipEntry zipEntry2 = mapK.get(pathParent);
                        if (zipEntry2 != null) {
                            zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                            break;
                        }
                        ZipEntry zipEntry3 = new ZipEntry(pathParent, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 65532, null);
                        mapK.put(pathParent, zipEntry3);
                        zipEntry3.getChildren().add(zipEntry.getCanonicalPath());
                        zipEntry = zipEntry3;
                    }
                }
            }
        }
        return mapK;
    }

    public static fw4 d(kp3 kp3Var, long j, lp3 lp3Var, final BufferedSource bufferedSource, lp3 lp3Var2, lp3 lp3Var3, final mp3 mp3Var, final mp3 mp3Var2, final mp3 mp3Var3, int i, long j2) throws IOException {
        if (i != 1) {
            if (i == 10) {
                if (j2 < 4) {
                    sb1.a("bad zip: NTFS extra too short");
                    return null;
                }
                bufferedSource.skip(4L);
                readExtra(bufferedSource, (int) (j2 - 4), new Function2() { // from class: bf5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ZipFilesKt.readCentralDirectoryZipEntry$lambda$1$0(mp3Var, bufferedSource, mp3Var2, mp3Var3, ((Integer) obj).intValue(), ((Long) obj2).longValue());
                    }
                });
            }
        } else {
            if (kp3Var.f) {
                sb1.a("bad zip: zip64 extra repeated");
                return null;
            }
            kp3Var.f = true;
            if (j2 < j) {
                sb1.a("bad zip: zip64 extra too short");
                return null;
            }
            long longLe = lp3Var.f;
            if (longLe == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
                longLe = bufferedSource.readLongLe();
            }
            lp3Var.f = longLe;
            lp3Var2.f = lp3Var2.f == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? bufferedSource.readLongLe() : 0L;
            lp3Var3.f = lp3Var3.f == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? bufferedSource.readLongLe() : 0L;
        }
        return fw4.a;
    }

    public static final Long dosDateTimeToEpochMillis(int i, int i2) {
        if (i2 == -1) {
            return null;
        }
        return Long.valueOf(_ZlibJvmKt.datePartsToEpochMillis(((i >> 9) & 127) + 1980, (i >> 5) & 15, i & 31, (i2 >> 11) & 31, (i2 >> 5) & 63, (i2 & 31) << 1));
    }

    public static final long filetimeToEpochMillis(long j) {
        return (j / 10000) - 11644473600000L;
    }

    private static final String getHex(int i) {
        StringBuilder sb = new StringBuilder("0x");
        String string = Integer.toString(i, zs.a(16));
        string.getClass();
        sb.append(string);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00d5 A[Catch: all -> 0x00d6, TRY_ENTER, TryCatch #9 {all -> 0x00d6, blocks: (B:13:0x005a, B:15:0x0063, B:18:0x0074, B:43:0x00d5, B:46:0x00d9, B:47:0x00e0, B:48:0x00e1), top: B:133:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0103 A[Catch: all -> 0x00fa, TryCatch #12 {all -> 0x00fa, blocks: (B:3:0x0013, B:5:0x0021, B:6:0x0029, B:10:0x0047, B:12:0x0052, B:65:0x0103, B:59:0x00f6, B:66:0x0104, B:93:0x0168, B:97:0x0179, B:90:0x0162, B:100:0x017c, B:103:0x018a, B:104:0x0191, B:105:0x0192, B:106:0x0195, B:107:0x0196, B:108:0x01ab, B:87:0x015b, B:56:0x00ef, B:7:0x0031, B:9:0x003a, B:67:0x0115, B:70:0x011d, B:72:0x012d, B:74:0x013b, B:77:0x0142, B:78:0x0146, B:79:0x014d, B:80:0x014e), top: B:138:0x0013, inners: #0, #6, #11, #13 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final okio.ZipFileSystem openZip(okio.Path r17, okio.FileSystem r18, kotlin.jvm.functions.Function1<? super okio.internal.ZipEntry, java.lang.Boolean> r19) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instruction units count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipFilesKt.openZip(okio.Path, okio.FileSystem, kotlin.jvm.functions.Function1):okio.ZipFileSystem");
    }

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: af5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(ZipFilesKt.b((ZipEntry) obj2));
                }
            };
        }
        return openZip(path, fileSystem, function1);
    }

    public static final ZipEntry readCentralDirectoryZipEntry(final BufferedSource bufferedSource) throws IOException {
        bufferedSource.getClass();
        int intLe = bufferedSource.readIntLe();
        if (intLe != CENTRAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(intLe));
        }
        bufferedSource.skip(4L);
        short shortLe = bufferedSource.readShortLe();
        int i = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            ze5.a("unsupported zip: general purpose bit flag=", getHex(i));
            return null;
        }
        int shortLe2 = bufferedSource.readShortLe() & 65535;
        int shortLe3 = bufferedSource.readShortLe() & 65535;
        int shortLe4 = bufferedSource.readShortLe() & 65535;
        long intLe2 = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        final lp3 lp3Var = new lp3();
        lp3Var.f = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        final lp3 lp3Var2 = new lp3();
        lp3Var2.f = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        int shortLe5 = bufferedSource.readShortLe() & 65535;
        int shortLe6 = bufferedSource.readShortLe() & 65535;
        int shortLe7 = bufferedSource.readShortLe() & 65535;
        bufferedSource.skip(8L);
        final lp3 lp3Var3 = new lp3();
        lp3Var3.f = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        String utf8 = bufferedSource.readUtf8(shortLe5);
        if (wg4.O(utf8, (char) 0, false, 2, null)) {
            sb1.a("bad zip: filename contains 0x00");
            return null;
        }
        long j = lp3Var2.f == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? 8L : 0L;
        if (lp3Var.f == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            j += 8;
        }
        if (lp3Var3.f == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            j += 8;
        }
        final long j2 = j;
        final mp3 mp3Var = new mp3();
        final mp3 mp3Var2 = new mp3();
        final mp3 mp3Var3 = new mp3();
        final kp3 kp3Var = new kp3();
        readExtra(bufferedSource, shortLe6, new Function2() { // from class: df5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ZipFilesKt.d(kp3Var, j2, lp3Var2, bufferedSource, lp3Var, lp3Var3, mp3Var, mp3Var2, mp3Var3, ((Integer) obj).intValue(), ((Long) obj2).longValue());
            }
        });
        if (j2 <= 0 || kp3Var.f) {
            return new ZipEntry(Path.Companion.get$default(Path.Companion, ServiceReference.DELIMITER, false, 1, (Object) null).resolve(utf8), sg4.x(utf8, ServiceReference.DELIMITER, false, 2, null), bufferedSource.readUtf8(shortLe7), intLe2, lp3Var.f, lp3Var2.f, shortLe2, lp3Var3.f, shortLe4, shortLe3, (Long) mp3Var.f, (Long) mp3Var2.f, (Long) mp3Var3.f, null, null, null, 57344, null);
        }
        sb1.a("bad zip: zip64 extra required but absent");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final fw4 readCentralDirectoryZipEntry$lambda$1$0(mp3 mp3Var, BufferedSource bufferedSource, mp3 mp3Var2, mp3 mp3Var3, int i, long j) throws IOException {
        if (i == 1) {
            if (mp3Var.f != null) {
                sb1.a("bad zip: NTFS extra attribute tag 0x0001 repeated");
                return null;
            }
            if (j != 24) {
                sb1.a("bad zip: NTFS extra attribute tag 0x0001 size != 24");
                return null;
            }
            mp3Var.f = Long.valueOf(bufferedSource.readLongLe());
            mp3Var2.f = Long.valueOf(bufferedSource.readLongLe());
            mp3Var3.f = Long.valueOf(bufferedSource.readLongLe());
        }
        return fw4.a;
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        int shortLe = bufferedSource.readShortLe() & 65535;
        int shortLe2 = bufferedSource.readShortLe() & 65535;
        long shortLe3 = bufferedSource.readShortLe() & 65535;
        if (shortLe3 == (bufferedSource.readShortLe() & 65535) && shortLe == 0 && shortLe2 == 0) {
            bufferedSource.skip(4L);
            return new EocdRecord(shortLe3, MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE & ((long) bufferedSource.readIntLe()), bufferedSource.readShortLe() & 65535);
        }
        sb1.a("unsupported zip: spanned");
        return null;
    }

    private static final void readExtra(BufferedSource bufferedSource, int i, Function2<? super Integer, ? super Long, fw4> function2) throws IOException {
        long j = i;
        while (j != 0) {
            if (j < 4) {
                sb1.a("bad zip: truncated header in extra field");
                return;
            }
            int shortLe = bufferedSource.readShortLe() & 65535;
            long shortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            long j2 = j - 4;
            if (j2 < shortLe2) {
                sb1.a("bad zip: truncated value in extra field");
                return;
            }
            bufferedSource.require(shortLe2);
            long size = bufferedSource.getBuffer().size();
            function2.invoke(Integer.valueOf(shortLe), Long.valueOf(shortLe2));
            long size2 = (bufferedSource.getBuffer().size() + shortLe2) - size;
            if (size2 < 0) {
                ye5.a("unsupported zip: too many bytes processed for ", shortLe);
                return;
            } else {
                if (size2 > 0) {
                    bufferedSource.getBuffer().skip(size2);
                }
                j = j2 - shortLe2;
            }
        }
    }

    public static final ZipEntry readLocalHeader(BufferedSource bufferedSource, ZipEntry zipEntry) throws IOException {
        bufferedSource.getClass();
        zipEntry.getClass();
        ZipEntry orSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, zipEntry);
        orSkipLocalHeader.getClass();
        return orSkipLocalHeader;
    }

    private static final ZipEntry readOrSkipLocalHeader(final BufferedSource bufferedSource, ZipEntry zipEntry) throws IOException {
        int intLe = bufferedSource.readIntLe();
        if (intLe != LOCAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(intLe));
        }
        bufferedSource.skip(2L);
        short shortLe = bufferedSource.readShortLe();
        int i = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            ze5.a("unsupported zip: general purpose bit flag=", getHex(i));
            return null;
        }
        bufferedSource.skip(18L);
        long shortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        int shortLe3 = bufferedSource.readShortLe() & 65535;
        bufferedSource.skip(shortLe2);
        if (zipEntry == null) {
            bufferedSource.skip(shortLe3);
            return null;
        }
        final mp3 mp3Var = new mp3();
        final mp3 mp3Var2 = new mp3();
        final mp3 mp3Var3 = new mp3();
        readExtra(bufferedSource, shortLe3, new Function2() { // from class: cf5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ZipFilesKt.a(bufferedSource, mp3Var, mp3Var2, mp3Var3, ((Integer) obj).intValue(), ((Long) obj2).longValue());
            }
        });
        return zipEntry.copy$okio((Integer) mp3Var.f, (Integer) mp3Var2.f, (Integer) mp3Var3.f);
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12L);
        int intLe = bufferedSource.readIntLe();
        int intLe2 = bufferedSource.readIntLe();
        long longLe = bufferedSource.readLongLe();
        if (longLe == bufferedSource.readLongLe() && intLe == 0 && intLe2 == 0) {
            bufferedSource.skip(8L);
            return new EocdRecord(longLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
        }
        sb1.a("unsupported zip: spanned");
        return null;
    }

    public static final void skipLocalHeader(BufferedSource bufferedSource) throws IOException {
        bufferedSource.getClass();
        readOrSkipLocalHeader(bufferedSource, null);
    }
}
