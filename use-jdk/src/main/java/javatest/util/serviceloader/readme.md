
最后要在ClassPath路径下配置添加一个文件。
src/main/resources/META-INF/services/javatest.util.serviceloader.ILoader

文件名字是接口的全限定类名
Filename: javatest.util.serviceloader.ILoader

文件内容是实现类的全限定类名
多个实现类用换行符分隔。
javatest.util.serviceloader.LoaderA
javatest.util.serviceloader.LoaderB



