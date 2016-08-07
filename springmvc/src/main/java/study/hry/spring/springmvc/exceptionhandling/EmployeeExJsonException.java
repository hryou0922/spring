package study.hry.spring.springmvc.exceptionhandling;

public class EmployeeExJsonException extends Exception {

  private static final long serialVersionUID = -3332292346834265371L;

  public EmployeeExJsonException(int id){
    super("EmployeeExJsonException with id="+id);
  }
}
