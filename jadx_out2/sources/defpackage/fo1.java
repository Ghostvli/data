package defpackage;

import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public final class fo1 {
    public Stack a;
    public Object b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fo1(Object obj) {
        Stack stack = new Stack();
        this.a = stack;
        this.b = obj;
        stack.push(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fo1 a(String str) {
        eo1 eo1Var = new eo1();
        g(str, eo1Var);
        this.a.push(eo1Var);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object b() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fo1 c() {
        if (this.a.size() == 1) {
            throw new bp1("Cannot end the root object or array");
        }
        this.a.pop();
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ko1 d() {
        try {
            return (ko1) this.a.peek();
        } catch (ClassCastException unused) {
            throw new bp1("Attempted to write a keyed value to a JsonArray");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fo1 e(String str) {
        ko1 ko1Var = new ko1();
        g(str, ko1Var);
        this.a.push(ko1Var);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fo1 f(String str, int i) {
        return g(str, Integer.valueOf(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fo1 g(String str, Object obj) {
        d().put(str, obj);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fo1 h(String str, String str2) {
        return g(str, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fo1 i(String str, boolean z) {
        return g(str, Boolean.valueOf(z));
    }
}
