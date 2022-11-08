package com.assignment.rewards.points.controller;

import com.assignment.rewards.points.service.RewardPointsService;
import com.assignment.rewards.points.utils.RewardPointsUtils;
import com.assignment.rewards.points.dto.RewardPointsDTO;
import com.assignment.rewards.points.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rewards")
public class RewardPointsController {


    RewardPointsService rewardPointsService;


    UserRepository userRepository;



    RewardPointsUtils rewardPointsUtils;


    @Autowired
    public RewardPointsController(RewardPointsService rewardPointsService, UserRepository userRepository, RewardPointsUtils rewardPointsUtils) {
        this.rewardPointsService = rewardPointsService;
        this.userRepository = userRepository;
        this.rewardPointsUtils = rewardPointsUtils;
    }

    @GetMapping(value = "/{id}/points", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "/{id}/points")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = RewardPointsDTO.class),
            @ApiResponse(code = 404, message = " User not found "),
            @ApiResponse(code=  422, message =" UnProcessable Entity"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<RewardPointsDTO> calcPointsRange(
            @PathVariable("id") Long customerId,
            @RequestParam("from") String from,
            @RequestParam("to") String to) {

        RewardPointsDTO responseDTO =
                rewardPointsService.calcPointsTotalFromTo(customerId,
                        rewardPointsUtils.convertStToDate(from), rewardPointsUtils.convertStToDate(to));

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/{id}/points/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "/{id}/points/{date}")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = RewardPointsDTO.class),
            @ApiResponse(code = 404, message = " User not found "),
            @ApiResponse(code=  422, message =" UnProcessable Entity"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})

    public ResponseEntity<RewardPointsDTO> calcPointsByMonth(
            @PathVariable("id") Long customerId,
            @PathVariable("date") String date) {

        RewardPointsDTO responseDTO =
                rewardPointsService.calcPointsForMonth(customerId, rewardPointsUtils.convertStToDate(date));


        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
