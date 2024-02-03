package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
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
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

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

        if (partRepository.count() == 0) {

            InhousePart part1 = new InhousePart();
            part1.setName("Wooden Planks");
            part1.setPrice(15.00);
            part1.setInv(10);
            part1.setMinInv(1);
            part1.setMaxInv(100);
            partRepository.save(part1);

            InhousePart part2 = new InhousePart();
            part2.setName("Metal Pipes and Fittings");
            part2.setPrice(20.00);
            part2.setInv(10);
            part2.setMinInv(1);
            part2.setMaxInv(100);
            partRepository.save(part2);

            InhousePart part3 = new InhousePart();
            part3.setName("Glass Tops");
            part3.setPrice(25.00);
            part3.setInv(10);
            part3.setMinInv(1);
            part3.setMaxInv(100);
            partRepository.save(part3);

            InhousePart part4 = new InhousePart();
            part4.setName("Paint");
            part4.setPrice(5.00);
            part4.setInv(10);
            part4.setMinInv(1);
            part4.setMaxInv(100);
            partRepository.save(part4);

            InhousePart part5 = new InhousePart();
            part5.setName("Legs");
            part5.setPrice(10.00);
            part5.setInv(10);
            part5.setMinInv(1);
            part5.setMaxInv(100);
            partRepository.save(part5);
        }
        //else {
            //partRepository.deleteAll();
        //}

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        if (productRepository.count() == 0) {
            Product product1 = new Product("Reclaimed Wood Coffee Table", 75.00, 15);
            Product product2 = new Product("Industrial Pipe Table", 65.00, 15);
            Product product3 = new Product("Glass Top Wooden Table", 100.00, 15);
            Product product4 = new Product("Nested Coffee Tables Set", 115.00, 15);
            Product product5 = new Product("Upcycled Pallet Table", 55.00, 15);

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            productRepository.save(product4);
            productRepository.save(product5);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
