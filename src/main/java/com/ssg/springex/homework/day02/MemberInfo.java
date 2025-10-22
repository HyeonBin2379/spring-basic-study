package com.ssg.springex.homework.day02;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MemberInfo {

    private String id;
    private String pwd;
    private String gender;
    private List<String> hobbies;
    private Date joinDate;
}
