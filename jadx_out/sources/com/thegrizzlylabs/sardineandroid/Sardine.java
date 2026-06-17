package com.thegrizzlylabs.sardineandroid;

import com.thegrizzlylabs.sardineandroid.report.SardineReport;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface Sardine {
    void copy(String str, String str2);

    void copy(String str, String str2, boolean z);

    void createDirectory(String str);

    void delete(String str);

    void disableCompression();

    void enableCompression();

    boolean exists(String str);

    InputStream get(String str);

    InputStream get(String str, Map<String, String> map);

    DavAcl getAcl(String str);

    List<String> getPrincipalCollectionSet(String str);

    List<DavPrincipal> getPrincipals(String str);

    DavQuota getQuota(String str);

    @Deprecated
    List<DavResource> getResources(String str);

    void ignoreCookies();

    List<DavResource> list(String str);

    List<DavResource> list(String str, int i);

    List<DavResource> list(String str, int i, Set<QName> set);

    List<DavResource> list(String str, int i, boolean z);

    String lock(String str);

    String lock(String str, int i);

    void move(String str, String str2);

    void move(String str, String str2, boolean z);

    void move(String str, String str2, boolean z, String str3);

    List<DavResource> patch(String str, List<Element> list, List<QName> list2);

    List<DavResource> patch(String str, Map<QName, String> map);

    List<DavResource> patch(String str, Map<QName, String> map, List<QName> list);

    List<DavResource> propfind(String str, int i, Set<QName> set);

    void put(String str, File file, String str2);

    void put(String str, File file, String str2, boolean z);

    void put(String str, File file, String str2, boolean z, String str3);

    void put(String str, byte[] bArr);

    void put(String str, byte[] bArr, String str2);

    String refreshLock(String str, String str2, String str3);

    <T> T report(String str, int i, SardineReport<T> sardineReport);

    List<DavResource> search(String str, String str2, String str3);

    void setAcl(String str, List<DavAce> list);

    void setCredentials(String str, String str2);

    void setCredentials(String str, String str2, boolean z);

    @Deprecated
    void setCustomProps(String str, Map<String, String> map, List<String> list);

    void unlock(String str, String str2);
}
