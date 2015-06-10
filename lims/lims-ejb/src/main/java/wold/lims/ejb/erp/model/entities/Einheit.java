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
	@JoinTable(name = "EINHEIT_EINHEITENGRUPPE", schema = "erp", joinColumns = { 
			@JoinColumn(name = "EINHEIT_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "EINHEITENGRUPPE_ID", 
					nullable = false, updatable = false) })
	protected List<Einheitengruppe> einheitengruppen = new ArrayList<Einheitengruppe>();

	public Einheit setName(String name) {
		this.name = name;
		return this;
	}

	public Einheit setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

	public List<Einheitengruppe> getEinheitengruppen() {
		return einheitengruppen;
	}

	public void setEinheitengruppen(List<Einheitengruppe> einheitengruppen) {
		this.einheitengruppen = einheitengruppen;
	}

	public Einheit addEinheitengruppe(Einheitengruppe einheitengruppe) {
		einheitengruppen.add(einheitengruppe);
		return this;
	}

}
