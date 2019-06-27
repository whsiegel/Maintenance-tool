package uptodatemaintainers.Maintenancetool.models.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uptodatemaintainers.Maintenancetool.models.Department;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface DepartmentDao extends CrudRepository<Department, Integer> {
    public Department getByName(String name);

}
