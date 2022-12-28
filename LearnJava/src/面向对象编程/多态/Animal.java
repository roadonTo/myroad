package 面向对象编程.多态;

public class Animal {

    private String name;
    public String color = "黑";
    public int age = 18;

    public void eat() {
        System.out.println("动物吃东西");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
