package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 인터페이스가 인터페이스를 상속 받을때는 'extends' 키워드를 써준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // 구현할 게 없다..
    // 스프링 데이터 JPA가 해당 인터페이스를 보고 구현체를 만들어서 스프링 빈에 등록해준다.
    @Override
    Optional<Member> findByName(String name);

}