package com.acc.prototype.service;

import com.acc.prototype.exception.ValueDoesntExistException;
import com.acc.prototype.exception.VariableNotEmptyException;
import com.acc.prototype.exception.VariableNotNullException;
import io.spring.guides.gs_producing_web_service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.*;


@Endpoint
public class PrototypeEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	@Autowired
	private Services service;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "PrototypeRequest")
	@ResponsePayload
	public PrototypeResponse getValueByKey(@RequestPayload PrototypeRequest prototypeRequest)
	{
		PrototypeResponse response = new PrototypeResponse();

		HashMap<String, String> map = service.map;

		if (prototypeRequest.getName()==null)
		{
			throw new VariableNotNullException();
		}
		else  if (prototypeRequest.getName().isEmpty())
		{
			throw new VariableNotEmptyException();
		}

		else  if(!map.containsKey(prototypeRequest.getName())){
			throw new ValueDoesntExistException()	;
		}

		response.setValue(map.get(prototypeRequest.getName()));

		return response;

	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "PrototypeRequestAll")
	@ResponsePayload
	public PrototypeResponseAll getAllValue(@RequestPayload PrototypeRequestAll prototypeRequestAll)
	{

		PrototypeResponseAll response = new PrototypeResponseAll();

		List<String> resultList=new ArrayList<>();

		  service.map.entrySet().forEach(index->resultList.add(index.getValue()));

		response.setValue(resultList);

		return response;



	}



	}




