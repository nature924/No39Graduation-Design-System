package com.entity.vo;

import com.entity.KetirenwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 课题任务
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("ketirenwu")
public class KetirenwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 教师
     */

    @TableField(value = "jiaoshi_id")
    private Integer jiaoshiId;


    /**
     * 选题申请
     */

    @TableField(value = "xuantishenqing_id")
    private Integer xuantishenqingId;


    /**
     * 课题任务
     */

    @TableField(value = "ketirenwu_name")
    private String ketirenwuName;


    /**
     * 任务类型
     */

    @TableField(value = "ketirenwu_types")
    private Integer ketirenwuTypes;


    /**
     * 参考文献
     */

    @TableField(value = "ketirenwu_file")
    private String ketirenwuFile;


    /**
     * 阶段文档
     */

    @TableField(value = "ketirenwu_huida_file")
    private String ketirenwuHuidaFile;


    /**
     * 审核结果
     */

    @TableField(value = "ketirenwu_yesno_types")
    private Integer ketirenwuYesnoTypes;


    /**
     * 教师打分
     */

    @TableField(value = "ketirenwu_yesno_text")
    private String ketirenwuYesnoText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 nameShow
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
	 * 设置：选题申请
	 */
    public Integer getXuantishenqingId() {
        return xuantishenqingId;
    }


    /**
	 * 获取：选题申请
	 */

    public void setXuantishenqingId(Integer xuantishenqingId) {
        this.xuantishenqingId = xuantishenqingId;
    }
    /**
	 * 设置：课题任务
	 */
    public String getKetirenwuName() {
        return ketirenwuName;
    }


    /**
	 * 获取：课题任务
	 */

    public void setKetirenwuName(String ketirenwuName) {
        this.ketirenwuName = ketirenwuName;
    }
    /**
	 * 设置：任务类型
	 */
    public Integer getKetirenwuTypes() {
        return ketirenwuTypes;
    }


    /**
	 * 获取：任务类型
	 */

    public void setKetirenwuTypes(Integer ketirenwuTypes) {
        this.ketirenwuTypes = ketirenwuTypes;
    }
    /**
	 * 设置：参考文献
	 */
    public String getKetirenwuFile() {
        return ketirenwuFile;
    }


    /**
	 * 获取：参考文献
	 */

    public void setKetirenwuFile(String ketirenwuFile) {
        this.ketirenwuFile = ketirenwuFile;
    }
    /**
	 * 设置：阶段文档
	 */
    public String getKetirenwuHuidaFile() {
        return ketirenwuHuidaFile;
    }


    /**
	 * 获取：阶段文档
	 */

    public void setKetirenwuHuidaFile(String ketirenwuHuidaFile) {
        this.ketirenwuHuidaFile = ketirenwuHuidaFile;
    }
    /**
	 * 设置：审核结果
	 */
    public Integer getKetirenwuYesnoTypes() {
        return ketirenwuYesnoTypes;
    }


    /**
	 * 获取：审核结果
	 */

    public void setKetirenwuYesnoTypes(Integer ketirenwuYesnoTypes) {
        this.ketirenwuYesnoTypes = ketirenwuYesnoTypes;
    }
    /**
	 * 设置：教师打分
	 */
    public String getKetirenwuYesnoText() {
        return ketirenwuYesnoText;
    }


    /**
	 * 获取：教师打分
	 */

    public void setKetirenwuYesnoText(String ketirenwuYesnoText) {
        this.ketirenwuYesnoText = ketirenwuYesnoText;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
