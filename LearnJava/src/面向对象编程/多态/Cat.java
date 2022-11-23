package 面向对象编程.多态;

public class Cat extends Animal {

    private String name;
    private String color = "灰";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void eat() {
        System.out.println("猫吃东西");
    }
}
