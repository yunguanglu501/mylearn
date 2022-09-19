package com.example.learn.date.t0916;

/**
 * ApplicationEventSender
 *
 * @author wcy
 */

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationEventSender {

    private final ApplicationEventPublisher publisher;

    public void saveUser(UserDTO dto) {
        // 推送事件
        publisher.publishEvent(dto);
        System.out.println("dto = " + dto);
    }
}
