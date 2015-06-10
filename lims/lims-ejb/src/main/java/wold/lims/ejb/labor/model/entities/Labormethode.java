package wold.lims.ejb.labor.model.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import wold.lims.ejb.base.model.entities.User;
import wold.lims.ejb.erp.model.entities.Artikel;
import wold.lims.ejb.erp.model.entities.Einheit;
import wold.lims.ejb.erp.model.entities.Norm;

@Entity
@DiscriminatorValue("LABORMETHODE")
@Table(name = "LABORMETHODE", schema = "LABOR")
public class Labormethode extends Artikel {

	private static final long serialVersionUID = -959237236838385067L;

	@NotNull
	@Column(name = "JAHRESMITTELWERT", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean jahresmittelwert;

	@NotNull
	@Column(name = "AKKREDITIERT", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean akkreditiert;

	public Labormethode setVerwenden(boolean verwenden) {
		this.verwenden = verwenden;
		return this;
	}

	public Labormethode setPreisausgeben(boolean preisausgeben) {
		this.preisausgeben = preisausgeben;
		return this;
	}

	public Labormethode setName(String name) {
		this.name = name;
		return this;
	}

	public Labormethode setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

	public Labormethode setUser(User user) {
		this.user = user;
		return this;
	}

	public Labormethode setPreis(double preis) {
		this.preis = preis;
		return this;
	}

	public Labormethode addNormen(Norm norm) {
		normen.add(norm);
		return this;
	}

	public Labormethode setNummer(String nummer) {
		this.nummer = nummer;
		return this;
	}

	public Labormethode addUebergeordnet(Labormethode methode) {
		artikels.add(methode);
		return this;
	}

	public boolean isJahresmittelwert() {
		return jahresmittelwert;
	}

	public Labormethode setJahresmittelwert(boolean jahresmittelwert) {
		this.jahresmittelwert = jahresmittelwert;
		return this;
	}

	public boolean isAkkreditiert() {
		return akkreditiert;
	}

	public Labormethode setAkkreditiert(boolean akkreditiert) {
		this.akkreditiert = akkreditiert;
		return this;
	}

	public Labormethode setEinheit(Einheit einheit) {
		this.einheit = einheit;
		return this;
	}
}
