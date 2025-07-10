package de.meinlade.persistenz.pojos;

import java.io.*;
import java.net.PortUnreachableException;

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

    /**
     * <pre>
     *     new BufferedWritter(schreiber): Dekorieren eines bestehenden Objekts
     *     ButteredWriter kann mehr.
     *     Batenströme sind mir Decorator Design Pattern organisiert;
     *     Im Konstruktur der Kindklasse muss ein Objekt edr Elternklasse übergeben werden.
     *     Buchempfehlung : Head First
     *     Totorial: Tutorisls Point Design Pattern
     * </pre>
     * @param ziel Datei
     * @param text der Text
     */
    public void besserSchreiben(File ziel, String text){
        try(Writer schreiber = new FileWriter(ziel,true);
            BufferedWriter besserSchreiber = new BufferedWriter(schreiber)){
            besserSchreiber.newLine();
            besserSchreiber.write(text);

        }catch(IOException schreibAusnahme){
            System.out.println("Fehler bei schreiben " + schreibAusnahme.getMessage() );
            schreibAusnahme.printStackTrace();
        }
    }

    /**
     * besssserLesser.readLine(); gibt zurück die nächste gelesene Zeile oder null am Ende der Datei
     * @param quelle Datei
     * @return
     */
    public String lesenVonText(File quelle){
      String ruechgabe = "";

      try(Reader leser = new FileReader(quelle);
          BufferedReader besserLeser = new BufferedReader(leser)
      ){

          while (true){
              String geleseneZeile = besserLeser.readLine();

              if(geleseneZeile==null){
                  break;
              }
              ruechgabe += geleseneZeile+ " \n" ;
          }
      }catch(IOException leseAusnahme){
          System.out.println("Fehler bei lese :" + leseAusnahme.getMessage());
          leseAusnahme.printStackTrace();
      }
      return ruechgabe;
    }
}
