package service;

import entity.Partner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import repository.PartnersRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PartnersService {
    private final PartnersRepository partnersRepository;

    public List<Partner> listPartners() {
        return partnersRepository.findAll();
    }

    public Partner getPartnerByName(String name){
        return partnersRepository.findPartnerByName(name);
    }

    public void createPartner(Partner partner) { partnersRepository.createPartner(partner); }
}
