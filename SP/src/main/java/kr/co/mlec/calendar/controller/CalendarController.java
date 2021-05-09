package kr.co.mlec.calendar.controller;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mlec.calendar.vo.CalendarVO;
import kr.co.mlec.member.vo.MemberVO;

@Controller
public class CalendarController {

   @Autowired
   private SqlSessionTemplate ss;
   
   @ResponseBody
   @PostMapping("/calendar")
   public int calendar(CalendarVO vo, HttpSession session) {
      vo.setId(((MemberVO)session.getAttribute("loginSucessVO")).getId());
      if(ss.insert("calendar.dao.CalendarDAO.insert", vo) == 1) {
         // 성공
         return 1;
      } else {
         // 실패
         return -1;
      }
      
   } 
}