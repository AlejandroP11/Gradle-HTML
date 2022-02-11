import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TiempoVigo {
    public static void main(String[] args) {
        //Ejemplo del JDOM2 con el tutorial online.
        SAXBuilder builder = new SAXBuilder();
        File xml = new File("concesionario.xml");
        Document document = null;
        try {
            document = builder.build(xml);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        System.out.println(root.getName());
        List<Element> list = root.getChildren("coches");

        for (int i = 0; i < list.size(); i++) {

            Element coche = list.get(i);

            List<Element> valores_coche = coche.getChildren();

        }
        System.out.println("Matricula\tMarca\tPrecio");

        for (int i = 0; i < list.size(); i++) {

            Element coche = list.get(i);

            List<Element> valores_coche = coche.getChildren();


            for (int j = 0; j < valores_coche.size(); j++) {

                Element campo = valores_coche.get(j);

                String matricula = campo.getAttributeValue("matricula");
                String marca = campo.getChildTextTrim("marca");
                String precio = campo.getChildTextTrim("precio");

                System.out.println(matricula + "\t\t" + marca + "\t" + precio);

            }
        }
    }
}
