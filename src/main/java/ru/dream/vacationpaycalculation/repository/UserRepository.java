package ru.dream.vacationpaycalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dream.vacationpaycalculation.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
