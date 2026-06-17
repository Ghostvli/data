package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class g14 extends h14 implements Iterator, f30, op1 {
    public int f;
    public Object g;
    public Iterator h;
    public f30 i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h14
    public Object b(Object obj, f30 f30Var) {
        this.g = obj;
        this.f = 3;
        this.i = f30Var;
        Object objE = kl1.e();
        if (objE == kl1.e()) {
            ta0.c(f30Var);
        }
        return objE == kl1.e() ? objE : fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h14
    public Object d(Iterator it, f30 f30Var) {
        if (!it.hasNext()) {
            return fw4.a;
        }
        this.h = it;
        this.f = 2;
        this.i = f30Var;
        Object objE = kl1.e();
        if (objE == kl1.e()) {
            ta0.c(f30Var);
        }
        return objE == kl1.e() ? objE : fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Throwable g() {
        int i = this.f;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f30
    public g40 getContext() {
        return bs0.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object h() {
        if (hasNext()) {
            return next();
        }
        bo.a();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i = this.f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw g();
                }
                Iterator it = this.h;
                it.getClass();
                if (it.hasNext()) {
                    this.f = 2;
                    return true;
                }
                this.h = null;
            }
            this.f = 5;
            f30 f30Var = this.i;
            f30Var.getClass();
            this.i = null;
            f30Var.resumeWith(kt3.b(fw4.a));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n(f30 f30Var) {
        this.i = f30Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Iterator
    public Object next() throws Throwable {
        int i = this.f;
        if (i == 0 || i == 1) {
            return h();
        }
        if (i == 2) {
            this.f = 1;
            Iterator it = this.h;
            it.getClass();
            return it.next();
        }
        if (i != 3) {
            throw g();
        }
        this.f = 0;
        Object obj = this.g;
        this.g = null;
        return obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f30
    public void resumeWith(Object obj) throws Throwable {
        lt3.b(obj);
        this.f = 4;
    }
}
