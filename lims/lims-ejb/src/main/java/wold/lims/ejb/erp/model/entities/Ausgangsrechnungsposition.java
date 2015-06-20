package wold.lims.ejb.erp.model.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wold.lims.ejb.base.model.entities.SystemUser;

@Entity
@DiscriminatorValue("AUSGANGSRECHNUNGSPOSITION")
@Table(name = "AUSGANGSRECHNUNGSPOSITION", schema = "ERP")
public class Ausgangsrechnungsposition extends Position {

	private static final long serialVersionUID = -6375901874538555205L;

	@ManyToOne
	@JoinColumn(name = "AUSGANGSLIEFERSCHEINPOSITION_ID")	
	protected Ausgangslieferscheinposition ausgangslieferscheinposition;

	public Ausgangsrechnungsposition setVorgang(Vorgang vorgang) {
		this.vorgang = vorgang;
		return this;
	}

	public Ausgangsrechnungsposition setUser(SystemUser user) {
		this.user = user;
		return this;
	}

	public Ausgangsrechnungsposition setArtikel(Artikel artikel) {
		this.artikel = artikel;
		return this;
	}

	public Ausgangsrechnungsposition setPreis(double preis) {
		this.preis = preis;
		return this;
	}

	public Ausgangslieferscheinposition getAusgangslieferscheinposition() {
		return ausgangslieferscheinposition;
	}

	public Ausgangsrechnungsposition setAusgangslieferscheinposition(
			Ausgangslieferscheinposition ausgangslieferscheinposition) {
		this.ausgangslieferscheinposition = ausgangslieferscheinposition;
		return this;
	}

}
