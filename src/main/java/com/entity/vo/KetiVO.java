package com.entity.vo;

import com.entity.KetiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 课题信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("keti")
public class KetiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
