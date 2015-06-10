package wold.lims.ejb.erp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import wold.lims.ejb.base.model.base.AbstractEntityUniqueNameLang;

@Entity
@Table(name = "ARTIKELGRUPPE", schema = "ERP")
public class Artikelgruppe extends AbstractEntityUniqueNameLang {

	private static final long serialVersionUID = -1125999259406088174L;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "artikelgruppen")
	protected List<Artikel> artikels = new ArrayList<Artikel>();

	public Artikelgruppe setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

	public List<Artikel> getArtikels() {
		return artikels;
	}

	public Artikelgruppe setArtikels(List<Artikel> artikels) {
		this.artikels = artikels;
		return this;
	}

	public Artikelgruppe addArtikelGruppe(Artikel artikel) {
		artikels.add(artikel);
		return this;
	}

}
