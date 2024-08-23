package flog.instagram_clone_coding.repository;

import flog.instagram_clone_coding.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> { // spring이 알아서 UserRepository 인터페이스 기능 사용할 수 있도록 세팅함.
}
