package kr.co.softcampus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.softcampus.beans.BoardInfoBean;

public interface TopMenuMapper {

	@Select("select * from board_info_table")
	List<BoardInfoBean> getTopMenuList();
}
