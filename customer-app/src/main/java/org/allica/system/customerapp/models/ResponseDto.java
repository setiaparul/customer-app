package org.allica.system.customerapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ResponseDto<T> {

    private T data;
    private String message;
    private int status;

    public ResponseDto(T data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public ResponseDto() {
    }
}
