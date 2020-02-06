package com.lezhi.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lezhi.entity.ResultBean;


@RestController
@RequestMapping("/upload")
public class UploadFileController {


     // 上传项目图片
     @PostMapping("/uploadProjectPicture")
     public ResultBean<Map<String, Object>> uploadProjectPicture(HttpSession httpSession, HttpServletRequest request,String picture) throws FileNotFoundException {
         MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
         MultipartFile multipartFile = multipartRequest.getFile("file");
         String fileName = multipartFile.getOriginalFilename();
         Integer length = fileName.length();
         String nameEnd = fileName.substring(length-4, length);

         String projectId = picture;

         String serverUrl = "http://" + request.getServerName()+":"+request.getServerPort();

         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
         String message = "";

         String uploadUrl =  ResourceUtils.getURL("classpath:").getPath();
         //若目录不存在，则创建
         String directory = uploadUrl +"/projectPic";
         File dir = new File(directory);
         if(!dir.exists()){
             dir.mkdir();
         }
         String pictureName = projectId + "_" + sdf.format(new Date()) + fileName;
         String url = directory + File.separator + pictureName;
         String pictureUrl =  serverUrl + "/projectPic/" + pictureName;
         File file = new File(url);
         try (InputStream is = multipartFile.getInputStream();FileOutputStream fos=new FileOutputStream(file)){
        	 
             int len;
             byte[] bytes = new byte[1024];//一次读取1M
             while((len = is.read(bytes)) > 0){
                 fos.write(bytes, 0, len);
             }
         }catch (Exception e){
             message = "文件上传异常";
             e.printStackTrace();
         }
         
         Map<String, Object> dataMap = new HashMap<>(1);
         dataMap.put("url", pictureUrl);
         dataMap.put("name", pictureName);
         dataMap.put("type", picture);
         
         
         return new ResultBean<Map<String,Object>>(dataMap);
     }

}
