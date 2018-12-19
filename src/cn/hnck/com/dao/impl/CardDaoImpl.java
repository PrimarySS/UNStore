package cn.hnck.com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.hnck.com.dao.CardDao;
import cn.hnck.com.entity.Card;

/**
 * 
 * ClassName: CardDaoImpl
 * 
 * @Description: 名片dao实现
 * @author XHChen
 * @date 2018年11月28日 上午10:31:18
 */
public class CardDaoImpl implements CardDao {

	// 注入hibernateTemplate模板
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Card> findAllCard(String entityName, String flag, int pageNo,
			int pageSize, int real) throws Exception {

		int begin = (pageNo - 1) * pageSize;

		int end = (pageNo) * pageSize;

		// bug修改显示bug
		if (end > real) {
			end = real;
		}

		try {
			@SuppressWarnings("unchecked")
			List<Card> list = this.hibernateTemplate.find(
					"from" + " " + entityName + " " + "where flag = " + flag)
					.subList(begin, end);

			return list;
		} catch (Exception e) {
			// 输出异常信息
			System.out.println(e.getStackTrace());

			System.out.println(e.getMessage());

			return null;
		}
	}

	@Override
	public void insertCard(Card card) throws Exception {

		try {
			this.hibernateTemplate.saveOrUpdate(card);
		} catch (Exception e) {
			// 输出异常信息
			System.out.println(e.getStackTrace());

			System.out.println(e.getMessage());
		}
	}

	@Override
	public Card findCardById(int id) throws Exception {

		try {
			return this.hibernateTemplate.get(Card.class, id);
		} catch (Exception e) {
			// 输出异常信息
			System.out.println(e.getStackTrace());

			System.out.println(e.getMessage());

			return null;
		}
	}

	@Override
	public void updateCard(Card card) throws Exception {

		try {
			this.hibernateTemplate.update(card);
		} catch (Exception e) {
			// 输出异常信息
			System.out.println(e.getStackTrace());

			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteCard(int id) throws Exception {

		try {
			// 查询删除的信息
			Card card = this.hibernateTemplate.get(Card.class, id);

			// 删除信息
			this.hibernateTemplate.delete(card);
		} catch (Exception e) {
			// 输出异常信息
			System.out.println(e.getStackTrace());

			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delCardList(int[] boxList) throws Exception {

		try {
			for (int i : boxList) {
				// 查询删除的信息
				Card card = this.hibernateTemplate.get(Card.class, i);

				// 删除信息
				this.hibernateTemplate.delete(card);
			}
		} catch (Exception e) {
			// 输出异常信息
			System.out.println(e.getStackTrace());

			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Card> searchByLike(String name, String flag) throws Exception {

		try {
			String sql = "from Card c where c.name like ? and c.flag = ?";

			@SuppressWarnings("unchecked")
			List<Card> cards = this.hibernateTemplate.find(sql, new Object[] {
					"%" + name + "%", flag });

			return cards;
		} catch (Exception e) {
			// 输出异常信息
			System.out.println(e.getStackTrace());

			System.out.println(e.getMessage());

			return null;
		}
	}

	@Override
	/**
	 * 获得数据库信息总数
	 */
	public int realPage(String entity, String flag) throws Exception {

		return this.hibernateTemplate.find("from" + " " + entity + " where flag=" + flag).size();
	}

}
