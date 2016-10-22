package it.uniroma3.hw.sii.hbase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.KeyValue;

public class HBaseWrapper {
	
	// TODO test
	public static void main(String[] argv) throws IOException
	{
		try {
			delRecord("blogposts", "post2");
			addRecord("blogposts", "post2", "post", "author", "Gaetano");
			System.out.println(getOneRecord("blogposts", "post2"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// TODO remove static
	public static void addRecord(String tableName, String rowKey, String family,
			String qualifier, String value) throws Exception 
	{
		Configuration config = HBaseConfiguration.create();
		HTable hTable = new HTable(config, tableName);
		Put p = new Put(Bytes.toBytes(rowKey));
		p.add(Bytes.toBytes(family), Bytes.toBytes(qualifier),
				Bytes.toBytes(value));
		hTable.put(p);
		hTable.close();
		System.out.println("Added record " + tableName + " " + rowKey + " " + family + ":" + qualifier + " " + value);
	}

	// TODO remove static
	public static void delRecord (String tableName, String rowKey) throws IOException
	{
		Configuration config = HBaseConfiguration.create();
		HTable hTable = new HTable(config, tableName);
		Delete d = new Delete(Bytes.toBytes(rowKey));
		hTable.delete(d);
		hTable.close();
		System.out.println("Deleted record " + tableName + " " + rowKey);
	}

	// TODO remove static
	public static RowBean getOneRecord(String tableName, String rowKey) throws IOException
	{
		Configuration config = HBaseConfiguration.create();
		HTable hTable = new HTable(config, tableName);
		Get get = new Get(rowKey.getBytes());
		Result rs = hTable.get(get);
		Map<String, String> row = new HashMap<String, String>(); 		
		for(KeyValue kv : rs.raw()){
			row.put((new String(kv.getFamily())) + ":" + (new String(kv.getQualifier())), 
					(new String(kv.getValue())));
		}
		hTable.close();
		return new RowBean(row);
	}

}
