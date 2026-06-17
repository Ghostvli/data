package org.mozilla.javascript;

import defpackage.d04;
import java.util.Set;
import org.mozilla.javascript.ast.ErrorCollector;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class CompilerEnvirons {
    Set<String> activationNames;
    private boolean allowSuper;
    private boolean ideMode;
    private boolean recordingComments;
    private boolean recordingLocalJsDocComments;
    private boolean recoverFromErrors;
    private boolean warnTrailingComma;
    private ErrorReporter errorReporter = DefaultErrorReporter.instance;
    private int languageVersion = 200;
    private boolean generateDebugInfo = true;
    private boolean reservedKeywordAsIdentifier = true;
    private boolean allowMemberExprAsFunctionName = false;
    private boolean xmlAvailable = true;
    private boolean interpretedMode = false;
    private boolean generatingSource = true;
    private boolean strictMode = false;
    private boolean warningAsError = false;
    private boolean generateObserverCount = false;
    private boolean allowSharpComments = false;

    public static CompilerEnvirons ideEnvirons() {
        CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
        compilerEnvirons.setRecoverFromErrors(true);
        compilerEnvirons.setRecordingComments(true);
        compilerEnvirons.setStrictMode(true);
        compilerEnvirons.setWarnTrailingComma(true);
        compilerEnvirons.setLanguageVersion(170);
        compilerEnvirons.setReservedKeywordAsIdentifier(true);
        compilerEnvirons.setIdeMode(true);
        compilerEnvirons.setErrorReporter(new ErrorCollector());
        return compilerEnvirons;
    }

    public Set<String> getActivationNames() {
        return this.activationNames;
    }

    public boolean getAllowSharpComments() {
        return this.allowSharpComments;
    }

    public final ErrorReporter getErrorReporter() {
        return this.errorReporter;
    }

    public final int getLanguageVersion() {
        return this.languageVersion;
    }

    @Deprecated
    public final int getOptimizationLevel() {
        return this.interpretedMode ? -1 : 9;
    }

    public boolean getWarnTrailingComma() {
        return this.warnTrailingComma;
    }

    public void initFromContext(Context context) {
        setErrorReporter(context.getErrorReporter());
        this.languageVersion = context.getLanguageVersion();
        this.generateDebugInfo = !context.isGeneratingDebugChanged() || context.isGeneratingDebug();
        this.reservedKeywordAsIdentifier = context.hasFeature(3);
        this.allowMemberExprAsFunctionName = context.hasFeature(2);
        this.strictMode = context.hasFeature(11);
        this.warningAsError = context.hasFeature(12);
        this.xmlAvailable = context.hasFeature(6);
        this.interpretedMode = context.isInterpretedMode();
        this.generatingSource = context.isGeneratingSource();
        this.activationNames = context.activationNames;
        this.generateObserverCount = context.isGenerateObserverCount();
    }

    public final boolean isAllowMemberExprAsFunctionName() {
        return this.allowMemberExprAsFunctionName;
    }

    public boolean isAllowSuper() {
        return this.allowSuper;
    }

    public final boolean isGenerateDebugInfo() {
        return this.generateDebugInfo;
    }

    public boolean isGenerateObserverCount() {
        return this.generateObserverCount;
    }

    public final boolean isGeneratingSource() {
        return this.generatingSource;
    }

    public boolean isIdeMode() {
        return this.ideMode;
    }

    public final boolean isInterpretedMode() {
        return this.interpretedMode;
    }

    public boolean isRecordingComments() {
        return this.recordingComments;
    }

    public boolean isRecordingLocalJsDocComments() {
        return this.recordingLocalJsDocComments;
    }

    public final boolean isReservedKeywordAsIdentifier() {
        return this.reservedKeywordAsIdentifier;
    }

    public final boolean isStrictMode() {
        return this.strictMode;
    }

    public final boolean isXmlAvailable() {
        return this.xmlAvailable;
    }

    public boolean recoverFromErrors() {
        return this.recoverFromErrors;
    }

    public final boolean reportWarningAsError() {
        return this.warningAsError;
    }

    public void setActivationNames(Set<String> set) {
        this.activationNames = set;
    }

    public void setAllowMemberExprAsFunctionName(boolean z) {
        this.allowMemberExprAsFunctionName = z;
    }

    public void setAllowSharpComments(boolean z) {
        this.allowSharpComments = z;
    }

    public void setAllowSuper(boolean z) {
        this.allowSuper = z;
    }

    public void setErrorReporter(ErrorReporter errorReporter) {
        if (errorReporter != null) {
            this.errorReporter = errorReporter;
        } else {
            d04.a();
        }
    }

    public void setGenerateDebugInfo(boolean z) {
        this.generateDebugInfo = z;
    }

    public void setGenerateObserverCount(boolean z) {
        this.generateObserverCount = z;
    }

    public void setGeneratingSource(boolean z) {
        this.generatingSource = z;
    }

    public void setIdeMode(boolean z) {
        this.ideMode = z;
    }

    public void setInterpretedMode(boolean z) {
        this.interpretedMode = z;
    }

    public void setLanguageVersion(int i) {
        Context.checkLanguageVersion(i);
        this.languageVersion = i;
    }

    @Deprecated
    public void setOptimizationLevel(int i) {
        Context.checkOptimizationLevel(i);
        this.interpretedMode = i < 0;
    }

    public void setRecordingComments(boolean z) {
        this.recordingComments = z;
    }

    public void setRecordingLocalJsDocComments(boolean z) {
        this.recordingLocalJsDocComments = z;
    }

    public void setRecoverFromErrors(boolean z) {
        this.recoverFromErrors = z;
    }

    public void setReservedKeywordAsIdentifier(boolean z) {
        this.reservedKeywordAsIdentifier = z;
    }

    public void setStrictMode(boolean z) {
        this.strictMode = z;
    }

    public void setWarnTrailingComma(boolean z) {
        this.warnTrailingComma = z;
    }

    public void setXmlAvailable(boolean z) {
        this.xmlAvailable = z;
    }
}
