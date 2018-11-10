package _Jackson;

import java.io.StringWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import _IO.IOUtils;
import _Model.Student;
import _Model.Teacher;


public class JacksonTest {
	public static void main(String[] args) throws Exception {
		modelToXml();
		xmlToModel();
	}
	
	public static void modelToXml() throws Exception {
		
		Teacher teacher = new Teacher();
		teacher.setId(1L);
		teacher.setName("hah");
		teacher.setAge(18);
		teacher.setBirthday(new Timestamp(new Date().getTime()));
		Student s1 = new Student();
		s1.setId(1L);
		s1.setName("yangyang");
		s1.setTeacher(teacher);
		Student s2 = new Student();
		s2.setId(2L);
		s2.setName("wangdaqing");
		s2.setTeacher(teacher);
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		teacher.setStudents(list);
		teacher.setStudent(s1);
		XmlMapper xmlmapper = new XmlMapper();
		String writeValueAsString = xmlmapper.writeValueAsString(teacher);
		System.out.println(writeValueAsString);
		IOUtils.save("teacher.xml", writeValueAsString);
		
	}
	
	public static void xmlToModel() throws Exception {
		String read = IOUtils.read("teacher.xml");
		XmlMapper xmlmapper = new XmlMapper();
		Teacher readValue = xmlmapper.readValue(read, Teacher.class);
		System.out.println(readValue);
		
	}
	
	
	
	public static void NODEtest() throws Exception {
		String content = IOUtils.read(".//teacher");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode readTree = mapper.readTree(content);
		JsonNodeType nodeType = readTree.getNodeType();
		System.out.println(nodeType);
		JsonNode jsonNode = readTree.get(0);
		System.out.println(jsonNode.getNodeType());
		NumberType numberType = jsonNode.get("birthday").numberType();
		System.out.println(numberType);
	}
	
	public static void NodeGenerateTest() throws Exception {
		JsonNodeFactory jsonNodeFactory = JsonNodeFactory.instance;
		JsonFactory jsonFactory = new JsonFactory();
		ObjectNode node = jsonNodeFactory.objectNode();
		node.put("id", 1L);
		node.put("age", 18);
		node.put("birthday", new Date().getTime());
		ArrayNode arrayNode = jsonNodeFactory.arrayNode();
		arrayNode.add(node);
		ObjectMapper objectmapper = new ObjectMapper();
		StringWriter stringWriter = new StringWriter();
		JsonGenerator createGenerator = jsonFactory.createGenerator(stringWriter);
		objectmapper.writeTree(createGenerator, arrayNode);
//		System.out.println(stringWriter.toString());
		IOUtils.save("teacher", stringWriter.toString());
	}
	
	
	
	
	public static void MapToJson() throws Exception { 
		Teacher teacher = new Teacher();
		teacher.setId(1L);
		teacher.setName("jack");
		teacher.setAge(18);
		teacher.setBirthday(new Timestamp(new Date().getTime()));
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		mapper.configure(SerializationFeature.INDENT_OUTPUT,true);
		String writeValueAsString = mapper.writeValueAsString(teacher);
		IOUtils.save("teacher", writeValueAsString);
	}
	
	public static void JsonToMap() throws Exception { 
		Teacher teacher = new Teacher();
		teacher.setId(1L);
		teacher.setName("jack");
		teacher.setAge(18);
		teacher.setBirthday(new Timestamp(new Date().getTime()));
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		String read = IOUtils.read(".//teacher");
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Teacher readValue = mapper.readValue(read, new TypeReference<Teacher>() {});
		
		System.out.println(readValue);
	}
	
	public static void jsonnode() throws Exception {
		Teacher teacher = new Teacher();
		teacher.setId(1L);
		teacher.setName("hah");
		teacher.setAge(18);
		teacher.setBirthday(new Timestamp(new Date().getTime()));
		Student s1 = new Student();
		s1.setId(1L);
		s1.setName("yangyang");
		s1.setTeacher(teacher);
		Student s2 = new Student();
		s2.setId(2L);
		s2.setName("wangdaqing");
		s2.setTeacher(teacher);
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		teacher.setStudents(list);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		mapper.configure(SerializationFeature.INDENT_OUTPUT,true);
		String writeValueAsString = mapper.writeValueAsString(teacher);
		IOUtils.save("teacher", writeValueAsString);
		
	}
	
	
}
