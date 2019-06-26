package uptodatemaintainers.Maintenancetool.models.Data;

import org.springframework.data.repository.CrudRepository;
import uptodatemaintainers.Maintenancetool.models.Asset;

public interface AssetDao extends CrudRepository<Asset,Integer> {
    public Asset getByName(String name);

}
