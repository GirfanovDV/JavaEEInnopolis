package ru.inno.consultation.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inno.consultation.model.Product;
import ru.inno.consultation.model.ProductRequest;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private static final Map<Long, Product> repository = new HashMap<>();
    private static final AtomicLong counter = new AtomicLong();

    @PostConstruct
    public void init() {
        addProductsToRepository();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return repository.containsKey(id)
                ? ResponseEntity.ok(repository.get(id))
                : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        var response = repository.values().stream()
                .sorted(Comparator.comparing(Product::getId))
                .toList();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest request) {
        var id = counter.incrementAndGet();
        Product product = new Product();
        product.setId(id);
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        repository.put(id, product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request) {
        if (repository.containsKey(id)) {
            var product = repository.get(id);
            if (request.getName() != null) {
                product.setName(request.getName());
            }
            if (request.getPrice() != null) {
                product.setPrice(request.getPrice());
            }
            repository.put(id, product);
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        repository.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private static void addProductsToRepository() {
        var id = counter.incrementAndGet();
        repository.put(id, new Product(id, "Молоко", new BigDecimal(70)));
        id = counter.incrementAndGet();
        repository.put(id, new Product(id, "Хлеб", new BigDecimal(45)));
        id = counter.incrementAndGet();
        repository.put(id, new Product(id, "Масло", new BigDecimal(50)));
    }

}
