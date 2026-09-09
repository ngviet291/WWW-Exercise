package com.ngviet291.nguyentranquocviet_23660721_bai01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {
    private String username;
    private String password;
    private String role;   // "ADMIN" hoặc "USER"

    // constructor, getter, setter tự bổ sung
}
