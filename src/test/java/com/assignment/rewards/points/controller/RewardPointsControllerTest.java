package com.assignment.rewards.points.controller;;


import com.assignment.rewards.points.entity.User;
import com.assignment.rewards.points.service.RewardPointsService;
import com.assignment.rewards.points.utils.RewardPointsUtils;
import com.assignment.rewards.points.exceptions.NoRecordFoundException;
import com.assignment.rewards.points.dto.RewardPointsDTO;
import com.assignment.rewards.points.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class RewardPointsControllerTest {




    private static LocalDate the_date = LocalDate.of(1999,10,10);

    @Mock
    private UserRepository userRepository;

    @Mock
    private RewardPointsService rewardPointsService;


    @MockBean
    private RewardPointsUtils rewardPointsUtils;


    @InjectMocks
    RewardPointsController rewardPointsController;


    @BeforeEach
    public void setUp(){
        rewardPointsService = mock(RewardPointsService.class);
        userRepository = mock(UserRepository.class);
        rewardPointsUtils = mock(RewardPointsUtils.class);
        Mockito.when(rewardPointsUtils.convertStToDate( any())).thenReturn(the_date);
        MockitoAnnotations.openMocks(this);


    }


    @Test
    public void shouldReturnTotalPointsForSingleMonth() throws Exception {

        int total = 100;
         User user = new User();
        user.setUserID(9999L);
        RewardPointsDTO responseDTO = RewardPointsDTO.builder().total(total).build();
        given(rewardPointsService.calcPointsForMonth(anyLong(), any())).willReturn(responseDTO);
        ResponseEntity<RewardPointsDTO> res = rewardPointsController.calcPointsByMonth(user.getUserID(), the_date.toString());
        assertEquals(res.getStatusCode().value(), 200);

    }

    @Test
    public void shouldReturnTotalPointsForRange() throws Exception {

        int total = 100;
        User user = new User();
        user.setUserID(9999L);
        RewardPointsDTO responseDTO = RewardPointsDTO.builder().total(total).build();

        given(userRepository.findCustomerByuserID(9999L)).willReturn(user);
        given(rewardPointsService.calcPointsTotalFromTo(anyLong(), any(), any())).willReturn(responseDTO);


        ResponseEntity<RewardPointsDTO> res = rewardPointsController.calcPointsRange(user.getUserID(), the_date.toString(), the_date.toString());
        assertEquals(res.getStatusCode().value(), 200);
        assertEquals(res.getBody().getTotal(), total);

    }

    @Test
    public void shouldReturnTotalPointsForRangeShouldThrow() throws Exception {

        int total = 100;
        User user = new User();
        user.setUserID(9999L);

        given(userRepository.findCustomerByuserID(9999L)).willReturn(user);
        given(rewardPointsService.calcPointsTotalFromTo(anyLong(), any(), any())).willThrow(new NoRecordFoundException(RewardPointsUtils.CUSTOMER_NOT_EXISTS));

        NoRecordFoundException thrown = assertThrows(
                NoRecordFoundException.class,
                () -> rewardPointsController.calcPointsRange(user.getUserID(), the_date.toString(), the_date.toString()),
                "Expected calcPointsRange response to throw, but it didn't"
        );


        assertTrue(thrown.getMessage().contains(RewardPointsUtils.CUSTOMER_NOT_EXISTS));

    }





}
