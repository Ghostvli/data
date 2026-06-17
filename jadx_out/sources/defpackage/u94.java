package defpackage;

import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.bean.Rule;
import com.github.catvod.utils.Json;
import com.github.catvod.utils.Trans;
import com.github.catvod.utils.Util;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u94 {
    public static final Pattern a = Pattern.compile("\\[a=cr:(\\{.*?\\})\\/](.*?)\\[\\/a]");
    public static final Pattern b = Pattern.compile("(https?|thunder|magnet|ed2k|video):\\S+");
    public static final Pattern c = Pattern.compile("https?://[^\\s]{12,}\\.(?:m3u8|mp4|mkv|flv|mp3|m4a|aac|mpd)(?:\\?.*)?|https?://.*?video/tos[^\\s]*|rtmp:[^\\s]+");

    public static SpannableStringBuilder a(String str, Function function) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Matcher matcher = a.matcher(str);
        int iEnd = 0;
        while (matcher.find()) {
            spannableStringBuilder.append((CharSequence) str, iEnd, matcher.start());
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) Trans.s2t(matcher.group(2).trim()));
            spannableStringBuilder.setSpan(function.apply(Result.type(matcher.group(1))), length, spannableStringBuilder.length(), 33);
            iEnd = matcher.end();
        }
        spannableStringBuilder.append((CharSequence) str, iEnd, str.length());
        return spannableStringBuilder;
    }

    public static Rule b(Uri uri) {
        if (uri.getHost() == null) {
            return Rule.empty();
        }
        String strJoin = TextUtils.join(",", Arrays.asList(qx4.d(uri), qx4.e(uri.getQueryParameter("url"))));
        for (Rule rule : bw3.a().c()) {
            Iterator<String> it = rule.getHosts().iterator();
            while (it.hasNext()) {
                if (Util.containOrMatch(strJoin, it.next())) {
                    return rule;
                }
            }
        }
        return Rule.empty();
    }

    public static List c(Uri uri) {
        return b(uri).getScript();
    }

    public static String d(String str) {
        if (Json.isObj(str) || str.contains("$")) {
            return str;
        }
        Matcher matcher = b.matcher(str);
        return matcher.find() ? matcher.group(0) : str;
    }

    public static boolean e(String str) {
        Rule ruleB = b(qx4.k(str));
        Iterator<String> it = ruleB.getExclude().iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return false;
            }
        }
        Iterator<String> it2 = ruleB.getExclude().iterator();
        while (it2.hasNext()) {
            if (Pattern.compile(it2.next()).matcher(str).find()) {
                return false;
            }
        }
        Iterator<String> it3 = ruleB.getRegex().iterator();
        while (it3.hasNext()) {
            if (str.contains(it3.next())) {
                return true;
            }
        }
        Iterator<String> it4 = ruleB.getRegex().iterator();
        while (it4.hasNext()) {
            if (Pattern.compile(it4.next()).matcher(str).find()) {
                return true;
            }
        }
        if (str.contains("url=http") || str.contains("v=http") || str.contains(".html")) {
            return false;
        }
        return c.matcher(str).find();
    }
}
