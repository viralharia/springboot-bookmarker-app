package com.vharia.bookmarker_api.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookmarkRequest {
    @NotNull(message = "Title cannot be blank")
    private String title;

    @NotNull(message = "URL cannot be blank")
    private String url;
}
