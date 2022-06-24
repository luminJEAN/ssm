package com.lm.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lm.ssm.entity.Memorials;
import com.lm.ssm.service.MemorialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/memorials")
public class MemorialsController {

    @Autowired
    private MemorialsService memorialsService;

    @GetMapping(value="/getAll")
    public String getAll(Model model,Memorials memorials,HttpSession session){
        System.out.println(memorials);
        List<Memorials> lists = memorialsService.getMemorialsAll(memorials,session);
        System.out.println(lists);
        model.addAttribute("lists",lists);
        return "lists";

    }

    @GetMapping(value="/getAllByPage")
    public String getAllByPage(Model model,int currentPage,
                                int size,
                               Memorials memorials, HttpSession session) {
        System.out.println(1);
        PageHelper.startPage(currentPage, size);
        System.out.println(currentPage);
        System.out.println(size);
        System.out.println(12);
        PageInfo<Memorials> lists = memorialsService.getMemorialsAllByPage(currentPage,size, memorials,session);
        System.out.println(lists);
        model.addAttribute("lists",lists);
        return "lists";

    }


    //?拼接，参数如下
    @GetMapping(value="/getDetails")
    public String getDetails(String id,Model model){
        System.out.println(123);
        System.out.println(id);
        Memorials info = memorialsService.getMemorialsById(id);
        if (info.getMemorialsStatus() == 0) {
            info.setMemorialsStatus(1);
        }
        System.out.println(info);
        memorialsService.updateMemorials(info);
        model.addAttribute("details",info);
        return "details";

    }

    @PostMapping(value = "/addMemorials")
    public Map<String,Object> addMemorials(@RequestBody Map<String,Object> params, HttpSession session) {
        System.out.println("添加");
        System.out.println(params);
        return memorialsService.saveMemorials(params,session);

    }

    //  /拼接，参数如下
    @PostMapping(value="/deleteMemorials/{id}")
    public String deleteMemorials(@PathVariable("id") String id,Model model){
        System.out.println(id);
        int result = memorialsService.deleteMemorials(id);
        System.out.println(result);
        return "redirect:/memorials/getAll";

    }
    //进入编辑页面
    @GetMapping(value="/getEditDetails")
    public String getEditDetails(String id,Model model){
        System.out.println(123);
        System.out.println(id);
        Memorials info = memorialsService.getMemorialsById(id);
        if (info.getMemorialsStatus() == 0) {
            info.setMemorialsStatus(1);
        }
        System.out.println(info);
        memorialsService.updateMemorials(info);
        model.addAttribute("details",info);
        return "edit";

    }

    @PostMapping(value="/editMemorials")
    public String editMemorials(Memorials memorials ,Model model){
        System.out.println(12334);
        System.out.println(memorials);
        memorials.setMemorialsStatus(2);
        memorials.setFeedbackTime(new Date());
        System.out.println(memorials);
        memorialsService.updateMemorials(memorials);
        return "redirect:/memorials/getAll";
    }


    //  /拼接，参数如下
    @PostMapping(value="/applyMemorials/{id}")
    public String applyMemorials(@PathVariable("id") String id, @RequestBody String requestBody, Model model){
        System.out.println("获取表单的值"+requestBody);
        System.out.println("获取/id的值"+id);
        int result = memorialsService.applyMemorials(id,requestBody);
        return "edit";
    }



}
