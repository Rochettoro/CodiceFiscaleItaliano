# CodiceFiscaleItaliano
Calcolatore di Codice Fiscale Italiano


Il programma non ha interfaccia grafica (WIP) e per ottenere il codice fiscale di qualcuno occorre istanziare CalcolaCodiceFiscale nel seguente modo:

     CalcoloCodiceFiscale identificatoreQualsiasi = new CalcoloCodiceFiscale(nome, cognome, genere, anno, mese, giorno, luogo di nascita);


Dentro al programma ci sono 8 esempi di come di può inserire la data nel costruttore (LocalDate o 3 stringhe),
non ci sono esempi per nomi, cognomi e sesso (genere) a parte quello gia inserito,
c'è la lista contenente i vari luoghi di nascita nel file codiciLuoghi.txt che si può usare anche per esempi di luoghi di nascita

Se si vuole generare il codice di una FEMMINA bisogna mettere nello spazio apposito "femmina" o "f" (le lettere possono essere sia maiuscole che minuscole)
altrimenti genererà il codice di un MASCHIO
