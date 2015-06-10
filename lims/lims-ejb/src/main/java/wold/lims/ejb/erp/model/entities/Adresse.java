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

import wold.lims.ejb.base.model.base.AbstractEntityUniqueName;

@Entity
@Table(name = "ADRESSE", schema = "ERP")
public class Adresse extends AbstractEntityUniqueName {

	private static final long serialVersionUID = 2319126841283984205L;

	@ManyToOne
	@JoinColumn(name = "PARTNER_ID")	
	protected Partner partner;

	@OneToMany(mappedBy = "adresse")
	protected List<Kontakt> kontakte = new ArrayList<Kontakt>();

	@Column(length = 120)
	protected String firma;

	@Column(length = 40)
	protected String strasse;

	@Column(length = 40)
	protected String zusatz;

	@Column(length = 10)
	protected String plz;

	@Column(length = 20)
	protected String ort;

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
		name = getBlankIsNull(firma)
			+ " "+ getBlankIsNull(strasse)
			+ " "+ getBlankIsNull(plz)
			+ " "+ getBlankIsNull(ort);
		name = name.toUpperCase();
	}

	public String getBlankIsNull(String value) {
		if (value == null)
			return "";
		return value;
	}

	public String getFirma() {
		return firma;
	}

	public Adresse setFirma(String firma) {
		this.firma = firma;
		return this;
	}

	public String getPlz() {
		return plz;
	}

	public Adresse setPlz(String plz) {
		this.plz = plz;
		return this;
	}

	public String getOrt() {
		return ort;
	}

	public Adresse setOrt(String ort) {
		this.ort = ort;
		return this;
	}

	public Partner getPartner() {
		return partner;
	}

	public Adresse setPartner(Partner partner) {
		this.partner = partner;
		return this;
	}

	public String getStrasse() {
		return strasse;
	}

	public Adresse setStrasse(String strasse) {
		this.strasse = strasse;
		return this;
	}

	public String getZusatz() {
		return zusatz;
	}

	public Adresse setZusatz(String zusatz) {
		this.zusatz = zusatz;
		return this;
	}

	public List<Kontakt> getKontakte() {
		return kontakte;
	}

	public Adresse setKontakte(List<Kontakt> kontakte) {
		this.kontakte = kontakte;
		return this;
	}

}
