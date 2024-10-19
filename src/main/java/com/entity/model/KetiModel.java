package com.entity.model;

import com.entity.KetiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 课题信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KetiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 课题名称
     */
    private String ketiName;


    /**
     * 课题类型
     */
    private Integer ketiTypes;


    /**
     * 课题内容
     */
    private String ketiText;


    /**
     * 教师
     */
    private Integer jiaoshiId;


    /**
     * 审核状态
     */
    private Integer ketiYesnoTypes;


    /**
     * 审核结果
     */
    private String ketiYesnoText;


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
	 * 获取：课题名称
	 */
    public String getKetiName() {
        return ketiName;
    }


    /**
	 * 设置：课题名称
	 */
    public void setKetiName(String ketiName) {
        this.ketiName = ketiName;
    }
    /**
	 * 获取：课题类型
	 */
    public Integer getKetiTypes() {
        return ketiTypes;
    }


    /**
	 * 设置：课题类型
	 */
    public void setKetiTypes(Integer ketiTypes) {
        this.ketiTypes = ketiTypes;
    }
    /**
	 * 获取：课题内容
	 */
    public String getKetiText() {
        return ketiText;
    }


    /**
	 * 设置：课题内容
	 */
    public void setKetiText(String ketiText) {
        this.ketiText = ketiText;
    }
    /**
	 * 获取：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：教师
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getKetiYesnoTypes() {
        return ketiYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setKetiYesnoTypes(Integer ketiYesnoTypes) {
        this.ketiYesnoTypes = ketiYesnoTypes;
    }
    /**
	 * 获取：审核结果
	 */
    public String getKetiYesnoText() {
        return ketiYesnoText;
    }


    /**
	 * 设置：审核结果
	 */
    public void setKetiYesnoText(String ketiYesnoText) {
        this.ketiYesnoText = ketiYesnoText;
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
