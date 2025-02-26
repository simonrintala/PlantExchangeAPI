# Plant Exchange API 🌱
## Summary
This project is a REST API for a plant exchange application, built using Spring Boot. The API allows users to exchange or sell plants and is connected to a MongoDB database for data storage.

### Key Features
CRUD operations for managing plants and user listings
MongoDB integration for storing plant data
RESTful API endpoints to facilitate plant exchanges and sales
Postman documentation and testing to ensure API reliability
This API is designed to provide a structured and efficient way for plant enthusiasts to connect and trade their plants.


## Github repo
https://github.com/simonrintala/backend_uppgift_1

## ER-diagram
https://drive.google.com/file/d/1GYwR3SMx0CZTzHOUYMIlLlGL99b573tJ/view?usp=sharing

## Video med kodgenomgång
https://youtu.be/t1QcqinD5jQ
# README content
### Installations instruktioner
Clona github repo (länk:https://github.com/simonrintala/backend_uppgift_1)
Se till att ha "MongoDB" på maskinen och även "mongoDB Compass" för en
bättre och lättare användarupplevlse att gå igenom datan visuellt.
"Postman" kan vara bra att använda om du vill testa egna querys och egen data 
för applikationen.
### Postman documentation
https://documenter.getpostman.com/view/40844842/2sAYX5JhCn
### Beskrivning av affärsregler
#### En användare kan inte ha mer än 10 aktiva annonser samtidigt
#### Växter markerade för byte kan endast bytas mot andra växter, inte säljas
#### Vid byte måste båda parter godkänna bytet innan det genomförs
#### Prissatta växter måste ha ett fast pris mellan 50-1000 kr
### Lista över kända begränsningar
Jag är väl medveten om att det blev lite krångligt med tillägg
av plantor och användare och hur de är kopplade.
Men detta är den tredje gången jag gjort om allting för att jag inte fick
det att fungera så som jag hade tänkt. 
Man måste vara väldigt specifik när man lägger till och ändrar i både users
och i plants då den hämtar all information på båda när dom är länkade.

Många objekt i models har inte heller någon validering så man kan skriva 
vad man vill och det kommer ändå fungera

Jag tror jag följde dina gamla kod repon lite mycket och backade in mig i 
ett hörn hur allting skulle se ut och vågade inte göra massa "nya" saker som
jag kände mig osäker på och därtill blev koden och hela proccessen väldigt
hoppig och hackig. Väldigt mycekt gå in och ändra en sak här och en där
och tillslut så blev det väldigt mycket kod för saker som kanske inte hade behövt det.


### Förslag på förbättringar
Man hade nog absolut kunnat simplifiera båda mina controllers och få dom att
göra ungefär samma sak.
Jag känner själv att mina controllers inte är bra och det va också det jag tyckte
har varit svårt i denna uppgiften att bygga upp dom på ett bra sätt, som FUNKAR.
Valideringen är inte heller något jag lade ner super mycket tid på då
det krånglade väldigt mycket när jag gjorde det i början. 
Så validering för värden i alla models klasser hade varit en väldigt stor förbättring.

