package dev.jeniffer.recipebook.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.jeniffer.recipebook.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
