package com.codingyoo.controller;

import com.codingyoo.pojo.Product;
import com.codingyoo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    //查询所有商品
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> all = iProductService.findAll();
        mv.addObject("productList",all);
        mv.setViewName("product-list");
        return mv;
    }

    //保存商品
    @RequestMapping("save.do")
    public String save(Product product){
        iProductService.save(product);
        return "redirect:findAll.do";
    }
}
