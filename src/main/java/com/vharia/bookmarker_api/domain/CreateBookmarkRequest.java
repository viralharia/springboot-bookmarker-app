package com.vharia.bookmarker_api.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookmarkRequest {
    private String title;
    private String url;
}
