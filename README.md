# Progetto informatica Tomas Rocchetti
La Rest API è in grado di ricevere richieste in ingresso di tipo POST, è possibile inserire come corpo della richiesta post i valori in formato JSon da ricercare nella tabella. Verranno restituiti (sempre sotto forma di dato JSon) i vari calcoli compiuti sui record della tabella che hanno gli attributi inseriti nel corpo della richiesta.
È inoltre possibile eliminare un record della tabella grazie ad una richiesta di tipo DELETE.

### POST
localhost:8080/selectRowByParameters

basta inserire come corpo della richiesta un JSon contenente i parametri. verrà restituito un JSon con tutti i calcoli effettuati sul record scelto

### DELETE
localhost:8080/deleteRow

basta inserire i parametri (formato JSon) per scegliere quale riga eliminare

### WebUI

È inoltre possibile utilizzare una comoda interfaccia web per scegliere gli attributi e mostrare i calcoli relativi al record scelto.
L'interfaccia Web restituisce anche una riga JSon contenente i parametri scelti. Sarà possibile copiare e incollare questa stringa in PostMan per testare le richieste POST e DELETE

http://localhost:8080/country
