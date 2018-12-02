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
<p>All the available products in our store</p> 

<section class="container">
    <div class="row">
        <c:forEach items="${products}" var="product">
            <article class="col-sm-6" itemtype="http://schema.org/NewsArticle" itemscope="">
            <div class="panel-body">
                <h3>${product.codeProduit}</h3>
                <h3>${product.nomProduit}</h3>
                <p>${product.prixUnitaire} USD</p>
                <p>
                    <a href=" <spring:url value="/market/product?id=${product.codeProduit}" /> " >
                        <span/></span> Details
                    </a>
                </p>
            </div>
            </article>
        </c:forEach>
    </div>
</section>

</html>