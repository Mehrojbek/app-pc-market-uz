package uz.pdp.apppcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.apppcmarket.entity.Product;
import uz.pdp.apppcmarket.projection.CustomProduct;


import java.util.*;

@RepositoryRestResource(path = "product",excerptProjection = CustomProduct.class)
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @RestResource(path = "byProperty")
    @Query(value = "select * from product p join characteristics ch on p.id=ch.product_id " +
            "join property pr on ch.id=pr.characteristic_id where pr.name=:name",
            nativeQuery = true)
    List<Product> getAllByProperty(String name);

    @RestResource(path = "byPrice")
    List<Product> findAllByPriceBetween(Double from, Double to);

}
