package com.assignment.rewards.points.repository;

import java.time.LocalDate;
import java.util.List;

import com.assignment.rewards.points.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TransactionRepository extends CrudRepository<Transaction,Long> {

    List<Transaction> findAllByUserIDAndTransDateBetween(Long id, LocalDate from, LocalDate to);
    Transaction findAllByUserIDAndTransDateIs(Long id, LocalDate date);
}
