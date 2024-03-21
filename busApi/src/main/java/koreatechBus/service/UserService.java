package koreatechBus.service;

import koreatechBus.auth.JWTProvider;
import koreatechBus.domain.Bookmark;
import koreatechBus.domain.User;
import koreatechBus.dto.etc.MainDTO;
import koreatechBus.dto.user.LoginDTO;
import koreatechBus.dto.user.RegisterDTO;
import koreatechBus.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JWTProvider jwtProvider;
    private static final String EMAIL_PATTERN =
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    public UserService(UserRepository userRepository, JWTProvider jwtProvider)  {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    public User registerUser(RegisterDTO registerDTO) throws IllegalAccessException {
        isValidStudentNumber(registerDTO.getSchoolId());
        isValidEmail(registerDTO.getEmail());
        isValidRegister(registerDTO);

        String password = hashPassword(registerDTO.getPassword());

        return userRepository.save(User.builder()
                .schoolId(registerDTO.getSchoolId())
                .name(registerDTO.getName())
                .password(password)
                .email(registerDTO.getEmail())
                .role(3L)
                .build());
    }

    private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public void isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        if(!matcher.matches()){
            throw new IllegalArgumentException("이메일의 형식이 올바르지 않습니다!");
        }
    }

    public void isValidStudentNumber(String studentNumber) {    // 정규 표현식을 사용하여 10자리 숫자인지 확인
        String regex = "^\\d{10}$";
        if(!studentNumber.matches(regex)){
            throw new IllegalArgumentException("학번이 형식에 맞지 않습니다!");
        }
    }

    private void isValidRegister(RegisterDTO registerDTO) throws IllegalAccessException {
        if(userRepository.existsBySchoolId(registerDTO.getSchoolId())){
            throw new IllegalAccessException("이미 존재하는 학번입니다!");
        }

        if(userRepository.existsByEmail(registerDTO.getEmail())){
            throw new IllegalAccessException("이미 존재하는 이메일입니다!");
        }
    }

    public String loginUser(LoginDTO loginDTO){
        User user = userRepository.findBySchoolId(loginDTO.getSchoolId());

        if (!checkPass(loginDTO.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다!");
        }

        Integer schoolId = Integer.parseInt(loginDTO.getSchoolId());
        return jwtProvider.createToken(schoolId);
    }

    private boolean checkPass(String plainPassword, String hashedPassword) {

        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    public MainDTO getMainPage(String token){
        String schoolId = jwtProvider.getSchoolId(token);   // 토큰에서 schoolId 추출
        User user = userRepository.findBySchoolId(schoolId);

        String name = user.getName();
        Long role = user.getRole();
        Set<Bookmark> bookmarks = user.getBookmarks();

        return new MainDTO(name, schoolId, role, bookmarks);
    }
}
