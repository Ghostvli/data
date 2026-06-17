package org.jupnp.util;

import defpackage.e04;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Iterators {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Empty<E> implements Iterator<E> {
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Singular<E> implements Iterator<E> {
        protected int current;
        protected final E element;

        public Singular(E e) {
            this.element = e;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current == 0;
        }

        @Override // java.util.Iterator
        public E next() {
            this.current++;
            return this.element;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class Synchronized<E> implements Iterator<E> {
        int nextIndex = 0;
        boolean removedCurrent = false;
        final Iterator<E> wrapped;

        public Synchronized(Collection<E> collection) {
            this.wrapped = new CopyOnWriteArrayList(collection).iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.wrapped.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            this.removedCurrent = false;
            this.nextIndex++;
            return this.wrapped.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.nextIndex;
            if (i == 0) {
                e04.a("Call next() first");
            } else if (this.removedCurrent) {
                e04.a("Already removed current, call next()");
            } else {
                synchronizedRemove(i - 1);
                this.removedCurrent = true;
            }
        }

        public abstract void synchronizedRemove(int i);
    }
}
