package nl.angeltr.cannolisrruffino.service;

import nl.angeltr.cannolisrruffino.exceptions.RecordNotFoundException;
import nl.angeltr.cannolisrruffino.exceptions.UsernameAlreadyExistException;
import nl.angeltr.cannolisrruffino.models.Authority;
import nl.angeltr.cannolisrruffino.models.User;
import nl.angeltr.cannolisrruffino.repositories.CannoliRepository;
import nl.angeltr.cannolisrruffino.repositories.FileUploadRepository;
import nl.angeltr.cannolisrruffino.repositories.UserRepository;
import nl.angeltr.cannolisrruffino.utils.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileUploadRepository fileUploadRepository;

    @Autowired
    private CannoliRepository cannoliRepository;

    @Autowired
    private CannoliServiceImpl cannoliService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Collection<User> getUsers() { return userRepository.findAll(); }

    @Override
    public Optional<User> getUser(String username) { return userRepository.findById(username); }

    @Override
    public Optional<User> getUser() {
        return Optional.empty();
    }

    public boolean userExists(String username) { return userRepository.existsById(username); }

    public String createUser(User user) {

        if(userExists(user.getUsername())) {
            throw new UsernameAlreadyExistException("Username is al in gebruik!");
        }
        String randomString = RandomStringGenerator.generateAlphaNumeric();
        user.setEmail(user.getEmail());
        user.setApikey(randomString);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getAuthorities().clear();
        user.addAuthority(new Authority(user.getUsername(), "ROLE_USER"));
        user.setId(long) ((getUsers().size()) + 1));

        user.setPerson(personService.savePerson(new Person()));

        User newUser = userRepository.save(user);

        return newUser.getUsername();
    }

    @Override
    public void deleteUser(String username) { userRepository.deleteById(username); }


    public void assignPersonToUser(Long personId, String username) {
        var optionalUser = userRepository.findById(username);
        var optionalPerson = personRepository.findById(personId);

        if (optionalPerson.isPresent() && optionalUser.isPresent()) {
            var user = optionalUser.get();
            var person = optionalPerson.get();
            user.setPerson(person);
            userRepository.save(user);
        }
    }

    public void assignImageToUser(String fileName, String username) {

        var optionalUser = userRepository.findById(username);
        var optionalImage = fileUploadRepository.findByFIleName(fileName);

        if (OptionalImage.isPresent() && optionalUser.isPresent()) {
            var user = optionalUser.get();
            var image = optionalPicture.get();

            user.setPerson(person);
            userRepository.save(user);

        } else {
            throw new RecordNotFoundException("een van de twee is niet gevonden");
        }
    }
}


