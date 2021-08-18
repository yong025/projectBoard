package org.zerock.projectboard.service;

import lombok.extern.log4j.Log4j2;
import org.zerock.projectboard.dao.BoardDAO;
import org.zerock.projectboard.dto.BoardDTO;

import java.util.List;

@Log4j2
public enum BoardService {
    INSTANCE;

    public void insert(BoardDTO boardDTO){

        log.info("insert" + boardDTO);

        BoardDAO.INSTANCE.insert(boardDTO);
    }

    public List<BoardDTO> list(){
        log.info("리스트 출력........");
        return BoardDAO.INSTANCE.list();
    }

    public BoardDTO read(int bno){
        log.info("게시글 조회.....");
        return BoardDAO.INSTANCE.read(bno);
    }

    public void modify(String title,String content,int bno){
        log.info("게시글 수정......");
        BoardDAO.INSTANCE.modify(title, content, bno);
    }

    public void remove(int bno){

        BoardDAO.INSTANCE.remove(bno);
    }
}
