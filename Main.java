import java.time.LocalDate;

public class Main {

        public static void main(String[] args) {
                
            // formato date: AAAA MM GG

            // Vari metodi per ottenere il codice fiscale

            CalcoloCodiceFiscale codiceFiscale = new CalcoloCodiceFiscale("Mario", "Rossi", "M", LocalDate.of(1990,1,1), "Roma");
            //CalcoloCodiceFiscale codiceFiscale = new CalcoloCodiceFiscale("Mario", "Rossi", "M", LocalDate.of(1990,1,01), "Roma");
            //CalcoloCodiceFiscale codiceFiscale = new CalcoloCodiceFiscale("Mario", "Rossi", "M", LocalDate.of(1990,01,1), "Roma");
            //CalcoloCodiceFiscale codiceFiscale = new CalcoloCodiceFiscale("Mario", "Rossi", "M", LocalDate.of(1990,01,01), "Roma");
            //CalcoloCodiceFiscale codiceFiscale = new CalcoloCodiceFiscale("Mario", "Rossi", "M", "1990", "1", "1", "Roma");
            //CalcoloCodiceFiscale codiceFiscale = new CalcoloCodiceFiscale("Mario", "Rossi", "M", "1990", "1", "01", "Roma");
            //CalcoloCodiceFiscale codiceFiscale = new CalcoloCodiceFiscale("Mario", "Rossi", "M", "1990", "01", "1", "Roma");
            //CalcoloCodiceFiscale codiceFiscale = new CalcoloCodiceFiscale("Mario", "Rossi", "M", "1990", "01", "01", "Roma");


            System.out.println(codiceFiscale);                              // Codice fiscale ottenuto con il programma
            System.out.println("Codice fiscale: RSSMRA90A01H501W");         // Codice fiscale ottenuto con https://codicefiscale.it/ e con http://www.codicefiscaleonline.com/

        }
}
