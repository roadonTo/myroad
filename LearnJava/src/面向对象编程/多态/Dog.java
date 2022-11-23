package 面向对象编程.多态;

import java.util.Objects;

public class Dog extends Animal {

    private String name;
    public String color = "白";
    private int tui = 4; //腿有四只

    public int getTui() {
        return tui;
    }

    public void setTui(int tui) {
        this.tui = tui;
    }

    @Override
    public void eat() {
        System.out.println("狗吃东西");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", tui=" + tui +
                '}';
    }
}
