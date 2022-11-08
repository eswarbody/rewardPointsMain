package com.assignment.rewards.points.service;

import com.assignment.rewards.points.dto.RewardPointsDTO;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface RewardPointsService {
     RewardPointsDTO calcPointsForMonth(Long id, LocalDate month);
     RewardPointsDTO calcPointsTotalFromTo(Long customerId, LocalDate from, LocalDate to);

    //int calcTierPoints(BigDecimal tierThreshold, BigDecimal amount, BigDecimal tier2MultiplierPoints);
}
