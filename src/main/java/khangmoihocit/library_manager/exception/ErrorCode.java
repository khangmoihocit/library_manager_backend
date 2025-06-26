package khangmoihocit.library_manager.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    BOOK_NOT_EXISTED(3001, "sách không tồn tại", HttpStatus.NOT_FOUND),
    AUTHOR_NOT_EXISTED(1001, "tác giả không tồn tại", HttpStatus.NOT_FOUND),
    INVALID_DATE_FORMAT(1002, "Lỗi dịnh dạng ngày (yyyy-mm-dd)", HttpStatus.BAD_REQUEST),
    ;


    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;
}
