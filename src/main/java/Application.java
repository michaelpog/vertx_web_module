import io.vertx.core.Vertx;

/**
 * Created by mpogrebinsky on 4/10/17.
 */
public class Application {
    public static void main(String [] args){
        Vertx vertx = Vertx.vertx();
        int numberOfInstnaces  = 4;

        for(int i =0 ; i<numberOfInstnaces ; i++) {
            vertx.deployVerticle(new Multiplexer());
        }
    }
}
