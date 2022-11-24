package org.zwq.command;

import org.zwq.enums.Expression;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangweiqiang
 * @date 2022/11/24
 **/
public class CommandFactory {

    public static Command create(Double first, Double second, Character exp) {
        Expression expression = Expression.findByExp(exp);
        Command command;
        try {
            Constructor<? extends Command> constructor = expression.getClazz()
                    .getConstructor(Double.class, Double.class, String.class);
            command = constructor.newInstance(first, second, expression.getShopExp());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("command should extend Command.class", e);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("reflect create command instance fail", e);
        }
        return command;
    }

}
