package com.entity.model;

import com.entity.XuantishenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 选题申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XuantishenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 课题编号
     */
    private String xuantishenqingUuidNumber;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 课题
     */
    private Integer ketiId;


    /**
     * 申请状态
     */
    private Integer xuantishenqingYesnoTypes;


    /**
     * 申请结果
     */
    private String xuantishenqingYesnoText;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：课题编号
	 */
    public String getXuantishenqingUuidNumber() {
        return xuantishenqingUuidNumber;
    }


    /**
	 * 设置：课题编号
	 */
    public void setXuantishenqingUuidNumber(String xuantishenqingUuidNumber) {
        this.xuantishenqingUuidNumber = xuantishenqingUuidNumber;
    }
    /**
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：学生
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：课题
	 */
    public Integer getKetiId() {
        return ketiId;
    }


    /**
	 * 设置：课题
	 */
    public void setKetiId(Integer ketiId) {
        this.ketiId = ketiId;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getXuantishenqingYesnoTypes() {
        return xuantishenqingYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setXuantishenqingYesnoTypes(Integer xuantishenqingYesnoTypes) {
        this.xuantishenqingYesnoTypes = xuantishenqingYesnoTypes;
    }
    /**
	 * 获取：申请结果
	 */
    public String getXuantishenqingYesnoText() {
        return xuantishenqingYesnoText;
    }


    /**
	 * 设置：申请结果
	 */
    public void setXuantishenqingYesnoText(String xuantishenqingYesnoText) {
        this.xuantishenqingYesnoText = xuantishenqingYesnoText;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
