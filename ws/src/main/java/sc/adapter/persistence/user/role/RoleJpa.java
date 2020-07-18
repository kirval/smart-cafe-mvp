package sc.adapter.persistence.user.role;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleJpa {

    @Id
    Long id;

}
