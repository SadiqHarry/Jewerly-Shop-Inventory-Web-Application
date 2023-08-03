package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0 && partRepository.count() == 0) {

            // Create sample products
            Product product1 = new Product(1, "Diamonds", 9.99, 10);
            Product product2 = new Product(2, "Sapphire", 14.99, 5);
            Product product3 = new Product(3, "Ruby", 19.99, 15);
            Product product4 = new Product(4, "Silver", 24.99, 8);
            Product product5 = new Product(5, "Gold", 29.99, 12);

            // Save the products in the repository
            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            productRepository.save(product4);
            productRepository.save(product5);

            //Create sample parts and save them in the repository
            OutsourcedPart part1 = new OutsourcedPart();
            part1.setName("Gold");
            part1.setPrice(5.99);
            part1.setMinInv(10); // Set the minimum inventory for part1
            part1.setMaxInv(30); // Set the maximum inventory for part1
            part1.validateAndSetInv(20);
            part1.setCompanyName("Company A");
            outsourcedPartRepository.save(part1);

            OutsourcedPart part2 = new OutsourcedPart();
            part2.setName("Silver");
            part2.setPrice(4.99);
            part2.setMinInv(5); // Set the minimum inventory for part2
            part2.setMaxInv(20); // Set the maximum inventory for part2
            part2.validateAndSetInv(15);
            part2.setCompanyName("Company B");
            outsourcedPartRepository.save(part2);

            OutsourcedPart part3 = new OutsourcedPart();
            part3.setName("Diamond");
            part3.setPrice(3.99);
            part3.setMinInv(11); // Set the minimum inventory for part3
            part3.setMaxInv(70); // Set the maximum inventory for part3
            part3.validateAndSetInv(12);
            part3.setCompanyName("Company C");
            outsourcedPartRepository.save(part3);

            OutsourcedPart part4 = new OutsourcedPart();
            part4.setName("Ruby");
            part4.setPrice(2.99);
            part4.setMinInv(19); // Set the minimum inventory for part4
            part4.setMaxInv(40); // Set the maximum inventory for part4
            part4.validateAndSetInv(22);
            part4.setCompanyName("Company D");
            outsourcedPartRepository.save(part4);

            OutsourcedPart part5 = new OutsourcedPart();
            part5.setName("Sapphire");
            part5.setPrice(1.99);
            part5.setMinInv(1); // Set the minimum inventory for part5
            part5.setMaxInv(80); // Set the maximum inventory for part5
            part5.validateAndSetInv(2);
            part5.setCompanyName("Company E");
            outsourcedPartRepository.save(part5);


       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + "" + part.getCompanyName());
            }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

            System.out.println("Started in Bootstrap");
            System.out.println("Number of Products" + productRepository.count());
            System.out.println(productRepository.findAll());
            System.out.println("Number of Parts" + partRepository.count());
            System.out.println(partRepository.findAll());

        }
    }
}
