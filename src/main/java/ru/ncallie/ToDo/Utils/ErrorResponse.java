package ru.ncallie.ToDo.Utils;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {
    private String message;
    private long timestamp;
}
