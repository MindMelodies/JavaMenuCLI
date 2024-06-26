// Versione di https://github.com/MyPassaport

public class Menu {
    private String titolo;
    private String[] opzioni;
    private int larghezza;
    private String carattereLinea = "-"; // Carattere per le linee
    private String coloreTesto = ""; // Codice ANSI per il colore del testo
    private final String RESET_COLORE = "\u001B[0m"; // Codice ANSI per resettare il colore

    public Menu(String titolo, String[] opzioni) {
        this.titolo = titolo;
        this.opzioni = opzioni;
        this.larghezza = calcolaLarghezza();
    }

    public Menu(String[] opzioni) {
        this("", opzioni);
    }

    private int calcolaLarghezza() {
        int maxLunghezzaOpzione = 0;
        for (String opzione : opzioni) {
            int lunghezzaOpzione = opzione.length() + 4;
            if (lunghezzaOpzione > maxLunghezzaOpzione) {
                maxLunghezzaOpzione = lunghezzaOpzione;
            }
        }
        int maxLunghezzaTitolo = titolo.length();
        int larghezzaOpzioni = maxLunghezzaOpzione * 2 + 3;
        int larghezzaCalcolata = Math.max(maxLunghezzaTitolo, larghezzaOpzioni);
        return Math.max(larghezzaCalcolata + 4, 20);
    }

    public void setCarattereLinea(String carattere) {
        this.carattereLinea = carattere;
    }

    public void setColoreTesto(String colore) {
        this.coloreTesto = colore;
    }

    public void stampaMenu() {
        stampaLinea();
        if (!titolo.isEmpty()) {
            stampaLineaCentrata(titolo);
            stampaLinea();
        }
        for (int i = 0; i < opzioni.length; i += 2) {
            if (i + 1 < opzioni.length) {
                stampaDueOpzioni(i + 1, opzioni[i], i + 2, opzioni[i + 1]);
            } else {
                stampaUnaOpzione(i + 1, opzioni[i]);
            }
        }
        stampaLinea();
    }

    private void stampaLinea() {
        String linea = "+";
        for (int i = 0; i < larghezza - 2; i++) {
            linea += carattereLinea;
        }
        linea += "+";
        System.out.println(coloreTesto + linea + RESET_COLORE);
    }

    private void stampaLineaCentrata(String testo) {
        int margine = (larghezza - 2 - testo.length()) / 2;
        String linea = "|";
        for (int i = 0; i < margine; i++) {
            linea += " ";
        }
        linea += testo;
        for (int i = 0; i < larghezza - 2 - testo.length() - margine; i++) {
            linea += " ";
        }
        linea += "|";
        System.out.println(coloreTesto + linea + RESET_COLORE);
    }

    private void stampaUnaOpzione(int numero, String opzione) {
        String testoOpzione = numero + ". " + opzione;
        int mezzaLarghezza = (larghezza - 4) / 2;
        String lineaFormattata = "| " + testoOpzione;
        for (int i = testoOpzione.length(); i < mezzaLarghezza; i++) {
            lineaFormattata += " ";
        }
        lineaFormattata += " | ";
        for (int i = 0; i < mezzaLarghezza; i++) {
            lineaFormattata += " ";
        }
        lineaFormattata += " |";
        System.out.println(coloreTesto + lineaFormattata + RESET_COLORE);
    }

    private void stampaDueOpzioni(int numero1, String opzione1, int numero2, String opzione2) {
        String testoOpzione1 = numero1 + ". " + opzione1;
        String testoOpzione2 = numero2 + ". " + opzione2;
        int mezzaLarghezza = (larghezza - 6) / 2;
        String lineaFormattata = "| " + testoOpzione1;
        for (int i = testoOpzione1.length(); i < mezzaLarghezza; i++) {
            lineaFormattata += " ";
        }
        lineaFormattata += " | " + testoOpzione2;
        for (int i = testoOpzione2.length(); i < mezzaLarghezza; i++) {
            lineaFormattata += " ";
        }
        lineaFormattata += " |";
        System.out.println(coloreTesto + lineaFormattata + RESET_COLORE);
    }
}
// metodo Main per utilizzare i nuovi metodi

public class TestMenu {
    public static void main(String[] args) {
        String[] opzioni = {"Opzione 1", "Opzione 2", "Opzione 3", "Opzione 4"};
        Menu menu = new Menu("Titolo Menu", opzioni);

        // Imposta un carattere diverso per le linee
        menu.setCarattereLinea("*");

        // Imposta il colore del testo in rosso (codice ANSI)
        menu.setColoreTesto("\u001B[31m");

        menu.stampaMenu();
    }
}
