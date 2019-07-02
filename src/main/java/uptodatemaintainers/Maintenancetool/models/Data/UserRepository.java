package uptodatemaintainers.Maintenancetool.models.Data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uptodatemaintainers.Maintenancetool.models.User;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);

}