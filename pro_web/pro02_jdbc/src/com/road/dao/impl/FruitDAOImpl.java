package com.road.dao.impl;

import com.road.dao.FruitDAO;
import com.road.dao.base.BaseDAO;
import com.road.pojo.Fruit;

import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("select * from fruit");
    }

    @Override
    public boolean addFruit(Fruit fruit) {
        String sql = "insert into fruit values(0,?,?,?,?)";
        int count = super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark());
        //insert语句返回的是自增列的值，而不是影响行数
        //System.out.println(count);
        return count > 0;
    }

    @Override
    public boolean updateFruit(Fruit fruit) {
        String sql = "update fruit set fcount = ? where fid = ? ";
        return super.executeUpdate(sql, fruit.getFcount(), fruit.getFid()) > 0;
    }

    @Override
    public Fruit getFruitByFname(String fname) {
        return super.load("select * from fruit where fname like ? ", fname);
    }

    @Override
    public boolean delFruit(String fname) {
        String sql = "delete from fruit where fname like ? ";
        return super.executeUpdate(sql, fname) > 0;
    }
}
