package com.K2Web.MBS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.K2Web.MBS.model.Reply;



public interface ReplyRepository extends JpaRepository<Reply,Integer> {

	// modifying은 int만 가능
	@Modifying
	@Query(value = "INSERT INTO reply(userId, boardId, content, createDate) VALUES(?1,?2,?3,now())", nativeQuery = true)
	int mSave(int userId, int boardId, String content);	// 업데이트된 행의 개수를 리턴해줌
}
