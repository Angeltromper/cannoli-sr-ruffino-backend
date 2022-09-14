package nl.angeltr.cannolisrruffino.dtos;


import jdk.jfr.DataAmount;
import nl.angeltr.cannolisrruffino.models.Cannoli;

@Data
public class CannoliInputDto {

    private Long id;

    private String cannoliName;

    private String cannoliType;

    private String description;

    private String ingredients;

    private String flavour;

    private String calories;


    private String userName;

    private String userCountry;

    private Double weight;

    private Double price;

    private Boolean glutenFree;

    private Boolean vegan;


    public Cannoli toCannoli() {

        var cannoli = new Cannoli();

        cannoli.setCannoliName(cannoliName);
        cannoli.setCannoliType(cannoliType);
        cannoli.setDescription(description);
        cannoli.setIngredients(ingredients);
        cannoli.setFlavour(flavour);
        cannoli.setCalories(calories);
        cannoli.setWeight(weight);
        cannoli.setPrice(price);
        cannoli.setGlutenFree(glutenFree);
        cannoli.setVegan(vegan);


    }
}









