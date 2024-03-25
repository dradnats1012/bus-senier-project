package koreatechBus.service;

import java.awt.print.Book;

import org.springframework.stereotype.Service;

import koreatechBus.domain.Bookmark;
import koreatechBus.domain.Bus;
import koreatechBus.domain.User;
import koreatechBus.dto.bookmark.BookMarkDTO;
import koreatechBus.repository.BookmarkRepository;
import koreatechBus.repository.BusRepository;
import koreatechBus.repository.UserRepository;

@Service
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;
    private final BusRepository busRepository;

    public BookmarkService(BookmarkRepository bookmarkRepository, UserRepository userRepository, BusRepository busRepository){
        this.bookmarkRepository = bookmarkRepository;
        this.userRepository = userRepository;
        this.busRepository = busRepository;
    }

    public Bookmark registerBookmark(BookMarkDTO bookMarkDTO){
        User user = userRepository.findByUserId(bookMarkDTO.userId());
        Bus bus = busRepository.findByBusId(bookMarkDTO.busId());

        Bookmark bookmark = new Bookmark(user, bus);
        return bookmarkRepository.save(bookmark);
    }
}
