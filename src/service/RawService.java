package service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import repository.RawRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class RawService {
    private final RawRepository rawRepository;
}
