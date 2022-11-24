package org.zwq;

import org.zwq.command.Command;
import org.zwq.command.CommandFactory;
import org.zwq.entity.CalculationNodes;
import org.zwq.entity.CalculationRecord;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author zhangweiqiang
 * @date 2022/11/24
 **/
public class Calculator {

    private CalculationNodes nodes;

    public Calculator() {
        this.nodes = new CalculationNodes();
    }

    public CalculationRecord calculate(String inputExp) {
        CalculationRecord latest = this.nodes.getLatest();

        double[] values = new double[2];
        int index = 0;
        Character exp = null;
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < inputExp.length(); i++) {
            char c = inputExp.charAt(i);
            if ((c >= '0' && c <= '9') || c == '.') {
                number.append(c);
            } else if (index < values.length) {
                String str = number.toString();
                // 如果操作符是第一个字符，那表示第一个数字使用上一次计算的结果
                values[index] = "".equals(str) ? (i == 0 && latest != null ? latest.getResult() : 0) : new BigDecimal(str).doubleValue();
                number.delete(0, number.length());
                index++;
                exp = c;
            } else {
                throw new IllegalArgumentException(String.format("illegal expression: %s", inputExp));
            }
        }
        String str = number.toString();
        values[index] = "".equals(str) ? 0 : new BigDecimal(str).doubleValue();

        return this.calculate(values[0], values[1], exp);
    }

    public CalculationRecord calculate(Double first, Double second, Character exp) {
        Command command = CommandFactory.create(first, second, exp);
        CalculationRecord record = command.exec();

        this.nodes.add(record);

        return record;
    }

    public CalculationRecord undo() {
        return this.nodes.undo();
    }

    public CalculationRecord redo() {
        return this.nodes.redo();
    }

    public void clear() {
        this.nodes.clear();
    }

    /**
     * 输入，以下基数行是输入，偶数行是输入；支持计算符 + - * /，支持命令 cc: 清空， redo、undo，esc：退出
     * 10*11
     * 10.0 × 11.0 = 110.0
     * +12
     * 110.0 + 12.0 = 122.0
     * *1.5566
     * 122.0 × 1.5566 = 189.9052
     * /33
     * 189.9052 ÷ 33.0 = 5.75470303030303
     * +100
     * 5.75470303030303 + 100.0 = 105.75470303030303
     * +200
     * 105.75470303030303 + 200.0 = 305.754703030303
     * -20
     * 305.754703030303 - 20.0 = 285.754703030303
     * undo
     * 105.75470303030303 + 200.0 = 305.754703030303
     * undo
     * 5.75470303030303 + 100.0 = 105.75470303030303
     * +36
     * 105.75470303030303 + 36.0 = 141.75470303030303
     * +14
     * 141.75470303030303 + 14.0 = 155.75470303030303
     * *25
     * 155.75470303030303 × 25.0 = 3893.8675757575757
     * undo
     * 141.75470303030303 + 14.0 = 155.75470303030303
     * undo
     * 105.75470303030303 + 36.0 = 141.75470303030303
     * redo
     * 141.75470303030303 + 14.0 = 155.75470303030303
     * redo
     * 155.75470303030303 × 25.0 = 3893.8675757575757
     * cc
     * 0
     * 6+5
     * 6.0 + 5.0 = 11.0
     * esc
     *
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        shutdown: while (true) {
            String input = scanner.nextLine();
            // 用于显示的计算结果
            CalculationRecord record = null;
            switch (input) {
                case "cc":
                    // 清空
                    nodes.clear();
                    break;
                case "esc":
                    nodes.clear();
                    break shutdown;
                case "undo":
                    record = nodes.undo();
                    break;
                case "redo":
                    record = nodes.redo();
                    break;
                default:
                    record = calculate(input);
                    break;
            }
            System.out.println(record == null ? 0 : (record.getFullExp() + " = " + record.getResult()));
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.start();
    }

}
