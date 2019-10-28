package com.team.test.controller;

import com.team.test.entity.Product;
import com.team.test.entity.Takeout;
import com.team.test.service.ProductService;
import com.team.test.service.TakeoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/page/")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private TakeoutService takeoutService;

    @RequestMapping("getAllProduct")
    public String getAllProduct(Model model){
        List<Product> list = productService.getAllProduct();
        model.addAttribute("list",list);
        return "index";
    }

    @RequestMapping("selectQuantity")
    @ResponseBody
    public Product selectQuantity(Integer id){
        return productService.selectQuantity(id);
    }

    @RequestMapping("outProduct")
    public String outProduct(Takeout takeout,Model model){
        takeout.setOutdate(new Date());
        int i = takeoutService.outProduct(takeout);
        model.addAttribute("flag",i);
        return "index";
    }
}
