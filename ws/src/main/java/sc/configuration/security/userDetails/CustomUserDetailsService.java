package sc.configuration.security.userDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import sc.adapter.persistence.user.UserRepository;

import static org.springframework.security.config.BeanIds.USER_DETAILS_SERVICE;

@Component(USER_DETAILS_SERVICE)
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;
    private final CustomUserDetailsMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return mapper.toCustomUserDetails(repository.findOne(Specification.where((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("phone"), username)))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with phone: " + username)));
    }

}
