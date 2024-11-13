package com.example.board.repository;

import com.example.board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findMemberByUsername(String username);

    default Member findMemberByUsernameOrElseThrow(String username) {
        return findMemberByUsername(username).orElseThrow(() -> new
                        ResponseStatusException(
                        HttpStatus.NO_CONTENT,
                        "Does not exists username : " + username
                )
        );
    }

    default Member findByIdOrElseThrow(Long id) { //default 를 이용하면 인터페이스 안에서 메서드를 구현할 수 있다.
        return findById(id)
                .orElseThrow(() -> new
                                ResponseStatusException(
                                HttpStatus.NO_CONTENT,
                                "Does not exists id : " + id
                        )
                );
    }
}
