package ru.dream.vacationpaycalculation.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import ru.dream.vacationpaycalculation.entity.User;
import ru.dream.vacationpaycalculation.repository.UserRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertNotNull;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @Test
    void getAverageSalary() {
        Double averageSalaryPerMonth = 3.5;
        Integer countDays = 28;
        assertNotNull(averageSalaryPerMonth / 29.3 * countDays);
    }

    @Test
    void addUser() {
        User user2 = new User();
        user2.setName("Name1");
        user2.setEmail("vova_sinikov@mail.ru1");
        user2.setLogin("vova_sinikov1");
        userService.addUser(user2);
    }

}