package wold.lims.ejb.erp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import wold.lims.ejb.base.model.base.AbstractEntityUniqueNameLang;

@Entity
@Table(
	name = "EINHEITSGRUPPE", schema = "ERP",
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class Einheitsgruppe extends AbstractEntityUniqueNameLang {

	private static final long serialVersionUID = -609510796524799057L;

	@ManyToMany(
		fetch = FetchType.LAZY, 
		cascade = CascadeType.ALL, 
		mappedBy = "einheitsgruppen")
	protected List<Einheit> einheiten = new ArrayList<Einheit>();

	public Einheitsgruppe setName(String name) {
		this.name = name;
		return this;
	}

	public Einheitsgruppe setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

	public List<Einheit> getEinheiten() {
		return einheiten;
	}

	public Einheitsgruppe setEinheiten(List<Einheit> einheiten) {
		this.einheiten = einheiten;
		return this;
	}

}
