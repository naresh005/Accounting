package demo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account {
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="ACCNUM")
	private String accountNumber;
	
	@Column(name="CUSNAME")
	private String customerName;
	
	@Column(name="BAL")
	private BigDecimal balance;

	public BigDecimal getBalance() {
		return balance;
	}
	
	@ElementCollection
	@CollectionTable(name="Prev_Accounts", joinColumns=@JoinColumn(name="Acc_Id"))
	private List<Account> preAccounts = new ArrayList<>();

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Long getAccountId() {
		return id;
	}

	public void setAccountId(Long accountId) {
		this.id = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	

	
}
