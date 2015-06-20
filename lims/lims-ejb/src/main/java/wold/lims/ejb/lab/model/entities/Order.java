package wold.lims.ejb.lab.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import wold.lims.ejb.base.model.base.AbstractEntityId;

@Entity
@Table(name = "ORDER", schema = "LAB")
public class Order extends AbstractEntityId {

	private static final long serialVersionUID = -7109791041072874962L;

	@Column(name = "TEXT", length = 240)
    protected String text;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")	
	protected User userId;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")	
	protected Client client;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ORDER_DATE")
	protected Date orderDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DESIRED_DATE")
	protected Date desiredDate;

	public User getUserId() {
		return userId;
	}

	public Order setUserId(User userId) {
		this.userId = userId;
		return this;
	}

	public Client getClient() {
		return client;
	}

	public Order setClient(Client client) {
		this.client = client;
		return this;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Order setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
		return this;
	}

	public Date getDesiredDate() {
		return desiredDate;
	}

	public Order setDesiredDate(Date desiredDate) {
		this.desiredDate = desiredDate;
		return this;
	}

	public String getText() {
		return text;
	}

	public Order setText(String text) {
		this.text = text;
		return this;
	}

}
