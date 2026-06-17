package defpackage;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class z64 extends no {
    public static final Pattern l = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    public static final Pattern m = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    public static final Pattern n = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public z64(String str, long j, long j2, long j3, File file) {
        super(str, j, j2, j3, file);
    }

    public static z64 g(File file, long j, long j2, po poVar) {
        String strI;
        String name = file.getName();
        if (!name.endsWith(".v3.exo")) {
            file = l(file, poVar);
            if (file == null) {
                return null;
            }
            name = file.getName();
        }
        File file2 = file;
        Matcher matcher = n.matcher(name);
        if (!matcher.matches() || (strI = poVar.i(Integer.parseInt((String) gg3.q(matcher.group(1))))) == null) {
            return null;
        }
        if (j == -1) {
            j = file2.length();
        }
        long j3 = j;
        if (j3 == 0) {
            return null;
        }
        return new z64(strI, Long.parseLong((String) gg3.q(matcher.group(2))), j3, j2 == -9223372036854775807L ? Long.parseLong((String) gg3.q(matcher.group(3))) : j2, file2);
    }

    public static z64 h(File file, long j, po poVar) {
        return g(file, j, -9223372036854775807L, poVar);
    }

    public static z64 i(String str, long j, long j2) {
        return new z64(str, j, j2, -9223372036854775807L, null);
    }

    public static z64 j(String str, long j) {
        return new z64(str, j, -1L, -9223372036854775807L, null);
    }

    public static File k(File file, int i, long j, long j2) {
        return new File(file, i + "." + j + "." + j2 + ".v3.exo");
    }

    public static File l(File file, po poVar) {
        String strR1;
        String name = file.getName();
        Matcher matcher = m.matcher(name);
        if (matcher.matches()) {
            strR1 = fy4.R1((String) gg3.q(matcher.group(1)));
        } else {
            matcher = l.matcher(name);
            strR1 = matcher.matches() ? (String) gg3.q(matcher.group(1)) : null;
        }
        if (strR1 == null) {
            return null;
        }
        File fileK = k((File) gg3.q(file.getParentFile()), poVar.e(strR1), Long.parseLong((String) gg3.q(matcher.group(2))), Long.parseLong((String) gg3.q(matcher.group(3))));
        if (file.renameTo(fileK)) {
            return fileK;
        }
        return null;
    }

    public z64 f(File file, long j) {
        gg3.v(this.i);
        return new z64(this.f, this.g, this.h, j, file);
    }
}
