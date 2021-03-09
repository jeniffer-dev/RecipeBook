package dev.jeniffer.recipebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "image")
	private String imageUrl;
	
	@Column(name = "cook_time")
	private int cookTime;
	
	@Column(name = "preparation_time")
	private int preparationTime;
	
	
	public Recipe() {
		super();
	}

	public Recipe(String name, String imageUrl, int cookTime, int preparationTime) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.cookTime = cookTime;
		this.preparationTime = preparationTime;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getCookTime() {
		return cookTime;
	}
	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}
	public int getPreparationTime() {
		return preparationTime;
	}
	public void setPreparationTime(int preparationTime) {
		this.preparationTime = preparationTime;
	}
	
	

}
