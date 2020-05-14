# Get Realtime Stock Qoute
A Java (Spring Boot) app to get stock price and qoute using Yahoo finance API.


## Getting started
In this project we have used Spring Boot, Thymeleaf, and data persistence.

Once you have your new Eclipse project, you can start up your web app by right-clicking on the `StocksApplication` class in the `org.optimum.stocks` package and selecting **Run As > Spring Boot Application**. If you see an exception stack trace in the console, something went wrong. The most common issue here is that your database isn't running or not connect. Make sure it's actually running.

Once the app starts up cleanly, point your browser at http://localhost:8080 and you should see the Stocks login page.

Have a look around at the code. You'll see that it's all in the `org.optimum.stocks` package (`src/main/java/org/optimum/stocks/`), with sub-packages for `models` and `controllers`, and a couple more below that. Our templates are stored in `src/main/resources/templates/` with the Tymeleaf extension of `.html` since they're "natural templates" (that is, templates that can still be displayed in a browser without any additional rendering engine).

## What to do
1. First, register a user or two for testing via the register link on the login page. (Notice how we've already implemented that one for you!)
2. The first is to implement quote lookup. You'll find the request handler for this action in `StockController.java`, and templates in `quote_form.html` and  `quote_display.html`. Take it from there, using the parameters already put in place for you in the template.
3. Once you enter the symbol it call the Yahoo finance API to get the Quote from the symbol. e.g: GOOG, APPL, AMZN etc
