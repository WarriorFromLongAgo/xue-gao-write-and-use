package spring.beans.factory.support;

import spring.beans.factory.ObjectFactory;
import spring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    /**
     * Cache of singleton objects: bean name to bean instance.
     */
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    /**
     * Cache of singleton factories: bean name to ObjectFactory.
     */
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        synchronized (this.singletonObjects) {
            Object oldObject = this.singletonObjects.get(beanName);
            if (oldObject != null) {
                throw new IllegalStateException("Could not register object [" + singletonObject +
                        "] under bean name '" + beanName + "': there is already object [" + oldObject + "] bound");
            }
            addSingleton(beanName, singletonObject);
        }
    }

    @Override
    public Object getSingleton(String beanName) {
        return getSingleton(beanName, true);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        synchronized (this.singletonObjects) {
            this.singletonObjects.put(beanName, singletonObject);
            this.singletonFactories.remove(beanName);
            // this.earlySingletonObjects.remove(beanName);
            // this.registeredSingletons.add(beanName);
        }
    }

    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
        synchronized (this.singletonObjects) {
            if (!this.singletonObjects.containsKey(beanName)) {
                this.singletonFactories.put(beanName, singletonFactory);
                // this.earlySingletonObjects.remove(beanName);
                // this.registeredSingletons.add(beanName);
            }
        }
    }

    protected Object getSingleton(String beanName, boolean allowEarlyReference) {
        // Quick check for existing instance without full singleton lock
        Object singletonObject = this.singletonObjects.get(beanName);
        // if (singletonObject == null && isSingletonCurrentlyInCreation(beanName)) {
        //     singletonObject = this.earlySingletonObjects.get(beanName);
        if (singletonObject == null && allowEarlyReference) {
            synchronized (this.singletonObjects) {
                // Consistent creation of early reference within full singleton lock
                singletonObject = this.singletonObjects.get(beanName);
                if (singletonObject == null) {
                    // singletonObject = this.earlySingletonObjects.get(beanName);
                    // if (singletonObject == null) {
                    ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
                    if (singletonFactory != null) {
                        singletonObject = singletonFactory.getObject();
                        // this.earlySingletonObjects.put(beanName, singletonObject);
                        this.singletonFactories.remove(beanName);
                    }
                    // }
                    // }
                }
            }
        }
        return singletonObject;
    }

    public Object getSingleton(String beanName, ObjectFactory<?> singletonFactory) {
        synchronized (this.singletonObjects) {
            Object singletonObject = this.singletonObjects.get(beanName);
            if (singletonObject == null) {
                boolean newSingleton = false;
                try {
                    singletonObject = singletonFactory.getObject();
                    // 这里就已经是正常的了，因为上面已经填充完成数据了 createBean的时候
                    // RootBean {country='hubei', city='wuhan'}
                    newSingleton = true;
                } catch (IllegalStateException ex) {
                    // Has the singleton object implicitly appeared in the meantime ->
                    // if yes, proceed with it since the exception indicates that state.
                    singletonObject = this.singletonObjects.get(beanName);
                    if (singletonObject == null) {
                        throw ex;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw ex;
                } finally {

                }
                if (newSingleton) {
                    addSingleton(beanName, singletonObject);
                }
            }
            return singletonObject;
        }
    }
}
