package javatest.lang.classloader.test4;

public class ExecutorV1 extends AbstractExecutor {

    @Override
    public void execute(final String name) {
        this.handle(new Handler() {
            @Override
            public void handle() {
                System.out.println("V1:" + name);
            }
        });
    }

}