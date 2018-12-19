package cn.hnck.com.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

/**
 * 
 * @ClassName: UpLoadUtils
 * @Description: 图片上传工具
 * @author XHChen
 * @date 2018-9-28 下午8:04:33
 * 
 */
public class UpLoadUtils {

	private static final int BUFFER_SIZE = 16 * 1024;

	/**
	 * 
	* @Title: copy
	* @Description: 把图片写入到设置的路径里
	* @param @param src
	* @param @param dst    设定文件
	* @return void    返回类型
	* @throws
	 */
	private static void copy(File src, File dst) {

		InputStream in = null;
		OutputStream out = null;

		try {
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);

			out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);

			byte[] buffer = new byte[BUFFER_SIZE];

			while (in.read(buffer) > 0) {

				out.write(buffer);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static String getExtention(String fileName) {

		int pos = fileName.lastIndexOf(".");

		return fileName.substring(pos);

	}

	/**
	 * @param headImgFileName 
	 * 
	* @Title: upload
	* @Description: 上传图片
	* @param @param src
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	public static String upload(File src, String headImgFileName) {
		
		if (src == null)return "图片为空！";
		
		String tempName = new Date().getTime() + getExtention(headImgFileName);
		
		// 得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)
		File imageFile = new File(ServletActionContext.getServletContext() .getRealPath("UploadImages") + "\\" + tempName);

		// 把图片写入到上面设置的路径里
		copy(src, imageFile);

		// 修改客户端显示图片bug 使用相对地址 直接返回文件名 mysql存储的文件名
		return tempName;
	}
}
