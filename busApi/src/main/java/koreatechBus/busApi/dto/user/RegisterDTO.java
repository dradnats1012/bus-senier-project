package koreatechBus.busApi.dto.user;

import lombok.Getter;

@Getter
public class RegisterDTO {
    private String schoolId;
    private String name;
    private String password;
    private String email;
}
