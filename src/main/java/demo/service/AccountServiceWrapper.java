package demo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.exception.InsufficientFundsException;
import demo.model.Account;

@Service
public class AccountServiceWrapper {
	
	@Autowired AccountService accountService;
	
	public synchronized void transfer(Account senderAccount, Account receiverAccount,
			BigDecimal amount) throws InsufficientFundsException{
		accountService.transfer(senderAccount, receiverAccount, amount);
	}

}
