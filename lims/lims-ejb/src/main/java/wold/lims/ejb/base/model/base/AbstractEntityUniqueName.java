package wold.lims.ejb.base.model.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntityUniqueName extends AbstractEntityBase {

	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", length = 120)
    protected String name;

	public String getName() {
		return name;
	}

	public AbstractEntityUniqueName setName(String name) {
		this.name = name;
		return this;
	}

}
