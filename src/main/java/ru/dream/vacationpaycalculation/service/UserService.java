package ru.dream.vacationpaycalculation.service;

import jakarta.persistence.Column;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.dream.vacationpaycalculation.entity.User;
import ru.dream.vacationpaycalculation.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Double getAverageSalary(Double averageSalaryPerMonth, Integer countDays){
        //29,3 - это среднее количество дней в месяце
        return averageSalaryPerMonth / 29.3 * countDays;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }

    public User addUser(User newUser){
        return userRepository.save(newUser);
    }

    public User deleteUser(int userId){
        userRepository.deleteById(userId);
        return null;
    }

    public void update(int id, User updateUser){
        User userToBeUpdated = userRepository.findById(id).orElseThrow(EntityNotFoundException::new); // Определение местонахождения Алисы
        userToBeUpdated.setName(updateUser.getName());
        userToBeUpdated.setLastName(updateUser.getLastName());
        userToBeUpdated.setLogin(updateUser.getLogin());
        userToBeUpdated.setPosition(updateUser.getPosition());
        userToBeUpdated.setEmail(updateUser.getEmail());
        userToBeUpdated.setBirthDate(updateUser.getBirthDate());
        userToBeUpdated.setSalary(updateUser.getSalary());
        userRepository.save(userToBeUpdated);
    }
}
