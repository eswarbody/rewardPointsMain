package com.assignment.rewards.points.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardPointsUtilsTest {


    RewardPointsUtils rewardPointsUtils;

    @BeforeEach
    public void init(){
         rewardPointsUtils = new RewardPointsUtils();
    }

    @Test
    public void testUtil(){
        LocalDate localDate = rewardPointsUtils.convertStToDate("1999-10-10");
        assertEquals(localDate, LocalDate.of(1999,10,10));
    }

}
