package za.ac.tut4life.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import za.ac.tut4life.util.LoggerUtil;

import java.io.IOException;
import java.util.logging.Logger;

@Component
@Order(1)
public class TransactionFilter implements Filter {

    LoggerUtil LOG = new LoggerUtil();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
            long start = System.currentTimeMillis();
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            LOG.info("Initialising transaction for req : {}",req.getRequestURI());
            filterChain.doFilter(servletRequest,servletResponse);
            LOG.info("Committing transaction for req : {}",req.getRequestURI());
            long elapsed= System.currentTimeMillis() - start;
            LOG.info("transaction elapsed time "+elapsed +" ms");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
