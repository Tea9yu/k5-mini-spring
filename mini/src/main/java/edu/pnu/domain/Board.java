//package edu.pnu.domain;
//
//import java.util.Date;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//@Getter
//@Setter
//@ToString
////@Entity
//public class Board {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long seq;
//	private String title;
//	private String writer;
//	private String content;
//	@Temporal(TemporalType.DATE) //날짜 정보만을 저장하고 시간 정보는 저장하지 않음
//	private Date createDate;
//	private Long cnt;
//}
