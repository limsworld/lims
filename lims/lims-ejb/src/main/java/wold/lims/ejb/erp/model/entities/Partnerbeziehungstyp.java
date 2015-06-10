package wold.lims.ejb.erp.model.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import wold.lims.ejb.base.model.base.AbstractEntityUniqueNameLang;

@Entity
@Table(name = "PARTNERBEZIEHUNGSTYP", schema = "ERP",
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@NamedQueries({
	@NamedQuery(name = "Partnerbeziehungstyp", 
		query = "SELECT p FROM Partnerbeziehungstyp p WHERE p.name = :name") })
public class Partnerbeziehungstyp extends AbstractEntityUniqueNameLang {

	private static final long serialVersionUID = 7319616208439591057L;

	public Partnerbeziehungstyp setName(String name) {
		this.name = name;
		return this;
	}

	public Partnerbeziehungstyp setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

	public Partnerbeziehungstyp setSystem(boolean system) {
		this.system = system;
		return this;
	}

}
