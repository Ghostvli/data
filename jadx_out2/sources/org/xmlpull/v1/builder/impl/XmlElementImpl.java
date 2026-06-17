package org.xmlpull.v1.builder.impl;

import defpackage.jl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.builder.XmlAttribute;
import org.xmlpull.v1.builder.XmlBuilderException;
import org.xmlpull.v1.builder.XmlContainer;
import org.xmlpull.v1.builder.XmlDocument;
import org.xmlpull.v1.builder.XmlElement;
import org.xmlpull.v1.builder.XmlNamespace;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class XmlElementImpl implements XmlElement {
    private static final Iterator EMPTY_ITERATOR = new EmptyIterator(null);
    private List attrs;
    private List children;
    private String name;
    private XmlNamespace namespace;
    private List nsList;
    private XmlContainer parent;

    /* JADX INFO: renamed from: org.xmlpull.v1.builder.impl.XmlElementImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    class AnonymousClass1 {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XmlElementImpl(String str, String str2) {
        if (str != null) {
            this.namespace = new XmlNamespaceImpl(null, str);
        }
        this.name = str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void checkChildParent(Object obj) {
        if (obj instanceof XmlContainer) {
            if (!(obj instanceof XmlElement)) {
                if (obj instanceof XmlDocument) {
                    throw new XmlBuilderException("docuemet can not be stored as element child");
                }
            } else {
                XmlContainer parent = ((XmlElement) obj).getParent();
                if (parent != null && parent != this.parent) {
                    throw new XmlBuilderException("child must have no parent to be added to this node");
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void setChildParent(Object obj) {
        if (obj instanceof XmlElement) {
            ((XmlElement) obj).setParent(this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(String str, XmlNamespace xmlNamespace, String str2, String str3, boolean z) {
        return addAttribute(new XmlAttributeImpl(this, str, xmlNamespace, str2, str3, z));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public void addChild(Object obj) {
        if (this.children == null) {
            ensureChildrenCapacity(1);
        }
        checkChildParent(obj);
        this.children.add(obj);
        setChildParent(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement addElement(XmlNamespace xmlNamespace, String str) {
        XmlElement xmlElementNewElement = newElement(xmlNamespace, str);
        addChild(xmlElementNewElement);
        return xmlElementNewElement;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public Iterator attributes() {
        List list = this.attrs;
        return list == null ? EMPTY_ITERATOR : list.iterator();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public Iterator children() {
        List list = this.children;
        return list == null ? EMPTY_ITERATOR : list.iterator();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace declareNamespace(XmlNamespace xmlNamespace) {
        if (xmlNamespace.getPrefix() == null) {
            throw new XmlBuilderException("namespace added to element must have not null prefix");
        }
        if (this.nsList == null) {
            ensureNamespaceDeclarationsCapacity(5);
        }
        this.nsList.add(xmlNamespace);
        return xmlNamespace;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public void ensureAttributeCapacity(int i) {
        List list = this.attrs;
        if (list == null) {
            this.attrs = new ArrayList(i);
        } else {
            ((ArrayList) list).ensureCapacity(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public void ensureChildrenCapacity(int i) {
        List list = this.children;
        if (list == null) {
            this.children = new ArrayList(i);
        } else {
            ((ArrayList) list).ensureCapacity(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public void ensureNamespaceDeclarationsCapacity(int i) {
        List list = this.nsList;
        if (list == null) {
            this.nsList = new ArrayList(i);
        } else {
            ((ArrayList) list).ensureCapacity(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute findAttribute(String str, String str2) {
        if (str2 == null) {
            jl.a("attribute name ca not ber null");
            return null;
        }
        List list = this.attrs;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            XmlAttribute xmlAttribute = (XmlAttribute) this.attrs.get(i);
            String name = xmlAttribute.getName();
            if (name == str2 || str2.equals(name)) {
                if (str != null) {
                    String namespaceName = xmlAttribute.getNamespaceName();
                    if (str.equals(namespaceName) || (str == "" && namespaceName == null)) {
                        return xmlAttribute;
                    }
                } else if (xmlAttribute.getNamespace() == null || xmlAttribute.getNamespace().getNamespaceName() == "") {
                    return xmlAttribute;
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement findElementByName(String str) {
        List list = this.children;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = this.children.get(i);
            if (obj instanceof XmlElement) {
                XmlElement xmlElement = (XmlElement) obj;
                if (str.equals(xmlElement.getName())) {
                    return xmlElement;
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public String getBaseUri() {
        throw new XmlBuilderException("not implemented");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public String getName() {
        return this.name;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace getNamespace() {
        return this.namespace;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public String getNamespaceName() {
        XmlNamespace xmlNamespace = this.namespace;
        if (xmlNamespace != null) {
            return xmlNamespace.getNamespaceName();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlContainer getParent() {
        return this.parent;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public boolean hasAttributes() {
        List list = this.attrs;
        return list != null && list.size() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public boolean hasChild(Object obj) {
        if (this.children == null) {
            return false;
        }
        for (int i = 0; i < this.children.size(); i++) {
            if (this.children.get(i) == obj) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public boolean hasChildren() {
        List list = this.children;
        return list != null && list.size() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public boolean hasNamespaceDeclarations() {
        List list = this.nsList;
        return list != null && list.size() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public void insertChild(int i, Object obj) {
        this.children.set(i, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace lookupNamespaceByName(String str) {
        if (str == null) {
            jl.a("namespace name can not ber null");
            return null;
        }
        if (hasNamespaceDeclarations()) {
            int size = this.nsList.size();
            for (int i = 0; i < size; i++) {
                XmlNamespace xmlNamespace = (XmlNamespace) this.nsList.get(i);
                if (str.equals(xmlNamespace.getNamespaceName())) {
                    return xmlNamespace;
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace lookupNamespaceByPrefix(String str) {
        if (str == null) {
            jl.a("namespace prefix can not ber null");
            return null;
        }
        if (hasNamespaceDeclarations()) {
            int size = this.nsList.size();
            for (int i = 0; i < size; i++) {
                XmlNamespace xmlNamespace = (XmlNamespace) this.nsList.get(i);
                if (str.equals(xmlNamespace.getPrefix())) {
                    return xmlNamespace;
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public Iterator namespaces() {
        List list = this.nsList;
        return list == null ? EMPTY_ITERATOR : list.iterator();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement newElement(String str) {
        return newElement((XmlNamespace) null, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace newNamespace(String str) {
        return newNamespace(null, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public void removeAllAttributes() {
        this.attrs = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public void removeAllChildren() {
        this.children = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public void removeAllNamespaceDeclarations() {
        this.nsList = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public void removeAttribute(XmlAttribute xmlAttribute) {
        for (int i = 0; i < this.attrs.size(); i++) {
            if (this.attrs.get(i).equals(xmlAttribute)) {
                this.attrs.remove(i);
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public void removeChild(Object obj) {
        if (obj == null) {
            jl.a("child to remove can not be null");
        } else {
            if (!hasChildren()) {
                throw new XmlBuilderException("no children to remove");
            }
            int iIndexOf = this.children.indexOf(obj);
            if (iIndexOf != -1) {
                this.children.remove(iIndexOf);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public void replaceChild(Object obj, Object obj2) {
        if (obj == null) {
            jl.a("new child to replace can not be null");
            return;
        }
        if (obj2 == null) {
            jl.a("old child to replace can not be null");
        } else {
            if (!hasChildren()) {
                throw new XmlBuilderException("no children available for replacement");
            }
            int iIndexOf = this.children.indexOf(obj2);
            if (iIndexOf == -1) {
                throw new XmlBuilderException("could not find child to replace");
            }
            this.children.set(iIndexOf, obj);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public void setBaseUri(String str) {
        throw new XmlBuilderException("not implemented");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public void setName(String str) {
        this.name = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public void setNamespace(XmlNamespace xmlNamespace) {
        this.namespace = xmlNamespace;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlElement
    public void setParent(XmlContainer xmlContainer) {
        if (xmlContainer != null) {
            if (xmlContainer instanceof XmlElement) {
                Iterator itChildren = ((XmlElement) xmlContainer).children();
                while (itChildren.hasNext()) {
                    if (itChildren.next() == this) {
                    }
                }
                throw new XmlBuilderException("this element must be child of parent to set its parent");
            }
            if ((xmlContainer instanceof XmlDocument) && ((XmlDocument) xmlContainer).getDocumentElement() != this) {
                throw new XmlBuilderException("this element must be root docuemnt element to have document set as parent but already different element is set as root document element");
            }
        }
        this.parent = xmlContainer;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("name[");
        stringBuffer.append(this.name);
        stringBuffer.append("] namespace[");
        stringBuffer.append(this.namespace.getNamespaceName());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class EmptyIterator implements Iterator {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private EmptyIterator() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public Object next() {
            throw new RuntimeException("this iterator has no content and next() is not allowed");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public void remove() {
            throw new RuntimeException("this iterator has no content and remove() is not allowed");
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:5) call: org.xmlpull.v1.builder.impl.XmlElementImpl.EmptyIterator.<init>():void type: THIS */
        public /* synthetic */ EmptyIterator(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement newElement(String str, String str2) {
        return new XmlElementImpl(str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace newNamespace(String str, String str2) {
        return new XmlNamespaceImpl(str, str2);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement newElement(XmlNamespace xmlNamespace, String str) {
        return new XmlElementImpl(xmlNamespace, str);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement addElement(XmlElement xmlElement) {
        addChild(xmlElement);
        return xmlElement;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement addElement(String str) {
        return addElement(null, str);
    }

    public XmlElementImpl(XmlNamespace xmlNamespace, String str) {
        this.namespace = xmlNamespace;
        this.name = str;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(XmlNamespace xmlNamespace, String str, String str2) {
        return addAttribute("CDATA", xmlNamespace, str, str2, false);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(String str, String str2) {
        return addAttribute("CDATA", null, str, str2, false);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(String str, XmlNamespace xmlNamespace, String str2, String str3) {
        return addAttribute(str, xmlNamespace, str2, str3, false);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(XmlAttribute xmlAttribute) {
        if (this.attrs == null) {
            ensureAttributeCapacity(5);
        }
        this.attrs.add(xmlAttribute);
        return xmlAttribute;
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public void addChild(int i, Object obj) {
        if (this.children == null) {
            ensureChildrenCapacity(1);
        }
        checkChildParent(obj);
        this.children.add(i, obj);
        setChildParent(obj);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlAttribute addAttribute(String str, String str2, String str3, String str4, String str5, boolean z) {
        return addAttribute(str, newNamespace(str2, str3), str4, str5, z);
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlNamespace declareNamespace(String str, String str2) {
        if (str != null) {
            return declareNamespace(newNamespace(str, str2));
        }
        throw new XmlBuilderException("namespace added to element must have not null prefix");
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement findElementByName(String str, String str2, XmlElement xmlElement) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement findElementByName(String str, XmlElement xmlElement) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.builder.XmlElement
    public XmlElement findElementByName(String str, String str2) {
        throw new UnsupportedOperationException();
    }
}
