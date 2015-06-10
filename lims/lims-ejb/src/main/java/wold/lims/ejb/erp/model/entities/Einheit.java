package wold.lims.ejb.erp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import wold.lims.ejb.base.model.base.AbstractEntityUniqueNameLang;

@Entity
@Table(name = "EINHEIT", schema = "ERP",
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class Einheit extends AbstractEntityUniqueNameLang {

	private static final long serialVersionUID = -609510796524799057L;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "EINHEIT_EINHEITSGRUPPE", schema = "erp", joinColumns = { 
			@JoinColumn(name = "EINHEIT_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "EINHEITSGRUPPE_ID", 
					nullable = false, updatable = false) })
	protected List<Einheitsgruppe> einheitsgruppen = new ArrayList<Einheitsgruppe>();

	public Einheit setName(String name) {
		this.name = name;
		return this;
	}

	public Einheit setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

	public List<Einheitsgruppe> getEinheitsgruppen() {
		return einheitsgruppen;
	}

	public Einheit setEinheitsgruppen(List<Einheitsgruppe> einheitsgruppen) {
		this.einheitsgruppen = einheitsgruppen;
		return this;
	}

	public Einheit addEinheitsgruppe(Einheitsgruppe einheitsgruppe) {
		einheitsgruppen.add(einheitsgruppe);
		return this;
	}

}
