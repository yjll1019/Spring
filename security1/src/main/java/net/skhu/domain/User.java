package net.skhu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


/*
 * @Data : @ToString, @EqualsAndHashCode, @Getter/@Setter,
 * 		@RequiredArgsConstructor를 모두 사용한 것과 같은 효과를 주는 어노테이션.
 * @Entity : JPA사용 시 엔티티 클래스임을 지정하고, 테이블과 매핑을 위한 어노테이션.	
 * @Id : 테이블에서 기본키(PK)에 해당하는 멤버 변수에 붙이는 어노테이션.
 * @GeneratedValue : 기본키가 Auto Increment 필드 이거나 Indentity 필드인 경우에 붙이는 어노테이션.
 * @Column : 테이블의 필드 이름과 Java 객체의 속성 이름이 다를 경우 붙이는 어노테이션.
 */
@Entity 
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name="userId")
	String loginId;
	String password;
	String name;
	String email;
	boolean enabled;
	String userType;
	
	
}
