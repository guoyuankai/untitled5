package mypackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class deep_copy {
   public static void copy() throws Exception
   {
       ArrayList<ArrayList> mylist=new ArrayList<>();
       ArrayList temp=new ArrayList();
       temp.add(1);
       temp.add('b');
       temp.add("asdasd");
       mylist.add(temp);
       ArrayList<ArrayList>copyed_list=(ArrayList<ArrayList>)mylist.clone();
       ByteArrayOutputStream bos=new ByteArrayOutputStream();
       ObjectOutputStream oos=new ObjectOutputStream(bos);
       oos.writeObject(mylist);
       oos.flush();
       ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
       ArrayList<ArrayList> deep=(ArrayList<ArrayList>)ois.readObject();
       temp.add("new add");
       System.out.println('a');
   }
}
