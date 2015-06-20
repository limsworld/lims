package wold.lims.ejb.erp.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wold.lims.ejb.base.model.base.AbstractEntityUser;
import wold.lims.ejb.base.model.entities.SystemUser;

@Entity
@Table(name = "VORGANG", schema = "ERP")
public class Vorgang extends AbstractEntityUser {

	private static final long serialVersionUID = 6095424740511045115L;

	@ManyToOne
	@JoinColumn(name = "VORGANGSTYP_ID")	
	protected Vorgangstyp vorgangstyp;

	@ManyToOne
	@JoinColumn(name = "VORGANGSSTATUS_ID")	
	protected Vorgangsstatus vorgangsstatus;

	public Vorgang setUser(SystemUser user) {
		this.user = user;
		return this;
	}

	public Vorgangstyp getVorgangstyp() {
		return vorgangstyp;
	}

	public Vorgang setVorgangstyp(Vorgangstyp vorgangstyp) {
		this.vorgangstyp = vorgangstyp;
		return this;
	}

	public Vorgangsstatus getVorgangsstatus() {
		return vorgangsstatus;
	}

	public Vorgang setVorgangsstatus(Vorgangsstatus vorgangsstatus) {
		this.vorgangsstatus = vorgangsstatus;
		return this;
	}

}
