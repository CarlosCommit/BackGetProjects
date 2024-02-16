package com.information.portfolio.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private String message;
    private Integer code;
    private Object entry;
}
