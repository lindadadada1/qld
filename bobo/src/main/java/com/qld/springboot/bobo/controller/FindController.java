package com.qld.springboot.bobo.controller;

import com.qld.springboot.bobo.model.NameList;
import com.qld.springboot.bobo.service.FindService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: bobo
 * @description:
 * @author: 秦令达
 * @create: 2019-07-03 09:33
 */
@RestController
public class FindController {

    private Logger logger = LoggerFactory.getLogger(FindController.class);

    @Autowired
    FindService findService;

    @RequestMapping("/getData")
    public String getDataa() {
        List<NameList> engineResult = findService.findEngineResult();
        logger.info("查到的数据为\t{}", engineResult);
        return "success";
    }

}
