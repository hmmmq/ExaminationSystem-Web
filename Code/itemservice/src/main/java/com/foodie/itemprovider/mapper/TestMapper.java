package com.foodie.itemprovider.mapper;

import com.foodie.pojo.Test;
import java.util.List;

public interface TestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbg.generated
     */
    int insert(Test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbg.generated
     */
    List<Test> selectAll();
}