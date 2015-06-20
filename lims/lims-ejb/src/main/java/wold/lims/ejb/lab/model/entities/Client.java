package wold.lims.ejb.lab.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import wold.lims.ejb.base.model.base.AbstractEntityId;

@Entity
@Table(name = "CLIENTS", schema = "LAB",
	uniqueConstraints = @UniqueConstraint(columnNames = "CLIENT_ID"))
public class Client extends AbstractEntityId {

	private static final long serialVersionUID = -5303721957828691604L;

	@NotNull
	@Column(name = "CLIENT_ID", length = 40)
	protected String clientId;

	@NotNull
	@Column(name = "NAME", length = 40)
	protected String name;

	@NotNull
	@Column(name = "EMAIL", length = 40)
	protected String email;

	@NotNull
	@Column(name = "PHONE", length = 40)
	protected String phone;

	@NotNull
	@Column(name = "fax", length = 40)
	protected String fax;

	@Column(name = "visible", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean visible;

	public String getName() {
		return name;
	}

	public Client setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Client setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public Client setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getFax() {
		return fax;
	}

	public Client setFax(String fax) {
		this.fax = fax;
		return this;
	}

	public boolean isVisible() {
		return visible;
	}

	public Client setVisible(boolean visible) {
		this.visible = visible;
		return this;
	}

	public String getClientId() {
		return clientId;
	}

	public Client setClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}

}
