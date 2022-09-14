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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cannoli_id")
    private Long id;

    // Variable declaraties
    @Column(name = "cannoli_name",
            length = 1000)
    private String cannoliName;
    @Column(name = "cannoli_type")
    private String cannoliType;

    @Column(name = "description",
            length = 1000)
    private String description;
    @Column(name = "ingredients",
            length = 1000)
    private String ingredients;
    @Column(name = "flavour")
    private String flavour;
    @Column(name = "calories")
    private String calories;
    @Column(name = "weight")
    private int weight;
    @Column(name = "price")
    private double price;
    @Column(name = "glutenFree")
    private boolean glutenFree;

    @Column(name = "vegan")
    private boolean vegan;
    @Column(name = "franchise")
    private String linkToFranchise;

    @Column(name = "review")
    private String linkToReview;


    @OneToOne
    FileUploadResponse image;


    // Extending arrays
    @OneToMany(
            targetEntity = Ingredients.class,
            mappedBy = "cannoli",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("cannoli")
    private List<Ingredients> ingredient = new ArrayList<>();

    @OneToMany(
            targetEntity = Direction.class,
            mappedBy = "cannoli",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("cannoli")
    private List<Direction> directions = new ArrayList<>();

    @OneToMany(
            targetEntity = Review.class,
            mappedBy = "cannoli",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("cannoli")
    private List<Review> reviews;



    // Alle variable getters
    public Long getId() { return id; }
    public String getCannoliName() { return cannoliName; }
    public String getCannoliType() { return cannoliType; }
    public String getDescription() { return description; }
    public String getIngredients() { return ingredients; }
    public String getFlavour() { return flavour; }
    public String getCalories() { return calories; }
    public int getWeight() { return weight; }
    public double getPrice() { return price; }
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

    public void setWeight(int weight) { this.weight = weight; }

    public void setPrice(double price) { this.price = price; }

    public void setLinkToFranchise(String linkToFranchise) { this.linkToFranchise = linkToFranchise; }

    public void setImage (FileUploadResponse image) { this.image = image; }

    public void setCannoliType(String test) { this.cannoliType = cannoliType; }


    }
}


