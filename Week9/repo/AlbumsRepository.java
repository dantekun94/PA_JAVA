package repo;

import entity.Albums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlbumsRepository extends JpaRepository<Albums, Integer>, JpaSpecificationExecutor<Albums> {

}