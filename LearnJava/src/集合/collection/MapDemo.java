package 集合.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    Map集合的基本功能：
        V put(K key,V value)：添加元素
        V remove(Object key)：根据键删除键值对元素
        void clear()：移除所有的键值对元素
        boolean containsKey(Object key)：判断集合是否包含指定的键
        boolean containsValue(Object value)：判断集合是否包含指定的值(自学)
        boolean isEmpty()：判断集合是否为空
        int size()：集合的长度，也就是集合中键值对的个数

    二:
        Map集合的获取功能：
        V get(Object key):根据键获取值
        Set<K> keySet():获取所有键的集合
        Collection<V> values():获取所有值的集合
 */
public class MapDemo {
    public static void main(String[] args) {
        //创建集合对象
        Map<String,String> map = new HashMap<String,String>();

        //V put(K key,V value)：添加元素
        map.put("张无忌","赵敏");
        map.put("郭靖","黄蓉");
        map.put("杨过","小龙女");

        //V remove(Object key)：根据键删除键值对元素
//        System.out.println(map.remove("郭靖"));
//        System.out.println(map.remove("郭襄"));

        //void clear()：移除所有的键值对元素
//        map.clear();

        //boolean containsKey(Object key)：判断集合是否包含指定的键
//        System.out.println(map.containsKey("郭靖"));
//        System.out.println(map.containsKey("郭襄"));

        //boolean isEmpty()：判断集合是否为空
//        System.out.println(map.isEmpty());

        //int size()：集合的长度，也就是集合中键值对的个数
        System.out.println(map.size());


        //输出集合对象
        System.out.println(map);

        // -----------------------------------------------

        //V get(Object key):根据键获取值
//        System.out.println(map.get("张无忌"));
//        System.out.println(map.get("张三丰"));

        //Set<K> keySet():获取所有键的集合
//        Set<String> keySet = map.keySet();
//        for(String key : keySet) {
//            System.out.println(key);
//        }

        //Collection<V> values():获取所有值的集合
//        Collection<String> values = map.values();
//        for(String value : values) {
//            System.out.println(value);
//        }

        //----------Map集合的遍历

        // 第一种方式    获取所有键的集合。用keySet()方法实现
        Set<String> keySet = map.keySet();
        //遍历键的集合，获取到每一个键。用增强for实现
        for (String key : keySet) {
            //根据键去找值。用get(Object key)方法实现
            String value = map.get(key);
            System.out.println(key + "," + value);
        }


        //第二种方式     获取所有键值对对象的集合
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        //遍历键值对对象的集合，得到每一个键值对对象
        for (Map.Entry<String, String> me : entrySet) {
            //根据键值对对象获取键和值
            String key = me.getKey();
            String value = me.getValue();
            System.out.println(key + "," + value);
        }

    }
}
