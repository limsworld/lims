package wold.lims.ejb.erp.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wold.lims.ejb.base.model.base.AbstractEntityBase;
import wold.lims.ejb.base.model.entities.Geschaeftsbereich;

@Entity
@Table(name = "PARTNERGESCHAEFTSBEREICH", schema = "ERP")
public class Partnergeschaeftsbereich extends AbstractEntityBase {

	private static final long serialVersionUID = 8454139818521859342L;

	@ManyToOne
	@JoinColumn(name = "GESCHAEFTSBEREICH_ID")	
	protected Geschaeftsbereich geschaeftsbereich;

	@ManyToOne
	@JoinColumn(name = "PARTNER_ID")	
	protected Partner partner;

	public Partner getPartner() {
		return partner;
	}

	public Partnergeschaeftsbereich setPartner(Partner partner) {
		this.partner = partner;
		return this;
	}

	public Geschaeftsbereich getGeschaeftsbereich() {
		return geschaeftsbereich;
	}

	public Partnergeschaeftsbereich 
			setGeschaeftsbereich(Geschaeftsbereich geschaeftsbereich) {
		this.geschaeftsbereich = geschaeftsbereich;
		return this;
	}

}
