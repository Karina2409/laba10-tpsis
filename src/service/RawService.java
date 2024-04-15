package service;

import entity.Raw;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import repository.RawRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RawService {
    private final RawRepository rawRepository;

    public List<Raw> listRaw() {
        return rawRepository.findAll();
    }

    public Raw getRawByName(String name){
        return rawRepository.findRawByName(name);
    }

    public void createRaw(Raw raw) { rawRepository.createRaw(raw); }

    public void deleteRaw(Long id){
        rawRepository.deleteById(id);
    }
}
