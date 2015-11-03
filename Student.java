import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Components implements Serializable {
   public int id;
   public String name;
   public String department;
   public int phoneNumber;
}

public class Student {      
   
   static Scanner scan = new Scanner(System.in);
   static Components[] student = new Components[999];
   static int i = 0, result=0;
   public static String  id;
   public static String id2;
   public static String[] s_id =new String [999];
   public static String[] name=new String [999];
   public static String[] department=new String[999];
   public static String[] phoneNumber= new String[999];
   static int number[] = {0};
   static int num=0;
   //cp배열 = 학생정보 입력되는배열, i = cp배열의 index, 
   //id=첫인덱스값이면 cp[i]에 바로 삽입 & 첫인덱스가아니면 idcheck로들어가서 중복되었나체크! 중복체크끝난 id는 id2에 저장되고 중복아닌거알게된애들 cp에삽입
   //result = case4 학생정보출력에서 찾았을경우 1로 변경, 초기화는 0으로해두었기때문에 못찾았을때 못찾았다고 if문넣어둬쏭
   public static void Addstudent() throws FileNotFoundException, IOException, ClassNotFoundException{
      //FileReader readFile = new FileReader("student.txt");
      //i = readFile.read();
      BufferedReader reader = 
            new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter writer = 
            new BufferedWriter(new FileWriter("student.txt",true));
      //FileWriter studentFile = new FileWriter("student.txt",true);
      System.out.println("[학생 정보 입력]");
      //cp[i] = new Components();
      student[i] = new Components();
      scan.nextLine();
      System.out.print("학번 : ");
      id = reader.readLine();
      
      if(i>0){
         Idcheck(id);
         //cp[i].id = id2;   
         s_id[i] = id2;
         
      }
      else{
         //cp[i].id = id;
         s_id[i] = id;
      }
      //studentFile.write(s_id[i]);
      //scan.nextLine();
      System.out.print("이름 : ");
      //cp[i].name = scan.nextLine();
      name[i] = scan.nextLine();
      //studentFile.write(name[i]);
      System.out.print("학과 : ");
      //cp[i].department = scan.nextLine();
      department[i] = reader.readLine();
      //studentFile.write(department[i]);
      System.out.print("전화번호 : ");
      //cp[i].phoneNumber = scan.nextInt();
      phoneNumber[i] = reader.readLine();
      //studentFile.write(phoneNumber[i]);
      //studentFile.write("**"+i);
      System.out.println("입력i값"+i);
      //studentFile.close();
      num++;
      String item = String.format("%s|%s|%s|%s\n",
            s_id[i],name[i],department[i],phoneNumber[i]);

         writer.write(item);
         
         writer.close();
         i++;
//       ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.txt"));
//        oos.writeInt(i);
//        for(int j = 0; j < i; j++){
//           oos.writeObject(cp[j]);
//           
//        }
           
        //oos.close();
        System.out.println("학생정보가 저장되었습니다.");
   }

   public static void Idcheck(String id) throws FileNotFoundException, IOException, ClassNotFoundException{
      //ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"));
      BufferedReader readFile = new BufferedReader(new FileReader("student.txt"));
      //FileReader readFile = new FileReader("student.txt");
      String id_i = readFile.readLine();
      System.out.println("중복i값"+i);
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
   
   public static void ViewStudent() throws FileNotFoundException, IOException, ClassNotFoundException{
//      if(i==0){
//         System.out.println("저장된 학생정보가 없습니다.");
//      }
//      else{
//         //FileReader readFile = new FileReader("student.txt");
         BufferedReader readFile = new BufferedReader(new FileReader("student.txt"));
           scan.nextLine();
         System.out.print("검색하고자 하는 학생의 학번을 입력하세요 : ");
         int sn = scan.nextInt();
         //ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"));
            i = readFile.read();
            int num=0;
            BufferedReader reader = 
                new BufferedReader(new FileReader("student.txt"));
             String line="";
             

             while((line = reader.readLine()) != null) {
                //홍길동|20|010-555-8888|서울시
                //사람 수 만큼
                String[] temp = line.split("\\|");
                
                   int intId = Integer.parseInt(temp[0]);
                if(sn == intId)
                {
                   System.out.printf("%s\t%s\t%s\t%s\n",
                          temp[0],temp[1],temp[2], temp[3]);
                    
                   
                   
                }
//                else{
//                   System.out.printf(sn+"sn이랑 "+temp[0]+"\n");
//                }
                
             }

             reader.close();
 
            
            
            
            
//            System.out.println("i값:"+i);
//            for(int j = 0; j<i; j++){
//              if(sn == s_id[j]){
//                 System.out.println("학생정보 읽기 결과");
//                 System.out.println("학번 : " + s_id[j]+" / 이름 : "+name[j]+" / 학과  : "+department[j]+" / 전화번호 : "+phoneNumber[j]); 
//                    result = 1;
//                 break;
//              }
//           }
//           if(result == 0){
//              System.out.println("학생정보가 없습니다.");
//           }
      }
   //}
   
   public static void AllViewStudent() throws IOException{
      //FileReader readFile = new FileReader("student.txt");
      BufferedReader readFile = new BufferedReader(new FileReader("student.txt"));
        i = readFile.read();
        System.out.println("전체"+i);
        //System.out.println(s_id[i]);
        
        BufferedReader reader = 
            new BufferedReader(new FileReader("student.txt"));
         
         String line = "";

         while((line = reader.readLine()) != null) {
            //홍길동|20|010-555-8888|서울시
            //사람 수 만큼
            String[] temp = line.split("\\|");

            System.out.printf("%s\t%s\t%s\t%s\n",
               temp[0],temp[1],temp[2], temp[3]);
         }

         reader.close();
//        String s;
//        while ((s = readFile.readLine()) != null) {
//            System.out.println(s);
//          }
//        
        System.out.println("학번  \t 이름 \t 학과 \t 전화번호");
        for(int j = 0; j<=i; j++){
           if(s_id[j] != null){
              System.out.println(s_id[j]+ "\t" + name[j] + "\t" + department[j] + "\t" + phoneNumber[j]);
           }
        }
   }

   public static void UpdateStudent() throws IOException{
      BufferedWriter writer = 
            new BufferedWriter(new FileWriter("student.txt",true));
      BufferedReader reader = 
            new BufferedReader(new FileReader("student.txt"));
          scan.nextLine();
         System.out.print("수정하고자 하는 학생의 학번을 입력하세요 : ");
         int sn = scan.nextInt();

         String line = "";
         String item;
         while((line = reader.readLine()) != null) {
            //홍길동|20|010-555-8888|서울시
            //사람 수 만큼
            String[] temp = line.split("\\|");

            System.out.printf("%s\t%s\t%s\t%s\n",
               temp[0],temp[1],temp[2], temp[3]);
            int o_id = Integer.parseInt(temp[0]);
            for(int j = 0; j<(num*4)-1; j=j+3){
                    if(sn == o_id){
                       System.out.print("수정할 전화번호 : ");
                       phoneNumber[j] = scan.nextLine();
                       //result = result.replaceAll(",", ";") + ";";
                     //bw.write(result + "\r\n");
                     //bw.flush();
                      String change =temp[3].replace(temp[3], phoneNumber[j]);
                      item = String.format("%s|%s|%s|%s\n",
                            temp[0],temp[1],temp[2],change);
           
                      writer.write(item);
                    }
                 
         }

         reader.close();
         }
         
//           for(int j = 0; j<i; j++){
//              if(sn == (s_id[j])){
//                 System.out.print("수정할 전화번호 : ");
//                 phoneNumber[j] = scan.nextInt();
//                 
//                 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.txt"));
//                  oos.writeInt(i);
//                  oos.writeObject(cp[j]);
//                  oos.close();
//                  System.out.println("전화번호가 수정되었습니다.");
//                  
//                    System.out.println("전화번호 수정 결과");
//                    System.out.println("학번 : " + cp[j].id +" / 이름 : "+cp[j].name+" / 학과  : "+cp[j].department+" / 전화번호 : "+cp[j].phoneNumber); 
//              }
//           }
      
   }

   public static void DeleteStudent() throws FileNotFoundException, IOException{
      FileWriter fw = new FileWriter("delete.txt", false);
      BufferedWriter writer = 
            new BufferedWriter(new FileWriter("student.txt",true));
      scan.nextLine();
      System.out.print("삭제하고자 하는 학생의 학번을 입력하세요 : ");
      int sn = scan.nextInt();
       System.out.println("sn값"+sn);
       String item;
        BufferedReader reader = 
            new BufferedReader(new FileReader("student.txt"));
         String newline = "";
         while((newline = reader.readLine()) != null) {
         
            num++;
            System.out.println("여기들어오니?"+num);
            String[] newtemp = newline.split("\\|");
            System.out.printf("%s\t%s\t%s\t%s\n",
                  newtemp[0],newtemp[1],newtemp[2], newtemp[3]);
            System.out.println("값은?"+newtemp[0]);
               int intId = Integer.parseInt(newtemp[0]);
               System.out.println("intId값"+intId);
               System.out.println("num값"+num);
            for(int j=0; j<(num*4)-1; j++){  
               if(intId==sn){
                  //System.out.println("같다면");
                  //System.out.println(intId+"끝났니?");         
               }
               else{
                   item = String.format("%s|%s|%s|%s\n",
                      newtemp[0],newtemp[1],newtemp[2],newtemp[3]);
                  System.out.println("j값"+j);
                  System.out.println((num*4)-1+"");
                  fw.write(item);
                  //FileOutputStream fos = new FileOutputStream("student.txt", true);
                 //fos.write(item.getBytes());
                 //writer = new BufferedWriter(fw);
                  System.out.println("item값"+item);
                  //writer.close();
                  
             }
            }
            }   
         fw.close();
      
         reader.close();

//      scan.nextLine();
//         System.out.print("삭제하고자 하는 학생의 학번을 입력하세요 : ");
//         int sn = scan.nextInt();
//         
//         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"));
//            i = ois.readInt();
//           for(int j=0; j<i; j++){  
//               if(cp[j].id==cp[i-1].id){
//                   cp[i-1].id = -1;
//                }
//               if(cp[j].id==sn){
//                  for(int k=j; k<i-1; k++){
//                     cp[k] = cp[k+1];
//                  }   
//                  return;
//               }
//            }
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
      case 2:
         UpdateStudent();
         break;
      case 3:
         DeleteStudent();
         break;
      case 4:
         ViewStudent();
         break;
      case 5:
         AllViewStudent();
         break;
      case 6:
         System.out.println("종료");
         System.exit(0);
         break;
      }
   }while(menu != 6);
   }
}



