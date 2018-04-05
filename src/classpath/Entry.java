package classpath;
import java.io.*;

/**
 * Created by yin on 18/4/2.
 */
// 用来创建各种路径实例的类
class NewEntry {

    public static Entry newEntry(String path) {
        if (path != null) {
            if (path.contains(Entry.pathListSeparator)) {
                return new Composite_Entry(path);
            }
            if (path.endsWith("*")) {
                return new Wildcard_Entry(path);
            }
            if (path.endsWith(".jar") || path.endsWith(".JAR") ||
                    path.endsWith(".zip") || path.endsWith(".ZIP")) {
                return new Zip_Entry(path);
            }
            return new Dir_Entry(path);
        } else {
            throw new RuntimeException("输入错误!");
        }
    }
}

// 路径接口
public interface Entry {
    String pathListSeparator = File.pathSeparator;

    String string(); //返回变量的字符串表示
    byte[] readClass(String className) throws IOException; //class文件的包路径
}

