package org.jupnp.model.message.header;

import defpackage.fq0;
import defpackage.j02;
import defpackage.n02;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class CallbackHeader extends UpnpHeader<List<URL>> {
    private final j02 logger;

    public CallbackHeader() {
        this.logger = n02.k(CallbackHeader.class);
        setValue(new ArrayList());
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        StringBuilder sb = new StringBuilder();
        for (URL url : getValue()) {
            sb.append("<");
            sb.append(url.toString());
            sb.append(">");
        }
        return sb.toString();
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        if (str.isEmpty()) {
            return;
        }
        if (!str.contains("<") || !str.contains(">")) {
            fq0.a("URLs not in brackets: ".concat(str));
            return;
        }
        String strReplaceAll = str.replaceAll("<", "");
        String[] strArrSplit = strReplaceAll.split(">");
        try {
            ArrayList arrayList = new ArrayList();
            for (String str2 : strArrSplit) {
                String strTrim = str2.trim();
                if (strTrim.startsWith("http://")) {
                    URL url = new URL(strTrim);
                    try {
                        url.toURI();
                        arrayList.add(url);
                    } catch (URISyntaxException e) {
                        this.logger.m("Discarding callback URL, not a valid URI on this platform: {}", url, e);
                    }
                } else {
                    this.logger.d("Discarding non-http callback URL: {}", strTrim);
                }
            }
            setValue(arrayList);
        } catch (MalformedURLException e2) {
            throw new InvalidHeaderException("Can't parse callback URLs from '" + strReplaceAll + "'", e2);
        }
    }

    public CallbackHeader(List<URL> list) {
        this();
        getValue().addAll(list);
    }

    public CallbackHeader(URL url) {
        this();
        getValue().add(url);
    }
}
