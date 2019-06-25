package uptodatemaintainers.Maintenancetool.models;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Asset {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    @NotNull
    @Column(unique = true)
    private String name;

    @ManyToOne
    private Department department;

    @OneToMany
    @JoinColumn(name = "asset_id")
    private List<Parts> parts = new ArrayList<>();


    public Asset() {
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Parts> getParts() {
        return parts;
    }

    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }
}
