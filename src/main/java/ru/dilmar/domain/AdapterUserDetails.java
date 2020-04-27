package ru.dilmar.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class AdapterUserDetails  implements UserDetails{

    User user;
    List<AuthGroup> authGroupList;

    public AdapterUserDetails(User user,List<AuthGroup> authGroupList) {
        super();
        this.user = user;
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
    public String getPassword() {

        return user.getPassword();
    }

    @Override
    public String getUsername()
    {
        return user.getUsername();
    }

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
    public boolean isEnabled() {
        return user.isEnabled();
    }
}
