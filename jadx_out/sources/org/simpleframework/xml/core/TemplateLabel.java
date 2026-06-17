package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
abstract class TemplateLabel implements Label {
    private final KeyBuilder builder = new KeyBuilder(this);

    @Override // org.simpleframework.xml.core.Label
    public Type getDependent() {
        return null;
    }

    @Override // org.simpleframework.xml.core.Label
    public String getEntry() {
        return null;
    }

    @Override // org.simpleframework.xml.core.Label
    public Object getKey() {
        return this.builder.getKey();
    }

    @Override // org.simpleframework.xml.core.Label
    public Label getLabel(Class cls) {
        return this;
    }

    @Override // org.simpleframework.xml.core.Label
    public String[] getNames() {
        return new String[]{getPath(), getName()};
    }

    @Override // org.simpleframework.xml.core.Label
    public String[] getPaths() {
        return new String[]{getPath()};
    }

    @Override // org.simpleframework.xml.core.Label
    public Type getType(Class cls) {
        return getContact();
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isAttribute() {
        return false;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isCollection() {
        return false;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isInline() {
        return false;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isText() {
        return false;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isTextList() {
        return false;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isUnion() {
        return false;
    }
}
