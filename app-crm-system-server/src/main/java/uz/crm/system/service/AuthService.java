package uz.crm.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.entity.enums.RoleNameEnum;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqRegister;
import uz.crm.system.repository.UserRepository;
import uz.crm.system.repository.rest.PostRepository;
import uz.crm.system.repository.rest.RestaurantRepository;
import uz.crm.system.repository.rest.RoleRepository;

import java.util.Collections;
import java.util.UUID;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    PostRepository postRepository;
    @Autowired
    RoleRepository roleRepository;

    public ApiResponse register(ReqRegister request) {
        if (request.getPassword().equals(request.getPrePassword())
                && !request.getPhoneNumber().isEmpty()
        ) {
            boolean exist = userRepository.existsByPhoneNumber(request.getPhoneNumber());
            if (!exist) {

                User user = new User();
                user.setFullName(request.getFullName());
                user.setRestaurant(restaurantRepository.findById(request.getRestaurantId())
                        .orElseThrow(() -> new ResourceNotFoundException("getRestaurantId")));
                user.setPhoneNumber(request.getPhoneNumber());
                user.setPassword(passwordEncoder.encode(request.getPassword()));
                user.setPost(postRepository.findById(request.getPostId())
                        .orElseThrow(() -> new ResourceNotFoundException("getPostId")));
                user.setPinCode(request.getPinCode());
                user.setRoles(Collections.singletonList(roleRepository.findByName(RoleNameEnum.ROLE_USER)));
                userRepository.save(user);
                return new ApiResponse("Регистрация успешно завершено.", true);
            }
            return new ApiResponse("Ползователь с таким номером уже существует.", false);
        }
        return new ApiResponse("Пароли не идентичны.", false);
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new UsernameNotFoundException("phoneNumber"));
    }

    public User loadUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Id"));
    }
}
