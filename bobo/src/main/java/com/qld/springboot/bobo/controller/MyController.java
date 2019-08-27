package com.qld.springboot.bobo.controller;

import com.qld.springboot.bobo.config.Deliver;
import com.qld.springboot.bobo.model.NameList;
import com.qld.springboot.bobo.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
/*
 *
 * @program: bobo
 * @description:
 * @author: 秦令达
 * @create: 2019-06-28 14:44
 */

@RestController
public class MyController {


    @Value("${bsfit.name}")
    public String name;

    @Value("${bsfit.age}")
    public String age;


    @Autowired
    public FindService findService;


    @Autowired
    public Deliver deliver;

    @RequestMapping("/myController")
    public String myController() {

        List<NameList> engineResult = findService.findEngineResult();
        System.out.println("" + engineResult);
        System.out.println("name" + name);
        System.out.println("name1" + deliver.getName());

        System.out.println("age" + age);
        System.out.println("age1" + deliver.getAge());

        return "success";
    }

    @RequestMapping("/seeJsp")
    public ModelAndView getJsp() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "哈哈");
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @RequestMapping("/form")
    public String getForm(@RequestBody List<Map> list) {
        Map map = list.get(0);
        String o = (String) map.get("name");
        System.out.println("得到返回的名字为：" + o);
        return "success";
    }

    @RequestMapping("/form1")
    public String getForm1(@RequestParam(value = "name", required = false) String name) {

        System.out.println("得到返回的名字为：" + name);
        return "success";
    }

    @RequestMapping("/form2")
    public String getForm2(@RequestBody JSONObject jsonObject) {
        String name = null;
        try {
            name = jsonObject.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("得到返回的名字为：" + name);
        return "success";
    }


}
