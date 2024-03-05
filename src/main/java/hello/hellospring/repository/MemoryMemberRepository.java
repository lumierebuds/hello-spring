package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setID(++sequence);
        store.put(member.getID(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {

        // null이 반환될수 있기 때문에  Optioal.ofNullable()로 감싸준다.
        // 클라이언트는 이 값에 대비할 수 있게된다.
        return Optional.ofNullable(store.get(id));

    }

    @Override
    public Optional<Member> findByName(String name) {

        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
