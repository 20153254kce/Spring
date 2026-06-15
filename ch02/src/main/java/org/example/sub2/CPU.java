package org.example.sub2;

import org.springframework.stereotype.Component;

//해당 ㅋ르래스 객체를 자동으로 컨테이너에 빈등록
@Component
public class CPU {

    public void show() {
        System.out.println("CPU - INTEL 17");
    }
}
