package com.express.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.express.bean.common.ResultData;
import com.express.common.controller.BaseController;
import com.express.entity.Order;
import com.express.entity.ext.UpdateOrder;
import com.express.entity.ext.UpdateOrderList;
import com.express.mapper.OrderMapper;
import com.express.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 *  前端控制器
 * </p>
 * @author haiger412
 * @since 2019-10-13
 */
@RestController
@RequestMapping("/order")
@Api("订单接口")
public class OrderController extends BaseController{
	@Autowired
	private OrderMapper mapper;
	
	@Autowired
	private IOrderService service;
	
	@PostMapping("insert.action")
	public ResultData insert(@RequestBody Order order,HttpSession ss) {
		 info("用户下单信息："+ order);
		 String openid = (String) ss.getAttribute("openid");
		 if( openid == null ) {
			 error("用户未登录。请先登陆！");
			 return ResultData.fail("用户未登录。请先登陆！");
		 }
		 int row = mapper.insert(order);
		return quickReturn(row).setData( order );
	}
	
	@ApiModelProperty("获取我的订单")
	@GetMapping("getmyorders.action")
	public ResultData getMyOrders(String status, HttpSession ss) {
		
		 String openid = (String) ss.getAttribute("openid");
		 if( openid == null ) {
			 error("用户未登录。请先登陆！");
			 return ResultData.fail("请先登陆！");
		 }
		 Order od = new Order();
		 od.setOpenid( openid);
		 //
		 if(status!=null && !"".equals( status.trim() )) {
			  od.setStatus( Integer.parseInt( status ));
		 }
		 return ResultData.success().setData( mapper.get( od )  );
	}
	
	
	@ApiModelProperty("根据条件查找订单")
	@GetMapping("getby.action")
	public ResultData getMyOrders(Order order ) {
		 return quickReturn(  mapper.get( order ) );
	}
	
	@ApiModelProperty("更新单个订单状态")
	@PostMapping("update.action")
	public ResultData updateStatus1(UpdateOrder updateorder) {
		info("更新单个订单信息  "+updateorder);
		return service.updateStatus(updateorder);
	}
	
	@ApiModelProperty("批量更新订单状态。暂时未加权限控制，后期要加权限控制。")
	@PostMapping("list/update.action")
	public ResultData updateStatus2(@RequestBody UpdateOrderList orlist) {
		info("批量订单信息  "+orlist);
		return service.updateStatus( orlist);
	}
	
}
