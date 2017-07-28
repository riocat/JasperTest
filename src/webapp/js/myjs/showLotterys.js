var app = angular.module('app',[]);
app.controller('lotteryController',function($scope,$http){
	$scope.lotterys = {};
	
	$scope.init = function (){
		$http.get('lottery/showLotterys').success(function(responseData){
			if(responseData.result=='success'){
				$scope.lotterys = responseData.data;
			}else{
				alert(responseData.message);
			}
		});
	};
	
	$scope.init();
});