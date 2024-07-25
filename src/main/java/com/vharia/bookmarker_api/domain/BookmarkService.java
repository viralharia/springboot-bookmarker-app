package com.vharia.bookmarker_api.domain;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarksRepository bookmarksRepository;

    @Transactional(readOnly = true)
    public BookmarksDTO getBookmarks(Integer page){
        int pageNo = page-1;
        Pageable pageable = PageRequest.of(pageNo, 5, Sort.Direction.DESC, "createdAt");
        return new BookmarksDTO(bookmarksRepository.findAllBookmarks(pageable));
    }
}
