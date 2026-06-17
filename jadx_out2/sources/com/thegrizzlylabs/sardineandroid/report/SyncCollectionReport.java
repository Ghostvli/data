package com.thegrizzlylabs.sardineandroid.report;

import com.thegrizzlylabs.sardineandroid.DavResource;
import com.thegrizzlylabs.sardineandroid.model.Limit;
import com.thegrizzlylabs.sardineandroid.model.Multistatus;
import com.thegrizzlylabs.sardineandroid.model.Prop;
import com.thegrizzlylabs.sardineandroid.model.Response;
import com.thegrizzlylabs.sardineandroid.model.SyncCollection;
import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SyncCollectionReport extends SardineReport<Result> {
    private static final Logger log = Logger.getLogger(SardineReport.class.getName());
    private final Integer limit;
    private final Set<QName> properties;
    private final SyncLevel syncLevel;
    private final String syncToken;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Result {
        private final List<DavResource> resources;
        private final String syncToken;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Result(List<DavResource> list, String str) {
            this.resources = list;
            this.syncToken = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public List<DavResource> getResources() {
            return this.resources;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String getSyncToken() {
            return this.syncToken;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum SyncLevel {
        LEVEL_1("1"),
        LEVEL_INFINITY("infinite");

        private final String value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        SyncLevel(String str) {
            this.value = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SyncCollectionReport(String str, SyncLevel syncLevel, Set<QName> set, Integer num) {
        this.syncToken = str;
        this.syncLevel = syncLevel;
        this.properties = set;
        this.limit = num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: fromMultistatus(Lcom/thegrizzlylabs/sardineandroid/model/Multistatus;)Ljava/lang/Object; */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.thegrizzlylabs.sardineandroid.report.SardineReport
    public Result fromMultistatus(Multistatus multistatus) {
        List<Response> response = multistatus.getResponse();
        ArrayList arrayList = new ArrayList(response.size());
        for (Response response2 : response) {
            try {
                arrayList.add(new DavResource(response2));
            } catch (URISyntaxException unused) {
                log.warning(String.format("Ignore resource with invalid URI %s", response2.getHref()));
            }
        }
        return new Result(arrayList, multistatus.getSyncToken());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.report.SardineReport
    public Object toJaxb() {
        Prop prop = new Prop();
        List<Element> any = prop.getAny();
        Iterator<QName> it = this.properties.iterator();
        while (it.hasNext()) {
            any.add(SardineUtil.createElement(it.next()));
        }
        SyncCollection syncCollection = new SyncCollection();
        String str = this.syncToken;
        if (str == null) {
            str = "";
        }
        syncCollection.setSyncToken(str);
        syncCollection.setSyncLevel(this.syncLevel.toString());
        syncCollection.setProp(prop);
        Integer num = this.limit;
        if (num != null && num.intValue() > 0) {
            Limit limit = new Limit();
            limit.setNresults(BigInteger.valueOf(this.limit.intValue()));
            syncCollection.setLimit(limit);
        }
        return syncCollection;
    }
}
