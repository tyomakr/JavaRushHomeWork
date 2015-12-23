package com.javarush.test.level36.lesson10.bonus01;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* Осваиваем ClassLoader и Reflection
Аргументом для класса Solution является абсолютный путь к пакету,
например, "C:\JavaRushHomeWork\src\com\javarush\test\level36\lesson10\bonus01\data\second".
Имя пакета может содержать File.separator.
В этом пакете находятся только скомпилированные классы.
Известно, что каждый класс имеет конструктор без параметров и реализует интерфейс HiddenClass.
Считайте все классы с файловой системы, создайте фабрику - реализуйте метод getHiddenClassObjectByKey.
Известно, что есть только один класс, простое имя которого начинается с String key без учета регистра.
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution("C:\\JavaRushHomeWork\\src\\com\\javarush\\test\\level36\\lesson10\\bonus01\\data\\second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File dir = new File(packageName);
        String[] classFiles = dir.list();
        for (String file : classFiles) {
            final String finalPath = dir.getAbsolutePath() + File.separator;
            ClassLoader loader = new ClassLoader() {
                @Override
                protected Class<?> findClass(String className) throws ClassNotFoundException {
                    byte[] temp = getBytesFromFile(finalPath + className + ".class");
                    return defineClass(null, temp, 0, temp.length);
                }

                private byte[] getBytesFromFile(String fileName) {
                    File file = new File(fileName);
                    FileInputStream fis = null;
                    try {
                        fis = new FileInputStream(file);
                    } catch (Exception e) {
                        return null;
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    int size = (int) file.length();
                    byte[] b = new byte[size];
                    int rb = 0;
                    int chunk = 0;
                    try {
                        while (((int) size - rb) > 0) {
                            chunk = bis.read(b, rb, (int) size - rb);
                            if (chunk == -1) {
                                break;
                            }
                            rb += chunk;
                        }
                    } catch (IOException e) {
                        try {
                            throw new ClassNotFoundException();
                        } catch (ClassNotFoundException e1) {
                            e1.printStackTrace();
                        }
                        return null;
                    }
                    return b;
                }
            };

            Class clazz = loader.loadClass(file.substring(0, file.lastIndexOf(".")));
            if (HiddenClass.class.isAssignableFrom(clazz)) {
                hiddenClasses.add(clazz);
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for(Class clazz: hiddenClasses){
            if(clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())){
                try {
                    Constructor[] constructors = clazz.getDeclaredConstructors();
                    for(Constructor constructor: constructors){
                        if(constructor.getParameterTypes().length==0){
                            constructor.setAccessible(true);
                            return (HiddenClass) constructor.newInstance(null);
                        }
                    }
                }
                catch (InstantiationException e) {
                    e.printStackTrace();
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}