package koreatechBus.dto.etc;

import koreatechBus.domain.Bookmark;
import lombok.Getter;

import java.util.Set;

@Getter
public class MainDTO {
    private String name;
    private String schoolId;
    private Long role;
    private Set<Bookmark> bookmarks;

    public MainDTO(String name, String schoolId, Long role, Set<Bookmark> bookmarks){
        this.name = name;
        this.schoolId = schoolId;
        this.role = role;
        this.bookmarks = bookmarks;
    }
}
