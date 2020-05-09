package ru.dilmar.configurSecurety;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.dilmar.entity.AuthGroup;
import ru.dilmar.entity.Customer;
import ru.dilmar.service.AuthGroupServise;
import ru.dilmar.service.CustomerServise;

import java.util.List;

@Service
public class AdapterCustomerService implements UserDetailsService {

    @Autowired
    CustomerServise customerServise;
    @Autowired
    AuthGroupServise authGroupServise;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerServise.getCustomer(s);
        if (customer == null) {
            throw new UsernameNotFoundException("cannot find user " + s);
        }
        List<AuthGroup> authGroupList=authGroupServise.getListAuthGroupByName(s);

        return new AdapterCustomerDetails(customer,authGroupList);
    }
}
