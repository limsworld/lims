package wold.lims.ejb.erp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import wold.lims.ejb.base.model.base.AbstractEntityUniqueNameLang;

@Entity
@Table(name = "GESCHAEFTSBEREICH", schema = "BASE",
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class Geschaeftsbereich extends AbstractEntityUniqueNameLang {

	private static final long serialVersionUID = -1648675469235650170L;

	@ManyToOne
	@JoinColumn(name = "GESCHAEFTSBEREICH_ID")	
	protected Geschaeftsbereich geschaeftsbereich;

	@ManyToOne
	@JoinColumn(name = "PARTNER_ID")	
	protected Partner partner;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "geschaeftsbereich")
	protected List<Geschaeftsbereich> geschaeftsbereiche = new ArrayList<Geschaeftsbereich>();

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

	public Geschaeftsbereich getGeschaeftsbereich() {
		return geschaeftsbereich;
	}

	public Geschaeftsbereich setGeschaeftsbereich(Geschaeftsbereich geschaeftsbereich) {
		this.geschaeftsbereich = geschaeftsbereich;
		return this;
	}

	public List<Geschaeftsbereich> getGeschaeftsbereiche() {
		return geschaeftsbereiche;
	}

	public Geschaeftsbereich setGeschaeftsbereiche(List<Geschaeftsbereich> geschaeftsbereiche) {
		this.geschaeftsbereiche = geschaeftsbereiche;
		return this;
	}

	public Geschaeftsbereich addGeschaeftsbereich(Geschaeftsbereich geschaeftsbereich) {
		geschaeftsbereiche.add(geschaeftsbereich);
		return this;
	}

	public Partner getPartner() {
		return partner;
	}

	public Geschaeftsbereich setPartner(Partner partner) {
		this.partner = partner;
		return this;
	}

}
