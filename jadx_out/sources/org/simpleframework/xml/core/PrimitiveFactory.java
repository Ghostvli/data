package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class PrimitiveFactory extends Factory {
    public PrimitiveFactory(Context context, Type type) {
        super(context, type);
    }

    public Instance getInstance(InputNode inputNode) {
        Value override = getOverride(inputNode);
        Class type = getType();
        Context context = this.context;
        return override == null ? context.getInstance(type) : new ObjectInstance(context, override);
    }

    public String getText(Object obj) {
        Class<?> cls = obj.getClass();
        boolean zIsEnum = cls.isEnum();
        Support support = this.support;
        return zIsEnum ? support.write(obj, cls) : support.write(obj, cls);
    }

    public PrimitiveFactory(Context context, Type type, Class cls) {
        super(context, type, cls);
    }

    public Object getInstance(String str, Class cls) {
        return this.support.read(str, cls);
    }
}
