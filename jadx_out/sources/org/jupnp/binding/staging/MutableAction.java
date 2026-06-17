package org.jupnp.binding.staging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jupnp.model.meta.Action;
import org.jupnp.model.meta.ActionArgument;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MutableAction {
    public List<MutableActionArgument> arguments = new ArrayList();
    public String name;

    public Action build() {
        return new Action(this.name, createActionArguments());
    }

    public ActionArgument[] createActionArguments() {
        ActionArgument[] actionArgumentArr = new ActionArgument[this.arguments.size()];
        Iterator<MutableActionArgument> it = this.arguments.iterator();
        int i = 0;
        while (it.hasNext()) {
            actionArgumentArr[i] = it.next().build();
            i++;
        }
        return actionArgumentArr;
    }
}
