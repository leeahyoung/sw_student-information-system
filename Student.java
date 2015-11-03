
import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class Student {      

   static Scanner scan = new Scanner(System.in);
   static int i = 0, result=0;
   public static String  id;
   public static String id2;
   public static String[] s_id =new String [999];
   public static String[] name=new String [999];
   public static String[] department=new String[999];
   public static String[] phoneNumber= new String[999];
   static int num=0;

   public static void Addstudent() throws FileNotFoundException, IOException, ClassNotFoundException{
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter writer = new BufferedWriter(new FileWriter("student.txt",true));
      System.out.println("[학생 정보 입력]");
      scan.nextLine();
      System.out.print("학번 : ");
      id = reader.readLine();

      
      System.out.print("이름 : ");
      name[i] = scan.nextLine();
      System.out.print("학과 : ");
      department[i] = reader.readLine();
      System.out.print("전화번호 : ");
      phoneNumber[i] = reader.readLine();
      System.out.println("입력i값"+i);
      num++;
      String item = String.format("%s|%s|%s|%s\n",s_id[i],name[i],department[i],phoneNumber[i]);
      writer.write(item);
      writer.close();
      i++;
      System.out.println("학생정보가 저장되었습니다.");
   }

   public static void Idcheck(String id) throws FileNotFoundException, IOException, ClassNotFoundException{
	      BufferedReader readFile = new BufferedReader(new FileReader("student.txt"));
	      String id_i = readFile.readLine();
	      for(int j = 0; j<i; j++){
	         if(id == (s_id[j])){
	            System.out.println("학번 중복! 다시 입력하세요.");
	            System.out.print("학번 : ");
	            id = scan.next();
	            Idcheck(id);
	         }
	         else{
	            id2 = id;
	         }
	      }
	   }

	public static void AllViewStudent() throws IOException{
      BufferedReader readFile = new BufferedReader(new FileReader("student.txt"));
      i = readFile.read();
      BufferedReader reader = new BufferedReader(new FileReader("student.txt"));
      String line = "";
      System.out.println("기존파일에 저장된 내용");
      System.out.println("학번  \t 이름 \t 학과 \t 전화번호");
      while((line = reader.readLine()) != null) {
         String[] temp = line.split("\\|");
         System.out.printf("%s\t%s\t%s\t%s\n",temp[0],temp[1],temp[2], temp[3]);
      }
      reader.close();
   }


   public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
      int menu=0;   
      do{
         do{
            System.out.println("------------------------------");
            System.out.println("1 학생 정보 입력");
            System.out.println("2 전화번호 수정");
            System.out.println("3 학생 정보 삭제");
            System.out.println("4 학생 정보 출력");
            System.out.println("5 전체 학생 정보 출력");
            System.out.println("6 종료");
            System.out.println("------------------------------");
            System.out.print("메뉴 입력 : ");
            menu = scan.nextInt();
         }while(menu < 1 || menu > 6);
         switch(menu){
         case 1:
            Addstudent();
            break;
         
         }
      }while(menu != 6);
   }
}


