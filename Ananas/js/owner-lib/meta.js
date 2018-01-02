(function(){
	var ananasApp = angular.module("ananasApp",["ng"]);
	
	ananasApp.controller("ananasCtrl", function($scope,$http) {
		
		$scope.resultData = {};
		$scope.display = false;
		$scope.newMetaContext = {};
		
	    $scope.save = function (){
	    	init($scope);
	    }
	
	    function init (_$scope){
			$http({
			    method: 'POST',
			    url: 'http://localhost:8080/Ananas/meta/getDivMeta'
			}).then(function successCallback(response) {
		        console.log(response);
		        
		        if(response != null && response.status == 200){
		    		var resData = response.data;
		    		if(resData != undefined){
		    			_$scope.resultData.name = resData[0].name;
		    			_$scope.resultData.context = resData[0].context;
		    		}
		    	}
		        
		    }, function errorCallback(response) {
		    	//console.log(response);
			})
		}
	    
	    $scope.dipaly = function (){
	    	$scope.display = !$scope.display;
	    	var metaContext = angular.fromJson($scope.resultData.context);
	    	console.log(metaContext);
	    	//var props = metaContext.prop;
	    	//var temp = metaContext.temp;
	    	
	    	$scope.metaContext = metaContext;
	    }
	    
	    $scope.subt = function(){
	    	console.log($scope.newMetaContext);
	    	
	    	var　subMeta = $scope.newMetaContext;
	    	
	    	var metaContext = $scope.metaContext;
	    	//$scope.resultData.name = 
	    	rebuild(subMeta);
	    	
	    }
	    
	    function rebuild(subMeta){
	    	var subResultData = {};
	    	subResultData.name = subMeta.newname;
	    	subResultData.context = [];
	    	var subItemTemp = {"temp":$scope.metaContext.temp};
	    	var subItemProp = {};
	    	
	    	/*angular.forEach(subMeta.prop,function(pp){
	    		subItemProp[pp] = subMeta.prop[pp];
	    	});*/
	    	
	    	for (x in subMeta.prop){
	    		subItemProp[x] = subMeta.prop[x];
	    	}
	    	subItemTemp.prop = subItemProp;
	    	subResultData.context.push(subItemTemp);
	    	
	    	console.log(subResultData);
	    	
	    }

	});
	
})();
