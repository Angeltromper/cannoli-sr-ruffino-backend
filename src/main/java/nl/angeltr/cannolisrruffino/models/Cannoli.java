package nl.angeltr.cannolisrruffino.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.List;

@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Table(name = "cannolis")
public class Cannoli {

    //  Een entiteit moet een primary key bevatten(id)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="product_id")
    private Long id;

    // Variable declaraties
    @Column(name = "cannoli_name",
            length = 1000)
    private String cannoliName;

    @Column(name = "cannoli_type")
    private String cannoliType;

    @Column(name = "cannoli_description",
            length = 1000)
    private String description;

    @Column( name = "cannoli_ingredients",
           length = 1000)
    private String ingredients;

    @Column(name = "cannoli_flavour",
            length = 1000)
    private String flavour;

    @Column(name = "cannoli_calories",
            length = 1000)
    private String calories;

    @Column(name = "username")
    private String username;

    @Column(name = "userCountry")
    private String userCountry;

    @Column(name = "cannoli_weight")
    private Double weight;

    @Column(name = "cannoli_price")
    private double price;

    // Booleans

    @Column(name = "cannoli_glutenFree")
    private boolean glutenFree;

    @Column(name = "vegan")
    private boolean vegan;

    @OneToOne
    private FileUploadResponse image;

    @OneToMany(
            targetEntity = Ingredients.class,
            mappedBy = "cannoli",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("cannoli")
    private List<Ingredient> ingredient = new ArrayList<>();

    @OneToMany(
            targetEntity = Direction.class,
            mappedBy= "cannoli",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("cannoli")
    private List<Direction> direction = new ArrayList<>();

    @OneToMany(
            targetEntity = Review.class,
            mappedBy= "cannoli",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("cannoli")
    private List<Review>reviews;
    )

    // Alle variable getters
    public Long getId() { return id; }



    public String getCannoliName() { return cannoliName; }

    public String getDescription() { return description; }

    public String getIngredients() { return ingredients; }

    public String getGlutenFree() { return glutenFree; }

    public String getFlavour() { return flavour; }

    public String getCalories() { return calories; }

    public Double getWeight() { return weight; }

    public Double getPrice() { return price; }

    public String getLinkToFranchise() { return linkToFranchise; }

    public String getLinkToReview() { return linkToReview; }

    public FileUploadResponse getImage() { return image; }



    // Alle variable setters
    public void setId(Long id) { this.id = id; }

    public void setCannoliName (String name) { this.cannoliName = name; }

    public void setDescription (String description) { this.description = description; }

    public void setIngredients (String ingredients) { this.ingredients = ingredients; }

    public void setGlutenFree (String glutenFree) { this.glutenFree = glutenFree; }

    public void setFlavour (String flavour) { this.flavour = flavour; }

    public void setCalories (String calories) { this.calories = calories; }

    public void setWeight(Double weight) { this.weight = weight; }

    public void setPrice(Double price) { this.price = price; }

    public void setLinkToFranchise(String linkToFranchise) { this.linkToFranchise = linkToFranchise; }

    public void setLinkToReview(String linkToReview) { this.linkToReview = linkToReview; }

    public void setUsername (String username) { this.userName = userName; }

    public void setImage (FileUploadResponse image) { this.image = image; }

}

