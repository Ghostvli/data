package org.xmlpull.v1.builder.impl;

import defpackage.jl;
import org.xmlpull.v1.builder.XmlAttribute;
import org.xmlpull.v1.builder.XmlElement;
import org.xmlpull.v1.builder.XmlNamespace;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class XmlAttributeImpl implements XmlAttribute {
    private boolean default_;
    private String name_;
    private XmlNamespace namespace_;
    private XmlElement owner_;
    private String prefix_;
    private String type_;
    private String value_;

    public XmlAttributeImpl(XmlElement xmlElement, String str, String str2) {
        this.type_ = "CDATA";
        this.owner_ = xmlElement;
        this.name_ = str;
        if (str2 != null) {
            this.value_ = str2;
        } else {
            jl.a("attribute value can not be null");
            throw null;
        }
    }

    @Override // org.xmlpull.v1.builder.XmlAttribute
    public String getName() {
        return this.name_;
    }

    @Override // org.xmlpull.v1.builder.XmlAttribute
    public XmlNamespace getNamespace() {
        return this.namespace_;
    }

    @Override // org.xmlpull.v1.builder.XmlAttribute
    public String getNamespaceName() {
        XmlNamespace xmlNamespace = this.namespace_;
        if (xmlNamespace != null) {
            return xmlNamespace.getNamespaceName();
        }
        return null;
    }

    @Override // org.xmlpull.v1.builder.XmlAttribute
    public XmlElement getOwner() {
        return this.owner_;
    }

    @Override // org.xmlpull.v1.builder.XmlAttribute
    public String getType() {
        return this.type_;
    }

    @Override // org.xmlpull.v1.builder.XmlAttribute
    public String getValue() {
        return this.value_;
    }

    @Override // org.xmlpull.v1.builder.XmlAttribute
    public boolean isSpecified() {
        return !this.default_;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("name=");
        stringBuffer.append(this.name_);
        stringBuffer.append(" value=");
        stringBuffer.append(this.value_);
        return stringBuffer.toString();
    }

    public XmlAttributeImpl(XmlElement xmlElement, XmlNamespace xmlNamespace, String str, String str2) {
        this(xmlElement, str, str2);
        this.namespace_ = xmlNamespace;
    }

    public XmlAttributeImpl(XmlElement xmlElement, String str, XmlNamespace xmlNamespace, String str2, String str3) {
        this(xmlElement, xmlNamespace, str2, str3);
        this.type_ = str;
    }

    public XmlAttributeImpl(XmlElement xmlElement, String str, XmlNamespace xmlNamespace, String str2, String str3, boolean z) {
        this(xmlElement, xmlNamespace, str2, str3);
        if (str != null) {
            this.type_ = str;
            this.default_ = !z;
        } else {
            jl.a("attribute type can not be null");
            throw null;
        }
    }
}
