package com.realovka.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries(@NamedQuery(name = "byName", query = "select p from Product p where name=:name"))
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    @Column(name = "cold_storage")
    private Boolean coldStorage;

    public Product(String name) {
        this.name = name;
    }

    public Product(Boolean coldStorage) {
        this.coldStorage = coldStorage;
    }
}
