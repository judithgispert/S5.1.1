package cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.exceptions;

public class BranchNotFoundException extends RuntimeException{
    public BranchNotFoundException (String errorMessage){
        super(errorMessage);
    }

}
