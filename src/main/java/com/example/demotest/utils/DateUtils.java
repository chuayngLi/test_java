package com.example.demotest.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xx
 * @date 2024/4/12 16:55
 */

public class DateUtils {
    public static List<String> extractNumbers(String input) {
        List<String> numbers = new ArrayList<>();
        StringBuilder numberBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch) || isChineseDigit(ch)) { // 判断字符是否是数字或中文数字
                numberBuilder.append(ch); // 将数字字符添加到字符串构建器中
            } else if (!numberBuilder.isEmpty()) { // 如果字符串构建器中有数字字符
//                int number = Integer.parseInt(numberBuilder.toString()); // 将字符串构建器中的数字字符转换为整数
                numbers.add(String.valueOf(numberBuilder)); // 添加到整数列表中
                numberBuilder.setLength(0); // 清空字符串构建器
            }
        }

        if (!numberBuilder.isEmpty()) { // 处理末尾的数字
            int number = Integer.parseInt(numberBuilder.toString());
            numbers.add(String.valueOf(number));
        }

        return numbers;
    }

    // 判断字符是否是中文数字
    private static boolean isChineseDigit(char ch) {
        return ch >= '\u4e00' && ch <= '\u9fa5' && (ch == '零' || ch == '一' || ch == '二' || ch == '三' || ch == '四' || ch == '五'
                || ch == '六' || ch == '七' || ch == '八' || ch == '九');
    }

    public static void main(String[] args) {
        String text = "这是一个示例文本，包含123相连的数字，还有456中文数字。";
        List<String> extractedNumbers = extractNumbers(text);

        System.out.println("提取的数字列表：" + extractedNumbers);

    }
}