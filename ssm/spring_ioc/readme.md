IOC和DI 思想
IOC容器创建对象的方式
获取bean的三种方式和注意事项
依赖注入
setter注入，构造器注入，null值注入，
为类类型、数组类型、list集合类型、map集合类型的属性赋值，p命令空间形式赋值

spring 管理数据源 以及引入外部文件
bean的作用域，生命周期，作用域对生命周期的影响
后置处理器（了解）：针对ioc容器中所有的bean起作用的，可以在bean初始化前后加入 额外的操作
FactoryBean（工厂bean）：
它是一个接口，需要创建一个类实现该接口，重写其中的方法
当把FactoryBean的实现类配置为bean时，会将当前类中getObject() 所返回的对象交给IOC容器管理
这样获取到的bean 只有实例化，没有依赖注入和初始化（显而易见 没有赋值也没有在bean中配置初始化的属性）