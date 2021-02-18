Map接口:
    HashMap:
        作为Map的主要实现类,线程不安全的,可以储存key=null或者value=null的情况
    LinkedHashMap:
        在遍历map元素时,可以按照添加顺序实现遍历,对于频繁的遍历,效率高于HashMap
        原因:在原有的HashMap基础上,添加了一对指针,分别指向上一个元素和下一个元素
    TreeMap:
        底层使用的是:红黑树
        可以保证按照添加的key-value进行排序(类似于TreeSet),此时考虑重写key值所在类的比较器(自然排序,定制排序)
        来修改排序规则
    HashTable:作为古老的实现类,线程安全,效率低,不能储存null的key和value
    Properties:常用来处理配置文件,kay和value都是String类型

    DEFAULT_LOAD_FACTOR:负载因子->0.75


问题:
    HashMap的底层运行原理
    HashMap和HashTable的异同
    CurrentHashMap和HashTable的异同


HashMap中的方法:
    注意循环获取map中的key-value的方法: