package ru.dilmar.configurSecurety;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.dilmar.entity.AuthGroup;
import ru.dilmar.entity.Customer;

import java.util.*;

public class AdapterUserDetails implements UserDetails{

    Customer customer;
    List<AuthGroup> authGroupList;

    public AdapterUserDetails(Customer customer, List<AuthGroup> authGroupList) {
        super();
        this.customer = customer;
        this.authGroupList=authGroupList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthoritySet=new HashSet<>();
        if(authGroupList==null){
            return Collections.emptySet();
        }
        for (AuthGroup authGroup : authGroupList) {
            grantedAuthoritySet.add(new SimpleGrantedAuthority(authGroup.getAuthgroup()));
        }
       return grantedAuthoritySet;
        //return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {        return customer.getPassword();    }

    @Override
    public String getUsername()  {      return customer.getName();        }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {      return customer.isEnabled();    }
}
