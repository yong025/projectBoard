package org.zerock.projectboard.dao;

import lombok.extern.log4j.Log4j2;
import org.zerock.projectboard.dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public enum BoardDAO {
    INSTANCE;

    private static final String SQL_INSERT = "insert into tbl_board (title,content,writer) values( ? , ? , ? )";

    private static final String SQL_LIST = "select bno,title,writer,regdate,viewcount \n" +
            "from tbl_board\n" +
            "order by bno desc";

    private static final String SQL_READ ="select bno,title,content,writer,regdate,viewcount \n" +
            "from tbl_board\n" +
            "where bno = ?";

    private static final String SQL_UPDATE_VIEWCOUNT = "update tbl_board set viewcount = (viewcount + 1)\n" +
            "where bno = ?";

    private static final String SQL_MODIFY = "update tbl_board set title = ?, content = ?\n" +
            "where bno = ?";

    private static final String SQL_REMOVE = "DELETE FROM tbl_board WHERE bno = ?";

    public void insert(BoardDTO boardDTO) throws RuntimeException {

        new JdbcTemplate(){

            @Override
            protected void execute() throws Exception {
                log.info("insert ......");
                preparedStatement = connection.prepareStatement(SQL_INSERT);
                preparedStatement.setString(1, boardDTO.getTitle());
                preparedStatement.setString(2, boardDTO.getContent());
                preparedStatement.setString(3, boardDTO.getWriter());

                int count = preparedStatement.executeUpdate();
                log.info("count:" + count );

            }
        }.makeAll();
    }
    public List<BoardDTO> list() throws RuntimeException {
        log.info("List..........");

        List<BoardDTO> boardDTOS = new ArrayList<>();
        new JdbcTemplate(){

            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement(SQL_LIST);
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){
                boardDTOS.add(BoardDTO.builder()
                         .bno(resultSet.getInt(1))
                         .title(resultSet.getString(2))
                        .writer(resultSet.getString(3))
                        .regdate(resultSet.getTimestamp(4))
                        .viewcount(resultSet.getInt(5))
                        .build());
                }
            }
        }.makeAll();


        return boardDTOS;
    }

    public BoardDTO read(int bno){

        BoardDTO boardDTO = BoardDTO.builder().build();

        new JdbcTemplate(){

            @Override
            protected void execute() throws Exception {

                preparedStatement = connection.prepareStatement(SQL_UPDATE_VIEWCOUNT);
                preparedStatement.setInt(1, bno);
                preparedStatement.executeUpdate();

                preparedStatement.close();
                preparedStatement = null;//메모리에서 빨리 비우기 위해 실행한다.



                preparedStatement = connection.prepareStatement(SQL_READ);
                preparedStatement.setInt(1, bno);
                resultSet = preparedStatement.executeQuery();

                resultSet.next();

                boardDTO.setBno(resultSet.getInt(1));
                boardDTO.setTitle(resultSet.getString(2));
                boardDTO.setContent(resultSet.getString(3));
                boardDTO.setWriter(resultSet.getString(4));
                boardDTO.setRegdate(resultSet.getTimestamp(5));
                boardDTO.setViewcount(resultSet.getInt(6));


            }
        }.makeAll();
        return boardDTO;
    }

    public void modify(String title,String content,int bno){

        new JdbcTemplate(){

            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement(SQL_MODIFY);
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, content);
                preparedStatement.setInt(3, bno);

                preparedStatement.executeUpdate();
            }
        }.makeAll();
    }

    public void remove(int bno){

        new JdbcTemplate(){

            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement(SQL_REMOVE);
                preparedStatement.setInt(1, bno);
                preparedStatement.executeUpdate();
            }
        }.makeAll();

    }
}
