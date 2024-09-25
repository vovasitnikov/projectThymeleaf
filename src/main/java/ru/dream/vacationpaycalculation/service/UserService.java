package ru.dream.vacationpaycalculation.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.dream.vacationpaycalculation.entity.User;
import ru.dream.vacationpaycalculation.repository.UserRepository;

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
}
