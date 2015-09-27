(function(){
	angular.module("com.marketRoad").controller('mainCtrl',['$scope','homeService', function($scope, homeService){
		
		$scope.categoryDetails = {};
		$scope.categoryDet = function(){
			homeService.getCategoryDetails().$promise.then(function(data){
				$scope.categoryDetails = data;
			});
		}
		$scope.categoryDet();
	}]);
})();	