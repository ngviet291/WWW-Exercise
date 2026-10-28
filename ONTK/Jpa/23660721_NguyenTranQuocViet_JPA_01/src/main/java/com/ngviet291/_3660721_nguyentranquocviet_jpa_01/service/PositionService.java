package com.ngviet291._3660721_nguyentranquocviet_jpa_01.service;

import com.ngviet291._3660721_nguyentranquocviet_jpa_01.model.Position;
import com.ngviet291._3660721_nguyentranquocviet_jpa_01.repo.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionService {
    private PositionRepository positionRepository;
    public Position findById(Integer id){
        return positionRepository.findById(id).orElse(null);
    }

}
