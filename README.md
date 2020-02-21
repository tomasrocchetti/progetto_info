# Progetto informatica Tomas Rocchetti
La rest API al primo avvio scarica una tabella. 
Ogni record della tabella è formato da 4 attributi e una lista di valori (uno per ogni anno).
Grazie alle richieste di tipo POST si può scegliere una riga della tabella ed eseguire dei calcoli sui valori.
Con le richieste di tipo DELETE verrà eliminata dal file una riga scelta.


### Sequenzialità del programma
![](https://github.com/tomasrocchetti/progetto_info/blob/master/flow1.png)


### POST
localhost:8080/selectRowByParameters

Basta inserire come corpo della richiesta un Json contenente i parametri. verrà restituito un Json con tutti i calcoli effettuati sul record scelto

[Esempio POST](https://youtu.be/WfEzRno1i7M)

### DELETE
localhost:8080/deleteRow

Basta inserire i parametri (formato Json) per scegliere quale riga eliminare

[Esempio DELETE](https://youtu.be/WfEzRno1i7M)

### WebUI

È possibile utilizzare una comoda interfaccia web per scegliere il record in base ai suoi attributi e mostrare i calcoli relativi al record stesso.
L'interfaccia Web restituisce anche una riga Json contenente i parametri scelti. Sarà possibile copiare e incollare questa stringa in PostMan per testare le richieste POST e DELETE

http://localhost:8080/country

[Esempio utilizzo WebUI](https://youtu.be/0djage0Twq4)

### NOTA

Negli ultimi giorni ho avuto problemi con il plugin eGit, purtroppo alcune commit sono andate perse e ho dovuto rifarle manualmente copiando il codice e incollandolo nell'editor di testo di gitHub. In caso in cui qualcosa non dovesse funzionare allego "progetto.zip" che contiene il programma sicuramente funzionante nella sua ultima versione.
