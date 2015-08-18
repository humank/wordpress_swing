package com.odde.atdd.demo.adaptor;

import net.bican.wordpress.exceptions.InsufficientRightsException;
import net.bican.wordpress.exceptions.ObjectNotFoundException;
import redstone.xmlrpc.XmlRpcFault;

import java.net.MalformedURLException;

public interface RunnableWithXmlRpcExceptions {

    void run() throws InsufficientRightsException, ObjectNotFoundException, XmlRpcFault, MalformedURLException;
}
