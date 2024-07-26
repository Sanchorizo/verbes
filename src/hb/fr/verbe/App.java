package hb.fr.verbe;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import hb.fr.verbe.business.Partie;
import hb.fr.verbe.business.Question;
import hb.fr.verbe.business.Verbe;

public class App {

	public static Scanner scanner = new Scanner(System.in);
	public static List<Verbe> verbes = new ArrayList<>();
	public static List<Question> questions = new ArrayList<>();
	public static Partie partie = new Partie();
	public static List<Verbe> verbesSelectionnes = new ArrayList<>();

	public static void main(String[] args) {

		lancerPartie();

	}

	public static void importerDonnee(String nomFichier) {
		File file = new File(nomFichier);

		if (!file.exists()) {
			System.out.println("Fichier CSV indisponible");
			System.exit(1);
		}

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(file.toURI().toURL().openStream()));
			// System.out.println("ligne d'entête : " + reader.readLine());
			String ligne = null;
			while ((ligne = reader.readLine()) != null) {

				String[] elements = ligne.split(",");
				Verbe verbe = new Verbe();
				verbe.setBaseVerbale(elements[1].replace("\"", ""));
				verbe.setPreterit(elements[3].replace("\"", ""));
				verbe.setParticipePasse(elements[2].replace("\"", ""));
				verbe.setTraduction(elements[4].replace("\"", ""));
				verbes.add(verbe);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void lancerPartie() {
		importerDonnee("src/hb/fr/verbe/verbes.csv");

		System.out.println("Bienvenue sur les verbes irréguliers!");
		int cbIrregulier = verbes.size();
		System.out.println("Nombre de verbes irréguliers disponibles: " + cbIrregulier);
		System.out.println("Combien de verbes pour cette partie ?");
		int nbVerbe = scanner.nextInt();
		melangerQuestion();
		creationQuestion(nbVerbe);
		poserQuestion();
		System.out.println("Souhaitez vous lancer une nouvelle partie ?  O/N");
		String replay = scanner.next();
		if (replay.equals("O")) {
			verbes.clear();
			verbesSelectionnes.clear();
			questions.clear();
			partie.setScore(0);
			lancerPartie();

		}else {
			System.out.println("Merci d'avoir joué!");
		}

	}

	public static void melangerQuestion() {

		Collections.shuffle(verbes);
	}

	public static void creationQuestion(int nbVerbe) {
		partie.setNbQuestionsSouhaitees(nbVerbe);
		for (int i = 0; i < nbVerbe; i++) {
			verbesSelectionnes.add(verbes.get(i));
			Question question = new Question();
			question.setVerbe(verbes.get(i));
			verbes.remove(verbes.get(i));
			questions.add(question);
		}
		partie.setQuestions(questions);
	}

	public static void poserQuestion() {
		int compteurQuestion = 0;
		double tempsReponse = 0;

		for (Question question : questions) {
			System.out.println("Donnez le preterit et le participe passé du verbe "
					+ question.getVerbe().getBaseVerbale() + " (" + question.getVerbe().getTraduction() + ").");
			Instant debut = Instant.now();

			String reponse = scanner.next();
			String[] reponses = reponse.split(",");
			question.setReponsePreterit(reponses[0]);
			question.setReponseParticicpePasse(reponses[1]);
			Instant fin = Instant.now();
			tempsReponse += (fin.toEpochMilli() - debut.toEpochMilli());
			compteurQuestion++;
			System.out.println(debut +" "+ fin);
			
			System.out.println(question.getVerbe().getPreterit() + question.getVerbe().getParticipePasse());
			System.out.println(question.getReponsePreterit()+ question.getReponseParticicpePasse());

			if (question.getReponsePreterit().compareTo(question.getVerbe().getPreterit())== 0
					&& question.getReponseParticicpePasse().compareTo(question.getVerbe().getParticipePasse()) ==0) {
				partie.setScore(partie.getScore() + 1);
				System.out.println("Bravo! Score:" + partie.getScore() +  "/" + compteurQuestion);
			}else {
				System.out.println("Bouff! Score:" + partie.getScore() + "/" + compteurQuestion);

			}
		}
		System.out.println("Temps de réponse moyen: " + tempsReponse/questions.size());
		
			
}
}
