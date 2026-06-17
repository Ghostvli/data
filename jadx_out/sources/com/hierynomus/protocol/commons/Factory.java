package com.hierynomus.protocol.commons;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface Factory<T> {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface Named<T> extends Factory<T> {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class Util {
            public static <T> T create(List<Named<T>> list, String str) {
                Named named = get(list, str);
                if (named != null) {
                    return named.create();
                }
                return null;
            }

            public static <T> Named<T> get(List<Named<T>> list, String str) {
                if (list == null) {
                    return null;
                }
                for (Named<T> named : list) {
                    if (named.getName().equals(str)) {
                        return named;
                    }
                }
                return null;
            }

            public static <T> List<String> getNames(List<Named<T>> list) {
                LinkedList linkedList = new LinkedList();
                Iterator<Named<T>> it = list.iterator();
                while (it.hasNext()) {
                    linkedList.add(it.next().getName());
                }
                return linkedList;
            }
        }

        String getName();
    }

    T create();
}
