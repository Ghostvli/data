package org.xmlpull.v1.wrapper;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import org.xmlpull.v1.wrapper.classic.StaticXmlPullParserWrapper;
import org.xmlpull.v1.wrapper.classic.StaticXmlSerializerWrapper;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class XmlPullWrapperFactory {
    private static final boolean DEBUG = false;
    protected XmlPullParserFactory f;

    public XmlPullWrapperFactory(XmlPullParserFactory xmlPullParserFactory) {
        if (xmlPullParserFactory != null) {
            this.f = xmlPullParserFactory;
        } else {
            this.f = XmlPullParserFactory.newInstance();
        }
    }

    public static XmlPullWrapperFactory newInstance(String str, Class cls) {
        return new XmlPullWrapperFactory(XmlPullParserFactory.newInstance(str, cls));
    }

    public XmlPullParserFactory getFactory() {
        return this.f;
    }

    public boolean getFeature(String str) {
        return this.f.getFeature(str);
    }

    public boolean isNamespaceAware() {
        return this.f.isNamespaceAware();
    }

    public boolean isValidating() {
        return this.f.isValidating();
    }

    public XmlPullParserWrapper newPullParserWrapper() {
        return new StaticXmlPullParserWrapper(this.f.newPullParser());
    }

    public XmlSerializerWrapper newSerializerWrapper() {
        return new StaticXmlSerializerWrapper(this.f.newSerializer(), this);
    }

    public void setFeature(String str, boolean z) {
        this.f.setFeature(str, z);
    }

    public void setNamespaceAware(boolean z) {
        this.f.setNamespaceAware(z);
    }

    public void setValidating(boolean z) {
        this.f.setValidating(z);
    }

    public static XmlPullWrapperFactory newInstance(XmlPullParserFactory xmlPullParserFactory) {
        return new XmlPullWrapperFactory(xmlPullParserFactory);
    }

    public static XmlPullWrapperFactory newInstance() {
        return new XmlPullWrapperFactory(null);
    }

    public XmlPullParserWrapper newPullParserWrapper(XmlPullParser xmlPullParser) {
        return new StaticXmlPullParserWrapper(xmlPullParser);
    }

    public XmlSerializerWrapper newSerializerWrapper(XmlSerializer xmlSerializer) {
        return new StaticXmlSerializerWrapper(xmlSerializer, this);
    }
}
