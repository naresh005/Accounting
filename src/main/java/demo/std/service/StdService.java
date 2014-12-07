package demo.std.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.std.model.api.StdCurrency;
import demo.std.model.api.StdLoan;
import demo.std.model.api.StdLoanImpl;
import demo.std.model.api.StdRequestImpl;
import demo.std.repository.StdRequestRepository;

@Service
public class StdService {
	
	@Autowired private StdRequestRepository stdRequestRepository;
	
	public StdRequestImpl getStdRequest(long stdid) {
		return stdRequestRepository.findOne(stdid);
	}
	
	public void createAndSaveStdRequest(){
		
		StdLoanImpl loan = new StdLoanImpl();
		loan.setNetOsuc(1000);
		loan.setWriteOff(100);
		StdRequestImpl stdRequest = new StdRequestImpl();
		stdRequest.setControlUnit("TW");
		stdRequest.setExtendingUnit("TW");
		stdRequest.getStdLoans().add(loan);
		saveStdRequest(stdRequest);
		
	}
	public void updateStdRequest(long stdid){
		StdRequestImpl stdRequestForUpdate = stdRequestRepository.findOne(stdid);
		stdRequestForUpdate.setExtendingUnit("IN");
		Iterator<StdLoan> stdLoansIterator = stdRequestForUpdate.getStdLoans().iterator();
		while(stdLoansIterator.hasNext()){
			StdLoanImpl loan = (StdLoanImpl) stdLoansIterator.next();
			if(loan.getLoanId()==2){
				stdLoansIterator.remove();
			}
		}
		Iterator<StdCurrency> currencies = stdRequestForUpdate.getCurrencies().iterator();
		while(currencies.hasNext()){
			StdCurrency currency = currencies.next();
			if(currency.getCode().equals("TWD")){
				currencies.remove();
			}
			
		}
		
		
		saveStdRequest(stdRequestForUpdate);
	}
	/**
	 * This will handle both save and update
	 * @param stdRequest
	 */
	public void saveStdRequest(StdRequestImpl stdRequest) {
		stdRequestRepository.save(stdRequest);
	}
	
	

}
