package com.ngviet291._3660721_nguyentranquocviet_jdbc_library.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "books")
public class Book {
    @Id
    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @Min(0) @Max(1000000000)
    private double price;
    @Column("publisher_id")
    private Integer publisherId;
}