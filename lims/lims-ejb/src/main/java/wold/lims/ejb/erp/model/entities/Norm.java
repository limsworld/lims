package wold.lims.ejb.erp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import wold.lims.ejb.base.model.base.AbstractEntityUserUniqueNameLang;

@Entity
@Table(name = "NORM", schema = "ERP")
public class Norm extends AbstractEntityUserUniqueNameLang {

	private static final long serialVersionUID = -2402266676761874205L;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "normen")
	protected List<Artikel> artikels = new ArrayList<Artikel>();

	public Norm setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

	public Norm setName(String name) {
		this.name = name;
		return this;
	}

	public List<Artikel> getArtikels() {
		return artikels;
	}

	public Norm setArtikels(List<Artikel> artikels) {
		this.artikels = artikels;
		return this;
	}

	public Norm addArtikel(Artikel artikel) {
		artikels.add(artikel);
		return this;
	}

}
