package behavioral.interpreter.simple;

import java.util.Map;

/**
 * 抽象表达式
 */
interface Expression {
    boolean interpret(Context context);
}

/**
 * 上下文
 */
class Context {
}

/**
 * 终结符表达式
 */
class TerminalExpression implements Expression {
    private final String statement;

    public TerminalExpression(String statement) {
        this.statement = statement;
    }

    @Override
    public boolean interpret(Context context) {
        return Map.of("true", true, "false", false).get(statement);
    }
}

/**
 * 非终结符表达式
 */
class AndExpression implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public AndExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public boolean interpret(Context context) {
        return leftExpression.interpret(context) && rightExpression.interpret(context);
    }
}

class OrExpression implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public OrExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public boolean interpret(Context context) {
        return leftExpression.interpret(context) || rightExpression.interpret(context);
    }
}

/**
 * @author yuzhian
 */
public class InterpreterDemo {
    public static void main(String[] args) {
        System.out.println(new AndExpression(
                new TerminalExpression("true"),
                new TerminalExpression("false"))
                .interpret(new Context()));
        System.out.println(new OrExpression(
                new TerminalExpression("true"),
                new TerminalExpression("false"))
                .interpret(new Context()));
    }
}
