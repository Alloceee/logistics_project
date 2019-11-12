package com.express.controller;


import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.express.bean.common.ResultData;
import com.express.common.controller.BaseController;
import com.express.entity.Address;
import com.express.mapper.AddressMapper;

import io.swagger.annotations.Api;
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
@RequestMapping("/address")
@Api(value = "统一地址接口")
public class AddressController extends BaseController {
	
	@Autowired
	private AddressMapper adm;
	 
 	@ApiOperation(value = "添加地址")
	@PostMapping("insert.action")
	public ResultData insert( Address add) {
 		info("保存参数："+add);
 		int num = adm.insert(add);
 		info("主键："+add.getId());
 		if( num > 0 ) {
 			return ResultData.success();
 		}else {
 			return ResultData.fail("添加失败");
 		}
 	}
 	
 	@ApiOperation(value = "查询所有地址")
	@GetMapping("getall.action")
	public ResultData getall( ) {
 		List<Address> list = adm.getAll();
 		return ResultData.success().setData( list );
 	}
 	
	@ApiOperation(value = "查询一个地址")
	@GetMapping("byid.action")
	public ResultData getById(Integer id ) {
		Address addr = adm.byId(id);
 		return ResultData.success().setData( addr );
 	}
	
	@ApiOperation(value = "删除一个地址")
	@PostMapping("deletebyid.action")
	public ResultData deleteById(Integer id ) {
		int row = adm.deleteById(id);
		if( row > 0 ) {
 			return ResultData.success();
 		}else {
 			return ResultData.fail("删除失败");
 		}
 	}
	
	@GetMapping("baiduMap.action")
	public void getBaiduMapJavaScript(HttpServletResponse rp ) {
		//1请求脚本。
		try {
			URL url = new URL("http://api.map.baidu.com/getscript?v=2.0&ak=U8sdm8dTbG5frQNg87IxYtY7OeEoyYOf");
			InputStream in = url.openConnection().getInputStream();
			byte [] bs = new byte[1024];
			rp.setContentType("text/javascript;charset=UTF-8");
			while(true) {
				int num = in.read(bs);
				if(num <=0 )break;
				rp.getOutputStream().write(bs, 0, num);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
 	}
	
	public static void main(String[] args) {
		
	}
	
	
}
