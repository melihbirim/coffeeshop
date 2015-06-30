import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.net.httpserver.HttpServer;
import org.apache.log4j.Logger;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    private HttpServer httpServer = null;

    public static void main(String[] args) {

        new Main().start();
    }


    void start() {
        try {
            logger.info("[start] Starting KAHVECI HTTPServer...\n");
            if (httpServer == null) {
                httpServer = createHttpServer();

                httpServer.start();
                URI uri = getURI();
                logger.info("[start] GOTO : " + uri);
            } else {
                logger.debug("[start] HTTP Server already started, skip it [OK]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates and embedded jetty server
     *
     * @throws IOException
     */
    private static HttpServer createHttpServer() throws IOException {
        ResourceConfig resourceConfig = new PackagesResourceConfig("com.kahveci.rest");
        resourceConfig.getContainerResponseFilters().add(new SampleCrossOriginFilter());

        return HttpServerFactory.create(getURI(), resourceConfig);
    }

    private static class SampleCrossOriginFilter implements ContainerResponseFilter {
        @Override
        public ContainerResponse filter(ContainerRequest request,
                                        ContainerResponse response) {
            response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
            response.getHttpHeaders().add("Access-Control-Allow-Methods",
                    "GET, POST, DELETE, PUT");
            response.getHttpHeaders().add("Access-Control-Allow-Headers",
                    "Content-Type");
            return response;
        }
    }

    private static URI getURI() {
        final String baseUri = "http://localhost:" + (System.getenv("PORT") != null ? System.getenv("PORT") : "9998") + "/";
        return UriBuilder.fromUri(baseUri).build();
    }

    private static String getHostName() {
        /*try {
            hostName = InetAddress.getLocalHost().getCanonicalHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }*/
        return "localhost";
    }

}
