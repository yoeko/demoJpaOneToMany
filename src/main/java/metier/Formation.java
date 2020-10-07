package metier;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Formation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private String theme;
	@OneToMany
	private Collection<Formateur> formateurs;

	public Formation(String theme, Collection<Formateur> formateurs) {
		super();
		this.theme = theme;
		this.formateurs = formateurs;
	}
	
	public Formation(String theme) {
		super();
		this.theme = theme;
		this.formateurs = new HashSet<Formateur>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Collection<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(Collection<Formateur> formateurs) {
		this.formateurs = formateurs;
	}	
	

}
