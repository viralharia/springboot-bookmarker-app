package com.vharia.bookmarker_api.domain;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarksRepository bookmarksRepository;

    @Transactional(readOnly = true)
    public BookmarksDTO getBookmarks(Integer page){
        int pageNo = page-1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        return new BookmarksDTO(bookmarksRepository.findAllBookmarks(pageable));
    }

    public BookmarksDTO getBookmarks(String search, Integer page) {
        int pageNo = page-1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        return new BookmarksDTO(bookmarksRepository.findAllBookmarks(search,pageable));
    }

    public BookmarkDTO createBookmark(CreateBookmarkRequest createBookmarkRequest) {
        Bookmark savedBookmark = bookmarksRepository.save(new Bookmark(null, createBookmarkRequest.getTitle(),
                createBookmarkRequest.getUrl(), Instant.now()));
        return toDTO(savedBookmark);
        
    }

    private BookmarkDTO toDTO(Bookmark savedBookmark) {
        BookmarkDTO bookmarkDTO = new BookmarkDTO(savedBookmark.getId(), savedBookmark.getTitle(),
                savedBookmark.getUrl(), savedBookmark.getCreatedAt());
        return bookmarkDTO;
    }


}
