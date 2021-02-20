反射的特征 : 动态性
疑问:反射机制与面向对象中的封装特性是不是矛盾的?如何看待这两个技术?
    不矛盾: 反射机制解决的是能不能调用的问题,
            封装性更多的体现在建议,提示去调什么,怎么调用的作用上

关于Java.lang.Class类的理解:
    1.类的加载过程:程序经过javac.exe命令后,会生成.class文件(字节码文件) -->编译
                  接着通过java.exe命令对某个字节码文件进行解释运行,相当于将某个字节码文件加载到内存中 -->类加载
                  加载到内存中的类就叫做: 运行时类,此运行时类就作为Class的一个实例
    2.运行时类就是一个Class实例
    3.加载到内存中的运行时类,一个对象只会存在一个,且会缓存一定时间

    理解 : Class实例对应着内存中的一个运行时类

    调用clazz.newInstance()方法时:
        1.运行时类中必须要有对应的空参构造器 ->newInstance()实际上就是调用了空参构造器
        2.权限级别要足够

获取Class实例的四种方式:
    1.调用运行时类的属性 : .class
    2.通过运行时类的对象,调用getClass()
    3.调用Class类的静态方法:getClass() ->更好的体现了反射的动态性
    4.使用类加载器(了解)


获取运行时类的属性:
    getFields():获取当前运行时类及其父类中声明为public的属性
    getDeclaredFields():获取当前运行时类中的所有属性(不包含父类声明的属性)
    getModifiiers():获取属性的权限修饰符
    getType():获取属性的数据类型
    getName():获取变量名

获取运行时类的方法
    getMethods():获取当前运行时类及其父类中的public的方法
    getDeclaredMethods():获取当前运行时类中声明的所有方法(不包含父类声明的属性)
    getAnnotation():获取注解
    getModifiiers():获取属性的权限修饰符
    getReturnType():获取返回值类型
    getName():获取方法名
    getParameterTypes():获取参数列表

获取运行时类的构造器
    getConstructors():
    getDeclaredConstructors():
