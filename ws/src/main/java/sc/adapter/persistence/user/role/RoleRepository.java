package sc.adapter.persistence.user.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import sc.adapter.persistence.user.UserJpa;

@Repository
public interface RoleRepository extends JpaRepository<RoleJpa, Long>,  JpaSpecificationExecutor<RoleJpa> {
}
