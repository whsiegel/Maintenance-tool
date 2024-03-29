package uptodatemaintainers.Maintenancetool.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class WorkOrder {

    @Id
    @GeneratedValue
    private int id;

    @Size(min=5)
    private String Description;

    @OneToMany
    @JoinColumn(name="workOrder_id")

    public int getId() {
        return id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
