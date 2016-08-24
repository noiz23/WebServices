package cl.vmetrix.webservices.proxy.client;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.axis.AxisFault;

public class TestoperationWS {

	public static void main(String[] args) {
		try{
			System.out.println("Starting...");
			final File folder = new File("C:\\ODS_WS\\OperationsWS Source\\src\\test\\resources\\files");
			List list =	listFilesForFolder(folder);
			
			for( int i=0; i<list.size(); i++ ){
				ProxyServiceImplService w = new ProxyServiceImplServiceLocator();
				ProxyServiceImpl ws = new ProxyServiceImplServiceSoapBindingStub(new URL(w.getProxyServiceImplPortAddress()), w);
				
				String fileName = (String) list.get(i);
				
				Path path = Paths.get(fileName);
				System.out.println( "Reading File " + i + " " + path.getFileName() );
	
				String fileContent = new String(Files.readAllBytes(path),"UTF-8");
			
				System.out.println( "Sending message " + i + " " + path.getFileName()  );
				
				System.out.println("Content: "+ fileContent);
				
				boolean result = ws.processMessage("operation", 2, fileContent);
				
				if (result)
					System.out.println( "Message " + i + " enviada con exito " + path.getFileName()  );
				else 
					System.out.println( "Message " + i + " no enviada" );
				
			}
	
			
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public static List listFilesForFolder(final File folder) {
	    List list = new ArrayList();
		
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            list.add( listFilesForFolder(fileEntry) );
	        } else {
	            list.add(fileEntry.getPath());
	        }
	    }
		
		return list;
	}
}
