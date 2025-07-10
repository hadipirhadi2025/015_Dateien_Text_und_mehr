package de.meinlade.persistenz.pojos;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Organisiert den Ablauf des Programms
 * Hier werden Klasen instaziiert, Methode aufgerufen für
 * zb Benutzerinteraktion (GUI/MeineApp/ConsoleUI/System.out/System.in)
 * zb Datenbankinteraktion (Datenbankzugriff)
 * zb Datenverarbeitung (MarmeladeService)
 * zb DateiInteraktion (DateiZugriff)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Das Programm wird gestartet um " + LocalTime.now() + " Uhr ---\n");

        File texte = new File("texte") ;
        File bilder = new File("bilder") ;
        File objekte = new File("objekte") ;

        texte.mkdir();
        bilder.mkdir();
        objekte.mkdir();

        DateiZugriff james = new DateiZugriff();

        File fileMitUhrzeit = new File("texte/Uhrzeiz.txt");
        String textMitUhrzeit = "Aktuell is es " + LocalTime.now() ;
        //james.einfachScreiben(fileMitUhrzeit, textMitUhrzeit);
        james.besserSchreiben(fileMitUhrzeit, textMitUhrzeit);
        String gelesenAusDatei = james.lesenVonText(fileMitUhrzeit);
        System.out.println(gelesenAusDatei);
        System.out.println("\n --------------- " + LocalTime.now() + "--------------------");
        File bild = new File("bilder/my.png");
        File bildKopie1 = new File("bilder/newcopy.png");
        //  james.einfachKopieren(bild, bildKopie1);
        System.out.println("----- Kopieren um: " + LocalTime.now() + "--------------");
        james.besserKopieren(bild, new File("bilder/bestecopy.png"));
        System.out.println("--------- Jetzt kochen wir Marmelade und speichern die -----");
        Marmelade neueMarmelade = new Marmelade("Lakritz mit Banane", 95, LocalDate.now());
        File marmeladenSpeicher = new File("objekte/Lecker.marmelade");
        System.out.println(neueMarmelade);
        james.speichernMarmelade(marmeladenSpeicher, neueMarmelade);
        System.out.println("--- Das Programm endet um " + LocalTime.now() + " Uhr ---\n");
    }
}
