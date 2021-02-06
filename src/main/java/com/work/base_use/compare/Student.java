package com.work.base_use.compare;

public class Student implements Comparable<Student>{

    private String name;
    private String age;
    private String message;

    public Student(String name) {
        this.name = name;
        }

    public Student(String name, String age, String message) {
        this.name = name;
        this.age = age;
        this.message = message;
        }

    /**
     * 自定义类的比较方法-->实现Comparable接口
     * @param o
     * @return
     */
    @Override
    public int compareTo(Student o) {
        if (Integer.parseInt(this.age) > Integer.parseInt(o.age))
        return 1;
        if (Integer.parseInt(this.age) < Integer.parseInt(o.age))
        return -1;
        if (Integer.parseInt(this.age) == Integer.parseInt(o.age))
        return this.message.compareTo(o.message);
        throw new RuntimeException("比较类型异常");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Student{" +
        "name='" + name + '\'' +
        ", age='" + age + '\'' +
        ", message='" + message + '\'' +
        '}';
    }
}
