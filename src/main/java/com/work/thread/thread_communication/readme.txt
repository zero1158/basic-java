线程通信 :

第一代 : sync -> wait() -> notify()
    通过上面三个方法,完成加锁 ->阻塞等待 ->唤醒的流程
第二代 : Lock ->
        通过await()方法进行阻塞 Condition condition = lock.newCondition();condition.await(); ->
        通知唤醒 condition.signalAll();
第三代 : 堵塞队列

线程通信实例 第一代:
    两个线程交替打印100以内的数字