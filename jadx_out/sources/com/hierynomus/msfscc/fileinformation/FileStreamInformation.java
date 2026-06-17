package com.hierynomus.msfscc.fileinformation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FileStreamInformation implements FileQueryableInformation {
    private List<FileStreamInformationItem> streamList;

    public FileStreamInformation(List<FileStreamInformationItem> list) {
        this.streamList = list;
    }

    public List<FileStreamInformationItem> getStreamList() {
        return this.streamList;
    }

    public List<String> getStreamNames() {
        ArrayList arrayList = new ArrayList();
        Iterator<FileStreamInformationItem> it = this.streamList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getName());
        }
        return arrayList;
    }
}
