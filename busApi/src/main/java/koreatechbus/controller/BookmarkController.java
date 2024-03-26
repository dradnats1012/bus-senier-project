package koreatechbus.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import koreatechbus.domain.Bookmark;
import koreatechbus.dto.bookmark.BookMarkDTO;
import koreatechbus.service.BookmarkService;

@RestController
@RequestMapping("/bookmark")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService){
        this.bookmarkService = bookmarkService;
    }

    @PostMapping("/register")
    public Bookmark registerBookmark(
        @RequestBody BookMarkDTO bookMarkDTO) {
        return bookmarkService.registerBookmark(bookMarkDTO);
    }
}
