package com.mooc.mapper;
import com.mooc.pojo.Bookadmin;
import java.util.List;

public interface BookMapper {
    List<Bookadmin> list();
    int insert(Bookadmin record);
    int update(Bookadmin b);
    int delete(Bookadmin bid);
    Bookadmin getBookByBid(Integer bid);
}
