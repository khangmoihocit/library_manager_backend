package khangmoihocit.library_manager.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    USERNAME_EXISTED(1001, "user name đã tồn tại", HttpStatus.BAD_REQUEST),
    EMAIL_EXISTED(1002, "email đã tồn tại", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1003, "user không tồn tại", HttpStatus.BAD_REQUEST),

    AUTHOR_NOT_EXISTED(2001, "tác giả không tồn tại", HttpStatus.NOT_FOUND),
    INVALID_DATE_FORMAT(2002, "Lỗi dịnh dạng ngày (yyyy-mm-dd)", HttpStatus.BAD_REQUEST),

    CATEGORY_NOT_EXISTED(3001, "thể loại sách không tồn tại", HttpStatus.NOT_FOUND),
    CATEGORIES_EMPTY(3001, "Không có thể loại sách nào trong kho", HttpStatus.BAD_REQUEST),

    BOOK_NOT_EXISTED(4001, "sách không tồn tại", HttpStatus.NOT_FOUND),


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
