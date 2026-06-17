package org.simpleframework.xml.core;

import org.simpleframework.xml.Order;
import org.simpleframework.xml.stream.Format;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class ModelAssembler {
    private final ExpressionBuilder builder;
    private final Detail detail;
    private final Format format;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ModelAssembler(ExpressionBuilder expressionBuilder, Detail detail, Support support) {
        this.format = support.getFormat();
        this.builder = expressionBuilder;
        this.detail = detail;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void assembleAttributes(Model model, Order order) throws PathException {
        for (String str : order.attributes()) {
            Expression expressionBuild = this.builder.build(str);
            if (!expressionBuild.isAttribute() && expressionBuild.isPath()) {
                throw new PathException("Ordered attribute '%s' references an element in %s", expressionBuild, this.detail);
            }
            if (expressionBuild.isPath()) {
                registerAttributes(model, expressionBuild);
            } else {
                model.registerAttribute(this.format.getStyle().getAttribute(str));
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void assembleElements(Model model, Order order) throws PathException {
        for (String str : order.elements()) {
            Expression expressionBuild = this.builder.build(str);
            if (expressionBuild.isAttribute()) {
                throw new PathException("Ordered element '%s' references an attribute in %s", expressionBuild, this.detail);
            }
            registerElements(model, expressionBuild);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void registerAttribute(Model model, Expression expression) {
        String first = expression.getFirst();
        if (first != null) {
            model.registerAttribute(first);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void registerAttributes(Model model, Expression expression) throws PathException {
        String prefix = expression.getPrefix();
        String first = expression.getFirst();
        int index = expression.getIndex();
        if (!expression.isPath()) {
            registerAttribute(model, expression);
            return;
        }
        Model modelRegister = model.register(first, prefix, index);
        Expression path = expression.getPath(1);
        if (modelRegister == null) {
            throw new PathException("Element '%s' does not exist in %s", first, this.detail);
        }
        registerAttributes(modelRegister, path);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void registerElement(Model model, Expression expression) throws PathException {
        String prefix = expression.getPrefix();
        String first = expression.getFirst();
        int index = expression.getIndex();
        if (index > 1 && model.lookup(first, index - 1) == null) {
            throw new PathException("Ordered element '%s' in path '%s' is out of sequence for %s", first, expression, this.detail);
        }
        model.register(first, prefix, index);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void registerElements(Model model, Expression expression) throws PathException {
        String prefix = expression.getPrefix();
        String first = expression.getFirst();
        int index = expression.getIndex();
        if (first != null) {
            Model modelRegister = model.register(first, prefix, index);
            Expression path = expression.getPath(1);
            if (expression.isPath()) {
                registerElements(modelRegister, path);
            }
        }
        registerElement(model, expression);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void assemble(Model model, Order order) throws PathException {
        assembleElements(model, order);
        assembleAttributes(model, order);
    }
}
