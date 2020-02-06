 /*
  * Copyright (C), 2018-2018, 杭州物源科技有限公司
  * FileName: DatabaseCondition
  * Author:   Charlie
  * Date:     2018/10/26 11:33
  * Description: 数据库配置启用条件类
  */
 package com.lezhi.condition;


 import org.springframework.context.annotation.Condition;
 import org.springframework.context.annotation.ConditionContext;
 import org.springframework.core.type.AnnotatedTypeMetadata;

 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.io.InputStream;
 import java.util.Properties;

 /**
  * 数据库配置启用条件类
  *
  * @author Charlie
  * @date 2018/10/26 11:33
  */
 public class DatabaseCondition implements Condition {
     private static Properties properties;
     private static Boolean useDatabase;

     static {
         InputStream in = null;
         try {
             properties = new Properties();
             in = DatabaseCondition.class.getResourceAsStream("/common.properties");

             if (in != null) {
                 properties.load(in);
                 String str = properties.getProperty("wuyuan.common.useDatabase").trim();
                 if (str==null || "".equals(str)) {
                     useDatabase = Boolean.valueOf(str);
                 }
             } else {
                 useDatabase = true;
             }
         } catch (FileNotFoundException e) {
             // 默认使用数据库
             useDatabase = true;
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("读取common.properties配置失败！");
         } finally {
             if (in != null) {
                 try {
                     in.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }
     }


     @Override
     public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
         return DatabaseCondition.useDatabase;
     }
 }
