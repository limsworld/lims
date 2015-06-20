package wold.lims.ejb.lab.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import wold.lims.ejb.base.model.base.AbstractEntityId;

@Entity
@Table(name = "USERS", schema = "LAB")
public class User extends AbstractEntityId {

	private static final long serialVersionUID = -6106429920883466440L;

	@NotNull
	@Column(name = "NAME", length = 40)
	protected String name;

	@NotNull
	@Column(name = "EMAIL", length = 40)
	protected String email;

	@Column(name = "visible", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean visible;

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public boolean isVisible() {
		return visible;
	}

	public User setVisible(boolean visible) {
		this.visible = visible;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

}
