(function(){
	var ananasApp = angular.module("ananasApp",["ng","treeControl"]);
	
	ananasApp.controller("ananasCtrl",ananasCtrl);
	ananasApp.service("ananasService",ananasService);
	
	ananasService.$inject = ['$http'];
	function ananasService($http){	
		
		//var url = "http://localhost:8080/Ananas/";
		var defaultHeader = {
				method : "POST",
				dataType:"json",      
	            contentType:"application/json"
		};
		
		
		this.anajax = anajax;
		function anajax(header,success,error){
			$http(angular.extend(defaultHeader,header)).then(function successCallback(response) {
		        if(response != null && response.status == 200){		    
		    		if(response.data != undefined){
		    			success(response.data);
		    		}
		    	}    
		    }, function errorCallback(response) {
		    	error(response);
			})
		}
	}
	
	ananasCtrl.$inject = ['$scope','$location','ananasService'];
	function ananasCtrl($scope,$location,ananasService){
		
		//$scope.resultData = {};
		//$scope.display = false;
		//$scope.newMetaContext = {};
		
		$scope.metaModelInst = {};  //meta 模板实例存储数据模型
		
		//$scope.metaDiv;            //选择中 div模板
		//$scope.metaDivList = [];   //div 列表
		
		//启动时 加载div list 列表
		initController($scope);
	    
	    
	    function initController(_$scope){
	    	ananasService.anajax({
			    url: 'http://localhost:8080/Ananas/meta/getDivMeta'
			},function(data){	
				_$scope.metaDivList = data; 
				console.log(_$scope.metaDivList);
			},function(response){
				console.log(response);
			})
	    };
	    
	
	   
	    $scope.dipaly = function (){
	    	//$scope.resultData.name = $scope.metaDiv.name;
			//$scope.resultData.context = $scope.metaDiv.context;
	    	
	    	//$scope.display = !$scope.display;
	    	//var metaContext = angular.fromJson($scope.metaDiv.context);
	    	//console.log(metaContext);
	    	//var props = metaContext.prop;
	    	//var temp = metaContext.temp;
	    	//$scope.resultData.context = metaContext.temp;
	    	
	    	//$scope.metaContext = metaContext;
	    }

	    
	    $scope.applyDiv = function(){
	    	$scope.metaModelInst.temp = $scope.metaDiv.temp;
	    	
	    	var treeObj = {"name":$scope.metaModelInst.name,"type":$scope.metaDiv.name,children:[]};
	    	$scope.selectedNode.children.push(treeObj);
	    	
	    	console.log($scope.dataForTheTree);
	    	console.log($scope.subResultData);
	    	
	    	ananasService.anajax({
	    		url: 'http://localhost:8080/Ananas/meta/saveMetaDivInst',
			    data:{"configMeta":{"name":$scope.metaModelInst.name,"treeConfig":$scope.dataForTheTree},"inst":$scope.metaModelInst}
			},function(data){	
				console.log(data);
			},function(response){
				console.log(response);
			})
	    }
	    
	    $scope.prewView = function(){
	    	ananasService.anajax({
	    		url: 'http://localhost:8080/Ananas/meta/prewViewMetaDivInst',
			    data:{"name":"a"}
			},function(data){	
				console.log(data);
			},function(response){
				console.log(response);
			})
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
	    
	    var dataForTheTree = [{"name":"root","type":"root","children":[]}];
	    
	    $scope.dataForTheTree = dataForTheTree;
	    
	    
    	/*$scope.dataForTheTree =
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
*/
	}
	
})();
