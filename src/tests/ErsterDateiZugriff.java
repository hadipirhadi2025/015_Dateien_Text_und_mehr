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
        ersteDatei.createNewFile();
        System.out.println("Gib es die Datei im Dateisystem?" + ersteDatei.exists());

        System.out.println("\nEnde");

    }
}
