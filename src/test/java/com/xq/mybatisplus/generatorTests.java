package com.xq.mybatisplus;



import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class generatorTests {


    @Test
    public void generatorTest() {

        //1、全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("xiongqi");
        globalConfig.setActiveRecord(false);
        globalConfig.setOutputDir("E:\\person\\project\\mybatisplus\\src\\main\\java");
        globalConfig.setFileOverride(true);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);

        //2、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/mp?characterEncoding=utf8");

        //3、策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix(new String[] { "tbl_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略


        //4、包名配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.xq.mybatisplus");
        pc.setModuleName("generator");
        pc.setController("controller");
        pc.setEntity("domain");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setXml("mapper.xml");


        //5、整合配置
        AutoGenerator mpg = new AutoGenerator();
        mpg.setDataSource(dsc);
        mpg.setGlobalConfig(globalConfig);
        mpg.setStrategy(strategy);
        mpg.setPackageInfo(pc);

        mpg.execute();
    }



}
