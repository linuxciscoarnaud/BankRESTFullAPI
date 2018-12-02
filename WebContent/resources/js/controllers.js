/**
 * 
 */

var cardApp = angular.module('cardApp', []);

cardApp.controller('cardCtrl', function($scope, $http) {
	$scope.refreshCard = function(cardId) {
		$http.get('/BankRESTFullAPI/rest/card/' + $scope.cardId).success(function(data) {
			$scope.card = data;
		});
	};
	
	$scope.clearCard = function() {
		$http.delete('/BankRESTFullAPI/rest/card/' + $scope.cardId).success(function(data) {
			$scope.refreshCard($scope.cardId);
		});
	};
	
	$scope.initCardId = function(cardId) {
		$scope.cardId = cardId;
		$scope.refreshCard($scope.cardId);
	};
	
	$scope.addToCard = function(codeProduit) {
		$http.put('/BankRESTFullAPI/rest/card/add/' + codeProduit).success(function(data) {
			alert("Product Successfully added to the Card!");
		});
	};
	
	$scope.removeFromCard = function(codeProduit) {
		$http.put('/BankRESTFullAPI/rest/card/remove/' + codeProduit).success(function(data) {
			$scope.refreshCard($scope.cardId);
		});
	};
});