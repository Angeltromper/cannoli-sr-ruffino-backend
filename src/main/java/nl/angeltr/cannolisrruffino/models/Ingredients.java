package nl.angeltr.cannolisrruffino.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.DataAmount;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
@Table(name= "ingredients")
public class Ingredients {

    @Id
    @GenerateValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ingredientName;

    @ManyToOne
    @JoinColumn(name = "cannoli_id" , nullable = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cannoli cannoli;

    public long getId() { return id; }
    public void setId(Long id) { this.id = id }
    public String getName() { return ingredientName; }
    public void setName(String name) { this.ingredientName = name; }
    public Cannoli getCannoli() { return cannoli; }
    public void setCannoli (Cannoli cannoli) { this.cannoli =cannoli; }
}
