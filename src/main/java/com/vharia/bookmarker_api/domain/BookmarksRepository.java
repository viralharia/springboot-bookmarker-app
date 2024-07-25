package com.vharia.bookmarker_api.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface BookmarksRepository extends JpaRepository<Bookmark, Long> {
}
