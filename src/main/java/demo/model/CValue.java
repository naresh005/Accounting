package demo.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class CValue  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Transient
	private Modifiable<String> twoCustomType;
	
	@Transient
	private Modifiable<String> cType;
	
	public Modifiable<String> getcType() {
		return ctype;
	}

	public void setcType(Modifiable<String> cType) {
		this.cType = cType;
	}

	public Modifiable<String> getTwoCustomType() {
		return customType;
	}

	public void setTwoCustomType(Modifiable<String> twoCustomType) {
		this.twoCustomType = twoCustomType;
	}
	
	@Embedded
	private CType ctype;

	/*public CType getCtype() {
		return ctype;
	}

	public void setCtype(CType ctype) {
		this.ctype = ctype;
	}*/

	@Embedded
	private CustomType customType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*public CustomType getCustomType() {
		return customType;
	}

	public void setCustomType(CustomType customType) {
		this.customType = customType;
	}*/

	
	
	

}
