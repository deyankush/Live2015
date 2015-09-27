(function(){
	angular.module("com.marketRoad").service('homeService',['$resource', '$http', function($resource,$http){
		var resource = $resource('/MarketRoadCore/customer/getCategories',  {},  {getCategories: {method: 'GET', isArray:true}});
		this.getCategoryDetails = function(){
			return resource.getCategories();
		}
	}]);
})();	