# Review af Williams kode.
https://github.com/WSHuusfeldt/LegoHouses

Af Malte Hviid-Magnussen.

## Kommentarer:

Der er intet i Readme.md.
Så jeg cloner bare projektet og prøver at clean/build.

COMPILATION ERROR : 
-------------------------------------------------------------
PresentationLayer/FrontController.java:[36,41] unreported exception FunctionLayer.CreateOrderException; must be caught or declared to be thrown

Jeg adder en catch. Ærgerligt at dette ikke var ordnet inden i dag.

Kører Clean and Build igen.
BUILD SUCCESS.

Før jeg kigger på mere kode, så kører jeg programmet.

Man kan se ordrer som employee. Man kan lave ordrer som customer. Ingen log ud knap. Ingen knap til at komme tilbage efter man opretter en ordre.
HTTPStatus 500 fra at trykke på "Vis Stykliste"

Kigger på kode nu.

Header og footer kunne splittes ind i deres egne .jsp filer og så blive included hvor det er brug for det, i stedet for at have en masse unødig kode.

Fandt ud af hvorfor jeg ikke kan se stykliste. På linje 10 i legolist.jsp står der <%@page import="DBAccess.Calculator"%>.
Det gør at den ikke kan compiles. 

org.apache.jasper.JasperException: Unable to compile class for JSP: 

An error occurred at line: [16] in the generated java file: [C:\Users\Malte\AppData\Roaming\NetBeans\8.2\apache-tomcat-8.0.27.0_base\work\Catalina\localhost\LegoHouses\org\apache\jsp\WEB_002dINF\legolist_jsp.java]
Only a type can be imported. DBAccess.Calculator resolves to a package

Jeg fjerner lige linjen, og prøver igen. 

Okay. Nu kan jeg se styklisten. Ærgerligt at det ikke var fixed inden i dag.

Igen ingen knap for at komme tilbage.

Det lader dog ikke til at at der i nogen af .jsp'erne bliver kaldt andet end session og request, så det er godt.

Aha. Jeg undrede mig over hvor at den fik data fra, men det kommer åbenbart fra hans server. Det synes jeg er fikst.

Godt at der bruges Prepared Statement i Mappers. Så undgår man SQL injections.

Aha! I DBAccess ligger der en dbInit.sql fil. Det burde der have stået i readme.md synes jeg.

Det lader ikke til at der er bygget i forbandt.

Godt med en Facade på logic. 
