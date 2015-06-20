package wold.lims.ejb.erp.model.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import wold.lims.ejb.base.model.entities.SystemUser;

@Entity
@DiscriminatorValue("EINGANGSBESTELLUNGSPOSITION")
@Table(name = "EINGANGSBESTELLUNGSPOSITION", schema = "ERP")
public class Eingangsbestellposition extends Position {

	private static final long serialVersionUID = 999233605133424810L;

	public Eingangsbestellposition setVorgang(Vorgang vorgang) {
		this.vorgang = vorgang;
		return this;
	}

	public Eingangsbestellposition setUser(SystemUser user) {
		this.user = user;
		return this;
	}

	public Eingangsbestellposition setArtikel(Artikel artikel) {
		this.artikel = artikel;
		return this;
	}

	public Eingangsbestellposition setPreis(double preis) {
		this.preis = preis;
		return this;
	}

	public Eingangsbestellposition setVorgangsstatus(Vorgangsstatus vorgangsstatus) {
		this.vorgangsstatus = vorgangsstatus;
		return this;
	}

	public Eingangsbestellposition setEinheit(Einheit einheit) {
		this.einheit = einheit;
		return this;
	}

}
