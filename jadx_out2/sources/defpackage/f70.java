package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fongmi.android.tv.App;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.utils.Util;
import fi.iki.elonen.NanoHTTPD;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class f70 extends WebView implements DialogInterface.OnDismissListener {
    public static final String q = "f70";
    public static final Pattern r = Pattern.compile("player.*https?://");
    public final AtomicReference f;
    public LinkedHashSet g;
    public WebResourceResponse h;
    public t85 i;
    public Runnable j;
    public boolean k;
    public boolean l;
    public String m;
    public String n;
    public String o;
    public String p;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends WebViewClient {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final /* synthetic */ void b() {
            f70.this.F();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (str.equals("about:blank")) {
                return;
            }
            f70 f70Var = f70.this;
            f70Var.s(f70Var.t(str), 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            String string = webResourceRequest.getUrl().toString();
            String host = webResourceRequest.getUrl().getHost();
            if (TextUtils.isEmpty(host) || f70.this.w(host)) {
                return f70.this.h;
            }
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (string.contains("/cdn-cgi/challenge-platform/")) {
                f70.this.post(new Runnable() { // from class: e70
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.b();
                    }
                });
            }
            if (f70.this.l && f70.r.matcher(string).find() && f70.this.p(string)) {
                f70.this.C(requestHeaders, string);
            } else if (f70.this.x(string)) {
                f70.this.E(requestHeaders, string);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public f70(Context context) {
        super(context);
        this.f = new AtomicReference();
        v();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static f70 r(Context context) {
        return new f70(context);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void A(Map map, String str, w73 w73Var) {
        r(App.b()).G(this.o, this.n, map, str, this.m, w73Var, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void B() {
        I(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C(final Map map, final String str) {
        final w73 w73Var = (w73) this.f.get();
        if (w73Var == null) {
            return;
        }
        post(new Runnable() { // from class: c70
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.A(map, str, w73Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D() {
        w73 w73Var = (w73) this.f.getAndSet(null);
        if (w73Var != null) {
            w73Var.a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E(Map map, String str) {
        w73 w73Var = (w73) this.f.getAndSet(null);
        if (w73Var != null) {
            w73Var.b(map, str, this.n);
        }
        post(new Runnable() { // from class: d70
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.B();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F() {
        if (this.i != null || App.a() == null) {
            return;
        }
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        this.i = new t85(this).c();
        App.f(this.j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public f70 G(String str, String str2, Map map, String str3, String str4, w73 w73Var, boolean z) {
        SpiderDebug.log(q, "key=%s, from=%s, click=%s, url=%s, headers=%s", str, str2, str4, str3, map);
        App.e(this.j, f10.k);
        this.f.set(w73Var);
        this.l = z;
        this.m = str4;
        this.n = str2;
        this.o = str;
        this.p = str3;
        H(map);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H(Map map) {
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        q(this.p, map);
        loadUrl(this.p, map);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I(boolean z) {
        if (this.k) {
            return;
        }
        this.k = true;
        u();
        stopLoading();
        loadUrl("about:blank");
        App.f(this.j);
        if (z) {
            D();
        } else {
            this.f.set(null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final WebViewClient J() {
        return new a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        I(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean p(String str) {
        if (this.g.size() > 5) {
            this.g.clear();
        }
        return this.g.add(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q(String str, Map map) {
        for (String str2 : map.keySet()) {
            if ("User-Agent".equalsIgnoreCase(str2)) {
                getSettings().setUserAgentString((String) map.get(str2));
            } else if ("Cookie".equalsIgnoreCase(str2)) {
                CookieManager.getInstance().setCookie(str, (String) map.get(str2));
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s(final List list, final int i) {
        if (i >= list.size()) {
            return;
        }
        String str = (String) list.get(i);
        if (TextUtils.isEmpty(str)) {
            s(list, i + 1);
        } else {
            evaluateJavascript(str, new ValueCallback() { // from class: b70
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    this.a.y(list, i, (String) obj);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List t(String str) {
        ArrayList arrayList = new ArrayList(u94.c(Uri.parse(str)));
        if (!TextUtils.isEmpty(this.m) && !arrayList.contains(this.m)) {
            arrayList.add(0, this.m);
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u() {
        t85 t85Var = this.i;
        if (t85Var != null) {
            t85Var.a();
        }
        this.i = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v() {
        this.j = new Runnable() { // from class: a70
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.z();
            }
        };
        this.g = new LinkedHashSet();
        this.h = new WebResourceResponse(NanoHTTPD.MIME_PLAINTEXT, "utf-8", new ByteArrayInputStream("".getBytes()));
        WebSettings settings = getSettings();
        settings.setSupportZoom(true);
        settings.setUseWideViewPort(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUserAgentString(q24.s());
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setMixedContentMode(0);
        setWebViewClient(J());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean w(String str) {
        Iterator it = bw3.a().b().iterator();
        while (it.hasNext()) {
            if (Util.containOrMatch(str, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean x(String str) {
        try {
            if (!this.l && str.equals(this.p)) {
                return false;
            }
            Spider spider = b75.I().W(this.o).spider();
            return spider.manualVideoCheck() ? spider.isVideoFormat(str) : u94.e(str);
        } catch (Exception unused) {
            return u94.e(str);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void y(List list, int i, String str) {
        s(list, i + 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void z() {
        I(true);
    }
}
