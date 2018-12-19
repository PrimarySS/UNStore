package cn.hnck.com.action.card;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.hnck.com.dto.CardDTO;
import cn.hnck.com.utils.DbToExcel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DownLoadAction extends ActionSupport implements ModelDriven<CardDTO> {

	private static final long serialVersionUID = 1L;

	private CardDTO cardDTO = new CardDTO();

	@Override
	public CardDTO getModel() {
		return cardDTO;
	}

	private String contentType; // 指定下载文件的类型,默认值为 text/plain
	private long contentLength; // 被下载的文件的大小，以字节为单位

	// 属性：contentDisposition：指定文件下载的处理方式，当为attachment（附件方式）会弹出文件保存对话框，是默认方式，
	// 其格式是attachment;filename="${fileName}
	private String contentDisposition; // 指定下载文件的下载方式，并指定保存文件的默认文件名
	private InputStream inputStream; // Action 中提供的文件的输入流。默认值为 inputStream

	private String fileName = "名片.xls"; // 指定下载的文件名

	public String down() throws Exception {
		
		String[] fieldList = { "id", "name", "sex", "department", "mobile",
				"phone", "email", "address", "flag" };
		String[] titles = { "序号", "姓名", "性别", "单位", "手机", "电话", "电子邮箱", "地址",
				"备注" };
		String file = "名片.xls";
		HttpSession session = ServletActionContext.getRequest().getSession();
		String condition = (String) session.getAttribute("condition");
		String order = (String) session.getAttribute("order");
		String sql = "";
		if (condition != null && !condition.equals("")) {
			sql = sql + " (name like '%" + condition + "%'";
			sql = sql + " or sex like '%" + condition + "%'";
			sql = sql + " or department like '%" + condition + "%'";
			sql = sql + " or mobile like '%" + condition + "%'";
			sql = sql + " or phone like '%" + condition + "%'";
			sql = sql + " or email like '%" + condition + "%'";
			sql = sql + " or address like '%" + condition + "%')";
		}

		// 确定各个成员变量的值，注意，这些值也可以在配置文件中配置，但一般在这里配置
		contentType = "application/octet-stream";// 指定为任意类型的文件
		// 指定下载后要保存的默认文件名,并通过编码转化，使之支持汉字文件名
		String name = java.net.URLEncoder.encode(fileName, "UTF-8");
		contentDisposition = "attachment;filename=" + name;

		ServletContext servletContext = ServletActionContext
				.getServletContext();

		String fileName2 = servletContext.getRealPath("/download/" + file);
		File downloadfile = new File(fileName2);
		if (!downloadfile.exists()) {
			System.out.println("不存在");
			downloadfile.getParentFile().mkdirs();
		}

		DbToExcel.dBToExcel("card", fieldList, titles, sql, order, fileName2);

		inputStream = new FileInputStream(fileName2);
		contentLength = inputStream.available();
		
		return "lsuccess";
	}

	public String getContentType() {
		return contentType;
	}

	public long getContentLength() {
		return contentLength;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public InputStream getInputStream() {
		return inputStream;
	}
}
