//create a class containing an int and char to verify that java preforms default initialization 
class container{
  int i;
  char c;
}

class Exercise1{
  public static void main(String[] args){
    container c = new container();
    System.out.println(c.i);
    System.out.println(c.c);
  }
}
