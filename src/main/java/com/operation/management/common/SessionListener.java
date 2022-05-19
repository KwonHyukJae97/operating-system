package com.operation.management.common;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionListener  implements HttpSessionListener{

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sessionCreated(HttpSessionEvent se){
        HttpSession session = se.getSession();
        long time = session.getCreationTime();
        String id = session.getId();

        System.out.println(time + "에 생성된 세션 " + id + "로그:" + log);

        //세션유지 시간 10시간
        se.getSession().setMaxInactiveInterval(36000);
    }

    @Override

    public void sessionDestroyed(HttpSessionEvent se) {

        HttpSession session = se.getSession();
        long time = session.getCreationTime();
        long last_time = session.getLastAccessedTime();
        long now_time = System.currentTimeMillis();
        String id = session.getId();
        System.out.println((now_time - last_time) + "ms 만에 세션이 만료되었습니다." + id + "타임 :" +time);

    }
    
}
