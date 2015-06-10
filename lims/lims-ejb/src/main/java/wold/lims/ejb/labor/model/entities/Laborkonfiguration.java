package wold.lims.ejb.labor.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wold.lims.ejb.base.model.base.AbstractEntityBase;
import wold.lims.ejb.erp.model.entities.Einheitengruppe;
import wold.lims.ejb.erp.model.entities.Geschaeftsbereich;

@Entity
@Table(name = "LABORKONFIGURATIONå", schema = "LABOR")
public class Laborkonfiguration extends AbstractEntityBase {

	private static final long serialVersionUID = -4927233143744425049L;

	@ManyToOne
	@JoinColumn(name = "EINHEITENGRUPPE_ID")	
	protected Einheitengruppe einheitengruppe;

	@ManyToOne
	@JoinColumn(name = "GESCHAEFTSBEREICH_ID")	
	protected Geschaeftsbereich geschaeftsbereich;

	public Einheitengruppe getEinheitengruppe() {
		return einheitengruppe;
	}

	public Laborkonfiguration setEinheitengruppe(Einheitengruppe einheitengruppe) {
		this.einheitengruppe = einheitengruppe;
		return this;
	}

	public Geschaeftsbereich getGeschaeftsbereich() {
		return geschaeftsbereich;
	}

	public Laborkonfiguration setGeschaeftsbereich(Geschaeftsbereich geschaeftsbereich) {
		this.geschaeftsbereich = geschaeftsbereich;
		return this;
	}

}
