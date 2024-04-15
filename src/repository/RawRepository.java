package repository;

import entity.Product;
import entity.Raw;

@Repository
public class RawRepository extends JpaRepository<Raw, Long> {

    Raw findAll(String name);

    Raw findRawByName(String name);

    void createRaw(Raw raw);

    void deleteById(Long id);
}
