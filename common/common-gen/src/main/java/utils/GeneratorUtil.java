package utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;


public class GeneratorUtil {
    private static final String DATE_TIME = "datetime";
    private static final String TIME_STAMP = "timestamp";
    private static final String DATE = "date";


    /**
     * 代码生成器
     *
     * @param args :
     */
    public static void main(String[] args) {


        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Veloctiy
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("huangc");
        //生成文件路径
        gc.setOutputDir("F:\\baomidou\\src\\main\\java");
        // 是否覆盖同名文件，默认是false
        gc.setFileOverride(true);
        // 不需要ActiveRecord特性的请改为false
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                //将数据库中时间类型转换成java.util.Date
                if (fieldType.toLowerCase().contains(TIME_STAMP)) {
                    return DbColumnType.LOCAL_DATE_TIME;
                }
                if (fieldType.toLowerCase().contains(DATE_TIME)) {
                    return DbColumnType.LOCAL_DATE_TIME;
                }
                if (fieldType.toLowerCase().contains(DATE)) {
                    return DbColumnType.LOCAL_DATE_TIME;
                }
                return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
            }
        });

        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/websocket-im?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表,不加则全部生成
        strategy.setInclude("im_group", "im_group_user", "im_history", "im_request", "im_user_relationship", "sys_dept", "sys_dept_user", "sys_user");
        //排除生成的表(排除表设置和生成表设置只能二选一)
        //实体类是否生成lombok模型
        strategy.setEntityLombokModel(true);
        // 自定义 mapper 父类
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");
        // 自定义 service 父类
        strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
        // 自定义 service 实现类父类
        strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.him.woll.common.entity");
        mpg.setPackageInfo(pc);
        mpg.execute();

    }
}
