package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.domain.MemberVO;

public interface MemberMapper {

	//회원하나 추가 
	@Insert("INSERT INTO member (id, passwd, name, birthday, gender, email, recv_email, reg_date) "
			+ "VALUES (#{id}, #{passwd}, #{name}, #{birthday}, #{gender}, #{email}, #{recvEmail}, #{regDate}) ")
	int insert(MemberVO memberVO);
	
	//모든 회원 삭제 
	@Delete("DELETE FROM member")
	int deleteAll();
	
	//아이디 한개 삭제 
	@Delete("DELETE FROM member WHERE id = #{id} ")
	int deleteById(String id);
	
	//회원정보 수정하기 
	@Update("UPDATE member "
			+ "SET name = #{name}, birthday = #{birthday}, gender = #{gender}, email = #{email}, recv_email = #{recvEmail}, reg_date = #{regDate} "
			+ "WHERE id = #{id} ")
	void updateById(MemberVO memberVO);
	
	
	@Select("SELECT count(*) AS cnt FROM member WHERE id = #{id}")
	int getCountById(String id);
	
	@Select("SELECT count(*) AS cnt FROM member")
	int getCountAll();
	
	@Select("SELECT * FROM member WHERE id = #{id}")
	MemberVO getMemberById(String id);
	
	//
	@Select("SELECT * FROM member ORDER BY id")
	List<MemberVO> getMembers();
	
	
//	// member 테이블과 profilepic 테이블 내용을 1:1 관계로 외부 조인해서 가져오기
//	MemberVO getMemberAndProfilepic(String id);
	
	
}






