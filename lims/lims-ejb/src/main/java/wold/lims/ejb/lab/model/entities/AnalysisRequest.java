package wold.lims.ejb.lab.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wold.lims.ejb.base.model.base.AbstractEntityId;

@Entity
@Table(name = "ANALYSIS_REQUESTS", schema = "LAB")
public class AnalysisRequest extends AbstractEntityId {

	private static final long serialVersionUID = -7337503771936024933L;
	
	@ManyToOne
	@JoinColumn(name = "TYP_ID")	
	protected AnalysisRequestState typ;

	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_ID")	
	protected Employee employee;

	@ManyToOne
	@JoinColumn(name = "USER_ID")	
	protected User userId;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")	
	protected Client clientId;

	public AnalysisRequestState getTyp() {
		return typ;
	}

	public AnalysisRequest setTyp(AnalysisRequestState typ) {
		this.typ = typ;
		return this;
	}

	public Employee getEmployee() {
		return employee;
	}

	public AnalysisRequest setEmployee(Employee employee) {
		this.employee = employee;
		return this;
	}

	public Client getClientId() {
		return clientId;
	}

	public AnalysisRequest setClientId(Client clientId) {
		this.clientId = clientId;
		return this;
	}

	public User getUserId() {
		return userId;
	}

	public AnalysisRequest setUserId(User userId) {
		this.userId = userId;
		return this;
	}

}
