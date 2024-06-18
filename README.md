# JavaMenuCLI

Questo repository contiene una classe Java chiamata `Menu`, progettata per creare e gestire menu interattivi nella command line interface (CLI). La classe `Menu` permette di visualizzare menu con una formattazione estetica, gestendo dinamicamente la larghezza in base alla lunghezza delle opzioni e del titolo.

## Caratteristiche

- **Titolo Dinamico**: Possibilità di inserire un titolo opzionale per il menu.
- **Adattamento Dinamico della Larghezza**: La larghezza del menu si adatta automaticamente alla lunghezza del titolo e delle opzioni.
- **Formattazione Estetica**: Inclusione di linee di separazione e adeguata spaziatura tra le opzioni per facilitare la lettura.
- **Multi-Colonna**: Supporto per la visualizzazione di due opzioni per riga, ottimizzando lo spazio visuale.

## Installazione

Per utilizzare questa classe nel tuo progetto Java, segui questi passaggi:

1. Clona il repository:
   ```bash
   git clone https://github.com/MindMelodies/JavaMenuCLI.git
   ```
2. Includi il file `Menu.java` nel tuo progetto Java.

## Esempio di Utilizzo

Ecco un semplice esempio su come utilizzare la classe `Menu`:

```java
String[] opzioni = {"Aggiungi contatto", "Rimuovi contatto", "Visualizza contatti", "Esci"};
Menu menu = new Menu("Scegli una opzione", opzioni);
menu.stampaMenu();
```

Questo codice inizializza un menu con un titolo e quattro opzioni, poi lo visualizza sulla console.

## Contribuire

Contributi al progetto sono sempre benvenuti. Per contribuire:

1. Forka il repository.
2. Crea un nuovo branch per la tua feature (`git checkout -b feature-nuova`).
3. Fai commit delle tue modifiche (`git commit -am 'Aggiungi qualche feature'`).
4. Pusha il branch (`git push origin feature-nuova`).
5. Apri una Pull Request.

## Licenza

Questo progetto è rilasciato sotto la licenza MIT. Per maggiori informazioni, consulta il file LICENSE incluso nel repository.
