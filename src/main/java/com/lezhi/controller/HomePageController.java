package com.lezhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.lezhi.dto.PictureDto;
import com.lezhi.entity.Picture;
import com.lezhi.entity.ResultBean;
import com.lezhi.service.HomePageService;

@RestController
@RequestMapping("/homepage")
public class HomePageController {

	@Autowired
	HomePageService homePageService;
	
	@PostMapping("/listPicture")
	public ResultBean<List<Picture>> listPicture(@RequestBody String params) {
		PictureDto pictureDto = JSONObject.parseObject(params, PictureDto.class);

		return new ResultBean<>(homePageService.listPicture(pictureDto));
	}
	
	@PostMapping("/updatePicture")
	public ResultBean<Integer> updatePicture(@RequestBody String params) {
		
		List<PictureDto> list = JSONObject.parseArray(params, PictureDto.class);

		return new ResultBean<>(homePageService.updatePicture(list));
	}
}
