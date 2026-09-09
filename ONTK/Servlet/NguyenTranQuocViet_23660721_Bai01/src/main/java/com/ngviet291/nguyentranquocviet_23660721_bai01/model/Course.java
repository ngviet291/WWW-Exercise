package com.ngviet291.nguyentranquocviet_23660721_bai01.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Course implements Serializable {
    private int id;                 // mã khóa học, tự sinh tăng dần
    private String courseName;      // tên khóa học
    private String instructor;      // tên giảng viên
    private String instructorEmail; // email giảng viên (không bắt buộc)
    private String category;        // danh mục: Lập trình / Thiết kế / Marketing / Ngoại ngữ
    private String level;           // trình độ: Cơ bản / Trung cấp / Nâng cao
    private double price;           // học phí (VNĐ)
    private int duration;           // thời lượng khóa học (giờ)
    private String startDate;       // ngày khai giảng, định dạng yyyy-MM-dd
    private boolean featured;       // khóa học nổi bật (checkbox)

    // constructor, getter, setter tự bổ sung
}
