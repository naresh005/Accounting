package demo.service;

import java.math.BigDecimal;

import demo.exception.InsufficientFundsException;
import demo.model.Account;

public interface AccountService {
	
	public void transfer(Account senderAccount, Account receiverAccount, BigDecimal amount) throws InsufficientFundsException;

}
