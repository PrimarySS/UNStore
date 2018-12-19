package cn.hnck.com.service.impl;

import java.util.List;

import cn.hnck.com.dao.RetrieveDao;
import cn.hnck.com.entity.Card;
import cn.hnck.com.service.RetrieveService;

/**
 * 
 * ClassName: RetrieveServiceImpl
 * 
 * @Description: 回收站 service 实现
 * @author XHChen
 * @date 2018年12月1日 下午2:39:30
 */
public class RetrieveServiceImpl implements RetrieveService {

	// 注入RetrieveDao
	private RetrieveDao retrieveDao;

	public void setRetrieveDao(RetrieveDao retrieveDao) {
		this.retrieveDao = retrieveDao;
	}

	@Override
	public void revertCard(int[] checkList, String flag) throws Exception {

		this.retrieveDao.revertCard(checkList, flag);
	}

	@Override
	public List<Card> findRevertCard(String flag, int pageNo, int pageSize)
			throws Exception {

		int real = this.retrieveDao.realPage("Card", flag);

		return this.retrieveDao.findRevertCard(flag, pageNo, pageSize, real);
	}

	@Override
	public void deleteRevertCard(int id) throws Exception {

		this.retrieveDao.deleteRevertCard(id);
	}

	@Override
	/**
	 * 删除回收站名片
	 */
	public void delListCard(int[] boxList) throws Exception {

		try {
			// 调用retrieveDao的删除方法
			for (int i : boxList) {
				this.retrieveDao.deleteRevertCard(i);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void reductionCard(int[] boxList, String flag) throws Exception {

		this.retrieveDao.reductionCard(boxList, flag);

	}

	@Override
	public List<Card> searchCard(String name, String flag) throws Exception {

		return this.retrieveDao.searchCard(name, flag);
	}

	@Override
	public int maxSize(String flag) throws Exception {

		int count = 0;

		int maxPage = 0;

		count = this.retrieveDao.realPage("Card", flag);

		maxPage = (count + 9) / 10;

		return maxPage;
	}

}
