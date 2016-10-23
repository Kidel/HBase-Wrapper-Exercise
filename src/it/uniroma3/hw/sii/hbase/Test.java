package it.uniroma3.hw.sii.hbase;

import java.io.IOException;

public class Test {
	public static void main(String[] argv) throws IOException
	{
		HBaseWrapper hw = new HBaseWrapper();
		try {
			hw.delRecord("blogposts", "post2");
			hw.addRecord("blogposts", "post2", "post", "author", "Gaetano");
			System.out.println(hw.getOneRecord("blogposts", "post2"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
