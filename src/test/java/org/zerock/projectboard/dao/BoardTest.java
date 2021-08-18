package org.zerock.projectboard.dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.zerock.projectboard.dto.BoardDTO;

import java.util.stream.IntStream;

@Log4j2
public class BoardTest {

    @Test
    public void InsertTest(){

        IntStream.rangeClosed(1,10).forEach(i -> {
            String title = "Sample Write" + (int)(Math.random()* 10);
            String content = "Sample Content" + (int)(Math.random()* 10);
            String writer = "user" + i;

        BoardDTO dto = BoardDTO.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();

            BoardDAO.INSTANCE.insert(dto);

        });

    }

    @Test
    public void ListTest(){

        log.info(BoardDAO.INSTANCE.list());
    }

    @Test
    public void ReadTest(){

       log.info(BoardDAO.INSTANCE.read(11));
    }

    @Test
    public  void modifyTest(){

        BoardDAO.INSTANCE.modify("하하하하","하하하하하하",11);
    }

    @Test
    public void remove(){

        BoardDAO.INSTANCE.remove(11);
    }
}
