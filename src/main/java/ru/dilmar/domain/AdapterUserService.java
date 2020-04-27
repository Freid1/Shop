package ru.dilmar.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.dilmar.repository.AuthGroupRepository;
import ru.dilmar.repository.UsersRepository;

import java.util.List;

@Service
public class AdapterUserService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    AuthGroupRepository authGroupRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("cannot find user " + s);
        }
        List<AuthGroup> authGroupList=authGroupRepository.findByUsername(s);

        return new AdapterUserDetails(user,authGroupList);
    }
}
