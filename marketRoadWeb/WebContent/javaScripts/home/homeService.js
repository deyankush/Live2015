(function(){
	angular.module("com.marketRoad").service('homeService',['$resource', '$http', function($resource,$http){
		var resource = $resource('/MarketRoad/unauth/products/getCategories',  {},  {getCategories: {method: 'GET', isArray:true}});
		this.getCategoryDetails = function(){
			return resource.getCategories();
		}
	}]);
})();	