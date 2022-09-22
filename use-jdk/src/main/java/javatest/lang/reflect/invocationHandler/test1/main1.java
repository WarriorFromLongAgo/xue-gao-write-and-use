package javatest.lang.reflect.invocationHandler.test1;

public class main1 {
    // https://juejin.cn/post/7140519841558954021
    public static void main(String[] args) {
        UseProxy useProxy = new UseProxy();
        IUser user = (IUser) useProxy.myJDKProxy(new User());

        user.shopping();
        System.out.println(user.expenses());
    }
}
