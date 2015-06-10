package wold.lims.ejb.erp.model.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import wold.lims.ejb.base.model.base.AbstractEntityUniqueNameLang;

@Entity
@Table(name = "GESCHLECHT", schema = "ERP",
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@NamedQueries({
	@NamedQuery(name = "Geschlecht", 
		query = "SELECT g FROM Geschlecht g WHERE g.name = :name") })
public class Geschlecht extends AbstractEntityUniqueNameLang {

	private static final long serialVersionUID = 5957361743420600324L;

	public Geschlecht setName(String name) {
		this.name = name;
		return this;
	}

	public Geschlecht setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

}
