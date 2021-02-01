package com.server.EmailAuthentication.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 부모 클래스로 선언, 자식 클래스는 해당 클래스의 필드를 Colum으로 생성!
@EntityListeners(AuditingEntityListener.class)// Auditing 기능 추가
public class BaseTime {
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
