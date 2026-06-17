package org.jupnp.model;

import defpackage.cx4;
import defpackage.e04;
import defpackage.j02;
import defpackage.n02;
import defpackage.zt2;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.jupnp.internal.compat.java.beans.PropertyChangeEvent;
import org.jupnp.internal.compat.java.beans.PropertyChangeListener;
import org.jupnp.internal.compat.java.beans.PropertyChangeSupport;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.meta.StateVariable;
import org.jupnp.model.state.StateVariableAccessor;
import org.jupnp.model.state.StateVariableValue;
import org.jupnp.util.Reflections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultServiceManager<T> implements ServiceManager<T> {
    protected final ReentrantLock lock;
    private final j02 logger;
    protected PropertyChangeSupport propertyChangeSupport;
    protected final LocalService<T> service;
    protected final Class<T> serviceClass;
    protected T serviceImpl;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class DefaultPropertyChangeListener implements PropertyChangeListener {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public DefaultPropertyChangeListener() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.internal.compat.java.beans.PropertyChangeListener
        public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
            DefaultServiceManager.this.logger.h("Property change event on local service: {}", propertyChangeEvent.getPropertyName());
            if (propertyChangeEvent.getPropertyName().equals(ServiceManager.EVENTED_STATE_VARIABLES)) {
                return;
            }
            String[] strArrFromCommaSeparatedList = ModelUtil.fromCommaSeparatedList(propertyChangeEvent.getPropertyName());
            if (DefaultServiceManager.this.logger.n()) {
                DefaultServiceManager.this.logger.h("Changed variable names: {}", Arrays.toString(strArrFromCommaSeparatedList));
            }
            try {
                Collection<StateVariableValue> currentState = DefaultServiceManager.this.getCurrentState(strArrFromCommaSeparatedList);
                if (currentState.isEmpty()) {
                    return;
                }
                DefaultServiceManager.this.getPropertyChangeSupport().firePropertyChange(ServiceManager.EVENTED_STATE_VARIABLES, null, currentState);
            } catch (Exception e) {
                DefaultServiceManager.this.logger.a("Error reading state of service after state variable update event", e);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DefaultServiceManager(LocalService<T> localService, Class<T> cls) {
        this.logger = n02.k(DefaultServiceManager.class);
        this.lock = new ReentrantLock(true);
        this.service = localService;
        this.serviceClass = cls;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PropertyChangeListener createPropertyChangeListener(T t) {
        return new DefaultPropertyChangeListener();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PropertyChangeSupport createPropertyChangeSupport(T t) {
        Method getterMethod = Reflections.getGetterMethod(t.getClass(), "propertyChangeSupport");
        if (getterMethod == null || !PropertyChangeSupport.class.isAssignableFrom(getterMethod.getReturnType())) {
            this.logger.h("Creating new PropertyChangeSupport for service implementation: {}", t.getClass().getName());
            return new PropertyChangeSupport(t);
        }
        this.logger.h("Service implementation instance offers PropertyChangeSupport, using that: {}", t.getClass().getName());
        return (PropertyChangeSupport) getterMethod.invoke(t, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public T createServiceInstance() {
        Class<T> cls = this.serviceClass;
        if (cls == null) {
            e04.a("Subclass has to provide service class or override createServiceInstance()");
            return null;
        }
        try {
            return cls.getConstructor(LocalService.class).newInstance(getService());
        } catch (NoSuchMethodException unused) {
            this.logger.h("Creating new service implementation instance with no-arg constructor: {}", this.serviceClass.getName());
            return this.serviceClass.getDeclaredConstructor(null).newInstance(null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.ServiceManager
    public void execute(Command<T> command) {
        lock();
        try {
            command.execute(this);
        } finally {
            unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.ServiceManager
    public Collection<StateVariableValue> getCurrentState() {
        lock();
        try {
            Collection<StateVariableValue> initialEventedStateVariableValues = readInitialEventedStateVariableValues();
            if (initialEventedStateVariableValues != null) {
                this.logger.y("Obtained initial state variable values for event, skipping individual state variable accessors");
                return initialEventedStateVariableValues;
            }
            ArrayList arrayList = new ArrayList();
            for (StateVariable<LocalService> stateVariable : getService().getStateVariables()) {
                if (stateVariable.getEventDetails().isSendEvents()) {
                    StateVariableAccessor accessor = getService().getAccessor(stateVariable);
                    if (accessor == null) {
                        throw new IllegalStateException("No accessor for evented state variable");
                    }
                    arrayList.add(accessor.read(stateVariable, getImplementation()));
                }
            }
            return arrayList;
        } finally {
            unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.ServiceManager
    public T getImplementation() {
        lock();
        try {
            if (this.serviceImpl == null) {
                init();
            }
            T t = this.serviceImpl;
            unlock();
            return t;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getLockTimeoutMillis() {
        return 500;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.ServiceManager
    public PropertyChangeSupport getPropertyChangeSupport() {
        lock();
        try {
            if (this.propertyChangeSupport == null) {
                init();
            }
            PropertyChangeSupport propertyChangeSupport = this.propertyChangeSupport;
            unlock();
            return propertyChangeSupport;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.ServiceManager
    public LocalService<T> getService() {
        return this.service;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void init() {
        this.logger.y("No service implementation instance available, initializing...");
        try {
            T tCreateServiceInstance = createServiceInstance();
            this.serviceImpl = tCreateServiceInstance;
            PropertyChangeSupport propertyChangeSupportCreatePropertyChangeSupport = createPropertyChangeSupport(tCreateServiceInstance);
            this.propertyChangeSupport = propertyChangeSupportCreatePropertyChangeSupport;
            propertyChangeSupportCreatePropertyChangeSupport.addPropertyChangeListener(createPropertyChangeListener(this.serviceImpl));
        } catch (Exception e) {
            cx4.a("Could not initialize implementation", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void lock() {
        try {
            if (this.lock.tryLock(getLockTimeoutMillis(), TimeUnit.MILLISECONDS)) {
                this.logger.y("Acquired lock");
                return;
            }
            throw new RuntimeException("Failed to acquire lock in milliseconds: " + getLockTimeoutMillis());
        } catch (InterruptedException e) {
            zt2.a("Failed to acquire lock:".concat(String.valueOf(e)));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Collection<StateVariableValue> readInitialEventedStateVariableValues() {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "(" + getClass().getSimpleName() + ") Implementation: " + String.valueOf(this.serviceImpl);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void unlock() {
        this.logger.y("Releasing lock");
        this.lock.unlock();
    }

    public DefaultServiceManager(LocalService<T> localService) {
        this(localService, null);
    }

    public Collection<StateVariableValue> getCurrentState(String[] strArr) {
        lock();
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                String strTrim = str.trim();
                StateVariable<LocalService> stateVariable = getService().getStateVariable(strTrim);
                if (stateVariable != null && stateVariable.getEventDetails().isSendEvents()) {
                    StateVariableAccessor accessor = getService().getAccessor(stateVariable);
                    if (accessor == null) {
                        this.logger.d("Ignoring evented state variable without accessor: {}", strTrim);
                    } else {
                        arrayList.add(accessor.read(stateVariable, getImplementation()));
                    }
                } else {
                    this.logger.h("Ignoring unknown or non-evented state variable: {}", strTrim);
                }
            }
            unlock();
            return arrayList;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }
}
