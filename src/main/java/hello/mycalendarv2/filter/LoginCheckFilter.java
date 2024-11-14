package hello.mycalendarv2.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Slf4j
public class LoginCheckFilter implements Filter {
    //인증 하지 않아도 될 url path 배열
    private static final String[] WHITE_LIST = {"/", "/signUp", "/login", "/logout"};


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        log.info("로그인 필터 로직 실행");

        if (!isWhiteList(requestURI)) {
            HttpSession session = httpRequest.getSession(false);

//            로그인 여부 확인
            if (session == null || session.getAttribute("email") == null) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "로그인 하지 않은 사용자입니다");
            }
        }

        filterChain.doFilter(request, response);


    }

    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
