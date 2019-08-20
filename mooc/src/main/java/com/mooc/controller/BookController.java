package com.mooc.controller;


import com.mooc.pojo.Bookadmin;
import com.mooc.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



@Controller
@RequestMapping("/a")
public class BookController {
    @Autowired
    BooksService booksService;
    //列出数据表格
    //设置listBooks页面（list第一种写法）
    @RequestMapping("/listBooks")
    public ModelAndView listBooks(){
        ModelAndView mav = new ModelAndView();
        List<Bookadmin> bb = booksService.list();
        mav.addObject("bb",bb);
        mav.setViewName("listBooks");
        return mav;
    }
    //添加数据
    //第一步：跳转到这里并添加图书信息，点击添加按钮就执行下边第二段代码
    @RequestMapping("/addBooks0")
    public String addBooks0(){
        return "savepage";
    }
    //第二步：把下边的页面数据返回给后端，再跳转到listBooks页面
    @RequestMapping(value = "/addBooks",method = RequestMethod.POST)
    public String addBooks(Bookadmin bookadmin){
        booksService.insertBook(bookadmin);
        return "redirect:listBooks";
    }
    //修改数据
    //第一步：更新图书，先通过bid找到图书，并列在/updatepage/{bid}页面上，
    @RequestMapping("/updatepage/{bid}")
    public String updatepage(@PathVariable("bid") int bid,Model model){
        model.addAttribute("bookadmin",booksService.getBookByBid(bid));
        return "updatepage";
    }
    //第二步：然后修改即可，在这里点更新提交数据给后端
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(Bookadmin b){
        booksService.update(b);
        return "redirect:listBooks";
    }
    //删除图书信息
    @RequestMapping("/deleteBooksByBid")
    public String deleteBooksByBid(Bookadmin bid){
        booksService.deleteBookByBid(bid);
        return "redirect:listBooks";
    }
}
