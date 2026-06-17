package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import java.util.Objects;
import javax.xml.XMLConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class he4 implements x44 {
    public final int a;
    public final y44 b;
    public final int[][] c;
    public final y44[] d;

    public he4(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        b.f(bVar);
        b.g(bVar);
        b.h(bVar);
        b.a(bVar);
    }

    public static he4 f(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId != 0 && Objects.equals(context.getResources().getResourceTypeName(resourceId), XMLConstants.XML_NS_PREFIX)) {
            return new b(context, resourceId).j();
        }
        return null;
    }

    public static void i(b bVar, Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayObtainAttributes = theme == null ? context.getResources().obtainAttributes(attributeSet, cn3.S3) : theme.obtainStyledAttributes(attributeSet, cn3.S3, 0, 0);
                y44 y44VarM = y44.f(context, typedArrayObtainAttributes.getResourceId(cn3.T3, 0), typedArrayObtainAttributes.getResourceId(cn3.U3, 0)).m();
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                int i = 0;
                for (int i2 = 0; i2 < attributeCount; i2++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i2);
                    if (attributeNameResource != mk3.Q && attributeNameResource != mk3.R) {
                        int i3 = i + 1;
                        if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr[i] = attributeNameResource;
                        i = i3;
                    }
                }
                bVar.i(StateSet.trimStateSet(iArr, i), y44VarM);
            }
        }
    }

    @Override // defpackage.x44
    public y44 a(float f) {
        return c().a(f);
    }

    @Override // defpackage.x44
    public y44 b(int[] iArr) {
        int iH = h(iArr);
        if (iH < 0) {
            iH = h(StateSet.WILD_CARD);
        }
        return this.d[iH];
    }

    @Override // defpackage.x44
    public y44 c() {
        return g(true);
    }

    @Override // defpackage.x44
    public boolean d() {
        return this.a > 1;
    }

    public y44 g(boolean z) {
        return this.b;
    }

    public final int h(int[] iArr) {
        int[][] iArr2 = this.c;
        for (int i = 0; i < this.a; i++) {
            if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                return i;
            }
        }
        return -1;
    }

    public b j() {
        return new b(this);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public int a;
        public y44 b;
        public int[][] c;
        public y44[] d;

        public b(Context context, int i) {
            int next;
            l();
            try {
                XmlResourceParser xml = context.getResources().getXml(i);
                try {
                    AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                    do {
                        next = xml.next();
                        if (next == 2) {
                            break;
                        }
                    } while (next != 1);
                    if (next != 2) {
                        throw new XmlPullParserException("No start tag found");
                    }
                    if (xml.getName().equals("selector")) {
                        he4.i(this, context, xml, attributeSetAsAttributeSet, context.getTheme());
                    }
                    xml.close();
                } catch (Throwable th) {
                    if (xml != null) {
                        try {
                            xml.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
                l();
            }
        }

        public static /* synthetic */ ge4 a(b bVar) {
            bVar.getClass();
            return null;
        }

        public static /* synthetic */ ge4 f(b bVar) {
            bVar.getClass();
            return null;
        }

        public static /* synthetic */ ge4 g(b bVar) {
            bVar.getClass();
            return null;
        }

        public static /* synthetic */ ge4 h(b bVar) {
            bVar.getClass();
            return null;
        }

        public b i(int[] iArr, y44 y44Var) {
            int i = this.a;
            if (i == 0 || iArr.length == 0) {
                this.b = y44Var;
            }
            if (i >= this.c.length) {
                k(i, i + 10);
            }
            int[][] iArr2 = this.c;
            int i2 = this.a;
            iArr2[i2] = iArr;
            this.d[i2] = y44Var;
            this.a = i2 + 1;
            return this;
        }

        public he4 j() {
            if (this.a == 0) {
                return null;
            }
            return new he4(this);
        }

        public final void k(int i, int i2) {
            int[][] iArr = new int[i2][];
            System.arraycopy(this.c, 0, iArr, 0, i);
            this.c = iArr;
            y44[] y44VarArr = new y44[i2];
            System.arraycopy(this.d, 0, y44VarArr, 0, i);
            this.d = y44VarArr;
        }

        public final void l() {
            this.b = new y44();
            this.c = new int[10][];
            this.d = new y44[10];
        }

        public b(he4 he4Var) {
            int i = he4Var.a;
            this.a = i;
            this.b = he4Var.b;
            int[][] iArr = he4Var.c;
            int[][] iArr2 = new int[iArr.length][];
            this.c = iArr2;
            this.d = new y44[he4Var.d.length];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(he4Var.d, 0, this.d, 0, this.a);
        }
    }
}
