# Review af Runis kode.
https://github.com/Runi-VN/LegoHouse

Af Malte Hviid-Magnussen.

## Krav:
### 1 Det færdige system skal være struktureret 3 lags modellen - præsentationslag, forretningslag og datalag.

- I Source Packages ligger der en Datamappe med Mappers og en DBConnector.
 Der er også en Logicmappe med entities, exceptions og diverse facader og logik klasser.
 Så er der Presentation der anvender FrontController+Command mønsteret.
 Så krav 1 er opfyldt.

### 2 Det forventes at der er en facade mellem præsentations og forretningslag og evt. mellem forretningslaget og datamappers/DAO. Det betyder blandt andet at der ikke må kaldes mappers direkte fra Servlets.
Der ligger som sagt i Logicmappen nogle facader, så dette krav er opfyldt.

### 3 Det forventes at der IKKE kaldes forretningslogik (eller datamappers) fra JSP siderne.
Det ligner ganske vist at der på linje 13 i /WEB-INF/customer.jsp er et kald til noget der ikke er request eller session. 
En løsning kunne her være at lægge alle users orders i session når han logger ind, i stedet for at hente dem direkte ud af SQL hver gang man reloader siden.


### 4 Det forventes at session og requests attributter anvendes korrekt.
Jeg har ikke personligt styr på hvad der her menes med ”korrekt”.

### 5 Vi vil anse det for en fejl hvis der bruges redirect hvor der burde bruges forward.
Igen, jeg har ingen idé om hvad forskellen er og hvordan de to skal anvendes korrekt. 

### 6 Det forventes at styklisterne ikke gemmes i databasen, men beregnes i forretningslaget.
Jeg kan se at han kun gemmer ordrer i databasen, og at styklisterne beregnes i "Calculator" i forretningslaget.

### 7 Du skal håndtere exceptions i data laget - ikke blot catch og så skrive stack trace ud på System.out
Han håndterer exceptions i datalaget, og smider sine egne Custom Erros med tilhørende message til User.

### 8 Du skal lave en specialiseret exception som du kaster fra datalaget og fanger i servlet.
Han har to specialiserede Exceptions. Orderexception.java og UserException.java.

### 9 JSP siderne må kun hente information via request og servlet
De henter desværre også information fra Mappers som beskrevet i #3.

### 10 Det forventes at du bruger en front-controller som vist i ugens oplæg.
Han anvender Front-Controller som vist i ugens oplæg.

## Kommentarer:

https://github.com/Runi-VN/LegoHouse#installation-and-use
Det var med hans guide nemt at finde ud af at installere programmet og få det til at køre.

Derefter læste jeg hans Readme.
Den er grundig, og jeg føler ikke at jeg mangler noget information om programmet.
En enkelt lille ting er at "Installation and use" godt kunne have ligget lidt højere oppe i readme.

Jeg er glad for at footer og header er delt ind i sine egne JSP-sider og så kun bliver kaldt som include i toppen og bunden af de andre. Det gør koden mere læsbar og gemmer en masse overflødig kode væk, der ellers ville blive gentaget et hav af gange. 
Hvis man vil rette noget i header eller footer behøves det også kun at gøres et sted, nu hvor de bare bliver included.

Jeg kunne godt have ønsket flere kommentarer i .jsp siderne. Man skal holde tungen lige i munden for at læse noget af det.

Det er sejt at der er lavet en custom CSS fil. Det ligner at han selv har lavet den. 

Validate Session metoden i FrontController linje 65 er enormt smart. Den løser et problem jeg selv stødte på. 
Da jeg havde været AFK i 30+ minutter og kom tilbage, så fik jeg en masse grimme errors da jeg prøvede at bruge programmet. Men det ville den der ”validateSession” have fixet.

Point for at bruge singleton instance i Mappers og Facaderne. Det burde jeg nok også have gjort. 

Godt at der bruges Prepared Statement i Mappers, for at undgå SQL injections.

Hjemmesiden er nem og overskuelig når man bruger den. Der er dog massere af plads på customer.jsp siden til det der står i orderdetails. Hvorfor ikke bare have det på samme side, for at spare kunden for clicks.

Main.java burde ikke være der i det færdige produkt, men fedt at det er blevet brugt til at teste.

"test pls work" beskeden after man trykker "Return to page" som employee, burde ikke have været der i det færdige produkt. EmployeeCommand.java linje 20.

Log Out knappen hopper lidt rundt alt efter hvilken side man ser. Personligt ville jeg have puttet den et fast sted. Fx oppe i navbaren.

Yderst lille ting: https://imgur.com/g2H4zfC

Hvad gør linje 24 og 26 i ShipOrderCommand.java?

Nice med link til github i footeren.

Hvad er formålet med CustomerCommand.java? Igen, ville være rart med flere kommentarer.

I OrderFacade.java i metode getAllOrders() og getAllUserOrders() fra linje 79 til og med linje 93.
Der kunne man med fordel have lavet dem til 1 metode, så API'en udadtil er nemmere.
Så hvis det er en employee der kalder den returnerer den ALLE orders, og hvis det er en customer returnerer den kun customerens.

I OrderFacade.java fra linje 27 til og med linje 52, kunne man have givet dem samme navn, men stadig forskellige bodies. Ville igen gøre det til en kortere API.

Gode kommentarer og forklaringer i CalculatorSimple.java og Bricks.java.

wow, CalculatorSimpleTest.java er nice.

Der er desværre ikke indsat dør og vindue, og jeg har svært ved at forestille mig forbandt mønsteret. Måske en tegning i readme.md havde været passende.

Fedt med UML og ER diagram i din readme.md.

Some classes have warnings and unused imports.
