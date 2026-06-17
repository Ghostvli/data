package org.mozilla.javascript.xml;

import defpackage.z20;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Ref;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class XMLLib {
    private static final Object XML_LIB_KEY = new Object();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class Factory {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static Factory create(final String str) {
            return new Factory() { // from class: org.mozilla.javascript.xml.XMLLib.Factory.1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // org.mozilla.javascript.xml.XMLLib.Factory
                public String getImplementationClassName() {
                    return str;
                }
            };
        }

        public abstract String getImplementationClassName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static XMLLib extractFromScope(Scriptable scriptable) {
        XMLLib xMLLibExtractFromScopeOrNull = extractFromScopeOrNull(scriptable);
        if (xMLLibExtractFromScopeOrNull != null) {
            return xMLLibExtractFromScopeOrNull;
        }
        throw Context.reportRuntimeError(ScriptRuntime.getMessageById("msg.XML.not.available", new Object[0]));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static XMLLib extractFromScopeOrNull(Scriptable scriptable) {
        ScriptableObject libraryScopeOrNull = ScriptRuntime.getLibraryScopeOrNull(scriptable);
        if (libraryScopeOrNull == null) {
            return null;
        }
        ScriptableObject.getProperty(libraryScopeOrNull, "XML");
        return (XMLLib) libraryScopeOrNull.getAssociatedValue(XML_LIB_KEY);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final XMLLib bindToScope(Scriptable scriptable) {
        ScriptableObject libraryScopeOrNull = ScriptRuntime.getLibraryScopeOrNull(scriptable);
        if (libraryScopeOrNull != null) {
            return (XMLLib) libraryScopeOrNull.associateValue(XML_LIB_KEY, this);
        }
        z20.a();
        return null;
    }

    public abstract String escapeAttributeValue(Object obj);

    public abstract String escapeTextValue(Object obj);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getPrettyIndent() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isIgnoreComments() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isIgnoreProcessingInstructions() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isIgnoreWhitespace() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isPrettyPrinting() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isXMLName(Context context, Object obj);

    public abstract Ref nameRef(Context context, Object obj, Object obj2, Scriptable scriptable, int i);

    public abstract Ref nameRef(Context context, Object obj, Scriptable scriptable, int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIgnoreComments(boolean z) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIgnoreProcessingInstructions(boolean z) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setIgnoreWhitespace(boolean z) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPrettyIndent(int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPrettyPrinting(boolean z) {
        throw new UnsupportedOperationException();
    }

    public abstract Object toDefaultXmlNamespace(Context context, Object obj);
}
