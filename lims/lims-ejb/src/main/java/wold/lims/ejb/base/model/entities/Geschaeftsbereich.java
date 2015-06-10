package wold.lims.ejb.base.model.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import wold.lims.ejb.base.model.base.AbstractEntityUniqueNameLang;

@Entity
@Table(name = "GESCHAEFTSBEREICH", schema = "BASE",
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class Geschaeftsbereich extends AbstractEntityUniqueNameLang {

	private static final long serialVersionUID = -1648675469235650170L;

	public Geschaeftsbereich setName(String name) {
		this.name = name;
		return this;
	}

	public Geschaeftsbereich setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

	public Geschaeftsbereich setSystem(boolean system) {
		this.system = system;
		return this;
	}

}
