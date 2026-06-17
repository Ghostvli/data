package org.jupnp.binding.staging;

import java.net.URI;
import org.jupnp.model.meta.Icon;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MutableIcon {
    public int depth;
    public int height;
    public String mimeType;
    public URI uri;
    public int width;

    public Icon build() {
        return new Icon(this.mimeType, this.width, this.height, this.depth, this.uri);
    }
}
