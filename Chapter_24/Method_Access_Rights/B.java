/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

public class B extends A {
  public B(A a){ 
     super(a);
     System.out.println("B object created!");
  }

  public  B(){
    System.out.println("B object created!");
  }

  public void f(A a){
    super.f(a);
    System.out.println("B.f() called!");
  }
  
  public String g(){
    return "B.g()";
  }
}