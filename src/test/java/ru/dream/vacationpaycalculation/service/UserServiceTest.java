package ru.dream.vacationpaycalculation.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.dream.vacationpaycalculation.entity.User;
import ru.dream.vacationpaycalculation.repository.UserRepository;

import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;

class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private final UserRepository userRepository;

    UserServiceTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    void getAverageSalary() {
        Double averageSalaryPerMonth = 3.5;
        Integer countDays = 28;
        assertNotNull(averageSalaryPerMonth / 29.3 * countDays);
    }

    @Test
    void addUser() {
        User user2 = new User();
        user2.setId(0);
        user2.setEmail("vova_sinikov@mail.ru");
        user2.setLogin("vova_sinikov");
        user2.setLastName("sitnikov");
        user2.setPosition("инженер");
        user2.setBirthDate(LocalDate.parse("12.09.1985"));
        user2.setSalary(100000);

        userService.addUser(user2);
    }

}