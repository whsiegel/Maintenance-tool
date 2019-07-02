package uptodatemaintainers.Maintenancetool.models.Data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uptodatemaintainers.Maintenancetool.models.WorkOrder;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface WorkOrderDao extends CrudRepository<WorkOrder,Integer> {
}
