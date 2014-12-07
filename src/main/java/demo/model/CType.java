package demo.model;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class CType implements Modifiable<String> {
	
	private String ctype2 = "dkdk";
	
	@Transient
	private boolean isModified;
	
	public void setValue(String ctype2) {
		this.ctype2 = ctype2;
	}

	@Override
	public String getValue() {
		return ctype2;
	}

	@Override
	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

}
