package 枚举泛型常用类.泛型;

public class TestInter {

    public static void main(String[] args) {

        InterImpl<Object> inter1 = new InterImpl<>();
        inter1.show(24);

        InterImpl2 inter2 = new InterImpl2();
        inter2.show("hhh");
    }
}
