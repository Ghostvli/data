package org.xmlpull.v1.builder.impl;

import defpackage.jl;
import org.xmlpull.v1.builder.XmlComment;
import org.xmlpull.v1.builder.XmlContainer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class XmlCommentImpl implements XmlComment {
    private String content_;
    private XmlContainer owner_;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XmlCommentImpl(XmlContainer xmlContainer, String str) {
        this.owner_ = xmlContainer;
        this.content_ = str;
        if (str != null) {
            return;
        }
        jl.a("comment content can not be null");
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlComment
    public String getContent() {
        return this.content_;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlComment
    public XmlContainer getParent() {
        return this.owner_;
    }
}
