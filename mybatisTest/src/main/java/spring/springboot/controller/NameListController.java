package spring.springboot.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot.mapper.NameListMapper;
import spring.springboot.model.NameList;

import java.util.List;


/**
 * @program: qld
 * @description:
 * @author: 秦令达
 * @create: 2019-07-12 10:01
 */
@RestController
public class NameListController {

    private Logger loggerFactory = LoggerFactory.getLogger(NameListController.class);
   /* @Autowired
    private NameListMapper nameService;
*/
    @Autowired
    @Qualifier("dsSqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;


    //mgrSqlSessionFactory

    @Autowired
    @Qualifier("mgrSqlSessionFactory")
    private SqlSessionFactory mgrSqlSessionFactory;



    @RequestMapping("/getData")
    public List<NameList> getDatatime() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        NameListMapper mapper = sqlSession.getMapper(NameListMapper.class);
        List<NameList> allNameList = mapper.getAllNameList();
        loggerFactory.info("获取数据");
        sqlSession.close();
//nameService.getAllNameList();
        return allNameList;
    }


    @RequestMapping("/data")
    public com.example.demo3.model.NameList getDatatime2() {
        SqlSession sqlSession = mgrSqlSessionFactory.openSession();
        com.example.demo3.mapper.NameListMapper mapper = sqlSession.getMapper(com.example.demo3.mapper.NameListMapper.class);
        com.example.demo3.model.NameList nameList = mapper.selectByPrimaryKey(1);
        loggerFactory.info("获取数据");
        sqlSession.close();
//nameService.getAllNameList();
        return nameList;
    }





}
