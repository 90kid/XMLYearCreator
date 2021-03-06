import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

class XMLMaker {
    XMLMaker(int whatYear) throws Exception {
        makeXML(whatYear);
    }

    private void makeXML(int whatYear) throws Exception {
        XMLInterior xmlInterior = new XMLInterior(whatYear);
        Document document = xmlInterior.newDocumentXML();

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource src = new DOMSource(document);

        String pathName = "./XMLyears"; // zmienic lokalizacje !!!!!!!!!
        checkDirectory(pathName);

        StreamResult streamResult = new StreamResult(new File(pathName + "/" + whatYear + ".xml"));
        transformer.transform(src, streamResult);
    }

    private void checkDirectory(String pathName) {
        try {
            File directoryXML = new File(pathName);
            if (!directoryXML.exists())
                if (!directoryXML.mkdir())
                    throw new Exception("Cannot create directory!");
            if (!directoryXML.isDirectory())
                System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}