package com.express.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
@ApiModel(value="驾驶员对象", description="")
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;

    
    private Integer id;

    @ApiModelProperty(value = "驾驶员名字")
    private String name;

    @ApiModelProperty(value = "电话")
    private String tel;

    @ApiModelProperty("入驻时间")
    private String creationtime;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(String creationtime) {
		this.creationtime = creationtime;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", tel=" + tel + ", creationtime=" + creationtime + "]";
	}

	 
}
