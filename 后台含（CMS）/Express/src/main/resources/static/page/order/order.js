(function($scope,$http ){
	layui.use([ "element", "form", "jquery", "table" ],function() {
		let table = layui.table;
		var $ = layui.jquery;
		var layer = layui.layer;
		let ordertable = null;
		//站点列表
		$scope.sitelist = [];
		$.get("site/getall.action",function(res){
			if(res.code == 0){
				$scope.sitelist = res.data;
				//angular重渲染
				$scope.$apply();
			}
		})
		
		//查询按钮 ： 要求发货站点不能为空
		$scope.query=()=>{
			if(!$scope.search || !$scope.search.send_site_id){
				layer.msg("请选择发货站点");
				return;
			}
			 $.get("order/getby.action",$scope.search,function(res){
				 ordertable.reload({
					 data:res.data
				 });
				 if( res.code == 0 ){
					 layer.msg(res.success);
				 }else{
					 layer.msg(res.srror);
				 }
			 })
		}
		//重置按钮
		$scope.reset=()=>{
			$scope.search=null;
		}
		//状态格式转换
		$scope.statusformat=function(status){
			//1未收件  2已收件未发货  3 已发货未送达  4已送达未派件  5 派件未签收  6 用户已经签收
			 if(status == 1)return  "未收件";
			 else if(status == 2)return  "未发货(已收件)";
			 else if(status == 3)return  "未到达(已发货)";
			 else if(status == 4)return  "已送达(未派件)";
			 else if(status == 5)return  "正在派件";
			 else if(status == 6)return  "用户已签收";
		}
	 
		//打印
		$scope.print=function( ){
			var checkStatus = table.checkStatus('ordertable'); //idTest 即为基础参数 id 对应的值
			let rowdatas = checkStatus.data;
			$scope.printlist = rowdatas;
			
			setTimeout(() => {
				for(let i=0;i<rowdatas.length;i++){
					 let id = "ercode"+(i+1);
					 let gen_id = $("#"+id).attr("data-orderid");
					 //生成一些二维码。
					 $("#"+id).qrcode({
							render: "canvas", //渲染方式 table|canvas
							width: 150, //宽度
							height:150, //高度
							text: gen_id //内容
					});
				}
				//windowPrint();
			}, 500);
			
			 
			let windowPrint =()=>{
				 let newwindw = window.open("");
				 //<link rel="stylesheet" href="layui/css/layui.css">
				 newwindw.document.write('<link rel="stylesheet" href="layui/css/layui.css">');
				 let html = $("#printeTemplate").html();
				 newwindw.document.write(  html  );
				 newwindw.onload=()=>{
					 newwindw.print();
				 };
			}; 
		}
		ordertable = table.render({
			elem : '#ordertable',
			height : 300,
		    data:[],
			cols : [ [ //表头
				{ type:"checkbox" ,width:40},
				{ field : 'id',title : '订单号',height:100  },
			    {field : 'send_username',title : '寄件人' ,width:100},
			    {field : 'send_addr_detail',title : '寄件地址' },
			    {field : 'rec_username',title : '收件人' ,width:100},
			    {field : 'rec_addr_detail',title : '收件地址' },
			    {field : 'box_id',title : '邮筒编号' ,width:90},
			    {field : 'creationtime',title : '时间' ,width:160,templet:function(d){
			    	return d.creationtime.replace(".0","");
			    }},
			    {title : '操作', 
					fixed:"right",
					align:'center',
					toolbar:'#barDemo2',
					width:100
				} 
			    ] ]
		});
		
		//监听订单详情按钮
		 table.on('tool(ordertable)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
		   var da = obj.data; //获得当前行数据
		   var layEvent = obj.event;
		   if(layEvent === 'detail'){ //查看位置
			    $.get("orderstatus/get.action?order_id="+da.id,function(res){
			    	 $scope.locationlist=res.data;
			    	 $scope.$apply();
			    	 $('#locationtable').show();
			    	 layer.open({
			    		 shade :0,
			    		 title:"进度信息",
			    		 isOutAnim: true,
			    		 area: ['500px', '400px'],
			    		  type: 1,
			    		  content: $('#locationtable'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
			    		  end(){
			    			  $('#locationtable').hide()
			    		  }
			    	 });
			    })
			   
		   } 
		 });
		
		
		 
	});
	
})