String:
    1.被final修饰--->不可被继承,不可被修改(不可变性)
        1.当对字符串进行重新赋值时,需要在jvm的方法区重新开辟区域赋值,并将该区域的地址赋给原字符串,并不会改变原有的value值
        2.当对现有的字符串进行操作的时候,也需要重新指定方法区区域赋值
        3.当调用repalce()方法时,实际上也是重新指定了内存区域
    2.实现了Serializable接口--->支持序列化
    3.实现了Comparable接口--->可以比较大小,重写了比较接口,实际上就是循环比较每个字符的ascii码
    4.内部定义了final char[]数组,用于储存字符串数据
    5.通过字面量的方式进行给字符串赋值--->此时字符串常量是声明在方法区中的,而通过new,是在堆中开辟的内存空间,并将字符串的引用指向方法区中常量池
    6.字符串常量池中是不会储存相同的内容的字符串的

String实例化的方式:
                 字面量定义的方式:String str1 = "111";
                     -->此时,str1中存放的是常量池中111字符串的地址
                 通过构造器的方式:String str2 = new String("222");
                     -->此时,str2中保存的是堆空间中的内存对象的地址,而这个内存对象中又有一个指向方法区中具体数据222的地址
String使用结论:
      1.常量和常量拼接的结果在常量池中,且常量池不会存放相同的数据
      2.但是,只要拼接方有一个是对象,拼接结果就会存放在堆空间中
      3.如果拼接的结果调用了intern()方法,返回值就在常量池中


String ,StringBuffer ,StringBuilder
    String:不可变的字符序列
           底层使用char[]数组: 在每次创建String的时候,char[]数组的长度实际上就已经被确定了,new String("12")->new char[]{'1','2'}
                                                                                      当new String()时->new char[0]
    StringBuffer:可变的字符序列
                 方法都被synchronized修饰,线程安全
                 底层使用char[]数组: 当new StringBuffer() -> new char[16],实际上就是new了一个长度为16的char数组
                                    当new StringBuffer("abc") -> new char[abc.length()+16]

    StringBuilder:可变的字符序列
                  线程不安全,效率更高
                  底层使用char[]数组      : 同上

    StringBuffer和StringBuilder的扩容问题 : 扩容为原来的2倍+2,同时将原有数组中的元素复制到新的数组中




