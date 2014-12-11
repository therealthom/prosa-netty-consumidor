package mx.redhat.fuse.prosa.netty.consumidor;

import java.io.IOException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

public class ParseISO implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception, IOException {

        Logger logger = LoggerFactory.getLogger("netty - consumidor");
        GenericPackager packager = new GenericPackager(getClass().getClassLoader().getResourceAsStream("basic.xml"));
        
        // Print Input Data
        String data = exchange.getIn().getBody(String.class);
        logger.info("DATA : " + data);

        // Create ISO Message
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);
        logger.info("Unpacking... ");
        isoMsg.unpack(data.getBytes());

        // Print the DE list
        String isoMsgString = logISOMsg(isoMsg);
        exchange.getOut().setBody(isoMsgString);
    }

    private static String logISOMsg(ISOMsg msg) {
        Logger logger = LoggerFactory.getLogger("netty - Consumidor");
        String cat = "";
        logger.info("----ISO MESSAGE-----");
        try {
            logger.info("  MTI : " + msg.getMTI());
            cat = msg.getMTI();
            for (int i = 1; i <= msg.getMaxField(); i++) {
                if (msg.hasField(i)) {
                    cat = cat + "|" + msg.getString(i);
                    logger.info("    Field-" + i + " : " + msg.getString(i));
                }
            }
        } catch (ISOException e) {
            e.printStackTrace();
        } finally {
            logger.info("--------------------");
        }
        return cat;
    }
}
