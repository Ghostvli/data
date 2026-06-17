package org.xmlpull.v1.builder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import org.xmlpull.v1.builder.impl.XmlPullBuilderImpl;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class XmlPullBuilder {
    protected XmlPullParserFactory factory;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static XmlPullBuilder newInstance() {
        XmlPullBuilderImpl xmlPullBuilderImpl = new XmlPullBuilderImpl();
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            xmlPullBuilderImpl.factory = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
            return xmlPullBuilderImpl;
        } catch (XmlPullParserException e) {
            StringBuffer stringBuffer = new StringBuffer("could not create XmlPull factory:");
            stringBuffer.append(e);
            throw new XmlBuilderException(stringBuffer.toString(), e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XmlPullParserFactory getFactory() {
        return this.factory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XmlDocument newDocument() {
        return newDocument(null, null, null);
    }

    public abstract XmlDocument newDocument(String str, Boolean bool, String str2);

    public abstract XmlElement newFragment(String str);

    public abstract XmlElement newFragment(String str, String str2);

    public abstract XmlElement newFragment(XmlNamespace xmlNamespace, String str);

    public abstract XmlNamespace newNamespace(String str);

    public abstract XmlNamespace newNamespace(String str, String str2);

    public abstract XmlDocument parse(XmlPullParser xmlPullParser);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XmlElement parseFragementFromInputStream(InputStream inputStream, String str) {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.factory.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, str);
            try {
                xmlPullParserNewPullParser.nextTag();
                return parseFragment(xmlPullParserNewPullParser);
            } catch (IOException e) {
                StringBuffer stringBuffer = new StringBuffer("IO error when starting to parse input stream (encoding=");
                stringBuffer.append(str);
                stringBuffer.append(")");
                throw new XmlBuilderException(stringBuffer.toString(), e);
            }
        } catch (XmlPullParserException e2) {
            StringBuffer stringBuffer2 = new StringBuffer("could not start parsing input stream (encoding=");
            stringBuffer2.append(str);
            stringBuffer2.append(")");
            throw new XmlBuilderException(stringBuffer2.toString(), e2);
        }
    }

    public abstract XmlElement parseFragment(XmlPullParser xmlPullParser);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XmlElement parseFragmentFromInputStream(InputStream inputStream) {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.factory.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            try {
                xmlPullParserNewPullParser.nextTag();
                return parseFragment(xmlPullParserNewPullParser);
            } catch (IOException e) {
                throw new XmlBuilderException("IO error when starting to parse input stream", e);
            }
        } catch (XmlPullParserException e2) {
            throw new XmlBuilderException("could not start parsing input stream", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XmlElement parseFragmentFromReader(Reader reader) {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.factory.newPullParser();
            xmlPullParserNewPullParser.setInput(reader);
            try {
                xmlPullParserNewPullParser.nextTag();
                return parseFragment(xmlPullParserNewPullParser);
            } catch (IOException e) {
                throw new XmlBuilderException("IO error when starting to parse from reader", e);
            }
        } catch (XmlPullParserException e2) {
            throw new XmlBuilderException("could not start parsing input from reader", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XmlDocument parseInputStream(InputStream inputStream, String str) {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.factory.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, str);
            return parse(xmlPullParserNewPullParser);
        } catch (XmlPullParserException e) {
            StringBuffer stringBuffer = new StringBuffer("could not start parsing input stream (encoding=");
            stringBuffer.append(str);
            stringBuffer.append(")");
            throw new XmlBuilderException(stringBuffer.toString(), e);
        }
    }

    public abstract Object parseItem(XmlPullParser xmlPullParser);

    public abstract XmlDocument parseLocation(String str);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XmlDocument parseReader(Reader reader) {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.factory.newPullParser();
            xmlPullParserNewPullParser.setInput(reader);
            return parse(xmlPullParserNewPullParser);
        } catch (XmlPullParserException e) {
            throw new XmlBuilderException("could not start parsing input from reader", e);
        }
    }

    public abstract XmlElement parseStartTag(XmlPullParser xmlPullParser);

    public abstract void serialize(Object obj, XmlSerializer xmlSerializer);

    public abstract void serializeEndTag(XmlElement xmlElement, XmlSerializer xmlSerializer);

    public abstract void serializeItem(Object obj, XmlSerializer xmlSerializer);

    public abstract void serializeStartTag(XmlElement xmlElement, XmlSerializer xmlSerializer);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void serializeToOutputStream(Object obj, OutputStream outputStream, String str) {
        try {
            XmlSerializer xmlSerializerNewSerializer = this.factory.newSerializer();
            xmlSerializerNewSerializer.setOutput(outputStream, str);
            serialize(obj, xmlSerializerNewSerializer);
        } catch (Exception e) {
            StringBuffer stringBuffer = new StringBuffer("could not serialize node to output stream (encoding=");
            stringBuffer.append(str);
            stringBuffer.append(")");
            throw new XmlBuilderException(stringBuffer.toString(), e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String serializeToString(Object obj) {
        StringWriter stringWriter = new StringWriter();
        serializeToWriter(obj, stringWriter);
        return stringWriter.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void serializeToWriter(Object obj, Writer writer) {
        try {
            XmlSerializer xmlSerializerNewSerializer = this.factory.newSerializer();
            xmlSerializerNewSerializer.setOutput(writer);
            serialize(obj, xmlSerializerNewSerializer);
        } catch (Exception e) {
            throw new XmlBuilderException("could not serialize node to writer", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void skipSubTree(XmlPullParser xmlPullParser) {
        try {
            xmlPullParser.require(2, null, null);
            int i = 1;
            while (i > 0) {
                int next = xmlPullParser.next();
                if (next == 3) {
                    i--;
                } else if (next == 2) {
                    i++;
                }
            }
        } catch (IOException e) {
            throw new XmlBuilderException("IO error when skipping subtree", e);
        } catch (XmlPullParserException e2) {
            throw new XmlBuilderException("could not skip subtree", e2);
        }
    }

    public void serializeToOutputStream(Object obj, OutputStream outputStream) {
        serializeToOutputStream(obj, outputStream, "UTF8");
    }

    public XmlDocument parseInputStream(InputStream inputStream) {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.factory.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            return parse(xmlPullParserNewPullParser);
        } catch (XmlPullParserException e) {
            throw new XmlBuilderException("could not start parsing input stream", e);
        }
    }
}
