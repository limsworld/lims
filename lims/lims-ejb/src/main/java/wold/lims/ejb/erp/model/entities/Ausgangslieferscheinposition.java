package wold.lims.ejb.erp.model.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wold.lims.ejb.base.model.entities.User;

@Entity
@DiscriminatorValue("AUSGANGSLIEFERSCHEINPOSITION")
@Table(name = "AUSGANGSLIEFERSCHEINPOSITION", schema = "ERP")
public class Ausgangslieferscheinposition extends Position {

	private static final long serialVersionUID = 6394561424983807330L;

	@ManyToOne
	@JoinColumn(name = "PRODUKTIONSPOSITION_ID")	
	protected Produktionsposition produktionsposition;

	public Ausgangslieferscheinposition setVorgang(Vorgang vorgang) {
		this.vorgang = vorgang;
		return this;
	}

	public Ausgangslieferscheinposition setUser(User user) {
		this.user = user;
		return this;
	}

	public Ausgangslieferscheinposition setArtikel(Artikel artikel) {
		this.artikel = artikel;
		return this;
	}

	public Ausgangslieferscheinposition setPreis(double preis) {
		this.preis = preis;
		return this;
	}

	public Ausgangslieferscheinposition setEinheit(Einheit einheit) {
		this.einheit = einheit;
		return this;
	}

	public Produktionsposition getProduktionsposition() {
		return produktionsposition;
	}

	public void setProduktionsposition(Produktionsposition produktionsposition) {
		this.produktionsposition = produktionsposition;
	}

}
