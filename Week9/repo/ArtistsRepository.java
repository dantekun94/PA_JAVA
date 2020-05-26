package repo;

import entity.Artists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArtistsRepository extends JpaRepository<Artists, Integer>, JpaSpecificationExecutor<Artists> {

}