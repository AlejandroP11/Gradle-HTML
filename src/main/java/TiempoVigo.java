import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TiempoVigo {
    public static void main(String[] args) {
        org.jsoup.nodes.Document docSOU = null;
        try{
            docSOU= Jsoup.connect("http://www.aemet.es/es/eltiempo/prediccion/municipios/vigo-id36057").get();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(docSOU.toString());
        //comienza jdom
        SAXBuilder builder = new SAXBuilder();
        File xml = new File("localidad_36057.xml");
        org.jdom2.Document docJDOM = null;
        try {
            docJDOM = builder.build(docSOU.toString());
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = docJDOM.getRootElement();
        System.out.println(root.getName());
        List<Element> prediccion = root.getChildren("prediccion");
        List<Element> dias=root.getChild("prediccion").getChildren("dia");
        List<Element> tMax=root.getChild("prediccion").getChild("dia").getChild("temperatura").getChildren();
        //System.out.println("Localidad: "+list.get(0).getContent());
        System.out.println(tMax.toString());

/*        for (int i = 0; i < list.size(); i++) {

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
        }*/
    }
}
