package _3660721_nguyentranquocviet_tuan6_mongodb.service;

import _3660721_nguyentranquocviet_tuan6_mongodb.model.Position;
import _3660721_nguyentranquocviet_tuan6_mongodb.repo.PositionRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PositionService {

    private final PositionRepository positionRepo;

    public PositionService(PositionRepository positionRepo) {
        this.positionRepo = positionRepo;
    }

    public List<Position> findAll() { return positionRepo.findAll(Sort.by("id")); }

    public Map<Integer, String> titleById() {
        Map<Integer, String> map = new HashMap<>();
        for (Position p : findAll()) map.put(p.id(), p.title());
        return map;
    }
}
