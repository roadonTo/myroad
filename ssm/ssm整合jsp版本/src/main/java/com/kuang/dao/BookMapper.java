package com.kuang.dao;

import com.kuang.pojo.Books;

import java.util.List;


public interface BookMapper {
    int addBook(Books book);
    int deleteBookById(int id);
    int updateBook(Books books);
    Books queryBookById(int id);
    List<Books> queryAllBook();


}
