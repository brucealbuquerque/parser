package jsoupweb.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

/**
 *
 * @author bruce
 */
@Stateless
public class Parser {

    public List<String> get(String url) throws IOException {

        List<String> lista = new ArrayList<>();

        Document doc = Jsoup.connect(url).get();

        lista.add(getDoctype(doc));
        lista.add(getLinks(doc).toString());
        lista.add(getDiv(doc));

        return lista;
    }

    public String getDoctype(Document doc) {
        //pegando os nós da página
        List<Node> nods = doc.childNodes();
        for (Node node : nods) {
            if (node instanceof DocumentType) {
                DocumentType dt = (DocumentType) node;
                return dt.toString();
                //System.out.println(dt.toString());
            }
        }
        return null;
    }

    public List<Element> getLinks(Document doc) {

        //List<Node> links = new ArrayList<>();
        Elements links = doc.select("a[href]");
        for (Element elemento : links) {
            if (elemento.attr("a") != null) {
                return (List<Element>) elemento;
            }
        }

        return null;

    }

    public String getDiv(Document doc) {
        Elements elementos = doc.select("div");
        for (Element elemento : elementos) {
            return elemento.toString();
        }
        return null;
    }
}
