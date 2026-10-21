package _3660721_nguyentranquocviet_tuan6_jdbctemplate.service;

import _3660721_nguyentranquocviet_tuan6_jdbctemplate.model.Position;
import _3660721_nguyentranquocviet_tuan6_jdbctemplate.repository.PositionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PositionService {

    private final PositionRepository positionRepo;

    public PositionService(PositionRepository positionRepo) {
        this.positionRepo = positionRepo;
    }

    public List<Position> findAll() { return positionRepo.findAll(); }
}
