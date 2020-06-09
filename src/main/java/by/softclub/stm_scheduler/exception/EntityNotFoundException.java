package by.softclub.stm_scheduler.exception;

public class EntityNotFoundException extends RuntimeException {
    public static String error = "ERROR_ENTITY_NOT_FOUND";

    public EntityNotFoundException(String userError){
        super(userError);
    }

    public EntityNotFoundException(){
        super(error);
    }
}
