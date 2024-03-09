package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity
public class Member {

    // @Id 엔티티의 기본키
    // @GeneratedValue 기본키가 생성되는 방식을 정해준다.
    // 해당 예제에서는 IDENTITY 전략으로 DB가 알아서 생성하게 만든다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // @Column 애노테이션은 해당 테이블의 컬럼을 연결해주는것
    @Column(name = "name")
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
