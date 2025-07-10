package tests;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 *     Files: Daten können dauerhaft gespeichert werden.
 *     Textdateien: Text, Json, CSV, Konfigurationen (chars)
 *     Bilddateien: jpg, gif, ...(bytes)
 *     Objektdateien: new Marmelade (java objects)
 *
 *
 *     Diese Klasse demonstiert die kommunikation mit dem Dateisystem.
 *     package: java.io. (java.nio)
 * </pre>
 */
public class ErsterDateiZugriff {
    public static void main(String[] args) throws IOException {
        System.out.println("Anfang\n");

        File ersteDatei = new File("test-text");
        System.out.println("ist das File-Objekt da?" +  (ersteDatei != null) );
        System.out.println("Gib es die Datei im Datei im Dateisystem?" + ersteDatei.exists());
        boolean wurdeAngelegt = ersteDatei.createNewFile();
        System.out.println("Gib es die Datei im Dateisystem?" + ersteDatei.exists());
        System.out.println("Wurde eine neue Datei angelegt?" + wurdeAngelegt);
        boolean wurdeGeloescht = ersteDatei.delete();
        System.out.println("Exists die datei?" + wurdeGeloescht);

        File infoDatei = new File("infos/info1.");
        System.out.println("Existiert datei " + infoDatei +" ?" + infoDatei.exists());

        File infoVerzeichnis = new File("infos");
        infoVerzeichnis.mkdir();
        System.out.println(infoVerzeichnis + " isz ein Verzeichnis: " +  infoVerzeichnis.isDirectory());
        infoDatei.createNewFile();
        System.out.println( infoDatei + " ist ein Verzeichnis: " + infoDatei.isDirectory());

        File xampp = new File("C:\\xampp");
        System.out.println("Absoluter Pfad? " + xampp.isAbsolute());
        xampp.delete();//Nur leere Verszeichnisse können gelöscht werden
        File[] inXampp = xampp.listFiles();
        for (int i = 0; i < inXampp.length; i++) {
            if(inXampp[i].isFile()){
                System.out.println("Datei: " + inXampp[i]);
            }else {
                System.out.println("Verzeichnis: " + inXampp[i]);
            }
        }
        boolean loeschenErfolgreich = infoVerzeichnis.delete();
        System.out.println("infoVerzeichnis.delete(): " + loeschenErfolgreich);
        loeschenErfolgreich = infoDatei.delete();
        System.out.println("infoDatei.delete(): " +loeschenErfolgreich);


        System.out.println("\nEnde");

    }
}
