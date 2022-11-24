package org.zwq.enums;

import org.zwq.command.*;

/**
 * @author zhangweiqiang
 * @date 2022/11/24
 **/
public enum Expression {

    PLUS('+', "+", PlusCommand.class),
    SUBTRACT('-', "-", SubtractCommand.class),
    MULTIPLY('*', "×", MultiplyCommand.class),
    DIVIDE('/', "÷", DivideCommand.class)
    ;

    private final Character exp;

    private final String shopExp;

    private final Class<? extends Command> clazz;

    Expression(final Character exp, String shopExp, final Class<? extends Command> clazz) {
        this.exp = exp;
        this.shopExp = shopExp;
        this.clazz = clazz;
    }

    public Character getExp() {
        return exp;
    }

    public Class<? extends Command> getClazz() {
        return clazz;
    }

    public String getShopExp() {
        return shopExp;
    }

    public static Expression findByExp(Character exp) {
        for (Expression expression : values()) {
            if (expression.getExp().equals(exp)) {
                return expression;
            }
        }
        throw new RuntimeException("unsupported expression");
    }

}
