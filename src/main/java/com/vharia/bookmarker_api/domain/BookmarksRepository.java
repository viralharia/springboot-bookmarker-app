package com.vharia.bookmarker_api.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface BookmarksRepository extends JpaRepository<Bookmark, Long> {

    @Query("select new com.vharia.bookmarker_api.domain.BookmarkDTO(b.id, b.title, b.url, b.createdAt) from Bookmark b")
    Page<BookmarkDTO> findAllBookmarks(Pageable pageable);

    @Query("""
    select new com.vharia.bookmarker_api.domain.BookmarkDTO(b.id, b.title, b.url, b.createdAt) from Bookmark b
    where lower(b.title) like lower(concat('%',:search,'%'))
    """)
    Page<BookmarkDTO> findAllBookmarks(String search, Pageable pageable);
}
