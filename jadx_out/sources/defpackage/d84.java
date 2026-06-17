package defpackage;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Class;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.bean.Site;
import com.fongmi.android.tv.bean.Vod;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.utils.Prefers;
import com.github.catvod.utils.Util;
import j$.util.stream.Stream$EL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import net.engio.mbassy.listener.MessageHandler;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d84 {
    public static String d(int i) {
        return i == 0 ? "videolist" : "detail";
    }

    public static Result e(String str, String str2) {
        Site siteW = b75.I().W(str);
        SpiderDebug.log("action", "key=%s,action=%s", str, str2);
        return siteW.getType().intValue() == 3 ? Result.fromJson(siteW.recent().spider().action(str2)) : siteW.getType().intValue() == 4 ? Result.fromJson(q53.E(str2)) : Result.empty();
    }

    public static String f(Site site, la laVar) {
        if (!site.getExt().isEmpty()) {
            laVar.put("extend", site.getExt());
        }
        Response responseExecute = (site.getExt().length() <= 1000 ? q53.t(site.getApi(), site.getHeader(), laVar) : q53.u(site.getApi(), site.getHeader(), q53.G(laVar))).execute();
        try {
            String strString = responseExecute.body().string();
            responseExecute.close();
            return strString;
        } catch (Throwable th) {
            if (responseExecute != null) {
                try {
                    responseExecute.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static Result g(String str, String str2, String str3, boolean z, HashMap map) {
        SpiderDebug.log("category", "key=%s,tid=%s,page=%s,filter=%s,extend=%s", str, str2, str3, Boolean.valueOf(z), map);
        Site siteW = b75.I().W(str);
        if (k(siteW)) {
            String strCategoryContent = siteW.recent().spider().categoryContent(str2, str3, z, map);
            SpiderDebug.log("category", strCategoryContent, new Object[0]);
            return Result.fromJson(strCategoryContent);
        }
        la laVar = new la();
        if (siteW.getType().intValue() == 1 && !map.isEmpty()) {
            laVar.put("f", App.c().toJson(map));
        }
        if (siteW.getType().intValue() == 4) {
            laVar.put("ext", Util.base64(App.c().toJson(map), 10));
        }
        laVar.put("ac", d(siteW.getType().intValue()));
        laVar.put("t", str2);
        laVar.put("pg", str3);
        String strF = f(siteW, laVar);
        SpiderDebug.log("category", strF, new Object[0]);
        return Result.fromType(siteW.getType().intValue(), strF);
    }

    public static Result h(String str, String str2) throws Exception {
        SpiderDebug.log("detail", "key=%s,id=%s", str, str2);
        Site siteW = b75.I().W(str);
        if (siteW.isEmpty() && "push_agent".equals(str)) {
            Vod vod = new Vod();
            vod.setId(str2);
            vod.setName(str2);
            vod.setPlayUrl(str2);
            vod.setPlayFrom(vr3.l(sm3.m0));
            vod.setPic(vr3.l(sm3.n0));
            db4.f().i(vod.setFlags());
            return Result.vod(vod);
        }
        if (k(siteW)) {
            String strDetailContent = siteW.recent().spider().detailContent(Arrays.asList(str2));
            SpiderDebug.log("detail", strDetailContent, new Object[0]);
            Result resultFromJson = Result.fromJson(strDetailContent);
            db4.f().i(resultFromJson.getVod().setFlags());
            return resultFromJson;
        }
        la laVar = new la();
        laVar.put("ac", d(siteW.getType().intValue()));
        laVar.put("ids", str2);
        String strF = f(siteW, laVar);
        SpiderDebug.log("detail", strF, new Object[0]);
        Result resultFromType = Result.fromType(siteW.getType().intValue(), strF);
        db4.f().i(resultFromType.getVod().setFlags());
        return resultFromType;
    }

    public static Result i(Site site, Result result) {
        if (site.getType().intValue() > 2 || result.getList().isEmpty() || !result.getVod().getPic().isEmpty()) {
            return result;
        }
        ArrayList arrayList = new ArrayList();
        boolean zIsEmpty = site.getCategories().isEmpty();
        for (Vod vod : result.getList()) {
            if (zIsEmpty || site.getCategories().contains(vod.getTypeName())) {
                arrayList.add(vod.getId());
            }
        }
        if (arrayList.isEmpty()) {
            return result.clear();
        }
        la laVar = new la();
        laVar.put("ac", d(site.getType().intValue()));
        laVar.put("ids", TextUtils.join(",", arrayList));
        Response responseExecute = q53.t(site.getApi(), site.getHeader(), laVar).execute();
        try {
            result.setList(Result.fromType(site.getType().intValue(), responseExecute.body().string()).getList());
            responseExecute.close();
            return result;
        } catch (Throwable th) {
            if (responseExecute != null) {
                try {
                    responseExecute.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static Result j(Site site) {
        if (k(site)) {
            Spider spider = site.recent().spider();
            boolean z = Prefers.getBoolean("crash");
            String strHomeContent = z ? "" : spider.homeContent(false);
            String strHomeVideoContent = z ? "" : spider.homeVideoContent();
            Prefers.put("crash", Boolean.FALSE);
            SpiderDebug.log("home", strHomeContent, new Object[0]);
            SpiderDebug.log("homeVideo", strHomeVideoContent, new Object[0]);
            Result resultFromJson = Result.fromJson(strHomeContent);
            List<Vod> list = Result.fromJson(strHomeVideoContent).getList();
            if (!list.isEmpty()) {
                resultFromJson.setList(list);
            }
            n(site, resultFromJson);
            return resultFromJson;
        }
        if (site.getType().intValue() == 4) {
            la laVar = new la();
            laVar.put(MessageHandler.Properties.Filter, "true");
            String strF = f(site.fetchExt(), laVar);
            SpiderDebug.log("home", strF, new Object[0]);
            Result resultFromJson2 = Result.fromJson(strF);
            n(site, resultFromJson2);
            return resultFromJson2;
        }
        Response responseExecute = q53.s(site.getApi(), site.getHeader()).execute();
        try {
            String strString = responseExecute.body().string();
            SpiderDebug.log("home", strString, new Object[0]);
            Result resultFromType = Result.fromType(site.getType().intValue(), strString);
            i(site, resultFromType);
            n(site, resultFromType);
            responseExecute.close();
            return resultFromType;
        } catch (Throwable th) {
            if (responseExecute != null) {
                try {
                    responseExecute.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static boolean k(Site site) {
        return site.getType().intValue() == 3;
    }

    public static Result l(String str, String str2, String str3) {
        SpiderDebug.log("player", "key=%s,flag=%s,id=%s", str, str2, str3);
        Site siteW = b75.I().W(str);
        db4.f().j();
        if (siteW.getType().intValue() == 3) {
            String strPlayerContent = siteW.recent().spider().playerContent(str2, str3, b75.I().N());
            SpiderDebug.log("player", strPlayerContent, new Object[0]);
            Result resultFromJson = Result.fromJson(strPlayerContent);
            if (resultFromJson.getFlag().isEmpty()) {
                resultFromJson.setFlag(str2);
            }
            resultFromJson.setUrl(db4.f().e(resultFromJson));
            resultFromJson.setHeader(siteW.getHeader());
            resultFromJson.setKey(str);
            return resultFromJson;
        }
        if (siteW.getType().intValue() == 4) {
            la laVar = new la();
            laVar.put("play", str3);
            laVar.put("flag", str2);
            String strF = f(siteW, laVar);
            SpiderDebug.log("player", strF, new Object[0]);
            Result resultFromJson2 = Result.fromJson(strF);
            if (resultFromJson2.getFlag().isEmpty()) {
                resultFromJson2.setFlag(str2);
            }
            resultFromJson2.setUrl(db4.f().e(resultFromJson2));
            resultFromJson2.setHeader(siteW.getHeader());
            return resultFromJson2;
        }
        if (siteW.isEmpty() && "push_agent".equals(str)) {
            Result result = new Result();
            result.setUrl(str3);
            result.setParse(0);
            result.setFlag(str2);
            result.setUrl(db4.f().e(result));
            SpiderDebug.log("player", result.toString(), new Object[0]);
            return result;
        }
        Result result2 = new Result();
        result2.setUrl(str3);
        result2.setFlag(str2);
        result2.setHeader(siteW.getHeader());
        result2.setPlayUrl(siteW.getPlayUrl());
        result2.setParse(Integer.valueOf((u94.e(str3) && result2.getPlayUrl().isEmpty()) ? 0 : 1));
        result2.setUrl(db4.f().e(result2));
        SpiderDebug.log("player", result2.toString(), new Object[0]);
        return result2;
    }

    public static Result m(Site site, String str, boolean z, String str2) {
        SpiderDebug.log("search", "site=%s,keyword=%s,quick=%s,page=%s", site.getName(), str, Boolean.valueOf(z), str2);
        boolean zEquals = str2.equals("1");
        if (k(site)) {
            String strSearchContent = !zEquals ? site.spider().searchContent(str, z, str2) : site.spider().searchContent(str, z);
            SpiderDebug.log("search", strSearchContent, new Object[0]);
            Result resultFromJson = Result.fromJson(strSearchContent);
            Iterator<Vod> it = resultFromJson.getList().iterator();
            while (it.hasNext()) {
                it.next().setSite(site);
            }
            return resultFromJson;
        }
        la laVar = new la();
        laVar.put("wd", str);
        laVar.put("quick", String.valueOf(z));
        laVar.put("extend", "");
        if (!zEquals) {
            laVar.put("pg", str2);
        }
        String strF = f(site, laVar);
        SpiderDebug.log("search", strF, new Object[0]);
        Result resultI = i(site, Result.fromType(site.getType().intValue(), strF));
        Iterator<Vod> it2 = resultI.getList().iterator();
        while (it2.hasNext()) {
            it2.next().setSite(site);
        }
        return resultI;
    }

    public static void n(Site site, final Result result) {
        result.getTypes().stream().filter(new Predicate() { // from class: y74
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return result.getFilters().containsKey(((Class) obj).getTypeId());
            }
        }).forEach(new Consumer() { // from class: z74
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Class r1 = (Class) obj;
                r1.setFilters(result.getFilters().get(r1.getTypeId()));
            }
        });
        if (site.getCategories().isEmpty()) {
            return;
        }
        final HashMap map = new HashMap();
        result.getTypes().forEach(new Consumer() { // from class: a84
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Class r1 = (Class) obj;
                map.put(r1.getTypeName(), r1);
            }
        });
        List<Class> list = Stream$EL.toList(site.getCategories().stream().map(new Function() { // from class: b84
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (Class) map.get((String) obj);
            }
        }).filter(new Predicate() { // from class: c84
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((Class) obj);
            }
        }));
        if (list.isEmpty()) {
            return;
        }
        result.setTypes(list);
    }
}
