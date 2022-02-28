/*****************************************************************
   provided for instructional purposes only. No warranty concerning
   the quality of this code is expressed or implied. You are free to 
   use this code in your programs so long as this copyright notice
   is included in its entirety.

public class C extends B {
  public C(A a){ 
     super(a);
     System.out.println("C object created!");
  }
  
  public C(){
   System.out.println("C object created!");
  }

  public void f(A a){
    super.f(a);
    System.out.println("C.f() called!");
  }
  
  public String g(){
    return "C.g()";
  }
}