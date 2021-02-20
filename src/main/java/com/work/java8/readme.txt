java8 的 新特性 :
    1.Lambda表达式
    2.函数式(Functional)接口
    3.方法的引用和构造器的引用
    4.Stream API
    5.Optional 类
    6.日期类API


1.Lambda表达式: 都是针对于接口,且接口中只能有一个方法  -> 依赖于函数式接口,本质就是函数式接口的实例
    举例:(o1,o2)->Integer.compare(o1,o2);
    ->  :Lambda操作符
    左边: Lambda形参列表(就是接口中抽象方法的形参列表)
    右边: Lambda体(就是重写的抽象方法的方法体)

    六种情况:
        1.无参,无返回 ;2.有一个参数,没有返回值 ;3.数据类型可以省略,因为可由编译器推断得出
        4.若lambda只有一个参数,则参数的小括号可以省略
        5.需要两个或以上的参数,并有多条执行语句,并且可以有返回值
        6.当lambda体中只有一条执行语句,则return和大括号都可以省略


2.函数式接口: 若一个接口中,只声明了一个抽象方法,则此接口就是函数式接口
    在Java.util.function包下定义了很多函数式接口,内置四大核心函数式接口:
    1.消费型接口:Consumer<T>       void accept<T t>
    2.供给型接口:Supplier<T>       T get()
    3.函数型接口:Function<T,R>     R apply<T t>
    4.断定型接口:Predicate<T>      boolean test<T>


3.方法引用和构造器引用
    方法引用:可以看作是Lambda表达式的深层次表达,是lambda的一个语法糖

    使用要求:接口中的抽象方法的形参列表和返回值类型与方法引用的方法的参数列表和返回值类型相同

4.Stream API:
    和Collection的区别:Collection是一个静态的内存容器,而Stream是有关计算的
    Stream:不会自己存储数据; 不会改变源对象,会返回一个持有结果的stream; stream操作是延迟的,只有等到需要结果的时候才执行

    创建Stream实例的三种方式:
        1.通过集合 : list.stream()
        2.通过数组 : Arrays.stream(arr)
        3.通过Stream.of()方法:

    使用-中间操作:
        1.筛选与切片 : filter() , limit() , skip() , distinct()
        2.映射 : map(function f)
        3.排序 : sorted() , sorted(Comparertor com)

    使用-终止操作:
        1.匹配与查找 :
        2.规约(累加)了解 : reduce()
        3.收集 : collect(Collector c)

