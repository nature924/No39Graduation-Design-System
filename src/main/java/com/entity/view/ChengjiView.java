package com.entity.view;

import com.entity.ChengjiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 最终成绩
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chengji")
public class ChengjiView extends ChengjiEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 jiaoshi
			/**
			* 教师姓名
			*/
			private String jiaoshiName;
			/**
			* 手机号
			*/
			private String jiaoshiPhone;
			/**
			* 身份证号
			*/
			private String jiaoshiIdNumber;
			/**
			* 电子邮箱
			*/
			private String jiaoshiEmail;

		//级联表 keti
			/**
			* 课题名称
			*/
			private String ketiName;
			/**
			* 课题类型
			*/
			private Integer ketiTypes;
				/**
				* 课题类型的值
				*/
				private String ketiValue;
			/**
			* 课题内容
			*/
			private String ketiText;
			/**
			* 课题信息 的 教师
			*/
			private Integer ketiJiaoshiId;
			/**
			* 审核状态
			*/
			private Integer ketiYesnoTypes;
				/**
				* 审核状态的值
				*/
				private String ketiYesnoValue;
			/**
			* 审核结果
			*/
			private String ketiYesnoText;

		//级联表 yonghu
			/**
			* 学号
			*/
			private String yonghuUuidNumber;
			/**
			* 学生姓名
			*/
			private String yonghuName;
			/**
			* 家庭地址
			*/
			private String yonghuAddress;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 学院
			*/
			private Integer xueyuanTypes;
				/**
				* 学院的值
				*/
				private String xueyuanValue;
			/**
			* 班级
			*/
			private Integer banjiTypes;
				/**
				* 班级的值
				*/
				private String banjiValue;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public ChengjiView() {

	}

	public ChengjiView(ChengjiEntity chengjiEntity) {
		try {
			BeanUtils.copyProperties(this, chengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}















				//级联表的get和set jiaoshi

					/**
					* 获取： 教师姓名
					*/
					public String getJiaoshiName() {
						return jiaoshiName;
					}
					/**
					* 设置： 教师姓名
					*/
					public void setJiaoshiName(String jiaoshiName) {
						this.jiaoshiName = jiaoshiName;
					}

					/**
					* 获取： 手机号
					*/
					public String getJiaoshiPhone() {
						return jiaoshiPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setJiaoshiPhone(String jiaoshiPhone) {
						this.jiaoshiPhone = jiaoshiPhone;
					}

					/**
					* 获取： 身份证号
					*/
					public String getJiaoshiIdNumber() {
						return jiaoshiIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setJiaoshiIdNumber(String jiaoshiIdNumber) {
						this.jiaoshiIdNumber = jiaoshiIdNumber;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getJiaoshiEmail() {
						return jiaoshiEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setJiaoshiEmail(String jiaoshiEmail) {
						this.jiaoshiEmail = jiaoshiEmail;
					}






				//级联表的get和set keti

					/**
					* 获取： 课题名称
					*/
					public String getKetiName() {
						return ketiName;
					}
					/**
					* 设置： 课题名称
					*/
					public void setKetiName(String ketiName) {
						this.ketiName = ketiName;
					}

					/**
					* 获取： 课题类型
					*/
					public Integer getKetiTypes() {
						return ketiTypes;
					}
					/**
					* 设置： 课题类型
					*/
					public void setKetiTypes(Integer ketiTypes) {
						this.ketiTypes = ketiTypes;
					}


						/**
						* 获取： 课题类型的值
						*/
						public String getKetiValue() {
							return ketiValue;
						}
						/**
						* 设置： 课题类型的值
						*/
						public void setKetiValue(String ketiValue) {
							this.ketiValue = ketiValue;
						}

					/**
					* 获取： 课题内容
					*/
					public String getKetiText() {
						return ketiText;
					}
					/**
					* 设置： 课题内容
					*/
					public void setKetiText(String ketiText) {
						this.ketiText = ketiText;
					}

					/**
					* 获取：课题信息 的 教师
					*/
					public Integer getKetiJiaoshiId() {
						return ketiJiaoshiId;
					}
					/**
					* 设置：课题信息 的 教师
					*/
					public void setKetiJiaoshiId(Integer ketiJiaoshiId) {
						this.ketiJiaoshiId = ketiJiaoshiId;
					}


					/**
					* 获取： 审核状态
					*/
					public Integer getKetiYesnoTypes() {
						return ketiYesnoTypes;
					}
					/**
					* 设置： 审核状态
					*/
					public void setKetiYesnoTypes(Integer ketiYesnoTypes) {
						this.ketiYesnoTypes = ketiYesnoTypes;
					}


						/**
						* 获取： 审核状态的值
						*/
						public String getKetiYesnoValue() {
							return ketiYesnoValue;
						}
						/**
						* 设置： 审核状态的值
						*/
						public void setKetiYesnoValue(String ketiYesnoValue) {
							this.ketiYesnoValue = ketiYesnoValue;
						}

					/**
					* 获取： 审核结果
					*/
					public String getKetiYesnoText() {
						return ketiYesnoText;
					}
					/**
					* 设置： 审核结果
					*/
					public void setKetiYesnoText(String ketiYesnoText) {
						this.ketiYesnoText = ketiYesnoText;
					}















				//级联表的get和set yonghu

					/**
					* 获取： 学号
					*/
					public String getYonghuUuidNumber() {
						return yonghuUuidNumber;
					}
					/**
					* 设置： 学号
					*/
					public void setYonghuUuidNumber(String yonghuUuidNumber) {
						this.yonghuUuidNumber = yonghuUuidNumber;
					}

					/**
					* 获取： 学生姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 家庭地址
					*/
					public String getYonghuAddress() {
						return yonghuAddress;
					}
					/**
					* 设置： 家庭地址
					*/
					public void setYonghuAddress(String yonghuAddress) {
						this.yonghuAddress = yonghuAddress;
					}

					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 学院
					*/
					public Integer getXueyuanTypes() {
						return xueyuanTypes;
					}
					/**
					* 设置： 学院
					*/
					public void setXueyuanTypes(Integer xueyuanTypes) {
						this.xueyuanTypes = xueyuanTypes;
					}


						/**
						* 获取： 学院的值
						*/
						public String getXueyuanValue() {
							return xueyuanValue;
						}
						/**
						* 设置： 学院的值
						*/
						public void setXueyuanValue(String xueyuanValue) {
							this.xueyuanValue = xueyuanValue;
						}

					/**
					* 获取： 班级
					*/
					public Integer getBanjiTypes() {
						return banjiTypes;
					}
					/**
					* 设置： 班级
					*/
					public void setBanjiTypes(Integer banjiTypes) {
						this.banjiTypes = banjiTypes;
					}


						/**
						* 获取： 班级的值
						*/
						public String getBanjiValue() {
							return banjiValue;
						}
						/**
						* 设置： 班级的值
						*/
						public void setBanjiValue(String banjiValue) {
							this.banjiValue = banjiValue;
						}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}





}
