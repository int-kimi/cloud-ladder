package IR;

public class LazyExecutionEndIR extends IRNode {

  @Override
  public IROperator getOp() {
    return IROperator.LazyExecutionEnd;
  }

  @Override
  public String toString() {
    return String.format("%s Lazy Execution End", labels);
  }

}
