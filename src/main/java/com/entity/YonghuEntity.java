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
 * 学生
 *
 * @author 
 * @email
 */
@TableName("yonghu")
public class YonghuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YonghuEntity() {

	}

	public YonghuEntity(T t) {
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
     * 学号
     */
    @TableField(value = "yonghu_uuid_number")

    private String yonghuUuidNumber;


    /**
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 学生姓名
     */
    @TableField(value = "yonghu_name")

    private String yonghuName;


    /**
     * 家庭地址
     */
    @TableField(value = "yonghu_address")

    private String yonghuAddress;


    /**
     * 手机号
     */
    @TableField(value = "yonghu_phone")

    private String yonghuPhone;


    /**
     * 身份证号
     */
    @TableField(value = "yonghu_id_number")

    private String yonghuIdNumber;


    /**
     * 电子邮箱
     */
    @TableField(value = "yonghu_email")

    private String yonghuEmail;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 学院
     */
    @TableField(value = "xueyuan_types")

    private Integer xueyuanTypes;


    /**
     * 班级
     */
    @TableField(value = "banji_types")

    private Integer banjiTypes;


    /**
     * 假删
     */
    @TableField(value = "yonghu_delete")

    private Integer yonghuDelete;


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
	 * 设置：学号
	 */
    public String getYonghuUuidNumber() {
        return yonghuUuidNumber;
    }
    /**
	 * 获取：学号
	 */

    public void setYonghuUuidNumber(String yonghuUuidNumber) {
        this.yonghuUuidNumber = yonghuUuidNumber;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：学生姓名
	 */
    public String getYonghuName() {
        return yonghuName;
    }
    /**
	 * 获取：学生姓名
	 */

    public void setYonghuName(String yonghuName) {
        this.yonghuName = yonghuName;
    }
    /**
	 * 设置：家庭地址
	 */
    public String getYonghuAddress() {
        return yonghuAddress;
    }
    /**
	 * 获取：家庭地址
	 */

    public void setYonghuAddress(String yonghuAddress) {
        this.yonghuAddress = yonghuAddress;
    }
    /**
	 * 设置：手机号
	 */
    public String getYonghuPhone() {
        return yonghuPhone;
    }
    /**
	 * 获取：手机号
	 */

    public void setYonghuPhone(String yonghuPhone) {
        this.yonghuPhone = yonghuPhone;
    }
    /**
	 * 设置：身份证号
	 */
    public String getYonghuIdNumber() {
        return yonghuIdNumber;
    }
    /**
	 * 获取：身份证号
	 */

    public void setYonghuIdNumber(String yonghuIdNumber) {
        this.yonghuIdNumber = yonghuIdNumber;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getYonghuEmail() {
        return yonghuEmail;
    }
    /**
	 * 获取：电子邮箱
	 */

    public void setYonghuEmail(String yonghuEmail) {
        this.yonghuEmail = yonghuEmail;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：学院
	 */
    public Integer getXueyuanTypes() {
        return xueyuanTypes;
    }
    /**
	 * 获取：学院
	 */

    public void setXueyuanTypes(Integer xueyuanTypes) {
        this.xueyuanTypes = xueyuanTypes;
    }
    /**
	 * 设置：班级
	 */
    public Integer getBanjiTypes() {
        return banjiTypes;
    }
    /**
	 * 获取：班级
	 */

    public void setBanjiTypes(Integer banjiTypes) {
        this.banjiTypes = banjiTypes;
    }
    /**
	 * 设置：假删
	 */
    public Integer getYonghuDelete() {
        return yonghuDelete;
    }
    /**
	 * 获取：假删
	 */

    public void setYonghuDelete(Integer yonghuDelete) {
        this.yonghuDelete = yonghuDelete;
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
        return "Yonghu{" +
            "id=" + id +
            ", yonghuUuidNumber=" + yonghuUuidNumber +
            ", username=" + username +
            ", password=" + password +
            ", yonghuName=" + yonghuName +
            ", yonghuAddress=" + yonghuAddress +
            ", yonghuPhone=" + yonghuPhone +
            ", yonghuIdNumber=" + yonghuIdNumber +
            ", yonghuEmail=" + yonghuEmail +
            ", sexTypes=" + sexTypes +
            ", xueyuanTypes=" + xueyuanTypes +
            ", banjiTypes=" + banjiTypes +
            ", yonghuDelete=" + yonghuDelete +
            ", createTime=" + createTime +
        "}";
    }
}
