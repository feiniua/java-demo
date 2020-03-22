package proxy.utils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author: huu
 * @date: 2020/2/2 23:05
 * @description:
 *      手动生成一个代理类
 */
public class ProxyUtil {
    /**
     * step1.得到一个代理对象的java文件
     * step2.编译成为一个class文件
     * step3.classloador加载磁盘上的class文件
     * step4.通过反射获得对象
     * step5.返回代理对象
     * @param object
     * @return
     * @throws IOException
     */
    public static Object newProxyInstance(Object object) throws Exception {
        String content = "";
        Class inter = object.getClass().getInterfaces()[0];
        String interName = inter.getSimpleName();
        String packContent = "package proxydemo;";
        String firstContent = "public class $Proxy implements " + interName + "{";
        String fieldContent = "private " + interName + " target;";
        String constructorContent = "public $Proxy(" + interName + " target) {" +
                "this.target = target;" +
                "}";
        Method[] methods = inter.getDeclaredMethods();
        String methodsContent = "";
        for (Method method : methods) {
            String returnTypeName = method.getReturnType().getSimpleName();
            String methodName = method.getName();
            Class[] parameterTypes = method.getParameterTypes();
            String argsContent = "";
            String parameterContent = "";
            int i = 0;
            for (Class parameterType : parameterTypes) {
                String simpleName = parameterType.getSimpleName();
                argsContent += simpleName + " p" + i + ",";
                parameterContent += " p" + i + ",";
                i++;
            }
            if (argsContent.length() > 0) {
                argsContent = argsContent.substring(0, argsContent.lastIndexOf(",") - 1);
                parameterContent = parameterContent.substring(0, parameterContent.lastIndexOf(",") - 1);
            }
            methodsContent += "public " + returnTypeName + " " + methodName + "(" + argsContent + "){" +
                    "System.out.println(\"ProxyUtil\");" +
                    "target." + methodName + "(" + parameterContent +");" +
                    "}";
        }
        content += packContent  + firstContent + fieldContent + constructorContent + methodsContent +"}";

        File file = new File("E:\\IdeaProjects\\demo-jdkDebug\\src\\proxydemo\\$Proxy.java");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(content);
        fileWriter.flush();
        fileWriter.close();

        // 可以将文件编译成class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);
        Iterable units = fileManager.getJavaFileObjects(file);
        // 把任务当成一个编译任务执行
        JavaCompiler.CompilationTask t = compiler.getTask(null,fileManager,null,null,null,units);
        t.call();
        fileManager.close();

        // 通过类加载器获取类然后反射得到代理对象
        URL[] urls = new URL[] {new URL("file:e:\\\\IdeaProjects\\demo-jdkDebug\\src.")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class clazz = urlClassLoader.loadClass("proxydemo.$Proxy");
        Constructor constructor = clazz.getConstructor(inter);
        Object proxy = constructor.newInstance(object);

        return proxy;
    }
}
