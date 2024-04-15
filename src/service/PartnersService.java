package service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import repository.PartnersRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class PartnersService {
    private final PartnersRepository partnersRepository;
}
