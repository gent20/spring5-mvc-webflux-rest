package gent.springframework.spring5mvcwebfluxrest.bootstrap;

import gent.springframework.spring5mvcwebfluxrest.domain.Category;
import gent.springframework.spring5mvcwebfluxrest.domain.Vendor;
import gent.springframework.spring5mvcwebfluxrest.repositories.CategoryRepository;
import gent.springframework.spring5mvcwebfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count().block() == 0) {

            System.out.println("LOADING DATA STARTUP ###");

            categoryRepository.save(Category.builder().description("Fruits").build()).block();
            categoryRepository.save(Category.builder().description("Nuts").build()).block();
            categoryRepository.save(Category.builder().description("Breads").build()).block();
            categoryRepository.save(Category.builder().description("Meats").build()).block();
            categoryRepository.save(Category.builder().description("Eggs").build()).block();

            System.out.println("Loaded categories : " + categoryRepository.count().block());


            vendorRepository.save(Vendor.builder()
                    .firstname("Gent").lastname("Kastrati").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstname("Ramiz").lastname("Kastrati").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstname("Nagjije").lastname("Kastrati").build()).block();

            System.out.println("Loaded vendors : " + vendorRepository.count().block());

        }
    }
}
