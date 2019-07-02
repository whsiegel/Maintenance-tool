package uptodatemaintainers.Maintenancetool.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Asset {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    @NotNull
    private String name;

    @ManyToOne
    private Department department;

    @ManyToOne
    private WorkOrder workOrder;

    public Asset() {
    }

    public int getId() {
        return id;
    }

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
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

}
