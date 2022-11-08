package com.assignment.rewards.points.repository;

import com.assignment.rewards.points.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findCustomerByuserID(Long customerId);
}
