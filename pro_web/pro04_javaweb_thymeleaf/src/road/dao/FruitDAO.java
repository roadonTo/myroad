package road.dao;

import road.pojo.Fruit;

import java.util.List;

public interface FruitDAO {

    //获取所有的库存列表信息
    List<Fruit> getFruitList();
}
