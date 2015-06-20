package wold.lims.ejb.erp.model.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wold.lims.ejb.base.model.base.AbstractEntityUser;
import wold.lims.ejb.base.model.entities.SystemUser;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DISKRIMINATOR", length = 32)
@DiscriminatorValue("POSITION")
@Table(name = "POSITION", schema = "ERP")
public class Position extends AbstractEntityUser {

	private static final long serialVersionUID = -523174583159520075L;

	@ManyToOne
	@JoinColumn(name = "VORGANG_ID")	
	protected Vorgang vorgang;

	@ManyToOne
	@JoinColumn(name = "ARTIKEL_ID")	
	protected Artikel artikel;

	@ManyToOne
	@JoinColumn(name = "VORGANGSSTATUS_ID")	
	protected Vorgangsstatus vorgangsstatus;

	@ManyToOne
	@JoinColumn(name = "EINHEIT_ID")	
	protected Einheit einheit;

	@Column(name = "MENGE")
	protected double menge;

	@Column(name = "PREIS")
	protected double preis;

	public Position setUser(SystemUser user) {
		this.user = user;
		return this;
	}

	public Vorgang getVorgang() {
		return vorgang;
	}

	public Position setVorgang(Vorgang vorgang) {
		this.vorgang = vorgang;
		return this;
	}

	public Artikel getArtikel() {
		return artikel;
	}

	public Position setArtikel(Artikel artikel) {
		this.artikel = artikel;
		return this;
	}

	public double getMenge() {
		return menge;
	}

	public Position setMenge(double menge) {
		this.menge = menge;
		return this;
	}

	public double getPreis() {
		return preis;
	}

	public Position setPreis(double preis) {
		this.preis = preis;
		return this;
	}

	public Einheit getEinheit() {
		return einheit;
	}

	public Position setEinheit(Einheit einheit) {
		this.einheit = einheit;
		return this;
	}

	public Vorgangsstatus getVorgangsstatus() {
		return vorgangsstatus;
	}

	public Position setVorgangsstatus(Vorgangsstatus vorgangsstatus) {
		this.vorgangsstatus = vorgangsstatus;
		return this;
	}

}
