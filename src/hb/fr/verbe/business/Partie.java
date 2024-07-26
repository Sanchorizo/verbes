package hb.fr.verbe.business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Partie {


	private long id;
	private int nbQuestionsSouhaitees;
	private int score = 0;
	public static long compteur = 0L;
	private List<Question> questions = new ArrayList<>();
	
	public Partie() {
		id= ++compteur;
		score = 0;
	}
	
	
	public Partie(int nbQuestionsSouhaitees, List<Question> questions) {
		this();
		this.nbQuestionsSouhaitees = nbQuestionsSouhaitees;
		this.questions = questions;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getNbQuestionsSouhaitees() {
		return nbQuestionsSouhaitees;
	}


	public void setNbQuestionsSouhaitees(int nbQuestionsSouhaitees) {
		this.nbQuestionsSouhaitees = nbQuestionsSouhaitees;
	}



	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public static long getCompteur() {
		return compteur;
	}


	public static void setCompteur(long compteur) {
		Partie.compteur = compteur;
	}


	public List<Question> getQuestions() {
		return questions;
	}


	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, nbQuestionsSouhaitees, questions, score);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partie other = (Partie) obj;
		return id == other.id && nbQuestionsSouhaitees == other.nbQuestionsSouhaitees
				&& Objects.equals(questions, other.questions) && score == other.score;
	}


	@Override
	public String toString() {
		return "Partie [id=" + id + ", nbQuestionsSouhaitees=" + nbQuestionsSouhaitees + ", score=" + score
				+ ", questions=" + questions + "]";
	}
	
	
	
	
	
}
