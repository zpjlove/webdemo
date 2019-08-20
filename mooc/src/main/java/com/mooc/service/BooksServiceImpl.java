package com.mooc.service;
import com.mooc.mapper.BookMapper;
import com.mooc.pojo.Bookadmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService{
    @Autowired
    private BookMapper bookMapper;
    //列出数据
    @Override
    public List<Bookadmin> list(){
        List<Bookadmin> list = this.bookMapper.list();
        return list;
    }
    //插入数据
    @Override
    public int insertBook(Bookadmin bookadmin){
        return bookMapper.insert(bookadmin);
    }
    //更新数据

    @Override
    public int update(Bookadmin b) {
        return bookMapper.update(b);
    }
    //删除数据
    @Override
    public int deleteBookByBid(Bookadmin bid){
        return  bookMapper.delete(bid);
    }
    @Override
    public Bookadmin getBookByBid(int bid){
        return bookMapper.getBookByBid(bid);
    }

}
