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
   //cp�迭 = �л����� �ԷµǴ¹迭, i = cp�迭�� index, 
   //id=ù�ε������̸� cp[i]�� �ٷ� ���� & ù�ε������ƴϸ� idcheck�ε��� �ߺ��Ǿ���üũ! �ߺ�üũ���� id�� id2�� ����ǰ� �ߺ��ƴѰž˰ԵȾֵ� cp������
   //result = case4 �л�������¿��� ã������� 1�� ����, �ʱ�ȭ�� 0�����صξ��⶧���� ��ã������ ��ã�Ҵٰ� if���־�ֽ�
   public static void Addstudent() throws FileNotFoundException, IOException, ClassNotFoundException{
      //FileReader readFile = new FileReader("student.txt");
      //i = readFile.read();
      BufferedReader reader = 
            new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter writer = 
            new BufferedWriter(new FileWriter("student.txt",true));
      //FileWriter studentFile = new FileWriter("student.txt",true);
      System.out.println("[�л� ���� �Է�]");
      //cp[i] = new Components();
      student[i] = new Components();
      scan.nextLine();
      System.out.print("�й� : ");
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
      System.out.print("�̸� : ");
      //cp[i].name = scan.nextLine();
      name[i] = scan.nextLine();
      //studentFile.write(name[i]);
      System.out.print("�а� : ");
      //cp[i].department = scan.nextLine();
      department[i] = reader.readLine();
      //studentFile.write(department[i]);
      System.out.print("��ȭ��ȣ : ");
      //cp[i].phoneNumber = scan.nextInt();
      phoneNumber[i] = reader.readLine();
      //studentFile.write(phoneNumber[i]);
      //studentFile.write("**"+i);
      System.out.println("�Է�i��"+i);
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
        System.out.println("�л������� ����Ǿ����ϴ�.");
   }

   public static void Idcheck(String id) throws FileNotFoundException, IOException, ClassNotFoundException{
      //ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"));
      BufferedReader readFile = new BufferedReader(new FileReader("student.txt"));
      //FileReader readFile = new FileReader("student.txt");
      String id_i = readFile.readLine();
      System.out.println("�ߺ�i��"+i);
        for(int j = 0; j<i; j++){
            if(id == (s_id[j])){
              System.out.println("�й� �ߺ�! �ٽ� �Է��ϼ���.");
              System.out.print("�й� : ");
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
//         System.out.println("����� �л������� �����ϴ�.");
//      }
//      else{
//         //FileReader readFile = new FileReader("student.txt");
         BufferedReader readFile = new BufferedReader(new FileReader("student.txt"));
           scan.nextLine();
         System.out.print("�˻��ϰ��� �ϴ� �л��� �й��� �Է��ϼ��� : ");
         int sn = scan.nextInt();
         //ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"));
            i = readFile.read();
            int num=0;
            BufferedReader reader = 
                new BufferedReader(new FileReader("student.txt"));
             String line="";
             

             while((line = reader.readLine()) != null) {
                //ȫ�浿|20|010-555-8888|�����
                //��� �� ��ŭ
                String[] temp = line.split("\\|");
                
                   int intId = Integer.parseInt(temp[0]);
                if(sn == intId)
                {
                   System.out.printf("%s\t%s\t%s\t%s\n",
                          temp[0],temp[1],temp[2], temp[3]);
                    
                   
                   
                }
//                else{
//                   System.out.printf(sn+"sn�̶� "+temp[0]+"\n");
//                }
                
             }

             reader.close();
 
            
            
            
            
//            System.out.println("i��:"+i);
//            for(int j = 0; j<i; j++){
//              if(sn == s_id[j]){
//                 System.out.println("�л����� �б� ���");
//                 System.out.println("�й� : " + s_id[j]+" / �̸� : "+name[j]+" / �а�  : "+department[j]+" / ��ȭ��ȣ : "+phoneNumber[j]); 
//                    result = 1;
//                 break;
//              }
//           }
//           if(result == 0){
//              System.out.println("�л������� �����ϴ�.");
//           }
      }
   //}
   
   public static void AllViewStudent() throws IOException{
      //FileReader readFile = new FileReader("student.txt");
      BufferedReader readFile = new BufferedReader(new FileReader("student.txt"));
        i = readFile.read();
        System.out.println("��ü"+i);
        //System.out.println(s_id[i]);
        
        BufferedReader reader = 
            new BufferedReader(new FileReader("student.txt"));
         
         String line = "";

         while((line = reader.readLine()) != null) {
            //ȫ�浿|20|010-555-8888|�����
            //��� �� ��ŭ
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
        System.out.println("�й�  \t �̸� \t �а� \t ��ȭ��ȣ");
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
         System.out.print("�����ϰ��� �ϴ� �л��� �й��� �Է��ϼ��� : ");
         int sn = scan.nextInt();

         String line = "";
         String item;
         while((line = reader.readLine()) != null) {
            //ȫ�浿|20|010-555-8888|�����
            //��� �� ��ŭ
            String[] temp = line.split("\\|");

            System.out.printf("%s\t%s\t%s\t%s\n",
               temp[0],temp[1],temp[2], temp[3]);
            int o_id = Integer.parseInt(temp[0]);
            for(int j = 0; j<(num*4)-1; j=j+3){
                    if(sn == o_id){
                       System.out.print("������ ��ȭ��ȣ : ");
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
//                 System.out.print("������ ��ȭ��ȣ : ");
//                 phoneNumber[j] = scan.nextInt();
//                 
//                 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.txt"));
//                  oos.writeInt(i);
//                  oos.writeObject(cp[j]);
//                  oos.close();
//                  System.out.println("��ȭ��ȣ�� �����Ǿ����ϴ�.");
//                  
//                    System.out.println("��ȭ��ȣ ���� ���");
//                    System.out.println("�й� : " + cp[j].id +" / �̸� : "+cp[j].name+" / �а�  : "+cp[j].department+" / ��ȭ��ȣ : "+cp[j].phoneNumber); 
//              }
//           }
      
   }

   public static void DeleteStudent() throws FileNotFoundException, IOException{
      FileWriter fw = new FileWriter("delete.txt", false);
      BufferedWriter writer = 
            new BufferedWriter(new FileWriter("student.txt",true));
      scan.nextLine();
      System.out.print("�����ϰ��� �ϴ� �л��� �й��� �Է��ϼ��� : ");
      int sn = scan.nextInt();
       System.out.println("sn��"+sn);
       String item;
        BufferedReader reader = 
            new BufferedReader(new FileReader("student.txt"));
         String newline = "";
         while((newline = reader.readLine()) != null) {
         
            num++;
            System.out.println("���������?"+num);
            String[] newtemp = newline.split("\\|");
            System.out.printf("%s\t%s\t%s\t%s\n",
                  newtemp[0],newtemp[1],newtemp[2], newtemp[3]);
            System.out.println("����?"+newtemp[0]);
               int intId = Integer.parseInt(newtemp[0]);
               System.out.println("intId��"+intId);
               System.out.println("num��"+num);
            for(int j=0; j<(num*4)-1; j++){  
               if(intId==sn){
                  //System.out.println("���ٸ�");
                  //System.out.println(intId+"������?");         
               }
               else{
                   item = String.format("%s|%s|%s|%s\n",
                      newtemp[0],newtemp[1],newtemp[2],newtemp[3]);
                  System.out.println("j��"+j);
                  System.out.println((num*4)-1+"");
                  fw.write(item);
                  //FileOutputStream fos = new FileOutputStream("student.txt", true);
                 //fos.write(item.getBytes());
                 //writer = new BufferedWriter(fw);
                  System.out.println("item��"+item);
                  //writer.close();
                  
             }
            }
            }   
         fw.close();
      
         reader.close();

//      scan.nextLine();
//         System.out.print("�����ϰ��� �ϴ� �л��� �й��� �Է��ϼ��� : ");
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
         System.out.println("1 �л� ���� �Է�");
         System.out.println("2 ��ȭ��ȣ ����");
         System.out.println("3 �л� ���� ����");
         System.out.println("4 �л� ���� ���");
         System.out.println("5 ��ü �л� ���� ���");
         System.out.println("6 ����");
         System.out.println("------------------------------");
         System.out.print("�޴� �Է� : ");
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
         System.out.println("����");
         System.exit(0);
         break;
      }
   }while(menu != 6);
   }
}



