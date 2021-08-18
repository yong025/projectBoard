package org.zerock.projectboard.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.projectboard.dto.BoardDTO;
import org.zerock.projectboard.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Log4j2
@WebServlet(name="ModifyController", value="/board/modify")
public class ModifyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int bno = Integer.parseInt(request.getParameter("bno"));

        BoardDTO dto = BoardService.INSTANCE.read(bno);


        request.setAttribute("dto", dto);
        request.getRequestDispatcher("/WEB-INF/board/modify.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        log.info("수정 성공 !!");
        int bno = Integer.parseInt(request.getParameter("bno"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BoardService.INSTANCE.modify(title,content,bno);

        response.sendRedirect("/board/list");
    }
}
