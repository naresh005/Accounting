package demo.std.model.api;

import java.util.List;
import java.util.Set;

public interface StdRequest {
	
	public Set<StdLoan> getStdLoans();
	public void setStdLoans(Set<StdLoan> stdLoans);
	public List<StdCurrency> getCurrencies();
	public void setCurrencies(List<StdCurrency> currencies);
	

}
