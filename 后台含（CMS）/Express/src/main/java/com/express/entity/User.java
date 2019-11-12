package com.express.entity;

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
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String openid;

    @ApiModelProperty(value = "微信名称")
    private String nickname;

    @ApiModelProperty(value = "头像地址")
    private String avatarurl;

    @ApiModelProperty(value = "性别 1男  2女")
    private Integer gender;

    @ApiModelProperty(value = "用户的联系方式")
    private String tel;
    
    @ApiModelProperty(value = "用户注册时间")
    private String creationtime;
    
    @ApiModelProperty(value = "用户最后登陆时间")
    private String lastupdate;
    
    
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

	public String getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}

	@Override
	public String toString() {
		return "User [openid=" + openid + ", nickname=" + nickname + ", avatarurl=" + avatarurl + ", gender=" + gender
				+ ", tel=" + tel + ", creationtime=" + creationtime + ", lastupdate=" + lastupdate + "]";
	}
 
}
