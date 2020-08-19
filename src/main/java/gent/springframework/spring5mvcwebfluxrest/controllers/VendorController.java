package gent.springframework.spring5mvcwebfluxrest.controllers;


import gent.springframework.spring5mvcwebfluxrest.domain.Vendor;
import gent.springframework.spring5mvcwebfluxrest.repositories.VendorRepository;
import org.reactivestreams.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VendorController {

    private final VendorRepository vendorRepository;

    public VendorController(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @GetMapping("/api/v1/vendors")
    Flux<Vendor> listVendors(){
         return vendorRepository.findAll();
    }

    @GetMapping("/api/v1/vendors/{id}")
    Mono<Vendor> getVendorById(@PathVariable String id){
        return  vendorRepository.findById(id);
    }

    @PostMapping("/api/v1/vendors")
    @ResponseStatus(HttpStatus.CREATED)
    Mono<Void> createVendor(@RequestBody Publisher<Vendor> vendorStream){
        return vendorRepository.saveAll(vendorStream).then();
    }

    @PutMapping("/api/v1/vendors/{id}")
    Mono<Vendor> createOrUpdateVendor(@PathVariable String id , @RequestBody  Vendor vendor){
        vendor.setId(id);
        return  vendorRepository.save(vendor);

    }
}
