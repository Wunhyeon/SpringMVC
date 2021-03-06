package kr.co.softcampus.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.softcampus.beans.ContentBean;

@Repository
public class BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public void addContentInfo(ContentBean writeContentBean) {
		sqlSessionTemplate.insert("board.addContentInfo",writeContentBean);
	}
	
	public String getBoardInfoName(int board_info_idx) {
		
		return sqlSessionTemplate.selectOne("board.getBoardInfoName", board_info_idx);
	}
	
	public List<ContentBean> getContentList(int board_info_idx, RowBounds rowbounds) {
		return sqlSessionTemplate.selectList("board.getContentList",board_info_idx, rowbounds);
	}
	
	public ContentBean getContentInfo(int content_idx) {
		return sqlSessionTemplate.selectOne("board.getContentInfo", content_idx);
	}
	
	public void modify_pro(ContentBean modifyContentBean) {
		sqlSessionTemplate.update("board.modify_pro",modifyContentBean);
	}
	
	public void deleteContent(int content_idx) {
		sqlSessionTemplate.delete("board.deleteContent",content_idx);
	}
	
	public int getContentCnt(int content_board_idx) {
		return sqlSessionTemplate.selectOne("board.getContentCnt", content_board_idx);
	}
}
