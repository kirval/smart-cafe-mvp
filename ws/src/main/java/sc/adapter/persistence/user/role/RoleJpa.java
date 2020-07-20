package sc.adapter.persistence.user.role;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class RoleJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_generator")
    @SequenceGenerator(name="role_id_generator", sequenceName = "role_id_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "value", nullable = false, unique = true)
    private String value;

}
