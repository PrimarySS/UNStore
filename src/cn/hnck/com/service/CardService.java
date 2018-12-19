package cn.hnck.com.service;

import java.util.List;

import cn.hnck.com.entity.Card;

/**
 * 
 * ClassName: CardService
 * 
 * @Description: 名片service接口
 * @author XHChen
 * @date 2018年11月28日 上午10:24:03
 */
public interface CardService {

	// 查询所有名片
	public List<Card> findAllCard(String flag, int pageNo, int pageSize)
			throws Exception;

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

	// 获得数据库总页码
	public int maxSize(String flag) throws Exception;

}
