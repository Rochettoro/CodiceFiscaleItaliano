/**
 * @autor Michele Cecchi
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class CalcoloCodiceFiscale {

    public String nome, cognome, codiceFiscale, luogoNascita, genere;
    public LocalDate dataNascita;

    CalcoloCodiceFiscale(String nome, String cognome, String genere, String anno, String mese, String giorno, String luogoNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = LocalDate.of(Integer.parseInt(anno), Integer.parseInt(mese), Integer.parseInt(giorno));
        this.luogoNascita = luogoNascita;
        this.genere = genere;
        this.codiceFiscale = getCodice(this);
    }

    public CalcoloCodiceFiscale(String nome, String cognome, String genere, LocalDate dataNascita, String luogoNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.luogoNascita = luogoNascita;
        this.genere = genere;
        this.codiceFiscale = getCodice(this);
    }

    public String toString(){
        return "Nome: "+nome+"\nCognome: "+cognome+"\nData di nascita: "+dataNascita+"\nLuogo di nascita: "+luogoNascita+"\nGenere: "+genere+"\nCodice fiscale: "+codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale(CalcoloCodiceFiscale ccf0) {
        return getCodice(ccf0);
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public String getGenere() {
        return genere;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public static String getCodice(CalcoloCodiceFiscale ccf){
        int posizione = 0;
        String s = "", s1 = "";
        s1 = ccf.getCognome().toLowerCase();
        while (s.length() < 3 && posizione < s1.length()){
            if(s1.charAt(posizione) != 'a' && s1.charAt(posizione) != 'e' && s1.charAt(posizione) != 'i' && s1.charAt(posizione) != 'o' && s1.charAt(posizione) != 'u'){
                s += s1.charAt(posizione);
            }
            posizione++;
        }
        posizione = 0;
        if(s.length() < 3){
            while (s.length() < 3 && posizione < s1.length()){
                if(s1.charAt(posizione) == 'a' || s1.charAt(posizione) == 'e' || s1.charAt(posizione) == 'i' || s1.charAt(posizione) == 'o' || s1.charAt(posizione) == 'u'){
                    s += s1.charAt(posizione);
                }
                posizione++;
            }
        }

        String contaConsonanti1 = ccf.getNome().toLowerCase().replace("a", "").replace("e", "").replace("i", "").replace("o", "").replace("u", "");

        int BloccaConsonante = -1;
        if(contaConsonanti1.length() >= 4){
            BloccaConsonante = 1;
        }

        int numeroConsonanti = 0;
        posizione = 0;
        s1 = ccf.getNome().toLowerCase();
        while (s.length() < 6 && posizione < s1.length()){
            if(s1.charAt(posizione) != 'a' && s1.charAt(posizione) != 'e' && s1.charAt(posizione) != 'i' && s1.charAt(posizione) != 'o' && s1.charAt(posizione) != 'u'){
                if(numeroConsonanti != BloccaConsonante) {
                    s += s1.charAt(posizione);
                }
                numeroConsonanti++;
            }
            posizione++;
        }

        posizione = 0;
        if(s.length() < 6){
            while (s.length() < 6 && posizione < s1.length()){
                if(s1.charAt(posizione) == 'a' || s1.charAt(posizione) == 'e' || s1.charAt(posizione) == 'i' || s1.charAt(posizione) == 'o' || s1.charAt(posizione) == 'u'){
                    s += s1.charAt(posizione);
                }
                posizione++;
            }
        }

        s1 = ""+ccf.getDataNascita().getYear();

        s += s1.charAt(s1.length()-2);
        s += s1.charAt(s1.length()-1);

        switch(ccf.getDataNascita().getMonthValue()){
            case 1: s += "A"; break;
            case 2: s += "B"; break;
            case 3: s += "C"; break;
            case 4: s += "D"; break;
            case 5: s += "E"; break;
            case 6: s += "H"; break;
            case 7: s += "L"; break;
            case 8: s += "M"; break;
            case 9: s += "P"; break;
            case 10: s += "R"; break;
            case 11: s += "S"; break;
            case 12: s += "T"; break;
        }

        if(ccf.getGenere().equalsIgnoreCase("femmina")||ccf.getGenere().equalsIgnoreCase("f")){
            s1 = ""+(ccf.getDataNascita().getDayOfMonth()+40);
        }else{
            if(ccf.getDataNascita().getDayOfMonth() < 10) {
                s1 = "0" + ccf.getDataNascita().getDayOfMonth();
            }else {
                s1 = "" + ccf.getDataNascita().getDayOfMonth();
            }
        }
        s += s1;

        s += LeggiDaFile(ccf);

        s = s.toUpperCase();

        int UltimaLettera = 0;
        for(int i = 0; i < s.length(); i++){
            if(i%2==0){
                switch (s.charAt(i)){
                    case '0':
                    case 'A': UltimaLettera += 1; break;
                    case '1':
                    case 'B': UltimaLettera += 0; break;
                    case '2':
                    case 'C': UltimaLettera += 5; break;
                    case '3':
                    case 'D': UltimaLettera += 7; break;
                    case '4':
                    case 'E': UltimaLettera += 9; break;
                    case '5':
                    case 'F': UltimaLettera += 13; break;
                    case '6':
                    case 'G': UltimaLettera += 15; break;
                    case '7':
                    case 'H': UltimaLettera += 17; break;
                    case '8':
                    case 'I': UltimaLettera += 19; break;
                    case '9':
                    case 'J': UltimaLettera += 21; break;
                    case 'K': UltimaLettera += 2; break;
                    case 'L': UltimaLettera += 4; break;
                    case 'M': UltimaLettera += 18; break;
                    case 'N': UltimaLettera += 20; break;
                    case 'O': UltimaLettera += 11; break;
                    case 'P': UltimaLettera += 3; break;
                    case 'Q': UltimaLettera += 6; break;
                    case 'R': UltimaLettera += 8; break;
                    case 'S': UltimaLettera += 12; break;
                    case 'T': UltimaLettera += 14; break;
                    case 'U': UltimaLettera += 16; break;
                    case 'V': UltimaLettera += 10; break;
                    case 'W': UltimaLettera += 22; break;
                    case 'X': UltimaLettera += 25; break;
                    case 'Y': UltimaLettera += 24; break;
                    case 'Z': UltimaLettera += 23; break;
                }
                //System.out.println(s.charAt(i)+" "+UltimaLettera);
            }else{
                switch(s.charAt(i)){
                    case '0':
                    case 'A': UltimaLettera += 0; break;
                    case '1':
                    case 'B': UltimaLettera += 1; break;
                    case '2':
                    case 'C': UltimaLettera += 2; break;
                    case '3':
                    case 'D': UltimaLettera += 3; break;
                    case '4':
                    case 'E': UltimaLettera += 4; break;
                    case '5':
                    case 'F': UltimaLettera += 5; break;
                    case '6':
                    case 'G': UltimaLettera += 6; break;
                    case '7':
                    case 'H': UltimaLettera += 7; break;
                    case '8':
                    case 'I': UltimaLettera += 8; break;
                    case '9':
                    case 'J': UltimaLettera += 9; break;
                    case 'K': UltimaLettera += 10; break;
                    case 'L': UltimaLettera += 11; break;
                    case 'M': UltimaLettera += 12; break;
                    case 'N': UltimaLettera += 13; break;
                    case 'O': UltimaLettera += 14; break;
                    case 'P': UltimaLettera += 15; break;
                    case 'Q': UltimaLettera += 16; break;
                    case 'R': UltimaLettera += 17; break;
                    case 'S': UltimaLettera += 18; break;
                    case 'T': UltimaLettera += 19; break;
                    case 'U': UltimaLettera += 20; break;
                    case 'V': UltimaLettera += 21; break;
                    case 'W': UltimaLettera += 22; break;
                    case 'X': UltimaLettera += 23; break;
                    case 'Y': UltimaLettera += 24; break;
                    case 'Z': UltimaLettera += 25; break;
                }
                //System.out.println(s.charAt(i)+" "+UltimaLettera);
            }
        }
        //System.out.println(UltimaLettera);

        switch (UltimaLettera%26){
            case 0: s += "A"; break;
            case 1: s += "B"; break;
            case 2: s += "C"; break;
            case 3: s += "D"; break;
            case 4: s += "E"; break;
            case 5: s += "F"; break;
            case 6: s += "G"; break;
            case 7: s += "H"; break;
            case 8: s += "I"; break;
            case 9: s += "J"; break;
            case 10: s += "K"; break;
            case 11: s += "L"; break;
            case 12: s += "M"; break;
            case 13: s += "N"; break;
            case 14: s += "O"; break;
            case 15: s += "P"; break;
            case 16: s += "Q"; break;
            case 17: s += "R"; break;
            case 18: s += "S"; break;
            case 19: s += "T"; break;
            case 20: s += "U"; break;
            case 21: s += "V"; break;
            case 22: s += "W"; break;
            case 23: s += "X"; break;
            case 24: s += "Y"; break;
            case 25: s += "Z"; break;
        }



        return s.toUpperCase();
    }

    public static String LeggiDaFile(CalcoloCodiceFiscale ccf1) {
        String DaReturn = "";
        final File f = new File("src\\Ospedale\\variInput\\codici.txt");
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String linea = s.nextLine();
                String[] dati = linea.split(";");

                if(dati[1].equalsIgnoreCase(ccf1.getLuogoNascita())) {
                    DaReturn = dati[0];
                    return DaReturn;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "XXXX";
    }

}
