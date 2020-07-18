package sc.adapter.persistence.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserJpa {

    @Id
    Long id;

}
