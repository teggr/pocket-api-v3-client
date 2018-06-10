package com.robintegg.pocket.web;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.robintegg.pocket.data.PocketData;

public class YamlView {

	public static String of(PocketData pocketData) throws Exception {
		
		YAMLMapper mapper = new YAMLMapper();
		ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
		
		return writer.writeValueAsString(pocketData);
		
	}

	
	
}
