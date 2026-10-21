package _3660721_nguyentranquocviet_tuan6_jpa.service;

import _3660721_nguyentranquocviet_tuan6_jpa.entity.Position;
import _3660721_nguyentranquocviet_tuan6_jpa.repository.PositionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PositionService {

    private final PositionRepository positionRepo;

    public PositionService(PositionRepository positionRepo) {
        this.positionRepo = positionRepo;
    }

    public List<Position> findAll() { return positionRepo.findAll(); }

    public Optional<Position> findById(Integer id) { return positionRepo.findById(id); }

    public Position getReference(Integer id) { return positionRepo.getReferenceById(id); }
}
