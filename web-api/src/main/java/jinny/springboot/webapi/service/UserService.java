package jinny.springboot.webapi.service;

import jinny.springboot.webapi.domain.User;
import jinny.springboot.webapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public List<User> getUsers () {
        return userRepository.findAll();
    }
}
