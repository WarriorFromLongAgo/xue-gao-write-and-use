package spring.beans.factory.support;

import com.sun.istack.internal.Nullable;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, RootBeanDefinition mbd, @Nullable Object[] args) {
        RootBeanDefinition mbdToUse = mbd;

        Object bean = doCreateBean(beanName, mbdToUse, args);
        // 上面这个bean，没有属性，RootBean {country='null', city='null'}

        Class<?> beanType = mbdToUse.getBeanClass();

        boolean earlySingletonExposure = mbd.isSingleton();
        if (earlySingletonExposure) {
            // 避免后期循环依赖,提早曝光创建的bean并加入到addSingletonFactory中
            addSingletonFactory(beanName, () -> getEarlyBeanReference(beanName, mbd, bean));
        }
        // 初始化bean实例对象
        // Initialize the bean instance.
        Object exposedObject = bean;
        // 5. 给bean的实例填充属性,其中，可能存在依赖于其他bean的属性,然后递归初始化bean的依赖
        populateBean(beanName, mbd, bean);
        // 6. 调用初始化方法，由于已经提前初始化了，所以不需要，实际情况下是这里触发的
        // exposedObject = initializeBean(beanName, exposedObject, mbd);

        // 7. 引用问题处理,这里先暴露早期单例引用的bean
        if (earlySingletonExposure) {
            // 从缓存注册中获取,这里不允许早期引用的创建
            // 这里返回的，其实是一个 ObjectFactory
            Object earlySingletonReference = getSingleton(beanName, false);
            // 只有在检测到有依赖的情况下,earlySingletonReference才会不为null
            if (earlySingletonReference != null) {
                if (exposedObject == bean) {
                    exposedObject = earlySingletonReference;
                }

            }

        }



        // 注册bean 的 DisposableBean
        registerDisposableBeanIfNecessary(beanName, bean, mbd);

        return exposedObject;
    }

    private Object doCreateBean(String beanName, RootBeanDefinition mbd, Object[] args) {
        // 解析class
        Class<?> beanClass = resolveBeanClass(mbd, beanName);

        try {
            return beanClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected Class<?> resolveBeanClass(RootBeanDefinition mbd, String beanName, Class<?>... typesToMatch) {
        return mbd.getBeanClass();
    }

    protected void registerDisposableBeanIfNecessary(String beanName, Object bean, RootBeanDefinition mbd) {
        if (mbd.isSingleton()) {


        }


    }


    protected void populateBean(String beanName, RootBeanDefinition mbd, @Nullable Object bean) {
        // 填充属性
    }

    protected Object getEarlyBeanReference(String beanName, RootBeanDefinition mbd, Object bean) {

        return bean;
    }
}
