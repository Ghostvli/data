package com.fongmi.android.tv.db;

import androidx.room.c;
import defpackage.bk0;
import defpackage.f84;
import defpackage.fq1;
import defpackage.hu3;
import defpackage.hz;
import defpackage.j70;
import defpackage.jk0;
import defpackage.kq4;
import defpackage.kw3;
import defpackage.le1;
import defpackage.lw3;
import defpackage.mx1;
import defpackage.n84;
import defpackage.rq4;
import defpackage.vq1;
import defpackage.vx1;
import defpackage.wz;
import defpackage.xk4;
import defpackage.yd1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class AppDatabase_Impl extends AppDatabase {
    public volatile fq1 p;
    public volatile f84 q;
    public volatile mx1 r;
    public volatile kq4 s;
    public volatile hz t;
    public volatile bk0 u;
    public volatile yd1 v;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends hu3 {
        public a(int i, String str, String str2) {
            super(i, str, str2);
        }

        @Override // defpackage.hu3
        public void a(lw3 lw3Var) throws Exception {
            kw3.a(lw3Var, "CREATE TABLE IF NOT EXISTS `Keep` (`key` TEXT NOT NULL, `siteName` TEXT, `vodName` TEXT, `vodPic` TEXT, `createTime` INTEGER NOT NULL, `type` INTEGER NOT NULL, `cid` INTEGER NOT NULL, PRIMARY KEY(`key`))");
            kw3.a(lw3Var, "CREATE TABLE IF NOT EXISTS `Site` (`key` TEXT NOT NULL, `searchable` INTEGER, `changeable` INTEGER, PRIMARY KEY(`key`))");
            kw3.a(lw3Var, "CREATE TABLE IF NOT EXISTS `Live` (`name` TEXT NOT NULL, `keep` TEXT, `boot` INTEGER NOT NULL, `pass` INTEGER NOT NULL, PRIMARY KEY(`name`))");
            kw3.a(lw3Var, "CREATE TABLE IF NOT EXISTS `Track` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` INTEGER NOT NULL, `key` TEXT, `name` TEXT, `format` TEXT, `selected` INTEGER NOT NULL)");
            kw3.a(lw3Var, "CREATE UNIQUE INDEX IF NOT EXISTS `index_Track_key_type` ON `Track` (`key`, `type`)");
            kw3.a(lw3Var, "CREATE TABLE IF NOT EXISTS `Config` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` INTEGER NOT NULL, `time` INTEGER NOT NULL, `url` TEXT, `json` TEXT, `name` TEXT, `logo` TEXT, `home` TEXT, `parse` TEXT)");
            kw3.a(lw3Var, "CREATE UNIQUE INDEX IF NOT EXISTS `index_Config_url_type` ON `Config` (`url`, `type`)");
            kw3.a(lw3Var, "CREATE TABLE IF NOT EXISTS `Device` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `uuid` TEXT, `name` TEXT, `ip` TEXT, `type` INTEGER NOT NULL)");
            kw3.a(lw3Var, "CREATE UNIQUE INDEX IF NOT EXISTS `index_Device_uuid_name` ON `Device` (`uuid`, `name`)");
            kw3.a(lw3Var, "CREATE TABLE IF NOT EXISTS `History` (`key` TEXT NOT NULL, `vodPic` TEXT, `vodName` TEXT, `vodFlag` TEXT, `vodRemarks` TEXT, `episodeUrl` TEXT, `revSort` INTEGER NOT NULL, `revPlay` INTEGER NOT NULL, `createTime` INTEGER NOT NULL, `opening` INTEGER NOT NULL, `ending` INTEGER NOT NULL, `position` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `speed` REAL NOT NULL, `scale` INTEGER NOT NULL, `cid` INTEGER NOT NULL, PRIMARY KEY(`key`))");
            kw3.a(lw3Var, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            kw3.a(lw3Var, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8191bb223b1cde184fbb43d20d39d851')");
        }

        @Override // defpackage.hu3
        public void b(lw3 lw3Var) throws Exception {
            kw3.a(lw3Var, "DROP TABLE IF EXISTS `Keep`");
            kw3.a(lw3Var, "DROP TABLE IF EXISTS `Site`");
            kw3.a(lw3Var, "DROP TABLE IF EXISTS `Live`");
            kw3.a(lw3Var, "DROP TABLE IF EXISTS `Track`");
            kw3.a(lw3Var, "DROP TABLE IF EXISTS `Config`");
            kw3.a(lw3Var, "DROP TABLE IF EXISTS `Device`");
            kw3.a(lw3Var, "DROP TABLE IF EXISTS `History`");
        }

        @Override // defpackage.hu3
        public void f(lw3 lw3Var) {
        }

        @Override // defpackage.hu3
        public void g(lw3 lw3Var) {
            AppDatabase_Impl.this.C(lw3Var);
        }

        @Override // defpackage.hu3
        public void h(lw3 lw3Var) {
        }

        @Override // defpackage.hu3
        public void i(lw3 lw3Var) {
            j70.a(lw3Var);
        }

        @Override // defpackage.hu3
        public hu3.a j(lw3 lw3Var) {
            HashMap map = new HashMap(7);
            map.put("key", new xk4.a("key", "TEXT", true, 1, null, 1));
            map.put("siteName", new xk4.a("siteName", "TEXT", false, 0, null, 1));
            map.put("vodName", new xk4.a("vodName", "TEXT", false, 0, null, 1));
            map.put("vodPic", new xk4.a("vodPic", "TEXT", false, 0, null, 1));
            map.put("createTime", new xk4.a("createTime", "INTEGER", true, 0, null, 1));
            map.put("type", new xk4.a("type", "INTEGER", true, 0, null, 1));
            map.put("cid", new xk4.a("cid", "INTEGER", true, 0, null, 1));
            xk4 xk4Var = new xk4("Keep", map, new HashSet(0), new HashSet(0));
            xk4 xk4VarA = xk4.a(lw3Var, "Keep");
            if (!xk4Var.equals(xk4VarA)) {
                return new hu3.a(false, "Keep(com.fongmi.android.tv.bean.Keep).\n Expected:\n" + xk4Var + "\n Found:\n" + xk4VarA);
            }
            HashMap map2 = new HashMap(3);
            map2.put("key", new xk4.a("key", "TEXT", true, 1, null, 1));
            map2.put("searchable", new xk4.a("searchable", "INTEGER", false, 0, null, 1));
            map2.put("changeable", new xk4.a("changeable", "INTEGER", false, 0, null, 1));
            xk4 xk4Var2 = new xk4("Site", map2, new HashSet(0), new HashSet(0));
            xk4 xk4VarA2 = xk4.a(lw3Var, "Site");
            if (!xk4Var2.equals(xk4VarA2)) {
                return new hu3.a(false, "Site(com.fongmi.android.tv.bean.Site).\n Expected:\n" + xk4Var2 + "\n Found:\n" + xk4VarA2);
            }
            HashMap map3 = new HashMap(4);
            map3.put("name", new xk4.a("name", "TEXT", true, 1, null, 1));
            map3.put("keep", new xk4.a("keep", "TEXT", false, 0, null, 1));
            map3.put("boot", new xk4.a("boot", "INTEGER", true, 0, null, 1));
            map3.put("pass", new xk4.a("pass", "INTEGER", true, 0, null, 1));
            xk4 xk4Var3 = new xk4("Live", map3, new HashSet(0), new HashSet(0));
            xk4 xk4VarA3 = xk4.a(lw3Var, "Live");
            if (!xk4Var3.equals(xk4VarA3)) {
                return new hu3.a(false, "Live(com.fongmi.android.tv.bean.Live).\n Expected:\n" + xk4Var3 + "\n Found:\n" + xk4VarA3);
            }
            HashMap map4 = new HashMap(6);
            map4.put(Name.MARK, new xk4.a(Name.MARK, "INTEGER", true, 1, null, 1));
            map4.put("type", new xk4.a("type", "INTEGER", true, 0, null, 1));
            map4.put("key", new xk4.a("key", "TEXT", false, 0, null, 1));
            map4.put("name", new xk4.a("name", "TEXT", false, 0, null, 1));
            map4.put("format", new xk4.a("format", "TEXT", false, 0, null, 1));
            map4.put("selected", new xk4.a("selected", "INTEGER", true, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new xk4.d("index_Track_key_type", true, Arrays.asList("key", "type"), Arrays.asList("ASC", "ASC")));
            xk4 xk4Var4 = new xk4("Track", map4, hashSet, hashSet2);
            xk4 xk4VarA4 = xk4.a(lw3Var, "Track");
            if (!xk4Var4.equals(xk4VarA4)) {
                return new hu3.a(false, "Track(com.fongmi.android.tv.bean.Track).\n Expected:\n" + xk4Var4 + "\n Found:\n" + xk4VarA4);
            }
            HashMap map5 = new HashMap(9);
            map5.put(Name.MARK, new xk4.a(Name.MARK, "INTEGER", true, 1, null, 1));
            map5.put("type", new xk4.a("type", "INTEGER", true, 0, null, 1));
            map5.put("time", new xk4.a("time", "INTEGER", true, 0, null, 1));
            map5.put("url", new xk4.a("url", "TEXT", false, 0, null, 1));
            map5.put("json", new xk4.a("json", "TEXT", false, 0, null, 1));
            map5.put("name", new xk4.a("name", "TEXT", false, 0, null, 1));
            map5.put("logo", new xk4.a("logo", "TEXT", false, 0, null, 1));
            map5.put("home", new xk4.a("home", "TEXT", false, 0, null, 1));
            map5.put("parse", new xk4.a("parse", "TEXT", false, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(1);
            hashSet4.add(new xk4.d("index_Config_url_type", true, Arrays.asList("url", "type"), Arrays.asList("ASC", "ASC")));
            xk4 xk4Var5 = new xk4("Config", map5, hashSet3, hashSet4);
            xk4 xk4VarA5 = xk4.a(lw3Var, "Config");
            if (!xk4Var5.equals(xk4VarA5)) {
                return new hu3.a(false, "Config(com.fongmi.android.tv.bean.Config).\n Expected:\n" + xk4Var5 + "\n Found:\n" + xk4VarA5);
            }
            HashMap map6 = new HashMap(5);
            map6.put(Name.MARK, new xk4.a(Name.MARK, "INTEGER", false, 1, null, 1));
            map6.put("uuid", new xk4.a("uuid", "TEXT", false, 0, null, 1));
            map6.put("name", new xk4.a("name", "TEXT", false, 0, null, 1));
            map6.put("ip", new xk4.a("ip", "TEXT", false, 0, null, 1));
            map6.put("type", new xk4.a("type", "INTEGER", true, 0, null, 1));
            HashSet hashSet5 = new HashSet(0);
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new xk4.d("index_Device_uuid_name", true, Arrays.asList("uuid", "name"), Arrays.asList("ASC", "ASC")));
            xk4 xk4Var6 = new xk4("Device", map6, hashSet5, hashSet6);
            xk4 xk4VarA6 = xk4.a(lw3Var, "Device");
            if (!xk4Var6.equals(xk4VarA6)) {
                return new hu3.a(false, "Device(com.fongmi.android.tv.bean.Device).\n Expected:\n" + xk4Var6 + "\n Found:\n" + xk4VarA6);
            }
            HashMap map7 = new HashMap(16);
            map7.put("key", new xk4.a("key", "TEXT", true, 1, null, 1));
            map7.put("vodPic", new xk4.a("vodPic", "TEXT", false, 0, null, 1));
            map7.put("vodName", new xk4.a("vodName", "TEXT", false, 0, null, 1));
            map7.put("vodFlag", new xk4.a("vodFlag", "TEXT", false, 0, null, 1));
            map7.put("vodRemarks", new xk4.a("vodRemarks", "TEXT", false, 0, null, 1));
            map7.put("episodeUrl", new xk4.a("episodeUrl", "TEXT", false, 0, null, 1));
            map7.put("revSort", new xk4.a("revSort", "INTEGER", true, 0, null, 1));
            map7.put("revPlay", new xk4.a("revPlay", "INTEGER", true, 0, null, 1));
            map7.put("createTime", new xk4.a("createTime", "INTEGER", true, 0, null, 1));
            map7.put("opening", new xk4.a("opening", "INTEGER", true, 0, null, 1));
            map7.put("ending", new xk4.a("ending", "INTEGER", true, 0, null, 1));
            map7.put("position", new xk4.a("position", "INTEGER", true, 0, null, 1));
            map7.put("duration", new xk4.a("duration", "INTEGER", true, 0, null, 1));
            map7.put("speed", new xk4.a("speed", "REAL", true, 0, null, 1));
            map7.put("scale", new xk4.a("scale", "INTEGER", true, 0, null, 1));
            map7.put("cid", new xk4.a("cid", "INTEGER", true, 0, null, 1));
            xk4 xk4Var7 = new xk4("History", map7, new HashSet(0), new HashSet(0));
            xk4 xk4VarA7 = xk4.a(lw3Var, "History");
            if (xk4Var7.equals(xk4VarA7)) {
                return new hu3.a(true, null);
            }
            return new hu3.a(false, "History(com.fongmi.android.tv.bean.History).\n Expected:\n" + xk4Var7 + "\n Found:\n" + xk4VarA7);
        }
    }

    @Override // com.fongmi.android.tv.db.AppDatabase
    public hz R() {
        hz hzVar;
        if (this.t != null) {
            return this.t;
        }
        synchronized (this) {
            try {
                if (this.t == null) {
                    this.t = new wz(this);
                }
                hzVar = this.t;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hzVar;
    }

    @Override // com.fongmi.android.tv.db.AppDatabase
    public bk0 S() {
        bk0 bk0Var;
        if (this.u != null) {
            return this.u;
        }
        synchronized (this) {
            try {
                if (this.u == null) {
                    this.u = new jk0(this);
                }
                bk0Var = this.u;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bk0Var;
    }

    @Override // com.fongmi.android.tv.db.AppDatabase
    public yd1 T() {
        yd1 yd1Var;
        if (this.v != null) {
            return this.v;
        }
        synchronized (this) {
            try {
                if (this.v == null) {
                    this.v = new le1(this);
                }
                yd1Var = this.v;
            } catch (Throwable th) {
                throw th;
            }
        }
        return yd1Var;
    }

    @Override // com.fongmi.android.tv.db.AppDatabase
    public fq1 U() {
        fq1 fq1Var;
        if (this.p != null) {
            return this.p;
        }
        synchronized (this) {
            try {
                if (this.p == null) {
                    this.p = new vq1(this);
                }
                fq1Var = this.p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fq1Var;
    }

    @Override // com.fongmi.android.tv.db.AppDatabase
    public mx1 V() {
        mx1 mx1Var;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            try {
                if (this.r == null) {
                    this.r = new vx1(this);
                }
                mx1Var = this.r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mx1Var;
    }

    @Override // com.fongmi.android.tv.db.AppDatabase
    public f84 W() {
        f84 f84Var;
        if (this.q != null) {
            return this.q;
        }
        synchronized (this) {
            try {
                if (this.q == null) {
                    this.q = new n84(this);
                }
                f84Var = this.q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return f84Var;
    }

    @Override // com.fongmi.android.tv.db.AppDatabase
    public kq4 X() {
        kq4 kq4Var;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            try {
                if (this.s == null) {
                    this.s = new rq4(this);
                }
                kq4Var = this.s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return kq4Var;
    }

    @Override // defpackage.bu3
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public hu3 k() {
        return new a(35, "8191bb223b1cde184fbb43d20d39d851", "18ce7883bd230cacdfc2f52c5252793f");
    }

    @Override // defpackage.bu3
    public void g() {
        super.H(false, "Keep", "Site", "Live", "Track", "Config", "Device", "History");
    }

    @Override // defpackage.bu3
    public c j() {
        return new c(this, new HashMap(0), new HashMap(0), "Keep", "Site", "Live", "Track", "Config", "Device", "History");
    }

    @Override // defpackage.bu3
    public List m(Map map) {
        return new ArrayList();
    }

    @Override // defpackage.bu3
    public Set s() {
        return new HashSet();
    }

    @Override // defpackage.bu3
    public Map v() {
        HashMap map = new HashMap();
        map.put(fq1.class, vq1.G());
        map.put(f84.class, n84.q());
        map.put(mx1.class, vx1.s());
        map.put(kq4.class, rq4.p());
        map.put(hz.class, wz.E());
        map.put(bk0.class, jk0.q());
        map.put(yd1.class, le1.A());
        return map;
    }
}
