package com.apple.PortfolioManager.service;
import com.apple.PortfolioManager.model.UserApp;
import com.apple.PortfolioManager.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, username)));
    }

    public String registerUser(UserApp user){
       /* boolean userExists = userRepo
                .findByUsername(user.getUsername())
                .isPresent();

        if (userExists){
            throw new IllegalStateException(("email taken"));
        } */

        //String encdodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        //user.setPassword(encdodedPassword);

        userRepo.save(user);


        return "it works";
    }


}

