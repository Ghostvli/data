package com.thegrizzlylabs.sardineandroid.util;

import com.thegrizzlylabs.sardineandroid.model.EntityWithAnyElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class EntityWithAnyElementConverter<T extends EntityWithAnyElement> implements Converter<T> {
    private Class<T> entityClass;
    private Serializer serializer;

    public EntityWithAnyElementConverter(Serializer serializer, Class<T> cls) {
        this.serializer = serializer;
        this.entityClass = cls;
    }

    private Map<String, Field> getEntityFields() {
        HashMap map = new HashMap();
        for (Field field : this.entityClass.getDeclaredFields()) {
            Element element = (Element) field.getAnnotation(Element.class);
            if (element != null) {
                map.put(element.name().equals("") ? field.getName() : element.name(), field);
            }
        }
        return map;
    }

    private Method getGetterForField(Field field) {
        String name = field.getName();
        return this.entityClass.getMethod("get".concat(name.substring(0, 1).toUpperCase() + name.substring(1)), null);
    }

    private Method getSetterForField(Field field) {
        String name = field.getName();
        return this.entityClass.getMethod("set".concat(name.substring(0, 1).toUpperCase() + name.substring(1)), field.getType());
    }

    private void skipChildrenOfNode(InputNode inputNode) {
        while (inputNode.getNext() != null) {
        }
    }

    @Override // org.simpleframework.xml.convert.Converter
    public T read(InputNode inputNode) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Map<String, Field> entityFields = getEntityFields();
        T tNewInstance = this.entityClass.newInstance();
        List<org.w3c.dom.Element> any = tNewInstance.getAny();
        while (true) {
            InputNode next = inputNode.getNext();
            if (next == null) {
                return tNewInstance;
            }
            if (entityFields.containsKey(next.getName())) {
                Field field = entityFields.get(next.getName());
                getSetterForField(field).invoke(tNewInstance, this.serializer.read((Class) field.getType(), next));
            } else if (next.getPrefix() == null || next.getPrefix().isEmpty()) {
                skipChildrenOfNode(next);
            } else {
                any.add(ElementConverter.read(next));
            }
        }
    }

    @Override // org.simpleframework.xml.convert.Converter
    public void write(OutputNode outputNode, T t) throws IllegalAccessException, InvocationTargetException {
        Iterator<org.w3c.dom.Element> it = t.getAny().iterator();
        while (it.hasNext()) {
            ElementConverter.write(outputNode, it.next());
        }
        Map<String, Field> entityFields = getEntityFields();
        for (String str : entityFields.keySet()) {
            Object objInvoke = getGetterForField(entityFields.get(str)).invoke(t, null);
            if (objInvoke != null) {
                if (objInvoke instanceof String) {
                    OutputNode child = outputNode.getChild(str);
                    child.setReference(SardineUtil.DEFAULT_NAMESPACE_URI);
                    child.setValue((String) objInvoke);
                } else {
                    this.serializer.write(objInvoke, outputNode);
                }
            }
        }
    }
}
