package com.foodie.itemprovider.mapper;

import com.foodie.pojo.Choice;
import com.foodie.pojo.Item;

import java.util.List;


public interface ChoiceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table choice
     *
     * @mbg.generated
     */
    int insert(Choice record);
    int update(Choice record);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table choice
     *
     * @mbg.generated
     */
    List<Choice> selectAll();
}