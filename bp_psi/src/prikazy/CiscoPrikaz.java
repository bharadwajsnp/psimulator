/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prikazy;

import java.util.List;
import pocitac.AbstractPocitac;
import pocitac.Konsole;

/**
 *
 * @author haldyr
 */
public abstract class CiscoPrikaz extends AbstraktniPrikaz {
    
    protected String radka = "";

    public CiscoPrikaz(AbstractPocitac pc, Konsole kon, List<String> slova) {
        super(pc, kon, slova);
        int i = 0;
        for (String s : slova) {
            if (i == 0) radka += s;
            else radka += " " + s;
            i++;
        }
    }

    /**
     * Tato metoda simuluje zkracovani prikazu tak, jak cini cisco.
     * Metoda se take stara o vypisy typu: IncompleteCommand, AmbigiousCommand, InvalidInputDetected.
     * @param command prikaz, na ktery se zjistuje, zda lze na nej doplnit.
     * @param cmd prikaz, ktery zadal uzivatel
     * @param min kolik musi mit mozny prikaz znaku
     * @return Vrati true, pokud retezec cmd je jedinym moznym prikazem, na ktery ho lze doplnit.
     */
    protected boolean kontrola(String command, String cmd, int min) {

        if (cmd.length() >= min && command.startsWith(cmd)) { // lze doplnit na jeden jedinecny prikaz
            return true;
        }

        if (command.startsWith(cmd)) {
            ambigiousCommand(cmd);
        } else {
            invalidInputDetected();
        }
        return false;
    }

    protected abstract boolean zpracujRadek();

    protected void incompleteCommand() {
        kon.posliRadek("% Incomplete command.");
    }

    protected void ambigiousCommand(String s) {
        kon.posliRadek("% Ambiguous command:  \""+radka+"\"");
    }

    protected void invalidInputDetected() {
        kon.posliRadek("\n% Invalid input detected.\n");
    }

    protected boolean zacinaCislem(String s) {
        if (s.length() == 0) return false;

        if (Character.isDigit(s.charAt(0))) {
            return true;
        } else {
            return false;
        }
    }

}