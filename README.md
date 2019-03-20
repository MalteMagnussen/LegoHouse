# LegoHouse
https://datsoftlyngby.github.io/dat2sem2019Spring/Modul3/LegoHus.html by Malte Hviid-Magnussen

[JavaDocs](https://maltemagnussen.github.io/LegoHouse/)

SQL is only ever accessed from DBAccess folder.

DBAccess folder is only ever accessed from LogicFacade.java.

LogicFacade.java is only ever accessed from FrontController+Command.

FrontController is only ever accessed from .jsp pages with requests.

.jsp Request -> FrontController -> Command -> LogicFacade -> DataMapper -> SQL.
