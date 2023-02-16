package az.asl.payday.response;

import org.springframework.http.ResponseEntity;

public class MessageResponse {

    public static ResponseEntity<?> response(String message){
        return ResponseEntity.ok(message);
    }
}
