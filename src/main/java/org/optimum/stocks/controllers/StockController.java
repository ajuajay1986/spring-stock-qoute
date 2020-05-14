package org.optimum.stocks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

/**
 */
@Controller
public class StockController extends AbstractController {

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public String quoteForm(Model model) {

        // pass data to template
        model.addAttribute("title", "Quote");
        model.addAttribute("quoteNavClass", "active");
        return "quote_form";
    }

    @RequestMapping(value = "/quote", method = RequestMethod.POST)
    public String quote(String symbol, Model model) {

        // TODO - Implement quote lookup
    	Stock stock = getStockPrice(symbol);
//    	stock.ger
        // pass data to template
    	model.addAttribute("stock_desc", symbol);
    	model.addAttribute("stock_price", stock.getQuote());
        model.addAttribute("title", "Quote");
        model.addAttribute("quoteNavClass", "active");

        return "quote_display";
    }


    private Stock getStockPrice(String quote) {
        try{
            /*Map mp = new HashMap();
            mp.put("GOOG","382");
            mp.put("APPL","657");
            mp.put("AMZN","783");
            return mp.get(quote)*/
            return YahooFinance.get(quote);
        }catch(IOException e) {
            e.printStackTrace();
            return new Stock(quote);
        }
    }

}
