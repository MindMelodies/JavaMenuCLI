// Definizione della classe Menu
class Menu {
    // Dichiaro le variabili private
    private String titolo;      // Titolo del menu
    private String[] opzioni;   // Array di stringhe contenente le opzioni del menu
    private int larghezza;      // Larghezza del menu, calcolata dinamicamente

    // Costruttore con titolo e opzioni
    public Menu(String titolo, String[] opzioni) {
        this.titolo = titolo;                   // Imposto il titolo del menu
        this.opzioni = opzioni;                 // Imposto le opzioni del menu
        this.larghezza = calcolaLarghezza();    // Calcolo la larghezza del menu basata su titolo e opzioni
    }

    // Costruttore alternativo solo con opzioni (senza titolo specificato)
    public Menu(String[] opzioni) {
        this("", opzioni); // Chiamo il costruttore principale con un titolo vuoto
    }

    // Metodo privato per calcolare la larghezza necessaria del menu
    private int calcolaLarghezza() {
        int maxLunghezzaOpzione = 0;

        // Calcolo la lunghezza massima delle opzioni aggiungendo 4 spazi per estetica
        for (String opzione : opzioni) {
            int lunghezzaOpzione = opzione.length() + 4;
            if (lunghezzaOpzione > maxLunghezzaOpzione) {
                maxLunghezzaOpzione = lunghezzaOpzione; // Aggiorno la lunghezza massima trovata
            }
        }

        int maxLunghezzaTitolo = titolo.length();                                   // Calcolo la lunghezza massima del titolo
        int larghezzaOpzioni = maxLunghezzaOpzione * 2 + 3;                         // Calcolo la larghezza totale necessaria per le opzioni
        int larghezzaCalcolata = Math.max(maxLunghezzaTitolo, larghezzaOpzioni);    // Determino la larghezza finale del menu confrontando il titolo e le opzioni

        return Math.max(larghezzaCalcolata + 4, 20);                              // Mi assicura che la larghezza minima sia 20 per estetica
    }

    // Metodo pubblico per stampare il menu
    public void stampaMenu() {
        stampaLinea();                      // Stampo la linea superiore del menu
        if (!titolo.isEmpty()) {
            stampaLineaCentrata(titolo);    // Stampo il titolo se presente
            stampaLinea();                  // Stampo una linea di separazione
        }
        // Stampo tutte le opzioni del menu
        for (int i = 0; i < opzioni.length; i += 2) {
            if (i + 1 < opzioni.length) {
                stampaDueOpzioni(i + 1, opzioni[i], i + 2, opzioni[i + 1]);
            } else {
                stampaUnaOpzione(i + 1, opzioni[i]);
            }
        }
        stampaLinea(); // Stampo la linea inferiore del menu
    }

    // Metodo privato per stampare una linea orizzontale
    private void stampaLinea() {
        String linea = "+";
        for (int i = 0; i < larghezza - 2; i++) {
            linea += "-"; // Aggiungo tratti per formare la linea
        }
        linea += "+";
        System.out.println(linea); // Stampo la linea completa
    }

    // Metodo privato per stampare una linea di testo centrato
    private void stampaLineaCentrata(String testo) {
        int imbottitura = (larghezza - 2 - testo.length()) / 2; // Calcolo la spaziatura per centrare il testo
        String linea = "|";

        // Aggiungo spazi prima del testo per centrarlo
        for (int i = 0; i < imbottitura; i++) {
            linea += " ";
        }

        linea += testo; // Aggiungo il testo

        // Completo la linea con spazi dopo il testo
        for (int i = 0; i < larghezza - 2 - testo.length() - imbottitura; i++) {
            linea += " ";
        }

        linea += "|";

        System.out.println(linea); // Stampo la linea centrata
    }

    // Stampo una singola opzione con una colonna vuota accanto
    private void stampaUnaOpzione(int numero, String opzione) {
        // Formatto la linea con il numero e l'opzione
        String testoOpzione = numero + ". " + opzione;
        int mezzaLarghezza = (larghezza - 4) / 2;
        String lineaFormattata = "| " + testoOpzione;

        // Aggiungo spazi per allineare la prima colonna
        for (int i = testoOpzione.length(); i < mezzaLarghezza; i++) {
            lineaFormattata += " ";
        }

        lineaFormattata += " | ";

        // Aggiungo spazi per la seconda colonna vuota
        for (int i = 0; i < mezzaLarghezza; i++) {
            lineaFormattata += " ";
        }

        lineaFormattata += " |";

        System.out.println(lineaFormattata); // Stampo la linea formattata
    }

    // Stampo due opzioni su una singola linea
    private void stampaDueOpzioni(int numero1, String opzione1, int numero2, String opzione2) {
        // Formatto la prima colonna con il numero e l'opzione
        String testoOpzione1 = numero1 + ". " + opzione1;
        String testoOpzione2 = numero2 + ". " + opzione2;
        int mezzaLarghezza = (larghezza - 6) / 2;
        String lineaFormattata = "| " + testoOpzione1;

        // Aggiungo spazi per allineare la prima colonna
        for (int i = testoOpzione1.length(); i < mezzaLarghezza; i++) {
            lineaFormattata += " ";
        }

        lineaFormattata += " | " + testoOpzione2;

        // Aggiungo spazi per allineare la seconda colonna
        for (int i = testoOpzione2.length(); i < mezzaLarghezza; i++) {
            lineaFormattata += " ";
        }

        lineaFormattata += " |";

        System.out.println(lineaFormattata); // Stampo la linea formattata
    }
}