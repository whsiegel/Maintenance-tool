package uptodatemaintainers.Maintenancetool.models.Data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uptodatemaintainers.Maintenancetool.models.Asset;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface AssetDao extends CrudRepository<Asset,Integer> {
    public Asset getByName(String name);

}
