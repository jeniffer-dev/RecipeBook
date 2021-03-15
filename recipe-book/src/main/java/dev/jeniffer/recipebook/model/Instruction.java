package dev.jeniffer.recipebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "instruction")
public class Instruction {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(name = "step")
	private int step;
	
	@Column(name = "step_description")
	private  String stepDescription;
	
	@ManyToOne
    @JoinColumn(name="recipe_id")
    private Recipe recipe;

	public Instruction() {
		super();
	}

	public Instruction(int step, String stepDescription) {
		super();
		this.step = step;
		this.stepDescription = stepDescription;
	}
	
	@JsonBackReference
	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public String getStepDescription() {
		return stepDescription;
	}

	public void setStepDescription(String stepDescription) {
		this.stepDescription = stepDescription;
	}


	
	
	
	
}