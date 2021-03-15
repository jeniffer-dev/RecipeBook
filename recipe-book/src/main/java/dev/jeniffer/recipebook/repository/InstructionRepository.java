package dev.jeniffer.recipebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.jeniffer.recipebook.model.Instruction;

import java.util.List;

@Repository
public interface InstructionRepository  extends JpaRepository<Instruction, Long>{
	List<Instruction> findByRecipeId(Long RecipeId);
	List<Instruction> findByIdAndRecipeId(Long id, Long reecipeId);
}
