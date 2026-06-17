package com.hierynomus.msdfsc;

import com.hierynomus.smbj.common.SmbPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DFSPath {
    private final List<String> pathComponents;

    public DFSPath(String str) {
        this.pathComponents = splitPath(str);
    }

    public static DFSPath from(SmbPath smbPath) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(smbPath.getHostname());
        if (smbPath.getShareName() != null) {
            arrayList.add(smbPath.getShareName());
        }
        if (smbPath.getPath() != null) {
            arrayList.addAll(splitPath(smbPath.getPath()));
        }
        return new DFSPath(arrayList);
    }

    private DFSPath replacePrefix(String str, List<String> list) {
        List<String> listSplitPath = splitPath(str);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        for (int size = listSplitPath.size(); size < this.pathComponents.size(); size++) {
            arrayList.add(this.pathComponents.get(size));
        }
        return new DFSPath(arrayList);
    }

    private static List<String> splitPath(String str) {
        if (str.charAt(0) == '\\') {
            str = str.charAt(1) == '\\' ? str.substring(2) : str.substring(1);
        }
        return Arrays.asList(str.split("\\\\"));
    }

    public List<String> getPathComponents() {
        return this.pathComponents;
    }

    public boolean hasOnlyOnePathComponent() {
        return this.pathComponents.size() == 1;
    }

    public boolean isIpc() {
        if (this.pathComponents.size() > 1) {
            return "IPC$".equals(this.pathComponents.get(1));
        }
        return false;
    }

    public boolean isSysVolOrNetLogon() {
        if (this.pathComponents.size() <= 1) {
            return false;
        }
        String str = this.pathComponents.get(1);
        return "SYSVOL".equals(str) || "NETLOGON".equals(str);
    }

    public String toPath() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.pathComponents) {
            sb.append("\\");
            sb.append(str);
        }
        return sb.toString();
    }

    public String toString() {
        return "DFSPath{" + this.pathComponents + "}";
    }

    public DFSPath(List<String> list) {
        this.pathComponents = list;
    }

    public DFSPath replacePrefix(String str, DFSPath dFSPath) {
        return replacePrefix(str, dFSPath.getPathComponents());
    }

    public DFSPath replacePrefix(String str, String str2) {
        return replacePrefix(str, splitPath(str2));
    }
}
