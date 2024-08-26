package flog.instagram_clone_coding.service;

import flog.instagram_clone_coding.domain.Bookmark;
import flog.instagram_clone_coding.domain.Post;
import flog.instagram_clone_coding.domain.Users;
import flog.instagram_clone_coding.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    public List<Bookmark> getBookmarkByUser(Users user) {
        return bookmarkRepository.findByUser(user);
    }

    public Bookmark addBookmark(Users user, Post post) {
        Bookmark bookmark = Bookmark.builder()
                .user(user)
                .post(post)
                .build();
        return bookmarkRepository.save(bookmark);
    }

    public void deleteBookmark(Long bookmarkId) {
        bookmarkRepository.deleteById(bookmarkId);
    }
}
