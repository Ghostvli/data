package org.xmlpull.v1.builder.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.builder.XmlBuilderException;
import org.xmlpull.v1.builder.XmlComment;
import org.xmlpull.v1.builder.XmlDoctype;
import org.xmlpull.v1.builder.XmlDocument;
import org.xmlpull.v1.builder.XmlElement;
import org.xmlpull.v1.builder.XmlNamespace;
import org.xmlpull.v1.builder.XmlNotation;
import org.xmlpull.v1.builder.XmlProcessingInstruction;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class XmlDocumentImpl implements XmlDocument {
    private String characterEncoding;
    private List children = new ArrayList();
    private XmlElement root;
    private Boolean standalone;
    private String version;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XmlDocumentImpl(String str, Boolean bool, String str2) {
        this.version = str;
        this.standalone = bool;
        this.characterEncoding = str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public void addChild(Object obj) {
        throw new XmlBuilderException("not implemented");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlComment addComment(String str) {
        XmlCommentImpl xmlCommentImpl = new XmlCommentImpl(this, str);
        this.children.add(xmlCommentImpl);
        return xmlCommentImpl;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlDoctype addDoctype(String str, String str2) {
        throw new XmlBuilderException("not implemented");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlElement addDocumentElement(XmlNamespace xmlNamespace, String str) {
        XmlElementImpl xmlElementImpl = new XmlElementImpl(xmlNamespace, str);
        if (getDocumentElement() != null) {
            throw new XmlBuilderException("document already has root element");
        }
        setDocumentElement(xmlElementImpl);
        return xmlElementImpl;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlNotation addNotation(String str, String str2, String str3, String str4) {
        throw new XmlBuilderException("not implemented");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlProcessingInstruction addProcessingInstruction(String str, String str2) {
        throw new XmlBuilderException("not implemented");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public Iterator children() {
        return this.children.iterator();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public String getBaseUri() {
        throw new XmlBuilderException("not implemented");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public String getCharacterEncodingScheme() {
        return this.characterEncoding;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlElement getDocumentElement() {
        return this.root;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public String getVersion() {
        return this.version;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public void insertChild(int i, Object obj) {
        throw new XmlBuilderException("not implemented");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public boolean isAllDeclarationsProcessed() {
        throw new XmlBuilderException("not implemented");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public Boolean isStandalone() {
        return this.standalone;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlComment newComment(String str) {
        return new XmlCommentImpl(null, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlDoctype newDoctype(String str, String str2) {
        throw new XmlBuilderException("not implemented");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlProcessingInstruction newProcessingInstruction(String str, String str2) {
        throw new XmlBuilderException("not implemented");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public Iterator notations() {
        throw new XmlBuilderException("not implemented");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public void remocveAllUnparsedEntities() {
        throw new XmlBuilderException("not implemented");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public void removeAllChildren() {
        throw new XmlBuilderException("not implemented");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public void removeAllNotations() {
        throw new XmlBuilderException("not implemented");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public void setCharacterEncodingScheme(String str) {
        this.characterEncoding = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public void setDocumentElement(XmlElement xmlElement) {
        boolean z = false;
        for (int i = 0; i < this.children.size(); i++) {
            if (this.children.get(i) == this.root) {
                this.children.set(i, xmlElement);
                z = true;
            }
        }
        if (!z) {
            this.children.add(xmlElement);
        }
        this.root = xmlElement;
        xmlElement.setParent(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlDocument
    public Iterator unparsedEntities() {
        throw new XmlBuilderException("not implemented");
    }

    @Override // org.xmlpull.v1.builder.XmlDocument
    public XmlElement addDocumentElement(String str) {
        return addDocumentElement(null, str);
    }
}
