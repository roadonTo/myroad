package road.dao;

import road.pojo.Fruit;

import java.util.List;

public interface FruitDAO {

    //获取所有的库存列表信息
//    List<Fruit> getFruitList();
    List<Fruit> getFruitList(Integer pageNo, String keyword);//（改进为）分页查询


    //获取单个Fruit实体信息
    Fruit getFruitByFid(String fid);

    void updateFruit(Fruit fruit);

    void deleteFruit(Integer fid);

    //获取总记录条数
    int getFruitCount(String keyword);
}
