package com.lezhi.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public ResultBean<Map<String, Object>> uploadProjectPicture(HttpSession httpSession, HttpServletRequest request,
			Integer picType) throws FileNotFoundException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		MultipartFile multipartFile = multipartRequest.getFile("file");
		String fileName = multipartFile.getOriginalFilename();
		
		Integer length = fileName.length();
		String nameEnd = fileName.substring(length - 4, length);

		String serverUrl = "http://" + request.getServerName() + ":" + request.getServerPort();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String message = "";

		String uploadUrl = ResourceUtils.getURL("classpath:").getPath();
		
		String forder = "/otherPic";
		// 产品图片
		if (picType == 1) {
			forder = "/bigPic";
		}
		// 主页大图片
		else if (picType == 2) {
			forder = "/clientPic";
		}
		// 主页客户图片
		else if (picType == 3) {
			forder = "/projectPic";
		}
		
		// 若目录不存在，则创建
		String directory = uploadUrl + forder;
		File dir = new File(directory);
		if (!dir.exists()) {
			dir.mkdir();
		}
		String pictureName = sdf.format(new Date())  + "_"  + fileName;
		String url = directory + File.separator + pictureName;
		String pictureUrl = serverUrl + "/lezhi" + forder + "/" + pictureName;
		
		File file = new File(url);
		try (InputStream is = multipartFile.getInputStream(); FileOutputStream fos = new FileOutputStream(file)) {

			int len;
			byte[] bytes = new byte[1024];// 一次读取1M
			while ((len = is.read(bytes)) > 0) {
				fos.write(bytes, 0, len);
			}
		} catch (Exception e) {
			message = "文件上传异常";
			e.printStackTrace();
		}

		Map<String, Object> dataMap = new HashMap<>(1);
		dataMap.put("url", pictureUrl);
		dataMap.put("name", pictureName);

		return new ResultBean<Map<String, Object>>(dataMap);
	}

}
