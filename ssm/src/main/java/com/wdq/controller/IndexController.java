package com.wdq.controller;

import com.wdq.domain.User;
import com.wdq.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by wdq on 2018/3/26.
 */
@Controller
public class IndexController {

    @Resource
    private UserService userService;

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("list", userService.queryList());
        return mav;
    }

    @RequestMapping("/save")
    public String save(User user){
        userService.save(user);
        return "redirect:index";
    }
    @RequestMapping("/saveUI")
    public String saveUI(){
        return "save";
    }



}
