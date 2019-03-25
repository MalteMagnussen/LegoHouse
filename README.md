# LegoHouse
by Malte Hviid-Magnussen

[Project Description](https://datsoftlyngby.github.io/dat2sem2019Spring/Modul3/LegoHus.html)

[JavaDocs](https://maltemagnussen.github.io/LegoHouse/)

[Deployment](http://46.101.213.70/Lego/) - Sometimes it starts acting up after a while. If so, please contact me and I'll reload it. Otherwise, please do a manual install, following instructions below.
### Logins
![Logins](https://i.imgur.com/kioQEcH.png) 

Or just make your own customer account.

## ER Diagram

![ER Diagram](https://i.imgur.com/HI05b2h.png)

## Installation

1. Clone project from GitHub.
2. Run [SQL script](/SQL%20scripts/dbInit.sql) in your MySQL workbench.
3. Open the project in your IDE.
4. Make sure the info in the [Connector](/Lego/src/main/java/malte/Model/Connector.java) matches your SQL.
5. Clean and build, just to be sure.
6. Run the project.
7. Log in as employee with **robin@somewhere.com** as email and **batman** as password.
8. Or log in as user with **jens@somewhere.com** as email and **jensen** as password. Or just create a new user.

## [Resources](https://datsoftlyngby.github.io/dat2sem2019Spring/Modul3/#resourcer)

* [This was my starting off point for the project.](https://github.com/DAT2SemKode/Modul3LogInSample)
* [Bootstrap for a lot of the Styling](https://getbootstrap.com/)
* [JSTL for my .jsp pages](https://github.com/datsoftlyngby/dat2sem2019Spring-module-3-pets#expression-language-el-and-java-standard-tag-library-jstl)

## Views

1. Index page. Login and Register. ![Index page. Login and Register.](https://i.imgur.com/wmFzal7.png)
2. Customer page. When having 1 order and having that order selected and dropdown menu pressed. ![Customer page](https://i.imgur.com/srqSq8r.png)
3. Employee page. When viewing an un-sent order. ![Employee page](https://i.imgur.com/yKEZfub.png)
