package uptodatemaintainers.Maintenancetool.models.Data;

import org.springframework.data.repository.CrudRepository;
import uptodatemaintainers.Maintenancetool.models.Department;

public interface DepartmentDao extends CrudRepository<Department, Integer> {
}
