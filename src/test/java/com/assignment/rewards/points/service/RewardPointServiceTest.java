package com.assignment.rewards.points.service;


import com.assignment.rewards.points.entity.User;
import com.assignment.rewards.points.entity.Transaction;
import com.assignment.rewards.points.utils.RewardPointsUtils;
import com.assignment.rewards.points.dto.RewardPointsDTO;
import com.assignment.rewards.points.repository.UserRepository;
import com.assignment.rewards.points.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class RewardPointServiceTest {



    private static LocalDate the_date = LocalDate.of(1999,10,10);

    @MockBean
    private UserRepository userRepository;

    @MockBean
    TransactionRepository transactionRepositoryMock;


    @InjectMocks
    private RewardPointsServiceImpl iPointsService;


    @MockBean
    private RewardPointsUtils rewardPointsUtils;


    @BeforeEach
    public void setUp(){
        userRepository = mock(UserRepository.class);
        transactionRepositoryMock = mock(TransactionRepository.class);
        rewardPointsUtils = mock(RewardPointsUtils.class);
        Mockito.when(rewardPointsUtils.convertStToDate( any())).thenReturn(the_date);
        MockitoAnnotations.openMocks(this);
    }





    @Test
    public void testCalcPointsForMonth(){
        LocalDate localDate = LocalDate.of(1999,9,9);
        Long cus_id = 1000L;
        Transaction transaction = new Transaction();
        transaction.setTransAmount(new BigDecimal(120L));
        transaction.setUserID(cus_id);
        transaction.setTransDate(localDate);
        given(transactionRepositoryMock.findAllByUserIDAndTransDateIs(anyLong(), any())).willReturn(transaction);
        given(userRepository.findCustomerByuserID(anyLong())).willReturn(User.builder().userID(cus_id).build());

        RewardPointsDTO rewardPointsDTO =  iPointsService.calcPointsForMonth(cus_id, localDate);
        assertEquals(rewardPointsDTO.getTotal(), 90);
    }
    @Test
    public void testCalcPointsTotalFromTo(){
        LocalDate localDate = LocalDate.of(1999,9,9);
        Long cus_id = 1000L;
        Transaction transaction = new Transaction();
        transaction.setTransAmount(new BigDecimal(120L));
        transaction.setUserID(100L);
        transaction.setTransDate(localDate);
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);
        transactionList.add(transaction);
        given(transactionRepositoryMock.findAllByUserIDAndTransDateBetween(anyLong(), any(), any())).willReturn(transactionList);
        given(userRepository.findCustomerByuserID(anyLong())).willReturn(User.builder().userID(cus_id).build());

        RewardPointsDTO rewardPointsDTO =  iPointsService.calcPointsTotalFromTo(cus_id, localDate,localDate);
        assertEquals(rewardPointsDTO.getTotal(), 180);
    }

}
