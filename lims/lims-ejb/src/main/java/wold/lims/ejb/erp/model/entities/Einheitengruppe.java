package wold.lims.ejb.erp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import wold.lims.ejb.base.model.base.AbstractEntityUniqueNameLang;

@Entity
@Table(
	name = "EINHEITENGRUPPE", schema = "ERP",
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@NamedQueries({
	@NamedQuery(name = "Einheitengruppe", 
		query = "SELECT e FROM Einheitengruppe e WHERE e.name = :name") })
public class Einheitengruppe extends AbstractEntityUniqueNameLang {

	private static final long serialVersionUID = -609510796524799057L;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, 
		mappedBy = "einheitengruppen")
	protected List<Einheit> einheiten = new ArrayList<Einheit>();

	public Einheitengruppe setName(String name) {
		this.name = name;
		return this;
	}

	public Einheitengruppe setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

	public List<Einheit> getEinheiten() {
		return einheiten;
	}

	public Einheitengruppe setEinheiten(List<Einheit> einheiten) {
		this.einheiten = einheiten;
		return this;
	}

}
