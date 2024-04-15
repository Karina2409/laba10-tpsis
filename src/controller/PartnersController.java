package controller;

import entity.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import service.PartnersService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PartnersController {
    @Autowired
    private PartnersService partnersService;

    @GetMapping("/partner")
    public List<Partner> getAllPartners(){
        return partnersService.listPartners();
    }

    @GetMapping("/partner/partner-by-name/{name}")
    public Partner getPartnerByLogin(@PathVariable String name) {
        return partnersService.getPartnerByName(name);
    }

    @PostMapping("/partner/add-partner")
    public void addPartner(Partner partner){partnersService.createPartner(partner);}
}
