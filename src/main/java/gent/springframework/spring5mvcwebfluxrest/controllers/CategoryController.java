package gent.springframework.spring5mvcwebfluxrest.controllers;

import gent.springframework.spring5mvcwebfluxrest.domain.Category;
import gent.springframework.spring5mvcwebfluxrest.repositories.CategoryRepository;
import org.reactivestreams.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @GetMapping("/api/v1/categories")
    Flux<Category> list(){
        return categoryRepository.findAll();
    }

    @GetMapping("/api/v1/categories/{id}")
    Mono<Category> getById(@PathVariable String id){
        return categoryRepository.findById(id);
    }


    @PostMapping("/api/v1/categories")
    @ResponseStatus(HttpStatus.CREATED)
    Mono<Void> createCategory(@RequestBody Publisher<Category> categoryStream){
        return categoryRepository.saveAll(categoryStream).then();
    }

    @PutMapping("/api/v1/categories/{id}")
    Mono<Category> updateCategory(@PathVariable String id , @RequestBody Category category){
        category.setId(id);
        return categoryRepository.save(category);
    }

}
