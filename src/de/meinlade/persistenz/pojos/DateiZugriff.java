package de.meinlade.persistenz.pojos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * <pre>
 *     Demonistiert Lesen aus und Schreiben in Dateien.
 *
 *     Dateien die Text(Unicode) enthalten: Reader und Writer
 *     Datein die anderes (Bytes) enthakten : Inputstream und OutputStream
 * </pre>
 *
 */
public class DateiZugriff {

    /**
     * In einer Datei hinein soll Text/String/Ubicode geschrieben werden
     * Scheiben/Lesevorgäne "blockieren" eine Datei: Eine Resource wird beanspruch->
     * Resourcen müssen freigeben werden -> close->
     *       try-with-resources
     * Writer schreibt Text in ein Ziel, hier das Objekt FileWriter schreibt in eine Datei
     *
     * Writer: autoClosable, autoFlushable
     * -> close ruf flush -> flush ruf createNewFile
     * new FileWriter(ziel) -> offnet Datei um den Inhalt zu lösen und nuen Inhalt zu schreiben
     * new FileWriter(ziel, false) -> offnet Datei um den Inhalt zu lösen und nuen Inhalt zu schreiben
     * new FileWriter(ziel, true) -> Neuer Inhalt wird ans Ende der Datei geschrieben
     * @param ziel dahin wird geschrieben
     * @param text das wird geschrieben
     */
    public void einfachScreiben(File ziel, String text){
        try (Writer schreiber = new FileWriter(ziel, true)){
            schreiber.write(text);
        }catch (IOException schreibAusnahme){
            System.out.println("Fehler bei schreiben " + schreibAusnahme.getMessage() );
            schreibAusnahme.printStackTrace();
        }
    }
}
