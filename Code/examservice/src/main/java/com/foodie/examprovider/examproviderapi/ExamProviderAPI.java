package com.foodie.examprovider.examproviderapi;

import com.foodie.dto.ExamCreate;
import com.foodie.dto.ServerResponse;
import com.foodie.pojo.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 备用。看情况分离。
 */
public interface ExamProviderAPI {
    @GetMapping("/getTeacher")
    public ServerResponse<Teacher> getTeacher() ;

    @GetMapping("/createexam/{teaid}")
    public ServerResponse<ExamCreate> createexam(@PathVariable("teaid") Integer teaid);
}
