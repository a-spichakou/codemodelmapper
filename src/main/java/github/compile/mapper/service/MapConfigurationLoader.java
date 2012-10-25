package github.compile.mapper.service;

import java.io.InputStream;

import com.thoughtworks.xstream.XStream;

import github.compile.mapper.mapping.MappingDefinitions;

public class MapConfigurationLoader {
	public MappingDefinitions load(InputStream stream)
	{
		final XStream xstream = new XStream();
		
		final MappingDefinitions fromXML = (MappingDefinitions)xstream.fromXML(stream);
		return fromXML;
	}

}
