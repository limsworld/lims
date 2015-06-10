package wold.lims.ejb.erp.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import wold.lims.ejb.base.model.base.AbstractEntityUniqueName;
import wold.lims.ejb.base.model.entities.Geschaeftsbereich;

@Entity
@Table(name = "KONTAKT", schema = "ERP",
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class Kontakt extends AbstractEntityUniqueName {

	private static final long serialVersionUID = 6942489550552489754L;

	@ManyToOne
	@JoinColumn(name = "ADRESSE_ID")	
	protected Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "PERSON_ID")	
	protected Person person;

	@ManyToOne
	@JoinColumn(name = "GESCHAEFTSBEREICH_ID")	
	protected Geschaeftsbereich geschaeftsbereich;

	@Column(name = "FUNKTION_ID", length = 40)
	protected String funktion;

	@Column(name = "FORMATTIERTEADRESSE", length = 240)
	protected String formattierteadresse;

	@PrePersist
	public void onCreate() {
		Date tmpDate = new Date();
		created = tmpDate;
		updated = tmpDate;
		aktiv = true;
		createName();
	}

	@PreUpdate
	public void onUpdate() {
		updated = new Date();
		createName();
	}
	
	public void createName() {
		name = getBlankIsNull(adresse.getName()) 
			+ " "+ getBlankIsNull(person.getName());
		name = name.toUpperCase();
	}

	public String getBlankIsNull(String value) {
		if (value == null)
			return "";
		return value;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public Kontakt setAdresse(Adresse adresse) {
		this.adresse = adresse;
		return this;
	}

	public Person getPerson() {
		return person;
	}

	public Kontakt setPerson(Person person) {
		this.person = person;
		return this;
	}

	public String getFormattierteadresse() {
		return formattierteadresse;
	}

	public Kontakt setFormattierteadresse(String formattierteadresse) {
		this.formattierteadresse = formattierteadresse;
		return this;
	}

	public String getFunktion() {
		return funktion;
	}

	public Kontakt setFunktion(String funktion) {
		this.funktion = funktion;
		return this;
	}

	public Geschaeftsbereich getGeschaeftsbereich() {
		return geschaeftsbereich;
	}

	public Kontakt setGeschaeftsbereich(Geschaeftsbereich geschaeftsbereich) {
		this.geschaeftsbereich = geschaeftsbereich;
		return this;
	}

}
