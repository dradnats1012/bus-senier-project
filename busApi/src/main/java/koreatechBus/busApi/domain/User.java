package koreatechBus.busApi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "user")
@Getter
public class User {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "school_id")
    private String schoolId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Long role;      // 1 : 관리자, 2 : 버스 기사, 3 : 일반 사용자
}
