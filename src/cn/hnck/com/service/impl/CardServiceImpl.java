package cn.hnck.com.service.impl;

import java.util.List;

import cn.hnck.com.dao.CardDao;
import cn.hnck.com.entity.Card;
import cn.hnck.com.service.CardService;

/**
 * 
 * ClassName: CardServiceImpl
 * 
 * @Description: 名片service实现
 * @author XHChen
 * @date 2018年11月28日 上午10:27:32
 */
public class CardServiceImpl implements CardService {

	// 注入dao ioc
	private CardDao cardDao;

	public void setCardDao(CardDao cardDao) {
		this.cardDao = cardDao;
	}

	@Override
	public List<Card> findAllCard(String flag, int pageNo, int pageSize)
			throws Exception {

		int real = this.cardDao.realPage("Card", flag);

		return this.cardDao.findAllCard("Card", flag, pageNo, pageSize, real);
	}

	@Override
	public void insertCard(Card card) throws Exception {

		this.cardDao.insertCard(card);
	}

	@Override
	public Card findCardById(int id) throws Exception {

		return this.cardDao.findCardById(id);
	}

	@Override
	public void updateCard(Card card) throws Exception {

		this.cardDao.updateCard(card);
	}

	@Override
	public void deleteCard(int id) throws Exception {

		this.cardDao.deleteCard(id);
	}

	@Override
	public void delCardList(int[] boxList) throws Exception {

		this.cardDao.delCardList(boxList);
	}

	@Override
	public List<Card> searchByLike(String name, String flag) throws Exception {

		return this.cardDao.searchByLike(name, flag);
	}

	@Override
	/**
	 * 获得数据库信息总数
	 */
	public int maxSize(String flag) throws Exception {

		int count = 0;

		int maxPage = 0;

		count = this.cardDao.realPage("Card", flag);

		maxPage = (count + 9) / 10;

		return maxPage;
	}

}
