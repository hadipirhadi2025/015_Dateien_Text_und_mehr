package de.meinlade.persistenz.pojos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * <pre>
 *     Pojos sind oft geeignet umd Datensäze einer Datenbanktabelle zu repräsentieren.
 *     EIn Datensatz aus der Tabelle Marmelade entspricht einem Objekt der Klasse Marmelade
 * </pre>
 */
public class Marmelade implements Serializable {

    /**
     * Entspricht der Primärschlüsselspalte in der Datenbank mit dem SQL Datentyp INT
     * und dem Spaltennamen marmelade_id
     * Wird von der Datenbank erzeugt!
     */
    private int marmeladeId;

    /**
     * Entspricht dem varchar(64) in der Tabelle
     */
    private String sorte;

    /**
     * Wie in der Datenbank
     */
    private int zuckergehalt;

    /**
     * Entspricht der Spalte eingekocht aus der Tabelle mit den SQL Datentyp Date,
     */
    private LocalDate eingekochtAm;

    public Marmelade(String sorte, int zuckergehalt, LocalDate eingekochtAm) {
        this.sorte = sorte;
        this.zuckergehalt = zuckergehalt;
        this.eingekochtAm = eingekochtAm;
    }

    public int getMarmeladeId() {
        return marmeladeId;
    }

    /**
     * Beim Speichern in die Datenbank vergibt die Datenbank einen Primärschlüssel.
     * Dann soll diese ID gesetzt werden.
     * Danach darf sie nicht mehr geändert werden.
     * @param marmeladeId aus der Datenbank
     */
    public void setMarmeladeId(int marmeladeId) {
        if(this.marmeladeId != 0){
            throw new PrimaeschluesselException("Diese Marmelade ist schon mit der id " + this.marmeladeId
                    +" in der Datenbank gespeichert");
        }
        this.marmeladeId = marmeladeId;
    }

    public String getSorte() {
        return sorte;
    }

    public void setSorte(String sorte) {
        this.sorte = sorte;
    }

    public int getZuckergehalt() {
        return zuckergehalt;
    }

    public void setZuckergehalt(int zuckergehalt) {
        this.zuckergehalt = zuckergehalt;
    }

    public LocalDate getEingekochtAm() {
        return eingekochtAm;
    }

    public void setEingekochtAm(LocalDate eingekochtAm) {
        this.eingekochtAm = eingekochtAm;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Marmelade marmelade = (Marmelade) o;
        return zuckergehalt == marmelade.zuckergehalt && Objects.equals(sorte, marmelade.sorte) && Objects.equals(eingekochtAm, marmelade.eingekochtAm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sorte, zuckergehalt, eingekochtAm);
    }

    @Override
    public String toString() {
        return "Marmelade{" +
                "marmeladeId=" + marmeladeId +
                ", sorte='" + sorte + '\'' +
                ", zuckergehalt=" + zuckergehalt +
                ", eingekochtAm=" + eingekochtAm +
                " Wie Speicheradresse+ " + super.hashCode()+
                '}';
    }
}
