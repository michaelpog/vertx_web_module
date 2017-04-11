import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

/**
 * Created by mpogrebinsky on 4/10/17.
 */
public class Multiplexer extends AbstractVerticle{

    @Override
    public void start() throws Exception {
        HttpServer server = getVertx().createHttpServer();
        Router router = Router.router(getVertx());
        router.route("/hello").handler(this::handleBidsRequest);
        router.route("/application.properties").handler(this::handleApplicationProperties);

        server.requestHandler(router::accept).listen(8080);

    }

    private void handleBidsRequest(RoutingContext routingContext){
        if(routingContext.request().method()== HttpMethod.GET ||
                routingContext.request().method()== HttpMethod.POST ){
            System.out.println("Got request on thread :"+Thread.currentThread().getName());
            routingContext.response().end("<html><body>All Good</html>");
        }
    }

    private void handleApplicationProperties(RoutingContext routingContext){
        routingContext.response().end("<html><body>proeprty1:value1;proeprty2:value2</body></html>");
    }
}
