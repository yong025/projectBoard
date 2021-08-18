package org.zerock.projectboard.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.projectboard.dto.BoardDTO;
import org.zerock.projectboard.service.BoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "WriteController", value = "/board/write")
public class WriteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("write .............");

        request.getRequestDispatcher("/WEB-INF/board/write.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("작성 성공!!!!!");
        request.setCharacterEncoding("UTF-8");

       String title =  request.getParameter("title");
       String content = request.getParameter("content");
       String writer =  request.getParameter("writer");

        BoardDTO boardDTO = BoardDTO.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();

        BoardService.INSTANCE.insert(boardDTO);

        response.sendRedirect("/board/list");
    }
}
