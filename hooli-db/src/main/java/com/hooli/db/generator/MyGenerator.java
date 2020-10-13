package com.hooli.db.generator;

import com.gitee.flying.cattle.mdg.entity.BasisInfo;
import com.gitee.flying.cattle.mdg.util.EntityInfoUtil;
import com.gitee.flying.cattle.mdg.util.Generator;
import com.gitee.flying.cattle.mdg.util.MySqlToJavaUtil;

import java.sql.SQLException;
import java.util.Date;

/**
 * @author ：hooli
 * @date ：Created in 2020/10/10 3:25 下午
 * @description：自动生成工具
 */
public class MyGenerator {

    // 基础信息：项目名、作者、版本
    public static final String PROJECT = "hooli";
    public static final String AUTHOR = "hooli";
    public static final String VERSION = "1.0.0-SNAPSHOT";

    // 数据库连接信息：连接URL、用户名、秘密、数据库名
    public static final String URL = "jdbc:mysql://localhost:3306/hooli?useSSL=false&serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8";
    public static final String NAME = "root";
    public static final String PASS = "root";
    public static final String DATABASE = "hooli";

    // 类信息：类名、对象名（一般是【类名】的首字母小些）、类说明、时间
    public static final String CLASSNAME = "User";
    public static final String TABLE = "user";
    public static final String CLASSCOMMENT = "";
    public static final String TIME = new Date().getTime() + "";
    public static final String AGILE = new Date().getTime() + "";

    // 路径信息，分开路径方便聚合工程项目，微服务项目
    public static final String ENTITY_URL = "com.hooli.db.domain";
    public static final String DAO_URL = "com.hooli.db.dao";
    public static final String XML_URL = "com.hooli.db.dao.xml";
    public static final String SERVICE_URL = "com.hooli.db.service";
    public static final String SERVICE_IMPL_URL = "com.hooli.db.service.impl";
    public static final String CONTROLLER_URL = "com.hooli.db.api";

    //是否是Swagger配置
    public static final String IS_SWAGGER = "true";

    public static void main(String[] args) {
        BasisInfo bi = new BasisInfo(PROJECT, AUTHOR, VERSION, URL, NAME, PASS, DATABASE, TIME, AGILE, ENTITY_URL,
                DAO_URL, XML_URL, SERVICE_URL, SERVICE_IMPL_URL, CONTROLLER_URL, IS_SWAGGER);
        bi.setTable(TABLE);
        bi.setEntityName(MySqlToJavaUtil.getClassName(TABLE));
        bi.setObjectName(MySqlToJavaUtil.changeToJavaFiled(TABLE));
        //bi.setEntityComment(CLASSCOMMENT);

        try {
            bi = EntityInfoUtil.getInfo(bi);
            String fileUrl = "";// 生成文件存放位置
            //开始生成文件
            String aa1 = Generator.createEntity(fileUrl, bi).toString();
            String aa2 = Generator.createDao(fileUrl, bi).toString();
            String aa3 = Generator.createDaoImpl(fileUrl, bi).toString();
            //String aa4 = Generator.createService(fileUrl, bi).toString();
            //String aa5 = Generator.createServiceImpl(fileUrl, bi).toString();
            //String aa6 = Generator.createController(fileUrl, bi).toString();
            // 是否创建swagger配置文件
            //String aa7 = Generator.createSwaggerConfig(fileUrl, bi).toString();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
