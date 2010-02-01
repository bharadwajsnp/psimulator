/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pocitac;

import java.util.ArrayList;
import java.util.List;


/**
 * Virtualni pocitac, predek Linuxu a Cisca
 * @author neiss
 */

public class AbstractPocitac {
    public Komunikace komunikace;
    public List <SitoveRozhrani>rozhrani;
    public String jmeno; //jmeno pocitace


    public AbstractPocitac(String jmeno){
        komunikace=new Komunikace(3567, this);
        rozhrani=new ArrayList<SitoveRozhrani>();
        this.jmeno=jmeno;
    }

    public AbstractPocitac(String jmeno, int port) {
        komunikace = new Komunikace(port, this);
        rozhrani=new ArrayList<SitoveRozhrani>();
        this.jmeno=jmeno;
    }

    public void pridejRozhrani(SitoveRozhrani sr){
        rozhrani.add(sr);
    }

}