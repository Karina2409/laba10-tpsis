package controller;

import entity.Raw;
import org.springframework.beans.factory.annotation.Autowired;
import service.RawService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class RawController {
    @Autowired
    private RawService rawService;

    @GetMapping("/raw")
    public List<Raw> getAllRaw(){
        return rawService.listProduct();
    }

    @GetMapping("/raw")
    public Raw getRawByName(String name) {
        return rawService.getProductByName(name);
    }

    @PostMapping("/raw")
    public void addRaw(Raw raw){
        rawService.createRaw(raw);
    }

    @PostMapping("/raw")
    public void deleteRaw(Long id){
        rawService.deleteRaw(id);
    }
}
