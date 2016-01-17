package testfichier;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Etudiant {
	
	private String _matricule;
	private String _nom;
	private String _prenom;
	private Date _date;
	private int _niveau;
	private String _email;
	private String _contact;
	private List<Etudiant> _listF ;
	private Boolean _estParrain;
	
	/*
	 * Constructeur
	 * 
	 */
	public Etudiant(String nom, String prenoms ){
		
		this.set_nom(nom);
		this.set_prenom(prenoms);
		
		this.set_estParrain(false);
		
		this.set_listF(new ArrayList<Etudiant>());
	}
	
	
	public String get_nom() {
		return _nom;
	}
	public void set_nom(String _nom) {
		this._nom = _nom;
	}
	public String get_prenom() {
		return _prenom;
	}
	public void set_prenom(String _prenom) {
		this._prenom = _prenom;
	}
	public Date get_date() {
		return _date;
	}
	public void set_date(Date _date) {
		this._date = _date;
	}
	public int get_niveau() {
		return _niveau;
	}
	public void set_niveau(int _niveau) {
		this._niveau = _niveau;
	}
	public String get_email() {
		return _email;
	}
	public void set_email(String _email) {
		this._email = _email;
	}
	public String get_contact() {
		return _contact;
	}
	public void set_contact(String _contact) {
		this._contact = _contact;
	}


	public String get_matricule() {
		return _matricule;
	}


	public void set_matricule(String _matricule) {
		this._matricule = _matricule;
	}


	public Boolean get_estParrain() {
		return _estParrain;
	}


	public void set_estParrain(Boolean _estParrain) {
		this._estParrain = _estParrain;
	}


	public List<Etudiant> get_listF() {
		return _listF;
	}


	public void set_listF(List<Etudiant> _listF) {
		this._listF = _listF;
	}
	
	
	
}


