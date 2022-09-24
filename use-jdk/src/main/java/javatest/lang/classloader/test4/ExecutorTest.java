package javatest.lang.classloader.test4;

public class ExecutorTest {
    
    public void testExecuteV1() {
        
        Executor executor = new ExecutorProxy("v1");
        
        executor.execute("TOM");
    }
    
    public void testExecuteV2() {
        
        Executor executor = new ExecutorProxy("v2");
        
        executor.execute("TOM");
    }
    
}
