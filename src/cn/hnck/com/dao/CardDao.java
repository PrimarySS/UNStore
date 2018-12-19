package cn.hnck.com.dao;

import java.util.List;

import cn.hnck.com.entity.Card;

/**
 * 
 * ClassName: CardDao
 * 
 * @Description: 名片dao接口
 * @author XHChen
 * @date 2018年11月28日 上午10:29:28
 */
public interface CardDao {

	// 查询所有名片
	public List<Card> findAllCard(String entityName, String flag, int pageNo,
			int pageSize, int real) throws Exception;

	// 添加名片
	public void insertCard(Card card) throws Exception;

	// 查询名片
	public Card findCardById(int id) throws Exception;

	// 更新数据库信息
	public void updateCard(Card card) throws Exception;

	// 删除名片信息
	public void deleteCard(int id) throws Exception;

	// 删除所选名片信息
	public void delCardList(int[] boxList) throws Exception;

	// 模糊查询名片
	public List<Card> searchByLike(String name, String flag) throws Exception;

	// 获得数据库信息总页码
	public int realPage(String entity, String flag) throws Exception;

}
