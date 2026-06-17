package net.engio.mbassy.dispatch.el;

import java.lang.reflect.Method;
import javax.el.BeanELResolver;
import javax.el.ELContext;
import javax.el.ELResolver;
import javax.el.FunctionMapper;
import javax.el.ValueExpression;
import javax.el.VariableMapper;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class StandardELResolutionContext extends ELContext {
    private final FunctionMapper functionMapper;
    private final Object message;
    private final ELResolver resolver = new BeanELResolver(true);
    private final VariableMapper variableMapper;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class MsgMapper extends VariableMapper {
        private static final String msg = "msg";
        private final ValueExpression msgExpression;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private MsgMapper() {
            this.msgExpression = ElFilter.ELFactory().createValueExpression(StandardELResolutionContext.this.message, StandardELResolutionContext.this.message.getClass());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ValueExpression resolveVariable(String str) {
            if (str.equals(msg)) {
                return this.msgExpression;
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ValueExpression setVariable(String str, ValueExpression valueExpression) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class NoopFunctionMapper extends FunctionMapper {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private NoopFunctionMapper() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Method resolveFunction(String str, String str2) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public StandardELResolutionContext(Object obj) {
        this.message = obj;
        this.functionMapper = new NoopFunctionMapper();
        this.variableMapper = new MsgMapper();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ELResolver getELResolver() {
        return this.resolver;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FunctionMapper getFunctionMapper() {
        return this.functionMapper;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public VariableMapper getVariableMapper() {
        return this.variableMapper;
    }
}
