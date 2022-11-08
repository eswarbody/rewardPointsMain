package com.assignment.rewards.points.integration.controller;


import com.assignment.rewards.points.controller.RewardPointsController;
import com.assignment.rewards.points.dto.RewardPointsDTO;
import com.assignment.rewards.points.entity.User;
import com.assignment.rewards.points.exceptions.NoRecordFoundException;
import com.assignment.rewards.points.repository.TransactionRepository;
import com.assignment.rewards.points.repository.UserRepository;
import com.assignment.rewards.points.service.RewardPointsService;
import com.assignment.rewards.points.utils.RewardPointsUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static com.assignment.rewards.points.utils.RewardPointsUtils.CUSTOMER_NOT_EXISTS;
import static com.assignment.rewards.points.utils.RewardPointsUtils.NO_RECORD_FOUND;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = RewardPointsController.class)
public class RewardPointsControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private UserRepository customerRepository;
    @MockBean
    private RewardPointsService iPointsService;

    @MockBean
    private TransactionRepository transactionRepository;



    @TestConfiguration
    static class AdditionalConfig {
        @Bean
        public RewardPointsUtils pointsUtils() {
            return new RewardPointsUtils();
        }
    }
    @Test
    public void shouldReturnTotalPointsForSingleMonth() throws Exception {

        int total = 100;
        User customer = new User();
        customer.setUserID(9999L);
        RewardPointsDTO responseDTO = RewardPointsDTO.builder().total(total).build();

        given(iPointsService.calcPointsForMonth(anyLong(), any())).willReturn(responseDTO);

        mockMvc.perform(get("/rewards/9999/points/2020-04-12"))
                .andExpect(jsonPath("$.total").value(total))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void shouldReturnTotalPointsForRange() throws Exception {

        int total = 100;
        User customer = new User();
        customer.setUserID(9999L);
        RewardPointsDTO responseDTO = RewardPointsDTO.builder().total(total).build();

        given(customerRepository.findCustomerByuserID(9999L)).willReturn(customer);
        given(iPointsService.calcPointsTotalFromTo(anyLong(), any(), any())).willReturn(responseDTO);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("from","2020-04-12");
        params.add("to","2020-04-12");

        mockMvc.perform(get("/rewards/9999/points").queryParams(params))
                .andExpect(jsonPath("$.total").value(total))
                .andExpect(status().is2xxSuccessful());
    }


    @Test
    public void shouldReturnTotalPointsForRangeThrow() throws Exception {

        given(iPointsService.calcPointsTotalFromTo(anyLong(), any(), any())).willThrow(new NoRecordFoundException(CUSTOMER_NOT_EXISTS));

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("from","2020-04-12");
        params.add("to","2020-04-12");

        mockMvc.perform(get("/rewards/9999/points").queryParams(params))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.message").value(NO_RECORD_FOUND));

    }


}
