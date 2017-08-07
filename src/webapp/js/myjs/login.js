$(function() {
	$('#test').click(function() {
		location.href = "test/toTest";
	});
});

var app = angular.module('login', []);
app.controller('loginController', function($scope, $http) {
	$scope.user = {};
	$scope.rePassword = null;
	$scope.checkcode = null;
	$scope.type = 'login';
	$scope.successMessage = null;
	$scope.errorMessage = null;

	$scope.showLogin = function() {
		$scope.user = {};
		$scope.successMessage = null;
		$scope.errorMessage = null;
		$('#identifier').modal('show');
	}

	$scope.showRegester = function() {
		$scope.user = {};
		$scope.type = 'regester';
		$scope.successMessage = null;
		$scope.errorMessage = null;
		$('#identifier').modal('show');
	}

	$scope.login = function() {
		$http.post('login', JSON.stringify($scope.user)).success(
				function(responseData) {
					if (responseData.result == 'success') {
						location.href = "logined/user/main";
					} else {
						$scope.errorMessage = responseData.message;
					}
				});

		// $.ajax({
		// url : 'user/login',
		// method : 'POST',
		// data : JSON.stringify($scope.user),
		// // dataType : 'json',
		// contentType : 'application/json;charset=UTF-8',
		// success : function(responseData) {
		// if (responseData.result == 'success') {
		// location.href = "";
		// }
		// }
		// });
	}

	$scope.refreshCheckCode = function() {
		$('#checkImage').attr("src", "rescource/checkImg?"+Math.random());
	}

	$scope.regester = function() {
		$http.post('user/regester',$scope.user).success(function(responseData) {
			if(responseData.result == 'success'){
				$scope.successMessage = responseData.message;
				
			}
			if(responseData.result == 'fail'){
				$scope.errorMessage = responseData.message;
			}
		});
	}

	$scope.toshowLotterys = function() {
		location.href = "lottery/toShowLotterys";
	}
});
