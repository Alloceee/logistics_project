package com.express.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.express.bean.common.ResultData;
import com.express.common.controller.BaseController;
import com.express.entity.Mailbox;
import com.express.mapper.MailboxMapper;

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
@RequestMapping("/mailbox")
@Api("邮筒管理接口")
public class MailboxController extends BaseController {
   @Autowired
   private MailboxMapper mapper;
	
   @ApiOperation("添加邮筒")
   @PostMapping("insert.action")
   public ResultData insert( Mailbox box) {
	   info("添加邮筒："+box);
	   int row = mapper.insert(box);
	   return quickReturn(row);
}
   
   @ApiOperation("查找某个站点的邮筒")
   @GetMapping("list/{site_id}")
   public ResultData getBySiteId(@PathVariable("site_id") int site_id) {
	   info("查找邮筒"+ site_id);
	   List<Mailbox>  list = mapper.getBySiteId(site_id);
	   return ResultData.success().setData(list);
   }
   
   @ApiOperation("删除邮筒")
   @PostMapping("delete/{id}")
   public ResultData deleteById(@PathVariable("id")int id) {
	   info("删除邮筒"+ id);
	   int row  = mapper.deleteById(id);
	   return quickReturn(row);
   }
   
   @ApiOperation("查找邮筒")
   @GetMapping("one/{id}")
   public ResultData  getById(@PathVariable("id") int id) {
	   Mailbox mailbox = mapper.getById(id);
	   return ResultData.success().setData(mailbox);
   }
}
