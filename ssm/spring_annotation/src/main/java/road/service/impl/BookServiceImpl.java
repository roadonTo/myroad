package road.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import road.dao.BookDao;
import road.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional(
        //readOnly = true   只读
        //timeout = 3   超时
        //noRollbackFor = ArithmeticException.class     回滚
        //noRollbackForClassName = "java.lang.ArithmeticException"    回滚
        //isolation = Isolation.DEFAULT     隔离级别
        //propagation = Propagation.REQUIRES_NEW    事务的传播
    )
    public void buyBook(Integer userId, Integer bookId) {

        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);

        //更新图书的库存
        bookDao.updateStock(bookId);

        //更新用户的余额
        bookDao.updateBalance(userId, price);


    }
}
