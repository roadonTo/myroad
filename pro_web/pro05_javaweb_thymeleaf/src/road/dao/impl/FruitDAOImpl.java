package road.dao.impl;

import road.dao.FruitDAO;
import road.dao.base.BaseDAO;
import road.pojo.Fruit;

import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    //    @Override
//    public List<Fruit> getFruitList() {
//        return super.executeQuery("select * from fruit");
//    }
    @Override
    public List<Fruit> getFruitList(Integer pageNo, String keyword) {
        return super.executeQuery("select * from fruit where fname like ? or remark like ? limit ? , 5", "%" + keyword + "%", "%" + keyword + "%", (pageNo - 1) * 5);
    }

    @Override
    public Fruit getFruitByFid(String fid) {
        return super.load("select * from fruit where fid=" + fid);
    }

    @Override
    public void updateFruit(Fruit fruit) {
        super.executeUpdate("update fruit set fname = ? , price = ? ,fcount = ? , remark = ?  where fid = ? ",
                fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark(), fruit.getFid());
    }

    @Override
    public void deleteFruit(Integer fid) {
        super.executeUpdate("delete from fruit where fid = ?", fid);
    }

    @Override
    public int getFruitCount(String keyword) {
        return ((Long) super.executeComplexQuery("select count(*) from fruit where fname like ? or remark like ?", "%" + keyword + "%", "%" + keyword + "%")[0]).intValue();
    }


}
