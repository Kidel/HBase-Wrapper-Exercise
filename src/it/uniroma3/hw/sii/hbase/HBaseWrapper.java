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
import org.apache.hadoop.hbase.KeyValue;

public class HBaseWrapper {
	
	private Configuration config = HBaseConfiguration.create();
	
	public void addRecord(String tableName, String rowKey, String family,
			String qualifier, String value) throws Exception 
	{
		HTable hTable = new HTable(config, tableName);
		Put p = new Put(rowKey.getBytes());
		p.add(family.getBytes(), qualifier.getBytes(),
				value.getBytes());
		hTable.put(p);
		hTable.close();
		System.out.println("Added record " + tableName + " " + rowKey + " " + family + ":" + qualifier + " " + value);
	}

	public void delRecord (String tableName, String rowKey) throws IOException
	{
		HTable hTable = new HTable(config, tableName);
		Delete d = new Delete(rowKey.getBytes());
		hTable.delete(d);
		hTable.close();
		System.out.println("Deleted record " + tableName + " " + rowKey + " (if it ever existed)");
	}

	public RowBean getOneRecord(String tableName, String rowKey) throws IOException
	{
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
