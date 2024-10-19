package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 课题信息
 *
 * @author 
 * @email
 */
@TableName("keti")
public class KetiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KetiEntity() {

	}

	public KetiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 课题名称
     */
    @TableField(value = "keti_name")

    private String ketiName;


    /**
     * 课题类型
     */
    @TableField(value = "keti_types")

    private Integer ketiTypes;


    /**
     * 课题内容
     */
    @TableField(value = "keti_text")

    private String ketiText;


    /**
     * 教师
     */
    @TableField(value = "jiaoshi_id")

    private Integer jiaoshiId;


    /**
     * 审核状态
     */
    @TableField(value = "keti_yesno_types")

    private Integer ketiYesnoTypes;


    /**
     * 审核结果
     */
    @TableField(value = "keti_yesno_text")

    private String ketiYesnoText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：课题名称
	 */
    public String getKetiName() {
        return ketiName;
    }
    /**
	 * 获取：课题名称
	 */

    public void setKetiName(String ketiName) {
        this.ketiName = ketiName;
    }
    /**
	 * 设置：课题类型
	 */
    public Integer getKetiTypes() {
        return ketiTypes;
    }
    /**
	 * 获取：课题类型
	 */

    public void setKetiTypes(Integer ketiTypes) {
        this.ketiTypes = ketiTypes;
    }
    /**
	 * 设置：课题内容
	 */
    public String getKetiText() {
        return ketiText;
    }
    /**
	 * 获取：课题内容
	 */

    public void setKetiText(String ketiText) {
        this.ketiText = ketiText;
    }
    /**
	 * 设置：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }
    /**
	 * 获取：教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getKetiYesnoTypes() {
        return ketiYesnoTypes;
    }
    /**
	 * 获取：审核状态
	 */

    public void setKetiYesnoTypes(Integer ketiYesnoTypes) {
        this.ketiYesnoTypes = ketiYesnoTypes;
    }
    /**
	 * 设置：审核结果
	 */
    public String getKetiYesnoText() {
        return ketiYesnoText;
    }
    /**
	 * 获取：审核结果
	 */

    public void setKetiYesnoText(String ketiYesnoText) {
        this.ketiYesnoText = ketiYesnoText;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Keti{" +
            "id=" + id +
            ", ketiName=" + ketiName +
            ", ketiTypes=" + ketiTypes +
            ", ketiText=" + ketiText +
            ", jiaoshiId=" + jiaoshiId +
            ", ketiYesnoTypes=" + ketiYesnoTypes +
            ", ketiYesnoText=" + ketiYesnoText +
            ", createTime=" + createTime +
        "}";
    }
}
