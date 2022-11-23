package IO流.处理流用到的修饰器设计模式;


public class Test_ {

    public static void main(String[] args) {
        BufferedReader reader_ = new BufferedReader(new FileReader_());
        reader_.readFile(5);
        BufferedReader reader2 = new BufferedReader(new StringReader_());
        reader2.readString(6);
    }
}
