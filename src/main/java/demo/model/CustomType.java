package demo.model;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class CustomType implements Modifiable<String>{

	private String cvalue = "Testvc1";
	
	@Transient
	private boolean isModified;
	
	@Override
	public boolean isModified() {
		return true;
	}

	public void setModified(boolean isModified) {
		this.isModified = isModified;
	}
	
	@Override
	public String getValue() {
		return cvalue;
	}
	
	public void setValue(String value) {
		this.cvalue = value;
	}
}
