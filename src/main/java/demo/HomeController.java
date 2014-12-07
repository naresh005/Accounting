package demo;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.exception.InsufficientFundsException;
import demo.model.Account;
import demo.model.CValue;
import demo.repository.CValueRepository;
import demo.service.AccountService;

@RestController
public class HomeController {
	
	@Autowired private ProductRepository productRepository;
	@Autowired private AccountService accountService;
	@Autowired private CValueRepository cvalueRepository;
	ExecutorService executor = Executors.newFixedThreadPool(10);
	@RequestMapping("/home")
	public String getHome(){
		return "home";
	}
	
	@RequestMapping("/products")
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	@RequestMapping("/cvalues")
	public List<CValue> getCValues(){
		return cvalueRepository.findAll();
	}
	
	@RequestMapping("/transferfunds")
	public void transferFunds() throws InsufficientFundsException, InterruptedException{
		final Account senderAccount = new Account();
		senderAccount.setAccountId(new Long(1));
		senderAccount.setAccountNumber("A1");
		senderAccount.setBalance(new BigDecimal(1000.00));
		
		final Account receiverAccount = new Account();
		receiverAccount.setAccountId(new Long(2));
		receiverAccount.setAccountNumber("A2");
		receiverAccount.setBalance(new BigDecimal(1000.00));
		
		for(int i=0; i<100; i++){
		executor.execute(new Runnable(){

			@Override
			public void run() {
				try {
					accountService.transfer(senderAccount, receiverAccount, new BigDecimal(1.00));
				} catch (InsufficientFundsException e) {
					e.printStackTrace();
				}
				
			}});
		}

		//accountService.transfer(senderAccount, receiverAccount, new BigDecimal(1));
		executor.shutdown();
		executor.awaitTermination(100, TimeUnit.SECONDS);
		
		System.out.println("Final Sender Balance - "+ senderAccount.getBalance());
		System.out.println("Final Receiver Balance - "+ receiverAccount.getBalance());
	}
	

}
