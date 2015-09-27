/**
 * 
 */
(function(){
	var mall = angular.module("com.marketRoad", ['ui.router', 'ngResource']);
	mall.config(['$stateProvider', '$urlRouterProvider',function($stateProvider, $urlRouterProvider){
		$stateProvider.state('home', { 
			url: '/home',
			templateUrl: "views/home/home.html",
			controller: 'homeCtrl'
		});
		$stateProvider.state('login', { 
			url: '/login',
			templateUrl: "views/login/login.html",
			controller: 'loginCtrl'
		});
		$urlRouterProvider.otherwise('/home');
	}]);
})();