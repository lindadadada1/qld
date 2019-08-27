package spring.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
/*
*
 * @program: qld
 * @description:
 * @author: 秦令达
 * @create: 2019-07-31 17:12
 */

@Configuration
//@MapperScan(basePackages = "spring.springboot.mapper")
//@MapperScan(basePackages = {"spring.springboot.mapper"},sqlSessionFactoryRef = "dsSqlSessionFactory")
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "frms.etl.to")
    public DataSource dataSource1(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "frms.etl.mgr")
    public DataSource dataSource2(){
        return DataSourceBuilder.create().build();
    }




    @Bean(name = "dsSqlSessionFactory")
    @Primary
    public SqlSessionFactory dsSqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource1,
                                                 @Qualifier("dsTypeTransf") String dsTypeTransf) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource1);
      /*  bean.setMapperLocations(
                // 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath*:mysql/*.xml"));
*/
        bean.setConfigLocation(new ClassPathResource("NameListConfig"+org.springframework.util.StringUtils.capitalize(dsTypeTransf)+".xml"));
        return  bean.getObject();
    }

    @Bean(name = "mgrSqlSessionFactory")
    public SqlSessionFactory mgrSqlSessionFactory(@Qualifier("dataSource2") DataSource dataSource2,
                                                 @Qualifier("dsTypeTransf") String dsTypeTransf) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource2);
      /*  bean.setMapperLocations(
                // 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath*:mysql/*.xml"));
*/
        bean.setConfigLocation(new ClassPathResource("NameConfig"+org.springframework.util.StringUtils.capitalize(dsTypeTransf)+".xml"));
        return  bean.getObject();
    }


    @Bean
    public String dsTypeTransf(@Value("${frms.etl.to.jdbc.type}") String type ){
        if (type.contains("mysql")){
            return  "mysql";
        }else if (type.contains("oracle")){
            return "oracle";
        }
        return  null;
    }





}
