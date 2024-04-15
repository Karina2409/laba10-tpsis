package repository;

import entity.Partner;

@Repository
public class PartnersRepository extends JpaRepository<Partner, Long> {
    Partner findAll(String login);

    Partner findPartnerByName(String name);

    void createPartner(Partner partner);
}
