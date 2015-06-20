package wold.lims.ejb.erp.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import wold.lims.ejb.base.model.base.AbstractEntityUniqueName;
import wold.lims.ejb.base.model.entities.SystemUser;

@Entity
@Table(name = "PERSON", schema = "ERP",
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class Person extends AbstractEntityUniqueName {

	private static final long serialVersionUID = 8952400188688218101L;

	@ManyToOne
	@JoinColumn(name = "GESCHLECHT_ID")	
	protected Geschlecht geschlecht;

	@ManyToOne
	@JoinColumn(name = "USER_ID")	
	protected SystemUser user;

	@OneToMany(mappedBy = "person")
	protected List<Kontakt> kontakte = new ArrayList<Kontakt>();

	@ManyToOne
	@JoinColumn(name = "PERSONENBEZIEHUNG_ID")	
	protected Personenbeziehung personenbeziehung;

	@Column(name = "TITEL", length = 20)
	protected String titel;

	@Column(name = "VORNAME", length = 20)
	protected String vorname;

	@Column(name = "NACHNAME", length = 20)
	protected String nachname;

	@Column(name = "LEDIGENNAME", length = 20)
	protected String ledigenname;

	@Column(name = "ZUSATZNAME", length = 255)
	protected String zusatzname;

	@Column(name = "BIRTHDAY")
	@Temporal(TemporalType.DATE)
	protected Date birthday;

	@NotNull
	@Column(name = "ZUSATZNAMENVERWENDEN", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean zusatznamenverwenden;

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
		name = getBlankIsNull(nachname).toUpperCase()
			+ " " + getBlankIsNull(vorname).toUpperCase();
	}

	public String getBlankIsNull(String value) {
		if (value == null)
			return "";
		return value;
	}

	public Geschlecht getGeschlecht() {
		return geschlecht;
	}

	public Person setGeschlecht(Geschlecht geschlecht) {
		this.geschlecht = geschlecht;
		return this;
	}

	public String getTitel() {
		return titel;
	}

	public Person setTitel(String titel) {
		this.titel = titel;
		return this;
	}

	public String getVorname() {
		return vorname;
	}

	public Person setVorname(String vorname) {
		this.vorname = vorname;
		return this;
	}

	public String getNachname() {
		return nachname;
	}

	public Person setNachname(String nachname) {
		this.nachname = nachname;
		return this;
	}

	public String getLedigenname() {
		return ledigenname;
	}

	public Person setLedigenname(String ledigenname) {
		this.ledigenname = ledigenname;
		return this;
	}

	public String getZusatzname() {
		return zusatzname;
	}

	public Person setZusatzname(String zusatzname) {
		this.zusatzname = zusatzname;
		return this;
	}

	public Date getBirthday() {
		return birthday;
	}

	public Person setBirthday(Date birthday) {
		this.birthday = birthday;
		return this;
	}

	public boolean isZusatznamenverwenden() {
		return zusatznamenverwenden;
	}

	public Person setZusatznamenverwenden(boolean zusatznamenverwenden) {
		this.zusatznamenverwenden = zusatznamenverwenden;
		return this;
	}

	public SystemUser getUser() {
		return user;
	}

	public Person setUser(SystemUser user) {
		this.user = user;
		return this;
	}

	public List<Kontakt> getKontakte() {
		return kontakte;
	}

	public Person setKontakte(List<Kontakt> kontakte) {
		this.kontakte = kontakte;
		return this;
	}

	public Personenbeziehung getPersonenbeziehung() {
		return personenbeziehung;
	}

	public Person setPersonenbeziehung(Personenbeziehung personenbeziehung) {
		this.personenbeziehung = personenbeziehung;
		return this;
	}

}
