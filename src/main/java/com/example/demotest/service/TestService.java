package com.example.demotest.service;

import com.example.demotest.bean.User;
import com.example.demotest.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class TestService {

    private final TestMapper testMapper;

    @Autowired
    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    public String upload(File file1) throws IOException {
        File file = new File("E:\\Desktop\\Desktop.zip");
        FileInputStream input = new FileInputStream(file);
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(input), Charset.forName("GBK"));
        ZipEntry ze = null;
        Map<String, List<String>> directoryStructure = new HashMap<>();

        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            String filePath = zipEntry.getName();
            if (!zipEntry.isDirectory()) {
                // 获取目录路径，确保不会因为路径不以'/'结尾而越界
                int lastIndex = filePath.lastIndexOf('/');
                String directoryPath = lastIndex != -1 ? filePath.substring(0, lastIndex) : "";

                // 获取文件名
                String fileName = filePath.substring(lastIndex + 1);

                // 添加文件名到对应的目录路径列表中
                directoryStructure.computeIfAbsent(directoryPath, k -> new ArrayList<>()).add(fileName);
            }
            zipInputStream.closeEntry();
        }

        // 输出目录结构和文件名
        for (Map.Entry<String, List<String>> entry : directoryStructure.entrySet()) {
            String directory = entry.getKey();
            if (!directory.isEmpty()) {
                System.out.println("Directory: " + directory);
            }
            for (String fileName : entry.getValue()) {
                System.out.println("  File: " + fileName);
            }
        }
        input.close();
        return "success";
    }

    public String addUser(User user) {
        int res = testMapper.insert(user);
//        int res = testMapper.insert(user);
        if (res != 1) return "添加失败";
        return "添加成功";
    }
}
