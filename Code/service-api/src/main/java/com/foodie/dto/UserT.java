package com.foodie.dto;
import com.foodie.pojo.Student;
import com.foodie.pojo.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 一个DTO，
 * userType:用户类型，为0是不存在该用户，为1是学生，为2是老师
 * student:学生
 * teacher:老师
 * 用法：用于统一验证登录。若为2,student=null,teacher!=null.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserT implements Serializable {
    int userType;
    Student student;
    Teacher teacher;
}
