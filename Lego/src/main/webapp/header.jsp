<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Author: Malte -->
<html lang = "en">
    <head>

        <title>LegoHouse</title>

        <base href="${pageContext.request.contextPath}/" />
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }

        </style>
        <!-- Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link type="text/css" rel="stylesheet" href="css/animatedDropDown.css">
        <link href="floating-labels.css" rel="stylesheet">
        <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/floating-labels/">
        <link type="text/css" rel="stylesheet" href="css/backgroundimage.css">
        <link type="text/css" rel="stylesheet" href="css/stickyfooter.css">


    </head>

    <body>
        
        <div id="everything" >
            <!-- The Navbar - Only if logged in. -->
            <c:if test="${not empty user}">

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container">
                        <a class="navbar-brand" href="#">Logged in as: ${user.email}</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ml-auto">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Menu
                                    </a>

                                    <div class="dropdown-menu dropdown-menu-right animate slideIn" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="FrontController?command=Redirect">
                                            <c:if test="${user.role == 'customer'}">
                                                Shop
                                            </c:if>    
                                            <c:if test="${user.role == 'employee'}">
                                                Invoices
                                            </c:if>    
                                        </a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="FrontController?command=Login&origin=logout">Log Out</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

            </c:if>
            <div class="container">
                <div class="card border-0 shadow my-5">
                    <div class="card-body p-5">
                        <!-- Show errormessage to the User --> 
                        <c:if test="${not empty error}">
                            <H2>Message: ${error} </h2>
                            </c:if>
