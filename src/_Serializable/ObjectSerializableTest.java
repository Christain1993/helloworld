package _Serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import _Model.Teacher;

public class ObjectSerializableTest {
	
	public static void main(String[] args) throws Exception, IOException {
//		ObjectOutput oo = new ObjectOutputStream(new FileOutputStream(new File(".//person.obj")));
//		oo.writeObject(new Teacher(1L, "hahah", null));
		
		ObjectInput oi = new ObjectInputStream(new FileInputStream(new File(".//person.obj") ));
		Teacher readObject = (Teacher) oi.readObject();
		System.out.println(readObject);
	} 
}
