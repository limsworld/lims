package wold.lims.ejb.lab.model.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import wold.lims.ejb.base.model.base.AbstractEntityIdNameLabel;
import wold.lims.ejb.lab.util.LangUtil;

@Entity
@Table(name = "ANALYSIS_REQUEST_STATES", schema = "LAB",
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@NamedQueries({
	@NamedQuery(name = "AnalysisRequestState", 
		query = "SELECT a FROM AnalysisRequestState a WHERE a.name = :name") })
public class AnalysisRequestState extends AbstractEntityIdNameLabel {

	private static final long serialVersionUID = -7153839942970222283L;

	public AnalysisRequestState setName(String name) {
		this.name = name;
		return this;
	}

	public AnalysisRequestState setText(String text) {
		this.text = text;
		return this;
	}

	public String getLabel(String lang) {
		return LangUtil.value(lang, getText());
	}

}
