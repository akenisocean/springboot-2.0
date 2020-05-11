package com.ocean.springcloud.oceanmybaitsplus.excel;


import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 关于操作Excel文件的导出和导入
 * 	使用此工具类操作的实体类要在实体类属性上方加入
 * 		@PropertiesName(name = "xxx"); xxx: Excel的表头
 * 
 * @author chao
 * 
 * 
 * <dependency> 
 * 	<groupId>org.apache.poi</groupId>
 * 	<artifactId>poi-ooxml</artifactId>
 * 	<version>3.17</version>
 * </dependency>
 */
public class ExcelUtils {

	public ExcelUtils() {
		throw new RuntimeException("工具类不允许实例化对象");
	}

	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 转换list集合到Excel中, 集合中对象的属性需要至少有一个打上 @PropertiesName 注解
	 * 
	 * @param list 要转换的集合
	 * @param outFile 输出地址
	 * @return 是否转换成功
	 * @throws Exception
	 */
	public static <T> boolean pojo2ExcelWithFile(List<T> list, File outFile) throws Exception {

		if (null != list && list.size() > 0) {

			T t = list.get(0);
			Class<? extends Object> clazz = t.getClass();

			// 判断要导出的类是否存在 "属性命名" 注解
			if (isExisitBeanPropertiesAnnotation(clazz)) {

				HSSFWorkbook excel = generate(list);
				excel.write(outFile);
				excel.close();
				return true;

			} else {
				throw new IllegalArgumentException("传入的类属性中没有加入@PropertiesName注解");
			}

		}

		return false;

	}

	/**
	 * 转换list集合到Excel中, 集合中对象的属性需要至少有一个打上 @PropertiesName 注解
	 *
	 * @param list 要转换的集合
	 * @param outputStream 输出流
	 * @return 是否转换成功
	 * @throws Exception
	 */
	public static <T> boolean pojo2ExcelWithOutputStream(List<T> list, OutputStream outputStream) throws Exception {

		if (null != list && list.size() > 0) {

			T t = list.get(0);
			Class<? extends Object> clazz = t.getClass();

			// 判断要导出的类是否存在 "属性命名" 注解
			if (isExisitBeanPropertiesAnnotation(clazz)) {

				HSSFWorkbook excel = generate(list);
				excel.write(outputStream);
				excel.close();
				return true;

			} else {
				throw new IllegalArgumentException("传入的类属性中没有加入@PropertiesName注解");
			}

		}

		return false;

	}
	
	/**
	 * 转换list集合到Excel中, 集合中对象的属性需要至少有一个打上 @PropertiesName 注解
	 * 	带追加功能
	 * 
	 * @param list 要转换的集合
	 * @param outFile 输出地址
	 * @param isAppend true: 追加, fals: 不追加
	 * @param sortArr 排序功能, isAppend为false则此属性无效, 如:new String[] {"id", "name", "age", "address"}
	 * 					传递的都是bean的属性, 会按照这个顺序追加写出去
	 * @return 是否转换成功
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static <T> boolean pojo2ExcelWithFile(List<T> list, File outFile, boolean isAppend, String[] sortArr) throws Exception {
		
		if (!isAppend) {
			return pojo2ExcelWithFile(list, outFile);
		}
		
		if (null != list && list.size() > 0) {
			if (null != outFile && outFile.length() > 0) {
				
				// 获取到源文件
				Workbook excel = null;
				if (outFile.getName().endsWith("xls")) {
					// 创建Excel对象
					excel = new HSSFWorkbook(new FileInputStream(outFile));
				} else if (outFile.getName().endsWith("xlsx")) {
					excel = new XSSFWorkbook(new FileInputStream(outFile));
				} else {
					throw new IllegalArgumentException("只支持'.xls'和'.xlsx'格式的Excel文档");
				}
				
				// 获取源文件已经存在的行数,在原基础上加上list循环的次数进行追加
				Sheet sheet = excel.getSheetAt(0);
				int existsRowNum = sheet.getLastRowNum();
				
				// 遍历要追加的list集合,每次新增行都要加上 existsRowNum
				// 查看是否存在排序指定列对应的属性
				if (null != sortArr && sortArr.length > 0) {
					for (int i = 0; i < list.size(); i++) {
						// 创建行
						Row newRow = sheet.createRow(existsRowNum + i + 1);
						// 获取到当前bean所有的属性
						Field[] declaredFields = list.get(i).getClass().getDeclaredFields();
						// 遍历排序的数组,在内层遍历字段,如果当前的排序属性和遍历的字段意向,则插入Excel单元格
						for (int j = 0; j < sortArr.length; j++) {
							for (Field field : declaredFields) {
								field.setAccessible(true);
								if (sortArr[j].equals(field.getName())) {
									// 插入单元格
									Cell cell = newRow.createCell(j);
									cell.setCellValue(String.valueOf(field.get(list.get(i))));
								}
							}
						}
					}
				} else {
					for (int i = 0; i < list.size(); i++) {
						// 创建行
						Row newRow = sheet.createRow(existsRowNum + i + 1);
						// 获取到当前bean所有的属性
						Field[] declaredFields = list.get(i).getClass().getDeclaredFields();
						// 遍历排序的数组,在内层遍历字段,如果当前的排序属性和遍历的字段意向,则插入Excel单元格
						for (int j = 0; j < declaredFields.length; j++) {
							// 插入单元格
							Cell cell = newRow.createCell(j);
							declaredFields[j].setAccessible(true);
							cell.setCellValue(String.valueOf(declaredFields[j].get(list.get(i))));
						}
					}
				}
				
				if (null != excel) {
					excel.write(new FileOutputStream(outFile));
					excel.close();
					return true;
				}
				
			}
		}

		return false;

	}

	/**
	 * 判断传入的类是否在属性上加入了"属性命名"的注解
	 * 
	 * @param clazz 需要判断的类
	 * @return true:至少有一个属性加了"属性命名"注解, false:没有一个属性加了"属性命名"注解
	 */
	public static Boolean isExisitBeanPropertiesAnnotation(Class<? extends Object> clazz) {

		boolean flag = false;

		// 获取所有的字段
		Field[] declaredFields = clazz.getDeclaredFields();
		// 是否有一个使用了属性命名注解
		if (null != declaredFields && declaredFields.length > 0) {
			for (Field field : declaredFields) {
				if (field.isAnnotationPresent(PropertiesName.class)) {
					flag = true;
				}
			}
		}

		return flag;

	}
	
	
	/**
	 * Excel转换到Pojo
	 *
	 * @param workbook Excel文档对象
	 * @param clazz 要转换的Pojo Class对象
	 * @return 是否成功
	 * @throws Exception 
	 */
	/**
	 *
	 * 添加一些空处理，数字转换为字符串为0.0的数值处理
	 * @modify wangxuxin
	 * @throws Exception
	 */
	public static <T> List<T> excel2Pojo(Workbook workbook, Class<T> clazz,Integer sIndex) throws Exception {
		
		if (!(null != workbook && null != clazz)) {
			return null;
		}
		
		List<T> poList = null;
		try {
			Workbook excel = workbook;
			Sheet sheet = excel.getSheetAt(sIndex);
			// 获取到总共有多少行
			int rowNum = sheet.getLastRowNum();
			// 获取到标题行
			Row headRow = sheet.getRow(0);
			// 获取到标题总共有多少列
			short cellNum = headRow.getLastCellNum();
			
			// 创建集合用来存储实例化的对象
			poList = new ArrayList<>();
			// 循环遍历每一行记录
			for (int i = 1; i <= rowNum; i++) {
				// 创建实体类
				T newPojo = clazz.newInstance();
				// 遍历每一列记录
				for (int j = 0; j < cellNum; j++) {
					// 获取到标题文字
					Cell cell = headRow.getCell(j);
					String headName = cell.toString();
					/**
					 * 遍历要封装类的属性并获取起注解上方 属性命名 查看是否和当前Excel的标题相同
					 * 	相同则封装
					 * 	不同则不理
					 */
					// 获取所有的字段反射对象
					Field[] declaredFields = clazz.getDeclaredFields();
					for (Field field : declaredFields) {
						field.setAccessible(true);
						// 获取到注解类型
						PropertiesName annotation = field.getAnnotation(PropertiesName.class);
						if(annotation==null){
							continue;
						}
						// 获取到属性命名
						String propertiesName = annotation.name();
						if (headName.equals(propertiesName)) {
//							if (headName.equals("phone")){
//								DecimalFormat df = new DecimalFormat("0");
//								String cellValue = df.format(cell.getNumericCellValue());
//								field.set(newPojo, Integer.valueOf(cellValue));
//							}else {
								// Excel标题头和属性相对应
								Class<? extends Object> type = field.getType();
								if (type.equals(Integer.class)) {
									if (sheet.getRow(i).getCell(j) != null) {
										String string = sheet.getRow(i).getCell(j).toString();
										int index = string.lastIndexOf(".");
										if (index > 0) {

											string = string.substring(0, index);
											field.set(newPojo, Integer.valueOf(string));
										} else
											field.set(newPojo, Integer.valueOf(string));
									}
								} else if (type.equals(String.class)) {
									if (sheet.getRow(i).getCell(j) != null) {
										String string = sheet.getRow(i).getCell(j).toString();
										if (string.endsWith(".0") | string.endsWith(".00")) {
											int index = string.lastIndexOf(".");
											string = string.substring(0, index);
										}

										if (NumberUtils.isNumber(string)){
											string = new BigDecimal(string).toPlainString();
										}
										field.set(newPojo, string);
									}
								} else if (type.equals(Double.class)) {
									if (sheet.getRow(i).getCell(j) != null) {
										String string = sheet.getRow(i).getCell(j).toString();
										if (string.endsWith(".0") | string.endsWith(".00")) {
											int index = string.lastIndexOf(".");
											string = string.substring(0, index);
										}
										field.set(newPojo, new Double(string));
									}
								} else if (type.equals(BigDecimal.class)) {
									if (sheet.getRow(i).getCell(j) != null) {
										String string = sheet.getRow(i).getCell(j).toString();
										if (string.endsWith(".0") | string.endsWith(".00")) {
											int index = string.lastIndexOf(".");
											string = string.substring(0, index);
										}
										field.set(newPojo, new BigDecimal(string));
									}
								} else if (type.equals(Date.class)) {
									SimpleDateFormat sdf = null;
									String dateStr = sheet.getRow(i).getCell(j).toString();
									// 验证 是否为:yyyy-MM-dd HH:mm:ss
									if (dateStr.matches(DateFormatEnum.REGEX_ONE.getValue())) {
										sdf = new SimpleDateFormat(DateFormatEnum.FORMAT_ONE.getValue());
										Date date = sdf.parse(dateStr);
										field.set(newPojo, date);
									} else if (dateStr.matches(DateFormatEnum.REGEX_TWO.getValue())) {
										sdf = new SimpleDateFormat(DateFormatEnum.FORMAT_TWO.getValue());
										Date date = sdf.parse(dateStr);
										field.set(newPojo, date);
									} else if (dateStr.matches(DateFormatEnum.REGEX_THREE.getValue())) {
										sdf = new SimpleDateFormat(DateFormatEnum.FORMAT_THREE.getValue());
										Date date = sdf.parse(dateStr);
										field.set(newPojo, date);
									} else if (dateStr.matches(DateFormatEnum.REGEX_FOUR.getValue())) {
										sdf = new SimpleDateFormat(DateFormatEnum.FORMAT_FOUR.getValue());
										Date date = sdf.parse(dateStr);
										field.set(newPojo, date);
									}
								}
//							}
						}
					}
				}
				poList.add(newPojo);
			}
		} catch (Exception e) {
			throw e;
		}
		return poList;
		
	}

	public static <T> HSSFWorkbook generate(List<T> list) throws IllegalAccessException {
		// 创建Excel对象
		HSSFWorkbook excel = new HSSFWorkbook();
		HSSFSheet sheet = excel.createSheet();

		// 存在带属性命名的注解
		// 遍历生成Excel
		for (int i = 0; i < list.size(); i++) {
			Field[] declaredFields = list.get(i).getClass().getDeclaredFields();
			// 如果是第一次,先创建标题行
			if (i == 0) {
				HSSFRow headRow = sheet.createRow(i);
				// 遍历属性,获取到属性命名作为Excel的标题
				for (int j = 0; j < declaredFields.length; j++) {
					Field field = declaredFields[j];
					field.setAccessible(true);
					PropertiesName BeanPropertiesNameAnnotation = field.getAnnotation(PropertiesName.class);
					// 获得属性注解命名
					String annotationName = BeanPropertiesNameAnnotation.name();

					// 创建列
					HSSFCell cell = headRow.createCell(j);
					cell.setCellValue(annotationName);
				}

				// 再写入记录
				// 创建每一条记录
				HSSFRow headRowRecord = sheet.createRow(i + 1);
				// 遍历属性,获取到属性值作为Excel的行记录
				for (int j = 0; j < declaredFields.length; j++) {
					// 获取到字段属性值
					Field field = declaredFields[j];
					field.setAccessible(true);
					// 获取到属性值
					Object object = field.get(list.get(i));
					if (object instanceof Date) {
						// 创建列
						HSSFCell cell = headRowRecord.createCell(j);
						cell.setCellValue(SDF.format((Date) object));
					} else {
						// 创建列
						HSSFCell cell = headRowRecord.createCell(j);
						cell.setCellValue(object.toString());
					}
				}

			} else {
				// 创建每一条记录
				HSSFRow headRow = sheet.createRow(i + 1);
				// 遍历属性,获取到属性值作为Excel的行记录
				for (int j = 0; j < declaredFields.length; j++) {
					// 获取到字段属性值
					Field field = declaredFields[j];
					field.setAccessible(true);
					// 获取到属性值
					Object object = field.get(list.get(i));
					if (object instanceof Date) {
						// 创建列
						HSSFCell cell = headRow.createCell(j);
						cell.setCellValue(SDF.format((Date) object));
					} else {
						// 创建列
						HSSFCell cell = headRow.createCell(j);
						cell.setCellValue(object.toString());
					}
				}
			}
		}

		return excel;
	}

	public static boolean pojo2EmptyExcelWithOutputStream(MapDetailParent financeDay, ServletOutputStream outputStream) {

		try {

			// 创建Excel对象
			HSSFWorkbook excel = new HSSFWorkbook();
			HSSFSheet sheet = excel.createSheet();

			Field[] declaredFields = financeDay.getClass().getDeclaredFields();
			HSSFRow headRow = sheet.createRow(0);

			// 遍历属性,获取到属性命名作为Excel的标题
			for (int j = 0; j < declaredFields.length; j++) {
				Field field = declaredFields[j];
				field.setAccessible(true);
				PropertiesName BeanPropertiesNameAnnotation = field.getAnnotation(PropertiesName.class);
				// 获得属性注解命名
				String annotationName = BeanPropertiesNameAnnotation.name();

				// 创建列
				HSSFCell cell = headRow.createCell(j);
				cell.setCellValue(annotationName);
			}

			excel.write(outputStream);
			excel.close();

			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
