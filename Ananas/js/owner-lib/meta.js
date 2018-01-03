(function(){
	var ananasApp = angular.module("ananasApp",["ng","treeControl"]);
	
	ananasApp.controller("ananasCtrl", function($scope,$http,$location) {
		
		$scope.resultData = {};
		$scope.display = false;
		$scope.newMetaContext = {};
		
		$scope.metaDiv;
		//$scope.metaDivList = [];
		
	    //$scope.save = function (){
	    init($scope);
	    //}
	    
	    $scope.goMeta = function(){
	    	//$location.path("../../metaIndx.html");
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
		    			$scope.metaDivList = resData;
		    		}
		    	}
		        
		    }, function errorCallback(response) {
		    	//console.log(response);
			})
		}
	    
	    $scope.dipaly = function (){
	    	$scope.resultData.name = $scope.metaDiv.name;
			$scope.resultData.context = $scope.metaDiv.context;
	    	
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
	    
	    //tree
	    $scope.showSelected = function(sel) {
	        $scope.selectedNode = sel;
	    };
	    
	    $scope.treeOptions = {
    	    nodeChildren: "children",
    	    dirSelectable: true,
    	    injectClasses: {
    	        ul: "a1",
    	        li: "a2",
    	        liSelected: "a7",
    	        iExpanded: "a3",
    	        iCollapsed: "a4",
    	        iLeaf: "a5",
    	        label: "a6",
    	        labelSelected: "a8"
    	    }
    	};
    	$scope.dataForTheTree =
    	[
    	    { "name" : "Joe", "age" : "21", "children" : [
    	        { "name" : "Smith", "age" : "42", "children" : [] },
    	        { "name" : "Gary", "age" : "21", "children" : [
    	            { "name" : "Jenifer", "age" : "23", "children" : [
    	                { "name" : "Dani", "age" : "32", "children" : [] },
    	                { "name" : "Max", "age" : "34", "children" : [] }
    	            ]}
    	        ]}
    	    ]},
    	    { "name" : "Albert", "age" : "33", "children" : [] },
    	    { "name" : "Ron", "age" : "29", "children" : [] }
    	];

	});
	
})();
