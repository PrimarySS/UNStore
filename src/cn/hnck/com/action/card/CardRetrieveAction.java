package cn.hnck.com.action.card;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.hnck.com.dto.CardDTO;
import cn.hnck.com.entity.Card;
import cn.hnck.com.service.RetrieveService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * ClassName: CardRetrieveAction
 * 
 * @Description: 回收站action
 * @author XHChen
 * @date 2018年12月1日 上午11:48:35
 */
public class CardRetrieveAction extends ActionSupport implements
		ModelDriven<CardDTO> {

	private static final long serialVersionUID = 1L;
	// 创建实体类
	private CardDTO cardDTO = new CardDTO();

	@Override
	public CardDTO getModel() {
		return cardDTO;
	}

	// 注入service ioc
	private RetrieveService retrieveService;

	public void setRetrieveService(RetrieveService retrieveService) {
		this.retrieveService = retrieveService;
	}

	private int[] BoxList; // 多选id

	// 分页
	private int page;
	private int maxPage;

	// 请求页面
	private HttpServletRequest request;

	// 模糊搜索
	public String search() throws Exception {

		// 调用retrieveService方法查询数据
		List<Card> cards = this.retrieveService.searchCard(cardDTO.getName(),
				"1");

		// 把数据响应到页面
		ActionContext.getContext().put("cards", cards);

		return "rfind";
	}

	// 把card移到回收站
	public String revert() throws Exception {

		// 调用retrieveService方法更改数据
		this.retrieveService.revertCard(BoxList, "1");

		return "rsuccess";
	}

	// 查询回收站
	public String find() throws Exception {

		// 获得请求
		this.request = ServletActionContext.getRequest();

		// 获得数据库最大页码
		int maxPage = this.retrieveService.maxSize("1");

		// 设置当前页码
		int pageNo = 1;

		// 设置每页信息量
		int pageSize = 10;

		// 更新当前页码
		if (page > 0) {
			pageNo = page;
		}

		// 调用retrieveService方法查询数据
		List<Card> cards = this.retrieveService.findRevertCard("1", pageNo,
				pageSize);

		// 把结果响应到页面
		ActionContext.getContext().put("cards", cards);

		request.setAttribute("page", pageNo);

		request.setAttribute("maxPage", maxPage);

		return "rfind";
	}

	// 删除名片信息
	public String delete() throws Exception {

		// 调用retrieveService方法删除数据
		this.retrieveService.deleteRevertCard(cardDTO.getId());

		return "rsave";
	}

	// 删除所选
	public String delList() throws Exception {

		// 调用retrieveService方法删除数据
		this.retrieveService.delListCard(BoxList);

		return "rsave";

	}

	// 名片还原
	public String reduction() throws Exception {

		// 调用retrieveService方法恢复数据
		this.retrieveService.reductionCard(BoxList, "0");

		return "rsave";
	}

	public int[] getBoxList() {
		return BoxList;
	}

	public void setBoxList(int[] boxList) {
		BoxList = boxList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

}
