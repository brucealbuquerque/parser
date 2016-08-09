package jsoupweb.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author bruce
 */
@Named
@RequestScoped
public class App implements Serializable {

    @Inject
    private Parser parser;
    private String url;

    List<String> lista;
    List<String> links;
   // List<String> divs;

    public App() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getLista() throws IOException {
        return lista;
    }

    public List<String> getLinks() {
        return links;
    }

    public void processar() throws IOException {
        if (url != null) {
            lista = parser.get(url);
        }
    }
}
