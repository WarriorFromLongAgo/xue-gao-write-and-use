package javatest.lang.classloader.test4;

public class AbstractExecutor implements Executor {

    @Override
    public void execute(final String name) {
        this.handle(new Handler() {
            @Override
            public void handle() {
                System.out.println("V:" + name);
            }
        });
    }

    protected void handle(Handler handler) {
        handler.call();
    }

    protected abstract class Handler {
        public void call() {
            ClassLoader oldClassLoader = Thread.currentThread().getContextClassLoader();
            // 临时更改 ClassLoader
            Thread.currentThread().setContextClassLoader(AbstractExecutor.class.getClassLoader());

            handle();

            // 还原为之前的 ClassLoader
            Thread.currentThread().setContextClassLoader(oldClassLoader);
        }

        public abstract void handle();
    }
}