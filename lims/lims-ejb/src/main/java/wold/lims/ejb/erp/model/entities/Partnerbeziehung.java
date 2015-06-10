package wold.lims.ejb.erp.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wold.lims.ejb.base.model.base.AbstractEntityBase;

@Entity
@Table(name = "PARTNERBEZIEHUNG", schema = "ERP")
public class Partnerbeziehung extends AbstractEntityBase {

	private static final long serialVersionUID = 9155112916170135401L;

	@ManyToOne
	@JoinColumn(name = "PARTNERBEZIEHUNGSTYP_ID")	
	protected Partnerbeziehungstyp partnerbeziehungstyp;

	@ManyToOne
	@JoinColumn(name = "PARTNER_ID")	
	protected Partner partner;

	@ManyToOne
	@JoinColumn(name = "PARTNER2_ID")	
	protected Partner partner2;

	public Partnerbeziehungstyp getPartnerbeziehungstyp() {
		return partnerbeziehungstyp;
	}

	public Partnerbeziehung setPartnerbeziehungstyp(Partnerbeziehungstyp partnerbeziehungstyp) {
		this.partnerbeziehungstyp = partnerbeziehungstyp;
		return this;
	}

	public Partner getPartner() {
		return partner;
	}

	public Partnerbeziehung setPartner(Partner partner) {
		this.partner = partner;
		return this;
	}

	public Partner getPartner2() {
		return partner2;
	}

	public Partnerbeziehung setPartner2(Partner partner2) {
		this.partner2 = partner2;
		return this;
	}

}
