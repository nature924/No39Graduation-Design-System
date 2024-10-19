package com.entity.view;

import com.entity.KetiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 课题信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("keti")
public class KetiView extends KetiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 课题类型的值
		*/
		private String ketiValue;
		/**
		* 审核状态的值
		*/
		private String ketiYesnoValue;



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

	public KetiView() {

	}

	public KetiView(KetiEntity ketiEntity) {
		try {
			BeanUtils.copyProperties(this, ketiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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












}
