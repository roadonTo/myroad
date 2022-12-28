package 面向对象编程.多态;

public class Test {

    public static void main(String[] args) {

        Animal animal = new Dog(); //向上转型
        Animal animal1 = new Cat();
        Dog dog = new Dog();


        getAnimal(animal);
        getAnimal(animal1);
        getAnimal(dog);
        System.out.println("---------------------");
        System.out.println(animal.getAge());
        System.out.println(animal.getColor());
        System.out.println(animal.color);
        System.out.println(animal.age);
        System.out.println(animal1.getAge());
        System.out.println(animal1.getColor());

        System.out.println(dog.getColor());// dog不能调用getAge方法，因为dog没有这个属性


        Dog dog1 = (Dog) animal; //向下转型
        System.out.println(dog1.getTui());

        //这个只能通过编译，执行是要报错的
        Dog dog2 = (Dog) new Animal(); //不能强转父类对象，只能强转父类的引用
        //Exception in thread "main" java.lang.ClassCastException: 面向对象编程.多态.Animal cannot be cast to 面向对象编程.多态.Dog
        //	at 面向对象编程.多态.Test.main(Test.java:26)
        System.out.println(dog2.getTui());


    }

    /*
    比如说我这个方法 是获取各种动物吃的东西  参数用的是Animal类型
    实际传进来的动物却是  狗，猫，老虎，兔子 这些
    这样 我的一个 animal.eat(); 就能用于所有的动物 ，
    不用因为是狗 就写的是  (Dog dog){ dog.eat();  }
    因为是猫 就写的是  (Cat cat){ cat.eat();  }

     */
    public static void getAnimal(Animal animal) {
        animal.eat();
    }

}
