(function(){
	angular.module("com.marketRoad").service('loginService',['$resource', '$http', function($resource,$http){
		var resource = $resource('/MarketRoad/auth/customer/login',  {},  {login: {method: 'POST'}});
		this.getLoginDetails = function(email, password){
			var params = {
					userID : email,
					password : password
			};
			return resource.login(params);
		}
	}]);
})();	