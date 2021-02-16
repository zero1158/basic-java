File类:
    相对路径:相对于某个路径下,指明剩余的路径
    绝对路径:包含盘符在内的所有路径
    路径分隔符: wimdows-->\\    nuix -->/
        File中的separator常量
    创建文件对象:
                new File(String filePath); 通过文件路径获取(相对路径/绝对路径)
                new File(String parentPath,String childPath);
                new File(File parentFile,String childPath);