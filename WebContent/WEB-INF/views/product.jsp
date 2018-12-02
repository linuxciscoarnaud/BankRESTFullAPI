<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.1/angular.min.js"></script>
    <script src="/BankRESTFullAPI/resources/js/controllers.js"></script> 
</head>

<h1>Products</h1> 

<section  ng-app="cardApp">
<article class="col-sm-6" itemtype="http://schema.org/NewsArticle" itemscope="">
    <div class="panel-body">
        <h3>${product.nomProduit}</h3>       
        <p><strong>Item Code : </strong><span class="label label warning">${product.codeProduit}</span></p>                    
        <p>${product.prixUnitaire} USD</p>
        
        <p ng-controller="cardCtrl">
        
        <a href="#" class="btn btn-warning btn-large" ng-click="addToCard('${product.codeProduit}')"> 
            <span class="glyphicon-shopping-cart glyphicon"></span> Order Now
        </a>
        
        <a href="<spring:url value="/card" />" class="btn btn-default">
	        <span class="glyphicon-hand-right glyphicon"></span> View Cart 
        </a>
        
        <a href="<spring:url value="/market/products" />" >
            <span></span> back
        </a>
        
        </p>
    </div>
</article>
</section>
</html>
