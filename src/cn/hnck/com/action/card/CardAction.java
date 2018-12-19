package cn.hnck.com.action.card;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.hnck.com.dto.CardDTO;
import cn.hnck.com.entity.Card;
import cn.hnck.com.service.CardService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * ClassName: CardAction
 * 
 * @Description: 名片管理action
 * @author XHChen
 * @date 2018年11月28日 上午10:05:12
 */
public class CardAction extends ActionSupport implements ModelDriven<CardDTO> {

	private static final long serialVersionUID = 1L;

	private CardDTO cardDTO = new CardDTO();

	@Override
	public CardDTO getModel() {
		return cardDTO;
	}

	// 注入service ioc
	private CardService cardService;

	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}

	// 定义实体类
	private Card card;

	// 封装checkbox的id
	private int[] BoxList;

	// 分页
	private int page;
	private int maxPage;

	// 请求页面
	private HttpServletRequest request;

	// 查询数据库所有信息
	public String list() throws Exception {

		// 获得请求
		this.request = ServletActionContext.getRequest();

		// 获得数据库最大页码
		int maxPage = this.cardService.maxSize("0");

		// 设置当前页码
		int pageNo = 1;

		// 设置每页信息量
		int pageSize = 10;

		// 更新当前页码
		if (page > 0) {
			pageNo = page;
		}

		// 调用cardService方法查询数据库
		List<Card> cardList = this.cardService.findAllCard("0", pageNo, pageSize);

		// 响应数据到页面
		ActionContext.getContext().put("cardList", cardList);
		
		request.setAttribute("page", pageNo);

		request.setAttribute("maxPage", maxPage);

		return "clist";
	}

	// 添加名片
	public String insert() throws Exception {

		// 创建实体类
		card = new Card();

		// 封装页面数据
		card.setName(cardDTO.getName());
		card.setSex(cardDTO.getSex());
		card.setDepartment(cardDTO.getDepartment());
		card.setMobile(cardDTO.getMobile());
		card.setPhone(cardDTO.getPhone());
		card.setEmail(cardDTO.getEmail());
		card.setAddress(cardDTO.getAddress());
		card.setFlag("0");

		// 调用cardService方法插入数据
		this.cardService.insertCard(card);

		return "csave";

	}

	// 根据id查询数据
	public String find() throws Exception {

		// 调用cardService方法查询数据
		card = this.cardService.findCardById(cardDTO.getId());

		// 响应数据到页面
		ActionContext.getContext().put("card", card);

		return "cfind";

	}

	// 更新数据库信息
	public String update() throws Exception {

		// 创建实体类
		card = new Card();

		// 封装页面数据
		card.setId(cardDTO.getId());
		card.setName(cardDTO.getName());
		card.setSex(cardDTO.getSex());
		card.setDepartment(cardDTO.getDepartment());
		card.setMobile(cardDTO.getMobile());
		card.setPhone(cardDTO.getPhone());
		card.setEmail(cardDTO.getEmail());
		card.setAddress(cardDTO.getAddress());
		card.setFlag("0");

		// 调用cardService方法更新数据
		this.cardService.updateCard(card);

		return "csave";

	}

	// 删除名片信息
	public String delete() throws Exception {

		// 调用cardService方法删除数据
		this.cardService.deleteCard(cardDTO.getId());

		return "csave";

	}

	// 删除所选
	public String delList() throws Exception {

		// 调用cardService方法删除数据
		this.cardService.delCardList(BoxList);

		return "csave";

	}

	// 模糊查询名片
	public String search() throws Exception {

		// 调用cardService方法查询数据
		List<Card> cardList = this.cardService.searchByLike(cardDTO.getName(),
				"0");

		// 响应数据到页面
		ActionContext.getContext().put("cardList", cardList);

		return "clist";

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
