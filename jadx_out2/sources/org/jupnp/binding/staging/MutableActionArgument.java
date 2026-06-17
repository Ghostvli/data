package org.jupnp.binding.staging;

import org.jupnp.model.meta.ActionArgument;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MutableActionArgument {
    public ActionArgument.Direction direction;
    public String name;
    public String relatedStateVariable;
    public boolean retval;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ActionArgument build() {
        return new ActionArgument(this.name, this.relatedStateVariable, this.direction, this.retval);
    }
}
