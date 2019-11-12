//1 layui初始化
layui.use([ "element"  ], function() { });

//2 angular初始化
const app = angular.module('Express_Sys',['ngRoute']);


//3 页面配置。
const pages={
		//suffix:"page/",
		//prefix:"",
		config:[
				["/address","page/address/address","addressCtrl"],
				["/home","page/home/home","homeCtrl"],
				["/site","page/site/site","siteCtrl"],
				["/worker","page/worker/worker","workerCtrl"],
				["/mailbox","page/mailbox/mailbox","mailboxCtrl"],
				["/route","page/route/route","routeCtrl"],
				["/driver","page/driver/driver","driverCtrl"],
				["/truck","page/truck/truck","truckCtrl"],
				["/order","page/order/order","orderCtrl"],
				["/deliver","page/deliver/deliver","deliverCtrl"],
				["/","page/home/home","homeCtrl"],
			]
};


//4路由配置。
app.config(['$routeProvider', function($routeProvider){
	for(var i=0;i<pages.config.length;i++){
		var conf = pages.config[i];
		(function(){
			let uul = conf[1];
			$routeProvider.when(conf[0],{
		    	templateUrl:conf[1]+".html",
		    	controller:conf[2] ,
		        resolve:{
		        	url:function(){
		        		return uul;
		        	}
		        } 
		    })
		})();
	}
    $routeProvider.otherwise({redirectTo:'/'});
}]);

//5 Controller配置
for(var i=0;i<pages.config.length;i++){
	var conf = pages.config[i];
	app.controller(conf[2], function( $scope,$http ){
		 //加载一个js  并把$scope传递给它。
		if($scope.$resolve){
			require($scope.$resolve.url+".js",arguments );
		}
	});
}

//6 动态加载js 
function require(path,args){
	 layui.use(["jquery"],function(){
		var jq = layui.jquery;
		jq.getScript(path, function(data, status, jqxhr) {
			 let callback = eval(data);
			 callback.apply(null,args);
			 args[0].$apply();
		});
	});
}