package spring.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.mapper.NameListMapper;
import spring.springboot.model.NameList;
import spring.springboot.service.NameListService;

import java.util.List;

/**
 * @program: qld
 * @description:
 * @author: 秦令达
 * @create: 2019-07-12 10:03
 */
@Service
public class NameListServiceImpl implements NameListService {

    @Autowired
    private NameListMapper nameListMapper;

    @Override
    public List<NameList> getAllNameList() {

        return nameListMapper.getAllNameList();
    }
}
