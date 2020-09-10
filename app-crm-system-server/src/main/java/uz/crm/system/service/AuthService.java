package uz.crm.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqRegister;
import uz.crm.system.repository.UserRepository;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

//    public ApiResponse register(ReqRegister request) {
//        if (request.getPassword().equals(request.getPrePassword())
//                && !request.getPhoneNumber().isEmpty()
//        ) {
//            boolean exist = userRepository.existsByPhoneNumber(request.getPhoneNumber());
//            if (!exist) {
//
//                User user = new User(
//                        request.getFirstName(),
//                        request.getLastName(),
//                        request.
//                        );
//
//            }
//        }
//    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
