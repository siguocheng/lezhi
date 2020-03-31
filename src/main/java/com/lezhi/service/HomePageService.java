package com.lezhi.service;

import java.util.List;

import com.lezhi.dto.PictureDto;
import com.lezhi.entity.Picture;

public interface HomePageService {

	List<Picture> listPicture(PictureDto pictureDto);
	
	Integer updatePicture(List<PictureDto> list);
}
