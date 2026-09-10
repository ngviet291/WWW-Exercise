package com.ngviet291.nguyentranquocviet_23660721_bai01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequest {
    String username;
    String password;
}
