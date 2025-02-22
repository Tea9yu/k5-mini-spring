package edu.pnu.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter // 각 필드 값을 조회할 수 있는 GETTER 메서드 자동 생성
@Setter
@ToString // 모든 필드를 출력할 수 있는 toString 메서드 자동 생성
@Builder
@AllArgsConstructor	// 모든 필드를 매개변수로 갖는 생성자 자동 생성
@NoArgsConstructor // 매개변수가 아예 없는 기본 생성자 자동 생성
@Entity	// 해당 클래스가 엔티티임을 선언, 클래스 필드를 바탕으로 DB에 테이블 생성
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_seq")//데이터베이스에서의 이름을 정의
    private Long seq;	// 번호
    private String title; // 제목
    private String writer; // 작성자
    private String content; // 내용
    @Builder.Default
    private Date createDate = new Date(); // 날짜
    @Builder.Default
    private Long cnt = 0L; // 조회수

}