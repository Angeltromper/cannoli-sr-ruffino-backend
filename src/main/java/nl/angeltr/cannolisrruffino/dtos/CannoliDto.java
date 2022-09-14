package nl.angeltr.cannolisrruffino.dtos;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.angeltr.cannolisrruffino.models.Cannoli;
import nl.angeltr.cannolisrruffino.models.FileUploadResponse;
import nl.angeltr.cannolisrruffino.models.GlutenFreeCannoli;
import nl.angeltr.cannolisrruffino.models.User;


@Getter @Setter
public class CannoliDto {

    public Long id;
    public String cannoliName;
    public String cannoliType;
    public String description;
    public String ingredients;
    public String flavour;
    public String calories;
    public double weight;
    public double price;
    public boolean gluten;
    public boolean vegan;
    public String linkToFranchise;
    public String linkToReview;

    @JsonSerialize
    FileUploadResponse image;

    public static CannoliDto fromCannoli(Cannoli cannoli) {

        var dto = new CannoliDto();

        dto.id = cannoli.getId();

        dto.cannoliName = cannoli.getCannoliName();

        dto.cannoliType = cannoli.getCannoliType();

        dto.description = cannoli.getDescription();

        dto.ingredients = cannoli.getIngredients();

        dto.flavour = cannoli.getFlavour();

        dto.weight = cannoli.getWeight();

        dto.price = cannoli.getPrice();

        dto.glutenFree = cannoli.getGlutenFree();

        dto.vegan = cannoli.getVegan();

        dto.linkToFranchise = cannoli.getLinkToFranchise();

        dto.linkToReview = cannoli.getLinkToReview();

        dto.image = cannoli.getImage();

        return dto;
    }


//   public Long getId() { return id; }
//   public String getCannoliName() { return cannoliName; }
//   public String getCannoliType() { return cannoliType; }
//   public String getDescription() { return description; }
//   public String getIngredients() { return ingredients; }
//   public String getFlavour() { return flavour; }
//   public String getCalories() { return calories; }
//   public double getWeight() { return weight; }
//   public double getPrice() { return price; }
//   public boolean getGluten() { return gluten; }
//   public boolean getVegan() { return vegan; }
//   public String getLinkToFranchise() { return linkToFranchise; }
//   public String getLinkToReview() { return linkToReview; }



//   public void setId(Long id) { this.id = id; }
//   public void setCannoliName (String cannoliName) { this.cannoliName = cannoliName; }
//   public void setCannoliType (String cannoliType) { this.cannoliType = cannoliType; }
//   public void setDescription (String description) { this.description = description; }
//   public void setIngredients (String ingredients) { this.ingredients = ingredients; }
//   public void setFlavour (String flavour) { this.flavour = flavour; }
//   public void setCalories (String calories) { this.calories = calories; }
//   public void setWeight( Double weight ) { this.weight = weight; }
//   public void setPrice(Double price) { this.price = price; }
//   public void setLinkToFranchise(String linkToFranchise) { this.linkToFranchise = linkToFranchise; }
//   public void setLinkToReview(String linkToReview) { this.linkToReview = linkToReview; }
}

