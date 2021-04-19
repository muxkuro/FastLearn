package sample;

public class Result {
    static String result;
    public Result(String result){
        this.result = result;
    }

    void setResult(String result){
        this.result = result;
    }
    static String getResult(){
        return result;
    }
}
