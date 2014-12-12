package Plugin;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class testPluginFilter {
	File f = new File("test.class");
	String s1 = "test.class";
	String s2 = "testfail.class";
	String s3 = "test";
	PluginFilter pf = new PluginFilter();
	
	@Test
	public void testAccept() {
		assertTrue(pf.accept(f, s1));
		assertFalse(pf.accept(f, s2));
		assertFalse(pf.accept(f, s3));
	}

	@Test
	public void testFileEndIsClass() {
		assertTrue(pf.fileExtensionIsClass(s1));
		assertTrue(pf.fileExtensionIsClass(s2));
		assertFalse(pf.fileExtensionIsClass(s3));
	}
	
	Class<?> c = getClass();
	
	
	@Test
	public void testclassInPluginPackage() {
		assertFalse(pf.classInPluginsPackage(c));
	}
	
	@Test
	public void testInheritFromPlugin(){
		assertFalse(pf.inheritFromPlugin(c));
	}
	

	@Test
	public void testclassHasParameterLessCons(){
		assertTrue(pf.classHasParameterLessConstructor(c));
	}
}
