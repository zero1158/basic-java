Collection中需要重写equals()的方法 : contains(),remove()
    通过重写元素对象的equals()方法,改变判断元素存在/相等的结果--->若是不重写调用的就是Object中的方法


看ArrayList源码,对比StringBuffer的源码

    1.ArrayList和LinkedList,Vector的区别?
        同:都实现了List接口,储存数据的特点相同:有序的,可重复的
        异:ArrayList:是List接口的主要实现类,线程不安全,效率高,底层还是使用Object[]的形式存储数据
                     数组结构,擅长查询操作,若是向数据中插入数据,需要依次挪动插入位置后的所有数据
           LinkedList:线程不安全,底层使用双向链表结构,由一个个node<>组成,
                           node中存放数据主体,指向上一个数据的指针,指向下一个数据的指针
                           所以更擅长插入操作(指向中间位置插入数据),和删除操作
           Vector:jdk1.1就已经存在了,线程安全底层使用Object[]

    2.ArrayList源码-jdk1.7和jdk1.8区别
        jdk1.7:
            new ArrayList<>():在底层创建一个长度是10的Object[]数组elementData
            list.add("123"):elementData[0] = new String("123")
                            ensureCapacityInternal():判断数组容量
                            modCount++:快速失败机制,不用管
            list.add("aaa"):若本次添加导致数组容量不足即数组elementData容量不够,则进行扩容,默认情况下
                            扩容为原来的1.5倍,并将原数组中的数据复制到新的扩容数组中去
        jdk1.8:
            new ArrayList<>():只是创建了一个Object[]数组elementData,初始化为{},并没有指定长度
                              等于Object[]={},只是一个数组的引用
            list.add("123"):第一次add数据的时候,才创建了长度为10的数组,这是一个扩容操作,将数组扩容为10
        小结:jdk1.7中的创建list对象的方式像是单例模式中的饿汉式,而jdk1.8中的方式更像是懒汉式,延迟了数组的创建
             节约了内存空间

    3.LinkedList源码分析:
        transient Node<E> first;单独记录链表第一个
        transient Node<E> last;单独记录链表最后一个
        //内部类
        private static class Node<E> {
                E item;         要存储的数据
                Node<E> next;   指向上一个数据
                Node<E> prev;   指向下一个数据,若没有下一个则为null

                Node(Node<E> prev, E element, Node<E> next) {
                    this.item = element;
                    this.next = next;
                    this.prev = prev;
                }
            }


Set接口:储存无序的,不可重复的数据
    无序的:不等于随机性,不按照添加顺序,实际上都是根据计算得到的hash值进行算法运算之后得到的具体在set中存放的位置
    不可重复:保证添加元素按照equals()判断时,不能返回true,即相同的元素只能有一个

    HashSet:作为Set接口的主要实现类,线程不安全,可以储存null值
            存储过程:-->见set_02
    LinkedHashSet:HashSet的子类,遍历其内部数据时,可以按照添加的顺序获取,因其存储数据的格式-->类是Node
    TreeSet:可以按照添加对象的指定属性进行排序
            向TreeSet中添加的数据,要求是相同类的对象
            使用TreeSet存自定义类,必须指定排序方式,两种排序方式: 自然排序 ; 定制排序

    注意:重写equals()方法时,也要重写hashCode()方法


