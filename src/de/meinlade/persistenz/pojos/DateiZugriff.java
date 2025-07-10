package de.meinlade.persistenz.pojos;

import java.io.*;

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

    /**
     * Alle Arten von Daten Können gelesen werden mit einem InputStream
     * Alle Arten von Daten können geschriebenw werden mt einem OutStream
     * @param quelle Datei mit Bild
     * @param ziel Kopie des Bildes
     */
    public void einfachKopieren(File quelle, File ziel){
        try(InputStream leser = new FileInputStream(quelle);
        OutputStream schreiber = new FileOutputStream(ziel)){
            while (true){
                int gelesen = leser.read();
                if(gelesen == -1){
                    break;
                }
                schreiber.write(gelesen);
            }
        }catch (IOException schreibLeseAusnahme){
            schreibLeseAusnahme.printStackTrace();

        }

    }

    public void besserKopieren(File quelle, File ziel) {
        try (BufferedInputStream besserLeser = new BufferedInputStream(new FileInputStream(quelle));
             BufferedOutputStream besserShreiber = new BufferedOutputStream(new FileOutputStream(ziel))) {
            byte[] puffer = new byte[1024];
            while (besserLeser.read(puffer) != -1) {
                besserShreiber.write(puffer);
            }
        } catch (IOException schreibLeseAusnahme) {
            schreibLeseAusnahme.printStackTrace();

        }
    }

    public void speichernMarmelade (File ziel, Marmelade marmelade){
        try(OutputStream schreiber = new FileOutputStream(ziel);
            ObjectOutput objectOutput = new ObjectOutputStream(schreiber)){
            objectOutput.writeObject(marmelade);
        }catch (IOException marmeladeAusnahme){
            System.out.println("Fehler bei Object schreiben " + marmeladeAusnahme.getMessage() );
            marmeladeAusnahme.printStackTrace();

        }
    }

    /**
     *
     */
    public Marmelade lesenMarmelade(File quelle){
        Marmelade reuckgabe = null ;

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(quelle))){
            objectInputStream.readObject();
        }catch (IOException objektAusnahme){
            objektAusnahme.printStackTrace();
        } catch (ClassNotFoundException klassAusnahme) {
            System.out.println(klassAusnahme.getMessage());
            System.out.println("Mehr Infos in der Klassenbeschreibung");
        }
        return reuckgabe;
    }
}
