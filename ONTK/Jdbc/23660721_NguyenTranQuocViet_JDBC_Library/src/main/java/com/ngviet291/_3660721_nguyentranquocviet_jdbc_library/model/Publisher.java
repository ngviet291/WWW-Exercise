package com.ngviet291._3660721_nguyentranquocviet_jdbc_library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "publishers")
public class Publisher {
    @Id
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
}

