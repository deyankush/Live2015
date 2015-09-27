(function(){
	angular.module("com.marketRoad").controller('loginCtrl',['$scope','loginService', function($scope, loginService){
		$scope.email = '';
		$scope.password= '';
		$scope.loginDetails = {};
		$scope.checkLogin = function(){
			loginService.getLoginDetails($scope.email, $scope.password).$promise.then(function(data){
				$scope.loginDetails = data;
			});
		}
	}]);
})();