package defpackage;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class pa3 implements cr3, kr {
    public Consumer a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pa3(Consumer consumer) {
        Objects.requireNonNull(consumer);
        this.a = consumer;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.kr
    public void a(List list) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.kr
    public void b() {
        Consumer consumer = this.a;
        if (consumer != null) {
            consumer.accept(Boolean.TRUE);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr3
    public void c(boolean z, List list, List list2) {
        Consumer consumer = this.a;
        if (consumer != null) {
            consumer.accept(Boolean.valueOf(z));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.kr
    public void request() {
    }
}
