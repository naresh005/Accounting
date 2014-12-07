package demo.std.model.api;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="stdrequest")
public class StdRequestImpl implements StdRequest{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long stdId;
	
	private String controlDept;
	private String extendingDept;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, targetEntity=StdLoanImpl.class, orphanRemoval=true)
	@JoinColumn(name="STD_ID")
	private Set<StdLoan> stdLoans = new LinkedHashSet<>();
	
	@ElementCollection
	@CollectionTable(name="stdcurrencies")
	private List<StdCurrency> currencies = new ArrayList<>();

	public Set<StdLoan> getStdLoans() {
		return stdLoans;
	}

	public void setStdLoans(Set<StdLoan> stdLoans) {
		this.stdLoans = stdLoans;
	}

	public List<StdCurrency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<StdCurrency> currencies) {
		this.currencies = currencies;
	}

	public String getControlUnit() {
		return controlDept;
	}

	public void setControlUnit(String controlDept) {
		this.controlDept = controlDept;
	}

	public String getExtendingUnit() {
		return extendingDept;
	}

	public void setExtendingUnit(String extendingDept) {
		this.extendingDept = extendingDept;
	}

}
