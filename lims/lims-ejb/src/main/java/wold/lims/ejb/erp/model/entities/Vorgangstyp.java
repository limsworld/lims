package wold.lims.ejb.erp.model.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import wold.lims.ejb.base.model.base.AbstractEntityUniqueNameLang;

@Entity
@Table(
	name = "VORGANGSTYP",
	schema = "ERP",
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@NamedQueries({
	@NamedQuery(name = "Vorgangstyp", 
		query = "SELECT v FROM Vorgangstyp v WHERE v.name = :name") })
public class Vorgangstyp extends AbstractEntityUniqueNameLang {

	private static final long serialVersionUID = 104114893998335430L;

	public Vorgangstyp setName(String name) {
		this.name = name;
		return this;
	}

	public Vorgangstyp setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

}
