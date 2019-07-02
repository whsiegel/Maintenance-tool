package uptodatemaintainers.Maintenancetool.models.Data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uptodatemaintainers.Maintenancetool.models.MyGrantAuthority;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MyGrantAuthorityRepository extends CrudRepository<MyGrantAuthority, Integer> {
    public MyGrantAuthority getByRole(String role);
}