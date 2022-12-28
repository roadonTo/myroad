package reflect.com.road;

public class Cat extends Animal {
    private String name = "小黄";
    public int age = 18;

    public static void hi() {
        System.out.println("hello world");
    }

    public void cry() {
        System.out.println("不给糖吃 我哭了啊");
    }

    public Cat() {
    }

    public Cat(String str) {
        this.name = str;
    }
}
