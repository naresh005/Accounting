package demo.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.exception.InsufficientFundsException;
import demo.model.Account;
import demo.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	@Transactional
	public void transfer(Account senderAccount, Account receiverAccount,
			BigDecimal amount) throws InsufficientFundsException {
		synchronized(senderAccount){
			synchronized(receiverAccount){
				
				BigDecimal senderBalance = senderAccount.getBalance();
				BigDecimal receiverBalance = receiverAccount.getBalance();
				if(senderBalance.compareTo(amount) < 0) 
					throw new InsufficientFundsException();
				System.out.println("Before Transfer-"+Thread.currentThread().getName() +" Balance sender- " + senderAccount.getBalance() + " Receiver-" + receiverAccount.getBalance());
				senderAccount.setBalance(senderBalance.subtract(amount));
				receiverAccount.setBalance(receiverBalance.add(amount));
				accountRepository.saveAndFlush(senderAccount);
				accountRepository.saveAndFlush(receiverAccount);
				System.out.println("After Transfer-"+Thread.currentThread().getName() +" Balance sender- " + senderAccount.getBalance() + " Receiver-" + receiverAccount.getBalance());
				
			}
		}		
	}

}
