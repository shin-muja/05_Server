package edu.kh.jsp2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok.jar 라이브러리 이용방법
// 1) lombok 기능을 이요하고자 하는 프로젝트의 lib 폴더에 lombok.jar 추가
// 2) lombok 이용하는 IDE에 설치해주기

// 따로 선언하여 만들수도 있음
// @Getter
// @Setter
// @ToString
@Data // Getter + Setter + toString
@NoArgsConstructor // 매개변수 없는 기본 생성자
@AllArgsConstructor // 모든 필드 초기화용 매개변수 생성자
public class Book {
	// 필드
	private String title;
	private String author;
	private int price;
	
	// 메서드 (생성자, getter/setter/toString)
	// 작성 및 어노테이션없이 자동으로 생성해주는
	// 것을 lombok이라 한다
	
}
