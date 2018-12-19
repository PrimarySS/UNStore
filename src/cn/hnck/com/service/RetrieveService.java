package cn.hnck.com.service;

import java.util.List;

import cn.hnck.com.entity.Card;

/**
 * 
 * ClassName: RetrieveService
 * 
 * @Description: 回收站service
 * @author XHChen
 * @date 2018年12月1日 下午2:37:43
 */
public interface RetrieveService {

	// 移到回收站
	public void revertCard(int[] checkList, String flag) throws Exception;

	// 查询回收站
	public List<Card> findRevertCard(String flag, int pageNo, int pageSize) throws Exception;

	// 删除名片信息
	public void deleteRevertCard(int id) throws Exception;

	// 删除回收站名片
	public void delListCard(int[] boxList) throws Exception;

	// 恢复回收站数据
	public void reductionCard(int[] boxList, String flag) throws Exception;

	// 模糊查询
	public List<Card> searchCard(String name, String flag) throws Exception;

	// 获得数据库最大页码
	public int maxSize(String falg) throws Exception;

}
