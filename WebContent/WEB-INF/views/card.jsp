<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.1/angular.min.js"></script>
    <script src="/BankRESTFullAPI/resources/js/controllers.js"></script> 
</head>

<h1>Card</h1>
<p>All the selected products in your card</p>

<section class="container" ng-app="cartApp">
   <div ng-controller="cartCtrl" ng-init="initCartId('${cardId}')">
   
   <div>
       <a class="btn btn-danger pull-left" ng-click="clearCart()"> <span class="glyphicon glyphicon-remove-sign"></span> 
           Clear Card
       </a>
       
       <a href="#" class="btn btn-successpull-right"> <span class="glyphicon-shopping-cart glyphicon"></span> 
           Check out
       </a>
   </div>
   
   <table class="table table-hover">
       <tr>
           <th>Produit</th>
           <th>Prix unitaire</th>
           <th>Quantite</th>
           <th>Prix total</th>
           <th>Action a faire</th>
       </tr>
       
       <tr ng-repeat="item in card.cartItems">
           <td>{{item.product.codeProduit}}-{{item.product.nomProduit}}</td>
           <td>{{item.product.prixUnitaire}}</td>
           <td>{{item.quantite}}</td>
           <td>{{item.prixTotal}}</td>
           <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.codeProduit)"> <span class="glyphicon glyphicon-remove" /></span> Remove</a></td>
       </tr>
       
       <tr>
           <th></th>
           <th></th>
           <th>Total</th>
           <th>{{card.totalGeneral}}</th>
           <th></th>
       </tr>
   </table>
   <a href = "<spring:url value="/market/products" />" class="btn btn-default"><span class="glyphicon-hand-left glyphicon"></span> 
       Continue shopping
   </a>
   </div>
 </section>
 </html>