package dev.neelcoder.productservice.models;

import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String name;

    @OneToMany(mappedBy = "category")
    List<Product> products;
}