package com.example.learn.fenye;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FenYeTest
 *
 * @author wcy
 * @date 2022/8/23
 */
public class FenYeTest {

    public static void main(String[] args) {
        // List<String> list = new ArrayList<>();
        // for(int i = 0;i < 100;i++){
        //     list.add(String.valueOf(i));
        // }
        // PageModel<String> pagination = PaginationUtil.pagination(list, 10, 2);
        // System.out.println(pagination);

        List<Doctor> list = new ArrayList<>();
        Doctor doctor;
        for (int i = 1; i <= 100; i++) {
            doctor = new Doctor();
            doctor.setDoctorId((long) i);
            doctor.setDoctorName("张三" + i);
            doctor.setDoctorSex("男" + i);
            list.add(doctor);
        }
        List<Doctor> collect = list.stream().filter(doctor1 -> doctor1.getDoctorId() > 20).collect(Collectors.toList());
        PageModel<Doctor> pagination = PaginationUtil.pagination(collect, 10, 1);
        System.out.println(pagination);

    }
}
