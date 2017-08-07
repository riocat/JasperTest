$(function(){
    $('#imgLableSpan').hover(function(){
        $('#userInfoMenu').css('display','block');
    },function(){
        $('#userInfoMenu').css('display','none');
    });
    $('#userInfoMenu').hover(function(){
        $('#userInfoMenu').css('display','block');
    },function(){
        $('#userInfoMenu').css('display','none');
    });
});

var app = angular.module('main',[]);
app.controller('mainController',function($scope,$http){

});
