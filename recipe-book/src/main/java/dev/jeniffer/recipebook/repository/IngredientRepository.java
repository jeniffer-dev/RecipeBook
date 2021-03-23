package dev.jeniffer.recipebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import dev.jeniffer.recipebook.model.Ingredient;
import dev.jeniffer.recipebook.model.Instruction;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
	Ingredient findByName(String name);
}
