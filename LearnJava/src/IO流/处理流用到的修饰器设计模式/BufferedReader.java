package IO流.处理流用到的修饰器设计模式;

public class BufferedReader extends Reader_ {
    private Reader_ reader_;

    public BufferedReader(Reader_ reader_){
        this.reader_ = reader_;
    }


    public void readFile(int num) {
        for (int i = 0; i < num; i++){
            reader_.readFile();
        }
    }


    public void readString(int num) {
        for (int i = 0; i < num; i++){
            reader_.readString();
        }
    }
}
