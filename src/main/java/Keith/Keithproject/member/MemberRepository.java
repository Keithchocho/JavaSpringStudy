package Keith.Keithproject.member;

public interface MemberRepository {

    void save(Member member);
    //회원을 저장하는 공간입니다.

    Member findById(Long memberId);

}
