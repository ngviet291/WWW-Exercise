package com.ngviet291.nguyentranquocviet_23660721_bai2.service;

import com.ngviet291.nguyentranquocviet_23660721_bai2.model.GradeReport;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Getter
@Setter
public class GradeService {
    private List<GradeReport> reports = new ArrayList<>(List.of(
            new GradeReport("1","Viet","Học kỳ 1",List.of("Lập trình java","Cơ sở dữ liệu")),
            new GradeReport("2","QuocViet","Học kỳ 2",List.of("Cấu trúc dữ liệu"))
    ));
    public List<GradeReport> getAll(){
        return  reports;
    }
    public GradeReport getReportById(String id){
        for(GradeReport g: reports){
            if(g.getStudentId().equalsIgnoreCase(id)){
                return  g;
            }
        }
        return null;
    }
    public boolean addReport(GradeReport gradeReport){
        return reports.add(gradeReport);
    }
}
