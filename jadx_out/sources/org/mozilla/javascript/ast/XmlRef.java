package org.mozilla.javascript.ast;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class XmlRef extends AstNode {
    protected int atPos;
    protected int colonPos;
    protected Name namespace;

    public XmlRef() {
        this.atPos = -1;
        this.colonPos = -1;
    }

    public int getAtPos() {
        return this.atPos;
    }

    public int getColonPos() {
        return this.colonPos;
    }

    public Name getNamespace() {
        return this.namespace;
    }

    public boolean isAttributeAccess() {
        return this.atPos >= 0;
    }

    public void setAtPos(int i) {
        this.atPos = i;
    }

    public void setColonPos(int i) {
        this.colonPos = i;
    }

    public void setNamespace(Name name) {
        this.namespace = name;
        if (name != null) {
            name.setParent(this);
        }
    }

    public XmlRef(int i) {
        super(i);
        this.atPos = -1;
        this.colonPos = -1;
    }

    public XmlRef(int i, int i2) {
        super(i, i2);
        this.atPos = -1;
        this.colonPos = -1;
    }
}
