package com.lezhi.dao;

import java.util.List;

import com.lezhi.dto.PictureDto;
import com.lezhi.entity.Picture;

public interface PictureMapper {
    /**
     *
     * @mbg.generated 2020-03-31
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-03-31
     */
    int insert(Picture record);

    /**
     *
     * @mbg.generated 2020-03-31
     */
    int insertSelective(Picture record);

    /**
     *
     * @mbg.generated 2020-03-31
     */
    Picture selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-03-31
     */
    int updateByPrimaryKeySelective(Picture record);

    /**
     *
     * @mbg.generated 2020-03-31
     */
    int updateByPrimaryKey(Picture record);
    
    List<Picture> listPicture(PictureDto pictureDto);
}