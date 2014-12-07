package demo.model;

import javax.persistence.Embeddable;


public interface Modifiable<T> {

	public String getValue();
	public boolean isModified();
}
