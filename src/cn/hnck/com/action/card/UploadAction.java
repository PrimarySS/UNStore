package cn.hnck.com.action.card;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.hnck.com.dto.CardDTO;
import cn.hnck.com.utils.DbToExcel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * ClassName: UploadAction
 * 
 * @Description: 导入名片
 * @author XHChen
 * @date 2018年12月3日 下午9:20:22
 */
public class UploadAction extends ActionSupport implements ModelDriven<CardDTO> {

	private static final long serialVersionUID = 1L;

	private CardDTO cardDTO = new CardDTO();

	@Override
	public CardDTO getModel() {

		return cardDTO;
	}

	private File file; // 上传文件对象

	private String fileContentType; // 上传文件内容类型

	private String fileFileName; // 上传文件名

	public String up() throws Exception {

		// 获取实际存放上传文件的文件夹
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");

		// 保存新路径
		File newPath = new File(path, fileFileName);

		// 复制路径
		FileUtils.copyFile(file, newPath);

		// 调用工具类上传文件
		DbToExcel.excelToDb(path + "/" + fileFileName, "card",
				"(name,sex,department,mobile,phone,email,address)", 7);

		return "lsuccess";
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

}
