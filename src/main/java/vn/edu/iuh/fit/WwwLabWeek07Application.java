package vn.edu.iuh.fit;

import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.iuh.fit.backend.enums.ProductStatus;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.repositories.ProductRepository;

@SpringBootApplication
public class WwwLabWeek07Application {

    public static void main(String[] args) {
        SpringApplication.run(WwwLabWeek07Application.class, args);
    }
    @Autowired
    private ProductRepository productRepository;
    CommandLineRunner createProductlist(){
        return args -> {
            Faker faker = new Faker();
            Device device = faker.device();
            for (int i = 0; i < 100; i++) {
                Product product = new Product(
                        device.modelName(),faker.lorem().paragraph(10),"price",device.manufacturer(), ProductStatus.ACTIVE
                );
                productRepository.save(product);
            }
        };
    }
    }
