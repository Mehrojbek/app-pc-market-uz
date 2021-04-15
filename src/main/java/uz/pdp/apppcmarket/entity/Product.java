package uz.pdp.apppcmarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "name should not be null")
    private String name;

    private String description;

    @NotNull(message = "price should not be null")
    private Double price;

    @NotNull(message = "category should not be null")
    @ManyToOne(optional = false)
    private Category category;


}
