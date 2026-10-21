package _3660721_nguyentranquocviet_tuan6_jdbc.service;

import _3660721_nguyentranquocviet_tuan6_jdbc.model.Position;
import _3660721_nguyentranquocviet_tuan6_jdbc.repo.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private final PositionRepository positionRepo;

    public PositionService(PositionRepository positionRepo) {
        this.positionRepo = positionRepo;
    }

    public List<Position> findAll() { return positionRepo.findAll(); }
}
