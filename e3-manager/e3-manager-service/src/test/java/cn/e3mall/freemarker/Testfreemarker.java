package cn.e3mall.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Data;

import cn.e3mall.pojo.Student;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class Testfreemarker {

	@Test
	public void testHello() throws Exception {
		// 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
		// 第二步：设置模板文件所在的路径。
		configuration.setDirectoryForTemplateLoading(
				new File("D:/Java就业班/e3/e3-manager/e3-manager-service/src/main/resources/conf"));
		// 第三步：设置模板文件使用的字符集。一般就是utf-8.
		configuration.setDefaultEncoding("utf-8");
		// 第四步：加载一个模板，创建一个模板对象。
		Template template = configuration.getTemplate("hello2.ftl");
		// 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
		Map dataModel = new HashMap<>();
		dataModel.put("hello", "好人");
		Student student = new Student("huoakang", 25, "北京");
		dataModel.put("student", student);
		List<Student> stuList = new ArrayList<>();
		stuList.add(new Student("huoakang", 25, "北京"));
		stuList.add(new Student("huo", 23, "北京"));
		dataModel.put("stuList", stuList);
		// 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
		dataModel.put("date", new Date());
		Writer writer = new FileWriter("C:/Users/kangkang/Desktop/first/hello.html");
		// 第七步：调用模板对象的process方法输出文件。
		template.process(dataModel, writer);
		// 第八步：关闭流。
		writer.close();
	}

}
