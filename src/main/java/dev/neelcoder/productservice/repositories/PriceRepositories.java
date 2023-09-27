package dev.neelcoder.productservice.repositories;

import dev.neelcoder.productservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriceRepositories extends JpaRepository<Price, UUID> {

}
