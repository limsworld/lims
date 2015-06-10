package wold.lims.ejb.erp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wold.lims.ejb.base.model.base.AbstractEntityBase;

@Entity
@Table(name = "PARTNER", schema = "ERP")
public class Partner extends AbstractEntityBase {

	private static final long serialVersionUID = -4932218921564154425L;

	@OneToMany(mappedBy = "partner")
	protected List<Adresse> adressen = new ArrayList<Adresse>();

	public List<Adresse> getAdressen() {
		return adressen;
	}

	public Partner setAdressen(List<Adresse> adressen) {
		this.adressen = adressen;
		return this;
	}

}
