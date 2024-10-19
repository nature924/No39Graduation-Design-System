package com.entity.model;

import com.entity.KetirenwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 课题任务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KetirenwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 教师
     */
    private Integer jiaoshiId;


    /**
     * 选题申请
     */
    private Integer xuantishenqingId;


    /**
     * 课题任务
     */
    private String ketirenwuName;


    /**
     * 任务类型
     */
    private Integer ketirenwuTypes;


    /**
     * 参考文献
     */
    private String ketirenwuFile;


    /**
     * 阶段文档
     */
    private String ketirenwuHuidaFile;


    /**
     * 审核结果
     */
    private Integer ketirenwuYesnoTypes;


    /**
     * 教师打分
     */
    private String ketirenwuYesnoText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 nameShow
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
	 * 获取：选题申请
	 */
    public Integer getXuantishenqingId() {
        return xuantishenqingId;
    }


    /**
	 * 设置：选题申请
	 */
    public void setXuantishenqingId(Integer xuantishenqingId) {
        this.xuantishenqingId = xuantishenqingId;
    }
    /**
	 * 获取：课题任务
	 */
    public String getKetirenwuName() {
        return ketirenwuName;
    }


    /**
	 * 设置：课题任务
	 */
    public void setKetirenwuName(String ketirenwuName) {
        this.ketirenwuName = ketirenwuName;
    }
    /**
	 * 获取：任务类型
	 */
    public Integer getKetirenwuTypes() {
        return ketirenwuTypes;
    }


    /**
	 * 设置：任务类型
	 */
    public void setKetirenwuTypes(Integer ketirenwuTypes) {
        this.ketirenwuTypes = ketirenwuTypes;
    }
    /**
	 * 获取：参考文献
	 */
    public String getKetirenwuFile() {
        return ketirenwuFile;
    }


    /**
	 * 设置：参考文献
	 */
    public void setKetirenwuFile(String ketirenwuFile) {
        this.ketirenwuFile = ketirenwuFile;
    }
    /**
	 * 获取：阶段文档
	 */
    public String getKetirenwuHuidaFile() {
        return ketirenwuHuidaFile;
    }


    /**
	 * 设置：阶段文档
	 */
    public void setKetirenwuHuidaFile(String ketirenwuHuidaFile) {
        this.ketirenwuHuidaFile = ketirenwuHuidaFile;
    }
    /**
	 * 获取：审核结果
	 */
    public Integer getKetirenwuYesnoTypes() {
        return ketirenwuYesnoTypes;
    }


    /**
	 * 设置：审核结果
	 */
    public void setKetirenwuYesnoTypes(Integer ketirenwuYesnoTypes) {
        this.ketirenwuYesnoTypes = ketirenwuYesnoTypes;
    }
    /**
	 * 获取：教师打分
	 */
    public String getKetirenwuYesnoText() {
        return ketirenwuYesnoText;
    }


    /**
	 * 设置：教师打分
	 */
    public void setKetirenwuYesnoText(String ketirenwuYesnoText) {
        this.ketirenwuYesnoText = ketirenwuYesnoText;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
