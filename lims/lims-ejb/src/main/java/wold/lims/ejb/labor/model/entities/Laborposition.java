package wold.lims.ejb.labor.model.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import wold.lims.ejb.base.model.entities.User;
import wold.lims.ejb.erp.model.entities.Eingangsbestellposition;
import wold.lims.ejb.erp.model.entities.Einheit;
import wold.lims.ejb.erp.model.entities.Produktionsposition;
import wold.lims.ejb.erp.model.entities.Vorgang;
import wold.lims.ejb.erp.model.entities.Vorgangsstatus;

@Entity
@DiscriminatorValue("LABORPOSITION")
@Table(name = "LABORPOSITION", schema = "LABOR")
public class Laborposition extends Produktionsposition {

	private static final long serialVersionUID = -536659487482188570L;

	public Laborposition setVorgang(Vorgang vorgang) {
		this.vorgang = vorgang;
		return this;
	}

	public Laborposition setUser(User user) {
		this.user = user;
		return this;
	}

	public Labormethode getLabormethode() {
		if  (this.artikel != null)
			return (Labormethode)this.artikel;
		return null;
	}

	public Laborposition setLabormethode(Labormethode labormethode) {
		this.artikel = labormethode;
		return this;
	}

	public Eingangsbestellposition getEingangsbestellposition() {
		return eingangsbestellposition;
	}

	public Laborposition setEingangsbestellposition(
			Eingangsbestellposition eingangsbestellposition) {
		this.eingangsbestellposition = eingangsbestellposition;
		return this;
	}

	public Laborposition setVorgangsstatus(Vorgangsstatus vorgangsstatus) {
		this.vorgangsstatus = vorgangsstatus;
		return this;
	}

	public Produktionsposition getProduktionsposition() {
		return this;
	}

	public Produktionsposition setEinheit(Einheit einheit) {
		this.einheit = einheit;
		return this;
	}

}
