package com.lezhi.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lezhi.dao.PictureMapper;
import com.lezhi.dto.PictureDto;
import com.lezhi.entity.Picture;
import com.lezhi.service.HomePageService;

@Service
public class HomePageServiceImpl implements HomePageService {

	@Autowired
	PictureMapper pictureMapper;
	
	@Override
	public List<Picture> listPicture(PictureDto pictureDto) {

		return pictureMapper.listPicture(pictureDto);
	}

	@Override
	public Integer updatePicture(List<PictureDto> list) {

		Picture pic = null;
		int count = 0;
		
		for (PictureDto pictureDto:list) {
			pic = new Picture();
			BeanUtils.copyProperties(pictureDto, pic);
			if (pic.getId() == null) {
				count +=pictureMapper.insertSelective(pic);
			} else {
				count +=pictureMapper.updateByPrimaryKeySelective(pic);
			}
			
		}
		return count;
	}

}
