package DiaryM;

public class DiaryAlreadyExistException extends RuntimeException{
    public DiaryAlreadyExistException(String message){
        super(message);
    }

}
