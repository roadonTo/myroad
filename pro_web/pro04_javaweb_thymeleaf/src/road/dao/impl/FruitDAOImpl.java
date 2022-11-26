package road.dao.impl;

import road.dao.FruitDAO;
import road.dao.base.BaseDAO;
import road.pojo.Fruit;

import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("select * from fruit");
    }
}
