package analyzer.services;

import java.util.List;

import analyzer.domain.models.Base;
import analyzer.repos.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl implements BaseService {

    private final BaseRepository baseRepository;

    @Autowired
    public BaseServiceImpl(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public void addBase(Base base) {
        baseRepository.save(base);
    }

    @Override
    public List<Base> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public Base save(Base base) {
        return null;
    }
}
