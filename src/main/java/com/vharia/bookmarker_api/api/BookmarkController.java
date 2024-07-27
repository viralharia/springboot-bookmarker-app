package com.vharia.bookmarker_api.api;

import com.vharia.bookmarker_api.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkDTO createBookmark(@RequestBody CreateBookmarkRequest createBookmarkRequest) {
        return bookmarkService.createBookmark(createBookmarkRequest);
    }


}
