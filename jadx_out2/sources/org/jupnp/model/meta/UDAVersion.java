package org.jupnp.model.meta;

import java.util.ArrayList;
import java.util.List;
import org.jupnp.model.Validatable;
import org.jupnp.model.ValidationError;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class UDAVersion implements Validatable {
    private int major;
    private int minor;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UDAVersion() {
        this.major = 1;
        this.minor = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getMajor() {
        return this.major;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getMinor() {
        return this.minor;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.Validatable
    public List<ValidationError> validate() {
        ArrayList arrayList = new ArrayList();
        if (getMajor() != 1) {
            arrayList.add(new ValidationError(getClass(), "major", "UDA major spec version must be 1"));
        }
        if (getMajor() < 0) {
            arrayList.add(new ValidationError(getClass(), "minor", "UDA minor spec version must be equal or greater 0"));
        }
        return arrayList;
    }

    public UDAVersion(int i, int i2) {
        this.major = i;
        this.minor = i2;
    }
}
