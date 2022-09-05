package nl.angeltr.cannolisrruffino.dtos;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import nl.angeltr.cannolisrruffino.models.FileUploadResponse;
import nl.angeltr.cannolisrruffino.models.GlutenFreeCannoli;
import nl.angeltr.cannolisrruffino.models.User;

public class CannoliDto {
    private Long id;
    private String cannoliName;
    private String description;
    private String ingredients;
    private GlutenFreeCannoli glutenFreeCannoli;
    private String flavour;
    private String calories;
    private Double weight;
    private Double price;
    private Boolean availableCannoli;
    private Integer sold;
    private String linkToFranchise;
    private String linkToReview;
    private FileUploadResponse image;

    private User user;


    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCannoliName() { return cannoliName; }

    public void setCannoliName (String cannoliName) { this.cannoliName = cannoliName; }

    public String getDescription() { return description; }

    public void setDescription (String description) { this.description = description; }

    public String getIngredients() { return ingredients; }

    public void setIngredients (String ingredients) { this.ingredients = ingredients; }

    public GlutenFreeCannoli getGlutenFreeCannoli() { return glutenFreeCannoli; }

    public void setGlutenFreeCannoli (GlutenFreeCannoli glutenFreeCannoli) { this.glutenFreeCannoli = glutenFreeCannoli; }

    public String getFlavour() { return flavour; }
    public void setFlavour (String flavour) { this.flavour = flavour; }

    public String getCalories() { return calories; }
    public void setCalories (String calories) { this.calories = calories; }

    public Double getWeight() { return weight; }

    public void setWeight( Double weight ) { this.weight = weight; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public Boolean getAvailAbleCannoli() { return availableCannoli; }

    public void setAvailAbleCannoli ( Boolean availableCannoli) { this.availableCannoli = availableCannoli; }

    public Integer getSold() { return sold; }

    public void setSold(Integer sold) { this.sold = sold; }

    public String getLinkToFranchise() { return linkToFranchise; }

    public void setLinkToFranchise(String linkToFranchise) { this.linkToFranchise = linkToFranchise; }

    public String getLinkToReview() { return linkToReview; }

    public void setLinkToReview(String linkToReview) { this.linkToReview = linkToReview; }

    public User getUser() { return user; }

    public void setUser (User user) { this.user = user; }

    public FileUploadResponse getImage() { return image; }

    public void setImage (FileUploadResponse image) { this.image = image; }
}

