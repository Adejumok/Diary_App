package DiaryM;

public class DiaryDoesNotExistException extends RuntimeException{
    public DiaryDoesNotExistException(String message){
        super(message);
    }
}
