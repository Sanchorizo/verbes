package hb.fr.verbe.business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question {

	private long id;
	private String reponsePreterit;
	private String reponseParticicpePasse;
	private LocalDateTime dateHeureEnvoi;
	private LocalDateTime dateHeureReponse;
	public static long compteur = 0L;
	private Partie partie;
	private Verbe verbe;
	
	
	public Question() {
		id= ++compteur;
		dateHeureEnvoi = LocalDateTime.now();
	}
	
	public Question(String reponsePreterit, String reponseParticicpePasse,
			LocalDateTime dateHeureReponse) {
		this();
		this.reponsePreterit = reponsePreterit;
		this.reponseParticicpePasse = reponseParticicpePasse;
		this.dateHeureReponse = dateHeureReponse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReponsePreterit() {
		return reponsePreterit;
	}

	public void setReponsePreterit(String reponsePreterit) {
		this.reponsePreterit = reponsePreterit;
	}

	public String getReponseParticicpePasse() {
		return reponseParticicpePasse;
	}

	public void setReponseParticicpePasse(String reponseParticicpePasse) {
		this.reponseParticicpePasse = reponseParticicpePasse;
	}

	public LocalDateTime getDateHeureEnvoi() {
		return dateHeureEnvoi;
	}

	public void setDateHeureEnvoi(LocalDateTime dateHeureEnvoi) {
		this.dateHeureEnvoi = dateHeureEnvoi;
	}

	public LocalDateTime getDateHeureReponse() {
		return dateHeureReponse;
	}

	public void setDateHeureReponse(LocalDateTime dateHeureReponse) {
		this.dateHeureReponse = dateHeureReponse;
	}

	public static long getCompteur() {
		return compteur;
	}

	public static void setCompteur(long compteur) {
		Question.compteur = compteur;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Verbe getVerbe() {
		return verbe;
	}

	public void setVerbe(Verbe verbe) {
		this.verbe = verbe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateHeureEnvoi, dateHeureReponse, id, partie, reponseParticicpePasse, reponsePreterit,
				verbe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(dateHeureEnvoi, other.dateHeureEnvoi)
				&& Objects.equals(dateHeureReponse, other.dateHeureReponse) && id == other.id
				&& Objects.equals(partie, other.partie)
				&& Objects.equals(reponseParticicpePasse, other.reponseParticicpePasse)
				&& Objects.equals(reponsePreterit, other.reponsePreterit) && Objects.equals(verbe, other.verbe);
	}

	
	
	


	
	
	
}
