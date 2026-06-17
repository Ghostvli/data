package j$.desugar.sun.nio.fs;

import j$.nio.file.LinkOption;
import j$.nio.file.OpenOption;
import j$.nio.file.Path;
import j$.nio.file.StandardCopyOption;
import j$.nio.file.a0;
import j$.nio.file.attribute.FileAttribute;
import j$.nio.file.attribute.FileTime;
import j$.nio.file.attribute.t;
import j$.nio.file.attribute.u;
import j$.nio.file.attribute.v;
import j$.nio.file.attribute.w;
import j$.nio.file.b0;
import j$.nio.file.y;
import j$.nio.file.z;
import j$.time.ZoneId;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardOpenOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String a(long j, String str, Locale locale) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(timeZone);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeZone);
        calendar.set(2016, 1, (int) j, 0, 0, 0);
        return simpleDateFormat.format(calendar.getTime());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String b(long j, String str, Locale locale) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(timeZone);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeZone);
        calendar.set(0, (int) j, 0, 0, 0, 0);
        return simpleDateFormat.format(calendar.getTime());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static FileTime c(java.nio.file.attribute.FileTime fileTime) {
        if (fileTime == null) {
            return null;
        }
        return new FileTime(fileTime.toMillis());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ StandardOpenOption d(j$.nio.file.StandardOpenOption standardOpenOption) {
        if (standardOpenOption == null) {
            return null;
        }
        return standardOpenOption == j$.nio.file.StandardOpenOption.READ ? StandardOpenOption.READ : standardOpenOption == j$.nio.file.StandardOpenOption.WRITE ? StandardOpenOption.WRITE : standardOpenOption == j$.nio.file.StandardOpenOption.APPEND ? StandardOpenOption.APPEND : standardOpenOption == j$.nio.file.StandardOpenOption.TRUNCATE_EXISTING ? StandardOpenOption.TRUNCATE_EXISTING : standardOpenOption == j$.nio.file.StandardOpenOption.CREATE ? StandardOpenOption.CREATE : standardOpenOption == j$.nio.file.StandardOpenOption.CREATE_NEW ? StandardOpenOption.CREATE_NEW : standardOpenOption == j$.nio.file.StandardOpenOption.DELETE_ON_CLOSE ? StandardOpenOption.DELETE_ON_CLOSE : standardOpenOption == j$.nio.file.StandardOpenOption.SPARSE ? StandardOpenOption.SPARSE : standardOpenOption == j$.nio.file.StandardOpenOption.SYNC ? StandardOpenOption.SYNC : StandardOpenOption.DSYNC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static java.nio.file.attribute.FileTime e(FileTime fileTime) {
        if (fileTime == null) {
            return null;
        }
        return java.nio.file.attribute.FileTime.fromMillis(fileTime.toMillis());
    }

    /* JADX DEBUG: Class process forced to load method for inline: j$.nio.file.p.u(j$.nio.file.Path):java.nio.file.Path */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object f(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof Path ? j$.nio.file.p.u((Path) obj) : obj instanceof java.nio.file.Path ? j$.nio.file.o.u((java.nio.file.Path) obj) : obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Class g(Class cls) {
        if (cls == null) {
            return null;
        }
        if (cls == BasicFileAttributeView.class) {
            return j$.nio.file.attribute.d.class;
        }
        if (cls == j$.nio.file.attribute.d.class) {
            return BasicFileAttributeView.class;
        }
        if (cls == PosixFileAttributeView.class) {
            return t.class;
        }
        if (cls == t.class) {
            return PosixFileAttributeView.class;
        }
        if (cls == FileOwnerAttributeView.class) {
            return j$.nio.file.attribute.q.class;
        }
        if (cls == j$.nio.file.attribute.q.class) {
            return FileOwnerAttributeView.class;
        }
        if (cls == j$.nio.file.attribute.g.class) {
            return DosFileAttributeView.class;
        }
        if (cls == DosFileAttributeView.class) {
            return j$.nio.file.attribute.g.class;
        }
        if (cls == w.class) {
            return UserDefinedFileAttributeView.class;
        }
        if (cls == UserDefinedFileAttributeView.class) {
            return w.class;
        }
        if (cls == j$.nio.file.attribute.a.class) {
            return AclFileAttributeView.class;
        }
        if (cls == AclFileAttributeView.class) {
            return j$.nio.file.attribute.a.class;
        }
        j$.util.a.a("java.nio.file.attribute.FileAttributeView", cls);
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Class h(Class cls) {
        if (cls == null) {
            return null;
        }
        if (cls == BasicFileAttributes.class) {
            return j$.nio.file.attribute.BasicFileAttributes.class;
        }
        if (cls == j$.nio.file.attribute.BasicFileAttributes.class) {
            return BasicFileAttributes.class;
        }
        if (cls == PosixFileAttributes.class) {
            return u.class;
        }
        if (cls == u.class) {
            return PosixFileAttributes.class;
        }
        if (cls == j$.nio.file.attribute.h.class) {
            return DosFileAttributes.class;
        }
        if (cls == DosFileAttributes.class) {
            return j$.nio.file.attribute.h.class;
        }
        j$.util.a.a("java.nio.file.attribute.BasicFileAttributes", cls);
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map i(Map map) {
        if (map == null || map.isEmpty()) {
            return map;
        }
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            map2.put(str, j(map.get(str)));
        }
        return map2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object j(Object obj) {
        if (obj instanceof java.nio.file.attribute.FileTime) {
            try {
                return c((java.nio.file.attribute.FileTime) obj);
            } catch (ClassCastException e) {
                j$.util.a.a("java.nio.file.attribute.FileTime", e);
                throw null;
            }
        }
        if (!(obj instanceof FileTime)) {
            return obj;
        }
        try {
            return e((FileTime) obj);
        } catch (ClassCastException e2) {
            j$.util.a.a("java.nio.file.attribute.FileTime", e2);
            throw null;
        }
    }

    /* JADX DEBUG: Class process forced to load method for inline: j$.nio.file.l.a(java.nio.file.OpenOption):j$.nio.file.OpenOption */
    /* JADX DEBUG: Class process forced to load method for inline: j$.nio.file.m.a(j$.nio.file.OpenOption):java.nio.file.OpenOption */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Set k(Set set) {
        if (set == null || set.isEmpty()) {
            return set;
        }
        HashSet hashSet = new HashSet();
        Object next = set.iterator().next();
        if (next instanceof OpenOption) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                try {
                    hashSet.add(j$.nio.file.m.a((OpenOption) it.next()));
                } catch (ClassCastException e) {
                    j$.util.a.a("java.nio.file.OpenOption", e);
                    throw null;
                }
            }
        } else {
            if (!(next instanceof java.nio.file.OpenOption)) {
                j$.util.a.a("java.nio.file.OpenOption", next.getClass());
                throw null;
            }
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                try {
                    hashSet.add(j$.nio.file.l.a((java.nio.file.OpenOption) it2.next()));
                } catch (ClassCastException e2) {
                    j$.util.a.a("java.nio.file.OpenOption", e2);
                    throw null;
                }
            }
        }
        return hashSet;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Set l(Set set) {
        if (set == null || set.isEmpty()) {
            return set;
        }
        HashSet hashSet = new HashSet();
        Object next = set.iterator().next();
        if (next instanceof v) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                try {
                    v vVar = (v) it.next();
                    hashSet.add(vVar == null ? null : vVar == v.OWNER_READ ? PosixFilePermission.OWNER_READ : vVar == v.OWNER_WRITE ? PosixFilePermission.OWNER_WRITE : vVar == v.OWNER_EXECUTE ? PosixFilePermission.OWNER_EXECUTE : vVar == v.GROUP_READ ? PosixFilePermission.GROUP_READ : vVar == v.GROUP_WRITE ? PosixFilePermission.GROUP_WRITE : vVar == v.GROUP_EXECUTE ? PosixFilePermission.GROUP_EXECUTE : vVar == v.OTHERS_READ ? PosixFilePermission.OTHERS_READ : vVar == v.OTHERS_WRITE ? PosixFilePermission.OTHERS_WRITE : PosixFilePermission.OTHERS_EXECUTE);
                } catch (ClassCastException e) {
                    j$.util.a.a("java.nio.file.attribute.PosixFilePermission", e);
                    throw null;
                }
            }
        } else {
            if (!(next instanceof PosixFilePermission)) {
                j$.util.a.a("java.nio.file.attribute.PosixFilePermission", next.getClass());
                throw null;
            }
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                try {
                    PosixFilePermission posixFilePermission = (PosixFilePermission) it2.next();
                    hashSet.add(posixFilePermission == null ? null : posixFilePermission == PosixFilePermission.OWNER_READ ? v.OWNER_READ : posixFilePermission == PosixFilePermission.OWNER_WRITE ? v.OWNER_WRITE : posixFilePermission == PosixFilePermission.OWNER_EXECUTE ? v.OWNER_EXECUTE : posixFilePermission == PosixFilePermission.GROUP_READ ? v.GROUP_READ : posixFilePermission == PosixFilePermission.GROUP_WRITE ? v.GROUP_WRITE : posixFilePermission == PosixFilePermission.GROUP_EXECUTE ? v.GROUP_EXECUTE : posixFilePermission == PosixFilePermission.OTHERS_READ ? v.OTHERS_READ : posixFilePermission == PosixFilePermission.OTHERS_WRITE ? v.OTHERS_WRITE : v.OTHERS_EXECUTE);
                } catch (ClassCastException e2) {
                    j$.util.a.a("java.nio.file.attribute.PosixFilePermission", e2);
                    throw null;
                }
            }
        }
        return hashSet;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean m(Object obj) {
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set.isEmpty()) {
            return false;
        }
        Object next = set.iterator().next();
        return (next instanceof v) || (next instanceof PosixFilePermission);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ String n(Iterable iterable) {
        StringBuilder sb = new StringBuilder();
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append((CharSequence) ServiceReference.DELIMITER);
            }
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ List o(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Set p(Object[] objArr) {
        HashSet hashSet = new HashSet(objArr.length);
        for (Object obj : objArr) {
            Objects.requireNonNull(obj);
            if (!hashSet.add(obj)) {
                throw new IllegalArgumentException("duplicate element: " + obj);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ LinkOption[] q(java.nio.file.LinkOption[] linkOptionArr) {
        if (linkOptionArr == null) {
            return null;
        }
        int length = linkOptionArr.length;
        LinkOption[] linkOptionArr2 = new LinkOption[length];
        for (int i = 0; i < length; i++) {
            linkOptionArr2[i] = linkOptionArr[i] == null ? null : LinkOption.NOFOLLOW_LINKS;
        }
        return linkOptionArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b0[] r(WatchEvent.Kind[] kindArr) {
        if (kindArr == null) {
            return null;
        }
        int length = kindArr.length;
        b0[] b0VarArr = new b0[length];
        for (int i = 0; i < length; i++) {
            WatchEvent.Kind kind = kindArr[i];
            b0VarArr[i] = kind == null ? null : kind == StandardWatchEventKinds.ENTRY_CREATE ? y.b : kind == StandardWatchEventKinds.ENTRY_DELETE ? y.c : kind == StandardWatchEventKinds.ENTRY_MODIFY ? y.d : kind == StandardWatchEventKinds.OVERFLOW ? y.a : kind instanceof a0 ? ((a0) kind).a : new z(kind);
        }
        return b0VarArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static FileAttribute[] s(java.nio.file.attribute.FileAttribute[] fileAttributeArr) {
        if (fileAttributeArr == null) {
            return null;
        }
        int length = fileAttributeArr.length;
        FileAttribute[] fileAttributeArr2 = new FileAttribute[length];
        for (int i = 0; i < length; i++) {
            java.nio.file.attribute.FileAttribute fileAttribute = fileAttributeArr[i];
            fileAttributeArr2[i] = fileAttribute == null ? null : m(fileAttribute.value()) ? new h(fileAttribute, 3) : fileAttribute instanceof j$.nio.file.attribute.j ? ((j$.nio.file.attribute.j) fileAttribute).a : new j$.nio.file.attribute.i(fileAttribute);
        }
        return fileAttributeArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ CopyOption[] t(j$.nio.file.CopyOption[] copyOptionArr) {
        CopyOption cVar;
        if (copyOptionArr == null) {
            return null;
        }
        int length = copyOptionArr.length;
        CopyOption[] copyOptionArr2 = new CopyOption[length];
        for (int i = 0; i < length; i++) {
            j$.nio.file.CopyOption copyOption = copyOptionArr[i];
            if (copyOption == null) {
                cVar = null;
            } else if (copyOption instanceof j$.nio.file.b) {
                cVar = ((j$.nio.file.b) copyOption).a;
            } else if (copyOption instanceof LinkOption) {
                cVar = java.nio.file.LinkOption.NOFOLLOW_LINKS;
            } else if (copyOption instanceof StandardCopyOption) {
                StandardCopyOption standardCopyOption = (StandardCopyOption) copyOption;
                cVar = standardCopyOption == StandardCopyOption.REPLACE_EXISTING ? java.nio.file.StandardCopyOption.REPLACE_EXISTING : standardCopyOption == StandardCopyOption.COPY_ATTRIBUTES ? java.nio.file.StandardCopyOption.COPY_ATTRIBUTES : java.nio.file.StandardCopyOption.ATOMIC_MOVE;
            } else {
                cVar = new j$.nio.file.c(copyOption);
            }
            copyOptionArr2[i] = cVar;
        }
        return copyOptionArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ java.nio.file.LinkOption[] u(LinkOption[] linkOptionArr) {
        if (linkOptionArr == null) {
            return null;
        }
        int length = linkOptionArr.length;
        java.nio.file.LinkOption[] linkOptionArr2 = new java.nio.file.LinkOption[length];
        for (int i = 0; i < length; i++) {
            linkOptionArr2[i] = linkOptionArr[i] == null ? null : java.nio.file.LinkOption.NOFOLLOW_LINKS;
        }
        return linkOptionArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static WatchEvent.Kind[] v(b0[] b0VarArr) {
        if (b0VarArr == null) {
            return null;
        }
        int length = b0VarArr.length;
        WatchEvent.Kind[] kindArr = new WatchEvent.Kind[length];
        for (int i = 0; i < length; i++) {
            b0 b0Var = b0VarArr[i];
            kindArr[i] = b0Var == null ? null : b0Var == y.b ? StandardWatchEventKinds.ENTRY_CREATE : b0Var == y.c ? StandardWatchEventKinds.ENTRY_DELETE : b0Var == y.d ? StandardWatchEventKinds.ENTRY_MODIFY : b0Var == y.a ? StandardWatchEventKinds.OVERFLOW : b0Var instanceof z ? ((z) b0Var).a : new a0(b0Var);
        }
        return kindArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static java.nio.file.attribute.FileAttribute[] w(FileAttribute[] fileAttributeArr) {
        if (fileAttributeArr == null) {
            return null;
        }
        int length = fileAttributeArr.length;
        java.nio.file.attribute.FileAttribute[] fileAttributeArr2 = new java.nio.file.attribute.FileAttribute[length];
        for (int i = 0; i < length; i++) {
            FileAttribute fileAttribute = fileAttributeArr[i];
            fileAttributeArr2[i] = fileAttribute == null ? null : m(fileAttribute.value()) ? new j$.nio.file.attribute.k(fileAttribute) : fileAttribute instanceof j$.nio.file.attribute.i ? ((j$.nio.file.attribute.i) fileAttribute).a : new j$.nio.file.attribute.j(fileAttribute);
        }
        return fileAttributeArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static char x(String str, int i) {
        if (i < str.length()) {
            return str.charAt(i);
        }
        return (char) 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static FileChannel y(Path path, Set set) throws IOException {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((OpenOption) it.next()).getClass();
        }
        if (path.toFile().exists()) {
            if (set.contains(j$.nio.file.StandardOpenOption.CREATE_NEW) && set.contains(j$.nio.file.StandardOpenOption.WRITE)) {
                throw new FileAlreadyExistsException(path.toString());
            }
        } else if (!set.contains(j$.nio.file.StandardOpenOption.CREATE) && !set.contains(j$.nio.file.StandardOpenOption.CREATE_NEW)) {
            throw new NoSuchFileException(path.toString());
        }
        if (set.contains(j$.nio.file.StandardOpenOption.READ) && set.contains(j$.nio.file.StandardOpenOption.APPEND)) {
            j$.nio.file.j.a("READ + APPEND not allowed");
            return null;
        }
        j$.nio.file.StandardOpenOption standardOpenOption = j$.nio.file.StandardOpenOption.APPEND;
        if (set.contains(standardOpenOption) && set.contains(j$.nio.file.StandardOpenOption.TRUNCATE_EXISTING)) {
            j$.nio.file.j.a("APPEND + TRUNCATE_EXISTING not allowed");
            return null;
        }
        File file = path.toFile();
        j$.nio.file.StandardOpenOption standardOpenOption2 = j$.nio.file.StandardOpenOption.WRITE;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, (set.contains(standardOpenOption2) || set.contains(standardOpenOption)) ? set.contains(j$.nio.file.StandardOpenOption.SYNC) ? "rws" : set.contains(j$.nio.file.StandardOpenOption.DSYNC) ? "rwd" : "rw" : "r");
        if (set.contains(j$.nio.file.StandardOpenOption.TRUNCATE_EXISTING) && set.contains(standardOpenOption2)) {
            randomAccessFile.setLength(0L);
        }
        if (!set.contains(standardOpenOption) && !set.contains(j$.nio.file.StandardOpenOption.DELETE_ON_CLOSE)) {
            return randomAccessFile.getChannel();
        }
        FileChannel channel = randomAccessFile.getChannel();
        int i = e.e;
        if (channel instanceof e) {
            channel = ((e) channel).a;
        }
        return new e(channel, set.contains(j$.nio.file.StandardOpenOption.DELETE_ON_CLOSE), set.contains(standardOpenOption), path);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static j$.time.a z() {
        return new j$.time.a(ZoneId.systemDefault());
    }
}
