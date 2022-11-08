package com.assignment.rewards.points.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.assignment.rewards.points.entity.User;
import com.assignment.rewards.points.entity.Transaction;
import com.assignment.rewards.points.utils.RewardPointsUtils;
import com.assignment.rewards.points.exceptions.NoRecordFoundException;
import com.assignment.rewards.points.dto.RewardPointsDTO;
import com.assignment.rewards.points.dto.RewardPointsRuleConfig;
import com.assignment.rewards.points.repository.UserRepository;
import com.assignment.rewards.points.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RewardPointsServiceImpl implements RewardPointsService {

	BigDecimal rewardThresholdMax= new BigDecimal(100);
	BigDecimal rewardThresholdMin= new BigDecimal(50);
	BigDecimal two= new BigDecimal(2);
	TransactionRepository transactionRepository;
	UserRepository userRepository;


	@Autowired
	public RewardPointsServiceImpl(TransactionRepository transactionRepository, UserRepository userRepository) {
		this.transactionRepository = transactionRepository;
		this.userRepository = userRepository;
	}

	public RewardPointsDTO calcPointsTotalFromTo(Long customerId, LocalDate from, LocalDate to) {
		checkCustomerOrThrow(customerId);

		List<Transaction> transactionsByMonths =
				transactionRepository
						.findAllByUserIDAndTransDateBetween(
								customerId, from,to);


		int totalsofAllMonths = transactionsByMonths.stream()
				.mapToInt(this::calcTierPointsByThresholdForTransaction)
				.sum();
		log.info("found total trannsaction : {} for user: {} ", totalsofAllMonths, customerId);

		RewardPointsDTO responseDTO =
				RewardPointsDTO
				.builder()
				.total(totalsofAllMonths)
				.build();


		return responseDTO;
	}
	public RewardPointsDTO calcPointsForMonth(Long customerId, LocalDate month) {

		checkCustomerOrThrow(customerId);

		Transaction transactionByMonth =
				transactionRepository
						.findAllByUserIDAndTransDateIs(
								customerId, month);
		return RewardPointsDTO
				.builder()
				.total(calcTierPointsByThresholdForTransaction(transactionByMonth))
				.build();

	}

	private void checkCustomerOrThrow(Long customerId) {
		User user = userRepository.findCustomerByuserID(customerId);

		log.debug("trying to check user {}", customerId);
		if(user == null)
		{
			log.error("Error while retrieving user info {}", customerId);
			throw new NoRecordFoundException(RewardPointsUtils.CUSTOMER_NOT_EXISTS);
		}
	}


	public int calcTierPointsByThresholdForTransaction(Transaction transaction) {

		int rewardPoints = ( transaction.getTransAmount().compareTo( rewardThresholdMin) >0 &&
				transaction.getTransAmount().compareTo( rewardThresholdMax) <= 0 )?transaction.getTransAmount().intValue() :
				(transaction.getTransAmount().subtract( rewardThresholdMax)).multiply(two)
				.add(rewardThresholdMin).intValue();
		return rewardPoints;
	}


}
