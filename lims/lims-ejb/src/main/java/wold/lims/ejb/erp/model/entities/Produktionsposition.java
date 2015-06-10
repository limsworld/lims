package wold.lims.ejb.erp.model.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wold.lims.ejb.base.model.entities.User;

@Entity
@DiscriminatorValue("PRODUKTIONSPOSITION")
@Table(name = "PRODUKTIONSPOSITION", schema = "ERP")
public class Produktionsposition extends Position {

	private static final long serialVersionUID = 6394561424983807330L;

	@ManyToOne
	@JoinColumn(name = "EINGANGSBESTELLPOSITION_ID")	
	protected Eingangsbestellposition eingangsbestellposition;

	public Produktionsposition setVorgang(Vorgang vorgang) {
		this.vorgang = vorgang;
		return this;
	}

	public Produktionsposition setUser(User user) {
		this.user = user;
		return this;
	}

	public Produktionsposition setArtikel(Artikel artikel) {
		this.artikel = artikel;
		return this;
	}

	public Produktionsposition setPreis(double preis) {
		this.preis = preis;
		return this;
	}

	public Produktionsposition setEinheit(Einheit einheit) {
		this.einheit = einheit;
		return this;
	}

	public Eingangsbestellposition getEingangsbestellposition() {
		return eingangsbestellposition;
	}

	public Produktionsposition setEingangsbestellposition(
			Eingangsbestellposition eingangsbestellposition) {
		this.eingangsbestellposition = eingangsbestellposition;
		return this;
	}

}
