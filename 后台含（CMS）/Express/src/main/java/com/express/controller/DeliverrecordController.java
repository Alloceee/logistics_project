package com.express.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.express.bean.common.ResultData;
import com.express.common.controller.BaseController;
import com.express.entity.Deliverrecord;
import com.express.entity.Deliverrecorddetail;
import com.express.entity.Orderstatus;
import com.express.entity.Worker;
import com.express.entity.ext.BindDeliverVO;
import com.express.mapper.DeliverrecordMapper;
import com.express.mapper.OrderstatusMapper;
import com.express.service.IDeliverrecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
@RestController
@RequestMapping("/deliverrecord")
@Api("发货单接口")
public class DeliverrecordController extends BaseController {
	
	 @Autowired
	 private IDeliverrecordService service;
 
	
	@ApiOperation("新建发货单")
	@PostMapping("insert.action")
     public ResultData insert( Deliverrecord record) {
		 info("新建发货单信息："+record);
		 return service.insert(record);
     }
	
	
	@ApiOperation("查询发货基础信息")
	@GetMapping("get.action")
     public ResultData get( Deliverrecord record) {
		info("查询发货信息："+record);
		return  service.get(record);
     }
	
	
	@ApiOperation("查询发货详细信息")
	@GetMapping("getdetail.action")
     public ResultData getDetail( Deliverrecord record) {
		info("查询发货信息详情。"+record);
		return  service.getDetail(record);
     }
	
	
	
	@ApiOperation("将订单和发货单绑定在一起")
	@PostMapping("deliver/bind.action")
     public ResultData bindDeliverRecord(@RequestBody BindDeliverVO bindvo ) {
		info("绑定发货单："+bindvo);
		return  service.bindDeliverRecord(bindvo);
     }
	
	@ApiOperation("将订单和发货单解除绑定关。微信小程序请求。")
	@PostMapping("deliver/unbind.action")
     public ResultData  unbindDeliverRecord(@RequestBody Deliverrecorddetail detail ) {
		info("解绑发货单："+detail);
		return  service.unbindDeliverRecord(detail);
     }
	
	@ApiOperation("发货发货发货。CMS请求 所以form-data格式就行。")
	@GetMapping("deliver.action")
	 public  ResultData updateStatus(int id,HttpServletRequest rq) {
		info("用户修改发货单状态："+id);
		HttpSession ss = rq.getSession(false);
		if(ss == null) {
			return ResultData.fail("请先登陆！");
		}
		return service.deliver(id,(Worker)ss.getAttribute("worker"));
	}
	
	@ApiOperation("根据发货单号获取发货清单列表。CMS请求 所以form-data格式就行。")
	@GetMapping("getorderbyid.action")
	 public  ResultData getOrderListById(int id) {
		info("用户获取发货清单："+id);
		return service.getOrderListById(id);
	}
	
 
}
