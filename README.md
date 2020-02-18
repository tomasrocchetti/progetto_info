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


### DELETE
localhost:8080/deleteRow

Basta inserire i parametri (formato Json) per scegliere quale riga eliminare


### WebUI

È possibile utilizzare una comoda interfaccia web per scegliere il record in base ai suoi attributi e mostrare i calcoli relativi al record stesso.
L'interfaccia Web restituisce anche una riga Json contenente i parametri scelti. Sarà possibile copiare e incollare questa stringa in PostMan per testare le richieste POST e DELETE

http://localhost:8080/country
