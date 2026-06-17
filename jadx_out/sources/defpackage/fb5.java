package defpackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class fb5 {
    public static /* synthetic */ boolean b(Object obj) {
        return (obj instanceof ko1) && ((ko1) obj).q("singleActionEmergencySupportRenderer");
    }

    public static ws2 c(ko1 ko1Var) throws s83 {
        String strO;
        ws2 ws2Var = new ws2();
        String strK = cc5.K(ko1Var.m("contentTitle"));
        String strK2 = cc5.K(ko1Var.m("text"));
        if (strK == null || strK2 == null) {
            ny4.a("Could not extract clarification renderer content");
            return null;
        }
        ws2Var.d(strK);
        ws2Var.c(new qj0(strK2, 3));
        if (ko1Var.q("actionButton")) {
            ko1 ko1VarM = ko1Var.m("actionButton").m("buttonRenderer");
            try {
                String strN = cc5.n(cc5.O(ko1VarM.m("command")));
                Objects.requireNonNull(strN);
                ws2Var.a(new URL(strN));
                String strK3 = cc5.K(ko1VarM.m("text"));
                if (yy4.n(strK3)) {
                    ny4.a("Could not get metadata info link text.");
                    return null;
                }
                ws2Var.b(strK3);
            } catch (NullPointerException | MalformedURLException e) {
                uo1.a("Could not get metadata info URL", e);
                return null;
            }
        }
        if (!ko1Var.q("secondaryEndpoint") || !ko1Var.q("secondarySource") || (strO = cc5.O(ko1Var.m("secondaryEndpoint"))) == null || cc5.U(strO)) {
            return ws2Var;
        }
        try {
            ws2Var.a(new URL(strO));
            String strK4 = cc5.K(ko1Var.m("secondarySource"));
            if (strK4 != null) {
                strO = strK4;
            }
            ws2Var.b(strO);
            return ws2Var;
        } catch (MalformedURLException e2) {
            uo1.a("Could not get metadata info secondary URL", e2);
            return null;
        }
    }

    public static void d(ko1 ko1Var, Consumer consumer) throws s83 {
        String string;
        List<ko1> list = (List) ko1Var.values().stream().filter(new Predicate() { // from class: db5
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return fb5.b(obj);
            }
        }).map(new Function() { // from class: eb5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m("singleActionEmergencySupportRenderer");
            }
        }).collect(Collectors.toList());
        if (list.isEmpty()) {
            ny4.a("Could not extract any meta info from emergency renderer");
            return;
        }
        for (ko1 ko1Var2 : list) {
            ws2 ws2Var = new ws2();
            String strM = cc5.M(ko1Var2.m("title"), "title");
            if (ko1Var2.q("actionText")) {
                string = "\n" + cc5.M(ko1Var2.m("actionText"), "action");
            } else if (ko1Var2.q("contacts")) {
                eo1 eo1VarB = ko1Var2.b("contacts");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < eo1VarB.size(); i++) {
                    sb.append("\n");
                    sb.append(cc5.M(eo1VarB.d(i).m("actionText"), "contacts.actionText"));
                }
                string = sb.toString();
            } else {
                string = "";
            }
            String strM2 = cc5.M(ko1Var2.m("detailsText"), "details");
            String strM3 = cc5.M(ko1Var2.m("navigationText"), "urlText");
            ws2Var.d(strM);
            ws2Var.c(new qj0(strM2 + string, 3));
            ws2Var.b(strM3);
            String strO = cc5.O(ko1Var2.m("navigationEndpoint"));
            if (strO == null) {
                ny4.a("Could not extract emergency renderer url");
                return;
            }
            try {
                ws2Var.a(new URL(yy4.u(strO)));
                consumer.accept(ws2Var);
            } catch (MalformedURLException e) {
                uo1.a("Could not parse emergency renderer url", e);
                return;
            }
        }
    }

    public static ws2 e(ko1 ko1Var) throws s83 {
        ws2 ws2Var = new ws2();
        StringBuilder sb = new StringBuilder();
        for (Object obj : ko1Var.b("paragraphs")) {
            if (sb.length() != 0) {
                sb.append("<br>");
            }
            sb.append(cc5.K((ko1) obj));
        }
        ws2Var.c(new qj0(sb.toString(), 1));
        if (!ko1Var.q("sourceEndpoint")) {
            return ws2Var;
        }
        try {
            String strN = cc5.n(cc5.O(ko1Var.m("sourceEndpoint")));
            Objects.requireNonNull(strN);
            ws2Var.a(new URL(strN));
            String strK = ko1Var.q("inlineSource") ? cc5.K(ko1Var.m("inlineSource")) : cc5.K(ko1Var.m("disclaimer"));
            if (yy4.n(strK)) {
                ny4.a("Could not get metadata info link text.");
                return null;
            }
            ws2Var.b(strK);
            return ws2Var;
        } catch (NullPointerException | MalformedURLException e) {
            uo1.a("Could not get metadata info URL", e);
            return null;
        }
    }

    public static List f(eo1 eo1Var) throws s83 {
        final ArrayList arrayList = new ArrayList();
        Iterator<E> it = eo1Var.iterator();
        while (it.hasNext()) {
            ko1 ko1Var = (ko1) it.next();
            if (ko1Var.q("itemSectionRenderer")) {
                for (ko1 ko1Var2 : ko1Var.m("itemSectionRenderer").b("contents")) {
                    if (ko1Var2.q("infoPanelContentRenderer")) {
                        arrayList.add(e(ko1Var2.m("infoPanelContentRenderer")));
                    }
                    if (ko1Var2.q("clarificationRenderer")) {
                        arrayList.add(c(ko1Var2.m("clarificationRenderer")));
                    }
                    if (ko1Var2.q("emergencyOneboxRenderer")) {
                        d(ko1Var2.m("emergencyOneboxRenderer"), new Consumer() { // from class: cb5
                            @Override // java.util.function.Consumer
                            public final void accept(Object obj) {
                                arrayList.add((ws2) obj);
                            }
                        });
                    }
                }
            }
        }
        return arrayList;
    }
}
