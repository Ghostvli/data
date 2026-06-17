package org.xmlpull.mxp1;

import java.util.Enumeration;
import org.xmlpull.mxp1_serializer.MXSerializer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MXParserFactory extends XmlPullParserFactory {
    protected static boolean stringCachedParserAvailable = true;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParserFactory
    public XmlPullParser newPullParser() {
        MXParser mXParserCachingStrings;
        if (stringCachedParserAvailable) {
            try {
                mXParserCachingStrings = new MXParserCachingStrings();
            } catch (Exception unused) {
                stringCachedParserAvailable = false;
                mXParserCachingStrings = null;
            }
        } else {
            mXParserCachingStrings = null;
        }
        if (mXParserCachingStrings == null) {
            mXParserCachingStrings = new MXParser();
        }
        Enumeration enumerationKeys = this.features.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            Boolean bool = (Boolean) this.features.get(str);
            if (bool != null && bool.booleanValue()) {
                mXParserCachingStrings.setFeature(str, true);
            }
        }
        return mXParserCachingStrings;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParserFactory
    public XmlSerializer newSerializer() {
        return new MXSerializer();
    }
}
