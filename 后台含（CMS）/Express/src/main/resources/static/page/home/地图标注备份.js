(function($scope,$http ){
	 
     
    var map = new BMap.Map("allmap");
  
    var start=new BMap.Point(108.66058,21.986593);
    var p1=new BMap.Point(108.321758, 22.832521 );
    var end=new BMap.Point( 110.203545,25.242887);
    
    map.centerAndZoom(start, 7);
    map.enableScrollWheelZoom();
    function newInstance( ){
    	  return new BMap.DrivingRoute(map,{
    		   	 onSearchComplete: function(result){
    		   		 if(result.xr[0]){
 		   				let dks = result.xr[0].dk;
 		   				let pointers = [];
 		   				for( let i = 0 ; i < dks.length ; i++ ){
 		   					 let dk = dks[i];
 		   					 for( let j=0 ; j < dk.Sr.length; j ++ ){
 		   						 let Uh = dk.Sr[j].Uh;
 		   						 pointers = pointers.concat(Uh);
 		   					 }
 		   				}
 		   				drawLine( pointers );
 		   			 }
    		   	 }
    		});
    }
  
    let middle = p1;
    let finish = newInstance( );
    finish.search(start, end ,{waypoints:[p1]} );
	function drawLine(Points ){
		//一刀两断，如意神剑。
	    let rs = findMiddle(Points,middle);
	    if(rs){
	    	let currentpoint = rs.left[ rs.left.length -1 ];
	    	var polyline = new  BMapLib.CurveLine(rs.left,
	    		    {strokeColor:"orange", strokeWeight:10, strokeOpacity:0.9}
	    		    );
	    	map.addOverlay(polyline);
	    	
	    	var polyline2 = new  BMapLib.CurveLine(rs.right,
	    		    {strokeColor:"gray", strokeWeight:10, strokeOpacity:0.9}
	    		    );
	    	map.addOverlay(polyline2);
	    	
	    	var marker = new BMap.Marker(currentpoint);  // 创建标注
	    	map.addOverlay(marker);              // 将标注添加到地图中
	    	var label = new BMap.Label("货物在这儿",{offset:new BMap.Size(-20,-20)});
	    	marker.setLabel(label);
	    	
	    }else{
	    	var polyline = new  BMapLib.CurveLine(Points,
	    		    {strokeColor:"orange", strokeWeight:10, strokeOpacity:0.9}
	    		    );
	    	map.addOverlay(polyline);
	    }
		 
	}
	
	function findMiddle( Points,middle){
		for(var i=0 ;i<Points.length ; i ++ ){
			 let p = Points[ i ];
			 if( Math.floor( Math.abs( p.lng*1000 - middle.lng*1000 ) ) <=1
				 &&
				 Math.floor( Math.abs( p.lat*1000 - middle.lat*1000 ) ) <=1
			   ){
				 return {
					 left:Points.splice(0,i+1),
					 right:Points
				 };
			 }
		}
		return null;
	}
	
	 
    
})