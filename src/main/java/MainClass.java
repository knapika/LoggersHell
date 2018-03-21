import com.external.PaymentsService;
import com.internal.DiscountCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class MainClass {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(MainClass.class);
        logger.info("Hello!");
        BigDecimal ticketPrice = new BigDecimal(0);
        int clientAge = 0;
        int clientId = 0;
        int companyId = 0;
        if(args.length > 0) {

            ticketPrice = new BigDecimal(args[0]);
            clientAge = Integer.valueOf(args[1]);
            clientId = Integer.valueOf(args[2]);
            companyId = Integer.valueOf(args[3]);

            DiscountCalculator discountCalculator = new DiscountCalculator();
            BigDecimal ticketPriceAfterDiscount = discountCalculator.calculateDiscount(ticketPrice, clientAge);

            PaymentsService paymentsService = new PaymentsService();
            paymentsService.makePayment(clientId, companyId, ticketPrice);
            logger.info("It works!");
        }

    }


}
