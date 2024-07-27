package com.vharia.bookmarker_api.api;

import com.vharia.bookmarker_api.domain.Bookmark;
import com.vharia.bookmarker_api.domain.BookmarkService;
import com.vharia.bookmarker_api.domain.BookmarksDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @GetMapping
    public BookmarksDTO getBookmarks(@RequestParam(name="page", defaultValue = "1") Integer page,
                                     @RequestParam(name="search", defaultValue = "") String search){
        if (search == "" || search.trim().length() == 0) {
            return bookmarkService.getBookmarks(page);
        }else{
            return bookmarkService.getBookmarks(search,page);
        }

    }


}
