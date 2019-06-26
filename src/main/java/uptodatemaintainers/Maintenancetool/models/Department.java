package uptodatemaintainers.Maintenancetool.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Department {

    @Id
    @GeneratedValue
    int id;

    @NotEmpty
    @NotNull
    String name;

    @OneToMany
    @JoinColumn(name = "department_id")

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
