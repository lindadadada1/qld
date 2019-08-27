package com.qld.springboot.bobo.service.serviceImpl;

import com.qld.springboot.bobo.mapper.NameListMapper;
import com.qld.springboot.bobo.model.NameList;
import com.qld.springboot.bobo.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bobo
 * @description:
 * @author: 秦令达
 * @create: 2019-07-03 15:26
 */
@Service
public class FindServiceImpl implements FindService {
    @Autowired
    private NameListMapper engineResultMapper;

    @Override
    public List<NameList> findEngineResult() {
        List<NameList> engineResults = engineResultMapper.selectAll();

        return engineResults;
    }
}
