package com.entity.vo;

import com.entity.XuantishenqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 选题申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuantishenqing")
public class XuantishenqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 课题编号
     */

    @TableField(value = "xuantishenqing_uuid_number")
    private String xuantishenqingUuidNumber;


    /**
     * 学生
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 课题
     */

    @TableField(value = "keti_id")
    private Integer ketiId;


    /**
     * 申请状态
     */

    @TableField(value = "xuantishenqing_yesno_types")
    private Integer xuantishenqingYesnoTypes;


    /**
     * 申请结果
     */

    @TableField(value = "xuantishenqing_yesno_text")
    private String xuantishenqingYesnoText;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：课题编号
	 */
    public String getXuantishenqingUuidNumber() {
        return xuantishenqingUuidNumber;
    }


    /**
	 * 获取：课题编号
	 */

    public void setXuantishenqingUuidNumber(String xuantishenqingUuidNumber) {
        this.xuantishenqingUuidNumber = xuantishenqingUuidNumber;
    }
    /**
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：课题
	 */
    public Integer getKetiId() {
        return ketiId;
    }


    /**
	 * 获取：课题
	 */

    public void setKetiId(Integer ketiId) {
        this.ketiId = ketiId;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getXuantishenqingYesnoTypes() {
        return xuantishenqingYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setXuantishenqingYesnoTypes(Integer xuantishenqingYesnoTypes) {
        this.xuantishenqingYesnoTypes = xuantishenqingYesnoTypes;
    }
    /**
	 * 设置：申请结果
	 */
    public String getXuantishenqingYesnoText() {
        return xuantishenqingYesnoText;
    }


    /**
	 * 获取：申请结果
	 */

    public void setXuantishenqingYesnoText(String xuantishenqingYesnoText) {
        this.xuantishenqingYesnoText = xuantishenqingYesnoText;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
