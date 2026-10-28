package com.ngviet291._3660721_nguyentranquocviet_jdbc1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "positions")
public class Position {
    @Id
    private Integer id;
    private String title;
}
