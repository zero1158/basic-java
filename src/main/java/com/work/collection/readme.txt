集合:
集合与数组都是对多个数据进行储存操作的结构,简称java容器

集合框架主要分为两个接口:

    Collection接口: 用来存储单例集合,一个个的对象
        1.List接口: 储存有序的,可重复的数据-->可以看作是一个动态数组
                    实现---> ArrayList,LinkedList,Vector
        2.Set接口 : 储存无序的,不可重复的数据
                    实现---> HashSet,LinkedHashSet,TreeSet

    Map接口: 是一个双列集合,用来储存一对对(key,value)的数据
           --->HashMap,LinkedHashMap,TreeMap,HashTable,Properties


Collection重点:
    Collection接口中的方法: 如remove(Obejct obj)和remove(index)方法的区别
                                remove(),底层调用的System.arraycopy()方法怎么实现的,作用是什么???
                           contains()方法需要重写obj对象所在类的equlas()方法
    Collection接口中的迭代器: Iterrator , forech
    ArrayList与LinkedArrayList,Vector的区别
    ArrayList源码分析: new(),add(),remove()等方法源码(jdk1.8和jdk1.7中的区别)
    LinkedList源码分析: 怎么实现链表

    Set接口:添加数据实际上是调用了equals()方法进行对象比较
    HashSet:添加数据的流程 -->见set_02
    LinkedHashSet:为什么可以按照添加的顺序获取数据-->使用了链表结构
    TreeSet:比较


Map重点:
    HashMap的实现源码(jdk1.8与jdk1.8),结构,方法源码
    HashMap和HashTable的区别
    CurrentHashMap和HashTable区别
