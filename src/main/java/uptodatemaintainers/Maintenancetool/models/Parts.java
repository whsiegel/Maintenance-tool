package uptodatemaintainers.Maintenancetool.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Parts {
    
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private String partNumber;

    @ManyToOne
    private Asset asset;

    public Parts() {}

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
