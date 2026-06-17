package org.simpleframework.xml.core;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
interface Model extends Iterable<String> {
    LabelMap getAttributes();

    LabelMap getElements();

    Expression getExpression();

    int getIndex();

    ModelMap getModels();

    String getName();

    String getPrefix();

    Label getText();

    boolean isAttribute(String str);

    boolean isComposite();

    boolean isElement(String str);

    boolean isEmpty();

    boolean isModel(String str);

    Model lookup(String str, int i);

    Model lookup(Expression expression);

    Model register(String str, String str2, int i);

    void register(Label label);

    void registerAttribute(String str);

    void registerAttribute(Label label);

    void registerElement(String str);

    void registerElement(Label label);

    void registerText(Label label);

    void validate(Class cls);
}
