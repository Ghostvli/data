package org.xmlpull.v1.builder;

import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface XmlPullElement extends XmlElement {
    @Override // org.xmlpull.v1.builder.XmlElement
    Iterator children();

    boolean fullyConstructed();

    XmlPullParser nextChildAsPullParser();

    XmlPullElement readNextChild();

    boolean skipNextChild();
}
