package cn.hnck.com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.hnck.com.dao.RetrieveDao;
import cn.hnck.com.entity.Card;

/**
 * 
 * ClassName: RetrieveDaoImpl
 * 
 * @Description: 回收站dao实现
 * @author XHChen
 * @date 2018年12月1日 下午2:41:55
 */
public class RetrieveDaoImpl implements RetrieveDao {

	// 注入HibernateTemplate模板
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 
	 * @param flag
	 *            状态
	 * @Description: 更改card的flag
	 * @param @param i
	 * @return void
	 * @throws
	 * @author XHChen
	 * @date 2018年12月1日 下午3:04:16
	 */
	private void updateCardFlag(int i, String flag) {

		try {
			// 找到card
			Card card = this.hibernateTemplate.get(Card.class, i);
			// 改变名片状态
			card.setFlag(flag);
			// 跟新名片
			this.hibernateTemplate.update(card);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
	}

	@Override
	/**
	 * 移到回收站
	 */
	public void revertCard(int[] checkList, String flag) throws Exception {

		try {
			// 改变名片状态
			for (int i : checkList) {
				updateCardFlag(i, flag);
			}

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
	}

	@Override
	/**
	 * 查询移到回收站的card
	 */
	public List<Card> findRevertCard(String flag, int pageNo, int pageSize,
			int real) throws Exception {

		int begin = (pageNo - 1) * pageSize;

		int end = (pageNo) * pageSize;

		// bug修改显示bug
		if (end > real) {
			end = real;
		}

		try {
			// 查询状态为flag的card
			@SuppressWarnings("unchecked")
			List<Card> cardList = this.hibernateTemplate.find(
					"from Card c where c.flag = ?", flag).subList(begin, end);

			return cardList;
		} catch (Exception e) {
			// 输出错误信息
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	/**
	 * 删除回收站的名片信息
	 */
	public void deleteRevertCard(int id) throws Exception {

		try {
			// 找到删除的卡片
			Card entity = this.hibernateTemplate.get(Card.class, id);
			// 删除卡片
			this.hibernateTemplate.delete(entity);
		} catch (Exception e) {
			// 输出错误信息
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
	}

	@Override
	/**
	 * 名片还原
	 */
	public void reductionCard(int[] boxList, String flag) throws Exception {

		try {
			for (int i : boxList) {
				// 更新数据状态标志
				updateCardFlag(i, flag);
			}
		} catch (Exception e) {
			// 输出错误信息
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Card> searchCard(String name, String flag) throws Exception {

		// 编写sql语句
		String sql = "from Card c where c.name like ? and c.flag = ?";
		try {

			@SuppressWarnings("unchecked")
			List<Card> cards = this.hibernateTemplate.find(sql, new Object[] {
					"%" + name + "%", flag });

			return cards;
		} catch (Exception e) {
			// 输出错误信息
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public int realPage(String entity, String flag) throws Exception {

		return this.hibernateTemplate.find(
				"from" + " " + entity + " where flag=" + flag).size();
	}

}
