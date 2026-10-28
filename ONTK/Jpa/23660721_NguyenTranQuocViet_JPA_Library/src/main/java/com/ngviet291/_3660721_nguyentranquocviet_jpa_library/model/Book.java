package com.ngviet291._3660721_nguyentranquocviet_jpa_library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @Min(0) @Max(1000000000)
    private double price;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
