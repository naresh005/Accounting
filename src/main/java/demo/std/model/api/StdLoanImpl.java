package demo.std.model.api;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import demo.std.model.api.StdLoan;
import demo.std.model.api.StdRequest;
import demo.std.model.api.StdRequestImpl;
/**
 * Std loan entity
 * @author nanu
 *
 */
@Entity
@Table(name = "stdloan")
public class StdLoanImpl implements StdLoan{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long loanId;
	
	private double writeOff;
	private double netAmount;
	
	@ManyToOne(targetEntity=StdRequestImpl.class, fetch=FetchType.EAGER)
	@JoinColumn(name="STD_ID", insertable=false, updatable=false)
	private StdRequest stdRequest;

	public double getWriteOff() {
		return writeOff;
	}

	public void setWriteOff(double writeOff) {
		this.writeOff = writeOff;
	}

	public double getNetOsuc() {
		return netAmount;
	}

	public void setNetOsuc(double netOsuc) {
		this.netAmount = netOsuc;
	}
	public Long getLoanId(){
		return loanId;
	}
}
