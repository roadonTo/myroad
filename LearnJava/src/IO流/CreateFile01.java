package IO流;

/**
 * 1. 创建文件
 * (其实就是根据路径构建一个file对象，几种不同的构造器不过是把路径分开了)
 * new File(String pathname);
 * new File(File parent, String child);
 * <p>
 * createNewFile() //创建新文件
 * //构造器方法只是在内存中创建了file对象，
 * //必须调用createNewFile()方法才能把文件写入硬盘
 * <p>
 * <p>
 * 2. 获取文件的信息
 * （这些方法都是所见即所得，没有什么编程思想在里面，敲一遍你知道有哪些方法就可以了）
 * getName 获取文件名
 * getAbsolutePath 获取绝对路径
 * getParent 获取父路径
 * length 获取文件大小
 * exists 是否存在
 * isFile 是否是文件
 * isDirectory 是否是目录
 * <p>
 * <p>
 * 3. 目录操作
 * mkdir 创建一级目录
 * mkdirs 创建多级目录
 * delete 删除空目录或文件，（若目录不为空 则需先删除文件再删除目录）
 * <p>
 * (我们可以通过delete看出，其实Java中把目录也当成了文件 在处理)
 */
public class CreateFile01 {

    public static void main(String[] args) {

/*
        //方法一
        File file1 = new File("e:\\ideaProject\\test1");
        //方法二
        File file2 = new File("e:\\","test2");
        //方法三
        File file3 = new File("e:\\","test3");
        try {
            file1.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        File file = new File("e:\\ideaProject\\test1");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParentFile());
        System.out.println(file.getParent());
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.length());


        String filePath = "e:\\test\\test1\\test2";
        File file = new File(filePath);
        if (file.mkdirs()){
            System.out.println("创建成功");
        }

*/
    }

}
