package wold.lims.ejb.erp.model.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import wold.lims.ejb.base.model.base.AbstractEntityUniqueNameLang;

@Entity
@Table(
	name = "VORGANGSSTATUS",
	schema = "ERP",
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@NamedQueries({
	@NamedQuery(name = "Vorgangsstatus", 
		query = "SELECT v FROM Vorgangsstatus v WHERE v.name = :name") })
public class Vorgangsstatus extends AbstractEntityUniqueNameLang {

	private static final long serialVersionUID = 8151382011921166130L;

	public Vorgangsstatus setName(String name) {
		this.name = name;
		return this;
	}

	public Vorgangsstatus setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

}
