基于注解来管理bean——其中包含了 基于注解的自动装配
一。注解    与    扫描
在配置文件中配置组件扫描，在文件上添加注解
标识组件的常用注解： 其实对于spring来说 这几个组件没有区别，只是对程序员来说 下面三个一看就知道是加在哪个层的
@Component将类标识为普通组件
@Controller将类标识为控制层组件
@Service将类标识为业务层组件
@Repository将类标识为持久层组件
通过注解+扫描 所配置的bean的id 默认值为类的小驼峰，如果想自定义id的话可以在写注解时写成@Controller("controller")
二。基于注解的自动装配 （@Autowired）
@Autowired注解能够标识的位置：
a》标识在成员变量上，此时不需要设置成员变量的set方法
b》标识在set方法上
c》标识在为当前成员变量赋值的有参构造上
（其实 就是能给 变量赋值的 三个位置）
@Autowired的实现原理：
a》默认通过byType的方式，在IOC容器中通过类型匹配某个bean为属性赋值
b》若有多个类型匹配的bean，此时会自动转换为byName的方式实现自动装配的效果
c》若byType和byName都不行，此时会报NoUniqueDefinitionException异常；补救方法是再加一个@Qualifier()注解 指定某个bean的名字， 为属性赋值
@Autowired
@Qualifier("userDaoImpl")
private UserDao userDao;
d》若IOC容器中没有任何一个类型匹配的bean 比如少写了个@Service注解，会报NoSuchBeanDefinitionException异常，可以将@Autowired(required=true) 默认的true 改为 false，就会变成NoUniqueDefinitionException异常了