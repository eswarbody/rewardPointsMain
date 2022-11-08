package com.assignment.rewards.points.dto;

import lombok.*;

import java.math.BigDecimal;


@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RewardPointsRuleConfig {


    private BigDecimal tierThreshold;
    private BigDecimal tier2MultiplierPoints;
}
