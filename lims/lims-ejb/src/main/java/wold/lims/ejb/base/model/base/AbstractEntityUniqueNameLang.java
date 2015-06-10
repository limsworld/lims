package wold.lims.ejb.base.model.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntityUniqueNameLang extends AbstractEntityBase {

	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", length = 120)
    protected String name;
	
	@Column(name = "BEZEICHNUNG", length = 240)
    protected String bezeichnung;

	public String getBezeichnung() {
		return bezeichnung;
	}

	public AbstractEntityUniqueNameLang setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

	public String getName() {
		return name;
	}

	public AbstractEntityUniqueNameLang setName(String name) {
		this.name = name;
		return this;
	}

}
