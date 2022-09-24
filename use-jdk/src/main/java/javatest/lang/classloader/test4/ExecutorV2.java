package javatest.lang.classloader.test4;

public class ExecutorV2 extends AbstractExecutor {

    @Override
    public void execute(final String name) {
        this.handle(new Handler() {
            @Override
            public void handle() {
                System.out.println("V2:" + name);
            }
        });
    }

}