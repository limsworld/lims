package wold.lims.ejb.lab.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import wold.lims.ejb.base.model.base.AbstractEntityId;

@Entity
@Table(name = "EMPLOYEES", schema = "LAB")
public class Employee extends AbstractEntityId {

	private static final long serialVersionUID = 6482940291716064287L;

	@NotNull
	@Column(name = "NAME", length = 40)
	protected String name;

	@Column(name = "visible", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean visible;

	public String getName() {
		return name;
	}

	public Employee setName(String name) {
		this.name = name;
		return this;
	}

	public boolean isVisible() {
		return visible;
	}

	public Employee setVisible(boolean visible) {
		this.visible = visible;
		return this;
	}

}
