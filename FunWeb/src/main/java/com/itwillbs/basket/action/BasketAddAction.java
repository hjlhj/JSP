package com.itwillbs.basket.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.basket.db.BasketDAO;
import com.itwillbs.basket.db.BasketDTO;

public class BasketAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : BasketAddAction_execute() ");
		
		// 세션제어(id)
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;			
		}
		//장바구니 정보 저장 (구매상품정보)
		// 1) 전달정보 저장 (DTO)
		BasketDTO dto = new BasketDTO();
		dto.setB_g_amount(Integer.parseInt(request.getParameter("amount")));
		dto.setB_g_color(request.getParameter("color"));
		dto.setB_g_num(Integer.parseInt(request.getParameter("gno")));
		dto.setB_g_size(request.getParameter("size"));
		dto.setB_m_id(id);
		
		System.out.println(" M : "+dto);
		
		// 2) DB에 저장
		//     - 기존에 동일옵션의 정보가 있는지 체크
		//     - O : 수량 update    X : 정보 insert
		BasketDAO dao = new BasketDAO();
		
		boolean isUpdate = dao.checkBasket(dto);

		// O : 수량 update    X : 정보 insert
		if(!isUpdate) {
			// 정보 추가(insert)
			dao.basketAdd(dto);
			System.out.println(" M : 장바구니 추가 ");
		}
		
		// 페이지 이동	
		forward.setPath("./BasketList.ba");
		forward.setRedirect(true);
		
		return forward;
	}

}
