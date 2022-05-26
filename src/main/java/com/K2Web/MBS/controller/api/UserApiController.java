package com.K2Web.MBS.controller.api;

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.K2Web.MBS.dto.ResponseDto;
import com.K2Web.MBS.model.User;
import com.K2Web.MBS.service.UserService;


@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/auth/joinProc")									// 제네릭 공부해야하나...
	public ResponseDto<Integer> save(@RequestBody User user) {	// username, password, email
		System.out.println("UserApiController : save 호출됨");
		// 실제로 DB에 insert를 하고 아래에서 return이 되면 되요.
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);	// 자바오브젝트를 JSON으로 변환해서 리턴
	}
	
	@PutMapping("/user")			// key = value (없을때), x-www-form-urlencoded (RequestBody있을때)
	public ResponseDto<Integer> update(@RequestBody User user) {
		userService.회원수정(user);
		// 여기서는 트랜잭션이 종료되기 때문에 DB값은 변경이 됬음
		// 하지만 세션값은 변경되지 않은 상태이기 때문에 우리가 직접 세션값을 변경해줄 것임
		// 세션 등록
		Authentication authentication = authenticationManager.authenticate
				(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()) );
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
		
	}

/*	
	//이 방식은 전통방식(구시대적) - 요즘은 스프링 시큐리티를 이용해서 로그인함
	@PostMapping("/api/user/login")
	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
		System.out.println("UserApiController : login호출됨");
		User principal = userService.로그인(user); // principal(접근주체)	//userService에 있는 로그인 클래스 안에 메소드
										// findByUsernameAndPassword에 의해 유저네임,패스워드 받아온 것을 principal에 넣음
		if(principal != null) {			// 즉 principal에는 username과 password 정보가 들어가있음 (로그인할시)
			session.setAttribute("principal", principal);	// sessionScope.principal에 principal 값을 저장하나봄
															// 그후 header.java에 sessionScope.principal
		}													// JSTL 필요  // session 쓰는이유는 로그인 기억을 해야하기때문에
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
*/	
	
	
}
